package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.i;
import h.a.k;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public final class t {
    public static final i c = new i(String.valueOf(','));

    /* renamed from: d  reason: collision with root package name */
    public static final t f3986d = new t(k.b.a, false, new t(new k.a(), true, new t()));
    public final Map<String, a> a;
    public final byte[] b;

    public static final class a {
        public final s a;
        public final boolean b;

        public a(s sVar, boolean z) {
            b.A(sVar, "decompressor");
            this.a = sVar;
            this.b = z;
        }
    }

    public t() {
        this.a = new LinkedHashMap(0);
        this.b = new byte[0];
    }

    public t(s sVar, boolean z, t tVar) {
        String a2 = sVar.a();
        b.o(!a2.contains(","), "Comma is currently not allowed in message encoding");
        int size = tVar.a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(!tVar.a.containsKey(sVar.a()) ? size + 1 : size);
        for (a aVar : tVar.a.values()) {
            String a3 = aVar.a.a();
            if (!a3.equals(a2)) {
                linkedHashMap.put(a3, new a(aVar.a, aVar.b));
            }
        }
        linkedHashMap.put(a2, new a(sVar, z));
        Map<String, a> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.a = unmodifiableMap;
        i iVar = c;
        HashSet hashSet = new HashSet(unmodifiableMap.size());
        for (Map.Entry<String, a> entry : unmodifiableMap.entrySet()) {
            if (entry.getValue().b) {
                hashSet.add(entry.getKey());
            }
        }
        this.b = iVar.a(Collections.unmodifiableSet(hashSet)).getBytes(Charset.forName("US-ASCII"));
    }
}
