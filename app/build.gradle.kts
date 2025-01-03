plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "io.furios.launcher"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.furios.launcher"
        minSdk = 32
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        resourceConfigurations.add("en")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isJniDebuggable = false
            isRenderscriptDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    packaging {
        resources {
            excludes += listOf(
                "META-INF/**",
                "kotlin/**",
                "**.bin",
                "res/mipmap*/**",
                "res/drawable*/**",
                "res/values*/**",
                "!res/values/strings.xml"
            )
        }
    }
}