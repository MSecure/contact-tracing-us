package com.facebook.datasource;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final boolean mDataSourceLazy;
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    public class IncreasingQualityDataSource extends AbstractDataSource<T> {
        public ArrayList<DataSource<T>> mDataSources;
        public Throwable mDelayedError;
        public AtomicInteger mFinishedDataSources;
        public int mIndexOfDataSourceWithResult;
        public int mNumberOfDataSources;

        public class InternalDataSubscriber implements DataSubscriber<T> {
            public int mIndex;

            public InternalDataSubscriber(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                IncreasingQualityDataSource.access$300(IncreasingQualityDataSource.this, this.mIndex, dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                Throwable th;
                if (dataSource.hasResult()) {
                    IncreasingQualityDataSource increasingQualityDataSource = IncreasingQualityDataSource.this;
                    int i = this.mIndex;
                    if (increasingQualityDataSource != null) {
                        boolean isFinished = dataSource.isFinished();
                        synchronized (increasingQualityDataSource) {
                            int i2 = increasingQualityDataSource.mIndexOfDataSourceWithResult;
                            if (dataSource == increasingQualityDataSource.getDataSource(i)) {
                                if (i != increasingQualityDataSource.mIndexOfDataSourceWithResult) {
                                    if (increasingQualityDataSource.getDataSourceWithResult() == null || (isFinished && i < increasingQualityDataSource.mIndexOfDataSourceWithResult)) {
                                        increasingQualityDataSource.mIndexOfDataSourceWithResult = i;
                                        i2 = i;
                                    }
                                    for (int i3 = increasingQualityDataSource.mIndexOfDataSourceWithResult; i3 > i2; i3--) {
                                        DataSource<T> andClearDataSource = increasingQualityDataSource.getAndClearDataSource(i3);
                                        if (andClearDataSource != null) {
                                            andClearDataSource.close();
                                        }
                                    }
                                }
                            }
                        }
                        if (dataSource == increasingQualityDataSource.getDataSourceWithResult()) {
                            increasingQualityDataSource.setResult(null, i == 0 && dataSource.isFinished());
                        }
                        if (increasingQualityDataSource.mFinishedDataSources.incrementAndGet() == increasingQualityDataSource.mNumberOfDataSources && (th = increasingQualityDataSource.mDelayedError) != null) {
                            increasingQualityDataSource.setFailure(th);
                            return;
                        }
                        return;
                    }
                    throw null;
                } else if (dataSource.isFinished()) {
                    IncreasingQualityDataSource.access$300(IncreasingQualityDataSource.this, this.mIndex, dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                if (this.mIndex == 0) {
                    IncreasingQualityDataSource.this.setProgress(dataSource.getProgress());
                }
            }
        }

        public IncreasingQualityDataSource() {
            if (!IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
        }

        public static void access$300(IncreasingQualityDataSource increasingQualityDataSource, int i, DataSource dataSource) {
            DataSource dataSource2;
            Throwable th;
            synchronized (increasingQualityDataSource) {
                if (dataSource == increasingQualityDataSource.getDataSourceWithResult()) {
                    dataSource2 = null;
                } else if (dataSource == increasingQualityDataSource.getDataSource(i)) {
                    dataSource2 = increasingQualityDataSource.getAndClearDataSource(i);
                } else {
                    dataSource2 = dataSource;
                }
            }
            if (dataSource2 != null) {
                dataSource2.close();
            }
            if (i == 0) {
                increasingQualityDataSource.mDelayedError = dataSource.getFailureCause();
            }
            if (increasingQualityDataSource.mFinishedDataSources.incrementAndGet() == increasingQualityDataSource.mNumberOfDataSources && (th = increasingQualityDataSource.mDelayedError) != null) {
                increasingQualityDataSource.setFailure(th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r1 >= r0.size()) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            r2 = r0.get(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            if (r2 == null) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return true;
         */
        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public boolean close() {
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            synchronized (this) {
                int i = 0;
                if (!super.close()) {
                    return false;
                }
                ArrayList<DataSource<T>> arrayList = this.mDataSources;
                this.mDataSources = null;
            }
        }

        public final void ensureDataSourceInitialized() {
            if (this.mFinishedDataSources == null) {
                synchronized (this) {
                    if (this.mFinishedDataSources == null) {
                        int i = 0;
                        this.mFinishedDataSources = new AtomicInteger(0);
                        int size = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
                        this.mNumberOfDataSources = size;
                        this.mIndexOfDataSourceWithResult = size;
                        this.mDataSources = new ArrayList<>(size);
                        while (true) {
                            if (i >= size) {
                                break;
                            }
                            DataSource<T> dataSource = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i).get();
                            this.mDataSources.add(dataSource);
                            dataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.sInstance);
                            if (dataSource.hasResult()) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }

        public final synchronized DataSource<T> getAndClearDataSource(int i) {
            DataSource<T> dataSource;
            dataSource = null;
            if (this.mDataSources != null && i < this.mDataSources.size()) {
                dataSource = this.mDataSources.set(i, null);
            }
            return dataSource;
        }

        public final synchronized DataSource<T> getDataSource(int i) {
            return (this.mDataSources == null || i >= this.mDataSources.size()) ? null : this.mDataSources.get(i);
        }

        public final synchronized DataSource<T> getDataSourceWithResult() {
            return getDataSource(this.mIndexOfDataSourceWithResult);
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public synchronized T getResult() {
            DataSource<T> dataSourceWithResult;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public synchronized boolean hasResult() {
            DataSource<T> dataSourceWithResult;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }
    }

    public IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list, boolean z) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument1(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
        this.mDataSourceLazy = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IncreasingQualityDataSourceSupplier)) {
            return false;
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return new IncreasingQualityDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = AppCompatDelegateImpl.ConfigurationImplApi17.toStringHelper(this);
        stringHelper.addHolder("list", this.mDataSourceSuppliers);
        return stringHelper.toString();
    }
}
