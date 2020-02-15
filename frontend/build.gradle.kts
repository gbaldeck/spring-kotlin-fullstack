import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
  kotlin("js")
}

repositories {
  maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev/") }
  maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
  maven { url = uri("https://kotlin.bintray.com/kotlinx") }
  maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
  mavenCentral()
  jcenter()
}

kotlin {
  target {
    browser {
      runTask {
        devServer = KotlinWebpackConfig.DevServer(
          open = false,
          port = 3000,
          proxy = mapOf("/api/*" to "http://localhost:8080"),
          contentBase = listOf("$buildDir/distributions")
        )
      }
    }

    sourceSets {
      main {
        dependencies {
          implementation(kotlin("stdlib-js"))
          implementation(project(":shared"))
        }
      }
    }
  }
}
