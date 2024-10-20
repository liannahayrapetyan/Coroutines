import kotlinx.coroutines.*

fun main() = runBlocking {
// launch - ը result չի տալիս
    var result = 0
    val job1 = launch {
        delay(1000)
        val value1 = 10
        result+=value1
    }

    val job2 = launch {
        delay(2000)
        val value2 = 30
        result+=value2

    }

    job1.join()
    job2.join()
    println("Result is : $result")
}