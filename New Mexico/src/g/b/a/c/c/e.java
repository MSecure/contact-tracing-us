package g.b.a.c.c;

import f.b.a.a.a.r;
import g.b.b.b;
/* loaded from: classes.dex */
public final class e implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final f f4068d;

    public e(f fVar) {
        this.f4068d = fVar;
    }

    @Override // g.b.b.b
    public Object e() {
        if (this.b == null) {
            synchronized (this.c) {
                if (this.b == null) {
                    this.b = ((r.a) this.f4068d).a();
                }
            }
        }
        return this.b;
    }
}
