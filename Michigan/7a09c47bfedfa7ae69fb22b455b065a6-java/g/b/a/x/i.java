package g.b.a.x;

import androidx.recyclerview.widget.RecyclerView;
import b.x.t;
import c.a.a.a.a;
import g.b.a.x.c;
import g.b.a.x.h;
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
    public static final CopyOnWriteArrayList<i> f6709a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentMap<String, i> f6710b = new ConcurrentHashMap(RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN, 0.75f, 2);

    static {
        if (!h.f6707a.getAndSet(true)) {
            h.f6708b.compareAndSet(null, new h.a());
            h.f6708b.get().a();
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public static f a(String str, boolean z) {
        f fVar;
        t.y2(str, "zoneId");
        i iVar = f6710b.get(str);
        if (iVar != null) {
            t.y2(str, "zoneId");
            c.a value = ((c) iVar).f6688d.lastEntry().getValue();
            int binarySearch = Arrays.binarySearch(value.f6690b, str);
            if (binarySearch < 0) {
                fVar = null;
            } else {
                try {
                    short s = value.f6691c[binarySearch];
                    Object obj = value.f6692d.get(s);
                    if (obj instanceof byte[]) {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
                        obj = a.b(dataInputStream.readByte(), dataInputStream);
                        value.f6692d.set(s, obj);
                    }
                    fVar = (f) obj;
                } catch (Exception e2) {
                    throw new g("Invalid binary time-zone data: TZDB:" + str + ", version: " + value.f6689a, e2);
                }
            }
            if (fVar != null) {
                return fVar;
            }
            throw new g(a.q("Unknown time-zone ID: ", str));
        } else if (f6710b.isEmpty()) {
            throw new g("No time-zone data files registered");
        } else {
            throw new g(a.q("Unknown time-zone ID: ", str));
        }
    }

    public static void b(i iVar) {
        t.y2(iVar, "provider");
        Iterator it = new HashSet(((c) iVar).f6687c).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            t.y2(str, "zoneId");
            if (f6710b.putIfAbsent(str, iVar) != null) {
                throw new g("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + iVar);
            }
        }
        f6709a.add(iVar);
    }
}
