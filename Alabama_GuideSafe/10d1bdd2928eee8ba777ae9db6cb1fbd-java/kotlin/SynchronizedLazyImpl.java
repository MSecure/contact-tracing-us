package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyJVM.kt */
public final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    public volatile Object _value = UNINITIALIZED_VALUE.INSTANCE;
    public Function0<? extends T> initializer;
    public final Object lock = this;

    public SynchronizedLazyImpl(Function0 function0, Object obj, int i) {
        int i2 = i & 2;
        Intrinsics.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t;
        T t2 = (T) this._value;
        if (t2 != UNINITIALIZED_VALUE.INSTANCE) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == UNINITIALIZED_VALUE.INSTANCE) {
                Function0<? extends T> function0 = this.initializer;
                Intrinsics.checkNotNull(function0);
                t = (T) function0.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    public String toString() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
