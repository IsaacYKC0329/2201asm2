package invaders.Builder;

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

public class EnemyBuilder implements builder {
    private Vector2D position;
    private final String image = "enemy.png";

    @Override
    public void getPosition(double x, double y) {
        this.position = new Vector2D(x, y);
    }

    @Override
    public Enemy build() {
        return new Enemy(position, image);
    }

    public List<Enemy> buildFromJson(String filepath) {
        List<Enemy> enemies = new ArrayList<>();

        try {
            // Parse the JSON file
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(filepath));
            JSONArray enemiesArray = (JSONArray) jsonObject.get("Enemies");

            for (Object obj : enemiesArray) {
                JSONObject enemyData = (JSONObject) obj;

                JSONObject positionData = (JSONObject) enemyData.get("position");
                getPosition((double) positionData.get("x"), (double) positionData.get("y"));

                enemies.add(build());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return enemies;
    }
}
