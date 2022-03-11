package f.b.b.a;

import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class l<T> implements Serializable {
    public static <T> l<T> c(T t) {
        Objects.requireNonNull(t);
        return new o(t);
    }

    public abstract T a();

    public abstract boolean b();

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    @Override // java.lang.Object
    public abstract int hashCode();
}
