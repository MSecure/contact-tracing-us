package gov.nc.dhhs.exposurenotification;

import b.p.b;
import c.c.a.a;
import e.c.a.x.h;

public final class ExposureNotificationApplication extends b {
    public void onCreate() {
        super.onCreate();
        if (!a.f4421a.getAndSet(true)) {
            c.c.a.b bVar = new c.c.a.b(this, "org/threeten/bp/TZDB.dat");
            if (h.f5218a.get()) {
                throw new IllegalStateException("Already initialized");
            } else if (!h.f5219b.compareAndSet(null, bVar)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
    }
}
