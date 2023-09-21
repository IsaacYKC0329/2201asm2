package invaders.Strategy;



public class FastStrategy implements ProjectileStrategy {
    @Override
    public double getSpeed() {
        return 2.0;
    }

    @Override
    public void shoot() {
        // Logic for shooting the projectile

    }
}