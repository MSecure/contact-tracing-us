package e.t;

import android.os.Bundle;
import e.t.q;
import f.a.a.a.a;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
@q.b("navigation")
/* loaded from: classes.dex */
public class l extends q<k> {
    public final r a;

    public l(r rVar) {
        this.a = rVar;
    }

    @Override // e.t.q
    public k a() {
        return new k(this);
    }

    @Override // e.t.q
    public j b(j jVar, Bundle bundle, o oVar, q.a aVar) {
        String str;
        k kVar = (k) jVar;
        int i2 = kVar.f1945k;
        if (i2 == 0) {
            StringBuilder h2 = a.h("no start destination defined via app:startDestination for ");
            int i3 = kVar.f1935d;
            if (i3 != 0) {
                if (kVar.f1936e == null) {
                    kVar.f1936e = Integer.toString(i3);
                }
                str = kVar.f1936e;
            } else {
                str = "the root navigation";
            }
            h2.append(str);
            throw new IllegalStateException(h2.toString());
        }
        j o = kVar.o(i2, false);
        if (o != null) {
            return this.a.c(o.b).b(o, o.h(bundle), oVar, aVar);
        }
        if (kVar.f1946l == null) {
            kVar.f1946l = Integer.toString(kVar.f1945k);
        }
        throw new IllegalArgumentException(a.c("navigation destination ", kVar.f1946l, " is not a direct child of this NavGraph"));
    }

    public boolean e() {
        return true;
    }
}
