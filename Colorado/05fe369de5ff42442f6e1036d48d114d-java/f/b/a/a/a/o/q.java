package f.b.a.a.a.o;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.z.c;
import e.z.e;
import e.z.m;
import e.z.n;
import e.z.t;
import e.z.x.s.o;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import l.b.a.d;

public final /* synthetic */ class q implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ q(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        e0 e0Var = (e0) obj;
        if (uploadCoverTrafficWorker.j(0.8d)) {
            return uploadCoverTrafficWorker.f357h.schedule((Callable) new r(uploadCoverTrafficWorker), d.i((long) uploadCoverTrafficWorker.f358i.nextInt(10001)).t(), TimeUnit.MILLISECONDS);
        }
        t tVar = uploadCoverTrafficWorker.f360k;
        HashMap hashMap = new HashMap();
        hashMap.put("UploadCoverTrafficWorker.IS_DELAYED_EXECUTION", Boolean.TRUE);
        e eVar = new e(hashMap);
        e.c(eVar);
        n.a aVar = new n.a(UploadCoverTrafficWorker.class);
        c.a aVar2 = new c.a();
        aVar2.a = m.CONNECTED;
        c cVar = new c(aVar2);
        o oVar = aVar.c;
        oVar.f1994j = cVar;
        oVar.f1989e = eVar;
        return l.x(((e.z.x.c) tVar.b(((n.a) aVar.e((long) uploadCoverTrafficWorker.f358i.nextInt(7), TimeUnit.HOURS)).a())).f1880d).z(y.a, uploadCoverTrafficWorker.f356g);
    }
}
