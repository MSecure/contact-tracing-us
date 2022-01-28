package gov.michigan.MiCovidExposure.home;

import android.app.Application;
import androidx.lifecycle.LiveData;
import b.o.a;
import b.o.p;
import c.b.a.a.d.k.b;
import c.b.a.a.j.b0;
import c.b.a.a.j.i;
import c.b.a.a.j.k;
import e.a.a.c.c;
import e.a.a.c.d;
import e.a.a.c.e;
import e.a.a.c.f;
import e.a.a.c.g;
import e.a.a.c.h;
import e.a.a.c.j;
import gov.michigan.MiCovidExposure.common.SingleLiveEvent;
import gov.michigan.MiCovidExposure.nearby.ExposureNotificationClientWrapper;
import gov.michigan.MiCovidExposure.nearby.ProvideDiagnosisKeysWorker;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.utils.CustomUtility;

public class ExposureNotificationViewModel extends a {
    public static final String TAG = "ExposureNotificationVM";
    public final SingleLiveEvent<Void> apiErrorLiveEvent = new SingleLiveEvent<>();
    public final ExposureNotificationSharedPreferences exposureNotificationSharedPreferences;
    public final p<Boolean> inFlightLiveData = new p<>(Boolean.FALSE);
    public final p<Boolean> inFlightResolutionLiveData = new p<>(Boolean.FALSE);
    public final p<Boolean> isEnabledLiveData = new p<>(Boolean.FALSE);
    public final SingleLiveEvent<b> resolutionRequiredLiveEvent = new SingleLiveEvent<>();

    public ExposureNotificationViewModel(Application application) {
        super(application);
        this.exposureNotificationSharedPreferences = new ExposureNotificationSharedPreferences(application);
    }

    public /* synthetic */ void a(Boolean bool) {
        this.isEnabledLiveData.setValue(bool);
        if (bool.booleanValue()) {
            noteOnboardingCompleted();
        }
    }

    public /* synthetic */ void b(Void r2) {
        CustomUtility.customLogger("A91000 - enabled Exposure Notification within app");
        refreshIsEnabledState();
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public void c(Exception exc) {
        if (!(exc instanceof b)) {
            StringBuilder h = c.a.a.a.a.h("A_CW_ERROR Unknown error when attempting to start API ");
            h.append(exc.getMessage());
            CustomUtility.customLogger(h.toString());
            this.inFlightLiveData.setValue(Boolean.FALSE);
            this.apiErrorLiveEvent.call();
            return;
        }
        b bVar = (b) exc;
        if (bVar.f2941b.f5981c == 6) {
            StringBuilder h2 = c.a.a.a.a.h("A_CW_ERROR API Exception  when attempting to start API, Error Code : ");
            h2.append(bVar.f2941b.f5981c);
            h2.append(", Error: ");
            h2.append(exc.getMessage());
            CustomUtility.customLogger(h2.toString());
            if (!this.inFlightResolutionLiveData.getValue().booleanValue()) {
                this.inFlightResolutionLiveData.setValue(Boolean.TRUE);
                this.resolutionRequiredLiveEvent.postValue(bVar);
                return;
            }
            return;
        }
        this.apiErrorLiveEvent.call();
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public /* synthetic */ void d() {
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public /* synthetic */ void e(Void r2) {
        refreshIsEnabledState();
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public /* synthetic */ void f(Exception exc) {
        this.apiErrorLiveEvent.call();
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public /* synthetic */ void g() {
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public SingleLiveEvent<Void> getApiErrorLiveEvent() {
        return this.apiErrorLiveEvent;
    }

    public LiveData<Boolean> getInFlightLiveData() {
        return this.inFlightLiveData;
    }

    public LiveData<Boolean> getIsEnabledLiveData() {
        return this.isEnabledLiveData;
    }

    public SingleLiveEvent<b> getResolutionRequiredLiveEvent() {
        return this.resolutionRequiredLiveEvent;
    }

    public /* synthetic */ void h(Void r2) {
        refreshIsEnabledState();
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public /* synthetic */ void i(Exception exc) {
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public /* synthetic */ void j() {
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public void noteOnboardingCompleted() {
        this.exposureNotificationSharedPreferences.setOnboardedState(true);
    }

    public void refreshIsEnabledState() {
        i<Boolean> isEnabled = ExposureNotificationClientWrapper.get(getApplication()).isEnabled();
        g gVar = new g(this);
        b0 b0Var = (b0) isEnabled;
        if (b0Var != null) {
            b0Var.d(k.f4110a, gVar);
            return;
        }
        throw null;
    }

    public void scheduleSync() {
        ProvideDiagnosisKeysWorker.scheduleDailyProvideDiagnosisKeys(b.b0.y.k.b(getApplication()));
    }

    public void startExposureNotifications() {
        CustomUtility.customLogger("Schedules polling for every 15 mins -> startExposureNotifications");
        this.inFlightLiveData.setValue(Boolean.TRUE);
        i<Void> start = ExposureNotificationClientWrapper.get(getApplication()).start();
        f fVar = new f(this);
        b0 b0Var = (b0) start;
        if (b0Var != null) {
            b0Var.d(k.f4110a, fVar);
            b0Var.c(k.f4110a, new d(this));
            b0Var.a(k.f4110a, new h(this));
            return;
        }
        throw null;
    }

    public void startResolutionResultNotOk() {
        this.inFlightResolutionLiveData.setValue(Boolean.FALSE);
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public void startResolutionResultOk() {
        this.inFlightResolutionLiveData.setValue(Boolean.FALSE);
        i<Void> start = ExposureNotificationClientWrapper.get(getApplication()).start();
        j jVar = new j(this);
        b0 b0Var = (b0) start;
        if (b0Var != null) {
            b0Var.d(k.f4110a, jVar);
            b0Var.c(k.f4110a, new c(this));
            b0Var.a(k.f4110a, new e.a.a.c.k(this));
            return;
        }
        throw null;
    }

    public void stopExposureNotifications() {
        this.inFlightLiveData.setValue(Boolean.TRUE);
        i<Void> stop = ExposureNotificationClientWrapper.get(getApplication()).stop();
        e.a.a.c.i iVar = new e.a.a.c.i(this);
        b0 b0Var = (b0) stop;
        if (b0Var != null) {
            b0Var.d(k.f4110a, iVar);
            b0Var.c(k.f4110a, new e.a.a.c.b(this));
            b0Var.a(k.f4110a, new e(this));
            return;
        }
        throw null;
    }
}
