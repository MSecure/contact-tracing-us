package com.facebook.datasource;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Supplier;
import java.util.List;

public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    public class FirstAvailableDataSource extends AbstractDataSource<T> {
        public DataSource<T> mCurrentDataSource = null;
        public DataSource<T> mDataSourceWithResult = null;
        public int mIndex = 0;

        public class InternalDataSubscriber implements DataSubscriber<T> {
            public InternalDataSubscriber(AnonymousClass1 r2) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                FirstAvailableDataSource.access$200(FirstAvailableDataSource.this, dataSource);
            }

            /* JADX WARNING: Removed duplicated region for block: B:20:0x0029  */
            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                DataSource<T> dataSource2;
                if (dataSource.hasResult()) {
                    FirstAvailableDataSource firstAvailableDataSource = FirstAvailableDataSource.this;
                    if (firstAvailableDataSource != null) {
                        boolean isFinished = dataSource.isFinished();
                        synchronized (firstAvailableDataSource) {
                            if (dataSource == firstAvailableDataSource.mCurrentDataSource) {
                                if (dataSource != firstAvailableDataSource.mDataSourceWithResult) {
                                    if (firstAvailableDataSource.mDataSourceWithResult != null) {
                                        if (!isFinished) {
                                            dataSource2 = null;
                                            if (dataSource2 != null) {
                                                dataSource2.close();
                                            }
                                        }
                                    }
                                    dataSource2 = firstAvailableDataSource.mDataSourceWithResult;
                                    firstAvailableDataSource.mDataSourceWithResult = dataSource;
                                    if (dataSource2 != null) {
                                    }
                                }
                            }
                        }
                        if (dataSource == firstAvailableDataSource.getDataSourceWithResult()) {
                            firstAvailableDataSource.setResult(null, dataSource.isFinished());
                            return;
                        }
                        return;
                    }
                    throw null;
                } else if (dataSource.isFinished()) {
                    FirstAvailableDataSource.access$200(FirstAvailableDataSource.this, dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                FirstAvailableDataSource.this.setProgress(Math.max(FirstAvailableDataSource.this.getProgress(), dataSource.getProgress()));
            }
        }

        public FirstAvailableDataSource() {
            if (!startNextDataSource()) {
                setFailure(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        public static void access$200(FirstAvailableDataSource firstAvailableDataSource, DataSource dataSource) {
            boolean z;
            synchronized (firstAvailableDataSource) {
                if (!firstAvailableDataSource.isClosed()) {
                    if (dataSource == firstAvailableDataSource.mCurrentDataSource) {
                        firstAvailableDataSource.mCurrentDataSource = null;
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                if (!(dataSource == firstAvailableDataSource.getDataSourceWithResult() || dataSource == null)) {
                    dataSource.close();
                }
                if (!firstAvailableDataSource.startNextDataSource()) {
                    firstAvailableDataSource.setFailure(dataSource.getFailureCause());
                }
            }
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                DataSource<T> dataSource = this.mCurrentDataSource;
                this.mCurrentDataSource = null;
                DataSource<T> dataSource2 = this.mDataSourceWithResult;
                this.mDataSourceWithResult = null;
                closeSafely(dataSource2);
                closeSafely(dataSource);
                return true;
            }
        }

        public final void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        public final synchronized DataSource<T> getDataSourceWithResult() {
            return this.mDataSourceWithResult;
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public synchronized T getResult() {
            DataSource<T> dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public synchronized boolean hasResult() {
            DataSource<T> dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }

        public final boolean startNextDataSource() {
            Supplier<DataSource<T>> supplier;
            boolean z;
            synchronized (this) {
                if (isClosed() || this.mIndex >= FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()) {
                    supplier = null;
                } else {
                    List<Supplier<DataSource<T>>> list = FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
                    int i = this.mIndex;
                    this.mIndex = i + 1;
                    supplier = list.get(i);
                }
            }
            DataSource<T> dataSource = supplier != null ? supplier.get() : null;
            synchronized (this) {
                if (isClosed()) {
                    z = false;
                } else {
                    this.mCurrentDataSource = dataSource;
                    z = true;
                }
            }
            if (!z || dataSource == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                return false;
            }
            dataSource.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.sInstance);
            return true;
        }
    }

    public FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument1(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirstAvailableDataSourceSupplier)) {
            return false;
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mDataSourceSuppliers, ((FirstAvailableDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return new FirstAvailableDataSource();
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
