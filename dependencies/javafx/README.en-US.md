# 📦 JavaFX SDK Setup

This guide explains how to download the **JavaFX SDK**, extract it, and place its required files into the correct directory for this project.

## 🔽 1. Download JavaFX SDK

Go to the official [JavaFX Downloads page](https://gluonhq.com/products/javafx/) and download the SDK version that matches your system:

* Windows: `javafx-sdk-[version]-windows.zip`
* Linux: `javafx-sdk-[version]-linux.zip`
* macOS: `javafx-sdk-[version]-macos.zip`

> 📌 **Recommended version:** JavaFX 24.0.1

---

## 📂 2. Extract the SDK

After downloading, extract the contents of the `.zip` file to a temporary folder.

Example (Linux/macOS terminal):

```bash
unzip openjfx-24.0.1_linux-x64_bin-sdk.zip -d ~/Downloads/
```

The extracted folder will look like this:

```
openjfx-24.0.1_linux-x64_bin-sdk/
├── legal/
├── lib/             ← we need this folder
└── README.md
```

---

## 🚚 3. Copy `lib/` to `dependencies/javafx/`

Now copy all contents from the `lib/` directory into the project's `dependencies/javafx` folder.

Example using terminal:

```bash
mkdir -p dependencies/javafx
cp -r ~/Downloads/openjfx-24.0.1_linux-x64_bin-sdk/lib/* dependencies/javafx/
```

Or using GUI (File Explorer):

1. Open the extracted `openjfx-24.0.1_linux-x64_bin-sdk/lib/` folder.
2. Select all files inside.
3. Copy and paste them into your project's `dependencies/javafx/` folder.

After that, your project folder should look like:

```
dependencies/
└── javafx/
    ├── javafx.base.jar
    ├── javafx.controls.jar
    ├── javafx.fxml.jar
    ├── javafx.graphics.jar
    └── ... (other JavaFX modules)
```

---

## ✅ Done!

Now you're ready to build and run the project with JavaFX support:

```bash
chmod +x build.sh
./build.sh
```

> 💡 If you get module errors, double-check that all necessary files are present in `dependencies/javafx`.