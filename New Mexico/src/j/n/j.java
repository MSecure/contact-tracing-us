package j.n;

import j.k.a.b;
import j.k.b.e;
import j.k.b.f;
import j.l.c;
/* loaded from: classes.dex */
public final class j extends f implements b<c, String> {
    public final /* synthetic */ CharSequence c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(CharSequence charSequence) {
        super(1);
        this.c = charSequence;
    }

    @Override // j.k.a.b
    public String d(c cVar) {
        c cVar2 = cVar;
        e.c(cVar2, "it");
        return h.p(this.c, cVar2);
    }
}
