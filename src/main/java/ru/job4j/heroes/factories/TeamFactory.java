package ru.job4j.heroes.factories;

import ru.job4j.heroes.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class TeamFactory {
    RaceAbstFactory factory;

    public TeamFactory(RaceAbstFactory factory) {
        this.factory = factory;
    }

    public List<Unit> createTeam() {
        List<Unit> team = new ArrayList<>();
        team.add(factory.createMage());
        System.out.println("Маг расы " + factory.getClass().getSimpleName() + " создан.");
        team.add(factory.createArcher());
        System.out.println("Лучник1 расы " + factory.getClass().getSimpleName() + " создан.");
        team.add(factory.createArcher());
        System.out.println("Лучник2 расы " + factory.getClass().getSimpleName() + " создан.");
        team.add(factory.createArcher());
        System.out.println("Лучник3 расы " + factory.getClass().getSimpleName() + " создан.");
        team.add(factory.createWarrior());
        System.out.println("Воин1 расы " + factory.getClass().getSimpleName() + " создан.");
        team.add(factory.createWarrior());
        System.out.println("Воин2 расы " + factory.getClass().getSimpleName() + " создан.");
        team.add(factory.createWarrior());
        System.out.println("Воин3 расы " + factory.getClass().getSimpleName() + " создан.");
        team.add(factory.createWarrior());
        System.out.println("Воин4 расы " + factory.getClass().getSimpleName() + " создан.");
        System.out.println();
        return team;
    }
}
