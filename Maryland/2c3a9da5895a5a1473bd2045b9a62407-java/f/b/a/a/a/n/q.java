package f.b.a.a.a.n;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.a.a.a.n.r;
import f.b.a.a.a.n.u;
import f.b.b.b.c;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import l.b.a.e;

public final /* synthetic */ class q implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ q(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        c<String> cVar;
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        u uVar = (u) obj;
        v vVar = uploadCoverTrafficWorker.f355e;
        u.a i2 = u.i("FAKE-VALIDATION-CODE");
        i2.b(true);
        i2.c(uploadCoverTrafficWorker.g());
        c q = c.q("US", "CA");
        r.b bVar = (r.b) i2;
        if (q == null) {
            cVar = null;
        } else {
            cVar = c.s(q);
        }
        bVar.f2184d = cVar;
        bVar.f2187g = f.b.a.a.a.h.r.a(32);
        bVar.f2185e = f.b.a.a.a.h.r.a(100);
        bVar.f2188h = f.b.a.a.a.h.r.a(100);
        bVar.f2189i = e.P(2020, 1, 1);
        return vVar.b(bVar.a());
    }
}
