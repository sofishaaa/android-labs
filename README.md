# 📱 Android Labs — Mobile Application Development

> Practical assignments from the **"Mobile Application Development"** course   
> Environment: **Android Studio** | Language: **Kotlin** | Platform: **Android 17, API 37**

---

## 📂 Repository Structure

| Project | Lab | Topic |
|---------|-----|-------|
| [HelloWorld](./HelloWorld) | Lab 1, 2-3 | Platform overview, first app, emulator setup |
| [TwoActivities](./TwoActivities) | Lab 4-5, 6 | Activity, Intent, lifecycle |
| [HelloToast](./HelloToast) | Lab 7-8 | Interactive UI, Toast, counter |
| [ContactList](./ContactList) | Lab 9 | RecyclerView, CardView, Adapter pattern |
| [Scorekeeper](./Scorekeeper) | Lab 10-12 | Styles, themes, ShapeDrawable |

---

## Projects

### HelloWorld — Lab 1, 2-3
**First Android app with logging**

- ✅ Basic ADB commands (`adb devices`, `adb logcat`)
- ✅ Running on Pixel 10 emulator (Android 17, API 37)
- ✅ Logging via `Log.d()` and Logcat analysis
- ✅ Project structure and Gradle Scripts overview

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d("MainActivity", "onCreate")
    setContent {
        HelloWorldTheme {
            Greeting("Android! from Sofiia Hunkalo")
        }
    }
}
```

---

### TwoActivities — Lab 4-5, 6
**Data transfer between screens + Activity Lifecycle**

- ✅ Two Activities: MainActivity and SecondActivity
- ✅ Data transfer via explicit `Intent` and `Intent Extras`
- ✅ Activity registration in `AndroidManifest.xml`
- ✅ Full lifecycle logging for both Activities
- ✅ State saving via `savedInstanceState`
- ✅ Configuration change handling via `onConfigurationChanged`

```kotlin
// Sending data to SecondActivity
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra(EXTRA_MESSAGE, message)
startActivity(intent)

// Receiving data
val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE) ?: ""
```

**Lifecycle sequence when navigating between Activities:**
```
MainActivity:   onCreate → onStart → onResume
                    ↓ (SEND button pressed)
MainActivity:   onPause → onStop
SecondActivity: onCreate → onStart → onResume
                    ↓ (Back button pressed)
SecondActivity: onPause → onStop → onDestroy
MainActivity:   onRestart → onStart → onResume
```

---

### HelloToast — Lab 7-8
**Interactive UI with buttons and a counter**

- ✅ Two buttons: TOAST and COUNT
- ✅ Toast notification — "Hello Toast!"
- ✅ Counter with state preserved via `remember`
- ✅ Yellow background with large number display (160sp)
- ✅ Built entirely with Jetpack Compose

```kotlin
// Show Toast message
Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show()

// Counter with Compose state
var count by remember { mutableStateOf(0) }
Button(onClick = { count++ }) {
    Text("COUNT")
}
```

---

### ContactList — Lab 9
**Contact list with RecyclerView**

- ✅ `Contact` data model (name, phone, image)
- ✅ `ContactAdapter` with `ViewHolder` pattern
- ✅ Contact cards using `CardView`
- ✅ `LinearLayoutManager` for vertical scrolling list
- ✅ `DividerItemDecoration` between items
- ✅ Toast notification on contact click

```kotlin
recyclerView.layoutManager = LinearLayoutManager(this)
recyclerView.adapter = ContactAdapter(contacts) { contact ->
    Toast.makeText(this, "Selected: ${contact.name}", Toast.LENGTH_SHORT).show()
}
recyclerView.addItemDecoration(
    DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
)
```

---

### Scorekeeper — Lab 10-12
**Score tracking app with themes and styles**

- ✅ Two sets of buttons for two teams
- ✅ `ShapeDrawable` — oval button shapes
- ✅ Custom styles (`ScoreButtons`, `PlusButtons`, `MinusButtons`, `ScoreText`)
- ✅ `DayNight` theme with night mode toggle in menu
- ✅ Score persistence via `onSaveInstanceState`
- ✅ Vector drawable icons (ic_plus, ic_minus)

```xml
<style name="ScoreButtons" parent="Widget.AppCompat.Button">
    <item name="android:background">@drawable/button_background</item>
    <item name="android:tint">@color/colorPrimary</item>
</style>
```

---

## 🛠 Tech Stack

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

| Technology | Usage |
|-----------|-------|
| **Kotlin** | Primary programming language |
| **Jetpack Compose** | Modern declarative UI (Labs 1–9) |
| **Android Views (XML)** | Classic UI layouts (Labs 9–12) |
| **ADB** | Command-line debugging tool |
| **Logcat** | App log analysis |
| **RecyclerView** | Efficient scrollable lists |
| **CardView** | Material Design card containers |
| **Intent** | Data passing between screens |

---

## 📋 Labs Overview

| # | Title | Project | Status |
|---|-------|---------|--------|
| Lab 1 | Mobile Platform Overview & Environment Setup | HelloWorld | ✅ Done |
| Lab 2-3 | Creating a Simple App & Running on Emulator | HelloWorld | ✅ Done |
| Lab 4-5 | Working with Activity and Intent | TwoActivities | ✅ Done |
| Lab 6 | Activity Lifecycle & State Preservation | TwoActivities | ✅ Done |
| Lab 7-8 | Building an Interactive UI | HelloToast | ✅ Done |
| Lab 9 | RecyclerView and CardView | ContactList | ✅ Done |
| Lab 10-12 | Applying Styles and Themes | Scorekeeper | ✅ Done |
