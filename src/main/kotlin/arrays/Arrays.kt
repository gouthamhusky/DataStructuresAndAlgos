package arrays

import kotlin.math.max

fun main() {
    val s = "a"
    println(lengthOfLastWord(s))
}

// https://leetcode.com/problems/contains-duplicate/description/
fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (num in nums){
        if (set.contains(num))
            return true
        set.add(num)
    }
    return false
}

// https://leetcode.com/problems/valid-anagram/description/
fun isAnagram(s: String, t: String): Boolean {
    val charArr = Array(26) {0}

    if (s.length != t.length) return false

    for (i in s.indices){
        val sPos = s[i] - 'a'
        val tPos = t[i] - 'a'
        charArr[sPos]++
        charArr[tPos]--
    }

    for (value in charArr){
        if (value != 0)
            return false
    }
    return true
}

// https://leetcode.com/problems/concatenation-of-array/
fun getConcatenation(nums: IntArray): IntArray {
    val n = nums.size
   val ans = IntArray(n*2)
    for (i in nums.indices){
        ans[i] = nums[i]
        ans[i + n] = nums[i]
    }
    return ans
}

// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
fun replaceElements(arr: IntArray): IntArray {
    val new = IntArray(arr.size)
    val n = arr.size - 1
    new[n] = -1
    for (i in n - 1 downTo 0){
        new[i] = max(arr[i+1], new[i+1])
    }
    return new
}

// https://leetcode.com/problems/is-subsequence/
fun isSubsequence(s: String, t: String): Boolean {
    var sIndex = 0
    var tIndex = 0

    while (sIndex < s.length && tIndex < t.length) {
        if (s[sIndex] == t[tIndex]) {
            sIndex++
        }
        tIndex++
    }
    return sIndex == s.length
}

fun lengthOfLastWord(s: String): Int {
    var i = s.length - 1
    while (s[i] == ' ')
        i--

    var length = 0
    while (i >= 0 && s[i] != ' '){
        length++
        i--
    }
    return length
}