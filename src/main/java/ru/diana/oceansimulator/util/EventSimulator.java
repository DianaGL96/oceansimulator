package ru.diana.oceansimulator.util;

import ru.diana.oceansimulator.entity.KillerWhale;

import java.util.Random;

public class EventSimulator {

    public void startSimulation (KillerWhale killerWhale) throws InterruptedException {
        while (checkStatus(killerWhale)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber <= 20) {
                move(killerWhale);
            }
            else if (eventNumber >= 21 && eventNumber <= 36) {
                sleepEvent(killerWhale);
            }
            else if (eventNumber >= 37 && eventNumber <= 45) {
                eatFish(killerWhale);
            } else if (eventNumber >= 46 && eventNumber <= 58) {
                eatSeal(killerWhale);
            }
            else if (eventNumber >= 59 && eventNumber <= 65) {
                eatTurtle(killerWhale);
            }
            else if (eventNumber >= 66 && eventNumber <= 76) {
                attackWhales(killerWhale);
            }
            else if (eventNumber >= 77 && eventNumber <= 87) {
                attackShark(killerWhale);
            }
            else if (eventNumber >= 88 && eventNumber <= 100) {
                hunterAttack(killerWhale);
            }
            Thread.sleep(1000);
        }
        System.out.println("Косатка погибла... The end.");

    }

    public void killerWhaleStatus(KillerWhale killerWhale) {
        String status = "Текущая энергия: " + killerWhale.getEnergy() + ". Текущее здоровье: " + killerWhale.getHealth() + "\n";
        System.out.println(status);
    }

    private void sleepEvent (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy += 30;
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        checkLimitsEnergy(killerWhale);
        System.out.println("Косатка поспала, +30 энергии.");
        killerWhaleStatus(killerWhale);
    }

    private void move (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 10;
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        checkLimitsEnergy(killerWhale);
        System.out.println("Косатка поплавала, но безуспешно. В этот раз добычи не было, -10 энергии.");
        killerWhaleStatus(killerWhale);
    }

    private void eatFish (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 5;
        int health = killerWhale.getHealth();
        health = health + (int) (killerWhale.getFactor() * 15);
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealth(health);
        checkLimitsHealth(killerWhale);
        checkLimitsEnergy(killerWhale);
        System.out.println("Косатка поела рыбу, - 5 энергии.");
        killerWhaleStatus(killerWhale);
    }

    private void eatSeal (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 10;
        int health = killerWhale.getHealth();
        health = health + (int) (killerWhale.getFactor() * 20);
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealth(health);
        checkLimitsHealth(killerWhale);
        checkLimitsEnergy(killerWhale);
        System.out.println("Косатка поела тюленя, - 10 энергии.");
        killerWhaleStatus(killerWhale);
    }

    private void eatTurtle (KillerWhale killerWhale) {
        int energy = killerWhale.getEnergy();
        energy -= 12;
        int health = killerWhale.getHealth();
        health = health + (int) (killerWhale.getFactor() * 18);
        checkEnergy(killerWhale);
        killerWhale.setEnergy(energy);
        killerWhale.setHealth(health);
        checkLimitsHealth(killerWhale);
        checkLimitsEnergy(killerWhale);
        System.out.println("Косатка поела черепаху, - 12 энергии.");
        killerWhaleStatus(killerWhale);
    }

    private void attackWhales(KillerWhale killerWhale) {
        Random random = new Random();
        int energy = killerWhale.getEnergy();
        int health = killerWhale.getHealth();
        boolean wins = random.nextBoolean();
        if (wins) {
            energy -= 30;
            health = health + (int) (killerWhale.getFactor() * 40);
            checkEnergy(killerWhale);
            killerWhale.setEnergy(energy);
            killerWhale.setHealth(health);
            checkLimitsHealth(killerWhale);
            checkLimitsEnergy(killerWhale);
            System.out.println("Косатка напала на семейство китов и победила. Она съела детёныша кита, -30 энергии.");
            killerWhaleStatus(killerWhale);
        } else {
            energy -= 35;
            health = health + (int) (killerWhale.getFactor() * -20);
            checkEnergy(killerWhale);
            killerWhale.setEnergy(energy);
            killerWhale.setHealth(health);
            checkLimitsHealth(killerWhale);
            checkLimitsEnergy(killerWhale);
            System.out.println("Косатка напала на семейство китов и проиграла, -35 энергии.");
            killerWhaleStatus(killerWhale);
        }

    }

    private void attackShark(KillerWhale killerWhale) {
        Random random = new Random();
        int energy = killerWhale.getEnergy();
        int health = killerWhale.getHealth();
        boolean wins = random.nextBoolean();
        if (wins) {
            energy -= 30;
            health = health + (int) (killerWhale.getFactor() * 18);
            checkEnergy(killerWhale);
            killerWhale.setEnergy(energy);
            killerWhale.setHealth(health);
            checkLimitsHealth(killerWhale);
            checkLimitsEnergy(killerWhale);
            System.out.println("Косатка напала на акулу и победила. Она съела акулу, -30 энергии.");
            killerWhaleStatus(killerWhale);
        }
        else  {
            energy -= 30;
            health = health + (int) (killerWhale.getFactor() * -20);
            checkEnergy(killerWhale);
            killerWhale.setEnergy(energy);
            killerWhale.setHealth(health);
            checkLimitsHealth(killerWhale);
            checkLimitsEnergy(killerWhale);
            System.out.println("Косатка напала на акулу и проиграла, -30 энергии.");
            killerWhaleStatus(killerWhale);
        }

    }

    private void hunterAttack(KillerWhale killerWhale) {
        int health = killerWhale.getHealth();
        health -= 20;
        checkEnergy(killerWhale);
        killerWhale.setHealth(health);
        checkLimitsHealth(killerWhale);
        System.out.println("На косатку напали охотники.");
        killerWhaleStatus(killerWhale);
    }

    private boolean checkStatus(KillerWhale killerWhale) {
        return killerWhale.getHealth() > 0;
    }

    private void checkEnergy(KillerWhale killerWhale) {
        if (killerWhale.getEnergy() <= 0) {
            int health = killerWhale.getHealth();
            health -= 30;
            killerWhale.setHealth(health);
            checkLimitsHealth(killerWhale);
        }
    }

    private void checkLimitsHealth(KillerWhale killerWhale) {
        int health = killerWhale.getHealth();
        if (health >= 100 ) {
            health = 100;
        } else if (health <= 0) {
            health = 0;
        }
        killerWhale.setHealth(health);
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
