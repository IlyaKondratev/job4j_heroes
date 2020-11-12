package ru.job4j.heroes;

import ru.job4j.heroes.moves.Move;
import ru.job4j.heroes.units.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logic {
    private final List<List<Unit>> teams = new ArrayList<>();

    public Logic(List<Unit> goodTeam, List<Unit> evilTeam) {
        teams.add(goodTeam);
        teams.add(evilTeam);
    }

    public void runGame() {
        List<List<Unit>> privTeam = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        int turn = chooseTurn();
        boolean run = true;
        while (run) {
            Unit srcUnit = !privTeam.get(turn).isEmpty() ? chooseUnit(privTeam.get(turn)) :
                                                            chooseUnit(teams.get(turn));
            Move move = srcUnit.chooseMove();
            List<Unit> targetTeam = new ArrayList<>();
            if (move.toEnemy()) {
                targetTeam.addAll(teams.get((turn+1) & 0x1));
                targetTeam.addAll(privTeam.get((turn+1) & 0x1));
            } else {
                targetTeam.addAll(teams.get(turn));
                targetTeam.addAll(privTeam.get(turn));
            }
            Unit dstUnit = chooseUnit(targetTeam);
            move.execute(srcUnit, dstUnit);
            if (!privTeam.get(turn).isEmpty()) {
                transferToUsual(teams.get(turn), privTeam.get(turn), turn);
                if (move.toEnemy()) {
                    clearDead(teams.get((turn + 1) & 0x1), privTeam.get((turn + 1) & 0x1), (turn + 1) & 0x1);
                    transferToUsual(teams.get((turn + 1) & 0x1), privTeam.get((turn + 1) & 0x1), (turn + 1) & 0x1);
                } else {
                    transferToPriv(teams.get(turn), privTeam.get(turn), turn);
                }
            } else {
                if (move.toEnemy()) {
                    clearDead(teams.get((turn + 1) & 0x1), privTeam.get((turn + 1) & 0x1), (turn + 1) & 0x1);
                    transferToUsual(teams.get((turn + 1) & 0x1), privTeam.get((turn + 1) & 0x1), (turn + 1) & 0x1);
                } else {
                    transferToPriv(teams.get(turn), privTeam.get(turn), turn);
                }
            }
            turn = (turn + 1) & 0x1;
            run = !((privTeam.get(0).isEmpty() && teams.get(0).isEmpty())
                    || (privTeam.get(1).isEmpty() && teams.get(1).isEmpty()));
        }

    }

    private Unit chooseUnit(List<Unit> team) {
        int index = (int) (Math.random() * team.size());
        return team.get(index);
    }

    private int chooseTurn() {
        return (int) (Math.random() * 2);
    }

    private void clearDead(List<Unit> team, List<Unit> privTeam, int teamNum) {
        if (team.removeIf(unit -> unit.isDead()) || privTeam.removeIf(unit -> unit.isDead())) {
            System.out.println("Удалены мертвые тела.");
            System.out.println("В " + teamNum + "ой обыч команде осталось " + team.size() + " существ.");
            System.out.println("В " + teamNum + "ой прив команде осталось " + privTeam.size() + " существ.");
        }
    }

    private void transferToPriv(List<Unit> team, List<Unit> privTeam, int teamNum) {
        for (Unit unit : team) {
            if (unit.isBuff()) {
                privTeam.add(unit);
            }
        }
        if (team.removeIf(unit -> unit.isBuff())) {
            System.out.println("Существа переводятся в баффнутую команду.");
            System.out.println("В " + teamNum + "ой обыч команде сейчас " + team.size() + " существ.");
            System.out.println("В " + teamNum + "ой прив команде сейчас " + privTeam.size() + " существ.");
        }
    }

    private void transferToUsual(List<Unit> team, List<Unit> privTeam, int teamNum) {
        for (Unit unit : privTeam) {
            if (!unit.isBuff()) {
                team.add(unit);
            }
        }
        if (privTeam.removeIf(unit -> !unit.isBuff())) {
            System.out.println("Существа переводятся в обычную команду.");
            System.out.println("В " + teamNum + "ой обыч команде сейчас " + team.size() + " существ.");
            System.out.println("В " + teamNum + "ой прив команде сейчас " + privTeam.size() + " существ.");
        }
    }

}
