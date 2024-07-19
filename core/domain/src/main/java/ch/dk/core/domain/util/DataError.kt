package ch.dk.core.domain.util

/**
 * Created by Deniz Kalem on 19.07.2024
 */
sealed interface DataError : Error {

    enum class Network : DataError {
        REQUEST_TIMEOUT,
        UNAUTHORIZED,
        CONFLICT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERIALIZATION_ERROR,
        UNKNOWN
    }

    enum class Local: DataError {
        DISK_FULL,
    }
}