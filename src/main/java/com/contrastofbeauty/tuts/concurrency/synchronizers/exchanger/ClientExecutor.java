package com.contrastofbeauty.tuts.concurrency.synchronizers.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Allow two friends, represented by threads, t exchange their presents.
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

        // object used to exchange presents between two friends
        Exchanger<String> presents = new Exchanger<String>();

        new Thread(new Friend(presents, "Alessandro Delpiero", "De Bello Gallico, di Giulio Cesare")).start();
        new Thread(new Friend(presents, "Michel Platini", "Fabulae, di Fedro")).start();
    }
}
