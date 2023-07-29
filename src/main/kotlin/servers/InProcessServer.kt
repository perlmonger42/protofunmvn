package servers

import io.grpc.BindableService
import io.grpc.Server
import io.grpc.inprocess.InProcessServerBuilder
import java.io.IOException


class InProcessServer<T : Class<BindableService>> (private val clazz: T) {

    private var server: Server? = null

    @Throws(IOException::class, InstantiationException::class, IllegalAccessException::class)
    fun start() {
        server = InProcessServerBuilder
            .forName("test")
            .directExecutor()
            .addService(clazz!!.getConstructor().newInstance()!!)
            .build()
            .start()
        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down")
                this@InProcessServer.stop()
                System.err.println("*** server shut down")
            }
        })
    }

    fun stop() {
        if (server != null) {
            server?.shutdown()
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    @Throws(InterruptedException::class)
    fun blockUntilShutdown() {
        server?.awaitTermination()
    }
}