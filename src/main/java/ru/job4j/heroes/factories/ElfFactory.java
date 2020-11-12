package ru.job4j.heroes.factories;

import ru.job4j.heroes.units.ElfArcher;
import ru.job4j.heroes.units.ElfMage;
import ru.job4j.heroes.units.ElfWarrior;
import ru.job4j.heroes.units.Unit;

public class ElfFactory implements RaceAbstFactory {
    @Override
    public Unit createMage() {
        return new ElfMage();
    }

    @Override
    public Unit createArcher() {
        return new ElfArcher();
    }

    @Override
    public Unit createWarrior() {
        return new ElfWarrior();
    }
}
