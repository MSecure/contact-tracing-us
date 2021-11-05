package gov.nc.dhhs.exposurenotification.notify;

import android.app.Application;
import android.app.ProgressDialog;
import androidx.lifecycle.LiveData;
import b.n.a;
import b.n.n;
import b.n.p;
import b.n.w;
import c.b.a.a.c.k.b;
import c.b.a.a.c.n.c;
import c.b.b.e.a.l;
import c.b.b.e.a.q;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import d.a.a.a.h.o0;
import d.a.a.a.h.p0;
import d.a.a.a.h.q0;
import e.c.a.s;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import gov.nc.dhhs.exposurenotification.common.SingleLiveEvent;
import gov.nc.dhhs.exposurenotification.common.TaskToFutureAdapter;
import gov.nc.dhhs.exposurenotification.nearby.ExposureNotificationClientWrapper;
import gov.nc.dhhs.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKey;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKeys;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisRepository;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShareDiagnosisViewModel extends a {
    public static final long NO_EXISTING_ID = -1;
    public static final String TAG = "ShareDiagnosisViewModel";
    public static String error_token_flag = "OK";
    public final SingleLiveEvent<Void> deletedLiveEvent = new SingleLiveEvent<>();
    public final p<Long> existingIdLiveData = new p<>(-1L);
    public final p<Boolean> inFlightResolutionLiveData = new p<>(Boolean.FALSE);
    public final PositiveDiagnosisRepository repository;
    public final SingleLiveEvent<b> resolutionRequiredLiveEvent = new SingleLiveEvent<>();
    public final SingleLiveEvent<Boolean> savedLiveEvent = new SingleLiveEvent<>();
    public final SingleLiveEvent<Boolean> sharedLiveEvent = new SingleLiveEvent<>();
    public final SingleLiveEvent<String> snackbarLiveEvent = new SingleLiveEvent<>();
    public final p<String> testIdentifierLiveData = new p<>();
    public final p<s> testTimestampLiveData = new p<>();

    public ShareDiagnosisViewModel(Application application) {
        super(application);
        this.repository = new PositiveDiagnosisRepository(application);
    }

    private u<List<TemporaryExposureKey>> getRecentKeys() {
        return TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(getApplication()).getTemporaryExposureKeyHistory(), ProvideDiagnosisKeysWorker.DEFAULT_API_TIMEOUT.p(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor());
    }

    private u<Void> insertOrUpdateDiagnosis(boolean z) {
        long longValue = this.existingIdLiveData.getValue().longValue();
        return longValue == -1 ? this.repository.deleteByIdAsync(longValue) : this.repository.markSharedForIdAsync(longValue, z);
    }

    /* access modifiers changed from: private */
    public u<Boolean> submitKeysToService(List<TemporaryExposureKey> list) {
        c.s(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i = 0;
        boolean z = false;
        for (TemporaryExposureKey temporaryExposureKey : list) {
            DiagnosisKey build = DiagnosisKey.newBuilder().setKeyBytes(temporaryExposureKey.getKeyData()).setIntervalNumber(temporaryExposureKey.getRollingStartIntervalNumber()).build();
            if (build != null) {
                int i2 = i + 1;
                if (objArr.length < i2) {
                    int length = objArr.length;
                    if (i2 >= 0) {
                        int i3 = length + (length >> 1) + 1;
                        if (i3 < i2) {
                            i3 = Integer.highestOneBit(i2 - 1) << 1;
                        }
                        if (i3 < 0) {
                            i3 = Integer.MAX_VALUE;
                        }
                        objArr = Arrays.copyOf(objArr, i3);
                    } else {
                        throw new AssertionError("cannot store more than MAX_VALUE elements");
                    }
                } else if (z) {
                    objArr = (Object[]) objArr.clone();
                } else {
                    objArr[i] = build;
                    i++;
                }
                z = false;
                objArr[i] = build;
                i++;
            } else {
                throw null;
            }
        }
        return l.s(new DiagnosisKeys(getApplication()).upload(c.b.b.b.c.o(objArr, i))).t(p0.f4746a, AppExecutors.getLightweightExecutor()).q(b.class, o0.f4744a, AppExecutors.getLightweightExecutor());
    }

    public void deleteEntity(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        u<Void> deleteByIdAsync = this.repository.deleteByIdAsync(positiveDiagnosisEntity.getId());
        AnonymousClass1 r0 = new c.b.b.e.a.p<Void>() {
            /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisViewModel.AnonymousClass1 */

            @Override // c.b.b.e.a.p
            public void onFailure(Throwable th) {
            }

            public void onSuccess(Void r1) {
                ShareDiagnosisViewModel.this.deletedLiveEvent.postCall();
            }
        };
        deleteByIdAsync.b(new q(deleteByIdAsync, r0), AppExecutors.getLightweightExecutor());
    }

    public LiveData<PositiveDiagnosisEntity> getByIdLiveData(long j) {
        return this.repository.getByIdLiveData(j);
    }

    public SingleLiveEvent<Void> getDeletedSingleLiveEvent() {
        return this.deletedLiveEvent;
    }

    public LiveData<Long> getExistingIdLiveData() {
        return this.existingIdLiveData;
    }

    public LiveData<Boolean> getInFlightResolutionLiveData() {
        return this.inFlightResolutionLiveData;
    }

    public SingleLiveEvent<b> getResolutionRequiredLiveEvent() {
        return this.resolutionRequiredLiveEvent;
    }

    public SingleLiveEvent<Boolean> getSavedLiveEvent() {
        return this.savedLiveEvent;
    }

    public SingleLiveEvent<Boolean> getSharedLiveEvent() {
        return this.sharedLiveEvent;
    }

    public SingleLiveEvent<String> getSnackbarSingleLiveEvent() {
        return this.snackbarLiveEvent;
    }

    public LiveData<String> getTestIdentifierLiveData() {
        return this.testIdentifierLiveData;
    }

    public LiveData<s> getTestTimestampLiveData() {
        p<s> pVar = this.testTimestampLiveData;
        n nVar = new n();
        w wVar = new w(nVar);
        n.a<?> aVar = new n.a<>(pVar, wVar);
        n.a<?> h = nVar.f1401a.h(pVar, aVar);
        if (h == null || h.f1403b == wVar) {
            if (h == null && nVar.hasActiveObservers()) {
                aVar.f1402a.observeForever(aVar);
            }
            return nVar;
        }
        throw new IllegalArgumentException("This source was already added with the different observer");
    }

    public void onTestTimestampChanged(s sVar) {
        this.testTimestampLiveData.setValue(sVar);
    }

    public void save(final boolean z, final ProgressDialog progressDialog) {
        u<Void> insertOrUpdateDiagnosis = insertOrUpdateDiagnosis(z);
        AnonymousClass3 r1 = new c.b.b.e.a.p<Void>() {
            /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisViewModel.AnonymousClass3 */

            @Override // c.b.b.e.a.p
            public void onFailure(Throwable th) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                ShareDiagnosisViewModel.this.snackbarLiveEvent.postValue(ShareDiagnosisViewModel.this.getApplication().getString(R.string.generic_error_message));
            }

            public void onSuccess(Void r2) {
                ShareDiagnosisViewModel.this.savedLiveEvent.postValue(Boolean.valueOf(z));
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        };
        insertOrUpdateDiagnosis.b(new q(insertOrUpdateDiagnosis, r1), AppExecutors.getLightweightExecutor());
    }

    public void setExistingId(long j) {
        this.existingIdLiveData.setValue(Long.valueOf(j));
    }

    public void setInflightResolution(boolean z) {
        this.inFlightResolutionLiveData.setValue(Boolean.valueOf(z));
    }

    public void setTestIdentifier(String str) {
        this.testIdentifierLiveData.setValue(str);
    }

    public void share(final ProgressDialog progressDialog) {
        progressDialog.show();
        l u = l.s(getRecentKeys()).u(new q0(this), AppExecutors.getBackgroundExecutor());
        AnonymousClass2 r1 = new c.b.b.e.a.p<Boolean>() {
            /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisViewModel.AnonymousClass2 */

            @Override // c.b.b.e.a.p
            public void onFailure(Throwable th) {
                SingleLiveEvent singleLiveEvent;
                Object string;
                if (!"OK".equalsIgnoreCase(ShareDiagnosisViewModel.error_token_flag)) {
                    singleLiveEvent = ShareDiagnosisViewModel.this.sharedLiveEvent;
                    string = Boolean.FALSE;
                } else if (!(th instanceof b)) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    singleLiveEvent = ShareDiagnosisViewModel.this.snackbarLiveEvent;
                    string = ShareDiagnosisViewModel.this.getApplication().getString(R.string.generic_error_message);
                } else {
                    b bVar = (b) th;
                    if (bVar.f2304b.f4432c == 6) {
                        ShareDiagnosisViewModel.this.resolutionRequiredLiveEvent.postValue(bVar);
                        return;
                    } else {
                        ShareDiagnosisViewModel.this.snackbarLiveEvent.postValue(ShareDiagnosisViewModel.this.getApplication().getString(R.string.generic_error_message));
                        return;
                    }
                }
                singleLiveEvent.postValue(string);
            }

            public void onSuccess(Boolean bool) {
                ShareDiagnosisViewModel.this.sharedLiveEvent.postValue(bool);
            }
        };
        u.b(new q(u, r1), AppExecutors.getLightweightExecutor());
    }
}
