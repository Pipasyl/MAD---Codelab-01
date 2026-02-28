package at.ac.fhcampuswien
data class GuessResult(
    val correctDigits: Int,
    val correctPositions: Int
) {
    override fun toString(): String {
        return "$correctDigits:$correctPositions"
    }
}
