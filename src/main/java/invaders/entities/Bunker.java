package invaders.entities;

import invaders.physics.Vector2D;
import invaders.State.State;
import invaders.State.NoDamageState;
import invaders.rendering.Renderable;
import javafx.scene.image.Image;
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
        return null;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Layer getLayer() {
        return null;
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
        state = state.takeHit(hits);
        if (state.shouldRemove()) {
            removeBunker();
        }
    }

    private void removeBunker() {
        return;
    }
}
