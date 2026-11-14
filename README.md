# Android and Kotlin samples

Three small Android apps and a Kotlin/JVM coroutine example. Each folder is a standalone Gradle project.

| Sample | What it demonstrates |
| --- | --- |
| [RecyclerExp](RecyclerExp/) | A RecyclerView adapter and opening a detail screen from an item click. |
| [NavigationDrawer2](NavigationDrawer2/) | A navigation drawer that switches between fragments and handles back navigation. |
| [UnitConvert](UnitConvert/) | Converting decimal inches to centimeters and handling invalid input. |
| [KotlinCoroutines](KotlinCoroutines/) | Starting concurrent work with `async`, collecting results with `await`, and waiting for cleanup with `cancelAndJoin`. |

## Android apps

Open an app folder in Android Studio with JDK 17 and the Android 36 SDK. Select the `app` run configuration and an emulator or device running Android 11 (API 30) or newer. To build a debug APK from that folder, run `./gradlew :app:assembleDebug`.

## Kotlin coroutines

From the repository root, run the sample with JDK 17.

```sh
cd KotlinCoroutines
./gradlew run
```

The program prints both asynchronous results, starts a background task, and prints the task's cleanup message before reporting that cancellation is complete. The example was adapted from [KotlinRepostBase](https://github.com/jedicode11/KotlinRepostBase/tree/465dc119b23c5d7e9c648cfc99c8d70c6707aeb5/KotlinCoroutines/KotlinCoroutines/src/main/kotlin).
