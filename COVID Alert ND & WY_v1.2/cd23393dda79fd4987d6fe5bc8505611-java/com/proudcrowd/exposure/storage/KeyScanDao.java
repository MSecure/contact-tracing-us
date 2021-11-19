package com.proudcrowd.exposure.storage;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* access modifiers changed from: package-private */
public abstract class KeyScanDao {
    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> deleteRecentAsync(long j);

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<List<KeyScanEntity>> getAllAsync();

    /* access modifiers changed from: package-private */
    public abstract LiveData<List<KeyScanEntity>> getAllLiveData();

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> upsertAsync(KeyScanEntity keyScanEntity);

    KeyScanDao() {
    }
}
