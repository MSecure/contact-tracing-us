package f.b.a.b.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import e.b.a.m;
import f.b.a.b.h.b.c;
import f.b.a.b.h.b.d;
import f.b.a.b.h.b.f;
import f.b.a.b.h.b.g;
import f.b.a.b.h.b.h;
import f.b.a.b.h.b.i;
import f.b.a.b.h.b.j;
import f.b.a.b.h.b.k;
import f.b.a.b.h.b.l;
import f.b.a.b.h.b.n;
import f.b.a.b.h.b.o;
import f.b.a.b.h.b.p;
import f.b.a.b.h.b.q;
import f.b.a.b.h.b.r;
import f.b.a.b.h.b.t;
import f.b.a.b.h.b.u;
import f.b.a.b.i.f;
import f.b.a.b.i.p.g;
import f.b.a.b.i.p.m;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class e implements m {
    public final f.b.c.i.a a;
    public final ConnectivityManager b;
    public final URL c = c(a.c);

    /* renamed from: d  reason: collision with root package name */
    public final f.b.a.b.i.u.a f2511d;

    /* renamed from: e  reason: collision with root package name */
    public final f.b.a.b.i.u.a f2512e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2513f;

    public static final class a {
        public final URL a;
        public final o b;
        public final String c;

        public a(URL url, o oVar, String str) {
            this.a = url;
            this.b = oVar;
            this.c = str;
        }
    }

    public static final class b {
        public final int a;
        public final URL b;
        public final long c;

        public b(int i2, URL url, long j2) {
            this.a = i2;
            this.b = url;
            this.c = j2;
        }
    }

    public e(Context context, f.b.a.b.i.u.a aVar, f.b.a.b.i.u.a aVar2) {
        f.b.c.i.h.e eVar = new f.b.c.i.h.e();
        c cVar = c.a;
        eVar.a.put(o.class, cVar);
        eVar.b.remove(o.class);
        eVar.a.put(i.class, cVar);
        eVar.b.remove(i.class);
        f fVar = f.a;
        eVar.a.put(r.class, fVar);
        eVar.b.remove(r.class);
        eVar.a.put(l.class, fVar);
        eVar.b.remove(l.class);
        d dVar = d.a;
        eVar.a.put(p.class, dVar);
        eVar.b.remove(p.class);
        eVar.a.put(j.class, dVar);
        eVar.b.remove(j.class);
        f.b.a.b.h.b.b bVar = f.b.a.b.h.b.b.a;
        eVar.a.put(f.b.a.b.h.b.a.class, bVar);
        eVar.b.remove(f.b.a.b.h.b.a.class);
        eVar.a.put(h.class, bVar);
        eVar.b.remove(h.class);
        f.b.a.b.h.b.e eVar2 = f.b.a.b.h.b.e.a;
        eVar.a.put(q.class, eVar2);
        eVar.b.remove(q.class);
        eVar.a.put(k.class, eVar2);
        eVar.b.remove(k.class);
        g gVar = g.a;
        eVar.a.put(t.class, gVar);
        eVar.b.remove(t.class);
        eVar.a.put(n.class, gVar);
        eVar.b.remove(n.class);
        eVar.f3174d = true;
        this.a = new f.b.c.i.h.d(eVar);
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f2511d = aVar2;
        this.f2512e = aVar;
        this.f2513f = 40000;
    }

    public static URL c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(f.a.a.a.a.c("Invalid url: ", str), e2);
        }
    }

    @Override // f.b.a.b.i.p.m
    public f.b.a.b.i.f a(f.b.a.b.i.f fVar) {
        int i2;
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        f.a i3 = fVar.i();
        i3.c().put("sdk-version", String.valueOf(Build.VERSION.SDK_INT));
        i3.c().put("model", Build.MODEL);
        i3.c().put("hardware", Build.HARDWARE);
        i3.c().put("device", Build.DEVICE);
        i3.c().put("product", Build.PRODUCT);
        i3.c().put("os-uild", Build.ID);
        i3.c().put("manufacturer", Build.MANUFACTURER);
        i3.c().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        i3.c().put("tz-offset", String.valueOf((long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000)));
        if (activeNetworkInfo == null) {
            t.b bVar = t.b.u;
            i2 = -1;
        } else {
            i2 = activeNetworkInfo.getType();
        }
        i3.c().put("net-type", String.valueOf(i2));
        int i4 = 0;
        if (activeNetworkInfo == null) {
            t.a aVar = t.a.c;
        } else {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                t.a aVar2 = t.a.w;
                i4 = 100;
            } else if (t.a.x.get(subtype) != null) {
                i4 = subtype;
            }
        }
        i3.c().put("mobile-subtype", String.valueOf(i4));
        return i3.b();
    }

    @Override // f.b.a.b.i.p.m
    public f.b.a.b.i.p.g b(f.b.a.b.i.p.f fVar) {
        String str;
        Integer num;
        String str2;
        k.a aVar;
        String str3;
        g.a aVar2 = g.a.TRANSIENT_ERROR;
        HashMap hashMap = new HashMap();
        f.b.a.b.i.p.a aVar3 = (f.b.a.b.i.p.a) fVar;
        for (f.b.a.b.i.f fVar2 : aVar3.a) {
            String g2 = fVar2.g();
            if (!hashMap.containsKey(g2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(fVar2);
                hashMap.put(g2, arrayList);
            } else {
                ((List) hashMap.get(g2)).add(fVar2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            String str4 = null;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                f.b.a.b.i.f fVar3 = (f.b.a.b.i.f) ((List) entry.getValue()).get(0);
                u uVar = u.b;
                Long valueOf = Long.valueOf(this.f2512e.a());
                Long valueOf2 = Long.valueOf(this.f2511d.a());
                j jVar = new j(p.a.c, new h(Integer.valueOf(fVar3.f("sdk-version")), fVar3.a("model"), fVar3.a("hardware"), fVar3.a("device"), fVar3.a("product"), fVar3.a("os-uild"), fVar3.a("manufacturer"), fVar3.a("fingerprint")));
                try {
                    str = null;
                    num = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                } catch (NumberFormatException unused) {
                    num = null;
                    str = (String) entry.getKey();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    f.b.a.b.i.f fVar4 = (f.b.a.b.i.f) it2.next();
                    f.b.a.b.i.e d2 = fVar4.d();
                    f.b.a.b.b bVar = d2.a;
                    if (bVar.equals(new f.b.a.b.b("proto"))) {
                        byte[] bArr = d2.b;
                        aVar = new k.a();
                        aVar.f2480d = bArr;
                    } else if (bVar.equals(new f.b.a.b.b("json"))) {
                        String str5 = new String(d2.b, Charset.forName("UTF-8"));
                        aVar = new k.a();
                        aVar.f2481e = str5;
                    } else {
                        m.h.s0("CctTransportBackend");
                        String.format("Received event of unsupported encoding %s. Skipping...", bVar);
                        it2 = it2;
                        it = it;
                    }
                    aVar.a = Long.valueOf(fVar4.e());
                    aVar.c = Long.valueOf(fVar4.h());
                    String str6 = fVar4.b().get("tz-offset");
                    aVar.f2482f = Long.valueOf(str6 == null ? 0 : Long.valueOf(str6).longValue());
                    aVar.f2483g = new n(t.b.v.get(fVar4.f("net-type")), t.a.x.get(fVar4.f("mobile-subtype")));
                    if (fVar4.c() != null) {
                        aVar.b = fVar4.c();
                    }
                    if (aVar.a == null) {
                        str3 = " eventTimeMs";
                    } else {
                        str3 = "";
                    }
                    if (aVar.c == null) {
                        str3 = f.a.a.a.a.c(str3, " eventUptimeMs");
                    }
                    if (aVar.f2482f == null) {
                        str3 = f.a.a.a.a.c(str3, " timezoneOffsetSeconds");
                    }
                    if (str3.isEmpty()) {
                        arrayList3.add(new k(aVar.a.longValue(), aVar.b, aVar.c.longValue(), aVar.f2480d, aVar.f2481e, aVar.f2482f.longValue(), aVar.f2483g));
                        it2 = it2;
                        it = it;
                    } else {
                        throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str3));
                    }
                }
                if (valueOf == null) {
                    str2 = " requestTimeMs";
                } else {
                    str2 = "";
                }
                if (valueOf2 == null) {
                    str2 = f.a.a.a.a.c(str2, " requestUptimeMs");
                }
                if (str2.isEmpty()) {
                    arrayList2.add(new l(valueOf.longValue(), valueOf2.longValue(), jVar, num, str, arrayList3, uVar));
                    it = it;
                } else {
                    throw new IllegalStateException(f.a.a.a.a.c("Missing required properties:", str2));
                }
            } else {
                i iVar = new i(arrayList2);
                URL url = this.c;
                if (aVar3.b != null) {
                    try {
                        a a2 = a.a(((f.b.a.b.i.p.a) fVar).b);
                        String str7 = a2.b;
                        if (str7 != null) {
                            str4 = str7;
                        }
                        String str8 = a2.a;
                        if (str8 != null) {
                            url = c(str8);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return f.b.a.b.i.p.g.a();
                    }
                }
                try {
                    b bVar2 = (b) m.h.c1(5, new a(url, iVar, str4), new c(this), d.a);
                    int i2 = bVar2.a;
                    if (i2 == 200) {
                        return new f.b.a.b.i.p.b(g.a.OK, bVar2.c);
                    }
                    if (i2 < 500) {
                        if (i2 != 404) {
                            return f.b.a.b.i.p.g.a();
                        }
                    }
                    return new f.b.a.b.i.p.b(aVar2, -1);
                } catch (IOException unused3) {
                    m.h.s0("CctTransportBackend");
                    return new f.b.a.b.i.p.b(aVar2, -1);
                }
            }
        }
    }
}
