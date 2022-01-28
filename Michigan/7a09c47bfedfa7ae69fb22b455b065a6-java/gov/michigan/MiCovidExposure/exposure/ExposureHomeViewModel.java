package gov.michigan.MiCovidExposure.exposure;

import android.app.Application;
import androidx.lifecycle.LiveData;
import b.o.a;
import b.o.p;
import b.x.t;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import e.a.a.b.n;
import e.a.a.b.o;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import gov.michigan.MiCovidExposure.common.TaskToFutureAdapter;
import gov.michigan.MiCovidExposure.nearby.ExposureNotificationClientWrapper;
import gov.michigan.MiCovidExposure.nearby.ProvideDiagnosisKeysWorker;
import gov.michigan.MiCovidExposure.storage.ExposureEntity;
import gov.michigan.MiCovidExposure.storage.ExposureRepository;
import gov.michigan.MiCovidExposure.storage.TokenEntity;
import gov.michigan.MiCovidExposure.storage.TokenRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExposureHomeViewModel extends a {
    public final ExposureRepository exposureRepository;
    public final LiveData<List<ExposureEntity>> getAllLiveData = this.exposureRepository.getAllLiveData();
    public final p<Boolean> isEnabledLiveData = new p<>(Boolean.FALSE);
    public final TokenRepository tokenRepository;

    public ExposureHomeViewModel(Application application) {
        super(application);
        this.exposureRepository = new ExposureRepository(application);
        this.tokenRepository = new TokenRepository(application);
    }

    /* access modifiers changed from: private */
    public u<List<Void>> checkForRespondedTokensAsync(List<TokenEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (TokenEntity tokenEntity : list) {
            if (tokenEntity.isResponded()) {
                arrayList.add(l.s(TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(getApplication()).getExposureInformation(tokenEntity.getToken()), ProvideDiagnosisKeysWorker.DEFAULT_API_TIMEOUT.s(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).u(new e.a.a.b.p(this, tokenEntity), AppExecutors.getLightweightExecutor()).u(new n(this, tokenEntity), AppExecutors.getLightweightExecutor()));
            }
        }
        return t.k(arrayList);
    }

    public /* synthetic */ u b(TokenEntity tokenEntity, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ExposureEntity.create(((ExposureInformation) it.next()).getDateMillisSinceEpoch(), tokenEntity.getLastUpdatedTimestampMs()));
        }
        return this.exposureRepository.upsertAsync(arrayList);
    }

    public /* synthetic */ u c(TokenEntity tokenEntity, Void r4) {
        return this.tokenRepository.deleteByTokensAsync(tokenEntity.getToken());
    }

    public LiveData<List<ExposureEntity>> getAllExposureEntityLiveData() {
        return this.getAllLiveData;
    }

    public void updateExposureEntities() {
        l.s(this.tokenRepository.getAllAsync()).u(new o(this), AppExecutors.getBackgroundExecutor());
    }
}
