package DZ_5;

import java.util.concurrent.locks.Lock;

public class Philosopher extends Thread {
    private final int id;
    private final Lock leftFork;
    private final Lock rightFork;
    private int eatingCount = 0;

    public Philosopher(int id, Lock leftFork, Lock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (eatingCount < 3) { // философ должен поесть три раза
                think();
                pickUpForks();
                eat();
                putDownForks();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет.");
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    private void pickUpForks() {
        leftFork.lock();
        rightFork.lock();
    }

    private void eat() throws InterruptedException {
        System.out.println("Философ " + id + " ест.");
        eatingCount++;
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    private void putDownForks() {
        rightFork.unlock();
        leftFork.unlock();
        System.out.println("Философ " + id + " закончил есть.");
    }
}
