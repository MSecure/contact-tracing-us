package h.a;

import f.b.a.c.b.o.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class j0 {
    public static final Logger c = Logger.getLogger(j0.class.getName());

    /* renamed from: d  reason: collision with root package name */
    public static j0 f4114d;

    /* renamed from: e  reason: collision with root package name */
    public static final Iterable<Class<?>> f4115e;
    public final LinkedHashSet<i0> a = new LinkedHashSet<>();
    public final LinkedHashMap<String, i0> b = new LinkedHashMap<>();

    /* loaded from: classes.dex */
    public static final class a implements b1<i0> {
        @Override // h.a.b1
        public int a(i0 i0Var) {
            return i0Var.c();
        }

        @Override // h.a.b1
        public boolean b(i0 i0Var) {
            return i0Var.d();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("h.a.j1.g2"));
        } catch (ClassNotFoundException e2) {
            c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e2);
        }
        try {
            arrayList.add(Class.forName("h.a.n1.b"));
        } catch (ClassNotFoundException e3) {
            c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e3);
        }
        f4115e = Collections.unmodifiableList(arrayList);
    }

    public synchronized i0 a(String str) {
        LinkedHashMap<String, i0> linkedHashMap;
        linkedHashMap = this.b;
        b.A(str, "policy");
        return linkedHashMap.get(str);
    }

    public final synchronized void b() {
        this.b.clear();
        Iterator<i0> it = this.a.iterator();
        while (it.hasNext()) {
            i0 next = it.next();
            String b = next.b();
            i0 i0Var = this.b.get(b);
            if (i0Var == null || i0Var.c() < next.c()) {
                this.b.put(b, next);
            }
        }
    }
}
