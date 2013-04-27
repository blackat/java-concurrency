package com.contrastofbeauty.tuts.concurrency.synchronizers.phaser;

import java.util.concurrent.Phaser;

/**
 * Executor of the assembler chain.
 */
public final class ClientExecutor {

    /**
     * Private constructor.
     */
    private ClientExecutor() {

    }

    /**
     * Main method.
     * @param args command line arguments
     */
    public static void main(final String args) {

        // only one party is register, other parties can further register themselves
        Phaser assembler = new Phaser(1);

        new Thread(new AssemblerRobot(assembler, "External assembler")).start();

        new Thread(new AssemblerRobot(assembler, "Interior assembler")).start();

        new Thread(new AssemblerRobot(assembler, "Wheel assembler")).start();
    }
}
