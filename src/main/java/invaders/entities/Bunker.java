package invaders.entities;

import invaders.physics.Vector2D;

public class Bunker {
    private Vector2D position;
    private Vector2D size;

    public Bunker(Vector2D position, Vector2D size) {
        this.position = position;
        this.size = size;
    }

    // getters, setters, and other methods...

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


}
