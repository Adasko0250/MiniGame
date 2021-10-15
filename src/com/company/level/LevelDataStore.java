package com.company.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LevelDataStore {

    private static final int MAX_LEVEL_INDEX = 19;
    public static ArrayList<Level> Levels = levels();
    public static int FIRST_LEVEL_EXPERIENCE = Levels.get(0).getRange().getLowerBound();


    private static ArrayList<Level> levels() {
        List<Level> levelList = lvlList().entrySet()
                .stream()
                .map(entry -> new Level(hpBoost().get(entry.getKey()),
                        entry.getKey(), new LevelRange(entry.getValue(), 0)))
                .collect(Collectors.toList());

        fillUpperRange(levelList);

        return new ArrayList<>(levelList);
    }

    private static void fillUpperRange(List<Level> levels) {
         levels
                .stream().filter(lvl -> lvl.getLvl() != 20)
                .forEach(l -> l.getRange().setUpperBound(lvlList().get(l.getLvl() + 1)));
         levels.get(MAX_LEVEL_INDEX).getRange().setUpperBound(Integer.MAX_VALUE);

    }

    private static HashMap<Integer, Integer> hpBoost() {
        HashMap<Integer, Integer> gainlvl = new HashMap<>();
        for (int i = 10; i < 100; i++) {
            for (int j = 1; j <= 20; j++) {
                i += ((i + (i * 2)) / (j + 2));
                gainlvl.put(j, i);
            }
        }
        return gainlvl;
    }

    private static HashMap<Integer, Integer> lvlList() {
        HashMap<Integer, Integer> gainlvl = new HashMap<>();
        for (int i = 100; i < 1000; i++) {
            for (int j = 1; j <= 20; j++) {
                i += ((i + (i * 6)) / (j + 1));
                gainlvl.put(j, i);
            }
        }
        return gainlvl;
    }
}
