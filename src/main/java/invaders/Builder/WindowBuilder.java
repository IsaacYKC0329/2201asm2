package invaders.Builder;

import invaders.engine.GameEngine;
import invaders.engine.GameWindow;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WindowBuilder implements builder{
    private GameEngine gameEngine;
    private static final String CONFIG_PATH = "src/main/resources/config.json";
    public WindowBuilder(GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    @Override
    public Object build() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(CONFIG_PATH);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject windowObject = (JSONObject) jsonObject.get("Game");
            JSONObject sizeObject = (JSONObject) windowObject.get("size");
            int xObject = Integer.parseInt(sizeObject.get("x").toString());
            int yObject = Integer.parseInt(sizeObject.get("y").toString());
            return new GameWindow(this.gameEngine, xObject, yObject);

        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GameWindow buildGameWindowFromConfig() {
        return (GameWindow) build();
    }

}
