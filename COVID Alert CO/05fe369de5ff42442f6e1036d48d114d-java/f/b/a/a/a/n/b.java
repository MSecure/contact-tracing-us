package f.b.a.a.a.n;

import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.io.IOException;
import java.util.Objects;

public final /* synthetic */ class b implements i {
    public final /* synthetic */ n a;
    public final /* synthetic */ q b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(n nVar, q qVar, String str) {
        this.a = nVar;
        this.b = qVar;
        this.c = str;
    }

    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        n nVar = this.a;
        q qVar = this.b;
        String str = this.c;
        byte[] bArr = (byte[]) obj;
        Objects.requireNonNull(nVar);
        try {
            return f.b.a.c.b.o.b.O0(new m(qVar.b(), qVar.d(), nVar.a(bArr, str), qVar.c()));
        } catch (IOException e2) {
            return new s.a(e2);
        }
    }
}
