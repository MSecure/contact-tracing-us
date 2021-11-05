package c.b.c.a.d0;

import c.b.c.a.i0.g1;
import c.b.c.a.y;
import java.security.GeneralSecurityException;

public final class b {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final g1 f3443a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final g1 f3444b;

    static {
        new a();
        g1 g1Var = g1.DEFAULT_INSTANCE;
        f3443a = g1Var;
        f3444b = g1Var;
        try {
            y.i(new a(), true);
            y.j(new c());
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        y.i(new a(), true);
        y.j(new c());
    }
}
