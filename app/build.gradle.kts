plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.moviekotlin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.moviekotlin"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // rxjava
    implementation("io.reactivex.rxjava2:rxjava:2.2.9")
    // rx with retrofit
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    // rxAndroid
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    // ssp
    implementation("com.intuit.ssp:ssp-android:1.1.0")
    // sdp
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    //room
    val room_version = "2.6.0"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:$room_version")
    
    
    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // gson
    implementation("com.google.code.gson:gson:2.9.0")

}
