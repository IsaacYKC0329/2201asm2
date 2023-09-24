package invaders.State;

import javafx.scene.paint.Color;

public class HeavyDamageState implements State {

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public State takeHit() {
        return this;
    }
}
