package b.r;

import b.u.a.d;
import b.u.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class j implements e, d {
    public static final TreeMap<Integer, j> j = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    public volatile String f1652b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f1653c;

    /* renamed from: d  reason: collision with root package name */
    public final double[] f1654d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f1655e;
    public final byte[][] f;
    public final int[] g;
    public final int h;
    public int i;

    public j(int i2) {
        this.h = i2;
        int i3 = i2 + 1;
        this.g = new int[i3];
        this.f1653c = new long[i3];
        this.f1654d = new double[i3];
        this.f1655e = new String[i3];
        this.f = new byte[i3][];
    }

    public static j d(String str, int i2) {
        synchronized (j) {
            Map.Entry<Integer, j> ceilingEntry = j.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                j.remove(ceilingEntry.getKey());
                j value = ceilingEntry.getValue();
                value.f1652b = str;
                value.i = i2;
                return value;
            }
            j jVar = new j(i2);
            jVar.f1652b = str;
            jVar.i = i2;
            return jVar;
        }
    }

    @Override // b.u.a.e
    public String a() {
        return this.f1652b;
    }

    @Override // b.u.a.e
    public void b(d dVar) {
        for (int i2 = 1; i2 <= this.i; i2++) {
            int i3 = this.g[i2];
            if (i3 == 1) {
                ((b.u.a.g.e) dVar).f1754b.bindNull(i2);
            } else if (i3 == 2) {
                ((b.u.a.g.e) dVar).f1754b.bindLong(i2, this.f1653c[i2]);
            } else if (i3 == 3) {
                ((b.u.a.g.e) dVar).f1754b.bindDouble(i2, this.f1654d[i2]);
            } else if (i3 == 4) {
                ((b.u.a.g.e) dVar).f1754b.bindString(i2, this.f1655e[i2]);
            } else if (i3 == 5) {
                ((b.u.a.g.e) dVar).f1754b.bindBlob(i2, this.f[i2]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void e(int i2, long j2) {
        this.g[i2] = 2;
        this.f1653c[i2] = j2;
    }

    public void f(int i2) {
        this.g[i2] = 1;
    }

    public void g(int i2, String str) {
        this.g[i2] = 4;
        this.f1655e[i2] = str;
    }

    public void h() {
        synchronized (j) {
            j.put(Integer.valueOf(this.h), this);
            if (j.size() > 15) {
                int size = j.size() - 10;
                Iterator<Integer> it = j.descendingKeySet().iterator();
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
}
