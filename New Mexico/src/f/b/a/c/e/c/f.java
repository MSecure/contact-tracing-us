package f.b.a.c.e.c;

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
public final /* synthetic */ class f implements k {
    public final /* synthetic */ v a;

    public /* synthetic */ f(v vVar) {
        this.a = vVar;
    }

    @Override // f.b.a.c.b.l.l.k
    public final void a(Object obj, Object obj2) {
        j jVar = new j((i) obj2);
        r0 r0Var = new r0((q0) null);
        r0Var.b = jVar;
        ((m1) ((s2) obj).t()).I(r0Var);
    }
}
