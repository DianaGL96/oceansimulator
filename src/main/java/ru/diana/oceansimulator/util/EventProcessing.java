package ru.diana.oceansimulator.util;

import ru.diana.oceansimulator.entity.KillerWhale;

import java.util.Random;

public class EventProcessing {
    //1 косатка плывёт -6 0 - 20%
    //2 косатка спит +20 21 - 40%
    //3 косатка ест рыбу -3 энергии + 8 здоровья 41 - 51%
    //4 косатка ест тюленя - 8 энергии + 15 здоровья 52 - 58%
    //5 косатка ест черепаху - 5 энергии +10 здоровья 59 - 65%
    //6 косатка нападает на китов - 20 энергии 66 - 77%
    //7 косатка ест детёныша кита + 30 здоровья 78 - 84%
    //8 косатка нападает на акулу - 25 энергии 85 - 91%
    //9 косатка ест акулу + 35 здоровья 92 - 97%
    //10 на косатку нападают охотники - 20 здоровья 98 - 100%

    String status;

    public void startSimulation (KillerWhale killerWhale) throws InterruptedException {
        while (checkStatus(killerWhale)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber <= 20) {
                move(killerWhale);
            }
            else if (eventNumber >= 21 && eventNumber <= 40) {
                sleepEvent(killerWhale);
            }
            else if (eventNumber >= 41 && eventNumber <= 51) {
                eatFish(killerWhale);
            } else if (eventNumber >= 52 && eventNumber <= 58) {
                eatSeal(killerWhale);
            }
            else if (eventNumber >= 59 && eventNumber <= 65) {
                eatTurtle(killerWhale);
            }
            else if (eventNumber >= 66 && eventNumber <= 84) {
                attackWhales(killerWhale);
            }
            else if (eventNumber >= 85 && eventNumber <= 97) {
                attackShark(killerWhale);
            }
            else if (eventNumber >= 98 && eventNumber <= 100) {
                hunterAttack(killerWhale);
            }
            Thread.sleep(1000);

        }
        System.out.println("Косатка погибла... The end.");

    }
    public String killerWhaleStatus(KillerWhale killerWhale) {
        return  "Текущая энергия: " + killerWhale.getEnergy() + ". Текущее здоровье: " + killerWhale.getHealf();
    }

    private void sleepEvent (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy += 20;
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        checkLimitsEnergy(killerWhale);
        status = killerWhaleStatus(killerWhale);
        System.out.println("Косатка поспала, +20 энергии.\n" + status);
    }

    private void move (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 20;
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        checkLimitsEnergy(killerWhale);
        status = killerWhaleStatus(killerWhale);
        System.out.println("Косатка поплавала, но безуспешно. В этот раз добычи не было, -6 энергии.\n" + status);
    }

    private void eatFish (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 10;
        int health = killerWhale.getHealf();
        health = health + (int) (killerWhale.getFactor() * 15);
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealf(health);
        checkLimitsHealth(killerWhale);
        checkLimitsEnergy(killerWhale);
        status = killerWhaleStatus(killerWhale);
        System.out.println("Косатка поела рыбу, - 3 энергии.\n" + status);
    }

    private void eatSeal (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 15;
        int health = killerWhale.getHealf();
        health = health + (int) (killerWhale.getFactor() * 20);
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealf(health);
        checkLimitsHealth(killerWhale);
        checkLimitsEnergy(killerWhale);
        status = killerWhaleStatus(killerWhale);
        System.out.println("Косатка поела тюленя, - 8 энергии.\n" + status);
    }
    private void eatTurtle (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 12;
        int health = killerWhale.getHealf();
        health = health + (int) (killerWhale.getFactor() * 18);
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealf(health);
        checkLimitsHealth(killerWhale);
        checkLimitsEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealf(health);
        status = killerWhaleStatus(killerWhale);
        System.out.println("Косатка поела черепаху, - 5 энергии.\n" + status);
    }
    private void attackWhales(KillerWhale killerWhale) {
    Random random = new Random();
    int energy = killerWhale.getEnergy();
    int health = killerWhale.getHealf();
    boolean wins = random.nextBoolean();
    if (wins) {
        energy -= 30;
        health = health + (int) (killerWhale.getFactor() * 40);
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealf(health);
        checkLimitsHealth(killerWhale);
        checkLimitsEnergy(killerWhale);
        status = killerWhaleStatus(killerWhale);
        System.out.println("Косатка напала на семейство китов и победила. Она съела детёныша кита, -20 энергии.\n" + status);
    }
        else  {
            energy -= 35;
            health = health + (int) (killerWhale.getFactor() * -20);
            checkEnergy(killerWhale);
            killerWhale.setEnergy(energy);
            killerWhale.setHealf(health);
            checkLimitsHealth(killerWhale);
            checkLimitsEnergy(killerWhale);
            status = killerWhaleStatus(killerWhale);
            System.out.println("Косатка напала на семейство китов и проиграла, -20 энергии.\n" + status);
        }

    }
    private void attackShark(KillerWhale killerWhale) {
        Random random = new Random();
        int energy = killerWhale.getEnergy();
        int health = killerWhale.getHealf();
        boolean wins = random.nextBoolean();
        if (wins) {
            energy -= 30;
            health = health + (int) (killerWhale.getFactor() * 45);
            checkEnergy(killerWhale);
            killerWhale.setEnergy(energy);
            killerWhale.setHealf(health);
            checkLimitsHealth(killerWhale);
            checkLimitsEnergy(killerWhale);
            status = killerWhaleStatus(killerWhale);
            System.out.println("Косатка напала на акулу и победила. Она съела акулу, -25 энергии.\n" + status);
        }
        else  {
            energy -= 30;
            health = health + (int) (killerWhale.getFactor() * -20);
            checkEnergy(killerWhale);
            killerWhale.setEnergy(energy);
            killerWhale.setHealf(health);
            checkLimitsHealth(killerWhale);
            checkLimitsEnergy(killerWhale);
            status = killerWhaleStatus(killerWhale);
            System.out.println("Косатка напала на акулу и проиграла, -20 энергии.\n" + status);
        }

    }
    private void hunterAttack(KillerWhale killerWhale) {
        int health = killerWhale.getHealf();
        health -= -20;
        checkEnergy(killerWhale);
        killerWhale.setHealf(health);
        checkLimitsHealth(killerWhale);
        status = killerWhaleStatus(killerWhale);
        System.out.println("На косатку напали охотники.\n" + status);
    }

    private boolean checkStatus(KillerWhale killerWhale) {
        if (killerWhale.getHealf() <= 0) {
            return false;
        }
        else {
            return true;
        }
    }
    private void checkEnergy(KillerWhale killerWhale) {
        if (killerWhale.getEnergy() <= 0) {
            int health = killerWhale.getHealf();
            health -= 5;
            killerWhale.setHealf(health);
            checkLimitsHealth(killerWhale);
        }
    }
    private void checkLimitsHealth(KillerWhale killerWhale) {
        int health = killerWhale.getHealf();
        if (health >= 100 ) {
            health = 100;
        } else if (health <= 0) {
            health = 0;
        }
        killerWhale.setHealf(health);
    }
    private void checkLimitsEnergy(KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        if (energy >= 100) {
            energy = 100;
        } else if (energy <= 0) {
            energy = 0;
        }
        killerWhale.setEnergy(energy);
    }



}
