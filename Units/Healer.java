package Sem3.Units;


import java.util.ArrayList;

public abstract class Healer extends BaseHero{
    boolean magic;

    public Healer (int offense, int defense, int hp, int speed, int[] damage, String name, States state) {
        super(offense, defense, hp, speed, damage, name, state);
        this.magic = true;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
        ", Magic: " + magic;
    }

    private void engage (int target, ArrayList<BaseHero> enemies) {
        if (target != -1) {
            enemies.get(target).setHP(enemies.get(target).getHP() + getDamage()[0]);
        }
    }

    private int findTarget(ArrayList<BaseHero> enemies) {
        int target = -1;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getClass().toString().contains("Ranged") &&
                enemies.get(i).getState() != States.KIA) {
                    target = i;
                }
            }
        return target;
    }

    private void resurrect() {
        for (BaseHero teammate : getGroup()) {
            if (teammate.getState() == States.KIA)
            teammate.setHP(1);
        }
    }
    
    private int findLow() {
        int minHP = Integer.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < getGroup().size(); i++) {
            if (getGroup().get(i).getHP() < minHP &&
            getGroup().get(i).getState() != States.KIA) {
                minHP = getGroup().get(i).getHP();
                temp = i;
            }
        }
        return temp;
    } 
    
    
    @Override
    public void step (ArrayList<BaseHero> enemies) {
        if (getState() == States.KIA)
        return;
        setState(States.ATTACK);
        int temp = findLow();
        BaseHero teammate = getGroup().get(temp);
        if (teammate.getHP() / teammate.getMaxHP() < 0.5)
            teammate.setHP(teammate.getHP() - getDamage()[0]);
        else if (teammate.getHP() / teammate.getMaxHP() >= 0.75) {
            engage (findTarget(enemies), enemies);
        }
        else resurrect();
    }
}
