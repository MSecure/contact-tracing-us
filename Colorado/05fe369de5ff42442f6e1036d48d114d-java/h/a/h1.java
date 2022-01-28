package h.a;

import h.a.q;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class h1 extends q.g {
    public static final Logger a = Logger.getLogger(h1.class.getName());
    public static final ThreadLocal<q> b = new ThreadLocal<>();

    @Override // h.a.q.g
    public q a() {
        q qVar = b.get();
        return qVar == null ? q.f4220h : qVar;
    }

    @Override // h.a.q.g
    public void b(q qVar, q qVar2) {
        ThreadLocal<q> threadLocal;
        if (a() != qVar) {
            a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (qVar2 != q.f4220h) {
            threadLocal = b;
        } else {
            threadLocal = b;
            qVar2 = null;
        }
        threadLocal.set(qVar2);
    }

    @Override // h.a.q.g
    public q c(q qVar) {
        q a2 = a();
        b.set(qVar);
        return a2;
    }
}
