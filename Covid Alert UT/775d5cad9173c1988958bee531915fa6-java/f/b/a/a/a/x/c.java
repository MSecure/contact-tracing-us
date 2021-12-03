package f.b.a.a.a.x;

import e.b.a.m;
import f.b.b.f.a.i;
import f.b.b.f.a.j;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.Objects;

public final /* synthetic */ class c implements i {
    public final /* synthetic */ n a;

    public /* synthetic */ c(n nVar) {
        this.a = nVar;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        n nVar = this.a;
        Objects.requireNonNull(nVar);
        byte[] bArr = new byte[8];
        n.n.nextBytes(bArr);
        String c = n.o.c(bArr);
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        for (q qVar : (f.b.b.b.c) obj) {
            int i3 = i2 + 1;
            arrayList.add(l.x(m.e.l0(new a(nVar, qVar.d()))).z(new b(nVar, qVar, String.format("/diag_keys/%s/keys_%s.zip", c, Integer.valueOf(i2))), nVar.f2451g));
            i2 = i3;
        }
        return l.x(new j.a(f.b.b.b.c.r(arrayList), true)).y(f.a, nVar.f2452h);
    }
}
