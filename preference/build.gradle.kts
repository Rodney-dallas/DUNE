plugins {
	id("com.android.library")
	kotlin("android")
	alias(libs.plugins.kotlin.compose)
}

android {
	namespace = "org.jellyfin.preference"
	compileSdk = libs.versions.android.compileSdk.get().toInt()

	defaultConfig {
		minSdk = libs.versions.android.minSdk.get().toInt()
	}

	buildFeatures {
		viewBinding = true
		compose = true
	}

	lint {
		lintConfig = file("$rootDir/android-lint.xml")
		abortOnError = false
	}

	testOptions.unitTests.all {
		it.useJUnitPlatform()
	}
}

dependencies {
	// Kotlin
	implementation(libs.kotlinx.coroutines)

	// Logging
	implementation(libs.timber)

	// Compose
	implementation(libs.bundles.androidx.compose)
	implementation("androidx.compose.ui:ui")
	implementation("androidx.compose.ui:ui-tooling-preview")
	implementation("androidx.compose.material:material:1.5.0")
	implementation("androidx.compose.material:material-icons-core:1.5.0")
	implementation("androidx.compose.material:material-icons-extended:1.5.0")
	debugImplementation("androidx.compose.ui:ui-tooling")

	// Testing
	testImplementation(libs.kotest.runner.junit5)
	testImplementation(libs.kotest.assertions)
	testImplementation(libs.mockk)
}
