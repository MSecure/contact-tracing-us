package f.b.a.a.a.q;

import android.net.Uri;
import e.b.a.m;
import f.a.b.k;
import f.a.b.n;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.h.s.a;

public class h extends n<byte[]> {
    public final p.b<byte[]> p;

    public h(Uri uri, p.b<byte[]> bVar, p.a aVar, a aVar2) {
        super(0, uri.toString(), aVar);
        this.p = bVar;
        this.f2061l = true;
        this.m = new c(aVar2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.a.b.n
    public void b(byte[] bArr) {
        this.p.a(bArr);
    }

    @Override // f.a.b.n
    public p<byte[]> q(k kVar) {
        if (kVar.a < 400) {
            return new p<>(kVar.b, m.h.H0(kVar));
        }
        return new p<>(new u(kVar));
    }
}
