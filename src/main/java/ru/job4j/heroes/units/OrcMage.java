package ru.job4j.heroes.units;

import ru.job4j.heroes.moves.*;

import java.util.Arrays;
import java.util.List;

public class OrcMage extends Unit {

    private final List<Move> moves = Arrays.asList(new Buff(), new Curse());

    public OrcMage() {
        super();
    }

    @Override
    public Move chooseMove() {
        int indexMove = (int) (Math.random() * moves.size());
        return this.moves.get(indexMove);
    }

}
