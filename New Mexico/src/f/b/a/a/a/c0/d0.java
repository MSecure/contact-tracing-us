package f.b.a.a.a.c0;

import androidx.work.ListenableWorker;
import f.b.a.a.a.z.f0;
import f.b.a.a.a.z.g0;
import f.b.b.a.g;
/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements g {
    public static final /* synthetic */ d0 a = new d0();

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        f0.d dVar = (f0.d) obj;
        if (g0.RATE_LIMITED.equals(dVar.b) || g0.SERVER_ERROR.equals(dVar.b)) {
            return new ListenableWorker.a.b();
        }
        return new ListenableWorker.a.C0003a();
    }
}
