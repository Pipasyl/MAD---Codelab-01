package at.ac.fhcampuswien

// WE ARE BACK TO A SIMPLE OBJECT! ⛺
object GameManager {

    val gameLogic = GameLogic()

    // 1. Expected Function: start
    fun start() {
        println("Welcome to the Number Guessing Game!")
        println("Guess a ${gameLogic.digitsToGuess}-digit number with unique digits.")

        while (true) {
            val guess = getUserGuess() ?: break

            if (!gameLogic.isValidGuess(guess)) {
                println("Invalid guess.")
                continue
            }

            val result = gameLogic.evaluateGuess(guess)
            println(result)

            if (gameLogic.isWinningGuess(result)) {
                println("Congratulations! You guessed the correct number.")

                // Calling the required restart function
                if (promptRestart()) {
                    start()  // Recursive call
                    break
                } else {
                    println("Thanks for playing!")
                    break
                }
            }
        }
    }

    // 2. Expected Function: getUserGuess (No longer private!)
    fun getUserGuess(): String? {
        println("Enter your guess (${gameLogic.digitsToGuess} unique digits) or type 'exit':")
        val input = readLine()

        if (input == "exit") {
            println("Thanks for playing!")
            return null
        }
        return input
    }

    // 3. Expected Function: promptRestart
    fun promptRestart(): Boolean {
        println("Do you want to play again? (y/n):")
        val playAgain = readLine()
        return playAgain == "y"
    }
}