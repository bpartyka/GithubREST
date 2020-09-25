plugins {
    id("org.springframework.boot") version "2.3.1.RELEASE"
    java
}

apply { plugin("io.spring.dependency-management") }

group = "demo"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks {
    named<Test>("test") {
        useJUnitPlatform()
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("junit:junit:4.12")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    // https://mvnrepository.com/artifact/com.github.tomakehurst/wiremock
    testCompile("com.github.tomakehurst:wiremock-standalone:2.27.2")
    compile("org.modelmapper:modelmapper:2.3.3")
}
