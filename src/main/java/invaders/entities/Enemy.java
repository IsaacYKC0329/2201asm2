package invaders.entities;


import invaders.Factory.Projectile;
import invaders.Strategy.FastStrategy;
import invaders.Strategy.ProjectileStrategy;
import invaders.Strategy.SlowStrategy;
import invaders.logic.Damagable;
import invaders.physics.Moveable;
import invaders.physics.Vector2D;
import invaders.rendering.Animator;
import invaders.rendering.Renderable;

import javafx.scene.image.Image;

import java.io.File;

public class Enemy{
    private Vector2D position;
    private String projectileType;
    private Image image;
    private ProjectileStrategy projectileStrategy;

    public Enemy(Vector2D position, String projectileType) {
        this.position = position;
        this.projectileType = projectileType;
        this.image = new Image(new File("src/main/resources/enemy.png").toURI().toString(), 20, 20, true, true);
//         Determine the projectile strategy based on the provided type
        if ("fast_straight".equals(projectileType)) {
            this.projectileStrategy = new FastStrategy();
        } else {
            this.projectileStrategy = new SlowStrategy();
        }
    }

    public void shoot() {
        projectileStrategy.shoot();
    }

    // You can have methods for:
    // - Moving the enemy
    // - Checking if the enemy has reached the bottom
    // - Checking if the enemy has hit the player
    // - ... and so on


    public Vector2D getPosition() {
        return position;
    }

    public String getProjectileType() {
        return projectileType;
    }

    public Image getImage() {
        return image;
    }
}

