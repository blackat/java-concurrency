package com.contrastofbeauty.tuts.concurrency.locks;

import java.util.concurrent.locks.Lock;

/**
 * Simulates some people withdrawing the money from a cash machine.
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

        Lock cashMachine = new CashMachine();

        new Person(cashMachine, "Albert Einstein");
        new Person(cashMachine, "Enrico Fermi");
        new Person(cashMachine, "Rita Levi Montalcini");
        new Person(cashMachine, "John Nash");
    }
}
