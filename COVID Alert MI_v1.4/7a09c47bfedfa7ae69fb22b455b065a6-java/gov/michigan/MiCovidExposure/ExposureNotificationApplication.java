package gov.michigan.MiCovidExposure;

import androidx.annotation.Keep;
import b.b0.b;
import b.b0.y.k;
import b.m.a.a;
import b.q.b;
import c.b.b.e.a.v;
import g.b.a.x.h;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import gov.michigan.MiCovidExposure.network.WorkScheduler;
import gov.michigan.MiCovidExposure.slices.SlicePermissionManager;
import java.util.Optional;

public final class ExposureNotificationApplication extends b implements b.AbstractC0016b {
    public v lightweightExecutor;
    public Optional<SlicePermissionManager> slicePermissionManager;
    @Keep
    public b.b0.v workManager;
    public WorkScheduler workScheduler;
    public a workerFactory;

    @Override // b.b0.b.AbstractC0016b
    public b.b0.b getWorkManagerConfiguration() {
        b.a aVar = new b.a();
        aVar.f1004a = this.workerFactory;
        return new b.b0.b(aVar);
    }

    public void onCreate() {
        super.onCreate();
        this.workManager = k.b(getApplicationContext());
        v lightweightExecutor2 = AppExecutors.getLightweightExecutor();
        this.lightweightExecutor = lightweightExecutor2;
        this.workScheduler = new WorkScheduler(this.workManager, lightweightExecutor2);
        if (!c.c.a.a.f5967a.getAndSet(true)) {
            c.c.a.b bVar = new c.c.a.b(this, "org/threeten/bp/TZDB.dat");
            if (h.f6707a.get()) {
                throw new IllegalStateException("Already initialized");
            } else if (!h.f6708b.compareAndSet(null, bVar)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
        this.workScheduler.schedule();
    }
}
