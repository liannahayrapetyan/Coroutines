import kotlinx.coroutines.*

/*
1. runBlocking is s bridge between non-coroutine world and coroutine world
2. Each coroutine is running in a coroutine scope
3. Most common coroutine builder is launch
4. Structured concurrency - Unless all child coroutines are complete the parent will not coroutine
   in other words parent coroutine waits all its children coroutines to complete their job
 */



/*fun main(args: Array<String>) = runBlocking   {
launch {
   doSomethingElse()
}
launch{
    doSomething()
}
    println("Hello,")
}

private suspend fun doSomething(){
    delay(1000)
    println("World!")
}
private suspend fun doSomethingElse(){
    delay(2000)
    println("World2!")
}
*/

/*
fun test(){

}
fun main(args: Array<String>) = runBlocking   {
    launch {
        val result = withTimeout(2500){ // withTimeoutOrNull - print null
            doSomething()
            "Done"
        }
        println(result)
    }
    println("Hello,")
    // job.join()
    delay(2500)
    //job.cancel()
    //job.cancelAndJoin()
    //println("Done,")
}

private suspend fun doSomething(){
    repeat(3) {
    delay(1000)
    println("World!")
}
}*/



fun test(){

}
fun main(args: Array<String>) = runBlocking {
    val job = launch {
        var startTime = System.currentTimeMillis()
        var i = 0

        // Below code is simulation to wait 1000 milliseconds (some result as dilay(1000))
        // Cancellation is not happening becouse there is no code to check is job canceledor not

       /* while (i < 5) {
            if (System.currentTimeMillis() > startTime + 1000) {
                i++
                startTime = System.currentTimeMillis()
                //delay(1000)
                println("World!")
            }
        }*/
        while (i < 5) {
            if (isActive) {
                i++
                delay(1000)
                println("World!")
            }
        }
    }
    println("Hello ")
    delay(2500)
    job.cancel()
}



