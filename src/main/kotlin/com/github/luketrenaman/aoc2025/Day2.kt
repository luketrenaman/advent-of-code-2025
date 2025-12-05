package com.github.luketrenaman.aoc2025

import java.io.File

class Day2 {
    fun part1(input: File): Long {
        var sum = 0L
        input.forEachLine { line ->
            val ranges = line
                .split(',')
                .map{ range -> range.split('-')
                    .map{str -> str.toLong()}
                }.sortedBy { range -> range[0] }

            // Sort the ranges in ascending order by range start
            val ids = (1..100000).map {
                // dirty way to generate 11 22 33 44 55
                    i -> (i.toString() + i.toString()).toLong()
            }
            var nextIdToCheck = 0
            for (range in ranges) {
                while (ids[nextIdToCheck] < range[0]){
                    nextIdToCheck++
                }
                while (ids[nextIdToCheck] >= range[0] && ids[nextIdToCheck] <= range[1]){
                    sum += ids[nextIdToCheck]
                    nextIdToCheck++
                }
                // Implicitly continues to next range
            }
        }
        return sum
    }
    fun part2(input: File): Long {
        val ranges = input.readLines().first()
            .split(',')
            .map{ range -> range.split('-')
                .map{str -> str.toLong()}
            }.sortedBy { range -> range[0] }
        val ids = mutableSetOf<Long>()

        for(j in 2..6) {
            val max = 100000
            for(i in 1..max) {
                if(kotlin.math.log10(i.toDouble()) * j > 10){
                    break
                }
                ids.add(i.toString().repeat(j).toLong())
            }
        }
// We used a set to filter out duplicates, but now we need to iterate!
        val idList = ids.toList().sorted()

        var sum = 0L;
        var nextIdToCheck = 0
        for (range in ranges) {
            while (idList[nextIdToCheck] < range[0]){
                nextIdToCheck++;
            }
            while (idList[nextIdToCheck] >= range[0] && idList[nextIdToCheck] <= range[1]){
                sum += idList[nextIdToCheck];
                nextIdToCheck++;
            }
            // Implicitly continues to next range
        }
        return sum
    }
}

