#!/usr/bin/env kotlin

import java.io.File
import kotlin.math.max
import kotlin.math.min

// Create mutable lists to hold the inputs (equivalent to vector<int>)

fun rangeSize(range: List<Long>): Long = range[1] - range[0] + 1

var ranges = mutableListOf<List<Long>>()
var processedRanges = mutableListOf<MutableList<Long>>()
var ids = mutableListOf<String>()
var blank = false
File("example.txt").forEachLine { line ->
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
// We can determine the number of items in a range as UB - LB + 1
// We need to make sure that ranges are non-overlapping and we cannot check via iteration if this is the case
// We also aren't able to use a set to precompute, that would take too much memory

// There is only 173 ranges so likely no need for a binary tree for range lookup
// Can likely check for overlap with any ranges by creating a NEW ranges list and rectifying that overlap when adding
// For example if our rangelist has 3-5, we note that this has 3 elements provided
// If we attempt to add the range 4-6, we would check
// - Is our LB contained in any range
// - Is our UB contained in any range
// If so we will modify that range to contain our new LB and UB, and add the range difference to our freshlist
// So 4-6's LB is 4, and is contained in 3-5
// We combine the ranges with min(LB1, LB2), max(UB1, UB2) and are left with 3-6
// We compare size(old) and size(new) and see a difference of 1, add that

// A range can contain multiple ranges for example having 1-5 6-9 and then adding 0-10

for(range in ranges){
    var containedInRanges = mutableListOf<MutableList<Long>>()
    var replacement = range.toMutableList()
    var oldSize = 0L
    for(pr in processedRanges){
        if(
            (range[0] in pr[0]..pr[1] || range[1] in pr[0]..pr[1]) ||
            (pr[0] in range[0]..range[1] || pr[1] in range[0]..range[1])
       ){
            containedInRanges.add(pr)
            oldSize += rangeSize(pr)
            replacement[0] = min(replacement[0], pr[0])
            replacement[1] = max(replacement[1], pr[1])
        }
    }
    if(containedInRanges.isNotEmpty()){
        processedRanges.removeAll(containedInRanges)
    }
    fresh += rangeSize(replacement) - oldSize
    processedRanges.add(replacement)
}

println(fresh)
