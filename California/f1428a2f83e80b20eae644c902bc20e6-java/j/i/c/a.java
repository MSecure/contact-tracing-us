package j.i.c;

import j.j.b.e;

public class a extends j.i.a {
    @Override // j.i.a
    public void a(Throwable th, Throwable th2) {
        e.c(th, "cause");
        e.c(th2, "exception");
        th.addSuppressed(th2);
    }
}
