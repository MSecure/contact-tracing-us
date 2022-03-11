package f.b.a.a.a.y;

import e.t.g;
import e.t.l;
import e.v.a.f.f;

public final class d extends c {
    public final g a;
    public final e.t.b<f> b;
    public final l c;

    public class a extends e.t.b<f> {
        public a(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR ABORT INTO `AnalyticsLoggingEntity` (`key`,`eventProto`) VALUES (nullif(?, 0),?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, f fVar2) {
            f fVar3 = fVar2;
            fVar.b.bindLong(1, fVar3.b());
            if (fVar3.a() == null) {
                fVar.b.bindNull(2);
                return;
            }
            fVar.b.bindString(2, fVar3.a());
        }
    }

    public class b extends l {
        public b(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM AnalyticsLoggingEntity";
        }
    }

    public d(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
