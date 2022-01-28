package com.proudcrowd.exposure.storage;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class KeyScanRepository {
    private final LiveData<List<KeyScanEntity>> getAllLiveData;
    private final KeyScanDao keyScanDao;

    public KeyScanRepository(Context context) {
        KeyScanDao keyScanDao2 = ExposureNotificationDatabase.getInstance(context).keyScanDao();
        this.keyScanDao = keyScanDao2;
        this.getAllLiveData = keyScanDao2.getAllLiveData();
    }

    public LiveData<List<KeyScanEntity>> getAllLiveData() {
        return this.getAllLiveData;
    }

    public ListenableFuture<Void> upsertAsync(KeyScanEntity keyScanEntity) {
        return this.keyScanDao.upsertAsync(keyScanEntity);
    }

    public ListenableFuture<Void> deleteRecentAsync(long j) {
        return this.keyScanDao.deleteRecentAsync(j);
    }
}
