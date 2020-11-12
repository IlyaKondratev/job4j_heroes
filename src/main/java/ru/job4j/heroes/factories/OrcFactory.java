package ru.job4j.heroes.factories;

import ru.job4j.heroes.units.OrcArcher;
import ru.job4j.heroes.units.OrcMage;
import ru.job4j.heroes.units.OrcWarrior;
import ru.job4j.heroes.units.Unit;

public class OrcFactory implements RaceAbstFactory {
    @Override
    public Unit createMage() {
        return new OrcMage();
    }

    @Override
    public Unit createArcher() {
        return new OrcArcher();
    }

    @Override
    public Unit createWarrior() {
        return new OrcWarrior();
    }
}
