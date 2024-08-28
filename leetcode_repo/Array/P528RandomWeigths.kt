import kotlin.random.Random

class P528RandomWeigths(val w: IntArray) {

    val weightSum = IntArray(w.size) { w[it] }
    val randomGenerator = Random(System.currentTimeMillis())

    init {
        for (i in 1..weightSum.lastIndex) {
            weightSum[i] += weightSum[i - 1]
        }
    }

    fun pickIndex(): Int {
        val fraction = Random.nextFloat()
        val num = (weightSum.last() * fraction).toInt()
        val index = searchGreater(weightSum, num)
        println("\t${w[index]}")
        return  index
    }

    private fun searchGreater(a: IntArray, e: Int): Int {
        if (a[a.size - 1] < e) return -1
        var l = 0
        var r = a.size - 1
        var mid = 0

        while (l < r) {
            mid = (l + r) / 2
            if (a[mid] >= e) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l
    }
}

fun main() {
    val arr = intArrayOf(3, 14, 1, 7)
    repeat(100) {
        val index = P528RandomWeigths(arr).pickIndex()
//        val ans = arr[index]
//        println("value = ${arr[index]}")
    }

}