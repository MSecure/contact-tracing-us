package f.b.a.a.a.p0;

import e.c0.q;
/* loaded from: classes.dex */
public class p implements f.b.b.f.a.p<q.b.c> {
    public p(q qVar) {
    }

    @Override // f.b.b.f.a.p
    public void a(q.b.c cVar) {
        q.f2373f.f("Scheduled SubmitPrivateAnalyticsWorker.");
    }

    @Override // f.b.b.f.a.p
    public void b(Throwable th) {
        q.f2373f.d("Failed to schedule SubmitPrivateAnalyticsWorker.", th);
    }
}
