# Java Technical Assistance System

A modular Java desktop application built with JavaFX, following the MVC (Model-View-Controller) architecture. The system allows users to manage client services, devices, warranties, and present the data in an interactive HTML interface.

## 🛠️ Features

* **Service Order Management**: Manage clients, devices, service details, and warranty status.
* **Data Simulation**: Generates realistic mock data for demonstration and testing.
* **Integrated Web View**: Displays a paginated and styled HTML table using Bootstrap 5.
* **Modular Structure**: Divided into `app`, `controller`, `model`, and `view` layers for clarity and scalability.
* **Responsive UI**: The HTML interface adapts to various screen sizes and offers modern UI elements.
* **Modal Pop-ups**: Dynamically opens detail views and optionally notifies the user.
* **Cross-Language Communication**: Java ↔ JavaScript interaction using `JSObject`.

## 📋 Prerequisites

* **Java JDK 22+**
* **JavaFX SDK** (make sure the contents of the `lib` folder from the JavaFX SDK are copied into `dependencies/javafx`)
* (Optional) Modern IDE like IntelliJ or VS Code with Java support

## 🚀 Installation & Execution

1. **Clone the repository:**

   ```bash
   git clone https://github.com/DevGabrielCoelho/projeto-java.git
   cd projeto-java
   ```

2. **Run using the shell script (recommended on Unix-based systems):**

   ```bash
   chmod +x build.sh
   ./build.sh
   ```

3. **Or compile and run manually:**

   ```bash
   javac --module-path dependencies/javafx --add-modules javafx.controls,javafx.fxml,javafx.web -d out @sources.txt

   java --module-path dependencies/javafx --add-modules javafx.controls,javafx.fxml,javafx.web \
     --enable-native-access=ALL-UNNAMED \
     -Djava.library.path=dependencies/javafx \
     -cp out app.App
   ```

## 🌐 Interface Overview

The application renders an HTML page (`view/page.html`) styled with Bootstrap. It features:

* Tabs for navigation between service and history.
* Paginated tables of service orders.
* Dynamic modal displaying detailed information.
* JavaScript support for triggering actions and callbacks from Java.

## 📂 Project Structure

```
src/
├── app/
│   └── App.java                  # Entry point with WebView integration
├── controller/
│   ├── MainController.java       # Core logic for data generation
│   ├── WebController.java        # Bridges Java <-> JavaScript interactions
│   └── CronController.java       # Scheduled or auxiliary tasks
├── model/
│   ├── Client.java
│   ├── DataFactory.java          # Generates mock data
│   ├── Device.java
│   ├── Guarantee.java
│   ├── Service.java
│   └── Type.java
├── view/
│   └── page.html                 # Responsive HTML interface
build.sh                          # Build and run script
sources.txt                       # Java file list for compilation
```

## 🧪 Main Classes Summary

* **App.java** – Sets up the JavaFX WebView and loads the HTML UI.
* **WebController.java** – Provides Java methods accessible from JavaScript (`notifyUser`, `loadHtmlWithData`).
* **MainController.java** – Orchestrates data generation via `DataFactory`.
* **CronController.java** – Reserved for timed or automated routines.
* **DataFactory.java** – Populates lists of Clients, Devices, Types, and Services.

## 📌 Notes

* The HTML uses placeholders like `%responsive-clients-tbody%`, `%client-total-items%`, which are replaced via JavaScript logic with data fetched from the Java backend.
* JavaScript functions within the HTML trigger native Java methods via `window.app`.

## 🛠️ Technologies Used

* **Java 22+**
* **JavaFX (WebView, FXML)**
* **HTML5, Bootstrap 5, Material Icons**
* **Shell Script (build automation)**

## Additional Documentation

- [JavaFX SDK Setup](dependencies/javafx/README.en-US.md)
- [Logs Guide](logs/README.en-US.md)

## 📞 Contact

For questions, suggestions, or contributions:

* **Gabriel Coelho**
* GitHub: [DevGabrielCoelho](https://github.com/DevGabrielCoelho)
* Email: [gabriel.coelhosousasantos.pv@gmail.com](mailto:gabriel.coelhosousasantos.pv@gmail.com)