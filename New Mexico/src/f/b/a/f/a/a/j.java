package f.b.a.f.a.a;

import f.b.a.f.a.e.u;
import java.util.Objects;
/* loaded from: classes.dex */
public final class j implements u<b> {
    public final u<g> a;

    public j(u<g> uVar) {
        this.a = uVar;
    }

    @Override // f.b.a.f.a.e.u
    public final b a() {
        g a = this.a.a();
        Objects.requireNonNull(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
