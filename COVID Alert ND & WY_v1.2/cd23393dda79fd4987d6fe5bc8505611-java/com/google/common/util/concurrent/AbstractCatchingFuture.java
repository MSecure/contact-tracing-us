package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    @NullableDecl
    Class<X> exceptionType;
    @NullableDecl
    F fallback;
    @NullableDecl
    ListenableFuture<? extends V> inputFuture;

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T doFallback(F f, X x) throws Exception;

    /* access modifiers changed from: package-private */
    public abstract void setResult(@NullableDecl T t);

    static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(cls);
        this.fallback = (F) Preconditions.checkNotNull(f);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.util.concurrent.AbstractCatchingFuture<V, X extends java.lang.Throwable, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076  */
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
        if ((!z && !z2) && !isCancelled()) {
            this.inputFuture = null;
            try {
                th = listenableFuture instanceof InternalFutureFailureAccess ? InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture) : null;
                if (th == null) {
                    obj = Futures.getDone(listenableFuture);
                    if (th != null) {
                        set(obj);
                        return;
                    } else if (!Platform.isInstanceOfThrowableClass(th, cls)) {
                        setFuture(listenableFuture);
                        return;
                    } else {
                        try {
                            Object doFallback = doFallback(f, th);
                            this.exceptionType = null;
                            this.fallback = null;
                            setResult(doFallback);
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
                    cause = new NullPointerException("Future type " + listenableFuture.getClass() + " threw " + e.getClass() + " without a cause");
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

    /* access modifiers changed from: protected */
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
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    /* access modifiers changed from: private */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((AsyncFunction) ((AsyncFunction) obj), th);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* access modifiers changed from: package-private */
        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    /* access modifiers changed from: private */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @NullableDecl
        public /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((Function) ((Function) obj), th);
        }

        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V doFallback(Function<? super X, ? extends V> function, X x) throws Exception {
            return (V) function.apply(x);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(@NullableDecl V v) {
            set(v);
        }
    }
}
