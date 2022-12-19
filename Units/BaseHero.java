package Sem3.Units;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseHero implements BaseInterface {
    protected int offense;
    protected int defense;
    protected int hp;
    protected int maxHP;
    protected int speed;
    protected String name;
    protected int[] damage;
    protected States state;
    protected ArrayList<BaseHero> group;
    protected Vector2D position;

    

    public BaseHero(int offense, int defense, int hp, int speed, int[] damage, String name, States state) {
        this.offense = offense;
        this.defense = defense;
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

    public void setState(States state){
        this.state = state;
    }

    @Override

    public String getInfo() {
        return getClass().getSimpleName() + 
        ": offense: " + offense +
        ", defense: " + defense +
        ", Damage: " + Arrays.toString(damage) +
        ", HP: " + hp +
        ", Speed: " + speed; 
    }
    
    @Override
    public void step(ArrayList<BaseHero> group){

    }

    protected void attack (BaseHero unit) {
        if (offense == unit.defense && speed < position.getDistance(unit.getPosition()))
            unit.hp -=(damage[0]+damage[1])/4;
        if (offense == unit.defense)
            unit.hp -= (damage[0] + damage[1])/2;
        if (offense > unit.defense && speed < position.getDistance(unit.getPosition()))
            unit.hp -= damage[1]/2;
        if (offense > unit.defense)
            unit.hp -= damage[1];
        if (offense < unit.defense && speed < position.getDistance(unit.getPosition()))
            unit.hp -= damage[0]/2;
        else unit.hp -= damage[0];

        if (unit.hp < 1) {
            unit.hp = 0;
            unit.setState(States.KIA);
        }
    }
}