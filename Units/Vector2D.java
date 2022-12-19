package Sem3.Units;

public class Vector2D {
    public int x,y;

    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean isEqual(Vector2D pos){
        if (pos.y == y && pos.x ==x) return true;
        return false;
    }

    public float getDistance(Vector2D position) {
        return (float) Math.sqrt((x - position.x) * (x - position.x) + (y - position.y) * (y - position.y));
    }
}