package gov.michigan.MiCovidExposure.storage;

import android.content.Context;
import androidx.lifecycle.LiveData;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import java.util.List;

public class ExposureRepository {
    public final ExposureDao exposureDao;
    public final LiveData<List<ExposureEntity>> getAllLiveData;

    public ExposureRepository(Context context) {
        ExposureDao exposureDao2 = ExposureNotificationDatabase.getInstance(context).exposureDao();
        this.exposureDao = exposureDao2;
        this.getAllLiveData = exposureDao2.getAllLiveData();
    }

    public u<Void> deleteAllAsync() {
        return this.exposureDao.deleteAllAsync();
    }

    public LiveData<List<ExposureEntity>> getAllLiveData() {
        return this.getAllLiveData;
    }

    public boolean refreshWithExposureWindows(List<ExposureWindow> list) {
        return this.exposureDao.refreshWithExposureWindows(list);
    }

    public u<Void> upsertAsync(List<ExposureEntity> list) {
        return this.exposureDao.upsertAsync(list);
    }
}
