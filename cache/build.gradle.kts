import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}


android {
    compileSdkVersion(Config.Versions.compileSdkVer)
    buildToolsVersion(Config.Versions.buildToolsVer)

    defaultConfig {
        minSdkVersion(Config.Versions.minSdk)
        targetSdkVersion(Config.Versions.targetSdk)
        versionCode = Config.Versions.versionCode
        versionName = Config.Versions.versionName

        testInstrumentationRunner = Config.Android.testRunner
        consumerProguardFiles("consumer-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments (
                    mapOf (
                        "room.schemaLocation" to "$projectDir/schemas",
                        "room.incremental" to "true")
                )
            }
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-logic.pro")
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    tasks.withType <KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude ("META-INF/notice.txt")
        exclude ("META-INF/ASL2.0")
        exclude ("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/*.kotlin_module")
    }

}

dependencies {
    cache()
}