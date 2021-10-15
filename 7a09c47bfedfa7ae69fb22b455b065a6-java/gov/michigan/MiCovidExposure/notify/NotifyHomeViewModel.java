package gov.michigan.MiCovidExposure.notify;

import android.app.Application;
import androidx.lifecycle.LiveData;
import b.o.a;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisRepository;
import java.util.List;

public class NotifyHomeViewModel extends a {
    public final LiveData<List<PositiveDiagnosisEntity>> getAllPositiveDiagnosisLiveData;
    public final PositiveDiagnosisRepository positiveDiagnosisRepository;

    public NotifyHomeViewModel(Application application) {
        super(application);
        PositiveDiagnosisRepository positiveDiagnosisRepository2 = new PositiveDiagnosisRepository(application);
        this.positiveDiagnosisRepository = positiveDiagnosisRepository2;
        this.getAllPositiveDiagnosisLiveData = positiveDiagnosisRepository2.getAllLiveData();
    }

    public LiveData<List<PositiveDiagnosisEntity>> getAllPositiveDiagnosisEntityLiveData() {
        return this.getAllPositiveDiagnosisLiveData;
    }
}
