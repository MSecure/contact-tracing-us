package e.v;

import e.x.a.d;
import e.x.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class i implements e, d {

    /* renamed from: j */
    public static final TreeMap<Integer, i> f2081j = new TreeMap<>();
    public volatile String b;
    public final long[] c;

    /* renamed from: d */
    public final double[] f2082d;

    /* renamed from: e */
    public final String[] f2083e;

    /* renamed from: f */
    public final byte[][] f2084f;

    /* renamed from: g */
    public final int[] f2085g;

    /* renamed from: h */
    public final int f2086h;

    /* renamed from: i */
    public int f2087i;

    public i(int i2) {
        this.f2086h = i2;
        int i3 = i2 + 1;
        this.f2085g = new int[i3];
        this.c = new long[i3];
        this.f2082d = new double[i3];
        this.f2083e = new String[i3];
        this.f2084f = new byte[i3];
    }

    public static i t(String str, int i2) {
        TreeMap<Integer, i> treeMap = f2081j;
        synchronized (treeMap) {
            Map.Entry<Integer, i> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                i value = ceilingEntry.getValue();
                value.b = str;
                value.f2087i = i2;
                return value;
            }
            i iVar = new i(i2);
            iVar.b = str;
            iVar.f2087i = i2;
            return iVar;
        }
    }

    public void J(int i2) {
        this.f2085g[i2] = 1;
    }

    public void L(int i2, String str) {
        this.f2085g[i2] = 4;
        this.f2083e[i2] = str;
    }

    public void Q() {
        TreeMap<Integer, i> treeMap = f2081j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f2086h), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                while (true) {
                    size--;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                }
            }
        }
    }

    @Override // e.x.a.e
    public String c() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // e.x.a.e
    public void d(d dVar) {
        for (int i2 = 1; i2 <= this.f2087i; i2++) {
            int i3 = this.f2085g[i2];
            if (i3 == 1) {
                ((e.x.a.f.e) dVar).b.bindNull(i2);
            } else if (i3 == 2) {
                ((e.x.a.f.e) dVar).b.bindLong(i2, this.c[i2]);
            } else if (i3 == 3) {
                ((e.x.a.f.e) dVar).b.bindDouble(i2, this.f2082d[i2]);
            } else if (i3 == 4) {
                ((e.x.a.f.e) dVar).b.bindString(i2, this.f2083e[i2]);
            } else if (i3 == 5) {
                ((e.x.a.f.e) dVar).b.bindBlob(i2, this.f2084f[i2]);
            }
        }
    }

    public void x(int i2, long j2) {
        this.f2085g[i2] = 2;
        this.c[i2] = j2;
    }
}
