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
    /*
    //0 - 25
    val alphabet: String = "abcdefghijklmnopqrstuvwxyz"
    val input: String = readln()
    val keyValue: Int = readln().toInt()
    var encodedMessage: String = ""
    for (char in input) {
        if (alphabet.contains(char)) {
            val initialPosition = alphabet.indexOf(char)
            var newPosition: Int = initialPosition + keyValue
            if (newPosition > 25) {
                newPosition = newPosition - 26
            }
            //println("$char = $initialPosition = $newPosition = ${alphabet[newPosition]}")
            encodedMessage+= alphabet[newPosition]
        } else {
          encodedMessage+= char
        }
    }
     */
    //A-B-C-D-E-F-G-H-I-J-K-L-M-N-O-P-Q-R-S-T-U-V-W-X-Y-Z
    //Z-Y-X-W-V-U-T-S-R-Q-P-O-N-M-L-K-J-I-H-G-F-E-D-C-B-A
    //we found a treasure!
    //dv ulfmw z givzhfiv!
    println(encodedMessage)
}