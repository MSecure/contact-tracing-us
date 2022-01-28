package f.b.a.a.a.q;

import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import l.b.a.d;

public final /* synthetic */ class h0 implements i {
    public static final /* synthetic */ h0 a = new h0();

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        Exception exc = (Exception) obj;
        d dVar = ProvideDiagnosisKeysWorker.m;
        if (exc instanceof ProvideDiagnosisKeysWorker.b) {
            return new s.a(new ProvideDiagnosisKeysWorker.b(null));
        }
        ProvideDiagnosisKeysWorker.n.d("Exception while updating the DiagnosisKeyDataMapping", exc);
        return s.c;
    }
}
