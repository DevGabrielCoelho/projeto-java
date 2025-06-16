#!/bin/sh

javac --module-path dependencies/javafx --add-modules javafx.controls,javafx.fxml,javafx.web -d out @sources.txt

java --module-path dependencies/javafx --add-modules javafx.controls,javafx.fxml,javafx.web \
  --enable-native-access=ALL-UNNAMED \
  -Djava.library.path=dependencies/javafx \
  -cp out app.App
