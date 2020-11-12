package ru.job4j.heroes.moves;

import ru.job4j.heroes.units.Unit;

public class Debuff implements Move {

    @Override
    public void execute(Unit srcUnit, Unit dstUnit) {
        dstUnit.setDebuffed(true);
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
        stringBuilder.append(" повесил дебафф на ");
        stringBuilder.append(dstUnit.toString());
        return stringBuilder.toString();
    }

}
