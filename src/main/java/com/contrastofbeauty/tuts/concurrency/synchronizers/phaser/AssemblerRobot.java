package com.contrastofbeauty.tuts.concurrency.synchronizers.phaser;

import java.util.concurrent.Phaser;

/**
 * An assembler robot represented by a thread.
 */
public class AssemblerRobot implements Runnable {

    /**
     * The phase the robot work on.
     */
    private Phaser workPhaser;

    /**
     * Name of the robot
     */
    private String name;

    /**
     * Constructor
     * @param phaser associated with the robot
     * @param robotName name of the robot
     */
    public AssemblerRobot(final Phaser phaser, final String robotName) {
        workPhaser = phaser;
        name = robotName;
        // the party register itself to synchronize
        workPhaser.register();
    }

    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
