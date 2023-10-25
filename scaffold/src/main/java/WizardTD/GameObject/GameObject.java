package WizardTD.GameObject;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;

public abstract class GameObject {
    protected int x; //position
    protected int y;
    protected int width; //size
    protected int height;
    protected List<PImage> sprites; //sprites
    protected int hp;
    protected int speed;

    public int[] get_position(){
        return new int[]{x, y};
    }

    public int[] get_size(){
        return new int[]{width, height};
    }

    public boolean is_alive(){
        return this.hp <= 0;
    }

    public abstract void draw(PApplet app);
    public abstract void tick();
}
