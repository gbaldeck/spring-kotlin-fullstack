pluginManagement {
  repositories {
    maven(url = "https://dl.bintray.com/kotlin/kotlin-dev/")
    gradlePluginPortal()
    jcenter()
    mavenCentral()
//		maven("https://repo.spring.io/milestone")
  }
  resolutionStrategy {
    eachPlugin {
      if (requested.id.id == "org.springframework.boot") {
        useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
      }
    }
  }
}

include("frontend", "backend", "shared")