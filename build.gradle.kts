plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.springframework.boot", "spring-boot", "1.5.20.RELEASE")
    
    testImplementation("junit:junit:4.12")
    testImplementation("org.springframework.boot", "spring-boot-starter-test", "1.5.20.RELEASE")
}
