package services

import com.google.protofun.ArithmeticServiceGrpc.ArithmeticServiceImplBase
import com.google.protofun.Difference
import com.google.protofun.Number
import com.google.protofun.Sum
import io.grpc.stub.StreamObserver
import java.lang.IllegalArgumentException

class ArithmeticService: ArithmeticServiceImplBase() {

    override fun add(
        request: Sum,
        responseObserver: StreamObserver<Number>
    ) {

        val response = when(request.addendCase) {
            Sum.AddendCase.ADDEND_64 -> when (request.augendCase) {
                Sum.AugendCase.AUGEND_64 -> Number.newBuilder().setInt64(request.addend64 + request.augend64).build()
                Sum.AugendCase.AUGEND_32 -> Number.newBuilder().setInt64(request.addend64 + request.augend32).build()
                Sum.AugendCase.AUGEND_NOT_SET -> throw IllegalArgumentException("No augend provided")
            }
            Sum.AddendCase.ADDEND_32 -> when(request.augendCase) {
                Sum.AugendCase.AUGEND_64 -> throw IllegalArgumentException("Cannot add a long to type int")
                Sum.AugendCase.AUGEND_32 -> Number.newBuilder().setInt32(request.addend32 + request.addend32).build()
                Sum.AugendCase.AUGEND_NOT_SET -> throw IllegalArgumentException("No augend provided")
            }
            Sum.AddendCase.ADDEND_NOT_SET -> throw IllegalArgumentException("No addend provided")
        }
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }


    override fun substract(
        request: Difference,
        responseObserver: StreamObserver<Number>
    ) {
        val respone = when(request.minuendCase) {
           Difference.MinuendCase.MINUEND_64 -> when(request.subtrahendCase) {
                Difference.SubtrahendCase.SUBTRAHEND_64 -> Number.newBuilder().setInt64(request.minuend64 - request.subtrahend64).build()
                Difference.SubtrahendCase.SUBTRAHEND_32 -> Number.newBuilder().setInt64(request.minuend64 - request.subtrahend32).build()
                Difference.SubtrahendCase.SUBTRAHEND_NOT_SET -> throw IllegalArgumentException("No subtrahend provided")
            }
            Difference.MinuendCase.MINUEND_32 -> when(request.subtrahendCase) {
                Difference.SubtrahendCase.SUBTRAHEND_64 -> throw IllegalArgumentException("Cannot subtract a long from an int")
                Difference.SubtrahendCase.SUBTRAHEND_32 -> Number.newBuilder().setInt32(request.minuend32 - request.subtrahend32).build()
                Difference.SubtrahendCase.SUBTRAHEND_NOT_SET -> throw IllegalArgumentException("No subtrahend provided")
            }
            Difference.MinuendCase.MINUEND_NOT_SET -> throw IllegalArgumentException("Minuend was not set!")
        }
        responseObserver.onNext(respone)
        responseObserver.onCompleted()
    }
}