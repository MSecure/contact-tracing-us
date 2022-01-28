package gov.michigan.MiCovidExposure.storage;

import android.content.Context;
import androidx.lifecycle.LiveData;
import c.b.b.e.a.u;
import java.util.List;

public class PositiveDiagnosisRepository {
    public final LiveData<List<PositiveDiagnosisEntity>> getAllLiveData;
    public final PositiveDiagnosisDao positiveDiagnosisDao;

    public PositiveDiagnosisRepository(Context context) {
        PositiveDiagnosisDao positiveDiagnosisDao2 = ExposureNotificationDatabase.getInstance(context).positiveDiagnosisDao();
        this.positiveDiagnosisDao = positiveDiagnosisDao2;
        this.getAllLiveData = positiveDiagnosisDao2.getAllLiveData();
    }

    public u<Void> deleteByIdAsync(long j) {
        return this.positiveDiagnosisDao.deleteById(j);
    }

    public LiveData<List<PositiveDiagnosisEntity>> getAllLiveData() {
        return this.getAllLiveData;
    }

    public LiveData<PositiveDiagnosisEntity> getByIdLiveData(long j) {
        return this.positiveDiagnosisDao.getById(j);
    }

    public u<Void> markSharedForIdAsync(long j, boolean z) {
        return this.positiveDiagnosisDao.markSharedForId(j, z);
    }

    public u<Void> upsertAsync(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        return this.positiveDiagnosisDao.upsertAsync(positiveDiagnosisEntity);
    }
}
