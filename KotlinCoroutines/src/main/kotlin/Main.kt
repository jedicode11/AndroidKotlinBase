import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val first = async {
        delay(250)
        "First result"
    }
    val second = async {
        delay(150)
        "Second result"
    }
    println("${first.await()} + ${second.await()}")

    // Start the task immediately so it reaches its first suspension before cancellation.
    val background = launch(start = CoroutineStart.UNDISPATCHED) {
        try {
            println("Background task started")
            awaitCancellation()
        } finally {
            println("Background task cleaned up")
        }
    }

    background.cancelAndJoin()
    println("Background task cancelled and joined")
}
