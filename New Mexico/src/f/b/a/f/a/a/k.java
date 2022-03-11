package f.b.a.f.a.a;

import android.content.Context;
import f.b.a.f.a.e.u;
import java.util.Objects;
/* loaded from: classes.dex */
public final class k implements u<Context> {
    public final i a;

    public k(i iVar) {
        this.a = iVar;
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
