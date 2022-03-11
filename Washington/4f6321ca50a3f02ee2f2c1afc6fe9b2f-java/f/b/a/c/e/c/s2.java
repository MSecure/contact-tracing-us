package f.b.a.c.e.c;

import android.content.Context;
import android.provider.Settings;
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
import f.b.a.c.i.c0;
import f.b.a.c.i.h;
import f.b.a.c.i.j;
import java.io.File;
import java.util.List;
import java.util.Objects;

public final class s2 extends c<a.c.C0082c> implements f.b.a.c.f.b.c {

    /* renamed from: h  reason: collision with root package name */
    public static final a<a.c.C0082c> f2516h = new a<>("Nearby.EXPOSURE_NOTIFICATION_API", new k(), new a.f());

    public s2(Context context) {
        super(context, f2516h, null, c.a.c);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> a(List<File> list) {
        b.a aVar = new b.a();
        b bVar = new b(4, aVar.a, 50, aVar.b, 50, aVar.c, 50, aVar.f2529d, 50, aVar.f2530e);
        h<Long> f2 = f();
        h hVar = new h(this, list, bVar, "TYZWQ32170AXEUVCDW7A");
        c0 c0Var = (c0) f2;
        Objects.requireNonNull(c0Var);
        return c0Var.i(j.a, hVar);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<TemporaryExposureKey>> b() {
        l.a a = l.a();
        a.a = new e(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2540f};
        return k(0, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final boolean c() {
        return Settings.Global.getInt(this.a.getContentResolver(), "bluetooth_sanitized_exposure_notification_supported", 0) == 1;
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<DailySummary>> d(DailySummariesConfig dailySummariesConfig) {
        l.a a = l.a();
        a.a = new u2(this, dailySummariesConfig);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2544j};
        return k(0, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<d>> e() {
        l.a a = l.a();
        a.a = new i(this, "TYZWQ32170AXEUVCDW7A");
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2540f};
        return k(0, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<Long> f() {
        l.a a = l.a();
        a.a = new t2(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2542h};
        return k(0, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<DiagnosisKeysDataMapping> g() {
        l.a a = l.a();
        a.a = new v2(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2546l};
        return k(0, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> h(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        l.a a = l.a();
        a.a = new w2(diagnosisKeysDataMapping);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2546l};
        return k(1, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<e> i() {
        l.a a = l.a();
        a.a = new b(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.n};
        return k(0, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<Boolean> isEnabled() {
        l.a a = l.a();
        a.a = new f(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2540f};
        return k(0, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> start() {
        l.a a = l.a();
        a.a = r2.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2540f};
        return k(1, a.a());
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> stop() {
        l.a a = l.a();
        a.a = c.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2540f};
        return k(1, a.a());
    }
}
