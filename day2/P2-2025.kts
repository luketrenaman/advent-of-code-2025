#!/usr/bin/env kotlin

import java.io.File
import kotlin.math.log10

val ranges = File("input.txt").readLines().first()
    .split(',')
    .map{ range -> range.split('-')
        .map{str -> str.toULong()}
    }.sortedBy { range -> range[0] }
val ids = mutableSetOf<ULong>();

for(j in 2..6) {
    val max = 100000
    for(i in 1..max) {
        if(log10(i.toDouble()) * j > 10){
            break;
        }
        ids.add(i.toString().repeat(j).toULong())
    }
}
// We used a set to filter out duplicates, but now we need to iterate!
val idList = ids.toList().sorted()

var sum = 0UL;
var nextIdToCheck = 0
for (range in ranges) {
    while (idList[nextIdToCheck] < range[0]){
        nextIdToCheck++;
    }
    while (idList[nextIdToCheck] >= range[0] && idList[nextIdToCheck] <= range[1]){
        sum += idList[nextIdToCheck];
        nextIdToCheck++;
    }
    // Implicitly continues to next range
}
println(sum)