package com.github.luketrenaman.aoc2025

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

class Day9 {
    data class Point(val x: Long, val y: Long)
    data class Rectangle(val min: Point, val max: Point, val area: Long)
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

        // Rectangles are now only valid if they lie within the perimeter determined by the provided list of points
        // We are still picking the same rectangles as shown in part1
        // If we had some method for determining whether a rectangle is "in" or "out" we could use that
        // I hope its not convex hull
        // What if we just checked, for each coordinate in our guess, whether it was within some other points
        // We could use traversal or we could do a naive approach of just seeing if there are orthongonally aligned rects
        val boundary = mutableSetOf<Point>()
        val xToY = mutableMapOf<Long, MutableList<Long>>()
        val yToX = mutableMapOf<Long, MutableList<Long>>()
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
                    boundary.add(Point(x,y))
                    if(!xToY.contains(x)){xToY[x] = mutableListOf()}
                    if(!yToX.contains(y)){yToX[y] = mutableListOf()}
                    xToY[x]!!.add(y)
                    yToX[y]!!.add(x)
                }
            }
        }
        //println(boundaryMap)

        fun isInBoundary(p: Point) = boundary.contains(p) ||
        (
            xToY[p.x]?.find { it >= p.y } != null &&
            xToY[p.x]?.find { it <= p.y } != null &&
            yToX[p.y]?.find { it >= p.x } != null &&
            yToX[p.y]?.find { it <= p.x } != null
        )
        fun isInBoundaryWithSideEffects(p: Point): Boolean{
            val isIn = isInBoundary(p)
            if(isIn){
                boundary.add(p)
            }
            return isIn
        }
        fun checkIsSafe(bl: Point, tr: Point): Boolean{
            for(x in bl.x..tr.x){
                if(!isInBoundaryWithSideEffects(Point(x, bl.y))) return false
                if(!isInBoundaryWithSideEffects(Point(x, tr.y))) return false
            }
            for(y in bl.y..tr.y){
                if(!isInBoundaryWithSideEffects(Point(bl.x, y))) return false
                if(!isInBoundaryWithSideEffects(Point(tr.x, y))) return false
            }
            return true
        }
        // Print grid if not exactly 496 coordinates
        var largest = 0L
        val rectangles = mutableListOf<Rectangle>()
        for (p1 in points) {
            for (p2 in points) {
                val minX = min(p1.x, p2.x)
                val minY = min(p1.y, p2.y)
                val maxX = max(p1.x, p2.x)
                val maxY = max(p1.y, p2.y)
                val l = abs(maxX - minX) + 1
                val w = abs(maxY - minY) + 1
                rectangles.add(Rectangle(Point(minX, minY), Point(maxX, maxY), l*w))
            }
        }
        var progress = 0
        for(rectangle in rectangles.sortedByDescending{ it.area }){
            if(progress % 1000 == 0) println("${progress}/${rectangles.size}")
            progress++
            if(checkIsSafe(rectangle.min, rectangle.max)){
                return rectangle.area
            }
        }
        return 0L
        //return rectangles.sortedByDescending{ it.area }.find{checkIsSafe(it.min, it.max)}!!.area
    }
}
