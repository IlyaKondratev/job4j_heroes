package ru.job4j.heroes.factories;

import ru.job4j.heroes.units.UndeadArcher;
import ru.job4j.heroes.units.UndeadMage;
import ru.job4j.heroes.units.UndeadWarrior;
import ru.job4j.heroes.units.Unit;

public class UndeadFactory implements RaceAbstFactory {
    @Override
    public Unit createMage() {
        return new UndeadMage();
    }

    @Override
    public Unit createArcher() {
        return new UndeadArcher();
    }

    @Override
    public Unit createWarrior() {
        return new UndeadWarrior();
    }
}
