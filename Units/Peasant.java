package Sem3.Units;

import java.util.ArrayList;

public class Peasant extends Melee {
    boolean delivery;
    public Peasant (ArrayList<BaseHero> blueTeam, int x, int y) {
        super(1, 1, 1, 3, new int[]{1,1}, "Peasant", States.ALIVE);
        super.group = group;
        delivery = true;
        super.position = new Vector2D(x, y);
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
        ", delivery: " + delivery;
    }    
}
