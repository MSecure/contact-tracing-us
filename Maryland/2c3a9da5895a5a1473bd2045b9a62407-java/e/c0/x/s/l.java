package e.c0.x.s;

import e.t.b;
import e.t.g;
import e.v.a.f.f;

public final class l implements k {
    public final g a;
    public final b<j> b;

    public class a extends b<j> {
        public a(l lVar, g gVar) {
            super(gVar);
        }

        @Override // e.t.l
        public String b() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.v.a.f.f, java.lang.Object] */
        @Override // e.t.b
        public void d(f fVar, j jVar) {
            j jVar2 = jVar;
            String str = jVar2.a;
            if (str == null) {
                fVar.b.bindNull(1);
            } else {
                fVar.b.bindString(1, str);
            }
            String str2 = jVar2.b;
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
