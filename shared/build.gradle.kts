plugins {
  kotlin("multiplatform")
  id("org.springframework.boot")
  id("io.spring.dependency-management")
}

repositories {
  maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev/") }
  maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
  mavenCentral()
  jcenter()
}

kotlin {
  jvm()
  js {
    browser()
    nodejs()
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation(kotlin("stdlib-common"))
      }
    }
    commonTest {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }
    getByName("jvmMain").apply {
      dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.springframework.boot:spring-boot-starter-mustache")
//        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
      }
    }
    getByName("jvmTest").apply {
      dependencies {
        implementation(kotlin("test"))
        implementation(kotlin("test-junit"))
      }
    }
    getByName("jsMain").apply {
      dependencies {
        implementation(kotlin("stdlib-js"))
      }
    }
    getByName("jsTest").apply {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}