package com.google.common.util.concurrent;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    public F function;
    public ListenableFuture<? extends I> inputFuture;

    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public Object doTransform(Object obj, Object obj2) throws Exception {
            AsyncFunction asyncFunction = (AsyncFunction) obj;
            ListenableFuture<O> apply = asyncFunction.apply(obj2);
            if (apply != null) {
                return apply;
            }
            throw new NullPointerException(ReactYogaConfigProvider.lenientFormat("AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction));
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(Object obj) {
            setFuture((ListenableFuture) obj);
        }
    }

    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        public TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public Object doTransform(Object obj, Object obj2) throws Exception {
            return ((Function) obj).apply(obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(O o) {
            set(o);
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f) {
        if (listenableFuture != null) {
            this.inputFuture = listenableFuture;
            if (f != null) {
                this.function = f;
                return;
            }
            throw null;
        }
        throw null;
    }

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        if (executor != null) {
            AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
            if (executor != DirectExecutor.INSTANCE) {
                executor = new MoreExecutors$5(executor, asyncTransformFuture);
            }
            listenableFuture.addListener(asyncTransformFuture, executor);
            return asyncTransformFuture;
        }
        throw null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    public abstract T doTransform(F f, I i) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f != null) {
            return str + "function=[" + ((Object) f) + "]";
        } else if (pendingToString != null) {
            return GeneratedOutlineSupport.outline8(str, pendingToString);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.util.concurrent.AbstractTransformFuture<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        boolean z = true;
        boolean z2 = (this.value instanceof AbstractFuture.Cancellation) | (listenableFuture == null);
        if (f != null) {
            z = false;
        }
        if (!z2 && !z) {
            this.inputFuture = null;
            if (listenableFuture.isCancelled()) {
                setFuture(listenableFuture);
                return;
            }
            try {
                try {
                    Object doTransform = doTransform(f, ReactYogaConfigProvider.getDone(listenableFuture));
                    this.function = null;
                    setResult(doTransform);
                } catch (Throwable th) {
                    this.function = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    public abstract void setResult(T t);

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function2, Executor executor) {
        if (function2 != null) {
            TransformFuture transformFuture = new TransformFuture(listenableFuture, function2);
            if (executor != null) {
                if (executor != DirectExecutor.INSTANCE) {
                    executor = new MoreExecutors$5(executor, transformFuture);
                }
                listenableFuture.addListener(transformFuture, executor);
                return transformFuture;
            }
            throw null;
        }
        throw null;
    }
}
