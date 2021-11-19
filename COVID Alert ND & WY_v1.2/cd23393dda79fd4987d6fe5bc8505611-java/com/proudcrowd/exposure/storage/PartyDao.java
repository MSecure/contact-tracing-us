package com.proudcrowd.exposure.storage;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* access modifiers changed from: package-private */
public abstract class PartyDao {
    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> deleteAllExceptAsync(List<Integer> list);

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<List<PartyEntity>> getAllAsync();

    /* access modifiers changed from: package-private */
    public abstract LiveData<List<PartyEntity>> getAllLiveData();

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> upsertAsync(List<PartyEntity> list);

    PartyDao() {
    }
}
