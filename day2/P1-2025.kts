#!/usr/bin/env kotlin

import java.io.File

File("input.txt").forEachLine { line ->
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
    println(ids.size)
    var sum = 0L;
    var nextIdToCheck = 0
    for (range in ranges) {
        while (ids[nextIdToCheck] < range[0]){
            nextIdToCheck++;
        }
        while (ids[nextIdToCheck] >= range[0] && ids[nextIdToCheck] <= range[1]){
            sum += ids[nextIdToCheck];
            nextIdToCheck++;
        }
        // Implicitly continues to next range
    }
    println(sum)
}