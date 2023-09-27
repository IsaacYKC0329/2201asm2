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
            JSONObject playerObject = (JSONObject) jsonObject.get("Player");
            JSONObject positionObject = (JSONObject) playerObject.get("position");
            int xObject = Integer.parseInt(positionObject.get("x").toString());
            int yObject = Integer.parseInt(positionObject.get("y").toString());
            Long speedObject = (Long) playerObject.get("speed");
            Long livesObject = (Long) playerObject.get("lives");
            String colorObject = (String) playerObject.get("colour");
            Player player = new Player(new Vector2D(xObject, yObject));
            player.setHealth(livesObject);
            player.setSpeed(speedObject);
            player.setColor(colorObject);
            return player;
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Player buildPlayerFromConfig() {
        return (Player) build();
    }

}
