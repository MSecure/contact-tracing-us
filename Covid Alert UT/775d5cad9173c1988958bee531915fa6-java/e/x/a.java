package e.x;

import android.content.Context;
import android.os.Trace;
import e.b.a.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f2030d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f2031e = new Object();
    public final Map<Class<?>, Object> a = new HashMap();
    public final Set<Class<? extends b<?>>> b = new HashSet();
    public final Context c;

    public a(Context context) {
        this.c = context.getApplicationContext();
    }

    public static a b(Context context) {
        if (f2030d == null) {
            synchronized (f2031e) {
                if (f2030d == null) {
                    f2030d = new a(context);
                }
            }
        }
        return f2030d;
    }

    public <T> T a(Class<? extends b<?>> cls, Set<Class<?>> set) {
        T t;
        synchronized (f2031e) {
            if (m.e.M0()) {
                try {
                    Trace.beginSection(cls.getSimpleName());
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            if (!set.contains(cls)) {
                if (!this.a.containsKey(cls)) {
                    set.add(cls);
                    try {
                        b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        List<Class<? extends b<?>>> a2 = bVar.a();
                        if (!a2.isEmpty()) {
                            for (Class<? extends b<?>> cls2 : a2) {
                                if (!this.a.containsKey(cls2)) {
                                    a(cls2, set);
                                }
                            }
                        }
                        t = (T) bVar.b(this.c);
                        set.remove(cls);
                        this.a.put(cls, t);
                    } catch (Throwable th2) {
                        throw new c(th2);
                    }
                } else {
                    t = (T) this.a.get(cls);
                }
                Trace.endSection();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
            }
        }
        return t;
    }
}
