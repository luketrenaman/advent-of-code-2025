package com.github.luketrenaman.aoc2025

import java.io.File

class Day6 {
    fun part1(input: File): Long {
        val input = input.readLines().map {
            it.trim().split("\\s+".toRegex())
        }.toMutableList()
        val operators = input.removeLast()
        val numbers = input.map { line ->
            line.map {
                it.toLong()
            }
        }
        var ans = 0L
        for (i in operators.indices) {
            // iterate through columns using operator as the row selector
            val operator = operators[i]
            var result = 0L
            if (operator == "+") {
                for (j in numbers.indices) {
                    result += numbers[j][i]
                }
            } else if (operator == "*") {
                result = 1L
                for (j in numbers.indices) {
                    result *= numbers[j][i]
                }
            }
            ans += result
        }
        return ans
    }
    fun part2(input: File): Long{
        val input = input.readLines().map{ it }.toMutableList()
        val operators = input.removeLast().split("\\s+".toRegex())
        var ans = 0L
        var currentOperator = 0
        var operator = operators[0]
        var result = if(operator == "*") 1L else 0L
        var seq = ""
        for(i in input[0].indices){
            // iterate through columns using operator as the row selector
            if(currentOperator > operators.size){
                return ans
            }
            for(j in input.indices){
                // operate through columns
                seq += input[j][i]
            }
            if(seq.trim().isEmpty()){
                //println("Result was ${result}")
                ans += result
                currentOperator++
                operator = operators[currentOperator]
                result = if(operator == "*") 1L else 0L
            } else {
                val num = seq.trim().toLong()
                //println("Performing ${result} ${operator} ${num}")
                result = if(operator == "*") result * num else result + num
                seq = ""
            }
        }
        return ans
    }
}