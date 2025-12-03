#!/usr/bin/env kotlin

import java.io.File

// Create mutable lists to hold the inputs (equivalent to vector<int>)
var current = 50
val max = 100
val min = 0
var pwd = 0
// Read the file line by line
File("input.txt").forEachLine { line ->
    val multiplier = if (line[0] == 'L') -1 else 1
    val diff = line.drop(1).toInt()
    current = (current + max + multiplier * diff) % max
    if (current == 0) pwd++
}
println(pwd)