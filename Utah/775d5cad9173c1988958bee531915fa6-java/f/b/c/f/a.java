package f.b.c.f;

import java.util.Set;

public abstract class a implements e {
    @Override // f.b.c.f.e
    public <T> T a(Class<T> cls) {
        f.b.c.m.a<T> b = b(cls);
        if (b == null) {
            return null;
        }
        return b.get();
    }

    @Override // f.b.c.f.e
    public <T> Set<T> c(Class<T> cls) {
        return d(cls).get();
    }
}
