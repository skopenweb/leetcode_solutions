import java.util.*
import kotlin.Comparator
import kotlin.random.Random

class P56MergeIntervals {
    fun merge(a: Array<IntArray>): Array<IntArray> {
        quickSort(a, 0, a.size - 1) { p, q -> p[0] - q[0] }
        val list = LinkedList<IntArray>()
        var curr = a[0]
        for (i in 1..<a.size) {
            if (curr.overlap(a[i])) {
                curr = curr.merge(a[i])
            } else {
                list.add(curr)
                curr = a[i]
            }
        }
        list.add(curr)

        val output = Array<IntArray>(list.size) { list[it] }
        return output
    }

    fun <T> quickSort(a: Array<T>, start: Int, end: Int, comparator: Comparator<T>) {
        if (start > end) return
        val partition = partition(a, start, end, comparator)
        quickSort(a, start, partition - 1, comparator)
        quickSort(a, partition + 1, end, comparator)
    }

    private fun <T> partition(a: Array<T>, start: Int, end: Int, comparator: Comparator<T>): Int {
        var firstHigh = start
        var curr = start
        val pivot = a[end]
        while (curr < end) {
            if (comparator.compare(a[curr], pivot) < 0) {
                swap(a, curr, firstHigh++)
            }
            curr++
        }
        swap(a, firstHigh, end)
        return firstHigh
    }

    private fun <T> swap(a: Array<T>, i: Int, j: Int) {
        val t = a[i]
        a[i] = a[j]
        a[j] = t
    }

    private fun IntArray.overlap(o: IntArray): Boolean {
        val minX = this[0].coerceAtMost(o[0])
        val maxX = this[1].coerceAtLeast(o[1])
        val diff = this[1] - this[0] + o[1] - o[0]
        return (maxX - minX) <= diff
    }

    private fun IntArray.merge(o: IntArray) = intArrayOf(this[0].coerceAtMost(o[0]), this[1].coerceAtLeast(o[1]))

}

fun main() {
    val arr = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    val out = P56MergeIntervals().merge(arr)

    val sb = StringBuilder("[")
    out.forEachIndexed { in1, items ->
        sb.append("[")
        items.forEachIndexed { index, item ->
            sb.append(if (index == items.size - 1) "$item" else "$item, ")
        }
        sb.append(if (in1 == out.size - 1) "]]" else "], ")
    }
    println(sb)
}

fun testSort() {
    val random = Random(System.currentTimeMillis())
    val arr = Array(100) { 0 }
    for (i in 0..<100) {
        arr[i] = random.nextInt(10, 100)
    }

    val solution = P56MergeIntervals()
    solution.quickSort(arr, 0, arr.size - 1) { a, b -> a - b }
    arr.forEach { print("$it, ") }

    var res = true
    for (i in 1..<arr.size) {
        if (arr[i] < arr[i - 1]) {
            res = false
            break
        }
    }
    println(if (res) "\nSorted" else "\nNOT SORTED")
}

fun hello() {
    val ar = arrayOf("123", "789", "456", "12", "234")
    ar.sortWith { a, b -> a.length - b.length }
    ar.forEach { print("$it, ") }
}