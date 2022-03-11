package f.b.a.a.a.g0.s;

import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.t.q0.a;
import f.b.a.c.b.o.b;
import f.b.a.c.f.b.e;
import f.b.a.c.f.b.g;
import f.b.a.d.a.e0;
import f.b.b.b.c;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;
/* loaded from: classes.dex */
public class h implements e0 {

    /* renamed from: e */
    public static final c<Double> f2277e;

    /* renamed from: f */
    public static final c<Double> f2278f;

    /* renamed from: g */
    public static final c<d> f2279g;

    /* renamed from: h */
    public static final int f2280h;

    /* renamed from: i */
    public static final int f2281i;

    /* renamed from: j */
    public static final int f2282j;

    /* renamed from: k */
    public static final d f2283k = d.f(14);

    /* renamed from: l */
    public static final d f2284l = d.n(30);
    public final ScheduledExecutorService a;
    public final q1 b;
    public final Map<Integer, Double> c;

    /* renamed from: d */
    public final a f2285d;

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
        f2277e = q;
        c<Double> q2 = c.q(Double.valueOf(1.0d), Double.valueOf(301.0d), Double.valueOf(601.0d), Double.valueOf(901.0d), Double.valueOf(1351.0d), Double.valueOf(1801.0d), Double.valueOf(3600.0d), Double.valueOf(7201.0d));
        f2278f = q2;
        c<d> y = c.y(d.f(2), d.f(4), d.f(6), d.f(8), d.f(10), d.f(12));
        f2279g = y;
        f2280h = q.size() + 1;
        f2281i = y.size() + 1;
        f2282j = q2.size();
    }

    public h(ScheduledExecutorService scheduledExecutorService, q1 q1Var, DailySummariesConfig dailySummariesConfig, a aVar) {
        this.a = scheduledExecutorService;
        this.b = q1Var;
        Objects.requireNonNull(dailySummariesConfig);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < dailySummariesConfig.b.size(); i2++) {
            if (!(i2 == 0 || i2 == 5)) {
                hashMap.put(Integer.valueOf(i2), dailySummariesConfig.b.get(i2));
            }
        }
        this.c = hashMap;
        this.f2285d = aVar;
    }

    @Override // f.b.a.d.a.e0
    public u<List<Integer>> a() {
        return l.x(m.e.o0(this.b.a.e(), f2284l, this.a)).z(new i() { // from class: f.b.a.a.a.g0.s.a
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                int i2;
                h hVar = h.this;
                Objects.requireNonNull(hVar);
                double[][][] dArr = (double[][][]) Array.newInstance(double.class, h.f2281i, 3, h.f2280h);
                Iterator it = ((List) obj).iterator();
                while (true) {
                    int i3 = -1;
                    if (!it.hasNext()) {
                        break;
                    }
                    e eVar = (e) it.next();
                    if (hVar.c.get(Integer.valueOf(eVar.f2815d)).doubleValue() != 0.0d && !l.b.a.e.z(eVar.b).u(hVar.f2285d.c().w(h.f2283k))) {
                        l.b.a.e c = hVar.f2285d.c();
                        l.b.a.e z = l.b.a.e.z(eVar.b);
                        int i4 = 0;
                        while (i4 < h.f2281i - 1 && z.u(c.w(h.f2279g.get(i4)))) {
                            i4++;
                        }
                        int i5 = eVar.f2816e;
                        for (g gVar : eVar.c) {
                            double d2 = (double) gVar.b;
                            int i6 = 0;
                            while (i6 < h.f2280h + i3 && d2 > h.f2277e.get(i6).doubleValue()) {
                                i6++;
                            }
                            double[] dArr2 = dArr[i4][i5];
                            dArr2[i6] = dArr2[i6] + ((double) gVar.f2820d);
                            i5 = i5;
                            i3 = -1;
                        }
                    }
                }
                int[] iArr = new int[h.f2281i * 3 * h.f2280h * h.f2282j];
                for (int i7 = 0; i7 < h.f2281i; i7++) {
                    for (int i8 = 0; i8 < 3; i8++) {
                        for (int i9 = 0; i9 < h.f2280h; i9++) {
                            double d3 = dArr[i7][i8][i9];
                            if (d3 >= h.f2278f.get(0).doubleValue()) {
                                i2 = 0;
                                while (i2 < h.f2282j - 1) {
                                    int i10 = i2 + 1;
                                    if (d3 <= h.f2278f.get(i10).doubleValue()) {
                                        break;
                                    }
                                    i2 = i10;
                                }
                            } else {
                                i2 = -1;
                            }
                            if (i2 >= 0) {
                                int i11 = h.f2280h;
                                int i12 = h.f2282j;
                                iArr[(i12 * i9) + (i11 * i8 * i12) + (i7 * 3 * i11 * i12) + i2] = 1;
                            }
                        }
                    }
                }
                return b.R0(b.h(iArr));
            }
        }, this.a);
    }

    @Override // f.b.a.d.a.e0
    public String b() {
        return "histogramMetric-v2";
    }
}
