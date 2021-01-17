import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

const val kotlinVersion = "1.4.21"
const val gradle = "4.1.1"

object Config {
    object Versions {
        const val compileSdkVer = 30
        const val buildToolsVer = "30.0.2"
        const val minSdk = 21
        const val targetSdk = 30
        const val versionCode = 1
        const val versionName = "v1.0.0"
    }

    object Android {
        const val applicationId = "com.mobigods.akwkw"
        const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    object ClassPaths {
        const val androidGradlePlugin = "com.android.tools.build:gradle:$gradle"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${AkwukwoDependencies.Navigation.Version.navVersion}"
    }

}

object TestDependencies {

    object Versions {
        const val mockk = "1.9.3"
        const val konveyor = "1.0.3"
        const val coroutineTest = "1.4.2"
        const val junitVersion = "4.13.1"
        const val androidJunit = "1.1.2"
        const val espressoCore = "3.3.0"
        const val annotation = "1.1.0"
        const val truth = "1.0.1"
    }

    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val konveyor = "com.github.vacxe:konveyor:${Versions.konveyor}"
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTest}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
}


object AkwukwoDependencies {

    object AndroidX {
        object Versions {
            const val coreKtx = "1.3.2"
            const val appCompact = "1.2.0"
            const val activityExt = "1.2.0-beta01"
            const val fragmentExt = "1.3.0-beta01"
        }

        const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appCompact = "androidx.appcompat:appcompat:${Versions.appCompact}"
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
        const val activityExtLib = "androidx.activity:activity-ktx:${Versions.activityExt}"
        const val fragmentExt = "androidx.fragment:fragment-ktx:${Versions.fragmentExt}"
    }


    object UILibs {
        object Versions {
            const val materialDesignComps = "1.2.1"
            const val constraintLayout = "2.0.4"
            const val rvAnimator = "4.0.1"
        }
        const val materialDesign = "com.google.android.material:material:${Versions.materialDesignComps}"
        const val constraintLayoutDep = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val recyclerViewAnimator = "jp.wasabeef:recyclerview-animators:${Versions.rvAnimator}"
    }

    object Persistence {
        object Versions {
            const val roomVersion = "2.2.5"
        }

        const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomExt = "androidx.room:room-ktx:${Versions.roomVersion}"
    }

    object DependencyInjection {
        object Version {
            const val daggerVersion = "2.29.1"
        }

        const val dagger = "com.google.dagger:dagger:${Version.daggerVersion}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.daggerVersion}"
        const val daggerAndroid = "com.google.dagger:dagger-android:${Version.daggerVersion}"
        const val daggerSupportLibs = "com.google.dagger:dagger-android-support:${Version.daggerVersion}"
        const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Version.daggerVersion}"
    }


    object Async {
        object Version {
            const val coroutines = "1.4.0"
        }
        const val ktCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val ktCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    }

    object Architecture {
        object Version {
            const val viewModelVersion = "2.2.0"
        }

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Version.viewModelVersion}"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewModelVersion}"
    }


    object Navigation {
        object Version {
            const val navVersion = "2.3.1"
        }

        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navVersion}"
        const val navUI = "androidx.navigation:navigation-ui-ktx:${Version.navVersion}"
        const val navFeatureModule = "androidx.navigation:navigation-dynamic-features-fragment:${Version.navVersion}"
    }

    object Play {
        object Version {
            const val playCore = "1.8.3"
            const val playCoreKtx = "1.8.1"
        }
        const val playCore = "com.google.android.play:core:${Version.playCore}"
        const val playCoreKtx = "com.google.android.play:core-ktx:${Version.playCoreKtx}"
    }


    object ExoPlayer {
        object Version {
            const val exoPlayerVersion = "2.12.3"
        }
        const val exoCore = "com.google.android.exoplayer:exoplayer-core:${Version.exoPlayerVersion}"
        const val exoUI = "com.google.android.exoplayer:exoplayer-ui:${Version.exoPlayerVersion}"
        const val exoStreaming = "com.google.android.exoplayer:exoplayer-smoothstreaming:${Version.exoPlayerVersion}"
    }


    object Api {
        object Version {
            const val retrofit = "2.9.0"
            const val okhttpInterceptor = "4.9.0"
            const val gson = "2.8.6"
            const val gsonConverter = "2.9.0"
        }

        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttpInterceptor}"
        const val gson = "com.google.code.gson:gson:${Version.gson}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.gsonConverter}"
    }

}


/**
 * Module dependencies block
 */
fun DependencyHandler.domain() {
    add("implementation", AkwukwoDependencies.AndroidX.kotlinStdlib)
    coroutines()
    dagger()
    unitTestDeps()
}

fun DependencyHandler.core() {
    add("implementation", AkwukwoDependencies.AndroidX.kotlinStdlib)
    add("api", AkwukwoDependencies.UILibs.materialDesign)
    add("implementation", "cc.cloudist.acplibrary:library:1.2.1")
    add("api", project(":domain"))
    androidX()
    dagger()
    androidUITestDeps()
    unitTestDeps()
    navigationComponent()
}

fun DependencyHandler.remote() {
    add("implementation", AkwukwoDependencies.AndroidX.kotlinStdlib)
    //add("implementation", project(":domain"))
    add("implementation", project(":core"))
    network()
    coroutines()
    dagger()
    unitTestDeps()
}


fun DependencyHandler.cache() {
    add("implementation", AkwukwoDependencies.AndroidX.kotlinStdlib)
    //add("implementation", project(":domain"))
    add("implementation", project(":core"))
    room()
    dagger()
}

fun DependencyHandler.presentation() {
    add("implementation", AkwukwoDependencies.AndroidX.kotlinStdlib)
    add("implementation", project(":core"))
    //add("implementation", project(":domain"))
    archComponent()
    dagger()
    unitTestDeps()
}


fun DependencyHandler.mobileUI() {
    add("implementation", AkwukwoDependencies.AndroidX.kotlinStdlib)
    add("implementation", AkwukwoDependencies.UILibs.materialDesign)
    add("implementation", AkwukwoDependencies.UILibs.constraintLayoutDep)
    add("implementation", AkwukwoDependencies.UILibs.recyclerViewAnimator)
    add("implementation", project(":core"))
    add("implementation", project(":presentation"))
    add("implementation", project(":remote"))
    add("implementation", project(":cache"))
    archComponent()
    dagger()
    unitTestDeps()
    androidUITestDeps()
    daggerAndroid()
    androidX()
}


fun DependencyHandler.player() {
    add("implementation", AkwukwoDependencies.AndroidX.kotlinStdlib)
    add("implementation", AkwukwoDependencies.UILibs.materialDesign)
    add("implementation", AkwukwoDependencies.UILibs.constraintLayoutDep)
    add("implementation", project(":core"))
    exoplayer()
    unitTestDeps()
    androidUITestDeps()
    androidX()
}

/**
 * Library dependencies block
 */
fun DependencyHandler.dagger() {
    add("api", AkwukwoDependencies.DependencyInjection.dagger)
    add("kapt", AkwukwoDependencies.DependencyInjection.daggerCompiler)
}


fun DependencyHandler.coroutines() {
    add("implementation", AkwukwoDependencies.Async.ktCoroutines)
    add("implementation", AkwukwoDependencies.Async.ktCoroutinesAndroid)
}

fun DependencyHandler.network() {
    add("api", AkwukwoDependencies.Api.retrofit)
    add("api", AkwukwoDependencies.Api.okhttpInterceptor)
    add("api", AkwukwoDependencies.Api.gson)
    add("api", AkwukwoDependencies.Api.gsonConverter)

}

fun DependencyHandler.navigationComponent() {
    add("api", AkwukwoDependencies.Navigation.navFragment)
    add("api", AkwukwoDependencies.Navigation.navUI)
    add("api", AkwukwoDependencies.Navigation.navFeatureModule)
}

fun DependencyHandler.daggerAndroid() {
    add("implementation", AkwukwoDependencies.DependencyInjection.dagger)
    add("implementation", AkwukwoDependencies.DependencyInjection.daggerAndroid)
    add("implementation", AkwukwoDependencies.DependencyInjection.daggerSupportLibs)
    add("kapt", AkwukwoDependencies.DependencyInjection.daggerCompiler)
    add("kapt", AkwukwoDependencies.DependencyInjection.daggerAndroidProcessor)
}


fun DependencyHandler.androidX(){
    add("implementation", AkwukwoDependencies.AndroidX.appCompact)
    add("implementation", AkwukwoDependencies.AndroidX.core)
    add("implementation", AkwukwoDependencies.AndroidX.activityExtLib)
}


fun DependencyHandler.androidUITestDeps() {
    add("androidTestImplementation", TestDependencies.androidJunit)
    add("androidTestImplementation", TestDependencies.espresso)
    add("androidTestImplementation", TestDependencies.annotation)
}

fun DependencyHandler.archComponent() {
    add("api", AkwukwoDependencies.Architecture.viewModel)
    add("api", AkwukwoDependencies.Architecture.viewModelKtx)
}


fun DependencyHandler.room() {
    add("api", AkwukwoDependencies.Persistence.room)
    add("api", AkwukwoDependencies.Persistence.roomExt)
    add("implementation", AkwukwoDependencies.Api.gson)
    add("kapt", AkwukwoDependencies.Persistence.roomCompiler)
}

fun DependencyHandler.unitTestDeps() {
    add("testImplementation", TestDependencies.konveyor)
    add("testImplementation", TestDependencies.mockk)
    add("testImplementation", TestDependencies.junit)
    add("testImplementation", TestDependencies.coroutineTest)
    add("testImplementation", TestDependencies.truth)
}

fun DependencyHandler.exoplayer() {
    add("implementation", AkwukwoDependencies.ExoPlayer.exoCore)
    add("implementation", AkwukwoDependencies.ExoPlayer.exoUI)
    add("implementation", AkwukwoDependencies.ExoPlayer.exoStreaming)
}