package Sem3.Units;

import java.util.ArrayList;


public class Sharpshooter extends Ranged {
    
    public Sharpshooter(ArrayList<BaseHero> blueTeam, int x, int y) {
        super(12, 10, 15, 9, new int[]{8,10}, "Sharpshooter", States.ALIVE, 32);
        super. group = group;
        super.position = new Vector2D(x, y);
    }
}
