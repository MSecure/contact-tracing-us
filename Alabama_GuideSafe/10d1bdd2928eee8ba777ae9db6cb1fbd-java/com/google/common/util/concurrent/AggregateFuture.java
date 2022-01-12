package com.google.common.util.concurrent;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    public static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    public final boolean allMustSucceed;
    public final boolean collectsValues;
    public ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

    public AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
        super(immutableCollection.size());
        this.futures = immutableCollection;
        this.allMustSucceed = z;
        this.collectsValues = z2;
    }

    public static void access$200(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        if (aggregateFuture != null) {
            int decrementAndGetRemainingCount = AggregateFutureState.ATOMIC_HELPER.decrementAndGetRemainingCount(aggregateFuture);
            int i = 0;
            ReactYogaConfigProvider.checkState1(decrementAndGetRemainingCount >= 0, "Less than 0 remaining futures");
            if (decrementAndGetRemainingCount == 0) {
                if (immutableCollection != null) {
                    UnmodifiableListIterator listIterator = ((ImmutableList) immutableCollection).listIterator();
                    while (listIterator.hasNext()) {
                        Future<? extends InputT> future = (Future) listIterator.next();
                        if (!future.isCancelled()) {
                            aggregateFuture.collectValueFromNonCancelledFuture(i, future);
                        }
                        i++;
                    }
                }
                aggregateFuture.seenExceptions = null;
                aggregateFuture.handleAllCompleted();
                CollectionFuture collectionFuture = (CollectionFuture) aggregateFuture;
                collectionFuture.futures = null;
                collectionFuture.values = null;
                return;
            }
            return;
        }
        throw null;
    }

    public static boolean addCausalChain(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        CollectionFuture collectionFuture = (CollectionFuture) this;
        collectionFuture.futures = null;
        collectionFuture.values = null;
        if ((this.value instanceof AbstractFuture.Cancellation) && (immutableCollection != null)) {
            boolean wasInterrupted = wasInterrupted();
            UnmodifiableListIterator listIterator = ((ImmutableList) immutableCollection).listIterator();
            while (listIterator.hasNext()) {
                ((Future) listIterator.next()).cancel(wasInterrupted);
            }
        }
    }

    public final void collectValueFromNonCancelledFuture(int i, Future<? extends InputT> future) {
        try {
            Object done = ReactYogaConfigProvider.getDone(future);
            List<CollectionFuture.Present<V>> list = ((CollectionFuture) this).values;
            if (list != null) {
                list.set(i, new CollectionFuture.Present<>(done));
            }
        } catch (ExecutionException e) {
            handleException(e.getCause());
        } catch (Throwable th) {
            handleException(th);
        }
    }

    public abstract void handleAllCompleted();

    public final void handleException(Throwable th) {
        if (th != null) {
            String str = "Input Future failed with Error";
            if (this.allMustSucceed && !setException(th)) {
                Set<Throwable> set = this.seenExceptions;
                if (set == null) {
                    Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
                    if (newSetFromMap != null) {
                        if (!(this.value instanceof AbstractFuture.Cancellation)) {
                            Object obj = this.value;
                            addCausalChain(newSetFromMap, obj instanceof AbstractFuture.Failure ? ((AbstractFuture.Failure) obj).exception : null);
                        }
                        AggregateFutureState.ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, newSetFromMap);
                        set = this.seenExceptions;
                    } else {
                        throw null;
                    }
                }
                if (addCausalChain(set, th)) {
                    if (!(th instanceof Error)) {
                        str = "Got more than one input Future failure. Logging failures after the first";
                    }
                    logger.log(Level.SEVERE, str, th);
                    return;
                }
            }
            boolean z = th instanceof Error;
            if (z) {
                if (!z) {
                    str = "Got more than one input Future failure. Logging failures after the first";
                }
                logger.log(Level.SEVERE, str, th);
                return;
            }
            return;
        }
        throw null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        if (immutableCollection == null) {
            return super.pendingToString();
        }
        return "futures=" + immutableCollection;
    }
}
