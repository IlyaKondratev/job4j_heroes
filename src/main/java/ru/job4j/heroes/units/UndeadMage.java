package ru.job4j.heroes.units;

import ru.job4j.heroes.moves.Buff;
import ru.job4j.heroes.moves.Debuff;
import ru.job4j.heroes.moves.MagicAttack;
import ru.job4j.heroes.moves.Move;

import java.util.Arrays;
import java.util.List;

public class UndeadMage extends Unit {

    private final List<Move> moves = Arrays.asList(new Debuff(), new MagicAttack(5));

    public UndeadMage() {
        super();
    }

    @Override
    public Move chooseMove() {
        int indexMove = (int) (Math.random() * moves.size());
        return this.moves.get(indexMove);
    }

}
