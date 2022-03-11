package f.b.a.c.e.c;

import android.content.Context;
import android.os.Looper;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.l.d;
import f.b.a.c.b.l.l.j;
import f.b.a.c.b.m.c;
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
public final class p extends a.AbstractC0082a<s2, a.c.C0084c> {
    @Override // f.b.a.c.b.l.a.AbstractC0082a
    public final /* synthetic */ s2 b(Context context, Looper looper, c cVar, Object obj, d dVar, j jVar) {
        a.c.C0084c cVar2 = (a.c.C0084c) obj;
        return new s2(context, looper, dVar, jVar, cVar);
    }
}
