plugins {
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.13"
    id("org.beryx.jlink") version "2.12.0"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(19))
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.32")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.controlsfx:controlsfx:11.1.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

javafx {
    version = "19"
    modules = listOf("javafx.controls", "javafx.fxml")
}

jlink{
    launcher {
        name = "skooo"
    }
    imageZip.set(project.file("${project.buildDir}/image-zip/skooo-image.zip"))
}

application {
    mainClass.set("com.example.MainApp")
}