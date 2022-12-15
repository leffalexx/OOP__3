package Sem3.Units;

import java.util.ArrayList;
import java.util.List;

public class Pikeman extends Melee {
    boolean delivery;
    public Pikeman(List<BaseHero> greenTeam, int x, int y) {
        super(4, 5, 10, 4, new int[]{1,3}, "Pikeman", States.ALIVE);
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
