package b.z.y.r;

import b.r.b;
import b.r.h;
import b.u.a.f;
import b.u.a.g.e;

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    public final h f2083a;

    /* renamed from: b  reason: collision with root package name */
    public final b<j> f2084b;

    public class a extends b<j> {
        public a(l lVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.u.a.f, java.lang.Object] */
        @Override // b.r.b
        public void bind(f fVar, j jVar) {
            j jVar2 = jVar;
            String str = jVar2.f2081a;
            if (str == null) {
                ((e) fVar).f1754b.bindNull(1);
            } else {
                ((e) fVar).f1754b.bindString(1, str);
            }
            String str2 = jVar2.f2082b;
            e eVar = (e) fVar;
            if (str2 == null) {
                eVar.f1754b.bindNull(2);
            } else {
                eVar.f1754b.bindString(2, str2);
            }
        }

        @Override // b.r.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public l(h hVar) {
        this.f2083a = hVar;
        this.f2084b = new a(this, hVar);
    }
}
