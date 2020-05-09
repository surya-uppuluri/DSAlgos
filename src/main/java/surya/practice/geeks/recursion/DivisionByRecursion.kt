package surya.practice.geeks.recursion

fun main() {
    println(divide(dividend = 20, divisor = 5))
    println(divide(dividend = 20, divisor = 6))

}

fun divide(dividend: Int, divisor: Int): Int {
    return if (dividend-divisor < 0) 0;
    else 1 + divide(dividend - divisor, divisor);
}
