package ru.job4j.heroes.units;

import ru.job4j.heroes.moves.MeleeAttack;
import ru.job4j.heroes.moves.Move;

import java.util.Arrays;
import java.util.List;

public class HumanWarrior extends Unit {

    private final List<Move> moves = Arrays.asList(new MeleeAttack(18));

    public HumanWarrior() {
        super();
    }

    @Override
    public Move chooseMove() {
        int indexMove = (int) (Math.random() * moves.size());
        return this.moves.get(indexMove);
    }

}
