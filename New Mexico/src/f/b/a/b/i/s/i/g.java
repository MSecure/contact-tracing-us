package f.b.a.b.i.s.i;

import java.util.Objects;
/* loaded from: classes.dex */
public final class g implements Object<d> {

    /* loaded from: classes.dex */
    public static final class a {
        public static final g a = new g();
    }

    public Object get() {
        d dVar = d.a;
        Objects.requireNonNull(dVar, "Cannot return null from a non-@Nullable @Provides method");
        return dVar;
    }
}
