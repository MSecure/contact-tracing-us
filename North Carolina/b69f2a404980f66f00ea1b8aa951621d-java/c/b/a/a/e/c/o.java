package c.b.a.a.e.c;

import b.b.k.i;
import c.b.a.a.g.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatus;

public final class o extends l2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f2677a;

    public o(i iVar) {
        this.f2677a = iVar;
    }

    @Override // c.b.a.a.e.c.i2
    public final void t(Status status, long j) {
        i.j.a1(status, ExposureNotificationStatus.fromValue(j), this.f2677a);
    }
}
