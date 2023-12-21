# Android BoM ![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.firework/firework-bom/badge.svg)

This repository holds Android Dependencies Bill of Materials - BoM which is required by the company/client Android Apps.

The Android Dependencies BoM is a Gradle file that defines all the dependencies versions for the client app which is using the Company Android SDKs.
It also includes the Android core modules versions that are going to be open-sourced at some point.

This is useful to avoid conflicts between SDKs using different core modules or Company/Client apps using a core.

By using the BoM version, the app doesn't need to define the dependencies versions, and it will use the versions defined in the BoM.

## Latest release

```kotlin
implementation(platform("androidx.compose:compose-bom:2023.11.01"))
```

### Dependencies versions

| Dependency                                        | Version  |
| :------------------------------------------------ |:---------|
| com.firework:sdk                                  | 6.8.0    |
| com.firework.external.imageloading:glide          | 6.8.0    |
| com.firework.external.imageloading:picasso        | 6.8.0    |
| com.firework.external.livestream:multiHostPlayer  | 6.8.0    |
| com.firework.external.livestream:singleHostPlayer | 6.8.0    |
| com.firework.android.exoplayer:exoplayer-core     | 2.16.1.6 |
| com.firework.android.exoplayer:exoplayer-hls      | 2.16.1.6 |
| com.firework.android.exoplayer:exoplayer-ui       | 2.16.1.6 |
| com.firework.android.exoplayer:extension-ima      | 2.16.1.6 |
| com.firework.core:event-bus                       | 7.0.0    |
| com.firework.core:gql                             | 7.0.2    |
| com.firework.core:image-loader                    | 7.0.4    |
| com.firework.core:json                            | 7.0.0    |
| com.firework.core:logger                          | 8.1.0    |
| com.firework.core:motion-sensor                   | 7.0.0    |
| com.firework.core:player                          | 8.0.6    |
| com.firework.core:session-manager                 | 7.0.0    |
| com.firework.core:storage                         | 7.0.1    |
| com.firework.core:utility                         | 7.0.0    |
| com.firework.core:vast-parser                     | 7.0.1    |
| com.firework.core.network:http                    | 7.1.0    |
| com.firework.core.network:web-socket              | 8.0.1    |
