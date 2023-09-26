package invaders.Builder;

import invaders.entities.Bunker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import invaders.physics.Vector2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BunkerBuilder implements builder {
    private Vector2D position;
    private Vector2D size;
    private static final String CONFIG_PATH = "src/main/resources/config.json";

    public void setPositions(int x, int y) {
        this.position = new Vector2D(x, y);
    }

    public void setSize(int x, int y) {
        this.size = new Vector2D(x, y);
    }

    @Override
    public Object build() {
        return new Bunker(position, size);
    }

    public ArrayList<Bunker> buildBunkersFromConfig() {
        ArrayList<Bunker> bunkers = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(CONFIG_PATH);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray bunkerArray = (JSONArray) jsonObject.get("Bunkers");

            for (int i = 0; i < bunkerArray.size(); i++) {
                JSONObject bunkerObj = (JSONObject) bunkerArray.get(i);
                JSONObject positionObj = (JSONObject) bunkerObj.get("position");
                JSONObject sizeObj = (JSONObject) bunkerObj.get("size");
                setPositions(((Long) positionObj.get("x")).intValue(), ((Long) positionObj.get("y")).intValue());
                setSize(((Long) sizeObj.get("x")).intValue(), ((Long) sizeObj.get("y")).intValue());
                bunkers.add((Bunker) build());
            }
            return bunkers;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
