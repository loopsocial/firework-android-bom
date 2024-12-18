plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
    id("maven-publish")
    signing
}

bomGenerator {
    // region Firework SDK
    val fireworkSdkVersion = "6.16.2"
    includeDependency("com.firework", "sdk", fireworkSdkVersion)

    includeDependency("com.firework.external.imageloading", "glide", fireworkSdkVersion)
    includeDependency("com.firework.external.imageloading", "picasso", fireworkSdkVersion)
    includeDependency("com.firework.external.livestream", "multiHostPlayer", fireworkSdkVersion)
    includeDependency("com.firework.external.livestream", "singleHostPlayer", fireworkSdkVersion)
    // endregion

    // region Core
    includeDependency("com.firework.core.di", "di-core", "8.0.0")
    includeDependency("com.firework.core.di", "di-android", "8.0.0")
    includeDependency("com.firework.core", "event-bus", "7.0.0")
    includeDependency("com.firework.core", "gql", "7.0.3")
    includeDependency("com.firework.core", "image-loader", "7.0.4")
    includeDependency("com.firework.core", "json", "7.0.0")
    includeDependency("com.firework.core", "logger", "8.1.0")
    includeDependency("com.firework.core", "motion-sensor", "7.0.0")
    includeDependency("com.firework.core", "player", "8.3.2")
    includeDependency("com.firework.core", "session-manager", "7.0.0")
    includeDependency("com.firework.core", "storage", "7.0.1")
    includeDependency("com.firework.core", "utility", "7.0.0")
    includeDependency("com.firework.core", "vast-parser", "7.0.2")
    includeDependency("com.firework.core.network", "http", "7.1.0")
    includeDependency("com.firework.core.network", "web-socket", "8.1.1")
    // endregion
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")
    val signingSecretKey = System.getenv("GPG_SIGNING_SECRET_KEY")
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")
    useInMemoryPgpKeys(signingKeyId, signingSecretKey, signingPassword)
}

publishing {
    publications {
        val publication = create<MavenPublication>("signedRelease") {
            configurePublication()
            configurePom()
        }
        signing.sign(publication)

        create<MavenPublication>("unsignedRelease") {
            configurePublication()
            configurePom()
        }

        repositories {
            maven {
                configureUrl()
                configureCredentials()
            }
        }
    }
}

fun MavenPublication.configurePublication() {
    groupId = "com.firework"
    artifactId = "firework-bom"
    version = "2024.12.18"
}

fun MavenPublication.configurePom() {
    pom {
        name.set("Android BOM")
        description.set("Firework Android BOM")
        url.set("https://firework.com")

        configureLicense()

        configureDeveloper()

        configureScm()
    }
}

fun MavenPom.configureLicense() {
    licenses {
        license {
            name.set("The Apache License, Version 2.0")
            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        }
    }
}

fun MavenPom.configureDeveloper() {
    developers {
        developer {
            id.set("Firework")
            name.set("Firework Android Team")
            email.set("team-android@fireworkhq.com")
        }
    }
}

fun MavenPom.configureScm() {
    scm {
        url.set("https://github.com/loopsocial/android-bom")
        connection.set("scm:git:git@github.com:loopsocial/android-bom.git")
        developerConnection.set("scm:git:git@github.com:loopsocial/android-bom.git")
    }
}

fun MavenArtifactRepository.configureUrl() {
    val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
    val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"

    val isSnapshot = false

    val repoUrl = if (isSnapshot) snapshotsRepoUrl else releasesRepoUrl

    setUrl(repoUrl)
}

fun MavenArtifactRepository.configureCredentials() {
    credentials {
        username = System.getenv("OSSRH_USERNAME")
        password = System.getenv("OSSRH_PASSWORD")
    }
}
