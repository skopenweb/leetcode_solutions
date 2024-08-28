class P539TimeDifferences {
    fun findMinDifference(timePoints: List<String>): Int {
        val arr = Array(timePoints.size) { 0 }

        timePoints.forEachIndexed { index, item ->
            arr[index] = item.toMinutes()
        }
        quickSort(arr, 0, arr.size - 1)

        var min = Int.MAX_VALUE
        for (i in 1..<arr.size) {
            val diff = arr[i] - arr[i - 1]
            if (diff < min) {
                min = diff
            }
        }
        val diff = arr.first() + 24 * 60 - arr.last()
        return min.coerceAtMost(diff)
    }

    fun quickSort(a: Array<Int>, l: Int, r: Int) {
        if (l > r) return
        val p = partition(a, l, r)

        quickSort(a, l, p - 1)
        quickSort(a, p + 1, r)
    }

    fun partition(a: Array<Int>, l: Int, r: Int): Int {
        val p = a[r]

        var firstHigh = l
        while (firstHigh < r && a[firstHigh] <= p) {
            firstHigh++
        }
        var curr = firstHigh
        while (curr < r) {
            if (a[curr] < p) {
                swap(a, firstHigh, curr)
                firstHigh++
            }
            curr++
        }
        swap(a, firstHigh, r)
        return firstHigh
    }

    fun swap(a: Array<Int>, l: Int, h: Int) {
        val t = a[l]
        a[l] = a[h]
        a[h] = t
    }

    fun String.toMinutes(): Int {
        var m = 0
        var curr = 0
        forEach { item ->
            if (item == ':') {
                m = curr * 60
                curr = 0
            } else {
                curr = curr * 10 + (item - '0')
            }
        }
        return m + curr
    }
}

fun main() {
    val result = P539TimeDifferences().findMinDifference(timePoints = listOf("23:59", "00:00"))
    println("result = $result")
}