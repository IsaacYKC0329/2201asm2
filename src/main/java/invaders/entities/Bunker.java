package invaders.entities;

import invaders.physics.Vector2D;
import javafx.scene.paint.Color;
import invaders.State.State;
import invaders.State.NoDamageState;

public class Bunker {
    private Vector2D position;
    private Vector2D size;
    private State state;

    public Bunker(Vector2D position, Vector2D size) {
        this.position = position;
        this.size = size;
        this.state = new NoDamageState();
    }

    public void hit() {
        state = state.takeHit();
        // Check if bunker should be removed
        if (state.getColor() == Color.RED) {
            // Call game logic to remove bunker

        }
    }

    public Color getColor() {
        return state.getColor();
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getSize() {
        return size;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setSize(Vector2D size) {
        this.size = size;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void update() {

    }
}