package ch.dk.auth.data

import android.util.Patterns
import ch.dk.auth.domain.PatternValidator

/**
 * Created by Deniz Kalem on 08.08.2024
 */
object EmailPatternValidator : PatternValidator {

    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}