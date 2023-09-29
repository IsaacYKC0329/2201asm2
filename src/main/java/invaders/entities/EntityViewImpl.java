package invaders.entities;

import invaders.Factory.Projectile;
import invaders.engine.GameEngine;
import invaders.physics.Vector2D;
import invaders.rendering.Renderable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class EntityViewImpl implements EntityView {
    private Renderable entity;
    private boolean delete = false;
    private ImageView node;

    public EntityViewImpl(Renderable entity) {
        this.entity = entity;
        node = new ImageView(entity.getImage());
        node.setViewOrder(getViewOrder(entity.getLayer()));
        update(0.0, 0.0);
    }

    private static double getViewOrder(Renderable.Layer layer) {
        switch (layer) {
            case BACKGROUND: return 100.0;
            case FOREGROUND: return 50.0;
            case EFFECT: return 25.0;
            default: throw new IllegalStateException("Javac doesn't understand how enums work so now I have to exist");
        }
    }

    @Override
    public void update(double xViewportOffset, double yViewportOffset) {
        if (!node.getImage().equals(entity.getImage())) {
            node.setImage(entity.getImage());
        }
        node.setX(entity.getPosition().getX() - xViewportOffset);
        node.setY(entity.getPosition().getY() - yViewportOffset);
        node.setFitHeight(entity.getHeight());
        node.setFitWidth(entity.getWidth());
        node.setPreserveRatio(true);
        delete = false;
        if (this.entity.getPosition().getY() < 10 || this.entity.getPosition().getX() < 0){
            this.markForDelete();
        }
    }

    @Override
    public boolean matchesEntity(Renderable entity) {
        return this.entity.equals(entity);
    }

    @Override
    public void markForDelete() {
        delete = true;
        if(this.entity instanceof Projectile projectile){
            try{
                Enemy enemy = (Enemy) projectile.getShooter();
            }catch (ClassCastException e){
                Player.shooting = false;
            }
        }
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public boolean isMarkedForDelete() {
        return delete;
    }
    @Override
    public Renderable getEntity(){return this.entity;}
}
