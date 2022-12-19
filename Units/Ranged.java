package Sem3.Units;
import java.util.ArrayList;


public abstract class Ranged extends BaseHero {
    int shots;
    public Ranged (int offense, int defense, int hp, int speed, int[] damage, String name, States state, int shots) {
        super(offense, defense, hp, speed, damage, name, state);
        this.shots = shots;
    }

    @Override

    public void step(ArrayList<BaseHero> group) {
        if (getState() == States.KIA) return;
        for (int i = 0; i < getGroup().size(); i++) {
            if (getGroup().get(i).getClass().getSimpleName().equals("Peasant") &&
            getGroup().get(i).getState().equals(States.ALIVE)) {
                shots++;
                getGroup().get(i).setState(States.USED);
            }
        }
        if (shots < 1)
            return;
            shots--;

        BaseHero engage = findTarget(group);
        attack(engage);
        



    }

    private BaseHero findTarget(ArrayList<BaseHero> group) {
        float closest = Float.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < group.size(); i++) {
            if (group.get(i).getState() == States.KIA)
            continue;
            float dist = getPosition().getDistance(group.get(i).getPosition());
            if (closest > dist) {
                closest = dist;
                temp = i;
            }
        }
        return group.get(temp);
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
        ", shots: " + shots;
    }
}
