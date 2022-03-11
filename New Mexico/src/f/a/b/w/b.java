package f.a.b.w;

import android.os.SystemClock;
import f.a.b.a;
import f.a.b.b;
import f.a.b.d;
import f.a.b.g;
import f.a.b.h;
import f.a.b.j;
import f.a.b.k;
import f.a.b.l;
import f.a.b.n;
import f.a.b.r;
import f.a.b.s;
import f.a.b.t;
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
/* loaded from: classes.dex */
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
        int a = rVar.a();
        try {
            rVar.b(uVar);
            nVar.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(a)));
        } catch (u e2) {
            nVar.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(a)));
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
        List<g> list2 = aVar.f2153g;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (g gVar2 : aVar.f2153g) {
                    if (!treeSet.contains(gVar2.a)) {
                        arrayList.add(gVar2);
                    }
                }
            }
        } else if (!aVar.f2152f.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.f2152f.entrySet()) {
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
        byte[] bArr = null;
        try {
            bArr = this.b.a(1024);
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                iVar.write(bArr, 0, read);
            }
            byte[] byteArray = iVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                v.b("Error occurred when closing InputStream", new Object[0]);
            }
            this.b.b(bArr);
            iVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                v.b("Error occurred when closing InputStream", new Object[0]);
            }
            this.b.b(bArr);
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public k f(n<?> nVar) {
        String str;
        u uVar;
        List list;
        byte[] bArr;
        IOException e2;
        k kVar;
        b bVar;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List emptyList = Collections.emptyList();
            d dVar = null;
            try {
                try {
                    d a = this.a.a(nVar, c(nVar.n));
                    try {
                        int i2 = a.a;
                        List unmodifiableList = Collections.unmodifiableList(a.b);
                        try {
                            if (i2 == 304) {
                                b.a aVar = nVar.n;
                                return aVar == null ? new k(304, null, true, SystemClock.elapsedRealtime() - elapsedRealtime, unmodifiableList) : new k(304, aVar.a, true, SystemClock.elapsedRealtime() - elapsedRealtime, b(unmodifiableList, aVar));
                            }
                            try {
                                InputStream inputStream = a.f2187d;
                                byte[] d2 = inputStream != null ? d(inputStream, a.c) : new byte[0];
                                try {
                                    bVar = this;
                                    bVar.e(SystemClock.elapsedRealtime() - elapsedRealtime, nVar, d2, i2);
                                } catch (IOException e3) {
                                    e2 = e3;
                                    bVar = unmodifiableList;
                                }
                                try {
                                    if (i2 < 200 || i2 > 299) {
                                        break;
                                    }
                                    return new k(i2, d2, false, SystemClock.elapsedRealtime() - elapsedRealtime, unmodifiableList);
                                } catch (IOException e4) {
                                    e2 = e4;
                                    list = bVar;
                                    dVar = a;
                                    bArr = d2;
                                    if (dVar == null) {
                                        int i3 = dVar.a;
                                        v.a("Unexpected response code %d for %s", Integer.valueOf(i3), nVar.f2165d);
                                        if (bArr != null) {
                                            kVar = new k(i3, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                                            if (i3 == 401 || i3 == 403) {
                                                uVar = new a(kVar);
                                                str = "auth";
                                            } else if (i3 >= 400 && i3 <= 499) {
                                                throw new d(kVar);
                                            } else if (i3 < 500 || i3 > 599) {
                                                throw new s(kVar);
                                            } else if (nVar.f2173l) {
                                                uVar = new s(kVar);
                                                str = "server";
                                            } else {
                                                throw new s(kVar);
                                            }
                                        } else {
                                            uVar = new j();
                                            str = "network";
                                        }
                                        a(str, nVar, uVar);
                                    } else {
                                        throw new l(e2);
                                    }
                                }
                            } catch (IOException e5) {
                                e2 = e5;
                                emptyList = unmodifiableList;
                                list = emptyList;
                                bArr = null;
                                dVar = a;
                                if (dVar == null) {
                                }
                            }
                        } catch (IOException e6) {
                            e2 = e6;
                            bArr = null;
                            dVar = a;
                            list = unmodifiableList;
                        }
                    } catch (IOException e7) {
                        e2 = e7;
                    }
                } catch (IOException e8) {
                    e2 = e8;
                    list = emptyList;
                    bArr = null;
                }
            } catch (MalformedURLException e9) {
                StringBuilder h2 = f.a.a.a.a.h("Bad URL ");
                h2.append(nVar.f2165d);
                throw new RuntimeException(h2.toString(), e9);
            } catch (SocketTimeoutException unused) {
                uVar = new t();
                str = "socket";
            }
            a(str, nVar, uVar);
        }
        throw new s(kVar);
    }
}
