package f.b.a.a.a.y;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.b0.a0.c;
import e.b0.d;
import e.b0.f;
import e.b0.h;
import e.b0.o;
import e.b0.p;
import e.b0.w;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
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
        boolean z = true;
        if (uploadCoverTrafficWorker.j(0.8d)) {
            return uploadCoverTrafficWorker.f361j.schedule((Callable) new r(uploadCoverTrafficWorker), d.i((long) uploadCoverTrafficWorker.f362k.nextInt(((int) UploadCoverTrafficWorker.p.t()) + 1)).t(), TimeUnit.MILLISECONDS);
        }
        long nextInt = (long) uploadCoverTrafficWorker.f362k.nextInt(((int) UploadCoverTrafficWorker.q.b) + 1);
        if (nextInt > UploadCoverTrafficWorker.r.b) {
            z = false;
        }
        if (!z) {
            return new s.a(new UploadCoverTrafficWorker.b(null));
        }
        w wVar = uploadCoverTrafficWorker.m;
        HashMap hashMap = new HashMap();
        hashMap.put("UploadCoverTrafficWorker.IS_DELAYED_EXECUTION", Boolean.TRUE);
        f fVar = new f(hashMap);
        f.c(fVar);
        p.a aVar = new p.a(UploadCoverTrafficWorker.class);
        d.a aVar2 = new d.a();
        aVar2.a = o.CONNECTED;
        e.b0.d dVar = new e.b0.d(aVar2);
        e.b0.a0.s.o oVar = aVar.c;
        oVar.f1118j = dVar;
        oVar.f1113e = fVar;
        h hVar = h.KEEP;
        Objects.requireNonNull(wVar);
        return l.x(((c) wVar.f("UploadCoverTrafficWorker", hVar, Collections.singletonList((p) ((p.a) aVar.e(nextInt, TimeUnit.SECONDS)).a()))).f1002d).z(y.a, uploadCoverTrafficWorker.f360i);
    }
}
