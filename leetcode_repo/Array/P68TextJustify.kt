//import org.graalvm.compiler.word.Word
//
//class P68TextJustify {
//    data class WordText(val word: String, var beforeSpaces: Int = 0)
//    data class WordLine(val line: List<String>, val size: Int)
//
//    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
//        var wordCount = 0
//        val wordResult = mutableListOf<String>()
//        val ll = mutableListOf<Pair<List<Word>, Int>>()
//        var currWordIndex = 0
//        while (currWordIndex < words.size) {
//            var currTotalWidth = 0
//            val list = mutableListOf<WordText>()
//            var firstWord = true
//
//            while (currWordIndex < words.size) {
//                val currWord = words[currWordIndex]
//                if (firstWord) {
//                    currTotalWidth += currWord.length
//                    firstWord = false
//                    list.add(WordText(currWord, 0))
//                } else {
//                    currTotalWidth += currWord.length + 1
//                    if (currTotalWidth <= maxWidth) {
//                        list.add(WordText(currWord, 1))
//                    } else { // word exceeds the maxWidth
//                        currTotalWidth -= (currWord.length + 1)
//                        ll.add(WordLine(list, currTotalWidth))
//
//                        currWordIndex--
//                        break
//                    }
//                }
//                currWordIndex++
//            }
//        }
//    }
//
//    fun getList(from: List<Pair<List<Word>, Int>>, maxWidth: Int): List<String> {
//        val res = mutableListOf<String>()
//        from.forEach { items ->
//            val sb = StringBuilder()
//            items.first.forEach {
//                sb.append(it)
//            }
//            res.add(sb.toString())
//        }
//        return res
//    }
//}