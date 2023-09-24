package invaders.State;

import javafx.scene.paint.Color;

public class LightDamageState implements State {

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public State takeHit() {
        return new HeavyDamageState();
    }
}
