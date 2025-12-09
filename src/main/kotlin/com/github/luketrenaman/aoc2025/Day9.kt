package com.github.luketrenaman.aoc2025

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

class Day9 {
    data class Point(val x: Long, val y: Long)

    fun part1(input: File): Long {
        val points = input.readLines().map { line ->
            val (x, y) = line.split(",").map { it.toLong() }
            Point(x, y)
        }
        var largest = 0L
        for (p1 in points) {
            for (p2 in points) {
                val l = abs(p1.x - p2.x) + 1
                val w = abs(p1.y - p2.y) + 1
                largest = max(largest, l * w)
            }
        }
        return largest
    }

    fun part2(input: File): Long {
        val points = input.readLines().map { line ->
            val (x, y) = line.split(",").map { it.toLong() }
            Point(x, y)
        }

        println("Number of coordinates: ${points.size}")

        // Rectangles are now only valid if they lie within the perimeter determined by the provided list of points
        // We are still picking the same rectangles as shown in part1
        // If we had some method for determining whether a rectangle is "in" or "out" we could use that
        // I hope its not convex hull
        // What if we just checked, for each coordinate in our guess, whether it was within some other points
        // We could use traversal or we could do a naive approach of just seeing if there are orthongonally aligned rects
        val safePoints = mutableSetOf<Point>()
        for(i in points.indices){
            val next = (i+1) % points.size
            val p1 = points[i]
            val p2 = points[next]
            val minX = min(p1.x, p2.x)
            val minY = min(p1.y, p2.y)
            val maxX = max(p1.x, p2.x)
            val maxY = max(p1.y, p2.y)
            for(x in minX..maxX){
                for(y in minY..maxY){
                    safePoints.add(Point(x,y))
                }
            }
        }

        // Print grid if not exactly 496 coordinates
        if (points.size != 496) {
            val minX = safePoints.minOf { it.x }
            val maxX = safePoints.maxOf { it.x }
            val minY = safePoints.minOf { it.y }
            val maxY = safePoints.maxOf { it.y }

            println("SafePoints Grid (${maxX - minX + 1} x ${maxY - minY + 1}):")
            println("X range: $minX to $maxX")
            println("Y range: $minY to $maxY")
            println("Total safe points: ${safePoints.size}")
            println()

            for (y in minY..maxY) {
                for (x in minX..maxX) {
                    if (safePoints.contains(Point(x, y))) {
                        print("#")
                    } else {
                        print(".")
                    }
                }
                println()
            }
            println()
        }

        var largest = 0L
        for (p1 in points) {
            for (p2 in points) {
                val minX = min(p1.x, p2.x)
                val minY = min(p1.y, p2.y)
                val maxX = max(p1.x, p2.x)
                val maxY = max(p1.y, p2.y)
                if (
                    safePoints.contains(Point(minX, minY)) &&
                    safePoints.contains(Point(maxX, minY)) &&
                    safePoints.contains(Point(minX, maxY)) &&
                    safePoints.contains(Point(maxX, maxY))
                ) {
                    val l = abs(p1.x - p2.x) + 1
                    val w = abs(p1.y - p2.y) + 1
                    largest = max(largest, l * w)
                }
                // if the bottom left is
            }
        }
        // 93214 * 1231 too low try also
        // 93215 * 1232 = 114840880 too low
        // 93215 * 1231 = 114747665
        // 93214 * 1232 = 114839648
        return largest
    }
}
