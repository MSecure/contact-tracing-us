package c.a.b.x;

import android.os.SystemClock;
import c.a.b.b;
import c.a.b.f;
import c.a.b.h;
import c.a.b.i;
import c.a.b.l;
import c.a.b.o;
import c.a.b.s;
import c.a.b.v;
import c.a.b.w;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

public class b implements i {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f2247c = w.f2239a;

    /* renamed from: a  reason: collision with root package name */
    public final a f2248a;

    /* renamed from: b  reason: collision with root package name */
    public final c f2249b;

    public b(a aVar) {
        c cVar = new c(4096);
        this.f2248a = aVar;
        this.f2249b = cVar;
    }

    public static void a(String str, o<?> oVar, v vVar) {
        s retryPolicy = oVar.getRetryPolicy();
        int timeoutMs = oVar.getTimeoutMs();
        try {
            f fVar = (f) retryPolicy;
            int i = fVar.f2203b + 1;
            fVar.f2203b = i;
            int i2 = fVar.f2202a;
            fVar.f2202a = i2 + ((int) (((float) i2) * fVar.f2205d));
            if (i <= fVar.f2204c) {
                oVar.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
                return;
            }
            throw vVar;
        } catch (v e2) {
            oVar.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e2;
        }
    }

    public static List<h> b(List<h> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (h hVar : list) {
                treeSet.add(hVar.f2211a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<h> list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (h hVar2 : aVar.h) {
                    if (!treeSet.contains(hVar2.f2211a)) {
                        arrayList.add(hVar2);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new h(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public final Map<String, String> c(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.f2190b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = aVar.f2192d;
        if (j > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            hashMap.put("If-Modified-Since", simpleDateFormat.format(new Date(j)));
        }
        return hashMap;
    }

    public final byte[] d(InputStream inputStream, int i) {
        j jVar = new j(this.f2249b, i);
        try {
            byte[] a2 = this.f2249b.a(1024);
            while (true) {
                int read = inputStream.read(a2);
                if (read == -1) {
                    break;
                }
                jVar.write(a2, 0, read);
            }
            byte[] byteArray = jVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                w.b("Error occurred when closing InputStream", new Object[0]);
            }
            this.f2249b.b(a2);
            jVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                w.b("Error occurred when closing InputStream", new Object[0]);
            }
            this.f2249b.b(null);
            jVar.close();
            throw th;
        }
    }

    public final void e(long j, o<?> oVar, byte[] bArr, int i) {
        if (f2247c || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = oVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(((f) oVar.getRetryPolicy()).f2203b);
            w.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        r14 = null;
        r2 = r12;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a9, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00aa, code lost:
        r18 = r1;
        r2 = r12;
        r14 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ba, code lost:
        r18 = r1;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        r0 = r2.f2266a;
        c.a.b.w.a("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r29.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d6, code lost:
        if (r14 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d8, code lost:
        r1 = new c.a.b.l(r0, r14, false, android.os.SystemClock.elapsedRealtime() - r9, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e8, code lost:
        if (r0 == 401) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f1, code lost:
        if (r0 < 400) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fd, code lost:
        throw new c.a.b.e(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0100, code lost:
        if (r0 < 500) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010a, code lost:
        if (r29.shouldRetryServerErrors() != false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010c, code lost:
        r0 = new c.a.b.t(r1);
        r1 = "server";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0119, code lost:
        throw new c.a.b.t(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x011f, code lost:
        throw new c.a.b.t(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
        r0 = new c.a.b.a(r1);
        r1 = "auth";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0128, code lost:
        r0 = new c.a.b.k();
        r1 = "network";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0135, code lost:
        throw new c.a.b.m(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0136, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0137, code lost:
        r2 = c.a.a.a.a.g("Bad URL ");
        r2.append(r29.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014d, code lost:
        throw new java.lang.RuntimeException(r2.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014e, code lost:
        r0 = new c.a.b.u();
        r1 = "socket";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136 A[ExcHandler: MalformedURLException (r0v2 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0130 A[SYNTHETIC] */
    public l f(o<?> oVar) {
        String str;
        v vVar;
        e a2;
        List unmodifiableList;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List emptyList = Collections.emptyList();
            e eVar = null;
            try {
                a2 = this.f2248a.a(oVar, c(oVar.getCacheEntry()));
                int i = a2.f2266a;
                unmodifiableList = Collections.unmodifiableList(a2.f2267b);
                if (i == 304) {
                    b.a cacheEntry = oVar.getCacheEntry();
                    if (cacheEntry == null) {
                        return new l(304, null, true, SystemClock.elapsedRealtime() - elapsedRealtime, unmodifiableList);
                    }
                    return new l(304, cacheEntry.f2189a, true, SystemClock.elapsedRealtime() - elapsedRealtime, b(unmodifiableList, cacheEntry));
                }
                InputStream inputStream = a2.f2269d;
                byte[] d2 = inputStream != null ? d(inputStream, a2.f2268c) : new byte[0];
                e(SystemClock.elapsedRealtime() - elapsedRealtime, oVar, d2, i);
                if (i >= 200 && i <= 299) {
                    List list = unmodifiableList;
                    return new l(i, d2, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                }
            } catch (SocketTimeoutException unused) {
            } catch (MalformedURLException e2) {
            } catch (IOException e3) {
                IOException e4 = e3;
                emptyList = unmodifiableList;
                List list2 = emptyList;
                byte[] bArr = null;
                eVar = a2;
                if (eVar == null) {
                }
            }
            a(str, oVar, vVar);
        }
        throw new IOException();
    }
}
