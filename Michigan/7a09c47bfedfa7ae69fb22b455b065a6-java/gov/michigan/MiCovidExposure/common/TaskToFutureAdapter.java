package gov.michigan.MiCovidExposure.common;

import b.b.k.i;
import b.f.a.b;
import c.b.a.a.j.b0;
import c.b.a.a.j.c0;
import c.b.a.a.j.i;
import c.b.a.a.j.q;
import c.b.a.a.j.y;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import e.a.a.a.d;
import e.a.a.a.e;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskToFutureAdapter {
    public static final String TAG = "TaskToFutureAdapter";

    public static Object a(i iVar, ScheduledExecutorService scheduledExecutorService, b bVar) {
        e eVar = new e(bVar);
        b0 b0Var = (b0) iVar;
        y<TResult> yVar = b0Var.f4102b;
        c0.a(scheduledExecutorService);
        yVar.b(new q(scheduledExecutorService, eVar));
        b0Var.k();
        return "GmsCoreTask";
    }

    public static void b(b bVar, i iVar) {
        try {
            if (((b0) iVar).f4104d) {
                bVar.b();
            } else if (iVar.e() != null) {
                bVar.d(iVar.e());
            } else {
                bVar.a(iVar.f());
            }
        } catch (Exception e2) {
            bVar.d(e2);
        }
    }

    public static <T> u<T> getFutureWithTimeout(i<T> iVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return l.s(i.j.z(new d(iVar, scheduledExecutorService))).v(j, timeUnit, scheduledExecutorService);
    }
}
