package Sem3.Units;

import java.util.ArrayList;
import java.util.List;

public class Monk extends Healer {
    public Monk(List<BaseHero> greenTeam, int x, int y) {
        super(12, 7, 30, 5, new int[]{-4,-4}, "Monk", States.ALIVE);
        super.group = group;
        super.position = new Vector2D(x, y);
    }
    
    @Override
    public void step(ArrayList<BaseHero> group) {
        
    }
}
