package ch.dk.core.data.networking

import ch.dk.core.data.BuildConfig
import ch.dk.core.domain.util.DataError
import ch.dk.core.domain.util.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.SerializationException

/**
 * Created by Deniz Kalem on 21.07.2024
 */
suspend inline fun <reified Response : Any> HttpClient.get(
    route: String, queryParameters: Map<String, Any?> = mapOf()
): Result<Response, DataError.Network> {
    return safeCall {
        get {
            url(constructRoute(route))
            queryParameters.forEach { (key, value) -> parameter(key, value) }
        }
    }
}

suspend inline fun <reified Response : Any> HttpClient.delete(
    route: String, queryParameters: Map<String, Any?> = mapOf()
): Result<Response, DataError.Network> {
    return safeCall {
        delete {
            url(constructRoute(route))
            queryParameters.forEach { (key, value) -> parameter(key, value) }
        }
    }
}

suspend inline fun <reified Request, reified Response : Any> HttpClient.post(
    route: String, body: Request
): Result<Response, DataError.Network> {
    return safeCall {
        post {
            url(constructRoute(route))
            setBody(body)
        }
    }
}

suspend inline fun <reified T> safeCall(execute: () -> HttpResponse): Result<T, DataError.Network> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        e.printStackTrace()
        return Result.Error(DataError.Network.NO_INTERNET)
    } catch (e: SerializationException) {
        e.printStackTrace()
        return Result.Error(DataError.Network.SERIALIZATION_ERROR)
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        e.printStackTrace()
        return Result.Error(DataError.Network.UNKNOWN)
    }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T, DataError.Network> {
    return when (response.status.value) {
        in 200..299 -> Result.Success(response.body<T>())
        401 -> Result.Error(DataError.Network.UNAUTHORIZED)
        408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
        409 -> Result.Error(DataError.Network.CONFLICT)
        413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
        429 -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(DataError.Network.SERVER_ERROR)
        else -> Result.Error(DataError.Network.UNKNOWN)
    }
}

fun constructRoute(route: String): String {
    return when {
        route.contains(BuildConfig.BASE_URL) -> route
        route.startsWith("/") -> BuildConfig.BASE_URL + route
        else -> BuildConfig.BASE_URL + "/$route"
    }
}