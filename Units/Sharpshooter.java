package Sem3.Units;

import java.util.ArrayList;
import java.util.List;

public class Sharpshooter extends Ranged {
    int shots;
    public Sharpshooter(List<BaseHero> blueTeam, int x, int y) {
        super(12, 10, 15, 9, new int[]{8,10}, "Sharpshooter", States.ALIVE);
        super. group = group;
        shots = 32;
        super.position = new Vector2D(x, y);
    }

    @Override
    public void step (ArrayList<BaseHero> group) {

    }

    @Override
    public String getInfo() {
        return super.getInfo() +
        ", shots: " + shots;
    }    
}
