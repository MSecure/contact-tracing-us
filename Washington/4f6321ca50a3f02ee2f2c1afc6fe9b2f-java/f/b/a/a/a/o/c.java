package f.b.a.a.a.o;

import e.b.a.m;
import f.a.b.j;
import f.a.b.r;
import f.a.b.t;
import f.a.b.u;
import f.b.a.a.a.h.s.a;
import f.b.a.c.b.o.b;
import f.b.b.a.l;
import java.util.HashMap;
import java.util.Map;
import l.b.a.d;
import l.b.a.q;
import l.b.a.u.f;

public class c implements r {

    /* renamed from: d  reason: collision with root package name */
    public static final l.b.a.u.c f2161d = l.b.a.u.c.m;
    public final a a;
    public l.b.a.c b = l.b.a.c.l(3);
    public int c = 0;

    public c(a aVar) {
        this.a = aVar;
    }

    @Override // f.a.b.r
    public int a() {
        return (int) this.b.q();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // f.a.b.r
    public void b(u uVar) {
        int i2;
        int i3;
        l lVar;
        uVar.getClass().getSimpleName();
        int h0 = m.h.h0(uVar);
        boolean z = true;
        if (h0 == 429 && (i3 = this.c) < 1) {
            this.c = i3 + 1;
            try {
                Map<String, String> map = uVar.b.c;
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    hashMap.put(entry.getKey().toLowerCase(), entry.getValue());
                }
                if (hashMap.containsKey("x-retry-after")) {
                    l.b.a.u.c h2 = f2161d.h(q.f4070g);
                    CharSequence charSequence = (CharSequence) hashMap.get("x-retry-after");
                    b.B1(charSequence, "text");
                    try {
                        l.b.a.u.a d2 = h2.d(charSequence, null);
                        d2.x(h2.f4125d, h2.f4126e);
                        lVar = l.c(d.s(d2));
                        if (!lVar.b()) {
                            if (((d) lVar.a()).compareTo(this.a.b()) <= 0) {
                                z = false;
                            }
                            if (z) {
                                this.b = l.b.a.c.b(this.a.b(), (l.b.a.w.d) lVar.a());
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (f e2) {
                        throw e2;
                    } catch (RuntimeException e3) {
                        throw h2.a(charSequence, e3);
                    }
                }
            } catch (Exception unused) {
            }
            lVar = f.b.b.a.a.b;
            if (!lVar.b()) {
            }
        } else if ((h0 < 500 || (i2 = this.c) >= 3) && ((!(uVar instanceof t) && !(uVar instanceof j)) || (i2 = this.c) >= 3)) {
            throw uVar;
        } else {
            this.c = i2 + 1;
        }
    }

    @Override // f.a.b.r
    public int c() {
        return this.c;
    }
}
