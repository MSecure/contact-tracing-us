package e.v;

import e.x.a.f.f;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class l {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final g b;
    public volatile f c;

    public l(g gVar) {
        this.b = gVar;
    }

    public f a() {
        this.b.a();
        if (this.a.compareAndSet(false, true)) {
            if (this.c == null) {
                this.c = this.b.d(b());
            }
            return this.c;
        }
        return this.b.d(b());
    }

    public abstract String b();

    public void c(f fVar) {
        if (fVar == this.c) {
            this.a.set(false);
        }
    }
}
