package invaders.Builder;

import invaders.entities.Enemy;

interface builder {
    void setPositions(int x, int y);
    void setSize(int x, int y);
    Object build();
}