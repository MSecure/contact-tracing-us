package e.u;

import e.w.a.d;
import e.w.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class i implements e, d {

    /* renamed from: j  reason: collision with root package name */
    public static final TreeMap<Integer, i> f1996j = new TreeMap<>();
    public volatile String b;
    public final long[] c;

    /* renamed from: d  reason: collision with root package name */
    public final double[] f1997d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f1998e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[][] f1999f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f2000g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2001h;

    /* renamed from: i  reason: collision with root package name */
    public int f2002i;

    public i(int i2) {
        this.f2001h = i2;
        int i3 = i2 + 1;
        this.f2000g = new int[i3];
        this.c = new long[i3];
        this.f1997d = new double[i3];
        this.f1998e = new String[i3];
        this.f1999f = new byte[i3][];
    }

    public static i t(String str, int i2) {
        TreeMap<Integer, i> treeMap = f1996j;
        synchronized (treeMap) {
            Map.Entry<Integer, i> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                i value = ceilingEntry.getValue();
                value.b = str;
                value.f2002i = i2;
                return value;
            }
            i iVar = new i(i2);
            iVar.b = str;
            iVar.f2002i = i2;
            return iVar;
        }
    }

    public void J(int i2) {
        this.f2000g[i2] = 1;
    }

    public void L(int i2, String str) {
        this.f2000g[i2] = 4;
        this.f1998e[i2] = str;
    }

    public void Q() {
        TreeMap<Integer, i> treeMap = f1996j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f2001h), this);
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

    @Override // e.w.a.e
    public String c() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // e.w.a.e
    public void d(d dVar) {
        for (int i2 = 1; i2 <= this.f2002i; i2++) {
            int i3 = this.f2000g[i2];
            if (i3 == 1) {
                ((e.w.a.f.e) dVar).b.bindNull(i2);
            } else if (i3 == 2) {
                ((e.w.a.f.e) dVar).b.bindLong(i2, this.c[i2]);
            } else if (i3 == 3) {
                ((e.w.a.f.e) dVar).b.bindDouble(i2, this.f1997d[i2]);
            } else if (i3 == 4) {
                ((e.w.a.f.e) dVar).b.bindString(i2, this.f1998e[i2]);
            } else if (i3 == 5) {
                ((e.w.a.f.e) dVar).b.bindBlob(i2, this.f1999f[i2]);
            }
        }
    }

    public void x(int i2, long j2) {
        this.f2000g[i2] = 2;
        this.c[i2] = j2;
    }
}
