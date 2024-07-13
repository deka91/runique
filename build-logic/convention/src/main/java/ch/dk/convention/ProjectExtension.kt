package ch.dk.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

/**
 * Created by Deniz Kalem on 13.07.2024
 */
val Project.libs get() = extensions.getByType<VersionCatalogsExtension>().named("libs")