package templates

import java.io.File
import kotlin.math.abs

fun main() {
    // Create mutable lists to hold the inputs (equivalent to vector<int>)
    val l1 = mutableListOf<Int>()
    val l2 = mutableListOf<Int>()

    // Read the file line by line
    File("P1.txt").forEachLine { line ->
        if (line.isNotBlank()) {
            // Split the line by whitespace (regex handles multiple spaces/tabs)
            val parts = line.trim().split("\\s+".toRegex())

            // Add to lists
            l1.add(parts[0].toInt())
            l2.add(parts[1].toInt())
        }
    }

    // Sort the lists in ascending order
    l1.sort()
    l2.sort()

    // Calculate the total distance
    // 'zip' combines the two lists into pairs, 'sumOf' sums the results
    val total = l1.zip(l2).sumOf { (a, b) ->
        abs(a - b)
    }

    println(total)
}