import kotlinx.coroutines.*

suspend fun task1():Int{
    delay(1000)
    return 10
}
suspend fun task2():Int{
    delay(2000)
    return 30
}

fun main() = runBlocking {
    val deferred1 = async {task1()}
    val deferred2 = async {task2()}

    val result1 = deferred1.await()
    val result2 = deferred2.await()

    val final = result1 + result2
    println("Final result is $final")
}

/*
fun main() = runBlocking {
    val job1 = launch {
        delay(1000)

    }
    val deferred1 = async {
        delay(1000)
        10
    }
    val deferred2 = async {
        delay(2000)
        30

    }
    job1.join()
    var result = deferred1.await() + deferred2.await()
    println("Result is : $result")
}

*/