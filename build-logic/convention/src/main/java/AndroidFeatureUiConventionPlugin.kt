import ch.dk.convention.addUiLayerDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Created by Deniz Kalem on 14.07.2024
 */
class AndroidFeatureUiConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runique.android.library.compose")
            }

            dependencies {
                addUiLayerDependencies(target)
            }
        }
    }
}