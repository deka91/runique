@file:Suppress("OPT_IN_USAGE_FUTURE_ERROR")

package ch.dk.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ch.dk.auth.domain.UserDataValidator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Deniz Kalem on 02.08.2024
 */
@OptIn(ExperimentalFoundationApi::class)
class RegisterViewModel(private val userDataValidator: UserDataValidator) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    init {
        state.email.textAsFlow()
            .onEach { email -> state = state.copy(isEmailValid = userDataValidator.isValidEmail(email.toString())) }
            .launchIn(viewModelScope)

        state.password.textAsFlow().onEach { password ->
            state = state.copy(passwordValidationState = userDataValidator.validatePassword(password.toString()))
        }.launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {

    }
}