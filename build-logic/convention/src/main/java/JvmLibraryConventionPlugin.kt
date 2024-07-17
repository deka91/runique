import ch.dk.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Deniz Kalem on 14.07.2024
 */
class JvmLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("org.jetbrains.kotlin.jvm")
            configureKotlinJvm()
        }
    }
}