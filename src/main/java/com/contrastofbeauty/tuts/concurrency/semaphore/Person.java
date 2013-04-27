package com.contrastofbeauty.tuts.concurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * A person.
 *
 * @author blackat
 */
public class Person implements Runnable {

    /**
     * Time for the withdrawal.
     */
    public static final int WITHDRAWAL_TIME = 1000;

    /**
     * Cash machine semaphore reference.
     */
    private Semaphore cashMachine;

    /**
     * Name of the person.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param machine semaphore to acquire the resource
     * @param personName  name of the person
     */
    public Person(final Semaphore machine, final String personName) {
        cashMachine = machine;
        name = personName;
    }

    @Override
    public final void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting for the cash machine.");

        try {
            cashMachine.acquire();
            System.out.println(Thread.currentThread().getName() + " is using the cash machine.");

            Thread.sleep(WITHDRAWAL_TIME); // simulate the user withdrawal

            System.out.println(Thread.currentThread().getName() + " has done with the cash machine.");
            cashMachine.release();
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
