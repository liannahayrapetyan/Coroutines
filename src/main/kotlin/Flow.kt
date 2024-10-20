import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) = runBlocking {

   /* val result = sequence {
        repeat(5) {
            Thread.sleep(1000)
            yield(it)
        }
    }


    result.forEach {
        println(it)
    }*/

    /*val intFlow=outFlow()
    println("intFlow is called")
        delay(3000)
        intFlow.collect{
            println("Collected $it")
        }*/
    val result = flow {
        repeat(5)
    }
    val userList = listOf(
        User("Lianna", "Hayrapetyan"),
        User("Mery", "Harutyunyan"),
        User("Marat", "Sargsyan"),
    )
    val intFlow=outFlow()
    /*intFlow.filter { it.surname=="surname_3" }.collect{
        println("Collected $it")
    }
    intFlow.map { it.name}.collect{
        println("Collected $it")
    }*/
    intFlow.transform{
        if (it.surname=="surname_2")
             emit(User("transform", "transform"))
        else emit(it)
    }.filter {
        println("Filter $it")
        it.surname != "transform"
    }.take(5).zip(result){user, i ->
        val string = "${user.name} + ${user.surname} + $i"
        string
    }.collect{
        println("Collected $it")
    }
}
// 1. Flow are cold
private fun outFlow() = flow{
    println("Flow is starting... ")
    repeat(5000){
        delay(1000)
        emit(User("name_$it", "surname_$it"))
        }
    }


data class User(val name: String, val surname: String)




// Nested class does not have any dependency with outer class object
// Inner class does have dependency with outer class object

