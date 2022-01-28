package com.proudcrowd.exposure.storage;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class ExposureRepository {
    private final ExposureDao exposureDao;
    private final LiveData<List<ExposureEntity>> getAllLiveData;

    public ExposureRepository(Context context) {
        ExposureDao exposureDao2 = ExposureNotificationDatabase.getInstance(context).exposureDao();
        this.exposureDao = exposureDao2;
        this.getAllLiveData = exposureDao2.getAllLiveData();
    }

    public LiveData<List<ExposureEntity>> getAllLiveData() {
        return this.getAllLiveData;
    }

    public List<ExposureEntity> getAll() {
        return this.exposureDao.getAll();
    }

    public ListenableFuture<Void> deleteRecentAsync(long j) {
        return this.exposureDao.deleteRecentAsync(j);
    }

    public boolean tryInsert(List<ExposureEntity> list) {
        return this.exposureDao.tryInsert(list);
    }

    public void markExposureAsViewed(long j) {
        this.exposureDao.markExposureAsViewed(j);
    }
}
