package com.proudcrowd.exposure.storage;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class WatermarkUrlRepository {
    private final WatermarkUrlDao dao;
    private final LiveData<List<WatermarkUrlEntity>> getAllLiveData;

    public WatermarkUrlRepository(Context context) {
        WatermarkUrlDao keyUrlDao = ExposureNotificationDatabase.getInstance(context).keyUrlDao();
        this.dao = keyUrlDao;
        this.getAllLiveData = keyUrlDao.getAllLiveData();
    }

    public LiveData<List<WatermarkUrlEntity>> getAllLiveData() {
        return this.getAllLiveData;
    }

    public ListenableFuture<List<WatermarkUrlEntity>> getAllAsync() {
        return this.dao.getAllAsync();
    }

    public ListenableFuture<Void> upsertAsync(List<WatermarkUrlEntity> list) {
        return this.dao.upsertAsync(list);
    }

    public ListenableFuture<Void> deleteAllAsync() {
        return this.dao.deleteAllAsync();
    }
}
