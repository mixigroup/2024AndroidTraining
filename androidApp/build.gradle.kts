plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose)
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting
        androidMain.dependencies {
            implementation(project(":app:sns"))
            implementation(compose.material)
            implementation(libs.androidx.activity.compose)
        }
    }
}

android {
    namespace = "jp.co.mixi.androidtraining.sns"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = namespace
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.app.versionCode.get().toInt()
        versionName = libs.versions.app.versionName.get()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    dependencies {
        debugImplementation(libs.androidx.compose.tooling)
    }
}
