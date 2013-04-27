package com.contrastofbeauty.tuts.concurrency.atomicvariables;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * An executor to test atomic variables
 *
 * @author blackat
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
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
    }
}
