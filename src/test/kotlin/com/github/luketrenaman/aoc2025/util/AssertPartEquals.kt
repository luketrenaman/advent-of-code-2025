package com.github.luketrenaman.aoc2025.util

import java.io.File
import org.junit.jupiter.api.Assertions.assertEquals

fun assertPartEquals(
    expected: Int,
    name: String,
    location: String,
    partFn: (File) -> Int
) {
    val file = File("src/test/resources/$name/$location.txt")
    assertEquals(expected, partFn(file))
}

fun assertPartEquals(
    expected: Long,
    name: String,
    location: String,
    partFn: (File) -> Long
) {
    val file = File("src/test/resources/$name/$location.txt")
    assertEquals(expected, partFn(file))
}

fun assertPartEquals(
    expected: ULong,
    name: String,
    location: String,
    partFn: (File) -> ULong
) {
    val file = File("src/test/resources/$name/$location.txt")
    assertEquals(expected, partFn(file))
}

