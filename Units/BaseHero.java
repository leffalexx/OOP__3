package Sem3.Units;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseHero implements BaseInterface {
    protected int offence;
    protected int defence;
    protected int hp;
    protected int maxHP;
    protected int speed;
    protected String name;
    protected int[] damage;
    protected States state;
    protected ArrayList<BaseHero> group;
    protected Vector2D position;

    

    public BaseHero(int offence, int defence, int hp, int speed, int[] damage, String name, States state) {
        this.offence = offence;
        this.defence = defence;
        this.hp = hp;
        this.maxHP = hp;
        this.speed = speed;
        this.damage = damage;
        this.name = name;
        this.state = state;
    }

    public ArrayList<BaseHero> getGroup() {
        return group;
    }

    public States getState() {
        return state;
    }

    public int[] getDamage() {
        return damage;
    }

    public int getHP() {
        return hp;
    }
    
    public int getMaxHP() {
        return maxHP;
    }

    public void setHP (int hp) {
        if (hp > getMaxHP()) this.hp = maxHP;
        else this.hp = hp;
    }

    public Vector2D getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override

    public String getInfo() {
        return getClass().getSimpleName() + 
        ": Offence: " + offence +
        ", Defence: " + defence +
        ", Damage: " + Arrays.toString(damage) +
        ", HP: " + hp +
        ", Speed: " + speed; 
    }
    
    @Override
    public void step(ArrayList<BaseHero> group){

    }
}