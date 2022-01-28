package com.google.common.util.concurrent;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    public Class<X> exceptionType;
    public F fallback;
    public ListenableFuture<? extends V> inputFuture;

    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        public CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }
    }

    public AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        if (listenableFuture != null) {
            this.inputFuture = listenableFuture;
            if (cls != null) {
                this.exceptionType = cls;
                if (f != null) {
                    this.fallback = f;
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        if (executor != null) {
            if (executor != DirectExecutor.INSTANCE) {
                executor = new MoreExecutors$5(executor, catchingFuture);
            }
            listenableFuture.addListener(catchingFuture, executor);
            return catchingFuture;
        }
        throw null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + ((Object) f) + "]";
        } else if (pendingToString != null) {
            return GeneratedOutlineSupport.outline8(str, pendingToString);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.util.concurrent.AbstractCatchingFuture<V, X extends java.lang.Throwable, F, T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: F */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.google.common.util.concurrent.AbstractCatchingFuture$CatchingFuture */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    public final void run() {
        Object obj;
        Throwable th;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        boolean z = true;
        boolean z2 = (listenableFuture == null) | (cls == null);
        if (f != null) {
            z = false;
        }
        if ((!z && !z2) && !(this.value instanceof AbstractFuture.Cancellation)) {
            this.inputFuture = null;
            try {
                th = listenableFuture instanceof InternalFutureFailureAccess ? ReactYogaConfigProvider.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture) : null;
                if (th == null) {
                    obj = ReactYogaConfigProvider.getDone(listenableFuture);
                    if (th != null) {
                        set(obj);
                        return;
                    } else if (!cls.isInstance(th)) {
                        setFuture(listenableFuture);
                        return;
                    } else {
                        try {
                            Object apply = f.apply(th);
                            this.exceptionType = null;
                            this.fallback = null;
                            ((CatchingFuture) this).set(apply);
                            return;
                        } catch (Throwable th2) {
                            this.exceptionType = null;
                            this.fallback = null;
                            throw th2;
                        }
                    }
                }
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Future type ");
                    outline15.append(listenableFuture.getClass());
                    outline15.append(" threw ");
                    outline15.append(e.getClass());
                    outline15.append(" without a cause");
                    cause = new NullPointerException(outline15.toString());
                }
                th = cause;
            } catch (Throwable th3) {
                th = th3;
            }
            obj = null;
            if (th != null) {
            }
        }
    }
}
