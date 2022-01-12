package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* compiled from: LockFreeTaskQueue.kt */
public final class LockFreeTaskQueueCore<E> {
    public static final Companion Companion = new Companion(null);
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    public static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    public volatile Object _next = null;
    public volatile long _state = 0;
    public AtomicReferenceArray array = new AtomicReferenceArray(this.capacity);
    public final int capacity;
    public final int mask;
    public final boolean singleConsumer;

    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.capacity = i;
        this.singleConsumer = z;
        boolean z2 = true;
        this.mask = i - 1;
        if (this.mask <= 1073741823) {
            if (!((this.capacity & this.mask) != 0 ? false : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int addLast(E e) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (j & 2305843009213693952L) != 0 ? 2 : 1;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.mask;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.singleConsumer && this.array.get(i2 & i3) != null) {
                int i4 = this.capacity;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (_state$FU.compareAndSet(this, j, (-1152921503533105153L & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                this.array.set(i2 & i3, e);
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                while ((lockFreeTaskQueueCore._state & 1152921504606846976L) != 0) {
                    lockFreeTaskQueueCore = lockFreeTaskQueueCore.next();
                    Object obj = lockFreeTaskQueueCore.array.get(lockFreeTaskQueueCore.mask & i2);
                    if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != i2) {
                        lockFreeTaskQueueCore = null;
                        continue;
                    } else {
                        lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i2, e);
                        continue;
                    }
                    if (lockFreeTaskQueueCore == null) {
                        break;
                    }
                }
                return 0;
            }
        }
        return 1;
    }

    public final boolean close() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!_state$FU.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final boolean isEmpty() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v2, resolved type: java.util.concurrent.atomic.AtomicReferenceArray */
    /* JADX WARN: Multi-variable type inference failed */
    public final LockFreeTaskQueueCore<E> next() {
        long j;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) == 0) {
                long j2 = j | 1152921504606846976L;
                if (_state$FU.compareAndSet(this, j, j2)) {
                    j = j2;
                    break;
                }
            } else {
                break;
            }
        }
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.mask;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object obj = this.array.get(i4);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                lockFreeTaskQueueCore2.array.set(lockFreeTaskQueueCore2.mask & i, obj);
                i++;
            }
            lockFreeTaskQueueCore2._state = -1152921504606846977L & j;
            atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueueCore2);
        }
    }

    public final Object removeFirstOrNull() {
        while (true) {
            long j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return REMOVE_FROZEN;
            }
            int i = (int) ((j & 1073741823) >> 0);
            int i2 = this.mask;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                return null;
            }
            Object obj = this.array.get(i4);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                long j2 = ((long) ((i + 1) & 1073741823)) << 0;
                if (_state$FU.compareAndSet(this, j, (j & -1073741824) | j2)) {
                    this.array.set(this.mask & i, null);
                    return obj;
                } else if (this.singleConsumer) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    while (true) {
                        long j3 = lockFreeTaskQueueCore._state;
                        int i5 = (int) ((j3 & 1073741823) >> 0);
                        if (DebugKt.ASSERTIONS_ENABLED) {
                            if (!(i5 == i)) {
                                throw new AssertionError();
                            }
                        }
                        if ((j3 & 1152921504606846976L) != 0) {
                            lockFreeTaskQueueCore = lockFreeTaskQueueCore.next();
                        } else if (_state$FU.compareAndSet(lockFreeTaskQueueCore, j3, j2 | (j3 & -1073741824))) {
                            lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i5, null);
                            lockFreeTaskQueueCore = null;
                        } else {
                            continue;
                        }
                        if (lockFreeTaskQueueCore == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
