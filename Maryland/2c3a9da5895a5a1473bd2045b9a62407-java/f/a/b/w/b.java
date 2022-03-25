package f.a.b.w;

import android.os.SystemClock;
import f.a.b.b;
import f.a.b.g;
import f.a.b.h;
import f.a.b.k;
import f.a.b.n;
import f.a.b.r;
import f.a.b.s;
import f.a.b.u;
import f.a.b.v;
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

public class b implements h {
    public static final boolean c = v.a;
    public final a a;
    public final c b;

    public b(a aVar) {
        c cVar = new c(4096);
        this.a = aVar;
        this.b = cVar;
    }

    public static void a(String str, n<?> nVar, u uVar) {
        r rVar = nVar.m;
        int a2 = rVar.a();
        try {
            rVar.b(uVar);
            nVar.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(a2)));
        } catch (u e2) {
            nVar.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(a2)));
            throw e2;
        }
    }

    public static List<g> b(List<g> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (g gVar : list) {
                treeSet.add(gVar.a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<g> list2 = aVar.f2041g;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (g gVar2 : aVar.f2041g) {
                    if (!treeSet.contains(gVar2.a)) {
                        arrayList.add(gVar2);
                    }
                }
            }
        } else if (!aVar.f2040f.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.f2040f.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new g(entry.getKey(), entry.getValue()));
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
        String str = aVar.b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j2 = aVar.c;
        if (j2 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            hashMap.put("If-Modified-Since", simpleDateFormat.format(new Date(j2)));
        }
        return hashMap;
    }

    public final byte[] d(InputStream inputStream, int i2) {
        i iVar = new i(this.b, i2);
        try {
            byte[] a2 = this.b.a(1024);
            while (true) {
                int read = inputStream.read(a2);
                if (read == -1) {
                    break;
                }
                iVar.write(a2, 0, read);
            }
            byte[] byteArray = iVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                v.c("Error occurred when closing InputStream", new Object[0]);
            }
            this.b.b(a2);
            iVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                v.c("Error occurred when closing InputStream", new Object[0]);
            }
            this.b.b(null);
            iVar.close();
            throw th;
        }
    }

    public final void e(long j2, n<?> nVar, byte[] bArr, int i2) {
        if (c || j2 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = nVar;
            objArr[1] = Long.valueOf(j2);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(nVar.m.c());
            v.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r14 = null;
        r2 = r12;
        r18 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a1, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00af, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        r18 = r1;
        r14 = null;
        r2 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b6, code lost:
        r18 = r1;
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
        r0 = r2.a;
        f.a.b.v.b("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r29.f2053d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        if (r14 != null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        r1 = new f.a.b.k(r0, r14, false, android.os.SystemClock.elapsedRealtime() - r9, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e2, code lost:
        if (r0 == 401) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        if (r0 < 400) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        throw new f.a.b.d(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        if (r0 < 500) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0102, code lost:
        if (r29.f2061l != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0104, code lost:
        r0 = new f.a.b.s(r1);
        r1 = "server";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0111, code lost:
        throw new f.a.b.s(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0118, code lost:
        r0 = new f.a.b.a(r1);
        r1 = "auth";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0120, code lost:
        r0 = new f.a.b.j();
        r1 = "network";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012d, code lost:
        throw new f.a.b.l(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012f, code lost:
        r2 = f.a.a.a.a.h("Bad URL ");
        r2.append(r29.f2053d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0143, code lost:
        throw new java.lang.RuntimeException(r2.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0144, code lost:
        r0 = new f.a.b.t();
        r1 = "socket";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x012e A[ExcHandler: MalformedURLException (r0v2 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0128 A[SYNTHETIC] */
    public k f(n<?> nVar) {
        String str;
        u uVar;
        k kVar;
        d a2;
        byte[] d2;
        List list;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List emptyList = Collections.emptyList();
            d dVar = null;
            try {
                a2 = this.a.a(nVar, c(nVar.n));
                int i2 = a2.a;
                List unmodifiableList = Collections.unmodifiableList(a2.b);
                if (i2 == 304) {
                    b.a aVar = nVar.n;
                    if (aVar == null) {
                        return new k(304, null, true, SystemClock.elapsedRealtime() - elapsedRealtime, unmodifiableList);
                    }
                    return new k(304, aVar.a, true, SystemClock.elapsedRealtime() - elapsedRealtime, b(unmodifiableList, aVar));
                }
                InputStream inputStream = a2.f2075d;
                d2 = inputStream != null ? d(inputStream, a2.c) : new byte[0];
                e(SystemClock.elapsedRealtime() - elapsedRealtime, nVar, d2, i2);
                if (i2 >= 200 && i2 <= 299) {
                    list = unmodifiableList;
                    return new k(i2, d2, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                }
            } catch (SocketTimeoutException unused) {
            } catch (MalformedURLException e2) {
            } catch (IOException e3) {
                IOException e4 = e3;
                List list2 = list;
                dVar = a2;
                byte[] bArr = d2;
                if (dVar == null) {
                }
            }
            a(str, nVar, uVar);
        }
        throw new s(kVar);
    }
}
