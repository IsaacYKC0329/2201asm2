package invaders.Builder;

import invaders.entities.Bunker;
import invaders.entities.Enemy;
import invaders.physics.Vector2D;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BunkerBuilder implements builder {
    private Vector2D position;
    private Vector2D size;

    @Override
    public void getPosition(double x, double y) {
        this.position = new Vector2D(x, y);
    }


    public void getSize(double x, double y) {
        this.size = new Vector2D(x, y);
    }

    @Override
    public void build() {
        new Bunker(position, size);
    }

    public List<Bunker> buildFromJson(String filepath) {
        List<Bunker> bunkers = new ArrayList<>();

        try {
            // Parse the JSON file
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(filepath));
            JSONArray bunkersArray = (JSONArray) jsonObject.get("Bunkers");

            for (Object obj : bunkersArray) {
                JSONObject bunkerData = (JSONObject) obj;

                JSONObject positionData = (JSONObject) bunkerData.get("position");
                getPosition((double) positionData.get("x"), (double) positionData.get("y"));

                JSONObject sizeData = (JSONObject) bunkerData.get("size");
                getSize((double) sizeData.get("x"), (double) sizeData.get("y"));

                bunkers.add(build());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return bunkers;
    }
}
