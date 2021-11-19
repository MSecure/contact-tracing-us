package com.proudcrowd.exposure.storage;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.misc.AppExecutors;
import java.util.ArrayList;
import java.util.List;

public class PartyRepository {
    private final PartyDao dao;
    private final LiveData<List<PartyEntity>> getAllLiveData;

    public PartyRepository(Context context) {
        PartyDao partyDao = ExposureNotificationDatabase.getInstance(context).partyDao();
        this.dao = partyDao;
        this.getAllLiveData = partyDao.getAllLiveData();
    }

    public LiveData<List<PartyEntity>> getAllLiveData() {
        return this.getAllLiveData;
    }

    public ListenableFuture<List<PartyEntity>> getAllAsync() {
        return this.dao.getAllAsync();
    }

    public ListenableFuture<Void> mergeAsync(List<PartyEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (PartyEntity partyEntity : list) {
            arrayList.add(Integer.valueOf(partyEntity.getId()));
        }
        return FluentFuture.from(this.dao.deleteAllExceptAsync(arrayList)).transformAsync(new AsyncFunction(list) {
            /* class com.proudcrowd.exposure.storage.$$Lambda$PartyRepository$ZMbgAoS8V3qCkIyIUrAeOUmOiTI */
            public final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return PartyRepository.this.lambda$mergeAsync$0$PartyRepository(this.f$1, (Void) obj);
            }
        }, AppExecutors.getBackgroundExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$mergeAsync$0$PartyRepository(List list, Void r2) throws Exception {
        return this.dao.upsertAsync(list);
    }
}
