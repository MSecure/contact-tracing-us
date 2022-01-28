package c.b.a.a.g.b;

import c.b.a.a.c.a;
import c.b.a.a.c.f;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.i;
import c.b.a.a.d.k.o.d;
import com.google.android.gms.common.api.Status;

public final class v4 extends d<Status, z4> {

    /* renamed from: a  reason: collision with root package name */
    public final f f3448a;

    public v4(f fVar, e eVar) {
        super(a.o, eVar);
        this.f3448a = fVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ i createFailedResult(Status status) {
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b] */
    @Override // c.b.a.a.d.k.o.d
    public final /* synthetic */ void doExecute(z4 z4Var) {
        z4 z4Var2 = z4Var;
        y4 y4Var = new y4(this);
        try {
            f fVar = this.f3448a;
            if (fVar.k != null && fVar.j.l.length == 0) {
                fVar.j.l = fVar.k.zza();
            }
            if (fVar.l != null && fVar.j.s.length == 0) {
                fVar.j.s = fVar.l.zza();
            }
            w4 w4Var = fVar.j;
            int c2 = w4Var.c();
            byte[] bArr = new byte[c2];
            j4.b(w4Var, bArr, c2);
            fVar.f2911c = bArr;
            ((c5) z4Var2.getService()).c0(y4Var, this.f3448a);
        } catch (RuntimeException unused) {
            setFailedResult(new Status(10, "MessageProducer"));
        }
    }
}
