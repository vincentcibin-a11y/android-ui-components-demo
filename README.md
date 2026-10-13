# Android UI Components & Storage Demo

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

A clean, modern Android application demonstrating 6 core Android UI widgets and persistence concepts in a single cohesive project.

---

## 📱 Demonstrated Components

| Component | Usage in Project |
|---|---|
| 📋 **Options Menu** | Inflated in `Toolbar` with actions to save or clear saved preferences. |
| 🔽 **Spinner** | Dropdown selection menu populated with an `ArrayAdapter`. |
| 🌉 **ArrayAdapter** | Bridges raw string arrays to both `Spinner` and `ListView` items. |
| 📜 **ListView** | Scrollable list displaying items with interactive `Toast` click listeners. |
| 🖼️ **ImageView** | Displays image resources in the layout (`ic_launcher`). |
| 💾 **SharedPreferences** | Persists and loads user choices across app launches. |

---

## 🛠️ Project Structure

```
app/src/main/
├── java/com/example/menu/
│   └── MainActivity.java        # Core activity logic (Menu, Adapters, Storage)
└── res/
    ├── layout/
    │   └── activity_main.xml    # Screen layout (Toolbar, ImageView, Spinner, ListView)
    ├── menu/
    │   └── main_menu.xml        # Options menu actions (Save, Clear)
    └── values/
        └── strings.xml          # Translatable text resources
```

---

## 🚀 Getting Started

### Prerequisites
* **Android Studio** Jellyfish or newer
* **JDK**: 17+
* **Target SDK**: 35 (Android 15)
* **Min SDK**: 24 (Android 7.0)

### Building & Running
1. Clone the repository:
   ```bash
   git clone https://github.com/vincentcibin-a11y/android-ui-components-demo.git
   ```
2. Open the project in **Android Studio**.
3. Let Gradle sync and build the project.
4. Select an emulator or connected physical device, then click **Run** (`▶` / `Shift + F10`).

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
