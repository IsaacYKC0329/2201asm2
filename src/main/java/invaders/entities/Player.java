package invaders.entities;

import invaders.logic.Damagable;
import invaders.physics.Moveable;
import invaders.physics.Vector2D;
import invaders.rendering.Animator;
import invaders.rendering.Renderable;

import javafx.scene.image.*;

import java.io.File;
import java.util.Objects;

import invaders.Factory.ProjectileFactory;
import javafx.scene.paint.Color;

public class Player implements Moveable, Damagable, Renderable {

    private final Vector2D position;
    private final Animator anim = null;
    private double health;
    private double speed;

    private final double width = 25;
    private final double height = 30;
    private Image image;


    public Player(Vector2D position){
        this.image = new Image(new File("src/main/resources/player.png").toURI().toString(), width, height, true, true);
        this.position = position;
    }

    public void setHealth(double health){
        this.health = health;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void setColor(String colour){
        Color color = Color.web(colour);
        double overlayRed = color.getRed()*255;
        double overlayGreen = color.getGreen()*255;
        double overlayBlue = color.getBlue()*255;
        WritableImage imageWithOverlay = new WritableImage((int) this.image.getWidth(), (int) this.image.getHeight());
        PixelWriter pixelWriter = imageWithOverlay.getPixelWriter();
        for (int x = 0; x < (int) this.image.getWidth(); x++) {
            for (int y = 0; y < (int) this.image.getHeight(); y++) {
                Color originalColor = this.image.getPixelReader().getColor(x, y);
                // 将覆盖颜色与原始颜色混合
                int newRed = (int) overlayRed;
                int newGreen = (int) overlayGreen;
                int newBlue = (int) overlayBlue;
                Color newColor = Color.rgb(newRed, newGreen, newBlue);
//                System.out.println(newColor.toString());
                // 写入新颜色到图像
                if(!originalColor.toString().equals("0x00000000")) {
                    pixelWriter.setColor(x, y, newColor);
                }
            }
        }
        ImageView imageView = new ImageView(imageWithOverlay);;
        this.image = imageView.getImage();
    }
    @Override
    public void takeDamage(double amount) {
        this.health -= amount;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void up() {
        return;
    }

    @Override
    public void down() {
        return;
    }

    @Override
    public void left() {
        this.position.setX(this.position.getX() - speed);
    }

    @Override
    public void right() {
        this.position.setX(this.position.getX() + speed);
    }

    public void shoot(){

    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

}
