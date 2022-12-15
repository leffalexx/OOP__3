package Sem3.Units;

public abstract class Melee extends BaseHero {
    public Melee (int offence, int defence, int hp, int speed, int[] damage, String name, States state) {
        super(offence, defence, hp, speed, damage, name, state);
    }
}