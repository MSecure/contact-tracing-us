package l.b.a.y;

import f.a.a.a.a;
import g.b.a.c.c.d;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import l.b.a.y.h;
/* loaded from: classes.dex */
public abstract class i {
    public static final CopyOnWriteArrayList<i> a = new CopyOnWriteArrayList<>();
    public static final ConcurrentMap<String, i> b = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        if (!h.a.getAndSet(true)) {
            AtomicReference<h> atomicReference = h.b;
            atomicReference.compareAndSet(null, new h.a());
            atomicReference.get().a();
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public static f a(String str, boolean z) {
        d.u(str, "zoneId");
        ConcurrentMap<String, i> concurrentMap = b;
        i iVar = concurrentMap.get(str);
        if (iVar != null) {
            return iVar.b(str, z);
        }
        if (concurrentMap.isEmpty()) {
            throw new g("No time-zone data files registered");
        }
        throw new g(a.x("Unknown time-zone ID: ", str));
    }

    public static void d(i iVar) {
        d.u(iVar, "provider");
        for (String str : iVar.c()) {
            d.u(str, "zoneId");
            if (b.putIfAbsent(str, iVar) != null) {
                throw new g("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + iVar);
            }
        }
        a.add(iVar);
    }

    public abstract f b(String str, boolean z);

    public abstract Set<String> c();
}
