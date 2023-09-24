package invaders.State;

import javafx.scene.paint.Color;

public class NoDamageState implements State {

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public State takeHit() {
        return new LightDamageState();
    }
}
