package invaders.Strategy;

import invaders.Factory.Projectile;
import invaders.Factory.ProjectileFactory;
import invaders.engine.GameEngine;
import invaders.physics.Vector2D;
import invaders.rendering.Renderable;

public class FastStrategy implements ProjectileStrategy {
    private static final double SPEED = 6.0;
    private ProjectileFactory factory = new ProjectileFactory();
    private Renderable renderable;

    @Override
    public double getSpeed() {
        return SPEED;
    }

    @Override
    public void shoot() {
        // Logic for fast projectile shooting, e.g., creation of a new projectile entity with fast movement
        // This could also handle any visual or sound effects associated with a fast shot
        Projectile projectile = factory.createProjectile(new Vector2D(renderable.getPosition().getX(),
                renderable.getPosition().getY() + 15), SPEED);
        projectile.setShooter(this.renderable);
        GameEngine.Projectiles.add(projectile);
        GameEngine.renderables.add((Renderable) projectile);
    }

    @Override
    public void setRenderable(Renderable renderable) {
        this.renderable = renderable;
    }
}