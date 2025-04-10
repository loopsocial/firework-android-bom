# Firework Android BoM ![GitHub Release](https://img.shields.io/github/v/release/loopsocial/firework-android-bom?label=GitHub%20Release&color=%2399CC00)

This repository holds the Android Dependencies Bill of Materials - BoM which the Android SDK clients can use.

The Android Dependencies BoM is a Gradle file that defines all the dependencies versions for the client app which is using the Company Android SDKs.
It also includes the Android core modules versions that will be open-sourced at some point.

This is useful to avoid conflicts between SDKs using different core modules or Company/Client apps using a core.

Using the BoM version, the app doesn't need to define the dependencies versions, and it will use the versions defined in the BoM.

## Latest release

```kotlin
val fireworkBomVersion = "2025.04.11"
implementation(platform("com.firework:firework-bom:$fireworkBomVersion"))
```

### Dependencies versions

| Dependency                                        | Version |
|:--------------------------------------------------|:--------|
| com.firework:sdk                                  | 6.18.5  |
| com.firework.external.imageloading:glide          | 6.18.5  |
| com.firework.external.imageloading:picasso        | 6.18.5  |
| com.firework.external.livestream:multiHostPlayer  | 6.18.5  |
| com.firework.external.livestream:singleHostPlayer | 6.18.5  |
| com.firework.core.di:di-core                      | 8.0.0   |
| com.firework.core.di:di-android                   | 8.0.0   |
| com.firework.core:event-bus                       | 7.0.0   |
| com.firework.core:gql                             | 7.0.3   |
| com.firework.core:image-loader                    | 7.0.4   |
| com.firework.core:json                            | 7.0.0   |
| com.firework.core:logger                          | 8.1.0   |
| com.firework.core:motion-sensor                   | 7.0.0   |
| com.firework.core:player                          | 8.3.2   |
| com.firework.core:session-manager                 | 7.0.0   |
| com.firework.core:storage                         | 7.0.1   |
| com.firework.core:utility                         | 7.0.0   |
| com.firework.core:vast-parser                     | 7.0.2   |
| com.firework.core.network:http                    | 7.1.0   |
| com.firework.core.network:web-socket              | 8.1.1   |
