package encryptdecrypt

import java.io.File
const val ALPHA_LOWERCASE = "abcdefghijklmnopqrstuvwxyz"
const val ALPHA_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
fun main(args: Array<String>) {
    try {
        val mode: String = getValueArgs(args, "-mode", "enc")
        val key: Int = getValueArgs(args, "-key", "0").toInt()
        var data: String = getValueArgs(args, "-data")
        val pathIn: String = getValueArgs(args, "-in")
        val pathOut: String = getValueArgs(args, "-out")
        val algorithm: String = getValueArgs(args, "-alg", "shift")
        if (pathIn != "" && data == "") {
            data = readFile(pathIn)
        }
        var output: String = ""
        val numericOperation: Int = if (mode == "enc") {
            1
        } else {
            -1
        }
        for (chr in data) {
            val newValue: Int =
                if (algorithm == "shift") {
                    caesar(chr, key * numericOperation, mode)
                } else {
                    chr.code + key * numericOperation
                }
            output+= newValue.toChar()
        }

        if(pathOut != "") {
            writeFile(output, pathOut)
        } else {
            println(output)
        }
    }catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

fun checkArgs(args: Array<String>, key: String): Int {
    var indexOf: Int = -1
    for (index in args.indices) {
        if (args[index] == key) {
            indexOf = index
            break
        }
    }
    return indexOf
}

fun getValueArgs(args: Array<String>, key:String, defaultValue: String = ""): String {
    var value: String = defaultValue
    val indexOf = checkArgs(args, key)
    if (indexOf != -1) {
        value = args[indexOf + 1]
    }
    return value
}

fun writeFile(data: String, filepath: String) {
    File(filepath).writeText(data)
}

fun readFile(filepath: String) :String {
    return File(filepath).readText()
}


fun caesar(chr: Char, key: Int, mode: String) : Int {
    val alphabet: String = if (chr.isUpperCase()) {
        ALPHA_UPPERCASE
    } else {
        ALPHA_LOWERCASE
    }
    return if (alphabet.contains(chr)) {
        alphabet.first().code + alphabetIndex(alphabet.indexOf(chr) + key)
    } else {
        chr.code
    }
}

fun alphabetIndex(newIndex: Int): Int {
    return if (newIndex < 0) {
        26 + newIndex
    } else if (newIndex > 26) {
        0 + (newIndex - 26)
    } else {
        newIndex
    }
}

