package f.b.a.a.a.w;

import e.t.g;
import e.t.l;
import e.v.a.f.f;

public final class p extends o {
    public final g a;
    public final e.t.b<q> b;
    public final l c;

    public class a extends e.t.b<q> {
        public a(p pVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `CountryEntity` (`countryCode`,`lastSeenTimestampMillis`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, q qVar) {
            q qVar2 = qVar;
            if (qVar2.a() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, qVar2.a());
            }
            fVar.b.bindLong(2, qVar2.b());
        }
    }

    public class b extends l {
        public b(p pVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM CountryEntity WHERE lastSeenTimestampMillis < ?";
        }
    }

    public p(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
