package f.b.a.d.a;

import f.b.a.a.a.u.f;
import f.b.a.a.a.u.q;
import f.b.a.a.a.u.r;
import f.b.a.d.a.d0;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class g0 {
    public final ExecutorService a = t.c;
    public final SecureRandom b = new SecureRandom();
    public final f0 c;

    /* renamed from: d  reason: collision with root package name */
    public final c0 f2749d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f2750e;

    /* renamed from: f  reason: collision with root package name */
    public final d0 f2751f;

    /* renamed from: g  reason: collision with root package name */
    public v f2752g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2753h;

    /* renamed from: i  reason: collision with root package name */
    public final a f2754i;

    public interface a {
        u<u> get();
    }

    public enum b {
        SUCCESS,
        FAILURE
    }

    public g0(a aVar, f0 f0Var, c0 c0Var, a0 a0Var, d0.a aVar2, int i2) {
        this.f2754i = aVar;
        this.c = f0Var;
        this.f2749d = c0Var;
        this.f2750e = a0Var;
        r rVar = ((f) aVar2).a;
        Objects.requireNonNull(rVar);
        this.f2751f = new q(rVar, f.b.a.a.a.i.e0.a.e("PAPrioSubmitter"));
        this.f2752g = new x(aVar2);
        this.f2753h = i2;
    }

    public static boolean a(int i2, Calendar calendar) {
        return calendar.get(3) % 2 == i2 / 7 && calendar.get(7) == (i2 % 7) + 1;
    }

    public final List<u<b>> b(List<w> list, h0 h0Var) {
        boolean z;
        ArrayList arrayList = new ArrayList(list.size());
        for (w wVar : list) {
            e0 e0Var = wVar.a;
            double d2 = wVar.c;
            if (this.b.nextDouble() > d2) {
                d0 d0Var = this.f2751f;
                StringBuilder i2 = f.a.a.a.a.i("Skipping sample for metric ");
                i2.append(e0Var.b());
                i2.append(". samplingRate=");
                i2.append(d2);
                ((q) d0Var).a.a(i2.toString());
                z = false;
            } else {
                z = true;
            }
            if (z) {
                String b2 = wVar.a.b();
                l y = l.x(wVar.a.a()).y(new m(this, wVar, h0Var), this.a).y(new n(this), this.a).y(new l(this, b2, h0Var), this.a).y(new k(this, b2), this.a);
                j jVar = new j(this, b2);
                ExecutorService executorService = this.a;
                a.b bVar = new a.b(y, Exception.class, jVar);
                y.a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }
}
