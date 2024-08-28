import java.lang.StringBuilder
import java.util.*

class P392DecodeString {

    fun decodeString(s: String): String {
        val stack = Stack<Any>()
        var result = LinkedList<Char>()

        var num = 0
        for (i in s.indices) {
            if (s[i] in '0'..'9') {
                num += num * 10 + (s[i] - '0')
            } else if (s[i] == '[') {
                stack.push(num)
                num = 0
                stack.push('[')
            } else if (s[i] == ']') {
                val charQ = LinkedList<Char>()
                while (stack.peek() != '[') {
                    charQ.addFirst(stack.pop() as Char)
                }
                stack.pop()
                val count = stack.pop() as Int
                val copy = LinkedList<Char>()
                repeat(count) {
                    copy.addAll(charQ)
                }
                result.addAll(copy)
            } else if (s[i] in 'a'..'z') {
                stack.push(s[i])
            }
        }
        val sb = StringBuilder()
        result.forEach {
            sb.append(it)
        }
//        if (stack.isNotEmpty()) {
//            val curr = stack.pop() as Int
//            repeat(curr - 1) {
//                for (c in result) {
//                    sb.append(result)
//                }
//            }
//        }
        return sb.toString()
    }


//    fun decodeString(s: String): String {
//
//        val listOfChars = decodeString(s.toList(), 0, s.length - 1)
//        val sb = StringBuilder()
//        listOfChars.forEach { c -> sb.append(c) }
//        return sb.toString()
//    }

    fun decodeString(s: List<Char>, i: Int, j: Int): List<Char> {
        if (i > j) return emptyList()

        var l = i
        var r = j
        var l1 = 0
        var num = 0
        var state = 0
        var count = 0

        val list = mutableListOf<Char>()

        while (l <= r) {
            if (state == 0) {
                if (s[l] in '0'..'9') {
                    num = num * 10 + (s[l] - '0')
                } else if (s[l] == '[') {
                    state = 1
                    count = 1
                    l1 = l + 1
                } else if (s[l] in 'a'..'z') {
                    list.add(s[l])
                    state = 2
                }
            } else if (state == 1) {
                if (s[l] == ']') {
                    count--
                } else if (s[l] == '[') {
                    count++
                }
                if (count == 0) {
                    val decodedChild = decodeString(s, l1, l - 1)
                    repeat(num) {
                        list.addAll(decodedChild)
                    }
                    state = 0
                    num = 0
                }
            } else {
                if (s[l] in 'a'..'z') {
                    list.add(s[l])
                } else if (s[l] in '0'..'9') {
                    num = s[l] - '0'
                    state = 0
                }
            }
            l++
        }
        return list
    }
}

fun main() {
    val inp1 = "3[a]2[bc]"
    val inp2 = "3[a2[c]]"
    val inp3 = "2[abc]3[cd]ef"
//    val decoded = P392DecodeString().decodeString("2[abc]")
    listOf(inp1, inp2, inp3).forEach {
        println("$it decoded = ${P392DecodeString().decodeString(it)}")
    }
}