package invaders.Strategy;

public class SlowStrategy implements ProjectileStrategy {
    private static final double SPEED = 1.0;

    @Override
    public double getSpeed() {
        return SPEED;
    }

    @Override
    public void shoot() {
        // Logic for slow projectile shooting, e.g., creation of a new projectile entity with slow movement
        // This could also handle any visual or sound effects associated with a slow shot

    }
}
