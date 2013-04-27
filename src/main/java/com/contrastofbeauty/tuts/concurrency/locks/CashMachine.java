package com.contrastofbeauty.tuts.concurrency.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A cash machine thread-safe sharable object.
 * <p/>
 * It is a wrapper around a ReentrantLock object to simulate a resource which
 * can be shared among people, i.e. threads, in a thread-safe manner.
 *
 * @author blackat
 */
public class CashMachine implements Lock {

    /**
     * Cash machine reference object.
     */
    private Lock cashMachine;

    /**
     * Constructor.
     */
    public CashMachine() {
        cashMachine = new ReentrantLock();
    }

    @Override
    public final void lock() {
        cashMachine.lock();
    }

    @Override
    public final void lockInterruptibly() throws InterruptedException {
        cashMachine.lockInterruptibly();
    }

    @Override
    public final boolean tryLock() {
        return cashMachine.tryLock();
    }

    @Override
    public final boolean tryLock(final long time, final TimeUnit unit) throws
            InterruptedException {
        return cashMachine.tryLock();
    }

    @Override
    public final void unlock() {
        cashMachine.unlock();
    }

    @Override
    public final Condition newCondition() {
        return cashMachine.newCondition();
    }
}
