package f.b.a.a.a.n0;

import e.b.a.m;
import e.v.g;
import e.v.l;
import e.x.a.f.f;
/* loaded from: classes.dex */
public final class m0 extends l0 {
    public final g a;
    public final e.v.b<o0> b;
    public final l c;

    /* loaded from: classes.dex */
    public class a extends e.v.b<o0> {
        public a(m0 m0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `DownloadServerEntity` (`indexUri`,`mostRecentSuccessfulDownload`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            o0 o0Var = (o0) obj;
            String e0 = m.e.e0(o0Var.a());
            if (e0 == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, e0);
            }
            String e02 = m.e.e0(o0Var.b());
            if (e02 == null) {
                fVar.b.bindNull(2);
            } else {
                fVar.b.bindString(2, e02);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(m0 m0Var, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM DownloadServerEntity";
        }
    }

    public m0(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
