package ch.dk.auth.domain

/**
 * Created by Deniz Kalem on 02.08.2024
 */
data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    val hasNumber: Boolean = false,
    val hasLowerCaseCharacter: Boolean = false,
    val hasUpperCaseCharacter: Boolean = false
) {
    val isValidPassword: Boolean
        get() = hasMinLength && hasNumber && hasLowerCaseCharacter && hasUpperCaseCharacter
}