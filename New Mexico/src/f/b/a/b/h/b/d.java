package f.b.a.b.h.b;

import f.b.c.i.e;
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
public final class d implements f.b.c.i.d<p> {
    public static final d a = new d();

    @Override // f.b.c.i.b
    public void a(Object obj, Object obj2) {
        p pVar = (p) obj;
        e eVar = (e) obj2;
        eVar.c("clientType", pVar.b());
        eVar.c("androidClientInfo", pVar.a());
    }
}
