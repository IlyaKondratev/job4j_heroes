package ru.job4j.heroes.factories;

import ru.job4j.heroes.units.HumanArcher;
import ru.job4j.heroes.units.HumanMage;
import ru.job4j.heroes.units.HumanWarrior;
import ru.job4j.heroes.units.Unit;

public class HumanFactory implements RaceAbstFactory {
    @Override
    public Unit createMage() {
        return new HumanMage();
    }

    @Override
    public Unit createArcher() {
        return new HumanArcher();
    }

    @Override
    public Unit createWarrior() {
        return new HumanWarrior();
    }
}
