package com.contrastofbeauty.tuts.concurrency.locks;

import java.util.concurrent.locks.Lock;

/**
 * A person represented by a thread. A thread is a good way to simulate the
 * behavior and the interaction of a person into a system.
 * <p/>
 * A thread as a person has an independent interaction with other people, threads,
 * and shared objects representing anther component of a system.
 * <p/>
 * run() method represents the actions a person does to withdraw the money.
 *
 * @author blackat
 */
public class Person extends Thread {

    /**
     * Withdrawal simulation time.
     */
    public static final int WITHDRAWAL_TIME = 1000;

    /**
     * Shared object reference.
     */
    private Lock cashMachine;

    /**
     * Name of the person.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param machine    the shared object
     * @param personName the name of the person
     */
    public Person(final Lock machine, final String personName) {
        cashMachine = machine;
        name = personName;
        start();
    }

    @Override
    public final void run() {
        try {
            System.out.println(name + " waiting in front the cash machine.");
            cashMachine.lock(); // wait to acquire the lock on the shared object
            System.out.println(name + " access the cash machine.");
            Thread.sleep(WITHDRAWAL_TIME); // simulate withdrawal
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            System.out.println(name + " has withdrawn the money.");
            cashMachine.unlock(); // release the lock on the shared object
        }
    }
}
