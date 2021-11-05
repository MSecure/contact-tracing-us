package e.c.a.x;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.x.c;
import e.c.a.x.h;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final CopyOnWriteArrayList<i> f5220a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentMap<String, i> f5221b = new ConcurrentHashMap(RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN, 0.75f, 2);

    static {
        if (!h.f5218a.getAndSet(true)) {
            h.f5219b.compareAndSet(null, new h.a());
            h.f5219b.get().a();
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public static f a(String str, boolean z) {
        f fVar;
        c.T1(str, "zoneId");
        i iVar = f5221b.get(str);
        if (iVar != null) {
            c.T1(str, "zoneId");
            c.a value = ((c) iVar).f5201d.lastEntry().getValue();
            int binarySearch = Arrays.binarySearch(value.f5203b, str);
            if (binarySearch < 0) {
                fVar = null;
            } else {
                try {
                    short s = value.f5204c[binarySearch];
                    Object obj = value.f5205d.get(s);
                    if (obj instanceof byte[]) {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
                        obj = a.b(dataInputStream.readByte(), dataInputStream);
                        value.f5205d.set(s, obj);
                    }
                    fVar = (f) obj;
                } catch (Exception e2) {
                    throw new g("Invalid binary time-zone data: TZDB:" + str + ", version: " + value.f5202a, e2);
                }
            }
            if (fVar != null) {
                return fVar;
            }
            throw new g(a.o("Unknown time-zone ID: ", str));
        } else if (f5221b.isEmpty()) {
            throw new g("No time-zone data files registered");
        } else {
            throw new g(a.o("Unknown time-zone ID: ", str));
        }
    }

    public static void b(i iVar) {
        c.b.a.a.c.n.c.T1(iVar, "provider");
        Iterator it = new HashSet(((c) iVar).f5200c).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            c.b.a.a.c.n.c.T1(str, "zoneId");
            if (f5221b.putIfAbsent(str, iVar) != null) {
                throw new g("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + iVar);
            }
        }
        f5220a.add(iVar);
    }
}
