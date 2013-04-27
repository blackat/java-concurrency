package com.contrastofbeauty.tuts.concurrency.exchanger;

import java.util.concurrent.Exchanger;

/**
 * A friend.
 */
public class Friend implements Runnable {

    /**
     * Reference to friend present exchanger object.
     */
    private Exchanger<String> presents;

    /**
     * Name of the friend.
     */
    private String name;

    /**
     * Present to donate.
     */
    private String present;

    /**
     * Constructor.
     *
     * @param exchanger     present exchanger object
     * @param friendName    name of the friend
     * @param presentToGive present to donate to another friend
     */
    public Friend(final Exchanger<String> exchanger, final String friendName, final String presentToGive) {
        presents = exchanger;
        name = friendName;
        present = presentToGive;
    }

    @Override
    public final void run() {

        String received;

        System.out.println(name + " give as a present " + present);
        try {
            received = presents.exchange(present);
            System.out.println(name + " get as a present " + received);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
