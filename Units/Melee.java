package Sem3.Units;

public abstract class Melee extends BaseHero {
    public Melee (int offense, int defense, int hp, int speed, int[] damage, String name, States state) {
        super(offense, defense, hp, speed, damage, name, state);
    }
}