package j.j.c;

import j.k.b.e;
/* loaded from: classes.dex */
public class a extends j.j.a {
    @Override // j.j.a
    public void a(Throwable th, Throwable th2) {
        e.c(th, "cause");
        e.c(th2, "exception");
        th.addSuppressed(th2);
    }
}
