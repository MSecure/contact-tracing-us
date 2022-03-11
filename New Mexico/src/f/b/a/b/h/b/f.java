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
public final class f implements d<r> {
    public static final f a = new f();

    @Override // f.b.c.i.b
    public void a(Object obj, Object obj2) {
        r rVar = (r) obj;
        e eVar = (e) obj2;
        eVar.d("requestTimeMs", rVar.f());
        eVar.d("requestUptimeMs", rVar.g());
        eVar.c("clientInfo", rVar.a());
        eVar.c("logSource", rVar.c());
        eVar.c("logSourceName", rVar.d());
        eVar.c("logEvent", rVar.b());
        eVar.c("qosTier", rVar.e());
    }
}
