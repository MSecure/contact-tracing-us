package f.b.b.a;

import f.b.b.a.h;
import f.b.b.a.r;
import java.util.Iterator;

public final class q implements r.b {
    public final /* synthetic */ f a;

    public q(f fVar) {
        this.a = fVar;
    }

    @Override // f.b.b.a.r.b
    public Iterator a(r rVar, CharSequence charSequence) {
        return new p(this, rVar, charSequence, new h.a(((h) this.a).b.matcher(charSequence)));
    }
}
