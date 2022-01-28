package c.b.a.a.g.e;

import b.x.t;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatus;

public final class o extends l2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f3669a;

    public o(j jVar) {
        this.f3669a = jVar;
    }

    @Override // c.b.a.a.g.e.i2
    public final void q(Status status, long j) {
        t.L2(status, ExposureNotificationStatus.fromValue(j), this.f3669a);
    }
}
