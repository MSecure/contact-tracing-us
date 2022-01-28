package c.a.b.x;

import android.os.SystemClock;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import c.a.b.b;
import c.a.b.h;
import c.a.b.o;
import c.a.b.w;
import gov.michigan.MiCovidExposure.BuildConfig;
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
    public final Map<String, a> f2868a = new LinkedHashMap(16, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public long f2869b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final File f2870c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2871d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f2872a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2873b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2874c;

        /* renamed from: d  reason: collision with root package name */
        public final long f2875d;

        /* renamed from: e  reason: collision with root package name */
        public final long f2876e;

        /* renamed from: f  reason: collision with root package name */
        public final long f2877f;

        /* renamed from: g  reason: collision with root package name */
        public final long f2878g;
        public final List<h> h;

        /* JADX WARNING: Illegal instructions before constructor call */
        public a(String str, b.a aVar) {
            this(str, r3, r4, r6, r8, r10, r12);
            ArrayList arrayList;
            String str2 = aVar.f2795b;
            long j = aVar.f2796c;
            long j2 = aVar.f2797d;
            long j3 = aVar.f2798e;
            long j4 = aVar.f2799f;
            List<h> list = aVar.h;
            if (list != null) {
                arrayList = list;
            } else {
                Map<String, String> map = aVar.f2800g;
                ArrayList arrayList2 = new ArrayList(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList2.add(new h(entry.getKey(), entry.getValue()));
                }
                arrayList = arrayList2;
            }
            this.f2872a = (long) aVar.f2794a.length;
        }

        public a(String str, String str2, long j, long j2, long j3, long j4, List<h> list) {
            this.f2873b = str;
            this.f2874c = "".equals(str2) ? null : str2;
            this.f2875d = j;
            this.f2876e = j2;
            this.f2877f = j3;
            this.f2878g = j4;
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
                throw new IOException(c.a.a.a.a.n("readHeaderList size=", i));
            }
            throw new IOException();
        }

        public b.a b(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f2794a = bArr;
            aVar.f2795b = this.f2874c;
            aVar.f2796c = this.f2875d;
            aVar.f2797d = this.f2876e;
            aVar.f2798e = this.f2877f;
            aVar.f2799f = this.f2878g;
            List<h> list = this.h;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (h hVar : list) {
                treeMap.put(hVar.f2820a, hVar.f2821b);
            }
            aVar.f2800g = treeMap;
            aVar.h = Collections.unmodifiableList(this.h);
            return aVar;
        }

        public boolean c(OutputStream outputStream) {
            try {
                d.n(outputStream, 538247942);
                d.p(outputStream, this.f2873b);
                d.p(outputStream, this.f2874c == null ? "" : this.f2874c);
                d.o(outputStream, this.f2875d);
                d.o(outputStream, this.f2876e);
                d.o(outputStream, this.f2877f);
                d.o(outputStream, this.f2878g);
                List<h> list = this.h;
                if (list != null) {
                    d.n(outputStream, list.size());
                    for (h hVar : list) {
                        d.p(outputStream, hVar.f2820a);
                        d.p(outputStream, hVar.f2821b);
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
        public final long f2879b;

        /* renamed from: c  reason: collision with root package name */
        public long f2880c;

        public b(InputStream inputStream, long j) {
            super(inputStream);
            this.f2879b = j;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f2880c++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f2880c += (long) read;
            }
            return read;
        }
    }

    public d(File file) {
        this.f2870c = file;
        this.f2871d = 5242880;
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
        long j2 = bVar.f2879b - bVar.f2880c;
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
        outputStream.write((i >> 0) & BuildConfig.VERSION_CODE);
        outputStream.write((i >> 8) & BuildConfig.VERSION_CODE);
        outputStream.write((i >> 16) & BuildConfig.VERSION_CODE);
        outputStream.write((i >> 24) & BuildConfig.VERSION_CODE);
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
        if (!this.f2870c.exists()) {
            if (!this.f2870c.mkdirs()) {
                w.a("Unable to create cache dir %s", this.f2870c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f2870c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    long length = file.length();
                    b bVar = new b(new BufferedInputStream(new FileInputStream(file)), length);
                    try {
                        a a2 = a.a(bVar);
                        a2.f2872a = length;
                        g(a2.f2873b, a2);
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
        f(aVar.f2794a.length);
        File d2 = d(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d2));
            a aVar2 = new a(str, aVar);
            if (aVar2.c(bufferedOutputStream)) {
                bufferedOutputStream.write(aVar.f2794a);
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
        a aVar = this.f2868a.get(str);
        if (aVar == null) {
            return null;
        }
        File d2 = d(str);
        try {
            b bVar = new b(new BufferedInputStream(new FileInputStream(d2)), d2.length());
            try {
                a a2 = a.a(bVar);
                if (!TextUtils.equals(str, a2.f2873b)) {
                    w.a("%s: key=%s, found=%s", d2.getAbsolutePath(), str, a2.f2873b);
                    a remove = this.f2868a.remove(str);
                    if (remove != null) {
                        this.f2869b -= remove.f2872a;
                    }
                    return null;
                }
                b.a b2 = aVar.b(m(bVar, bVar.f2879b - bVar.f2880c));
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
        return new File(this.f2870c, e(str));
    }

    public final String e(String str) {
        int length = str.length() / 2;
        StringBuilder h = c.a.a.a.a.h(String.valueOf(str.substring(0, length).hashCode()));
        h.append(String.valueOf(str.substring(length).hashCode()));
        return h.toString();
    }

    public final void f(int i) {
        long j;
        long j2 = (long) i;
        if (this.f2869b + j2 >= ((long) this.f2871d)) {
            if (w.f2852a) {
                w.b("Pruning old cache entries.", new Object[0]);
            }
            long j3 = this.f2869b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.f2868a.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (d(value.f2873b).delete()) {
                    j = j2;
                    this.f2869b -= value.f2872a;
                } else {
                    j = j2;
                    String str = value.f2873b;
                    w.a("Could not delete cache entry for key=%s, filename=%s", str, e(str));
                }
                it.remove();
                i2++;
                if (((float) (this.f2869b + j)) < ((float) this.f2871d) * 0.9f) {
                    break;
                }
                j2 = j;
            }
            if (w.f2852a) {
                w.b("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f2869b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    public final void g(String str, a aVar) {
        if (!this.f2868a.containsKey(str)) {
            this.f2869b += aVar.f2872a;
        } else {
            this.f2869b = (aVar.f2872a - this.f2868a.get(str).f2872a) + this.f2869b;
        }
        this.f2868a.put(str, aVar);
    }

    public synchronized void l(String str) {
        boolean delete = d(str).delete();
        a remove = this.f2868a.remove(str);
        if (remove != null) {
            this.f2869b -= remove.f2872a;
        }
        if (!delete) {
            w.a("Could not delete cache entry for key=%s, filename=%s", str, e(str));
        }
    }
}
