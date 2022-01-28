package androidx.lifecycle;

import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class LifecycleRegistry extends Lifecycle {
    public int mAddingObserverCounter = 0;
    public boolean mHandlingEvent = false;
    public final WeakReference<LifecycleOwner> mLifecycleOwner;
    public boolean mNewEventOccurred = false;
    public FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap = new FastSafeIterableMap<>();
    public ArrayList<Lifecycle.State> mParentStates = new ArrayList<>();
    public Lifecycle.State mState;

    public static class ObserverWithState {
        public LifecycleEventObserver mLifecycleObserver;
        public Lifecycle.State mState;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.mState = state;
        }

        public void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State stateAfter = LifecycleRegistry.getStateAfter(event);
            this.mState = LifecycleRegistry.min(this.mState, stateAfter);
            this.mLifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.mState = stateAfter;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = new WeakReference<>(lifecycleOwner);
        this.mState = Lifecycle.State.INITIALIZED;
    }

    public static Lifecycle.State getStateAfter(Lifecycle.Event event) {
        int ordinal = event.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return Lifecycle.State.RESUMED;
                }
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return Lifecycle.State.DESTROYED;
                        }
                        throw new IllegalArgumentException("Unexpected event value " + event);
                    }
                }
            }
            return Lifecycle.State.STARTED;
        }
        return Lifecycle.State.CREATED;
    }

    public static Lifecycle.State min(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    public static Lifecycle.Event upEvent(Lifecycle.State state) {
        int ordinal = state.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return Lifecycle.Event.ON_CREATE;
        }
        if (ordinal == 2) {
            return Lifecycle.Event.ON_START;
        }
        if (ordinal == 3) {
            return Lifecycle.Event.ON_RESUME;
        }
        if (ordinal != 4) {
            throw new IllegalArgumentException("Unexpected state value " + state);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        Lifecycle.State state = this.mState;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (this.mObserverMap.putIfAbsent(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.mLifecycleOwner.get()) != null) {
            boolean z = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
            Lifecycle.State calculateTargetState = calculateTargetState(lifecycleObserver);
            this.mAddingObserverCounter++;
            while (observerWithState.mState.compareTo((Enum) calculateTargetState) < 0 && this.mObserverMap.mHashMap.containsKey(lifecycleObserver)) {
                this.mParentStates.add(observerWithState.mState);
                observerWithState.dispatchEvent(lifecycleOwner, upEvent(observerWithState.mState));
                popParentState();
                calculateTargetState = calculateTargetState(lifecycleObserver);
            }
            if (!z) {
                sync();
            }
            this.mAddingObserverCounter--;
        }
    }

    public final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.mObserverMap;
        Lifecycle.State state = null;
        SafeIterableMap.Entry<K, V> entry = fastSafeIterableMap.mHashMap.containsKey(lifecycleObserver) ? fastSafeIterableMap.mHashMap.get(lifecycleObserver).mPrevious : null;
        Lifecycle.State state2 = entry != null ? ((ObserverWithState) entry.getValue()).mState : null;
        if (!this.mParentStates.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.mParentStates;
            state = arrayList.get(arrayList.size() - 1);
        }
        return min(min(this.mState, state2), state);
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        moveToState(getStateAfter(event));
    }

    public final void moveToState(Lifecycle.State state) {
        if (this.mState != state) {
            this.mState = state;
            if (this.mHandlingEvent || this.mAddingObserverCounter != 0) {
                this.mNewEventOccurred = true;
                return;
            }
            this.mHandlingEvent = true;
            sync();
            this.mHandlingEvent = false;
        }
    }

    public final void popParentState() {
        ArrayList<Lifecycle.State> arrayList = this.mParentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: androidx.arch.core.internal.FastSafeIterableMap<androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleRegistry$ObserverWithState> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: androidx.arch.core.internal.FastSafeIterableMap<androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleRegistry$ObserverWithState> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void sync() {
        Lifecycle.Event event;
        Lifecycle.State state;
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner.get();
        if (lifecycleOwner != null) {
            while (true) {
                FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.mObserverMap;
                if (!(fastSafeIterableMap.mSize == 0 || (fastSafeIterableMap.mStart.mValue.mState == (state = fastSafeIterableMap.mEnd.mValue.mState) && this.mState == state))) {
                    this.mNewEventOccurred = false;
                    if (this.mState.compareTo((Enum) this.mObserverMap.mStart.mValue.mState) < 0) {
                        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap2 = this.mObserverMap;
                        SafeIterableMap.DescendingIterator descendingIterator = new SafeIterableMap.DescendingIterator(fastSafeIterableMap2.mEnd, fastSafeIterableMap2.mStart);
                        fastSafeIterableMap2.mIterators.put(descendingIterator, Boolean.FALSE);
                        while (descendingIterator.hasNext() && !this.mNewEventOccurred) {
                            Map.Entry entry = (Map.Entry) descendingIterator.next();
                            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
                            while (observerWithState.mState.compareTo((Enum) this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains(entry.getKey())) {
                                Lifecycle.State state2 = observerWithState.mState;
                                int ordinal = state2.ordinal();
                                if (ordinal == 0) {
                                    throw new IllegalArgumentException();
                                } else if (ordinal != 1) {
                                    if (ordinal == 2) {
                                        event = Lifecycle.Event.ON_DESTROY;
                                    } else if (ordinal == 3) {
                                        event = Lifecycle.Event.ON_STOP;
                                    } else if (ordinal == 4) {
                                        event = Lifecycle.Event.ON_PAUSE;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected state value " + state2);
                                    }
                                    this.mParentStates.add(getStateAfter(event));
                                    observerWithState.dispatchEvent(lifecycleOwner, event);
                                    popParentState();
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                    SafeIterableMap.Entry<K, V> entry2 = this.mObserverMap.mEnd;
                    if (!this.mNewEventOccurred && entry2 != null && this.mState.compareTo((Enum) entry2.mValue.mState) > 0) {
                        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
                        while (iteratorWithAdditions.hasNext() && !this.mNewEventOccurred) {
                            Map.Entry entry3 = (Map.Entry) iteratorWithAdditions.next();
                            ObserverWithState observerWithState2 = (ObserverWithState) entry3.getValue();
                            while (observerWithState2.mState.compareTo((Enum) this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains(entry3.getKey())) {
                                this.mParentStates.add(observerWithState2.mState);
                                observerWithState2.dispatchEvent(lifecycleOwner, upEvent(observerWithState2.mState));
                                popParentState();
                            }
                        }
                    }
                } else {
                    this.mNewEventOccurred = false;
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }
}
