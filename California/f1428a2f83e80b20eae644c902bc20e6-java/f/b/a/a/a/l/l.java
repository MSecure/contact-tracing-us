package f.b.a.a.a.l;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.a.a.a.h.r;
import f.b.a.a.a.l.q;
import f.b.a.a.a.l.t;
import f.b.b.b.c;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import l.b.a.e;

public final /* synthetic */ class l implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ l(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        c<String> cVar;
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        t tVar = (t) obj;
        u uVar = uploadCoverTrafficWorker.f346e;
        t.a i2 = t.i("FAKE-VALIDATION-CODE");
        i2.b(true);
        i2.c(uploadCoverTrafficWorker.g());
        c q = c.q("US", "CA");
        q.b bVar = (q.b) i2;
        if (q == null) {
            cVar = null;
        } else {
            cVar = c.s(q);
        }
        bVar.f2105d = cVar;
        bVar.f2108g = r.a(32);
        bVar.f2106e = r.a(100);
        bVar.f2109h = r.a(100);
        bVar.f2110i = e.P(2020, 1, 1);
        return uVar.b(bVar.a());
    }
}
