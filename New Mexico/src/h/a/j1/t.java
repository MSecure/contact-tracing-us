package h.a.j1;

import h.a.c1;
import h.a.j1.p;
import h.a.n0;
import h.b.a;
import h.b.b;
import h.b.c;
import h.b.d;
import java.util.Objects;
/* loaded from: classes.dex */
public final class t extends b0 {
    public final /* synthetic */ c1 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n0 f4330d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p.b f4331e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect args count in method signature: ()V */
    public t(p.b bVar, b bVar2, c1 c1Var, n0 n0Var) {
        super(p.this.f4272e);
        this.f4331e = bVar;
        this.c = c1Var;
        this.f4330d = n0Var;
    }

    @Override // h.a.j1.b0
    public void a() {
        d dVar = p.this.b;
        a aVar = c.a;
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(aVar);
        try {
            p.b bVar = this.f4331e;
            if (!bVar.b) {
                p.b.f(bVar, this.c, this.f4330d);
            }
            d dVar2 = p.this.b;
            Objects.requireNonNull(aVar);
        } catch (Throwable th) {
            d dVar3 = p.this.b;
            Objects.requireNonNull(c.a);
            throw th;
        }
    }
}
