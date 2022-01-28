package c.b.a.a.g.h;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class e extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f3865a;

    public e(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f3865a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == e.class) {
            if (this == obj) {
                return true;
            }
            e eVar = (e) obj;
            return this.f3865a == eVar.f3865a && get() == eVar.get();
        }
    }

    public final int hashCode() {
        return this.f3865a;
    }
}
