package gov.nc.dhhs.exposurenotification.storage;

import androidx.lifecycle.LiveData;
import c.b.b.e.a.u;
import java.util.List;

public abstract class PositiveDiagnosisDao {
    public abstract u<Void> deleteById(long j);

    public abstract List<PositiveDiagnosisEntity> getAll();

    public abstract LiveData<List<PositiveDiagnosisEntity>> getAllLiveData();

    public abstract LiveData<PositiveDiagnosisEntity> getById(long j);

    public abstract u<Void> markSharedForId(long j, boolean z);

    public abstract void upsert(PositiveDiagnosisEntity positiveDiagnosisEntity);

    public abstract u<Void> upsertAsync(PositiveDiagnosisEntity positiveDiagnosisEntity);
}
