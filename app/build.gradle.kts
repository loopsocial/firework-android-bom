plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.firework.bom.demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.firework.bom.demo"

        minSdk = 21
        targetSdk = 34

        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Firework SDK
    implementation(platform("com.firework:firework-bom:2024.02.07"))
    // implementation("com.firework:sdk")

    // implementation("com.firework.external.imageloading:glide")
    // implementation("com.firework.external.imageloading:picasso")
    // implementation("com.firework.external.livestream:singleHostPlayer")
    // implementation("com.firework.external.livestream:multiHostPlayer")

    // ExoPlayer
    implementation("com.firework.android.exoplayer:exoplayer-core")
    implementation("com.firework.android.exoplayer:exoplayer-hls")
    implementation("com.firework.android.exoplayer:exoplayer-ui")
    implementation("com.firework.android.exoplayer:extension-ima")

    // Core
    implementation("com.firework.core.network:http")
    implementation("com.firework.core.network:web-socket")
    implementation("com.firework.core:event-bus")
    implementation("com.firework.core:gql")
    implementation("com.firework.core:image-loader")
    implementation("com.firework.core:json")
    implementation("com.firework.core:logger")
    implementation("com.firework.core:motion-sensor")
    implementation("com.firework.core:player")
    implementation("com.firework.core:session-manager")
    implementation("com.firework.core:storage")
    implementation("com.firework.core:utility")
    implementation("com.firework.core:vast-parser")
}
