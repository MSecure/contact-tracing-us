package b.s;

import b.w.a.d;
import b.w.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class j implements e, d {
    public static final TreeMap<Integer, j> j = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    public volatile String f2516b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f2517c;

    /* renamed from: d  reason: collision with root package name */
    public final double[] f2518d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f2519e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[][] f2520f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f2521g;
    public final int h;
    public int i;

    public j(int i2) {
        this.h = i2;
        int i3 = i2 + 1;
        this.f2521g = new int[i3];
        this.f2517c = new long[i3];
        this.f2518d = new double[i3];
        this.f2519e = new String[i3];
        this.f2520f = new byte[i3][];
    }

    public static j c(String str, int i2) {
        synchronized (j) {
            Map.Entry<Integer, j> ceilingEntry = j.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                j.remove(ceilingEntry.getKey());
                j value = ceilingEntry.getValue();
                value.f2516b = str;
                value.i = i2;
                return value;
            }
            j jVar = new j(i2);
            jVar.f2516b = str;
            jVar.i = i2;
            return jVar;
        }
    }

    @Override // b.w.a.e
    public String a() {
        return this.f2516b;
    }

    @Override // b.w.a.e
    public void b(d dVar) {
        for (int i2 = 1; i2 <= this.i; i2++) {
            int i3 = this.f2521g[i2];
            if (i3 == 1) {
                ((b.w.a.g.e) dVar).f2630b.bindNull(i2);
            } else if (i3 == 2) {
                ((b.w.a.g.e) dVar).f2630b.bindLong(i2, this.f2517c[i2]);
            } else if (i3 == 3) {
                ((b.w.a.g.e) dVar).f2630b.bindDouble(i2, this.f2518d[i2]);
            } else if (i3 == 4) {
                ((b.w.a.g.e) dVar).f2630b.bindString(i2, this.f2519e[i2]);
            } else if (i3 == 5) {
                ((b.w.a.g.e) dVar).f2630b.bindBlob(i2, this.f2520f[i2]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void d(int i2, long j2) {
        this.f2521g[i2] = 2;
        this.f2517c[i2] = j2;
    }

    public void e(int i2) {
        this.f2521g[i2] = 1;
    }

    public void f(int i2, String str) {
        this.f2521g[i2] = 4;
        this.f2519e[i2] = str;
    }

    public void g() {
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
