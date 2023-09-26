package invaders.Builder;


import invaders.entities.Enemy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import invaders.physics.Vector2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EnemyBuilder implements builder {
    private Vector2D position;
    private String projectileType;
    private static final String CONFIG_PATH = "src/main/resources/config.json";  // Update this path.

    public void setPositions(int x, int y) {
        this.position = new Vector2D(x, y);
    }

    public void setProjectileType(String projectileType){this.projectileType = projectileType;}
    @Override
    public Object build() {
        return new Enemy(position, projectileType);
    }

    public ArrayList<Enemy> buildEnemiesFromConfig() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(CONFIG_PATH);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray enemyArray = (JSONArray) jsonObject.get("Enemies");
            for (int i = 0; i < enemyArray.size(); i++) {
                JSONObject enemyObj = (JSONObject) enemyArray.get(i);
                JSONObject positionObj = (JSONObject) enemyObj.get("position");
                setPositions(((Long) positionObj.get("x")).intValue(), ((Long) positionObj.get("y")).intValue());
                setProjectileType((String) enemyObj.get("projectile"));
                enemies.add((Enemy) build());
            }
            return enemies;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
