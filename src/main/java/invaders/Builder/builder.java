package invaders.Builder;

import invaders.rendering.Renderable;

import java.util.ArrayList;

interface builder {
    void setPositions(int x, int y);
    void setSize(int x, int y);
    ArrayList<Renderable> build();
}