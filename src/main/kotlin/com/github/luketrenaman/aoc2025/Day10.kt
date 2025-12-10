package com.github.luketrenaman.aoc2025

import java.io.File
import java.util.LinkedList
import java.util.Queue

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
    data class Attempt(val state: Long, val actions: Long)
    data class AttemptWithJoltage(val state: List<Int>, val actions: Long)
    fun indicesToBinarystring(indices: List<Long>, size: Int)
        = indices.sumOf{pow(2, size-it-1)}

    fun part1(input: File): Long {
        var output = 0L
        input.forEachLine { line ->
            val input = line.split(" ")
            val goalStateString = input[0].filter{it != '[' && it != ']'}.map{
                if(it=='#') '1' else '0'
            }.joinToString ("")
            val n = goalStateString.length

            val startState = 0L
            val goalState = goalStateString.toLong(2)

            val transforms = input.subList(1, input.size - 1).map {
                transform -> transform.filter{it != '(' && it != ')'}.split(",").map{it.toLong()}
            }.map{indicesToBinarystring(it, n)}
            val joltages = input[input.size - 1].filter{it != '{' && it != '}'}.split(",").map{it.toLong()}
            val visited = mutableSetOf<Long>()
            val states: Queue<Attempt> = LinkedList()
            states.add(Attempt(startState, 0))
            visited.add(startState)
            while(states.peek().state != goalState){
                val toProcess = states.remove()
                for(transform in transforms){
                    val newState = toProcess.state xor transform
                    if(newState !in visited){
                        visited.add(newState)
                        states.add(Attempt(newState, toProcess.actions+1))
                    }
                }
            }
            output += states.peek().actions
        }
        return output
    }
    fun part2(input: File): Long {
        var output = 0L
        input.forEachLine { line ->
            val input = line.split(" ")
            val goalStateString = input[0].filter{it != '[' && it != ']'}.map{
                if(it=='#') 1 else 0
            }
            val n = goalStateString.size

            val transforms = input.subList(1, input.size - 1).map {
                    transform -> transform.filter{it != '(' && it != ')'}.split(",").map{it.toLong()}
            }
            val joltages = input[input.size - 1].filter{it != '{' && it != '}'}.split(",").map{it.toLong()}

            val visited = mutableSetOf<List<Int>>()
            val attempts: Queue<AttemptWithJoltage> = LinkedList()
            val firstState = List(n) { 0 }
            val firstAttempt = AttemptWithJoltage( List(n) { 0 }, 0)

            attempts.add(firstAttempt)
            visited.add(firstState)
            while(attempts.peek().state != joltages){
                val toProcess = attempts.remove()
                for(transform in transforms){
                    // transformSimple will
                    val newJoltages = toProcess.state.toMutableList()
                    for(index in transform){
                        newJoltages[index.toInt()]++
                    }
                    // If we haven't been here, and the joltage state is still valid, continue
                    if(newJoltages !in visited && newJoltages.zip(joltages).all { it.first <= it.second }){
                        visited.add(newJoltages)
                        attempts.add(AttemptWithJoltage(newJoltages, toProcess.actions+1))
                    }
                }
            }
            output += attempts.peek().actions
        }
        return output
    }
}

