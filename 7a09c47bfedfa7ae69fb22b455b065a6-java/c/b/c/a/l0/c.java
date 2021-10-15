package c.b.c.a.l0;

import c.b.c.a.i0.g1;
import c.b.c.a.y;
import java.security.GeneralSecurityException;

public final class c {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final g1 f5089a;

    /* renamed from: b  reason: collision with root package name */
    public static final g1 f5090b;

    static {
        new a();
        new b();
        g1 g1Var = g1.DEFAULT_INSTANCE;
        f5089a = g1Var;
        f5090b = g1Var;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        y.i(new a(), true);
        y.i(new b(), true);
        y.j(new e());
    }
}
