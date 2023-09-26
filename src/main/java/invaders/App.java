package invaders;

import invaders.Builder.WindowBuilder;
import javafx.application.Application;
import javafx.stage.Stage;
import invaders.engine.GameEngine;
import invaders.engine.GameWindow;

import java.util.Map;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Map<String, String> params = getParameters().getNamed();

        GameEngine model = new GameEngine("/resources/config.json");
        WindowBuilder wb = new WindowBuilder(model);
        GameWindow window = wb.buildGameWindowFromConfig();
        window.run();

        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(window.getScene());
        primaryStage.show();

        window.run();
    }
}
