package c.b.a.a.g.e;

import c.b.a.a.d.k.e;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

public final class k6 extends r6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f3624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f3625b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k6(e eVar, List list, byte[] bArr) {
        super(eVar, null);
        this.f3624a = list;
        this.f3625b = bArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.d.k.a$b] */
    @Override // c.b.a.a.d.k.o.d
    public final /* synthetic */ void doExecute(v3 v3Var) {
        v3Var.k(this, (String[]) this.f3624a.toArray(new String[0]), Payload.fromBytes(this.f3625b));
    }
}
