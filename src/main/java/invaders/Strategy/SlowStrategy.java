package invaders.Strategy;

public class SlowStrategy implements ProjectileStrategy {
    @Override
    public double getSpeed() {
        return 1.0;
    }

    @Override
    public void shoot() {
        // Logic for shooting the projectile
    }
}