package invaders.State;

import javafx.scene.paint.Color;

public interface State {
    Color getColor();
    State takeHit();
}
