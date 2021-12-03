package f.b.a.a.a.u.t;

import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.i.f0.a;
import f.b.a.a.a.q.i1;
import f.b.a.d.a.e0;
import f.b.b.b.c;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;

public class g implements e0 {

    /* renamed from: e  reason: collision with root package name */
    public static final c<Double> f2448e;

    /* renamed from: f  reason: collision with root package name */
    public static final c<Double> f2449f;

    /* renamed from: g  reason: collision with root package name */
    public static final c<d> f2450g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f2451h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f2452i;

    /* renamed from: j  reason: collision with root package name */
    public static final int f2453j;

    /* renamed from: k  reason: collision with root package name */
    public static final d f2454k = d.f(14);

    /* renamed from: l  reason: collision with root package name */
    public static final d f2455l = d.n(30);
    public final ScheduledExecutorService a;
    public final i1 b;
    public final Map<Integer, Double> c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2456d;

    static {
        Double valueOf = Double.valueOf(50.1d);
        Double valueOf2 = Double.valueOf(55.1d);
        Double valueOf3 = Double.valueOf(60.1d);
        Double valueOf4 = Double.valueOf(65.1d);
        Double valueOf5 = Double.valueOf(70.1d);
        Double valueOf6 = Double.valueOf(75.1d);
        Double valueOf7 = Double.valueOf(80.1d);
        f.b.b.b.a<Object> aVar = c.c;
        c<Double> q = c.q(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7);
        f2448e = q;
        c<Double> q2 = c.q(Double.valueOf(1.0d), Double.valueOf(301.0d), Double.valueOf(601.0d), Double.valueOf(901.0d), Double.valueOf(1351.0d), Double.valueOf(1801.0d), Double.valueOf(3600.0d), Double.valueOf(7201.0d));
        f2449f = q2;
        c<d> y = c.y(d.f(2), d.f(4), d.f(6), d.f(8), d.f(10), d.f(12));
        f2450g = y;
        f2451h = q.size() + 1;
        f2452i = y.size() + 1;
        f2453j = q2.size();
    }

    public g(ScheduledExecutorService scheduledExecutorService, i1 i1Var, DailySummariesConfig dailySummariesConfig, a aVar) {
        this.a = scheduledExecutorService;
        this.b = i1Var;
        Objects.requireNonNull(dailySummariesConfig);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < dailySummariesConfig.b.size(); i2++) {
            if (!(i2 == 0 || i2 == 5)) {
                hashMap.put(Integer.valueOf(i2), dailySummariesConfig.b.get(i2));
            }
        }
        this.c = hashMap;
        this.f2456d = aVar;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        return l.x(m.h.i0(this.b.a.e(), f2455l, this.a)).z(new a(this), this.a);
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "histogramMetric-v2";
    }
}
