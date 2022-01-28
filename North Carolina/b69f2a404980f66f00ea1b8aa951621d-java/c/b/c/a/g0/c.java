package c.b.c.a.g0;

import c.b.c.a.i0.g1;
import c.b.c.a.y;
import java.security.GeneralSecurityException;

public final class c {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final g1 f3471a = g1.DEFAULT_INSTANCE;

    static {
        new b();
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() {
        y.i(new b(), true);
        y.i(new a(), true);
        y.j(new d());
    }
}
