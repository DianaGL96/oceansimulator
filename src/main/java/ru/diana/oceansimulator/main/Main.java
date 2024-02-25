package ru.diana.oceansimulator.main;

import ru.diana.oceansimulator.entity.KillerWhale;
import ru.diana.oceansimulator.util.EventSimulator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        KillerWhale killerwhale = new KillerWhale();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(killerwhale);
    }
}
