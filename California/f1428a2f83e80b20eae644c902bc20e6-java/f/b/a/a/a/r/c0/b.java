package f.b.a.a.a.r.c0;

import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.n.f0;
import f.b.b.b.c;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;

public class b implements f {

    /* renamed from: e  reason: collision with root package name */
    public static final c<Double> f2199e;

    /* renamed from: f  reason: collision with root package name */
    public static final c<Double> f2200f;

    /* renamed from: g  reason: collision with root package name */
    public static final c<l.b.a.c> f2201g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f2202h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f2203i;

    /* renamed from: j  reason: collision with root package name */
    public static final int f2204j;

    /* renamed from: k  reason: collision with root package name */
    public static final l.b.a.c f2205k = l.b.a.c.e(14);

    /* renamed from: l  reason: collision with root package name */
    public static final l.b.a.c f2206l = l.b.a.c.l(30);
    public final ScheduledExecutorService a;
    public final f0 b;
    public final Map<Integer, Double> c;

    /* renamed from: d  reason: collision with root package name */
    public final a f2207d;

    static {
        c<Double> w = c.w(Double.valueOf(50.1d), Double.valueOf(55.1d), Double.valueOf(60.1d), Double.valueOf(65.1d), Double.valueOf(70.1d), Double.valueOf(75.1d), Double.valueOf(80.1d));
        f2199e = w;
        c<Double> w2 = c.w(Double.valueOf(301.0d), Double.valueOf(601.0d), Double.valueOf(901.0d), Double.valueOf(1351.0d), Double.valueOf(1801.0d), Double.valueOf(3600.0d), Double.valueOf(7201.0d));
        f2200f = w2;
        c<l.b.a.c> v = c.v(l.b.a.c.e(2), l.b.a.c.e(4), l.b.a.c.e(6), l.b.a.c.e(8), l.b.a.c.e(10), l.b.a.c.e(12));
        f2201g = v;
        f2202h = w.size() + 1;
        f2203i = v.size() + 1;
        f2204j = w2.size() + 1;
    }

    public b(ScheduledExecutorService scheduledExecutorService, f0 f0Var, DailySummariesConfig dailySummariesConfig, a aVar) {
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
        this.f2207d = aVar;
    }

    @Override // f.b.a.a.a.r.c0.f
    public u<List<Integer>> a() {
        return l.x(m.h.g0(this.b.a.e(), f2206l, this.a)).z(new a(this), this.a);
    }

    @Override // f.b.a.a.a.r.c0.f
    public /* synthetic */ void b() {
        e.a(this);
    }

    @Override // f.b.a.a.a.r.c0.f
    public String c() {
        return "histogramMetric-v1";
    }
}
