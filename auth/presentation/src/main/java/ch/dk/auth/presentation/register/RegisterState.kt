@file:OptIn(ExperimentalFoundationApi::class)

package ch.dk.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import ch.dk.auth.domain.PasswordValidationState

/**
 * Created by Deniz Kalem on 02.08.2024
 */
data class RegisterState(
    val email: TextFieldState = TextFieldState(),
    val isEmailValid: Boolean = false,
    val password: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val passwordValidationState: PasswordValidationState = PasswordValidationState(),
    val isRegistering: Boolean = false,
    val canRegister: Boolean = passwordValidationState.isValidPassword && !isRegistering
)