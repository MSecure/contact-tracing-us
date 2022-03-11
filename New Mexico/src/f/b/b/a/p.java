package f.b.b.a;

import f.b.b.a.h;
import f.b.b.a.r;
/* loaded from: classes.dex */
public class p extends r.a {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e f3377i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, r rVar, CharSequence charSequence, e eVar) {
        super(rVar, charSequence);
        this.f3377i = eVar;
    }

    @Override // f.b.b.a.r.a
    public int b(int i2) {
        return ((h.a) this.f3377i).a.end();
    }

    @Override // f.b.b.a.r.a
    public int c(int i2) {
        if (((h.a) this.f3377i).a.find(i2)) {
            return ((h.a) this.f3377i).a.start();
        }
        return -1;
    }
}
