class P200NumOfIsland {
    data class WordText(val word: String, var len: Int)

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        val M = grid.size
        val N = grid[0].size



        val visited = Array<BooleanArray>(M) { i ->
            BooleanArray(N) { j -> grid[i][j] == '1' }
        }

        for (i in 0..<M) {
            for (j in 0..<N) {
                if (visited[i][j].not()) {
                    dfs(grid, i, j, visited)

                    println
                    count++
                }
            }
        }
        return count
    }

    fun shallVisit(g: Array<CharArray>, i: Int, j: Int, visited: Array<BooleanArray>): Boolean {
        if (i < 0 || j < 0 || i >= g.size || j >= g[0].size) return false

        if (g[i][j] == '1') return false
        return visited[i][j].not()
    }

    fun dfs(g: Array<CharArray>, i: Int, j: Int, visited: Array<BooleanArray>) {
        if (i < 0 || j < 0 || i >= g.size || j >= g[0].size) return
        if (visited[i][j]) return
        if (g[i][j] == '1') return

        visited[i][j] = true
        dfs(g, i - 1, j, visited)
        dfs(g, i + 1, j, visited)
        dfs(g, i, j + 1, visited)
        dfs(g, i, j - 1, visited)
    }
}

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1'),
    )
    val ans = P200NumOfIsland().numIslands()
}