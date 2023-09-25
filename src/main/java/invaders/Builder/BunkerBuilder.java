package invaders.Builder;

import invaders.entities.Bunker;
//import invaders.entities.Enemy;
import invaders.rendering.Renderable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import invaders.physics.Vector2D;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BunkerBuilder implements builder {
    private Vector2D position;
    private Vector2D size;
    private static final String CONFIG_PATH = "src/main/resources/config.json";

    @Override
    public void setPositions(int x, int y) {
        this.position = new Vector2D(x, y);
    }

    @Override
    public void setSize(int x, int y) {
        this.size = new Vector2D(x, y);
    }

    @Override
    public ArrayList<Renderable> build() {
        ArrayList<Renderable> bunkersList = new ArrayList<>();
        bunkersList.add((Renderable) new Bunker(position, size));
        return bunkersList;
    }

    public ArrayList<Renderable> buildBunkersFromConfig() {
        ArrayList<Renderable> bunkersList = new ArrayList<>();
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

                bunkersList.addAll(build());
            }
            return bunkersList;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
