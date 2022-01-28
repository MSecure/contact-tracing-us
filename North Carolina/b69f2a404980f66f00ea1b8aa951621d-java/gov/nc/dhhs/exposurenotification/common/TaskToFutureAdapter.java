package gov.nc.dhhs.exposurenotification.common;

import b.b.k.i;
import b.f.a.b;
import c.b.a.a.g.a0;
import c.b.a.a.g.c0;
import c.b.a.a.g.h;
import c.b.a.a.g.q;
import c.b.a.a.g.y;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import d.a.a.a.c.d;
import d.a.a.a.c.e;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskToFutureAdapter {
    public static final String TAG = "TaskToFutureAdapter";

    public static Object a(h hVar, ScheduledExecutorService scheduledExecutorService, b bVar) {
        d dVar = new d(bVar);
        a0 a0Var = (a0) hVar;
        y<TResult> yVar = a0Var.f2850b;
        c0.a(scheduledExecutorService);
        yVar.b(new q(scheduledExecutorService, dVar));
        a0Var.k();
        return "GmsCoreTask";
    }

    public static void b(b bVar, h hVar) {
        try {
            if (((a0) hVar).f2852d) {
                bVar.b();
            } else if (hVar.e() != null) {
                bVar.d(hVar.e());
            } else {
                bVar.a(hVar.f());
            }
        } catch (Exception e2) {
            bVar.d(e2);
        }
    }

    public static <T> u<T> getFutureWithTimeout(h<T> hVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return l.s(i.j.b0(new e(hVar, scheduledExecutorService))).v(j, timeUnit, scheduledExecutorService);
    }
}
