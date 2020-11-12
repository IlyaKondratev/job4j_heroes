package ru.job4j.heroes;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit.";
    }

    @Override
    public boolean execute(Input input) {
        return false;
    }
}
