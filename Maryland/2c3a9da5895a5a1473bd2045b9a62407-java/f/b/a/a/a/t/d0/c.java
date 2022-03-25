package f.b.a.a.a.t.d0;

import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.p.f0;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;

public class c implements g {

    /* renamed from: e  reason: collision with root package name */
    public static final f.b.b.b.c<Double> f2283e;

    /* renamed from: f  reason: collision with root package name */
    public static final f.b.b.b.c<Double> f2284f;

    /* renamed from: g  reason: collision with root package name */
    public static final f.b.b.b.c<l.b.a.c> f2285g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f2286h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f2287i;

    /* renamed from: j  reason: collision with root package name */
    public static final int f2288j;

    /* renamed from: k  reason: collision with root package name */
    public static final l.b.a.c f2289k = l.b.a.c.e(14);

    /* renamed from: l  reason: collision with root package name */
    public static final l.b.a.c f2290l = l.b.a.c.m(30);
    public final ScheduledExecutorService a;
    public final f0 b;
    public final Map<Integer, Double> c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2291d;

    static {
        Double valueOf = Double.valueOf(50.1d);
        Double valueOf2 = Double.valueOf(55.1d);
        Double valueOf3 = Double.valueOf(60.1d);
        Double valueOf4 = Double.valueOf(65.1d);
        Double valueOf5 = Double.valueOf(70.1d);
        Double valueOf6 = Double.valueOf(75.1d);
        Double valueOf7 = Double.valueOf(80.1d);
        f.b.b.b.a<Object> aVar = f.b.b.b.c.c;
        f.b.b.b.c<Double> q = f.b.b.b.c.q(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7);
        f2283e = q;
        f.b.b.b.c<Double> q2 = f.b.b.b.c.q(Double.valueOf(1.0d), Double.valueOf(301.0d), Double.valueOf(601.0d), Double.valueOf(901.0d), Double.valueOf(1351.0d), Double.valueOf(1801.0d), Double.valueOf(3600.0d), Double.valueOf(7201.0d));
        f2284f = q2;
        f.b.b.b.c<l.b.a.c> v = f.b.b.b.c.v(l.b.a.c.e(2), l.b.a.c.e(4), l.b.a.c.e(6), l.b.a.c.e(8), l.b.a.c.e(10), l.b.a.c.e(12));
        f2285g = v;
        f2286h = q.size() + 1;
        f2287i = v.size() + 1;
        f2288j = q2.size();
    }

    public c(ScheduledExecutorService scheduledExecutorService, f0 f0Var, DailySummariesConfig dailySummariesConfig, a aVar) {
        this.a = scheduledExecutorService;
        this.b = f0Var;
        Objects.requireNonNull(dailySummariesConfig);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < dailySummariesConfig.b.size(); i2++) {
            if (!(i2 == 0 || i2 == 5)) {
                hashMap.put(Integer.valueOf(i2), dailySummariesConfig.b.get(i2));
            }
        }
        this.c = hashMap;
        this.f2291d = aVar;
    }

    @Override // f.b.a.a.a.t.d0.g
    public u<List<Integer>> a() {
        return l.x(m.h.g0(this.b.a.d(), f2290l, this.a)).z(new a(this), this.a);
    }

    @Override // f.b.a.a.a.t.d0.g
    public String b() {
        return "histogramMetric-v2";
    }
}
