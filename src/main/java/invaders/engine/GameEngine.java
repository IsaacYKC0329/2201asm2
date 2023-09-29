package invaders.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import invaders.Builder.BunkerBuilder;
import invaders.Builder.EnemyBuilder;
import invaders.Builder.PlayerBuilder;
import invaders.Factory.Projectile;
import invaders.Factory.SimpleProjectile;
import invaders.GameObject;
import invaders.entities.Bunker;
import invaders.entities.Enemy;
import invaders.entities.Player;
import invaders.rendering.Renderable;

/**
 * This class manages the main loop and logic of the game
 */
public class GameEngine {

	private List<GameObject> gameobjects;
	public static List<Renderable> renderables;
	public static List<Projectile> Projectiles;
	public static Player player;
	public static ArrayList<Enemy> enemies;
	public static ArrayList<Bunker> bunkers;

	private boolean left;
	private boolean right;
	private GameWindow gameWindow;
	private int count = 1;

	public GameEngine(String config){
		// read the config here
		gameobjects = new ArrayList<GameObject>();
		renderables = new ArrayList<Renderable>();
		Projectiles = new ArrayList<>();
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
		if(player.getHealth() <= 0){
			System.out.println("You Lose!");
			System.exit(0);
		}
		for(GameObject go: gameobjects){
			go.update();
		}
		if(count%60 != 0){
			count++;
		}else {
			for (Enemy e : enemies) {
				e.move();
				Random random = new Random();
				int i = random.nextInt(10000);
				if(i > 9950 && GameEngine.Projectiles.size() < 3){
					e.shoot();
				}
			}
			count = 1;
		}
		if(count%5 == 0){
			for(Projectile p: Projectiles){
				p.move();
			}
			Projectiles.removeIf(Projectile::getDisappear);
		}
		enemies.removeIf(enemy -> enemy.getPosition().getY()<=0);
		bunkers.removeIf(bunker -> bunker.getPosition().getY()<=0);
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
