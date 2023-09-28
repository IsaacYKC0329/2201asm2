package invaders.Strategy;

import invaders.Factory.Projectile;
import invaders.Factory.ProjectileFactory;
import invaders.rendering.Renderable;

public class SlowStrategy implements ProjectileStrategy {
    private static final double SPEED = 1.0;
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
        Projectile projectile = factory.createProjectile(renderable.getPosition(), SPEED);

    }
    @Override
    public void setRenderable(Renderable renderable){
        this.renderable = renderable;
    }
}
