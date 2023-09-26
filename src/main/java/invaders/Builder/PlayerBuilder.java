package invaders.Builder;

import invaders.engine.GameWindow;
import invaders.entities.Player;
import invaders.physics.Vector2D;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class PlayerBuilder implements builder{
    private static final String CONFIG_PATH = "src/main/resources/config.json";
    @Override
    public Object build() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(CONFIG_PATH);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject windowObject = (JSONObject) jsonObject.get("Player");
            JSONObject positionObject = (JSONObject) windowObject.get("position");
            int xObject = Integer.parseInt(positionObject.get("x").toString());
            int yObject = Integer.parseInt(positionObject.get("y").toString());
            return new Player(new Vector2D(xObject, yObject));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Player buildPlayerFromConfig() {
        return (Player) build();
    }

}
