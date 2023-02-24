fun main(args: Array<String>) {
    // Get the output from direct args of the main file or scan them if they were not passed
    val (janeArray, aliceArray) = parseArgs(args) ?: scanTwoArrays()
    val result = StampExchange(janeArray, aliceArray).output()

    // output the result in standard format
    println("{${result.first.joinToString(",")}}, {${result.second.joinToString(",")}}")
}

/**
 * ## The class responsible for the actual requirement
 * Take two inputs and [output] gives the outputs required
 *
 * > Usage
 * ```
 * val output = StampExchange(arr1, arr2).output()
 * ```
 */
class StampExchange(
    private val janeStamps: Array<Int>,
    private val aliceStamps: Array<Int>
) {

    /**
     * ### Expects two outputs, returns a list at the end
     * NOTE: Since [exchange] is being used twice, it's extracted as common code
     */
    private fun exchange(a: Array<Int>, b: Array<Int>): Array<Int> {
        val list = mutableListOf<Int>()
        for (stamp in a) {
            if (a.count { it == stamp } > 2 && (a.size > list.size) &&
                (!b.contains(stamp) || b.count { it == stamp } == 1)) {
                val janeRepeatedCount = a.count { it == stamp }
                val canRepeatCount = if (janeRepeatedCount % 2 == 0)
                    janeRepeatedCount / 2
                else
                    janeRepeatedCount % 2
                if (list.count { it == stamp } < canRepeatCount)
                    list.add(stamp)
            }
        }
        return list.toTypedArray()
    }

    /**
     * Returns the output
     */
    fun output() = Pair(
        exchange(aliceStamps, janeStamps),
        exchange(janeStamps, aliceStamps)
    )
}


// region utils

/**
 * Return two array from corresponding inputs
 */
private fun scanTwoArrays(): Pair<Array<Int>, Array<Int>> {
    val string1 = readlnOrNull() ?: throw IllegalArgumentException("Pass a valid input")
    val string2 = readlnOrNull() ?: throw IllegalArgumentException("Pass a valid input")
    if (string1.isExpectedArray() && string2.isExpectedArray()) {
        return Pair(string1.asExpectedIntArray(), string2.asExpectedIntArray())
    } else {
        throw IllegalArgumentException("Invalid input was entered. Must be 1,2,3,4,... normal array format (no {})")
    }
}

/**
 * Expects two {1,2,3,...} strings passed as inputs. Returns null otherwise
 */
private fun parseArgs(args: Array<String>): Pair<Array<Int>, Array<Int>>? {
    return if (args.size == 2 && args.all { it.isExpectedArray() }) {
        Pair(
            args[0].asExpectedIntArray().also { println(it.joinToString(",")) },
            args[1].asExpectedIntArray().also { println(it.joinToString(",")) }
        )
    } else {
        null
    }
}

/**
 * Transforms the input string to an int array
 * **NOTE**: input must have checked with [isExpectedArray] first
 */
private fun String.asExpectedIntArray(): Array<Int> = removeSpace().split(',').map { it.toInt() }.toTypedArray()

/**
 * Returns true if input extension is matching "1,3,4,5..." (spaces removed first)
 */
private fun String.isExpectedArray() = removeSpace().matches("([0-9]+(,[0-9]+)*)+".toRegex())

/**
 * Removes spaces from input
 */
private fun String.removeSpace() = replace(" ", "")

// endregion