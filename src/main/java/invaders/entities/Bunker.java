package invaders.entities;

import invaders.physics.Vector2D;

import java.awt.*;

public class Bunker {
    private Vector2D position;
    private Vector2D size;
    private int hits;

    private String color;

    public Bunker(Vector2D position, Vector2D size) {
        this.position = position;
        this.size = size;
        this.hits = 0;
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getSize() {
        return size;
    }

    public int getHits() {
        return hits;
    }

    public void hit() {
        this.hits++;
        if (hits == 3) {
            // Remove bunker from game.

        } else {
            updateColor();
        }
    }

    private void updateColor() {
        switch (hits) {
            case 0:
                // set color to green

                break;
            case 1:
                // set color to yellow
                break;
            case 2:
                // set color to red
                break;
        }
    }
}
