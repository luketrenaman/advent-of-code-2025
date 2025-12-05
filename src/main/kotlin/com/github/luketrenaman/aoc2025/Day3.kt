package com.github.luketrenaman.aoc2025

import java.io.File

class Day3 {
    fun part1(input: File): Long {
        var answer = 0L
        input.forEachLine { line ->
            var chars = line.trim().split("").filter{x -> x != ""}.map{x -> x.toInt()}
            var first = 0
            for (i in 0 until chars.size-1){
                if(chars[i] > chars[first]){
                    first = i
                }
            }
            var second = first+1
            for(i in first+1 until chars.size){
                if(chars[i] > chars[second]){
                    second = i
                }
            }
            answer += chars[first] * 10 + chars[second]
        }
        return answer
    }
    fun part2(input: File): Long {
        var answer = 0L
        input.forEachLine { line ->
            var chars = line.trim().split("").filter{x -> x != ""}.map{x -> x.toInt()}
            var lastIndex = 0
            var mult = 100000000000L
            // 987654321111
            for(j in 11 downTo  0) {
                for (i in lastIndex until chars.size - j) {
                    if (chars[i] > chars[lastIndex]) {
                        lastIndex = i
                    }
                }
                answer += chars[lastIndex] * mult
                lastIndex++
                mult /= 10
            }
        }
        return answer
    }
}

