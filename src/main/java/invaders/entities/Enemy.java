package invaders.entities;

import invaders.physics.Vector2D;

public class Enemy {
    private Vector2D position;
    private String image;

    public Enemy(Vector2D position, String image) {
        this.position = position;
        this.image = image;
    }

    // getters, setters, and other methods...

    public Vector2D getPosition() {
        return position;
    }

    public String getImage() {
        return image;
    }

}

