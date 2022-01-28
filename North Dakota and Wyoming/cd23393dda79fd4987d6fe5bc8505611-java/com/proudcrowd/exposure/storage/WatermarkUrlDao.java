package com.proudcrowd.exposure.storage;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* access modifiers changed from: package-private */
public abstract class WatermarkUrlDao {
    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> deleteAllAsync();

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<List<WatermarkUrlEntity>> getAllAsync();

    /* access modifiers changed from: package-private */
    public abstract LiveData<List<WatermarkUrlEntity>> getAllLiveData();

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> upsertAsync(List<WatermarkUrlEntity> list);

    WatermarkUrlDao() {
    }
}
