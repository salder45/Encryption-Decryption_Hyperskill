package encryptdecrypt

fun main(args: Array<String>) {
    val mode: String = getValueArgs(args, "-mode", "enc")
    val key: Int = getValueArgs(args, "-key", "0").toInt()
    val data: String = getValueArgs(args, "-data", "")

    var output: String = ""
    val numericOperation: Int = if (mode == "enc") {
        1
    } else {
        -1
    }
    for (chr in data) {
        val newValue: Int = chr.code + key * numericOperation
        output+= newValue.toChar()
    }
    println(output)
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

fun getValueArgs(args: Array<String>, key:String, defaultValue: String): String {
    var value: String = defaultValue
    val indexOf = checkArgs(args, key)
    if (indexOf != -1) {
        value = args[indexOf + 1]
    }
    return value
}