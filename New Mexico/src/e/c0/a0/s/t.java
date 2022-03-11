package e.c0.a0.s;

import android.database.Cursor;
import e.v.b;
import e.v.g;
import e.v.i;
import e.x.a.f.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class t implements s {
    public final g a;
    public final b<r> b;

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
    public class a extends b<r> {
        public a(t tVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            r rVar = (r) obj;
            String str = rVar.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            String str2 = rVar.b;
            if (str2 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, str2);
            }
        }
    }

    public t(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
    }

    public List<String> a(String str) {
        i t = i.t("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            t.J(1);
        } else {
            t.L(1, str);
        }
        this.a.b();
        Cursor b = e.v.p.b.b(this.a, t, false, null);
        try {
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(b.getString(0));
            }
            return arrayList;
        } finally {
            b.close();
            t.Q();
        }
    }
}
