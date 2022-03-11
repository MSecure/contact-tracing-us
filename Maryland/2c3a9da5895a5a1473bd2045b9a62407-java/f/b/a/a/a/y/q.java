package f.b.a.a.a.y;

import e.t.g;
import e.t.l;
import e.v.a.f.f;

public final class q extends p {
    public final g a;
    public final e.t.b<r> b;
    public final l c;

    public class a extends e.t.b<r> {
        public a(q qVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `CountryEntity` (`countryCode`,`lastSeenTimestampMillis`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, r rVar) {
            r rVar2 = rVar;
            if (rVar2.a() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, rVar2.a());
            }
            fVar.b.bindLong(2, rVar2.b());
        }
    }

    public class b extends l {
        public b(q qVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM CountryEntity WHERE lastSeenTimestampMillis < ?";
        }
    }

    public q(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
