package f.b.a.c.e.c;

import f.b.a.c.b.l.a;
import f.b.a.c.b.l.l.k;
import f.b.a.c.i.i;
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
public final /* synthetic */ class j3 implements k {
    public static final /* synthetic */ j3 a = new j3();

    @Override // f.b.a.c.b.l.l.k
    public final void a(Object obj, Object obj2) {
        a<a.c.C0084c> aVar = v.f2785h;
        b2 b2Var = new b2(null);
        b2Var.c = true;
        b2Var.b = new o((i) obj2);
        ((m1) ((s2) obj).t()).F(b2Var);
    }
}
