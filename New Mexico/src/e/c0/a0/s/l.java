package e.c0.a0.s;

import e.v.b;
import e.v.g;
import e.x.a.f.f;
/* loaded from: classes.dex */
public final class l implements k {
    public final g a;
    public final b<j> b;

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
    public class a extends b<j> {
        public a(l lVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            j jVar = (j) obj;
            String str = jVar.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            String str2 = jVar.b;
            if (str2 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, str2);
            }
        }
    }

    public l(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }
}
