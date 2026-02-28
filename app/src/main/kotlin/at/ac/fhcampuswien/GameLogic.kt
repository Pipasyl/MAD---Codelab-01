package at.ac.fhcampuswien
import at.ac.fhcampuswien.GuessResult

class GameLogic(initialDigitsToGuess: Int = DEFAULT_DIGITS) {

    var digitsToGuess: Int = initialDigitsToGuess
        private set

    private val targetNumber: List<Int> = generateRandomNumber(digitsToGuess)

    val evaluateGuess: (String) -> GuessResult = { guess ->
        val guessDigits = guess.map { it.toString().toInt() }
        val correctPositions = guessDigits.indices.count { i ->
            guessDigits[i] == targetNumber[i]
        }
        val correctDigits = guessDigits.toSet().count { digit ->
            targetNumber.contains(digit)
        }
        GuessResult(correctDigits, correctPositions)
    }

    val isValidGuess: (String?) -> Boolean = { guess ->
        guess != null &&
                guess.length == digitsToGuess &&
                guess.all { it.isDigit() && it != '0' } &&
                guess.toSet().size == guess.length
    }
    fun isWinningGuess(result: GuessResult) = result.correctPositions == digitsToGuess

    companion object {
        const val DEFAULT_DIGITS = 4
        fun generateRandomNumber(digits: Int): List<Int> {
            return (1..9).shuffled().take(digits)
        }
    }
}