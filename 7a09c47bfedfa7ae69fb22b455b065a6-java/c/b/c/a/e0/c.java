package c.b.c.a.e0;

import c.b.c.a.b0.a;
import c.b.c.a.i0.g1;
import c.b.c.a.y;
import java.security.GeneralSecurityException;

public final class c {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final g1 f4798a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final g1 f4799b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final g1 f4800c;

    static {
        new b();
        new a();
        g1 g1Var = g1.DEFAULT_INSTANCE;
        f4798a = g1Var;
        f4799b = g1Var;
        f4800c = g1Var;
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        a.a();
        y.h(new a(), new b(), true);
        y.j(new d());
        y.j(new e());
    }
}
