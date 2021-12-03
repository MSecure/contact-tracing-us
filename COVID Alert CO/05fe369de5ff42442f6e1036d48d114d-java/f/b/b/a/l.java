package f.b.b.a;

import java.io.Serializable;
import java.util.Objects;

public abstract class l<T> implements Serializable {
    public static <T> l<T> c(T t) {
        Objects.requireNonNull(t);
        return new o(t);
    }

    public abstract T a();

    public abstract boolean b();

    public abstract boolean equals(Object obj);

    public abstract int hashCode();
}
