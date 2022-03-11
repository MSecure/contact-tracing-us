package h.a.j1;

import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class x0<T> {
    public final HashSet<T> a = new HashSet<>();

    public abstract void a();

    public abstract void b();

    public final void c(T t, boolean z) {
        int size = this.a.size();
        if (z) {
            this.a.add(t);
            if (size == 0) {
                a();
            }
        } else if (this.a.remove(t) && size == 1) {
            b();
        }
    }
}
