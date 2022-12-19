package Sem3.Units;

import java.util.ArrayList;

public class Archer extends Ranged {

    public Archer(ArrayList<BaseHero> greenTeam, int x, int y) {
        super(6, 3, 10, 4, new int[]{2,3}, "Archer", States.ALIVE, 16);
        super.group = group;
        super.position = new Vector2D(x, y);
    }

}