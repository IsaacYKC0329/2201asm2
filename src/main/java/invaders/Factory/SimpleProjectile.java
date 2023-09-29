package invaders.Factory;

import invaders.engine.GameEngine;
import invaders.engine.GameWindow;
import invaders.entities.Bunker;
import invaders.entities.Enemy;
import invaders.entities.Player;
import invaders.physics.Vector2D;
import invaders.rendering.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SimpleProjectile implements Projectile, Renderable {
    private Vector2D position;
    private double speed;
    private Vector2D size = new Vector2D(0,0); // Diameter for circle or side length for rectangle
    private Renderable shooter;
    private boolean disappear;

    public SimpleProjectile(Vector2D position, double speed) {
        this.position = position;
        this.speed = speed;
        size.setX(5);
        size.setY(10);
    }
    @Override
    public void setShooter(Renderable shooter){
        this.shooter = shooter;
    }

    @Override
    public void disappear() {
        this.disappear = true;
        this.position.setX(-1);
        this.position.setY(-1);
    }

    @Override
    public boolean getDisappear() {
        return disappear;
    }

    @Override
    public void move() {
        if(this.position.getY() < 0 || this.position.getY() > GameWindow.scene.getHeight()){
            disappear();
        }
        try {
            Enemy player = (Enemy) shooter;
            position.setY(position.getY() + speed);
        }catch (Exception e) {
            position.setY(position.getY() - speed);
        }
        removeBunker();
        hitPlayer();
        hitEnemy();
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillOval(position.getX(), position.getY(), size.getX(), size.getY());
    }

    @Override
    public Renderable getShooter() {
        return this.shooter;
    }

    @Override
    public Image getImage() {
        // 创建一个 WritableImage 对象，用于绘制长方形
        WritableImage writableImage = new WritableImage((int) size.getX(), (int) size.getY());

        // 创建一个长方形并设置颜色
        Rectangle rectangle = new Rectangle((int) size.getX(), (int) size.getY());
        try{
            Enemy enemy = (Enemy) getShooter();
            rectangle.setFill(Color.WHITE);
        }catch (ClassCastException e){
            rectangle.setFill(Color.PURPLE);
        }
        // 在 WritableImage 上绘制长方形
        rectangle.snapshot(null, writableImage);
        return writableImage;
    }

    @Override
    public double getWidth() {
        return size.getX();
    }

    @Override
    public double getHeight() {
        return size.getY();
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Layer getLayer() {
        return Layer.EFFECT;
    }

    public void removeBunker(){
        for(Bunker bunker:GameEngine.bunkers){
            if(this.position.getX() > bunker.getPosition().getX()
                    && this.position.getX() < bunker.getPosition().getX() + bunker.getSize().getX()
                    && this.position.getY() > bunker.getPosition().getY()
                    && this.position.getY() < bunker.getPosition().getY() + bunker.getSize().getY()
            ){
                disappear();
                bunker.hit();
            }
        }
    }

    public void hitPlayer(){
        if(this.position.getX() > GameEngine.player.getPosition().getX() - GameEngine.player.getImage().getWidth()/2
                && this.position.getX() < GameEngine.player.getPosition().getX() + GameEngine.player.getImage().getWidth()/2
                && this.position.getY() >GameEngine.player.getPosition().getY() - GameEngine.player.getImage().getHeight()/2
                && this.position.getY() < GameEngine.player.getPosition().getY() + GameEngine.player.getImage().getHeight()/2
        ){
            GameEngine.player.getHit();
            disappear();
        }
    }

    public void hitEnemy(){
        for(Enemy enemy:GameEngine.enemies){
            if(this.position.getX() > enemy.getPosition().getX()
                    && this.position.getX() < enemy.getPosition().getX() + enemy.getImage().getWidth()
                    && this.position.getY() > enemy.getPosition().getY()
                    && this.position.getY() < enemy.getPosition().getY() + enemy.getImage().getHeight()
            ){
                disappear();
                enemy.destroy();
            }
        }
    }

}
