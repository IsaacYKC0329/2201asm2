package invaders.State;

import javafx.scene.paint.Color;

public class LightDamageState implements State {

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public State takeHit(int hits) {
        if (hits == 2) {
            return new HeavyDamageState();
        }
        return this;
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }
}
