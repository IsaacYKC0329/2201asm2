package invaders.Factory;

import invaders.physics.Vector2D;

public class ProjectileFactory {

    public static Projectile createProjectile(Vector2D position) {
        return new SimpleProjectile(position);
    }

}
