package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import h.a.i1.a;
import h.a.w;
import java.util.concurrent.TimeUnit;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public abstract class w<T extends w<T>> extends l0<T> {
    @Override // h.a.l0
    public l0 b(long j2, TimeUnit timeUnit) {
        ((a) this).a.b(j2, timeUnit);
        return this;
    }

    public l0 c() {
        ((a) this).a.c();
        return this;
    }

    public String toString() {
        k u1 = b.u1(this);
        u1.d("delegate", ((a) this).a);
        return u1.toString();
    }
}
