package invaders.Builder;

interface builder {
    void setPositions(int x, int y);
    void setSize(int x, int y);
    Object build();
}