package f.b.a.c.e.c;

import android.content.Context;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.c;
import f.b.a.c.b.l.l.l;
import f.b.a.c.f.b.b;
import f.b.a.c.f.b.d;
import f.b.a.c.f.b.e;
import f.b.a.c.f.b.f;
import f.b.a.c.i.c0;
import f.b.a.c.i.h;
import f.b.a.c.i.j;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class t extends c<a.c.C0085c> implements f.b.a.c.f.b.c {

    /* renamed from: h  reason: collision with root package name */
    public static final a<a.c.C0085c> f2593h = new a<>("Nearby.EXPOSURE_NOTIFICATION_API", new n(), new a.f());

    /* renamed from: i  reason: collision with root package name */
    public static final long f2594i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f2595j;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f2594i = timeUnit.toMillis(2);
        f2595j = timeUnit.toMillis(60);
    }

    public t(Context context) {
        super(context, f2593h, null, c.a.c);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> a(List<File> list) {
        b.a aVar = new b.a();
        b bVar = new b(4, aVar.a, 50, aVar.b, 50, aVar.c, 50, aVar.f2619d, 50, aVar.f2620e);
        l.a a = l.a();
        a.a = new z2(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2642h};
        h Y1 = f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
        e eVar = new e(this, list, bVar, "TYZWQ32170AXEUVCDW7A");
        c0 c0Var = (c0) Y1;
        Objects.requireNonNull(c0Var);
        return f.b.a.c.b.o.b.Y1(c0Var.i(j.a, eVar), f2595j);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<TemporaryExposureKey>> b() {
        l.a a = l.a();
        a.a = new d(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2640f};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<DailySummary>> c(DailySummariesConfig dailySummariesConfig) {
        l.a a = l.a();
        a.a = new a3(this, dailySummariesConfig);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2644j};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<e>> d() {
        l.a a = l.a();
        a.a = new g(this, "TYZWQ32170AXEUVCDW7A");
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2640f};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Long> e() {
        l.a a = l.a();
        a.a = new z2(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2642h};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<DiagnosisKeysDataMapping> f() {
        l.a a = l.a();
        a.a = new c3(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2646l};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> g(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        l.a a = l.a();
        a.a = new b3(diagnosisKeysDataMapping);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2646l};
        return f.b.a.c.b.o.b.Y1(j(1, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Set<d>> getStatus() {
        l.a a = l.a();
        a.a = new d3(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2645k};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<f> h() {
        l.a a = l.a();
        a.a = new e3(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.n};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Boolean> isEnabled() {
        l.a a = l.a();
        a.a = new c(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2640f};
        return f.b.a.c.b.o.b.Y1(j(0, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> start() {
        l.a a = l.a();
        a.a = s2.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2640f};
        return f.b.a.c.b.o.b.Y1(j(1, a.a()), f2594i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> stop() {
        l.a a = l.a();
        a.a = b.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2640f};
        return f.b.a.c.b.o.b.Y1(j(1, a.a()), f2594i);
    }
}
