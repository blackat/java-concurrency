package com.contrastofbeauty.tuts.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * A partecipant represented by a thread.
 *
 * @author blackat
 */
public class Participant implements Runnable {

    /**
     * The meeting point, such as a room.
     */
    private CyclicBarrier meetingPoint;

    /**
     * Name of the partecipant.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param barrier         the meeting point
     * @param partecipantName name of the partecipant
     */
    public Participant(final CyclicBarrier barrier, final String partecipantName) {
        meetingPoint = barrier;
        name = partecipantName;
    }

    @Override
    public final void run() {
        System.out.println(name + " arrived at the meeting point.");
        try {
            meetingPoint.await();
        } catch (InterruptedException e) {
            System.err.println(e);
        } catch (BrokenBarrierException e) {
            System.err.println(e);
        }
    }
}
