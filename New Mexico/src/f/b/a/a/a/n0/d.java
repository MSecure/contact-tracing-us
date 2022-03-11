package f.b.a.a.a.n0;

import e.v.g;
import e.v.l;
import e.x.a.f.f;
/* loaded from: classes.dex */
public final class d extends c {
    public final g a;
    public final e.v.b<g> b;
    public final l c;

    /* renamed from: d */
    public final l f2333d;

    /* loaded from: classes.dex */
    public class a extends e.v.b<g> {
        public a(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR ABORT INTO `AnalyticsLoggingEntity` (`key`,`eventProto`) VALUES (nullif(?, 0),?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            g gVar = (g) obj;
            fVar.b.bindLong(1, gVar.b());
            if (gVar.a() == null) {
                fVar.b.bindNull(2);
                return;
            }
            fVar.b.bindString(2, gVar.a());
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM AnalyticsLoggingEntity";
        }
    }

    /* loaded from: classes.dex */
    public class c extends l {
        public c(d dVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM AnalyticsLoggingEntity WHERE key <= ?";
        }
    }

    public d(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2333d = new c(this, gVar);
    }
}
