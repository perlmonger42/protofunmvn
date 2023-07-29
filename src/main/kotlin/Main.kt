import io.grpc.inprocess.InProcessChannelBuilder
import io.grpc.inprocess.InProcessServerBuilder
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import services.ArithmeticService
import target.Indenter
import java.io.ByteArrayInputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.TimeUnit

private object Protofun {
    val serverName = InProcessServerBuilder.generateName();
    val server = InProcessServerBuilder
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
}

fun main(args: Array<String>) {
    val protofunVisitor = ProtofunVisitorImpl()
    val charstream =
        CharStreams.fromStream(ByteArrayInputStream(Files.readAllBytes((Paths.get("./src/main/resources/main.protofun")))))
    val protofunLexer = ProtofunLexer(charstream)
    val protofunParser = ProtofunParser(CommonTokenStream(protofunLexer))
    val tree = protofunVisitor.visit(protofunParser.start())
    tree.emit(Indenter(System.out, ""))
    Protofun.inProcessCannel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    Protofun.server.shutdown().awaitTermination(5, TimeUnit.SECONDS)
}
