package com.github.luketrenaman.aoc2025

import java.io.File

class Day10 {
    fun pow(base: Long, exp: Long): Long {
        require(exp >= 0) { "Exponent must be non-negative" }
        var result = 1L
        var b = base
        var e = exp

        while (e > 0) {
            if (e and 1L == 1L) result *= b
            b *= b
            e = e shr 1
        }

        return result
    }
    fun logBin(l: Long, n: Int){
        println(l.toString(2).padStart(n, '0'))
    }
    fun logBin(l: List<Long>, n: Int){
        println(l.map{it.toString(2).padStart(n, '0')})
    }
    fun indicesToBinarystring(indices: List<Long>, size: Int)
        = indices.sumOf{pow(2, size-it-1)}

    fun part1(input: File): Long {
        input.forEachLine { line ->
            val input = line.split(" ")
            val goalStateString = input[0].filter{it != '[' && it != ']'}.map{
                if(it=='#') '1' else '0'
            }.joinToString ("")
            val n = goalStateString.length

            val startState = 0L
            val goalState = goalStateString.toLong(2)

            val edges = input.subList(1, input.size - 1).map {
                edge -> edge.filter{it != '(' && it != ')'}.split(",").map{it.toLong()}
            }.map{indicesToBinarystring(it, n)}
            val joltages = input[input.size - 1].filter{it != '{' && it != '}'}.split(",")

            
        }
        return -1L
    }
    fun part2(input: File): Long {
        return -1L
    }
}

