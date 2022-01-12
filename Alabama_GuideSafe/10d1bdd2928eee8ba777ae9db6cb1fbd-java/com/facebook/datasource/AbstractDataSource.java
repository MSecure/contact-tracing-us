package com.facebook.datasource;

import android.util.Pair;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public abstract class AbstractDataSource<T> implements DataSource<T> {
    public DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
    public Throwable mFailureThrowable = null;
    public boolean mIsClosed = false;
    public float mProgress = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public T mResult = null;
    public final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers = new ConcurrentLinkedQueue<>();

    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        closeResult(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (isFinished() != false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        notifyDataSubscribers();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.mSubscribers.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r1 == null) goto L_0x0016;
     */
    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return false;
            }
            this.mIsClosed = true;
            T t = this.mResult;
            this.mResult = null;
        }
    }

    public void closeResult(T t) {
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized Throwable getFailureCause() {
        return this.mFailureThrowable;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized T getResult() {
        return this.mResult;
    }

    public synchronized boolean hasFailed() {
        return this.mDataSourceStatus == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasMultipleResults() {
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        return this.mResult != null;
    }

    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isFinished() {
        return this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS;
    }

    public final void notifyDataSubscribers() {
        final boolean hasFailed = hasFailed();
        final boolean wasCancelled = wasCancelled();
        Iterator<Pair<DataSubscriber<T>, Executor>> it = this.mSubscribers.iterator();
        while (it.hasNext()) {
            Pair<DataSubscriber<T>, Executor> next = it.next();
            final DataSubscriber dataSubscriber = (DataSubscriber) next.first;
            ((Executor) next.second).execute(new Runnable() {
                /* class com.facebook.datasource.AbstractDataSource.AnonymousClass1 */

                public void run() {
                    if (r0) {
                        r4.onFailure(AbstractDataSource.this);
                    } else if (r1) {
                        r4.onCancellation(AbstractDataSource.this);
                    } else {
                        r4.onNewResult(AbstractDataSource.this);
                    }
                }
            });
        }
    }

    public boolean setFailure(Throwable th) {
        boolean z;
        synchronized (this) {
            if (!this.mIsClosed) {
                if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                    this.mDataSourceStatus = DataSourceStatus.FAILURE;
                    this.mFailureThrowable = th;
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            notifyDataSubscribers();
        }
        return z;
    }

    public boolean setProgress(float f) {
        boolean z;
        synchronized (this) {
            z = false;
            if (!this.mIsClosed) {
                if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                    if (f >= this.mProgress) {
                        this.mProgress = f;
                        z = true;
                    }
                }
            }
        }
        if (z) {
            Iterator<Pair<DataSubscriber<T>, Executor>> it = this.mSubscribers.iterator();
            while (it.hasNext()) {
                Pair<DataSubscriber<T>, Executor> next = it.next();
                final DataSubscriber dataSubscriber = (DataSubscriber) next.first;
                ((Executor) next.second).execute(new Runnable() {
                    /* class com.facebook.datasource.AbstractDataSource.AnonymousClass2 */

                    public void run() {
                        dataSubscriber.onProgressUpdate(AbstractDataSource.this);
                    }
                });
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0026, code lost:
        if (r5 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0028, code lost:
        closeResult(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002e, code lost:
        if (r5 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0042, code lost:
        r5 = th;
     */
    public boolean setResult(T t, boolean z) {
        AbstractDataSource<T> abstractDataSource;
        boolean z2;
        T t2;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    if (!this.mIsClosed) {
                        if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                            if (z) {
                                this.mDataSourceStatus = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            if (this.mResult != t) {
                                t2 = this.mResult;
                                try {
                                    this.mResult = t;
                                    t = t2;
                                } catch (Throwable th) {
                                    th = th;
                                    t3 = t2;
                                    abstractDataSource = this;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                    throw th;
                                }
                            } else {
                                t = null;
                            }
                            z2 = true;
                            try {
                            } catch (Throwable th3) {
                                t2 = t;
                                th = th3;
                                t3 = t2;
                                abstractDataSource = this;
                                while (true) {
                                    break;
                                }
                                throw th;
                            }
                        }
                    }
                    z2 = false;
                } catch (Throwable th4) {
                    th = th4;
                    abstractDataSource = this;
                    while (true) {
                        break;
                    }
                    throw th;
                }
            }
            if (z2) {
                notifyDataSubscribers();
            }
            return z2;
        } catch (Throwable th5) {
            Throwable th6 = th5;
            abstractDataSource = this;
            if (t3 != null) {
                abstractDataSource.closeResult(t3);
            }
            throw th6;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        r0 = hasFailed();
        r1 = wasCancelled();
        r5.execute(new com.facebook.datasource.AbstractDataSource.AnonymousClass1(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    @Override // com.facebook.datasource.DataSource
    public void subscribe(final DataSubscriber<T> dataSubscriber, Executor executor) {
        boolean z;
        if (executor != null) {
            synchronized (this) {
                if (!this.mIsClosed) {
                    if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                        this.mSubscribers.add(Pair.create(dataSubscriber, executor));
                    }
                    if (!hasResult() && !isFinished()) {
                        if (!wasCancelled()) {
                            z = false;
                        }
                    }
                    z = true;
                }
            }
        } else {
            throw null;
        }
    }

    public final synchronized boolean wasCancelled() {
        return isClosed() && !isFinished();
    }
}
