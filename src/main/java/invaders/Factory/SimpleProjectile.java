package invaders.Factory;

import invaders.physics.Vector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SimpleProjectile implements Projectile {
    private final Vector2D position;
    private final double speed = 5.0;
    private final double size = 5.0; // Diameter for circle or side length for rectangle

    public SimpleProjectile(Vector2D position) {
        this.position = position;
    }

    @Override
    public void move() {
        position.setY(position.getY() - speed);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillOval(position.getX(), position.getY(), size, size);
    }
}
