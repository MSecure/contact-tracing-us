package f.b.a.f.a.b;

import android.content.Context;
import f.b.a.f.a.e.t;
import f.b.a.f.a.e.u;
import java.util.Objects;
/* loaded from: classes.dex */
public final class q3 implements u<v3> {
    public final u<Context> a;
    public final u<s> b;
    public final u<a2> c;

    public q3(u<Context> uVar, u<s> uVar2, u<a2> uVar3) {
        this.a = uVar;
        this.b = uVar2;
        this.c = uVar3;
    }

    @Override // f.b.a.f.a.e.u
    public final v3 a() {
        v3 v3Var = (v3) (m3.a(((r3) this.a).b()) == null ? t.b(this.b).a() : t.b(this.c).a());
        Objects.requireNonNull(v3Var, "Cannot return null from a non-@Nullable @Provides method");
        return v3Var;
    }
}
