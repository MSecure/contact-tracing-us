package e.y;

import android.content.Context;
import android.os.Trace;
import e.b.a.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f2115d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f2116e = new Object();
    public final Context c;
    public final Set<Class<? extends b<?>>> b = new HashSet();
    public final Map<Class<?>, Object> a = new HashMap();

    public a(Context context) {
        this.c = context.getApplicationContext();
    }

    public static a b(Context context) {
        if (f2115d == null) {
            synchronized (f2116e) {
                if (f2115d == null) {
                    f2115d = new a(context);
                }
            }
        }
        return f2115d;
    }

    public <T> T a(Class<? extends b<?>> cls, Set<Class<?>> set) {
        T t;
        synchronized (f2116e) {
            if (m.e.P0()) {
                Trace.beginSection(cls.getSimpleName());
            }
            if (!set.contains(cls)) {
                if (!this.a.containsKey(cls)) {
                    set.add(cls);
                    try {
                        b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        List<Class<? extends b<?>>> a = bVar.a();
                        if (!a.isEmpty()) {
                            for (Class<? extends b<?>> cls2 : a) {
                                if (!this.a.containsKey(cls2)) {
                                    a(cls2, set);
                                }
                            }
                        }
                        t = (T) bVar.b(this.c);
                        set.remove(cls);
                        this.a.put(cls, t);
                    } catch (Throwable th) {
                        throw new c(th);
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
