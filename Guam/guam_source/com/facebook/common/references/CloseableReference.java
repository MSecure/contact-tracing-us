package com.facebook.common.references;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Closeables;
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.io.IOException;

public final class CloseableReference<T> implements Cloneable, Closeable {
    public static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser<Closeable>() {
        /* class com.facebook.common.references.CloseableReference.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Closeable closeable) {
            try {
                Closeables.close(closeable, true);
            } catch (IOException unused) {
            }
        }
    };
    public static final LeakHandler DEFAULT_LEAK_HANDLER = new LeakHandler() {
        /* class com.facebook.common.references.CloseableReference.AnonymousClass2 */

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public void reportLeak(SharedReference<Object> sharedReference, Throwable th) {
            FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName());
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public boolean requiresStacktrace() {
            return false;
        }
    };
    public static Class<CloseableReference> TAG = CloseableReference.class;
    public boolean mIsClosed = false;
    public final LeakHandler mLeakHandler;
    public final SharedReference<T> mSharedReference;
    public final Throwable mStacktrace;

    public interface LeakHandler {
        void reportLeak(SharedReference<Object> sharedReference, Throwable th);

        boolean requiresStacktrace();
    }

    public CloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler, Throwable th) {
        if (sharedReference != null) {
            this.mSharedReference = sharedReference;
            synchronized (sharedReference) {
                sharedReference.ensureValid();
                sharedReference.mRefCount++;
            }
            this.mLeakHandler = leakHandler;
            this.mStacktrace = th;
            return;
        }
        throw null;
    }

    public static void closeSafely(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static <T extends Closeable> CloseableReference<T> of(T t) {
        return of(t, DEFAULT_CLOSEABLE_RELEASER);
    }

    public synchronized CloseableReference<T> cloneOrNull() {
        if (!isValid()) {
            return null;
        }
        return clone();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1.ensureValid();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        if (r1.mRefCount <= 0) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
        androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(r2);
        r2 = r1.mRefCount - 1;
        r1.mRefCount = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        if (r2 != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r2 = r1.mValue;
        r1.mValue = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        r1.mResourceReleaser.release(r2);
        r4 = com.facebook.common.references.SharedReference.sLiveObjects;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1 = com.facebook.common.references.SharedReference.sLiveObjects.get(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        if (r1 != null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003d, code lost:
        com.facebook.common.logging.FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", r2.getClass());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        if (r1.intValue() != 1) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        com.facebook.common.references.SharedReference.sLiveObjects.remove(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
        com.facebook.common.references.SharedReference.sLiveObjects.put(r2, java.lang.Integer.valueOf(r1.intValue() - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0067, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
        r1 = r6.mSharedReference;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        monitor-enter(r1);
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
            }
        }
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.mIsClosed) {
                    this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                    close();
                    super.finalize();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public synchronized T get() {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!this.mIsClosed);
        return this.mSharedReference.get();
    }

    public synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    public static boolean isValid(CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.isValid();
    }

    public static <T extends Closeable> CloseableReference<T> of(T t, LeakHandler leakHandler) {
        Throwable th = null;
        if (t == null) {
            return null;
        }
        ResourceReleaser<Closeable> resourceReleaser = DEFAULT_CLOSEABLE_RELEASER;
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return new CloseableReference<>(t, resourceReleaser, leakHandler, th);
    }

    @Override // java.lang.Object
    public synchronized CloseableReference<T> clone() {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(isValid());
        return new CloseableReference<>(this.mSharedReference, this.mLeakHandler, this.mStacktrace);
    }

    public static <T> CloseableReference<T> cloneOrNull(CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static <T> CloseableReference<T> of(T t, ResourceReleaser<T> resourceReleaser) {
        return of(t, resourceReleaser, DEFAULT_LEAK_HANDLER);
    }

    public static <T> CloseableReference<T> of(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        Throwable th = null;
        if (t == null) {
            return null;
        }
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return new CloseableReference<>(t, resourceReleaser, leakHandler, th);
    }

    public CloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, Throwable th) {
        this.mSharedReference = new SharedReference<>(t, resourceReleaser);
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }
}
