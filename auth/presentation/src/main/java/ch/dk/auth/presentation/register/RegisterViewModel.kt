@file:Suppress("OPT_IN_USAGE_FUTURE_ERROR")

package ch.dk.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Created by Deniz Kalem on 02.08.2024
 */
class RegisterViewModel : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    fun onAction(action: RegisterAction) {

    }
}