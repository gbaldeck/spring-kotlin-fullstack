allprojects {
  group = "io.spring"
  version = "1.0.0-SNAPSHOT"
}

plugins {
  val kotlinVersion = "1.3.70-eap-184"
  val springBootVersion = "2.2.4.RELEASE"
  val springBootDependencyManagementVersion = "1.0.9.RELEASE"
  kotlin("multiplatform") version kotlinVersion apply false
  kotlin("js") version kotlinVersion apply false
  kotlin("jvm") version kotlinVersion apply false
  kotlin("plugin.spring") version kotlinVersion apply false
  kotlin("plugin.jpa") version kotlinVersion apply false
  id("org.springframework.boot") version springBootVersion apply false
  id("io.spring.dependency-management") version springBootDependencyManagementVersion apply false
}
