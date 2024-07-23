package ch.dk.auth.presentation.intro

/**
 * Created by Deniz Kalem on 23.07.2024
 */
sealed interface IntroAction {
    data object OnSignInClick : IntroAction
    data object OnSignUpClick : IntroAction
}