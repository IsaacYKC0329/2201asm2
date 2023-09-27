package invaders.engine;

import java.util.ArrayList;
import java.util.List;


import invaders.Builder.BunkerBuilder;
import invaders.Builder.EnemyBuilder;
import invaders.Builder.PlayerBuilder;
import invaders.GameObject;
import invaders.entities.Bunker;
import invaders.entities.Enemy;
import invaders.entities.Player;
import invaders.physics.Moveable;
import invaders.physics.Vector2D;
import invaders.rendering.Renderable;

/**
 * This class manages the main loop and logic of the game
 */
public class GameEngine {

	private List<GameObject> gameobjects;
	private List<Renderable> renderables;
	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Bunker> bunkers;

	private boolean left;
	private boolean right;
	private GameWindow gameWindow;


	public GameEngine(String config){
		// read the config here
		gameobjects = new ArrayList<GameObject>();
		renderables = new ArrayList<Renderable>();
		enemies = new EnemyBuilder().buildEnemiesFromConfig();
		bunkers = new BunkerBuilder().buildBunkersFromConfig();
		player = new PlayerBuilder().buildPlayerFromConfig();
		renderables.addAll(bunkers);
		renderables.addAll(enemies);
		renderables.add(player);
	}

	/**
	 * Updates the game/simulation
	 */
	public void update(){
		movePlayer();
		for(GameObject go: gameobjects){
			go.update();
		}
		double width = gameWindow.getScene().getWidth();
		double height = gameWindow.getScene().getHeight();

		// ensure that renderable foreground objects don't go off-screen
		for(Renderable ro: renderables){
			if(!ro.getLayer().equals(Renderable.Layer.FOREGROUND)){
				continue;
			}
			if(ro.getPosition().getX() + ro.getWidth() >= width) {
				ro.getPosition().setX(width-ro.getWidth());
			}

			if(ro.getPosition().getX() <= 0) {
				ro.getPosition().setX(1);
			}

			if(ro.getPosition().getY() + ro.getHeight() >= height) {
				ro.getPosition().setY(height-ro.getHeight());
			}

			if(ro.getPosition().getY() <= 0) {
				ro.getPosition().setY(1);
			}
		}
	}

	public List<Renderable> getRenderables(){
		return renderables;
	}


	public void leftReleased() {
		this.left = false;
	}

	public void rightReleased(){
		this.right = false;
	}

	public void leftPressed() {
		this.left = true;
	}
	public void rightPressed(){
		this.right = true;
	}

	public boolean shootPressed(){
		player.shoot();
		return true;
	}

	private void movePlayer(){
		if(left){
			player.left();
		}

		if(right){
			player.right();
		}
	}

	public void setWindow(GameWindow gw){
		this.gameWindow = gw;
	}
}
