// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.3.1"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        allRules = true
        config = files("$rootDir/config/detekt/detekt-config.yml")
        baseline = file("detekt-baseline.xml")
        buildUponDefaultConfig = true
    }
}


group = "com.firework"
version =findProperty("bom-version").toString()
nexusPublishing {
    repositories {
        sonatype {
            // see https://central.sonatype.org/publish/publish-portal-ossrh-staging-api/Add commentMore actions
            nexusUrl = uri( "https://ossrh-staging-api.central.sonatype.com/service/local/" )
            snapshotRepositoryUrl = uri( "https://central.sonatype.com/repository/maven-snapshots/" )
            username = System.getenv( "OSSRH_USERNAME" )
            password = System.getenv( "OSSRH_PASSWORD" )
        }
    }
}
