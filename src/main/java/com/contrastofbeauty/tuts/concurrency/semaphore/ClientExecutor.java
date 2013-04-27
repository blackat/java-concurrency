package com.contrastofbeauty.tuts.concurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Runner of the example.
 *
 * @author blackat
 */
public final class ClientExecutor {

    /**
     * Private constructor.
     */
    private ClientExecutor() {
    }

    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        // semaphore control the access to the 3 available cash machines
        Semaphore cashmachines = new Semaphore(2);

        new Thread(new Person(cashmachines, "Einstein"), "Einstein").start();
        new Thread(new Person(cashmachines, "Fermi"), "Fermi").start();
        new Thread(new Person(cashmachines, "oppenheimer"), "oppenheimer").start();
        new Thread(new Person(cashmachines, "Majorana"), "Majorana").start();
        new Thread(new Person(cashmachines, "Turing"), "Turing").start();
        new Thread(new Person(cashmachines, "von Neumann"), "von Neumann").start();
    }
}
