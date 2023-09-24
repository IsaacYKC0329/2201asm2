package invaders.entities;

import invaders.physics.Vector2D;
import invaders.State.State;
import invaders.State.NoDamageState;
import javafx.scene.paint.Color;

public class Bunker {
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

    public Vector2D getPosition() {
        return position;
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
        if (state.shouldRemove()) {
            removeBunker();
        }
    }

    private void removeBunker() {
        return;
    }
}
