package ru.job4j.heroes.moves;

import ru.job4j.heroes.units.Unit;

public interface Move {
    void execute (Unit srcUnit, Unit dstUnit);

    boolean toEnemy();

    String log(Unit srcUnit, Unit dstUnit);
}
