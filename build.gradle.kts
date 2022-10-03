import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    kotlin("jvm") version "1.4.0"
}

allprojects {
    apply {
        plugin("com.github.johnrengelman.shadow")
        plugin("org.jetbrains.kotlin.jvm")
    }

    group = "org.op65n.frcsty"
    version = "3.0.0"

    repositories {
        mavenCentral()

        maven("https://repo.destroystokyo.com/repository/maven-public/")
        maven("https://oss.sonatype.org/content/groups/public/")
        maven("https://jitpack.io/")
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("me.mattstudios.utils:matt-framework:1.4")
        implementation("me.mattstudios.utils:matt-framework-msg:1.1")

        compileOnly("com.destroystokyo.paper:paper-api:1.16.1-R0.1-SNAPSHOT")
    }

    java.sourceCompatibility = JavaVersion.VERSION_1_8
    java.targetCompatibility = JavaVersion.VERSION_1_8

    val libsPath = "org.op65n.frcsty.frozenjoin"

    tasks {
        withType<ShadowJar> {
            relocate("kotlin", "${libsPath}.kotlin")
            relocate("me.mattstudios.mf", "${libsPath}.mf-utils")

            archiveFileName.set("FrozenJoin[${project.name}]-${project.version}.jar")
        }

        processResources {
            filesMatching("*.yml") {
                expand("version" to rootProject.version)
            }
        }

        compileKotlin {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
}