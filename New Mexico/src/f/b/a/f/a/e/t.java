package f.b.a.f.a.e;

import java.util.Objects;
/* loaded from: classes.dex */
public final class t<T> implements u, r {
    public static final Object c = new Object();
    public volatile u<T> a;
    public volatile Object b = c;

    public t(u<T> uVar) {
        this.a = uVar;
    }

    public static <P extends u<T>, T> r<T> b(P p) {
        if (p instanceof r) {
            return (r) p;
        }
        Objects.requireNonNull(p);
        return new t(p);
    }

    @Override // f.b.a.f.a.e.u
    public final T a() {
        T t = (T) this.b;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.b;
                if (t == obj) {
                    t = this.a.a();
                    Object obj2 = this.b;
                    if (!(obj2 == obj || obj2 == t)) {
                        String valueOf = String.valueOf(obj2);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.b = t;
                    this.a = null;
                }
            }
        }
        return t;
    }
}
