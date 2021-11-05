package d.a.a.a.c;

import b.f.a.b;
import b.f.a.d;
import c.b.a.a.g.h;
import gov.nc.dhhs.exposurenotification.common.TaskToFutureAdapter;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: lambda */
public final /* synthetic */ class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f4604a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f4605b;

    public /* synthetic */ e(h hVar, ScheduledExecutorService scheduledExecutorService) {
        this.f4604a = hVar;
        this.f4605b = scheduledExecutorService;
    }

    @Override // b.f.a.d
    public final Object a(b bVar) {
        TaskToFutureAdapter.a(this.f4604a, this.f4605b, bVar);
        return "GmsCoreTask";
    }
}
