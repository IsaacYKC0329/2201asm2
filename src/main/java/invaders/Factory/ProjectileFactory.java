package invaders.Factory;

import invaders.physics.Vector2D;

public class ProjectileFactory {

    public Projectile createProjectile(Vector2D position, double speed){
        return new SimpleProjectile(position, speed);
    }

}
