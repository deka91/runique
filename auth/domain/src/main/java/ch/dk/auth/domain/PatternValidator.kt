package ch.dk.auth.domain

/**
 * Created by Deniz Kalem on 08.08.2024
 */
interface PatternValidator {

    fun matches(value: String): Boolean
}