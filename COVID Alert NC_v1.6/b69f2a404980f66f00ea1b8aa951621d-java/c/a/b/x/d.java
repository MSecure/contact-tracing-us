package c.a.b.x;

import android.os.SystemClock;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import c.a.b.b;
import c.a.b.h;
import c.a.b.o;
import c.a.b.w;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class d implements c.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f2255a = new LinkedHashMap(16, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public long f2256b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final File f2257c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2258d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f2259a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2260b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2261c;

        /* renamed from: d  reason: collision with root package name */
        public final long f2262d;

        /* renamed from: e  reason: collision with root package name */
        public final long f2263e;
        public final long f;
        public final long g;
        public final List<h> h;

        /* JADX WARNING: Illegal instructions before constructor call */
        public a(String str, b.a aVar) {
            this(str, r3, r4, r6, r8, r10, r12);
            ArrayList arrayList;
            String str2 = aVar.f2190b;
            long j = aVar.f2191c;
            long j2 = aVar.f2192d;
            long j3 = aVar.f2193e;
            long j4 = aVar.f;
            List<h> list = aVar.h;
            if (list != null) {
                arrayList = list;
            } else {
                Map<String, String> map = aVar.g;
                ArrayList arrayList2 = new ArrayList(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList2.add(new h(entry.getKey(), entry.getValue()));
                }
                arrayList = arrayList2;
            }
            this.f2259a = (long) aVar.f2189a.length;
        }

        public a(String str, String str2, long j, long j2, long j3, long j4, List<h> list) {
            this.f2260b = str;
            this.f2261c = "".equals(str2) ? null : str2;
            this.f2262d = j;
            this.f2263e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        public static a a(b bVar) {
            if (d.i(bVar) == 538247942) {
                String k = d.k(bVar);
                String k2 = d.k(bVar);
                long j = d.j(bVar);
                long j2 = d.j(bVar);
                long j3 = d.j(bVar);
                long j4 = d.j(bVar);
                int i = d.i(bVar);
                if (i >= 0) {
                    List emptyList = i == 0 ? Collections.emptyList() : new ArrayList();
                    for (int i2 = 0; i2 < i; i2++) {
                        emptyList.add(new h(d.k(bVar).intern(), d.k(bVar).intern()));
                    }
                    return new a(k, k2, j, j2, j3, j4, emptyList);
                }
                throw new IOException(c.a.a.a.a.l("readHeaderList size=", i));
            }
            throw new IOException();
        }

        public b.a b(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f2189a = bArr;
            aVar.f2190b = this.f2261c;
            aVar.f2191c = this.f2262d;
            aVar.f2192d = this.f2263e;
            aVar.f2193e = this.f;
            aVar.f = this.g;
            List<h> list = this.h;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (h hVar : list) {
                treeMap.put(hVar.f2211a, hVar.f2212b);
            }
            aVar.g = treeMap;
            aVar.h = Collections.unmodifiableList(this.h);
            return aVar;
        }

        public boolean c(OutputStream outputStream) {
            try {
                d.n(outputStream, 538247942);
                d.p(outputStream, this.f2260b);
                d.p(outputStream, this.f2261c == null ? "" : this.f2261c);
                d.o(outputStream, this.f2262d);
                d.o(outputStream, this.f2263e);
                d.o(outputStream, this.f);
                d.o(outputStream, this.g);
                List<h> list = this.h;
                if (list != null) {
                    d.n(outputStream, list.size());
                    for (h hVar : list) {
                        d.p(outputStream, hVar.f2211a);
                        d.p(outputStream, hVar.f2212b);
                    }
                } else {
                    d.n(outputStream, 0);
                }
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                w.a("%s", e2.toString());
                return false;
            }
        }
    }

    @VisibleForTesting
    public static class b extends FilterInputStream {

        /* renamed from: b  reason: collision with root package name */
        public final long f2264b;

        /* renamed from: c  reason: collision with root package name */
        public long f2265c;

        public b(InputStream inputStream, long j) {
            super(inputStream);
            this.f2264b = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f2265c++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f2265c += (long) read;
            }
            return read;
        }
    }

    public d(File file) {
        this.f2257c = file;
        this.f2258d = 5242880;
    }

    public static int h(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static int i(InputStream inputStream) {
        return (h(inputStream) << 24) | (h(inputStream) << 0) | 0 | (h(inputStream) << 8) | (h(inputStream) << 16);
    }

    public static long j(InputStream inputStream) {
        return ((((long) h(inputStream)) & 255) << 0) | 0 | ((((long) h(inputStream)) & 255) << 8) | ((((long) h(inputStream)) & 255) << 16) | ((((long) h(inputStream)) & 255) << 24) | ((((long) h(inputStream)) & 255) << 32) | ((((long) h(inputStream)) & 255) << 40) | ((((long) h(inputStream)) & 255) << 48) | ((255 & ((long) h(inputStream))) << 56);
    }

    public static String k(b bVar) {
        return new String(m(bVar, j(bVar)), o.DEFAULT_PARAMS_ENCODING);
    }

    public static byte[] m(b bVar, long j) {
        long j2 = bVar.f2264b - bVar.f2265c;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    public static void n(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void o(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    public static void p(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes(o.DEFAULT_PARAMS_ENCODING);
        o(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // c.a.b.b
    public synchronized void a() {
        if (!this.f2257c.exists()) {
            if (!this.f2257c.mkdirs()) {
                w.a("Unable to create cache dir %s", this.f2257c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f2257c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    long length = file.length();
                    b bVar = new b(new BufferedInputStream(new FileInputStream(file)), length);
                    try {
                        a a2 = a.a(bVar);
                        a2.f2259a = length;
                        g(a2.f2260b, a2);
                    } finally {
                        bVar.close();
                    }
                } catch (IOException unused) {
                    file.delete();
                }
            }
        }
    }

    @Override // c.a.b.b
    public synchronized void b(String str, b.a aVar) {
        f(aVar.f2189a.length);
        File d2 = d(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d2));
            a aVar2 = new a(str, aVar);
            if (aVar2.c(bufferedOutputStream)) {
                bufferedOutputStream.write(aVar.f2189a);
                bufferedOutputStream.close();
                g(str, aVar2);
            } else {
                bufferedOutputStream.close();
                w.a("Failed to write header for %s", d2.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (!d2.delete()) {
                w.a("Could not clean up file %s", d2.getAbsolutePath());
            }
        }
    }

    @Override // c.a.b.b
    public synchronized b.a c(String str) {
        a aVar = this.f2255a.get(str);
        if (aVar == null) {
            return null;
        }
        File d2 = d(str);
        try {
            b bVar = new b(new BufferedInputStream(new FileInputStream(d2)), d2.length());
            try {
                a a2 = a.a(bVar);
                if (!TextUtils.equals(str, a2.f2260b)) {
                    w.a("%s: key=%s, found=%s", d2.getAbsolutePath(), str, a2.f2260b);
                    a remove = this.f2255a.remove(str);
                    if (remove != null) {
                        this.f2256b -= remove.f2259a;
                    }
                    return null;
                }
                b.a b2 = aVar.b(m(bVar, bVar.f2264b - bVar.f2265c));
                bVar.close();
                return b2;
            } finally {
                bVar.close();
            }
        } catch (IOException e2) {
            w.a("%s: %s", d2.getAbsolutePath(), e2.toString());
            l(str);
            return null;
        }
    }

    public File d(String str) {
        return new File(this.f2257c, e(str));
    }

    public final String e(String str) {
        int length = str.length() / 2;
        StringBuilder g = c.a.a.a.a.g(String.valueOf(str.substring(0, length).hashCode()));
        g.append(String.valueOf(str.substring(length).hashCode()));
        return g.toString();
    }

    public final void f(int i) {
        long j;
        long j2 = (long) i;
        if (this.f2256b + j2 >= ((long) this.f2258d)) {
            if (w.f2239a) {
                w.b("Pruning old cache entries.", new Object[0]);
            }
            long j3 = this.f2256b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.f2255a.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (d(value.f2260b).delete()) {
                    j = j2;
                    this.f2256b -= value.f2259a;
                } else {
                    j = j2;
                    String str = value.f2260b;
                    w.a("Could not delete cache entry for key=%s, filename=%s", str, e(str));
                }
                it.remove();
                i2++;
                if (((float) (this.f2256b + j)) < ((float) this.f2258d) * 0.9f) {
                    break;
                }
                j2 = j;
            }
            if (w.f2239a) {
                w.b("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f2256b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    public final void g(String str, a aVar) {
        if (!this.f2255a.containsKey(str)) {
            this.f2256b += aVar.f2259a;
        } else {
            this.f2256b = (aVar.f2259a - this.f2255a.get(str).f2259a) + this.f2256b;
        }
        this.f2255a.put(str, aVar);
    }

    public synchronized void l(String str) {
        boolean delete = d(str).delete();
        a remove = this.f2255a.remove(str);
        if (remove != null) {
            this.f2256b -= remove.f2259a;
        }
        if (!delete) {
            w.a("Could not delete cache entry for key=%s, filename=%s", str, e(str));
        }
    }
}
