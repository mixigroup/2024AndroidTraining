plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose)
}

kotlin {
    androidTarget()
    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
        }
        androidMain.dependencies {
            implementation(libs.androidx.compose.preview)
            implementation(libs.ktor.cio)
        }
        iosMain.dependencies {
            implementation(libs.ktor.darwin)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.ktor.core)
            implementation(libs.coil)
            implementation(libs.coil.network)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.cio)
        }
    }
}

compose.resources {
    packageOfResClass = "jp.co.mixi.androidtraining.sns.resources"
}

android {
    namespace = "jp.co.mixi.androidtraining.sns"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.androidx.compose.tooling)
    }
}
