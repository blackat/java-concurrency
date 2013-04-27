package com.contrastofbeauty.tuts.concurrency.synchronizers.cyclicbarrier;

/**
 * A meeting room represented by a thread.
 */
public class MeetingRoom extends Thread {

    @Override
    public final void run() {
        System.out.println("All the participants have arrived at the meeting room.");
    }
}
