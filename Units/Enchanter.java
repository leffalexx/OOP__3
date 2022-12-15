package Sem3.Units;

import java.util.ArrayList;
import java.util.List;

public class Enchanter extends Healer {
    public Enchanter(List<BaseHero> blueTeam, int x, int y) {
        super(17, 12, 30, 9, new int[]{-5,-5}, "Enchanter", States.ALIVE);
        super.group = group;
        super.position = new Vector2D(x, y);
    }

        @Override
        public void step(ArrayList<BaseHero> group) {
            
    }
}