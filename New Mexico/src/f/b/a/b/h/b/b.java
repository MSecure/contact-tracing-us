package f.b.a.b.h.b;

import f.b.c.i.d;
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
public final class b implements d<a> {
    public static final b a = new b();

    @Override // f.b.c.i.b
    public void a(Object obj, Object obj2) {
        a aVar = (a) obj;
        e eVar = (e) obj2;
        eVar.c("sdkVersion", aVar.h());
        eVar.c("model", aVar.e());
        eVar.c("hardware", aVar.c());
        eVar.c("device", aVar.a());
        eVar.c("product", aVar.g());
        eVar.c("osBuild", aVar.f());
        eVar.c("manufacturer", aVar.d());
        eVar.c("fingerprint", aVar.b());
    }
}
