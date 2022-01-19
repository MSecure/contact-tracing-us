package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    public static final AtomicHelper ATOMIC_HELPER;
    public static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
    public volatile int remaining;
    public volatile Set<Throwable> seenExceptions = null;

    public static abstract class AtomicHelper {
        public AtomicHelper(AnonymousClass1 r1) {
        }

        public abstract void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2);

        public abstract int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState);
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        public final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
        public final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super(null);
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            this.seenExceptionsUpdater.compareAndSet(aggregateFutureState, null, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        public SynchronizedAtomicHelper(AnonymousClass1 r1) {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.seenExceptions == null) {
                    aggregateFutureState.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            int i;
            synchronized (aggregateFutureState) {
                i = aggregateFutureState.remaining - 1;
                aggregateFutureState.remaining = i;
            }
            return i;
        }
    }

    static {
        AtomicHelper atomicHelper;
        Throwable th = null;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
        } catch (Throwable th2) {
            th = th2;
            atomicHelper = new SynchronizedAtomicHelper(null);
        }
        ATOMIC_HELPER = atomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public AggregateFutureState(int i) {
        this.remaining = i;
    }
}
