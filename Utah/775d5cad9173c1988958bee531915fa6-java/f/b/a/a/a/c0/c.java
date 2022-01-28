package f.b.a.a.a.c0;

import e.b.a.m;
import f.a.b.j;
import f.a.b.r;
import f.a.b.t;
import f.a.b.u;
import f.b.a.a.a.s.d0.a;
import f.b.b.a.l;
import java.util.HashMap;
import java.util.Map;
import l.b.a.d;
import l.b.a.e;
import l.b.a.v.f;

public class c implements r {

    /* renamed from: d  reason: collision with root package name */
    public static final a f2174d = a.e("CustomRetryPolicy");

    /* renamed from: e  reason: collision with root package name */
    public static final l.b.a.v.c f2175e = l.b.a.v.c.m;
    public final f.b.a.a.a.s.e0.a a;
    public d b = d.n(10);
    public int c = 0;

    public c(f.b.a.a.a.s.e0.a aVar) {
        this.a = aVar;
    }

    @Override // f.a.b.r
    public int a() {
        return (int) this.b.t();
    }

    @Override // f.a.b.r
    public void b(u uVar) {
        int i2;
        l lVar;
        a aVar = f2174d;
        aVar.a(uVar.getClass().getSimpleName() + " error, retrycount:[" + this.c + "]");
        int n0 = m.e.n0(uVar);
        if (n0 == 429 && (i2 = this.c) < 1) {
            this.c = i2 + 1;
            try {
                Map<String, String> map = uVar.b.c;
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    hashMap.put(entry.getKey().toLowerCase(), entry.getValue());
                }
                if (hashMap.containsKey("x-retry-after")) {
                    l.b.a.v.c h2 = f2175e.h(l.b.a.r.f4386g);
                    CharSequence charSequence = (CharSequence) hashMap.get("x-retry-after");
                    g.b.a.c.c.d.u(charSequence, "text");
                    try {
                        l.b.a.v.a d2 = h2.d(charSequence, null);
                        d2.x(h2.f4441d, h2.f4442e);
                        lVar = l.c(e.s(d2));
                        if (lVar.b() && ((e) lVar.a()).t(this.a.c())) {
                            this.b = d.c(this.a.c(), (l.b.a.x.d) lVar.a());
                        }
                        f2174d.a("Rate limited, will retry after delay.");
                    } catch (f e2) {
                        throw e2;
                    } catch (RuntimeException e3) {
                        throw h2.a(charSequence, e3);
                    }
                }
            } catch (Exception unused) {
            }
            lVar = f.b.b.a.a.b;
            this.b = d.c(this.a.c(), (l.b.a.x.d) lVar.a());
            f2174d.a("Rate limited, will retry after delay.");
        } else if (n0 >= 500 && this.c < 3) {
            StringBuilder h3 = f.a.a.a.a.h("Server error, retrycount:[");
            h3.append(this.c);
            h3.append("]. Will retry after delay.");
            aVar.a(h3.toString());
            this.c++;
        } else if (((uVar instanceof t) || (uVar instanceof j)) && this.c < 3) {
            StringBuilder h4 = f.a.a.a.a.h("Timeout or network error, retry count [");
            h4.append(this.c);
            h4.append("]. Will retry after delay.");
            aVar.a(h4.toString());
            this.c++;
        } else {
            aVar.a("Error not retryable, or retries exhausted. Fail now.");
            throw uVar;
        }
    }

    @Override // f.a.b.r
    public int c() {
        return this.c;
    }
}
