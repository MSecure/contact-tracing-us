package gov.nc.dhhs.exposurenotification.storage;

import androidx.lifecycle.LiveData;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import java.util.List;

public abstract class ExposureDao {
    public abstract u<Void> deleteAllAsync();

    public abstract List<ExposureEntity> getAll();

    public abstract u<List<ExposureEntity>> getAllAsync();

    public abstract LiveData<List<ExposureEntity>> getAllLiveData();

    public boolean refreshWithExposureWindows(List<ExposureWindow> list) {
        boolean z;
        List<ExposureEntity> all = getAll();
        boolean z2 = false;
        for (ExposureWindow exposureWindow : list) {
            int i = 0;
            while (true) {
                if (i >= all.size()) {
                    z = false;
                    break;
                } else if (all.get(i).getDateMillisSinceEpoch() == exposureWindow.getDateMillisSinceEpoch()) {
                    all.remove(i);
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                upsert(ExposureEntity.create(exposureWindow.getDateMillisSinceEpoch(), System.currentTimeMillis()));
                z2 = true;
            }
        }
        return z2;
    }

    public abstract void upsert(ExposureEntity exposureEntity);

    public abstract u<Void> upsertAsync(List<ExposureEntity> list);
}
