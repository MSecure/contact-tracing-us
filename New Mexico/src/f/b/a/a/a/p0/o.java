package f.b.a.a.a.p0;

import e.c0.q;
import f.b.b.f.a.p;
/* loaded from: classes.dex */
public class o implements p<q.b.c> {
    public o(q qVar) {
    }

    @Override // f.b.b.f.a.p
    public void a(q.b.c cVar) {
        q.f2373f.f("Scheduled FirelogAnalyticsWorker.");
    }

    @Override // f.b.b.f.a.p
    public void b(Throwable th) {
        q.f2373f.d("Failed to schedule FirelogAnalyticsWorker.", th);
    }
}
