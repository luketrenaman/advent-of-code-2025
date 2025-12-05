#!/usr/bin/env kotlin

import java.io.File

var answer = 0L
File("input.txt").forEachLine { line ->
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
println(answer)
