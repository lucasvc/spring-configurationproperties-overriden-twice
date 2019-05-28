plugins {
    java
    application
}

repositories {
    jcenter()
}

val springBootVersion = "1.5.20.RELEASE"
                        // "2.1.5.RELEASE"
dependencies {
    implementation("org.springframework.boot", "spring-boot", springBootVersion)
    
    testImplementation("junit", "junit", "4.12")
    testImplementation("org.springframework.boot", "spring-boot-starter-test", springBootVersion)
}
