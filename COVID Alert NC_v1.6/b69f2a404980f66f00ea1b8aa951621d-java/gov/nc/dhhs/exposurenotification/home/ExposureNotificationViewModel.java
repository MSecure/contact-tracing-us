package gov.nc.dhhs.exposurenotification.home;

import android.app.Application;
import androidx.lifecycle.LiveData;
import b.n.a;
import b.n.p;
import c.b.a.a.c.k.b;
import c.b.a.a.g.a0;
import c.b.a.a.g.h;
import c.b.a.a.g.j;
import d.a.a.a.e.c;
import d.a.a.a.e.d;
import d.a.a.a.e.e;
import d.a.a.a.e.f;
import d.a.a.a.e.g;
import d.a.a.a.e.i;
import d.a.a.a.e.k;
import gov.nc.dhhs.exposurenotification.common.SingleLiveEvent;
import gov.nc.dhhs.exposurenotification.nearby.ExposureNotificationClientWrapper;
import gov.nc.dhhs.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;

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
        CustomUtility.customLogger("A_CW_91000 - enabled Exposure Notification within app");
        refreshIsEnabledState();
        this.inFlightLiveData.setValue(Boolean.FALSE);
    }

    public void c(Exception exc) {
        if (!(exc instanceof b)) {
            StringBuilder g = c.a.a.a.a.g("A_CW_ERROR Unknown error when attempting to start API ");
            g.append(exc.getMessage());
            CustomUtility.customLogger(g.toString());
            this.inFlightLiveData.setValue(Boolean.FALSE);
            this.apiErrorLiveEvent.call();
            return;
        }
        b bVar = (b) exc;
        if (bVar.f2304b.f4432c == 6) {
            StringBuilder g2 = c.a.a.a.a.g("A_CW_ERROR API Exception  when attempting to start API, Error Code : ");
            g2.append(bVar.f2304b.f4432c);
            g2.append(", Error: ");
            g2.append(exc);
            g2.toString();
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
        CustomUtility.customLogger("A_CW_91000 - enabled Exposure Notification within app");
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
        h<Boolean> isEnabled = ExposureNotificationClientWrapper.get(getApplication()).isEnabled();
        d dVar = new d(this);
        a0 a0Var = (a0) isEnabled;
        if (a0Var != null) {
            a0Var.d(j.f2857a, dVar);
            return;
        }
        throw null;
    }

    public void scheduleSync() {
        ProvideDiagnosisKeysWorker.scheduleDailyProvideDiagnosisKeys(getApplication().getApplicationContext());
    }

    public void startExposureNotifications() {
        scheduleSync();
        this.inFlightLiveData.setValue(Boolean.TRUE);
        h<Void> start = ExposureNotificationClientWrapper.get(getApplication()).start();
        i iVar = new i(this);
        a0 a0Var = (a0) start;
        if (a0Var != null) {
            a0Var.d(j.f2857a, iVar);
            a0Var.c(j.f2857a, new d.a.a.a.e.h(this));
            a0Var.a(j.f2857a, new k(this));
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
        h<Void> start = ExposureNotificationClientWrapper.get(getApplication()).start();
        c cVar = new c(this);
        a0 a0Var = (a0) start;
        if (a0Var != null) {
            a0Var.d(j.f2857a, cVar);
            a0Var.c(j.f2857a, new d.a.a.a.e.j(this));
            a0Var.a(j.f2857a, new g(this));
            return;
        }
        throw null;
    }

    public void stopExposureNotifications() {
        this.inFlightLiveData.setValue(Boolean.TRUE);
        h<Void> stop = ExposureNotificationClientWrapper.get(getApplication()).stop();
        d.a.a.a.e.b bVar = new d.a.a.a.e.b(this);
        a0 a0Var = (a0) stop;
        if (a0Var != null) {
            a0Var.d(j.f2857a, bVar);
            a0Var.c(j.f2857a, new f(this));
            a0Var.a(j.f2857a, new e(this));
            return;
        }
        throw null;
    }
}
