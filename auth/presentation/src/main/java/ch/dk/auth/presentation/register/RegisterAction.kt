package ch.dk.auth.presentation.register

/**
 * Created by Deniz Kalem on 02.08.2024
 */
sealed interface RegisterAction {
    data object OnTogglePasswordVisibilityClick: RegisterAction
    data object OnLoginClick: RegisterAction
    data object OnRegisterClick: RegisterAction
}