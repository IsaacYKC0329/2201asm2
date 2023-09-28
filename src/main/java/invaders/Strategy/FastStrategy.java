package invaders.Strategy;

import invaders.rendering.Renderable;

public class FastStrategy implements ProjectileStrategy {
    private static final double SPEED = 2.0;
    private Renderable renderable;

    @Override
    public double getSpeed() {
        return SPEED;
    }

    @Override
    public void shoot() {
        // Logic for fast projectile shooting, e.g., creation of a new projectile entity with fast movement
        // This could also handle any visual or sound effects associated with a fast shot

    }

    @Override
    public void setRenderable(Renderable renderable) {
        this.renderable = renderable;
    }
}