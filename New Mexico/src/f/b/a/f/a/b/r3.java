package f.b.a.f.a.b;

import android.content.Context;
import f.b.a.f.a.e.u;
import java.util.Objects;
/* loaded from: classes.dex */
public final class r3 implements u<Context> {
    public final m3 a;

    public r3(m3 m3Var) {
        this.a = m3Var;
    }

    @Override // f.b.a.f.a.e.u
    public final Context a() {
        Context context = this.a.a;
        Objects.requireNonNull(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }

    public final Context b() {
        Context context = this.a.a;
        Objects.requireNonNull(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }
}
