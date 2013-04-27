package com.contrastofbeauty.tuts.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Executor of the meeting.
 */
public final class ClientExecutor {

    /**
     * Private constructor.
     */
    private ClientExecutor() {
    }

    /**
     * Main method.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {

        /**
         * Manage the meeting point, represented by a thread, for all the
         * registered threads. When all the threads have reached the meeting
         * point, the run() method of the meeting point thread is executed.
         */
        CyclicBarrier barrier = new CyclicBarrier(5, new MeetingRoom());

        // participant to the meeting
        new Thread(new Participant(barrier, "Charlie Chaplin")).start();
        new Thread(new Participant(barrier, "Rodolfo Valentino")).start();
        new Thread(new Participant(barrier, "Buster Keaton")).start();
        new Thread(new Participant(barrier, "Roscoe Arbuckle")).start();
        new Thread(new Participant(barrier, "Max Linder")).start();
    }
}
