package c.b.a.a.e.c;

import c.b.a.a.c.k.e;
import com.google.android.gms.nearby.connection.Payload;

public final class l6 extends r6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f2654b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l6(e eVar, String str, byte[] bArr) {
        super(eVar, null);
        this.f2653a = str;
        this.f2654b = bArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.a.a.c.k.a$b] */
    @Override // c.b.a.a.c.k.o.d
    public final /* synthetic */ void doExecute(v3 v3Var) {
        v3Var.k(this, new String[]{this.f2653a}, Payload.fromBytes(this.f2654b));
    }
}
