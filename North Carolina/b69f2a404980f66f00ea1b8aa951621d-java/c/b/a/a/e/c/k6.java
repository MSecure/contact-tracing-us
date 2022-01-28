package c.b.a.a.e.c;

import c.b.a.a.c.k.e;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

public final class k6 extends r6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f2636a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f2637b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k6(e eVar, List list, byte[] bArr) {
        super(eVar, null);
        this.f2636a = list;
        this.f2637b = bArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b] */
    @Override // c.b.a.a.c.k.o.d
    public final /* synthetic */ void doExecute(v3 v3Var) {
        v3Var.k(this, (String[]) this.f2636a.toArray(new String[0]), Payload.fromBytes(this.f2637b));
    }
}
