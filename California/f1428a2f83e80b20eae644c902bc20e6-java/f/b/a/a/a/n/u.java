package f.b.a.a.a.n;

import android.util.Log;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import l.b.a.c;

public final /* synthetic */ class u implements i {
    public static final /* synthetic */ u a = new u();

    @Override // f.b.b.f.a.i
    public final f.b.b.f.a.u a(Object obj) {
        Exception exc = (Exception) obj;
        c cVar = ProvideDiagnosisKeysWorker.m;
        if (exc instanceof ProvideDiagnosisKeysWorker.b) {
            return new s.a(new ProvideDiagnosisKeysWorker.b(null));
        }
        Log.e("ProvideDiagnosisKeysWkr", "Exception while updating the DiagnosisKeyDataMapping", exc);
        return s.c;
    }
}
