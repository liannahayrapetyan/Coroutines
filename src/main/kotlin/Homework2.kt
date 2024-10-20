 // Fibonacci
fun fibonacci(n:Int):Long {
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
}

 // գրել chashing-ով map, list, linkedMapOf,
