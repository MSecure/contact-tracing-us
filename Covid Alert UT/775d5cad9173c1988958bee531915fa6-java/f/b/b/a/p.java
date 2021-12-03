package f.b.b.a;

import f.b.b.a.h;
import f.b.b.a.r;

public class p extends r.a {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e f3122i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(q qVar, r rVar, CharSequence charSequence, e eVar) {
        super(rVar, charSequence);
        this.f3122i = eVar;
    }

    @Override // f.b.b.a.r.a
    public int b(int i2) {
        return ((h.a) this.f3122i).a.end();
    }

    @Override // f.b.b.a.r.a
    public int c(int i2) {
        if (((h.a) this.f3122i).a.find(i2)) {
            return ((h.a) this.f3122i).a.start();
        }
        return -1;
    }
}
