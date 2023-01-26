package encryptdecrypt

fun main() {
    val operation: String = readln()
    val input: String = readln()
    val key: Int = readln().toInt()
    var output: String = ""
    val numericOperation: Int = if (operation == "enc") {
        1
    } else {
        -1
    }
    for (chr in input) {
        val newValue: Int = chr.code + key * numericOperation
        output+= newValue.toChar()
    }
    println(output)
}