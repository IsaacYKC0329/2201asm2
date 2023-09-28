package invaders.entities;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Rectangle;
import invaders.physics.Vector2D;
import invaders.State.State;
import invaders.State.NoDamageState;
import invaders.rendering.Renderable;
import javafx.scene.paint.Color;

public class Bunker implements Renderable{
    private Vector2D position;
    private Vector2D size;
    private State state;
    private int hits;

    public Bunker(Vector2D position, Vector2D size) {
        this.position = position;
        this.size = size;
        this.hits = 0;
        this.state = new NoDamageState();
    }

    @Override
    public Image getImage() {
        // 创建一个 WritableImage 对象，用于绘制长方形
        WritableImage writableImage = new WritableImage((int) size.getX(), (int) size.getY());

        // 创建一个长方形并设置颜色
        Rectangle rectangle = new Rectangle((int) size.getX(), (int) size.getY());
        rectangle.setFill(this.state.getColor());

        // 在 WritableImage 上绘制长方形
        rectangle.snapshot(null, writableImage);
        return writableImage;
    }

    @Override
    public double getWidth() {
        return getImage().getWidth();
    }

    @Override
    public double getHeight() {
        return getImage().getHeight();
    }

    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Layer getLayer() {
       return Layer.FOREGROUND;
    }

    public Vector2D getSize() {
        return size;
    }

    public Color getColor() {
        return state.getColor();
    }

    public int getHits() {
        return hits;
    }

    public void hit() {
        hits++;
        state = state.takeHit(hits);  // Pass hits count to states
        if (hits > 2) {
            this.position.setX(-1);
            this.position.setY(-1);
        }
    }
}
