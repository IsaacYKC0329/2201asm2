package invaders.Strategy;

import invaders.Factory.Projectile;
import invaders.Factory.ProjectileFactory;
import invaders.Factory.SimpleProjectile;
import invaders.engine.GameEngine;
import invaders.entities.Enemy;
import invaders.entities.Player;
import invaders.physics.Vector2D;
import invaders.rendering.Renderable;
import javafx.scene.paint.Color;

public class PlayerSlowStrategy implements ProjectileStrategy {
    private static final double SPEED = 3.0;
    private ProjectileFactory factory = new ProjectileFactory();
    private Renderable renderable;

    @Override
    public double getSpeed() {
        return SPEED;
    }

    @Override
    public void shoot() {
        // Logic for slow projectile shooting, e.g., creation of a new projectile entity with slow movement
        // This could also handle any visual or sound effects associated with a slow shot
        Projectile projectile = factory.createProjectile(new Vector2D(renderable.getPosition().getX() + 10,
                renderable.getPosition().getY() - 10), -SPEED);
        projectile.setColor(Color.PURPLE);
        projectile.setShooter(this.renderable);
        GameEngine.Projectiles.add(projectile);
        GameEngine.renderables.add((Renderable) projectile);
        Player.shooting = true;
    }
    @Override
    public void setRenderable(Renderable renderable){
        this.renderable = renderable;
    }
}