package Sem3.Units;

import java.util.ArrayList;

public class Monk extends Healer {
    public Monk(ArrayList<BaseHero> greenTeam, int x, int y) {
        super(12, 7, 30, 5, new int[]{-4,-4}, "Monk", States.ALIVE);
        super.group = group;
        super.position = new Vector2D(x, y);
    }
    
}
