package kotlin.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
public final class CombinedContext implements CoroutineContext, Serializable {
    public final CoroutineContext.Element element;
    public final CoroutineContext left;

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.Element element2) {
        Intrinsics.checkNotNullParameter(coroutineContext, RNGestureHandlerModule.KEY_HIT_SLOP_LEFT);
        Intrinsics.checkNotNullParameter(element2, "element");
        this.left = coroutineContext;
        this.element = element2;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            if (!(obj instanceof CombinedContext)) {
                return false;
            }
            CombinedContext combinedContext = (CombinedContext) obj;
            if (combinedContext.size() != size()) {
                return false;
            }
            if (combinedContext != null) {
                CombinedContext combinedContext2 = this;
                while (true) {
                    CoroutineContext.Element element2 = combinedContext2.element;
                    if (!Intrinsics.areEqual(combinedContext.get(element2.getKey()), element2)) {
                        z = false;
                        break;
                    }
                    CoroutineContext coroutineContext = combinedContext2.left;
                    if (coroutineContext instanceof CombinedContext) {
                        combinedContext2 = (CombinedContext) coroutineContext;
                    } else if (coroutineContext != null) {
                        CoroutineContext.Element element3 = (CoroutineContext.Element) coroutineContext;
                        z = Intrinsics.areEqual(combinedContext.get(element3.getKey()), element3);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    }
                }
                if (z) {
                    return true;
                }
                return false;
            }
            throw null;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) function2.invoke((Object) this.left.fold(r, function2), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(key);
        if (minusKey == this.left) {
            return this;
        }
        if (minusKey == EmptyCoroutineContext.INSTANCE) {
            return this.element;
        }
        return new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return coroutineContext == EmptyCoroutineContext.INSTANCE ? this : (CoroutineContext) coroutineContext.fold(this, CoroutineContext$plus$1.INSTANCE);
    }

    public final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                coroutineContext = null;
            }
            combinedContext = (CombinedContext) coroutineContext;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    public String toString() {
        return GeneratedOutlineSupport.outline14(GeneratedOutlineSupport.outline17("["), (String) fold("", CombinedContext$toString$1.INSTANCE), "]");
    }
}
