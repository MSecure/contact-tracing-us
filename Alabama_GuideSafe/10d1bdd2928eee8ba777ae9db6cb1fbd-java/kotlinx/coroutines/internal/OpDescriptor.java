package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.MoreExecutors;

/* compiled from: Atomic.kt */
public abstract class OpDescriptor {
    public abstract Object perform(Object obj);

    public String toString() {
        return getClass().getSimpleName() + '@' + MoreExecutors.getHexAddress(this);
    }
}
