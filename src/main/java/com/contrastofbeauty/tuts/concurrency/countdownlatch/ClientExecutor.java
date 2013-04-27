package com.contrastofbeauty.tuts.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Client will start the countdown and then will release all the threads.
 *
 * @author blackat
 */
public final class ClientExecutor {

    /**
     * Seconds of the countdown.
     */
    public static final int COUNTDOWN_SECONDS = 10;

    /**
     * Seconds to wait.
     */
    public static final int SECONDS_TO_WAIT = 1000;

    /**
     * Private constructor.
     */
    private ClientExecutor() {
    }

    /**
     * Main method to be run.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        CountDownLatch timer = new CountDownLatch(COUNTDOWN_SECONDS);

        // all the runners each one represented by one thread
        new Thread(new Runner(timer), "Pietro Paolo Mennea").start();
        new Thread(new Runner(timer), "Sara Simeoni").start();
        new Thread(new Runner(timer), "Luigi Beccali").start();
        new Thread(new Runner(timer), "Adolfo Consolini").start();
        new Thread(new Runner(timer), "Maurizio Damilano").start();

        System.out.println("Timer started");
        Long count = timer.getCount();

        while (count > 0) {
            try {
                Thread.sleep(SECONDS_TO_WAIT); // simulate the passing of 1 sec.
                System.out.print(count + " ");

                if (count == 1) {
                    System.out.println("GO!");
                }
                timer.countDown(); // decrement the timer of 1 unit
                count = timer.getCount();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
