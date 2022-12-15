package Sem3.Units;

import java.util.ArrayList;
import java.util.List;

public class Rogue extends Melee {
    boolean delivery;
    public Rogue(List<BaseHero> blueTeam, int x, int y) {
        super(8, 3, 10, 6, new int[]{2,4}, "Rogue", States.ALIVE);
        super.group = group;
        delivery = false;
        super.position = new Vector2D(x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> group) {

    }

    @Override
    public String getInfo() {
        return super.getInfo() +
        ", delivery: " + delivery;
    }    
}
