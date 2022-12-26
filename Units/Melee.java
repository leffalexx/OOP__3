package Sem3.Units;

import java.util.ArrayList;

public abstract class Melee extends BaseHero {
    public Melee (int offense, int defense, int hp, int speed, int[] damage, String name, States state) {
        super(offense, defense, hp, speed, damage, name, state);
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

    public void step(ArrayList<BaseHero> group) {
        if (getState().equals(States.KIA))
        return;
        BaseHero engage = findTarget(group);
        if (getPosition().getDistance(engage.getPosition()) < Math.sqrt(2))
        attack(engage);
        int x = getPosition().x;
        int y = getPosition().y;
        if (engage.getPosition().y > y && checkPos(new Vector2D(x, y+1)) && (y+1 < 10))
            setPos(new Vector2D(x, y+1));
        if (engage.getPosition().y < y && checkPos(new Vector2D(x, y-1)) && (y-1 >= 0))
            setPos(new Vector2D(x, y-1));
        if (engage.getPosition().x < y && checkPos(new Vector2D(x+1, y)) && (x+1 < 10))
            setPos(new Vector2D(x+1, y));
        if (engage.getPosition().x < x && checkPos(new Vector2D(x-1, y)) && (x-1 >= 0))
            setPos(new Vector2D(x-1, y));
        
    }

    private boolean checkPos (Vector2D position) {
        for (BaseHero baseHero : getGroup()) {
            if (position.isEqual(baseHero.getPosition()))
            return false;
        }
        return true;
    }
}