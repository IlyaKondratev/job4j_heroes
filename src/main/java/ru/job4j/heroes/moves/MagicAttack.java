package ru.job4j.heroes.moves;

import ru.job4j.heroes.units.Unit;

public class MagicAttack implements Move {

    private final int attack;

    public MagicAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public void execute(Unit srcUnit, Unit dstUnit) {
        int damage = srcUnit.isBuff() ? attack * 2 : srcUnit.isDebuffed() ? attack / 2 : attack;
        if (dstUnit.getHp() > damage) {
            dstUnit.setHp(dstUnit.getHp() - damage);
        } else {
            dstUnit.setHp(0);
            dstUnit.setDead(true);
        }
        System.out.println(log(srcUnit, dstUnit));
        srcUnit.setBuff(false);
        srcUnit.setDebuffed(false);
    }

    @Override
    public boolean toEnemy() {
        return true;
    }

    @Override
    public String log(Unit srcUnit, Unit dstUnit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(srcUnit.toString());
        stringBuilder.append(" нанес ");
        stringBuilder.append(dstUnit.toString());
        stringBuilder.append(" " + attack + " урона.");
        return stringBuilder.toString();
    }

}
