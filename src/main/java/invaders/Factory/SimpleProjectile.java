package invaders.Factory;

import invaders.physics.Vector2D;
import invaders.rendering.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SimpleProjectile implements Projectile, Renderable {
    private Vector2D position;
    private double speed;
    private Vector2D size; // Diameter for circle or side length for rectangle

    public SimpleProjectile(Vector2D position, double speed) {
        this.position = position;
        this.speed = speed;
        size.setX(2);
        size.setY(4);
    }

    @Override
    public void move() {
        position.setY(position.getY() - speed);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillOval(position.getX(), position.getY(), size.getX(), size.getY());
    }

    @Override
    public Image getImage() {
        // 创建一个 WritableImage 对象，用于绘制长方形
        WritableImage writableImage = new WritableImage((int) size.getX(), (int) size.getY());

        // 创建一个长方形并设置颜色
        Rectangle rectangle = new Rectangle((int) size.getX(), (int) size.getY());
        rectangle.setFill(Color.WHITE);

        // 在 WritableImage 上绘制长方形
        rectangle.snapshot(null, writableImage);
        return writableImage;
    }

    @Override
    public double getWidth() {
        return size.getX();
    }

    @Override
    public double getHeight() {
        return size.getY();
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Layer getLayer() {
        return Layer.EFFECT;
    }
}
