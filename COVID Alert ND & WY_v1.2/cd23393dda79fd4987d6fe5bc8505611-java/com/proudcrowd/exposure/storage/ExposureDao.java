package com.proudcrowd.exposure.storage;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* access modifiers changed from: package-private */
public abstract class ExposureDao {
    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> deleteRecentAsync(long j);

    /* access modifiers changed from: package-private */
    public abstract List<ExposureEntity> getAll();

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<List<ExposureEntity>> getAllAsync();

    /* access modifiers changed from: package-private */
    public abstract LiveData<List<ExposureEntity>> getAllLiveData();

    /* access modifiers changed from: package-private */
    public abstract int getCount();

    /* access modifiers changed from: package-private */
    public abstract void insert(List<ExposureEntity> list);

    /* access modifiers changed from: package-private */
    public abstract void markExposureAsViewed(long j);

    ExposureDao() {
    }

    public boolean tryInsert(List<ExposureEntity> list) {
        int count = getCount();
        insert(list);
        return count != getCount();
    }
}
