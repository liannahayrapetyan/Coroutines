 // Fibonacci
/*fun fibonacci(n:Int):Long {
    var a: Long = 1
    var b: Long = 1
    var result: Long = 1

    for (i in 3..n){
        result = a + b
        a = b
        b = result
    }
    return result
}
fun main(){
    val result = fibonacci(50)
    println(result)
}*/

 // գրել chashing-ով map, list, linkedMapOf,
 /*fun fibonacci(n: Int, cache: HashMap<Int, Long> = HashMap()): Long {
     // Check if the value is already cached
     if (cache.containsKey(n)) {
         return cache[n]!!
     }

     // Base cases
     if (n == 1 || n == 2) {
         return 1
     }

     // Recursive step with caching
     val result = fibonacci(n - 1, cache) + fibonacci(n - 2, cache)

     // Cache the result
     cache[n] = result

     return result
 }

 fun main() {
     val n = 50
     println("The $n-th Fibonacci number is: ${fibonacci(n)}")
 }*/


 /*fun fibonacciMap(n: Int): Long {
     val fibMap = linkedMapOf(1 to 1L, 2 to 1L)

     // Use the map to calculate Fibonacci numbers
     for (i in 3..n) {
         fibMap[i] = fibMap[i - 1]!! + fibMap[i - 2]!!
     }

     return fibMap[n]!!
 }

 fun main() {
     val n = 100
     println("The $n-th Fibonacci number is: ${fibonacciMap(n)}")
 }*/

 /*fun main() {
     val n = 100
     println("The 100th Fibonacci number is: ${fibonacci(n)}")
 }

 fun fibonacci(n: Int, cache: MutableMap<Int, Long> = mutableMapOf()): Long {
     if (n == 1 || n == 2) return 1
     if (cache.containsKey(n)) return cache[n]!!

     val result = fibonacci(n - 1, cache) + fibonacci(n - 2, cache)
     cache[n] = result
     return result
 }*/
 fun main() {
     val s1 = "12312322"
     val s2 = "5555"

     println("Longest substring length for '$s1': ${lengthOfLongestSubstring(s1)}")
     println("Longest substring length for '$s2': ${lengthOfLongestSubstring(s2)}")
 }

 fun lengthOfLongestSubstring(s: String): Int {
     val seen = mutableMapOf<Char, Int>()
     var maxLength = 0
     var start = 0

     for (end in s.indices) {
         val char = s[end]

         // If we have seen this character before and it's within the current window
         if (char in seen && seen[char]!! >= start) {
             start = seen[char]!! + 1
         }

         // Update the current character's index
         seen[char] = end

         // Calculate the length of the current substring without repeating characters
         maxLength = maxOf(maxLength, end - start + 1)
     }

     return maxLength
 }


