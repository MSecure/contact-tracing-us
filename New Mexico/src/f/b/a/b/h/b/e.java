package f.b.a.b.h.b;

import f.b.c.i.d;
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
public final class e implements d<q> {
    public static final e a = new e();

    @Override // f.b.c.i.b
    public void a(Object obj, Object obj2) {
        q qVar = (q) obj;
        f.b.c.i.e eVar = (f.b.c.i.e) obj2;
        eVar.d("eventTimeMs", qVar.b());
        eVar.c("eventCode", qVar.a());
        eVar.d("eventUptimeMs", qVar.c());
        eVar.c("sourceExtension", qVar.e());
        eVar.c("sourceExtensionJsonProto3", qVar.f());
        eVar.d("timezoneOffsetSeconds", qVar.g());
        eVar.c("networkConnectionInfo", qVar.d());
    }
}
