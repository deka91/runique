package ch.dk.core.presentation.ui

import ch.dk.core.domain.util.DataError

/**
 * Created by Deniz Kalem on 19.07.2024
 */
fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Local.DISK_FULL -> UiText.StringResource(R.string.error_disk_full)
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(R.string.error_request_timeout)
        DataError.Network.TOO_MANY_REQUESTS -> UiText.StringResource(R.string.error_too_many_requests)
        DataError.Network.NO_INTERNET -> UiText.StringResource(R.string.error_no_internet)
        DataError.Network.PAYLOAD_TOO_LARGE -> UiText.StringResource(R.string.error_payload_too_large)
        DataError.Network.SERVER_ERROR -> UiText.StringResource(R.string.error_server_error)
        DataError.Network.SERIALIZATION_ERROR -> UiText.StringResource(R.string.error_serialiazation)
        DataError.Network.UNKNOWN -> UiText.StringResource(R.string.error_unknown)
        else -> UiText.StringResource(R.string.error_unknown)
    }
}