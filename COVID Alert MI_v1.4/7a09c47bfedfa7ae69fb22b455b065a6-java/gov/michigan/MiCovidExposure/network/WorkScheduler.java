package gov.michigan.MiCovidExposure.network;

import b.b0.p;
import b.b0.y.s.r.c;
import c.b.b.e.a.q;
import c.b.b.e.a.v;
import gov.michigan.MiCovidExposure.common.Qualifiers;
import gov.michigan.MiCovidExposure.nearby.ProvideDiagnosisKeysWorker;

public class WorkScheduler {
    public static final String TAG = "WorkScheduler";
    public final v lightweightExecutor;
    public final b.b0.v workManager;

    public WorkScheduler(b.b0.v vVar, @Qualifiers.LightweightExecutor v vVar2) {
        this.workManager = vVar;
        this.lightweightExecutor = vVar2;
    }

    public void schedule() {
        c<p.b.c> cVar = ((b.b0.y.c) ProvideDiagnosisKeysWorker.scheduleDailyProvideDiagnosisKeys(this.workManager)).f1066d;
        AnonymousClass1 r1 = new c.b.b.e.a.p<p.b.c>() {
            /* class gov.michigan.MiCovidExposure.network.WorkScheduler.AnonymousClass1 */

            @Override // c.b.b.e.a.p
            public void onFailure(Throwable th) {
            }

            public void onSuccess(p.b.c cVar) {
            }
        };
        cVar.b(new q(cVar, r1), this.lightweightExecutor);
    }
}
