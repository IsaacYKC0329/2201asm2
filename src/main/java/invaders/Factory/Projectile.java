package invaders.Factory;


import invaders.rendering.Renderable;
import javafx.scene.canvas.GraphicsContext;

public interface Projectile  {
    // to do

    void move();
    void draw(GraphicsContext gc);
    Renderable getShooter();
    void setShooter(Renderable shooter);
    void disappear();
    boolean getDisappear();
}

