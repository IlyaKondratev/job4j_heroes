package ru.job4j.heroes;

import ru.job4j.heroes.factories.*;

import java.util.Arrays;
import java.util.List;

public class StartAction implements UserAction {
    private final Output out;

    public StartAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Start the game.";
    }

    @Override
    public boolean execute(Input input) {
        List<RaceAbstFactory> goodTeamFactories = Arrays.asList(new ElfFactory(), new HumanFactory());
        List<RaceAbstFactory> evilTeamFactories = Arrays.asList(new OrcFactory(), new UndeadFactory());
        int chooseGoodFactory = (int) (Math.random() * goodTeamFactories.size());
        int chooseEvilFactory = (int) (Math.random() * evilTeamFactories.size());
        TeamFactory goodTeam = new TeamFactory(goodTeamFactories.get(chooseGoodFactory));
        TeamFactory evilTeam = new TeamFactory(evilTeamFactories.get(chooseEvilFactory));
        Logic game = new Logic(goodTeam.createTeam(), evilTeam.createTeam());
        game.runGame();
        return true;
    }
}