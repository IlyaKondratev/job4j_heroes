package ru.job4j.heroes;

public interface UserAction {
    String name();

    boolean execute (Input input);
}
