package f.b.a.a.a.b0;

import e.t.g;
import e.t.l;
import e.v.a.f.f;

public final class s extends r {
    public final g a;
    public final e.t.b<t> b;
    public final l c;

    public class a extends e.t.b<t> {
        public a(s sVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR REPLACE INTO `CountryEntity` (`countryCode`,`lastSeenTimestampMillis`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, t tVar) {
            t tVar2 = tVar;
            if (tVar2.a() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, tVar2.a());
            }
            fVar.b.bindLong(2, tVar2.b());
        }
    }

    public class b extends l {
        public b(s sVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "DELETE FROM CountryEntity WHERE lastSeenTimestampMillis < ?";
        }
    }

    public s(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
    }
}
