package com.facebook.datasource;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Supplier;

public final class DataSources$1 implements Supplier<DataSource<T>> {
    public final /* synthetic */ Throwable val$failure;

    public DataSources$1(Throwable th) {
        this.val$failure = th;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.immediateFailedDataSource(this.val$failure);
    }
}
