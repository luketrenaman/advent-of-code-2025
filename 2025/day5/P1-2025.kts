#!/usr/bin/env kotlin

import java.io.File

// Create mutable lists to hold the inputs (equivalent to vector<int>)
var ranges = mutableListOf<List<String>>()
var ids = mutableListOf<String>()
var blank = false
File("input.txt").forEachLine { line ->
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

println(fresh)
