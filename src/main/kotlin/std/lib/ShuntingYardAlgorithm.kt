package std.lib

object ShuntingYardAlgorithm {
    data class NumberData(val rest: List<Char>, val value: Double)
    fun evaluate(str: String): Any {


        return object : Any() {

            fun parse(chars: List<Char>): Double {
                return getExpression(chars.filter { it != ' ' })
                    .also { if (it.rest.isNotEmpty()) throw RuntimeException("Unexpected character: ${it.rest.first()}") }
                    .value
            }

            private fun getExpression(chars: List<Char>): NumberData {
                var (rest, carry) = getTerm(chars)
                while (true) {
                    when {
                        rest.firstOrNull() == '+' -> rest = getTerm(rest.drop(1)).also { carry += it.value }.rest
                        rest.firstOrNull() == '-' -> rest = getTerm(rest.drop(1)).also { carry -= it.value }.rest
                        else -> return NumberData(rest, carry)
                    }
                }
            }

            fun getTerm(chars: List<Char>): NumberData {
                var (rest, carry) = getFactor(chars)
                while (true) {
                    when {
                        rest.firstOrNull() == '*' -> rest = getTerm(rest.drop(1)).also { carry *= it.value }.rest
                        rest.firstOrNull() == '/' -> rest = getTerm(rest.drop(1)).also { carry = it.value / carry }.rest
                        else -> return NumberData(rest, carry)
                    }
                }
            }

            fun getFactor(chars: List<Char>): NumberData {
                return when (val char = chars.firstOrNull()) {
                    '+' -> getFactor(chars.drop(1)).let { NumberData(it.rest, +it.value) }
                    '-' -> getFactor(chars.drop(1)).let { NumberData(it.rest, -it.value) }
                    '(' -> getParenthesizedExpression(chars.drop(1))
                    in '0'..'9', ',' -> getNumber(chars)
                    else -> throw RuntimeException("Unexpected character: $char")
                }
            }

            fun getParenthesizedExpression(chars: List<Char>): NumberData {
                return getExpression(chars)
                    .also { if (it.rest.firstOrNull() != ')') throw RuntimeException("Missing closing parenthesis") }
                    .let { NumberData(it.rest.drop(1), it.value) }
            }

            fun getNumber(chars: List<Char>): NumberData {
                val s = chars.takeWhile { it.isDigit() || it == '.' }.joinToString("")
                return NumberData(chars.drop(s.length), s.toDouble())
            }

        }.parse(str.toList())

    }
}

