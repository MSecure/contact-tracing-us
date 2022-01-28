package c.b.a.a.g.e;

import c.b.a.a.d.k.e;
import com.google.android.gms.nearby.connection.Payload;

public final class l6 extends r6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3643a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f3644b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l6(e eVar, String str, byte[] bArr) {
        super(eVar, null);
        this.f3643a = str;
        this.f3644b = bArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b] */
    @Override // c.b.a.a.d.k.o.d
    public final /* synthetic */ void doExecute(v3 v3Var) {
        v3Var.k(this, new String[]{this.f3643a}, Payload.fromBytes(this.f3644b));
    }
}
