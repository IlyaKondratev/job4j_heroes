package ru.job4j.heroes.factories;

import ru.job4j.heroes.units.Unit;

public interface RaceAbstFactory {

    Unit createMage();

    Unit createArcher();

    Unit createWarrior();

}
