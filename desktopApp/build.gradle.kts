import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose)
}

kotlin {
    jvm {}
    sourceSets {
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(project(":app:sns"))
        }
    }
}

compose.desktop {
    application {
        mainClass = "jp.co.mixi.androidtraining.sns.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jp.co.mixi.androidtraining.sns"
            packageVersion = libs.versions.app.versionName.get()
        }
    }
}
