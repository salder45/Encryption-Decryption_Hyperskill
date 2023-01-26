package encryptdecrypt

fun main() {
    val operation: String = readln()
    val input: String = readln()
    val key: Int = readln().toInt()
    if (operation == "enc") {
        //encrypt
        println("encrypt")
    } else {
        //decrypt
        println("decrypt")
    }
}