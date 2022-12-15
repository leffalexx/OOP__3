package Sem3.Units;
import java.util.ArrayList;
import java.util.List;

public class Archer extends Ranged {
    int shots;
    public Archer(List<BaseHero> greenTeam, int x, int y) {
        super(6, 3, 10, 4, new int[]{2,3}, "Archer", States.ALIVE);
        super.group = group;
        shots = 16;
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