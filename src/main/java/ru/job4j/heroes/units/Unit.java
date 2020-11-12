package ru.job4j.heroes.units;

import ru.job4j.heroes.moves.Move;

public abstract class Unit {

    private int hp;
    private boolean buffed;
    private boolean debuffed;
    private boolean dead;

    public Unit() {
        this.hp = 100;
        this.buffed = false;
        this.debuffed = false;
        this.dead = false;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isBuff() {
        return buffed;
    }

    public void setBuff(boolean buffed) {
        this.buffed = buffed;
    }

    public boolean isDebuffed() {
        return debuffed;
    }

    public void setDebuffed(boolean debuffed) {
        this.debuffed = debuffed;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public abstract Move chooseMove();

    public String toString() {
        return this.getClass().getSimpleName() + " {Hp: " + this.hp + ", buff: " + this.buffed + ", debuff: " + this.debuffed + "}";
    }
}
