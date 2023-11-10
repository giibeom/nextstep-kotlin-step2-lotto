package calculator

class PositiveNumbers {

    private val numbers: MutableList<Int> = mutableListOf()
    val values: List<Int>
        get() = numbers.toList()

    fun add(number: Int) {
        if (number < POSITIVE_NUMBER_THRESHOLD) {
            throw RuntimeException("숫자는 0 이상의 양수를 입력해주세요.")
        }

        numbers.add(number)
    }

    fun sum(): Int {
        return numbers.sum()
    }

    companion object {
        private const val POSITIVE_NUMBER_THRESHOLD = 0
    }
}
