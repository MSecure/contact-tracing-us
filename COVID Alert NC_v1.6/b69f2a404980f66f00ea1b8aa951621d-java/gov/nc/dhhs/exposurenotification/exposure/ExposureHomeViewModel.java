package gov.nc.dhhs.exposurenotification.exposure;

import android.app.Application;
import androidx.lifecycle.LiveData;
import b.n.a;
import b.n.p;
import c.b.a.a.c.n.c;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import d.a.a.a.d.q;
import d.a.a.a.d.r;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import gov.nc.dhhs.exposurenotification.common.TaskToFutureAdapter;
import gov.nc.dhhs.exposurenotification.nearby.ExposureNotificationClientWrapper;
import gov.nc.dhhs.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import gov.nc.dhhs.exposurenotification.storage.ExposureEntity;
import gov.nc.dhhs.exposurenotification.storage.ExposureRepository;
import gov.nc.dhhs.exposurenotification.storage.TokenEntity;
import gov.nc.dhhs.exposurenotification.storage.TokenRepository;
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
                arrayList.add(l.s(TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(getApplication()).getExposureInformation(tokenEntity.getToken()), ProvideDiagnosisKeysWorker.DEFAULT_API_TIMEOUT.p(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).u(new d.a.a.a.d.p(this, tokenEntity), AppExecutors.getLightweightExecutor()).u(new r(this, tokenEntity), AppExecutors.getLightweightExecutor()));
            }
        }
        return c.k(arrayList);
    }

    public /* synthetic */ u a(TokenEntity tokenEntity, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ExposureEntity.create(((ExposureInformation) it.next()).getDateMillisSinceEpoch(), tokenEntity.getLastUpdatedTimestampMs()));
        }
        return this.exposureRepository.upsertAsync(arrayList);
    }

    public /* synthetic */ u b(TokenEntity tokenEntity, Void r4) {
        return this.tokenRepository.deleteByTokensAsync(tokenEntity.getToken());
    }

    public LiveData<List<ExposureEntity>> getAllExposureEntityLiveData() {
        return this.getAllLiveData;
    }

    public void updateExposureEntities() {
        l.s(this.tokenRepository.getAllAsync()).u(new q(this), AppExecutors.getBackgroundExecutor());
    }
}
