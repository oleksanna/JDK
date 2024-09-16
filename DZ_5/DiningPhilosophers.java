package DZ_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public static void main(String[] args) {
        // Создаем вилки (замки)
        Lock[] forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }

        // Создаем философов
        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            Lock leftFork = forks[i];
            Lock rightFork = forks[(i + 1) % 5]; // круглый стол
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            philosophers[i].start();
        }

        // Ожидание завершения всех философов
        for (Philosopher philosopher : philosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
