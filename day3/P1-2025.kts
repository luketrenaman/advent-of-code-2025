#!/usr/bin/env kotlin

import java.io.File

var answer = 0
File("input.txt").forEachLine { line ->
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
println(answer)
