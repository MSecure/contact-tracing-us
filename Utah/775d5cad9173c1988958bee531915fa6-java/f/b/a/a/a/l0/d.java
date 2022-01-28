package f.b.a.a.a.l0;

import e.u.g;
import e.u.l;
import e.w.a.f.f;

public final class d extends c {
    public final g a;
    public final e.u.b<g> b;
    public final l c;

    /* renamed from: d  reason: collision with root package name */
    public final l f2277d;

    public class a extends e.u.b<g> {
        public a(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "INSERT OR ABORT INTO `AnalyticsLoggingEntity` (`key`,`eventProto`) VALUES (nullif(?, 0),?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.w.a.f.f, java.lang.Object] */
        @Override // e.u.b
        public void d(f fVar, g gVar) {
            g gVar2 = gVar;
            fVar.b.bindLong(1, gVar2.b());
            if (gVar2.a() == null) {
                fVar.b.bindNull(2);
                return;
            }
            fVar.b.bindString(2, gVar2.a());
        }
    }

    public class b extends l {
        public b(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM AnalyticsLoggingEntity";
        }
    }

    public class c extends l {
        public c(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.u.l
        public String b() {
            return "DELETE FROM AnalyticsLoggingEntity WHERE key <= ?";
        }
    }

    public d(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2277d = new c(this, gVar);
    }
}
