package e.a.a.a;

import b.f.a.b;
import c.b.a.a.j.i;
import gov.michigan.MiCovidExposure.common.TaskToFutureAdapter;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: lambda */
public final /* synthetic */ class d implements b.f.a.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f6217a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f6218b;

    public /* synthetic */ d(i iVar, ScheduledExecutorService scheduledExecutorService) {
        this.f6217a = iVar;
        this.f6218b = scheduledExecutorService;
    }

    @Override // b.f.a.d
    public final Object a(b bVar) {
        TaskToFutureAdapter.a(this.f6217a, this.f6218b, bVar);
        return "GmsCoreTask";
    }
}
