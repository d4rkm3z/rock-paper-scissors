import kotlin.random.Random

enum class Options {
    ROCK, PAPER, SCISSORS
}

fun main() {
    val options = Options.values()
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<Options>) =
    optionsParam[(Random.nextInt(0, optionsParam.size))]

fun getUserChoice(optionsParam: Array<Options>): Options {
    printAllOptions(optionsParam)

    val userChoice: Int = scanUserChoice(optionsParam)
    return optionsParam[userChoice]
}

fun scanUserChoice(optionsParam: Array<Options>): Int {
    var userChoice: Int = -1

    do {
        print("Enter your choice number: ")
        try {
            val userInput = readLine()
            if (userInput != null) userChoice = userInput.toInt()
            else continue
        } catch (error: NumberFormatException) {
            continue
        }

        if (!validate(userChoice, optionsParam.size)) {
            println("Incorrect choice, please try else...")
        }
    } while (!validate(userChoice, optionsParam.size))

    return userChoice
}

fun validate(userChoice: Int, size: Int): Boolean = userChoice in 0 until size

fun printAllOptions(optionsParam: Array<Options>) {
    println("Select one of the following options:")
    for (i in optionsParam.indices) {
        println("$i: ${optionsParam[i]}")
    }
}

fun printResult(userChoice: Options, gameChoice: Options) {
    val result: String = if (userChoice == gameChoice) "Tie!"
    else if ((userChoice == Options.ROCK && gameChoice == Options.SCISSORS) ||
        (userChoice == Options.PAPER && gameChoice == Options.ROCK) ||
        (userChoice == Options.SCISSORS && gameChoice == Options.PAPER)) "You win!"
    else "You lose!"

    println("you chose $userChoice. I chose $gameChoice. $result")
}