import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MainKtTest {
    @Test
    fun `exchangeStamps test1`() {
        val t = StampExchange(arrayOf(1, 7, 3, 1, 7, 4, 5, 1, 7, 1), arrayOf(2, 3, 3, 2, 4, 3, 2)).output()
        assertUnOrderedEquals(arrayOf(2, 3), t.first)
        assertUnOrderedEquals(arrayOf(1, 1, 7), t.second)
    }

    @Test
    fun `exchangeStamps test2`() {
        val t = StampExchange(arrayOf(1, 2, 3, 4, 4), arrayOf(4, 4, 4, 5, 6, 7)).output()
        assertUnOrderedEquals(arrayOf(), t.first)
        assertUnOrderedEquals(arrayOf(), t.second)
    }

    @Test
    fun `exchangeStamps test3`() {
        val t = StampExchange(arrayOf(5, 4, 4, 3, 3, 3, 3), arrayOf(1, 3)).output()
        assertUnOrderedEquals(arrayOf(), t.first)
        assertUnOrderedEquals(arrayOf(3, 3), t.second)
    }
}

private fun assertUnOrderedEquals(first: Array<Int>, second: Array<Int>) {
    assertArrayEquals(first.apply { sort() }, second.apply { sort() })
}