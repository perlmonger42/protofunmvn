import com.googe.protofun.ArithmeticServiceGrpc
import com.googe.protofun.Sum
import io.grpc.inprocess.InProcessChannelBuilder
import io.grpc.inprocess.InProcessServerBuilder
import org.junit.jupiter.api.AfterAll
import services.ArithmeticService
import java.util.concurrent.TimeUnit
import kotlin.test.Test
import kotlin.test.assertTrue

class ArithmeticServiceTest {



    @Test
    fun sumTest() {
        val arithmeticService: ArithmeticServiceGrpc.ArithmeticServiceBlockingStub = ArithmeticServiceGrpc.newBlockingStub(junit.inProcessCannel)
        val response = arithmeticService.add(Sum.newBuilder()
            .setAddend64(1L)
            .setAugend64(1L)
            .build())
        assert(response.int64 == 2L)

    }

    object junit {
        val serverName = InProcessServerBuilder.generateName();
        private val server = InProcessServerBuilder
            .forName(serverName)
            .directExecutor()
            .addService(ArithmeticService())
            .build()
            .start()
        val inProcessCannel = InProcessChannelBuilder
            .forName(serverName)
            .directExecutor()
            // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
            // needing certificates.
            .usePlaintext()
            .build();

        @JvmStatic
        @AfterAll
        fun afterAll() {
            assertTrue(inProcessCannel.shutdown().awaitTermination(5, TimeUnit.SECONDS))
            assertTrue(server.shutdown().awaitTermination(5, TimeUnit.SECONDS))
        }
    }

}