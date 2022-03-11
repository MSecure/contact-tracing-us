package f.b.c.i.h;

import f.b.c.i.c;
import f.b.c.i.d;
import f.b.c.i.h.e;
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
public final /* synthetic */ class a implements d {
    public static final a a = new a();

    @Override // f.b.c.i.b
    public void a(Object obj, Object obj2) {
        e.a aVar = e.f3491e;
        StringBuilder h2 = f.a.a.a.a.h("Couldn't find encoder for type ");
        h2.append(obj.getClass().getCanonicalName());
        throw new c(h2.toString());
    }
}
