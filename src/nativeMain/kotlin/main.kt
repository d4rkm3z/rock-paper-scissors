import kotlin.random.Random

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
}

fun getGameChoice(optionsParam: Array<String>) =
        optionsParam[(Random.nextInt(0, optionsParam.size))]

fun getUserChoice(optionsParam: Array<String>): String {
    printAllOptions(optionsParam)

    val userChoice: Int = scanUserChoice(optionsParam)
    return optionsParam[userChoice]
}

fun scanUserChoice(optionsParam: Array<String>): Int {
    var userChoice: Int

    do {
        print("Enter your choice number: ")
        userChoice = readLine()!!.toInt()

        if (!validate(userChoice, optionsParam.size)) {
            println("Incorrect choice, please try else...")
        }
    } while (!validate(userChoice, optionsParam.size))

    println("\nYou selected: ${optionsParam[userChoice]}")
    return userChoice
}

fun validate(userChoice: Int, size: Int): Boolean = userChoice < size

fun printAllOptions (optionsParam: Array<String>) {
    println("Select one of the following options:")
    for (i in optionsParam.indices) {
        println("$i: ${optionsParam[i]}")
    }
}