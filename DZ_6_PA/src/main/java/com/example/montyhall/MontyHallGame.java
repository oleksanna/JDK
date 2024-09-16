package com.example.montyhall ;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
public class MontyHallGame {

    private final Random random = new Random();

    public void runSimulation(int trials) {
        HashMap<Integer, String> results = new HashMap<>();

        int winsWithSwitch = 0;
        int winsWithoutSwitch = 0;

        for (int i = 1; i <= trials; i++) {
            boolean resultWithSwitch = playGame(true);
            boolean resultWithoutSwitch = playGame(false);

            if (resultWithSwitch) winsWithSwitch++;
            if (resultWithoutSwitch) winsWithoutSwitch++;

            results.put(i, "Trial " + i + " - Win with switch: " + resultWithSwitch + ", Win without switch: " + resultWithoutSwitch);
        }

        System.out.println("Wins with switch: " + winsWithSwitch + "/" + trials);
        System.out.println("Wins without switch: " + winsWithoutSwitch + "/" + trials);
    }

    private boolean playGame(boolean switchChoice) {
        int carDoor = random.nextInt(3);
        int chosenDoor = random.nextInt(3);

        int revealedDoor = revealDoor(carDoor, chosenDoor);
        int finalChoice = switchChoice ? switchDoor(chosenDoor, revealedDoor) : chosenDoor;

        return finalChoice == carDoor;
    }

    private int revealDoor(int carDoor, int chosenDoor) {
        int revealedDoor;
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == carDoor || revealedDoor == chosenDoor);

        return revealedDoor;
    }

    private int switchDoor(int chosenDoor, int revealedDoor) {
        for (int door = 0; door < 3; door++) {
            if (door != chosenDoor && door != revealedDoor) {
                return door;
            }
        }
        return chosenDoor; // Should not happen
    }

    public static void main(String[] args) {
        MontyHallGame game = new MontyHallGame();
        game.runSimulation(1000);
    }
}
