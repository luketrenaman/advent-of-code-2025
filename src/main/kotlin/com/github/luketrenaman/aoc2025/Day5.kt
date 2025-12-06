package com.github.luketrenaman.aoc2025

import java.io.File

class Day5 {
    fun part1(input: File): Int {
        val ranges = mutableListOf<List<String>>()
        val ids = mutableListOf<String>()
        var blank = false
        input.forEachLine { line ->
            if(blank){
                ids.add(line)
                return@forEachLine
            }
            if(line.isEmpty()){
                blank = true
                return@forEachLine
            }
            ranges.add(line.split('-'))
        }
        var fresh = 0
        for(id in ids){
            if(ranges.any { range ->
                ((id >= range[0] && id.length == range[0].length) || id.length > range[0].length) &&
                        ((id <= range[1] && id.length == range[1].length) || id.length < range[1].length)
            }) {
                fresh++
            }
        }

        return fresh
    }
    fun part2(input: File): Long {
        fun rangeSize(range: List<Long>): Long = range[1] - range[0] + 1

        val ranges = mutableListOf<List<Long>>()
        val processedRanges = mutableListOf<MutableList<Long>>()
        val ids = mutableListOf<String>()
        var blank = false
        input.forEachLine { line ->
            if(blank){
                ids.add(line)
                return@forEachLine
            }
            if(line.isEmpty()){
                blank = true
                return@forEachLine
            }
            ranges.add(line.split('-').map{it.toLong()})
        }
        var fresh = 0L
        for(range in ranges){
            val containedInRanges = mutableListOf<MutableList<Long>>()
            val replacement = range.toMutableList()
            var oldSize = 0L
            for(pr in processedRanges){
                if(
                    (range[0] in pr[0]..pr[1] || range[1] in pr[0]..pr[1]) ||
                    (pr[0] in range[0]..range[1] || pr[1] in range[0]..range[1])
                ){
                    containedInRanges.add(pr)
                    oldSize += rangeSize(pr)
                    replacement[0] = kotlin.math.min(replacement[0], pr[0])
                    replacement[1] = kotlin.math.max(replacement[1], pr[1])
                }
            }
            if(containedInRanges.isNotEmpty()){
                processedRanges.removeAll(containedInRanges)
            }
            fresh += rangeSize(replacement) - oldSize
            processedRanges.add(replacement)
        }

        return fresh
    }
}

