package invaders.State;

import javafx.scene.paint.Color;

public class NoDamageState implements State {

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public State takeHit(int hits) {
        if (hits == 1) {
            return new LightDamageState();
        }
        return this;
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }
}
