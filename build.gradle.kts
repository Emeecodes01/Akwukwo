// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Config.ClassPaths.androidGradlePlugin)
        classpath(Config.ClassPaths.kotlinGradlePlugin)
        classpath(Config.ClassPaths.safeArgs)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}