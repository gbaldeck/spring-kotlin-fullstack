import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  kotlin("plugin.spring")
  kotlin("plugin.jpa")
  war
  id("org.springframework.boot")
  id("io.spring.dependency-management")
}

repositories {
  maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev/") }
  maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
  maven { url = uri("https://kotlin.bintray.com/kotlinx") }
  mavenCentral()
  jcenter()
}

val developmentOnly by configurations.creating
configurations {
  runtimeClasspath {
    extendsFrom(developmentOnly)
  }
}

dependencies {
  val coroutinesVersion = "1.3.3"
//  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-mustache")
//  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$coroutinesVersion")
  implementation(project(":shared"))
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  runtimeOnly("org.postgresql:postgresql")
  providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}

tasks {
  withType<Test> {
    useJUnitPlatform()
  }

  withType<KotlinCompile> {
    kotlinOptions {
      jvmTarget = "1.8"
      freeCompilerArgs = listOf("-Xjsr305=strict")
    }
  }
  processResources {
    dependsOn(":frontend:browserWebpack")
    from(project(":frontend").projectDir.resolve("src/main/resources")) {
      into("static")
    }
    from(project(":frontend").buildDir.resolve("distributions/frontend.js")) {
      into("static")
    }
  }
}
