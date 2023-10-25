package WizardTD.GameObject;
import processing.core.PApplet;

public class Tile extends GameObject {

    private int type; // 0 = grass, 1 = shrub, 2 = path, 3 = wizard house

    public Tile(int x, int y, PApplet pApplet, int type) {
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        this.type = type;
        this.hp = 0;
        this.speed = 0;
    }

    public int getType() {
        return type;
    }

    @Override
    public void draw(PApplet app) {
        
    }

    @Override
    public void tick() {
        // Tiles usually don't have behavior that changes over time
    }
}