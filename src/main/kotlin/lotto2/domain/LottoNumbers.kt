package lotto2.domain

@JvmInline
value class LottoNumbers(private val numbers: List<LottoNumber>) : Collection<LottoNumber> by numbers {
    init {
        validateSize()
        validateDuplicate()
    }

    private fun validateSize() {
        require(numbers.size == MAIN_LOTTO_NUMBERS_COUNT) { "로또 번호는 총 6개여야 합니다." }
    }

    private fun validateDuplicate() {
        require(numbers.size == numbers.toSet().size) { "로또 번호들은 서로 중복될 수 없습니다." }
    }

    fun countMatchingNumbers(lottoNumbers: LottoNumbers): Int {
        return numbers.intersect(lottoNumbers.numbers.toSet()).size
    }

    fun contains(number: Int): Boolean {
        return numbers.map { it.number }
            .contains(number)
    }

    override fun toString(): String {
        return numbers.map { it.number }.toString()
    }

    companion object {
        const val MAIN_LOTTO_NUMBERS_COUNT = 6
    }
}
