package app;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import javafx.concurrent.Worker;
import netscape.javascript.JSObject;
import controller.MainController;
import controller.CronController;

public class App extends Application {
    private WebView webView;
    private WebEngine engine;
    private MainController controller = new MainController();

    @Override
    public void start(Stage primaryStage) {
        webView = new WebView();
        engine = webView.getEngine();
        controller.setEngine(engine);

        engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                controller.injectJavaScriptBridge();
            }
        });

        Scene scene = new Scene(webView, 1920, 1080);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Assistência Técnica");
        primaryStage.show();

        controller.loadHtmlWithData();
        
        CronController cron = new CronController();
        cron.startDailySchedule(LocalTime.now(), controller.getGuarantee());
    }

    public static void main(String[] args) {
        System.setProperty("javafx.embed.singleThread", "true");
        launch(args);
    }
}