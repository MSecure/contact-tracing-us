package f.b.a.a.a.b0;

import androidx.work.ListenableWorker;
import f.b.a.a.a.y.f0;
import f.b.a.a.a.y.g0;
import f.b.b.a.g;

public final /* synthetic */ class a0 implements g {
    public static final /* synthetic */ a0 a = new a0();

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        f0.d dVar = (f0.d) obj;
        if (g0.RATE_LIMITED.equals(dVar.b) || g0.SERVER_ERROR.equals(dVar.b)) {
            return new ListenableWorker.a.b();
        }
        return new ListenableWorker.a.C0003a();
    }
}
