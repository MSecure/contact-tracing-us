package e.t;

import e.v.a.d;
import e.v.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class i implements e, d {

    /* renamed from: j  reason: collision with root package name */
    public static final TreeMap<Integer, i> f1905j = new TreeMap<>();
    public volatile String b;
    public final long[] c;

    /* renamed from: d  reason: collision with root package name */
    public final double[] f1906d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f1907e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[][] f1908f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f1909g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1910h;

    /* renamed from: i  reason: collision with root package name */
    public int f1911i;

    public i(int i2) {
        this.f1910h = i2;
        int i3 = i2 + 1;
        this.f1909g = new int[i3];
        this.c = new long[i3];
        this.f1906d = new double[i3];
        this.f1907e = new String[i3];
        this.f1908f = new byte[i3][];
    }

    public static i v(String str, int i2) {
        TreeMap<Integer, i> treeMap = f1905j;
        synchronized (treeMap) {
            Map.Entry<Integer, i> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                i value = ceilingEntry.getValue();
                value.b = str;
                value.f1911i = i2;
                return value;
            }
            i iVar = new i(i2);
            iVar.b = str;
            iVar.f1911i = i2;
            return iVar;
        }
    }

    public void A(int i2, long j2) {
        this.f1909g[i2] = 2;
        this.c[i2] = j2;
    }

    public void N(int i2) {
        this.f1909g[i2] = 1;
    }

    public void P(int i2, String str) {
        this.f1909g[i2] = 4;
        this.f1907e[i2] = str;
    }

    public void V() {
        TreeMap<Integer, i> treeMap = f1905j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f1910h), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i2;
                }
            }
        }
    }

    @Override // e.v.a.e
    public String c() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // e.v.a.e
    public void d(d dVar) {
        for (int i2 = 1; i2 <= this.f1911i; i2++) {
            int i3 = this.f1909g[i2];
            if (i3 == 1) {
                ((e.v.a.f.e) dVar).b.bindNull(i2);
            } else if (i3 == 2) {
                ((e.v.a.f.e) dVar).b.bindLong(i2, this.c[i2]);
            } else if (i3 == 3) {
                ((e.v.a.f.e) dVar).b.bindDouble(i2, this.f1906d[i2]);
            } else if (i3 == 4) {
                ((e.v.a.f.e) dVar).b.bindString(i2, this.f1907e[i2]);
            } else if (i3 == 5) {
                ((e.v.a.f.e) dVar).b.bindBlob(i2, this.f1908f[i2]);
            }
        }
    }
}
