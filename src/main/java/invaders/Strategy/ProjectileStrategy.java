package invaders.Strategy;

import invaders.rendering.Renderable;

public interface ProjectileStrategy {
    double getSpeed();
    void shoot();
    void setRenderable(Renderable renderable);
}
