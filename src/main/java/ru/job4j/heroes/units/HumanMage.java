package ru.job4j.heroes.units;

import ru.job4j.heroes.moves.Buff;
import ru.job4j.heroes.moves.MagicAttack;
import ru.job4j.heroes.moves.Move;

import java.util.Arrays;
import java.util.List;

public class HumanMage extends Unit{

    private final List<Move> moves = Arrays.asList(new Buff(), new MagicAttack(4));

    public HumanMage() {
        super();
    }

    @Override
    public Move chooseMove() {
        int indexMove = (int) (Math.random() * moves.size());
        return this.moves.get(indexMove);
    }

}
