plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.chloehouse.mopriongame"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chloehouse.mopriongame"
        minSdk = 24
        targetSdk = 34
        versionCode = 6
        versionName = "6.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    //noinspection UseTomlInstead
    implementation ("com.airbnb.android:lottie-compose:6.6.2")
    //noinspection UseTomlInstead
    implementation ("com.daimajia.androidanimations:library:2.4@aar")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}