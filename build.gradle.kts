plugins {
    kotlin("jvm") version "1.5.31"
    id("org.springframework.boot") version "2.5.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("jacoco")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("net.snowflake:snowflake-jdbc:3.15.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.12.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("junit:junit:4.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("org.jacoco:org.jacoco.core:0.8.7")
    testImplementation ("org.mockito:mockito-junit-jupiter:3.12.4")

}


tasks.test {
    useJUnitPlatform()
}
tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
    println("dwdwdw")
    dependsOn(tasks.test)
            classDirectories.setFrom(
                    files(classDirectories.files.map {
                        fileTree(it).apply {
                            exclude(
                                    "com/baeldung//ExcludedPOJO.class",
                                    "com/baeldung//DTO.",
                                    "**/config/*",
                                    "**/generated/**"

                            )
                        }
                    }))
//    }

}
jacoco {
    toolVersion = "0.8.11"

}