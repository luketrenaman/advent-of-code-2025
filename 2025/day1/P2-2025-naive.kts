#!/usr/bin/env kotlin

import java.io.File

var current = 50
val max = 100
val min = 0
var pwd = 0
File("input.txt").forEachLine { line ->
    val multiplier = if (line[0] == 'L') -1 else 1
    val diff = line.drop(1).toInt()
    for(i in 1..diff) {
        current = (current + max + multiplier) % max
        if (current == 0) pwd++
    }
}
println(pwd)