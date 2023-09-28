package invaders.entities;


import invaders.Factory.Projectile;
import invaders.Factory.ProjectileFactory;
import invaders.Strategy.FastStrategy;
import invaders.Strategy.ProjectileStrategy;
import invaders.Strategy.SlowStrategy;
import invaders.engine.GameWindow;
import invaders.logic.Damagable;
import invaders.physics.Moveable;
import invaders.physics.Vector2D;
import invaders.rendering.Animator;
import invaders.rendering.Renderable;

import javafx.scene.image.Image;

import java.io.File;

public class Enemy implements Renderable{
    private Vector2D position;
    private String projectileType;
    private Image image;
    private ProjectileStrategy projectileStrategy;
    private double speed;

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
        this.projectileStrategy.setRenderable(this);
        this.speed = this.image.getWidth();
    }

    public void shoot() {
        projectileStrategy.shoot();
    }

    // You can have methods for:
    // - Moving the enemy
    // - Checking if the enemy has reached the bottom
    // - Checking if the enemy has hit the player
    // - ... and so on

    public void move(){
        double x = this.position.getX();
        double y = this.position.getY();
        if(((int)(y/20))%2 == 1){
            if(x - speed > 0){
                x = x - speed - 5;
            }else {
                x = 0;
                y = y + 20;
            }
        }else{
            if(x + speed < GameWindow.scene.getWidth() - speed - 5){
                x = x + speed + 5;
            }else {
                x = GameWindow.scene.getWidth();
                y = y + 20;
            }
        }
        this.position = new Vector2D(x,y);
    }

    public Vector2D getPosition() {
        return position;
    }

    public void changeSpeed(double speed){
        this.speed = speed;
    }

    public double getSpeed(){return speed;}

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    public String getProjectileType() {
        return projectileType;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public double getWidth() {
        return getImage().getWidth();
    }

    @Override
    public double getHeight() {
        return getImage().getHeight();
    }

}

