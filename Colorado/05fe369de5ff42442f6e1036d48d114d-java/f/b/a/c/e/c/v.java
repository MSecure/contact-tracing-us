package f.b.a.c.e.c;

import android.content.Context;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.c;
import f.b.a.c.b.l.l.l;
import f.b.a.c.b.o.b;
import f.b.a.c.f.b.b;
import f.b.a.c.f.b.d;
import f.b.a.c.f.b.e;
import f.b.a.c.f.b.f;
import f.b.a.c.i.h;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class v extends c<a.c.C0084c> implements f.b.a.c.f.b.c {

    /* renamed from: h  reason: collision with root package name */
    public static final a<a.c.C0084c> f2690h = new a<>("Nearby.EXPOSURE_NOTIFICATION_API", new p(), new a.f());

    /* renamed from: i  reason: collision with root package name */
    public static final long f2691i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f2692j;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f2691i = timeUnit.toMillis(2);
        f2692j = timeUnit.toMillis(60);
    }

    public v(Context context) {
        super(context, f2690h, null, c.a.c);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> a() {
        l.a a = l.a();
        a.a = k3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.o};
        return b.w1(l(1, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> b(List<File> list) {
        b.a aVar = new b.a();
        f.b.a.c.f.b.b bVar = new f.b.a.c.f.b.b(4, aVar.a, 50, aVar.b, 50, aVar.c, 50, aVar.f2709d, 50, aVar.f2710e);
        l.a a = l.a();
        a.a = new f(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2732h};
        return f.b.a.c.b.o.b.w1(f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i).i(new n3(this, list, bVar, "TYZWQ32170AXEUVCDW7A")), f2692j);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<TemporaryExposureKey>> c() {
        l.a a = l.a();
        a.a = new e(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2730f};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<DailySummary>> d(DailySummariesConfig dailySummariesConfig) {
        l.a a = l.a();
        a.a = new h(this, dailySummariesConfig);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2734j};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<e>> e() {
        l.a a = l.a();
        a.a = new h3(this, "TYZWQ32170AXEUVCDW7A");
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2730f};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Long> f() {
        l.a a = l.a();
        a.a = new f(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2732h};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<DiagnosisKeysDataMapping> g() {
        l.a a = l.a();
        a.a = new b(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2736l};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Set<d>> getStatus() {
        l.a a = l.a();
        a.a = new d(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2735k};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> h() {
        l.a a = l.a();
        a.a = j3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.p};
        return f.b.a.c.b.o.b.w1(l(1, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> i(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        l.a a = l.a();
        a.a = new v2(diagnosisKeysDataMapping);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2736l};
        return f.b.a.c.b.o.b.w1(l(1, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Boolean> isEnabled() {
        l.a a = l.a();
        a.a = new g(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2730f};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<f> j() {
        l.a a = l.a();
        a.a = new c(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.n};
        return f.b.a.c.b.o.b.w1(l(0, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> start() {
        l.a a = l.a();
        a.a = l3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2730f};
        return f.b.a.c.b.o.b.w1(l(1, a.a()), f2691i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> stop() {
        l.a a = l.a();
        a.a = m3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2730f};
        return f.b.a.c.b.o.b.w1(l(1, a.a()), f2691i);
    }
}
