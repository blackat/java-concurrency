package com.contrastofbeauty.tuts.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * A runner represented as a thread.
 *
 * @author blackat
 */
public class Runner implements Runnable {

    /**
     * Timer reference.
     */
    private CountDownLatch timer;

    /**
     * Constructor.
     *
     * @param counter timer to waiting for
     */
    public Runner(final CountDownLatch counter) {
        timer = counter;
    }

    @Override
    public final void run() {
        System.out.println(Thread.currentThread().getName() + " waiting to run.");
        try {
            // the thread waits for the timer to reach 0 and be released
            timer.await();

        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println(Thread.currentThread().getName() + " started to run.");
    }
}
