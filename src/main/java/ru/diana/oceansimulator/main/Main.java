package ru.diana.oceansimulator.main;

import ru.diana.oceansimulator.entity.KillerWhale;
import ru.diana.oceansimulator.util.EventProcessing;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //море
        //косатка, ест тюленей, рыбу, черепах, китов, акул
        Thread.sleep(1000);
        KillerWhale killerwhale = new KillerWhale();
        EventProcessing eventProcessing = new EventProcessing();
        eventProcessing.startSimulation(killerwhale);
    }
}
