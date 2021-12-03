package f.b.a.a.a.y;

import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import f.b.a.a.a.y.b0;
import f.b.b.c.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.security.SecureRandom;
import java.util.Objects;
import l.b.a.f;

public final /* synthetic */ class x implements i {
    public final /* synthetic */ UploadCoverTrafficWorker a;

    public /* synthetic */ x(UploadCoverTrafficWorker uploadCoverTrafficWorker) {
        this.a = uploadCoverTrafficWorker;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        u uVar;
        UploadCoverTrafficWorker uploadCoverTrafficWorker = this.a;
        Objects.requireNonNull(uploadCoverTrafficWorker);
        if (!((Boolean) obj).booleanValue()) {
            return new s.a(new UploadCoverTrafficWorker.b(null));
        }
        if (!uploadCoverTrafficWorker.j(0.16666666666666666d)) {
            uVar = s.c;
        } else {
            f0 f0Var = uploadCoverTrafficWorker.f358g;
            SecureRandom secureRandom = uploadCoverTrafficWorker.f362k;
            a aVar = f.b.a.a.a.s.x.a;
            byte[] bArr = new byte[256];
            secureRandom.nextBytes(bArr);
            String c = f.b.a.a.a.s.x.a.c(bArr);
            f fVar = f.f4357e;
            b0.b bVar = (b0.b) i0.d("FAKE-PHONE-NUMBER", c, f.O(l.b.a.a.b()), 0);
            bVar.f2487g = Boolean.TRUE;
            uVar = f0Var.a(bVar.a());
        }
        return l.x(uVar).z(new p(uploadCoverTrafficWorker), uploadCoverTrafficWorker.f359h).z(new q(uploadCoverTrafficWorker), uploadCoverTrafficWorker.f359h).z(new z(uploadCoverTrafficWorker), uploadCoverTrafficWorker.f359h);
    }
}
