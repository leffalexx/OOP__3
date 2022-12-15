package Sem3.Units;

import java.util.ArrayList;

public abstract class Healer extends BaseHero{
    boolean magic;

    public Healer (int offence, int defence, int hp, int speed, int[] damage, String name, States state) {
        super(offence, defence, hp, speed, damage, name, state);
        this.magic = true;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
        ", Magic: " + magic;
    }
    
    @Override
    public void step(ArrayList<BaseHero> group) {
        int minHP = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < getGroup().size(); i++) {
            if (getState() != States.KIA && getGroup().get(i).getMaxHP() - getGroup().get(i).getHP() !=0) {
                if (minHP > getGroup().get(i).getMaxHP() - getGroup().get(i).getHP()) {
                    minHP = getGroup().get(i).getMaxHP() - getGroup().get(i).getHP();
                    index = i;
                }

            }
        }
        if (minHP != Integer.MAX_VALUE) {
            getGroup().get(index).setHP(getHP() - getDamage()[0]);
        }
    }
}
