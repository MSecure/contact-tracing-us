package b.b0.y.r;

import b.s.b;
import b.s.h;
import b.w.a.f;
import b.w.a.g.e;

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    public final h f1226a;

    /* renamed from: b  reason: collision with root package name */
    public final b<j> f1227b;

    public class a extends b<j> {
        public a(l lVar, h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [b.w.a.f, java.lang.Object] */
        @Override // b.s.b
        public void bind(f fVar, j jVar) {
            j jVar2 = jVar;
            String str = jVar2.f1224a;
            if (str == null) {
                ((e) fVar).f2630b.bindNull(1);
            } else {
                ((e) fVar).f2630b.bindString(1, str);
            }
            String str2 = jVar2.f1225b;
            e eVar = (e) fVar;
            if (str2 == null) {
                eVar.f2630b.bindNull(2);
            } else {
                eVar.f2630b.bindString(2, str2);
            }
        }

        @Override // b.s.m
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public l(h hVar) {
        this.f1226a = hVar;
        this.f1227b = new a(this, hVar);
    }
}
