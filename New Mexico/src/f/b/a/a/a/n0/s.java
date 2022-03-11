package f.b.a.a.a.n0;

import e.v.g;
import e.v.l;
import e.x.a.f.f;
/* loaded from: classes.dex */
public final class s extends r {
    public final g a;
    public final e.v.b<u> b;
    public final l c;

    /* renamed from: d */
    public final l f2372d;

    /* loaded from: classes.dex */
    public class a extends e.v.b<u> {
        public a(s sVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "INSERT OR REPLACE INTO `CountryEntity` (`countryCode`,`lastSeenTimestampMillis`) VALUES (?,?)";
        }

        @Override // e.v.b
        public void d(f fVar, Object obj) {
            u uVar = (u) obj;
            if (uVar.a() == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, uVar.a());
            }
            fVar.b.bindLong(2, uVar.b());
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {
        public b(s sVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM CountryEntity WHERE lastSeenTimestampMillis < ?";
        }
    }

    /* loaded from: classes.dex */
    public class c extends l {
        public c(s sVar, g gVar) {
            super(gVar);
        }

        @Override // e.v.l
        public String b() {
            return "DELETE FROM CountryEntity";
        }
    }

    public s(g gVar) {
        this.a = gVar;
        this.b = new a(this, gVar);
        this.c = new b(this, gVar);
        this.f2372d = new c(this, gVar);
    }
}
