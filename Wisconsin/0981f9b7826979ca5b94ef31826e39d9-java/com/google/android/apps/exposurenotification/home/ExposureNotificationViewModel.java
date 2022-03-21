package com.google.android.apps.exposurenotification.home;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build;
import android.os.StatFs;
import e.p.a0;
import e.p.q;
import f.b.a.a.a.j.c;
import f.b.a.a.a.j.d;
import f.b.a.a.a.j.f;
import f.b.a.a.a.j.g;
import f.b.a.a.a.j.j;
import f.b.a.a.a.j.k;
import f.b.a.a.a.j.l;
import f.b.a.a.a.j.m;
import f.b.a.a.a.j.n;
import f.b.a.a.a.m.p;
import f.b.a.a.a.n.f0;
import f.b.a.a.a.n.i0;
import f.b.a.a.a.w.k0;
import f.b.a.c.b.l.b;
import f.b.a.c.f.b.e;
import f.b.a.c.i.h;
import java.util.Objects;

public class ExposureNotificationViewModel extends a0 {
    public final q<a> c;

    /* renamed from: d  reason: collision with root package name */
    public final q<Boolean> f331d;

    /* renamed from: e  reason: collision with root package name */
    public final q<Boolean> f332e;

    /* renamed from: f  reason: collision with root package name */
    public final q<Boolean> f333f;

    /* renamed from: g  reason: collision with root package name */
    public final k0 f334g;

    /* renamed from: h  reason: collision with root package name */
    public final f.b.a.a.a.h.q<Void> f335h = new f.b.a.a.a.h.q<>();

    /* renamed from: i  reason: collision with root package name */
    public final f.b.a.a.a.h.q<b> f336i = new f.b.a.a.a.h.q<>();

    /* renamed from: j  reason: collision with root package name */
    public final f0 f337j;

    /* renamed from: k  reason: collision with root package name */
    public final LocationManager f338k;

    /* renamed from: l  reason: collision with root package name */
    public final StatFs f339l;
    public final p m;
    public final i0 n;
    public final f.b.a.a.a.h.s.a o;
    public boolean p = false;

    public enum a {
        DISABLED,
        ENABLED,
        PAUSED_BLE,
        PAUSED_LOCATION,
        PAUSED_LOCATION_BLE,
        STORAGE_LOW
    }

    public ExposureNotificationViewModel(k0 k0Var, f0 f0Var, LocationManager locationManager, StatFs statFs, p pVar, i0 i0Var, f.b.a.a.a.h.s.a aVar) {
        Boolean bool = Boolean.FALSE;
        this.f331d = new q<>(bool);
        this.f332e = new q<>(bool);
        this.f334g = k0Var;
        this.f337j = f0Var;
        this.f338k = locationManager;
        this.f339l = statFs;
        this.m = pVar;
        this.n = i0Var;
        this.o = aVar;
        boolean z = k0Var.a.getBoolean("ExposureNotificationSharedPreferences.IS_ENABLED_CACHE_KEY", false);
        this.f333f = new q<>(Boolean.valueOf(z));
        this.c = new q<>(c(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0074  */
    public final a c(boolean z) {
        boolean z2;
        boolean z3;
        int i2;
        LocationManager locationManager;
        a aVar = a.STORAGE_LOW;
        this.f333f.l(Boolean.valueOf(z));
        boolean z4 = false;
        if (!z) {
            if (this.f339l.getAvailableBytes() <= 104857600) {
                z4 = true;
            }
            if (z4) {
                return aVar;
            }
            return a.DISABLED;
        }
        if (!this.f337j.a.c() && (i2 = Build.VERSION.SDK_INT) >= 23 && (locationManager = this.f338k) != null) {
            if (!(i2 >= 28 ? locationManager.isLocationEnabled() : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps"))) {
                z2 = true;
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                z3 = defaultAdapter == null && !defaultAdapter.isEnabled();
                if (!z3 && z2) {
                    return a.PAUSED_LOCATION_BLE;
                }
                if (!z3) {
                    return a.PAUSED_BLE;
                }
                if (z2) {
                    return a.PAUSED_LOCATION;
                }
                if (this.f339l.getAvailableBytes() <= 104857600) {
                    z4 = true;
                }
                if (z4) {
                    return aVar;
                }
                return a.ENABLED;
            }
        }
        z2 = false;
        BluetoothAdapter defaultAdapter2 = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter2 == null) {
        }
        if (!z3) {
        }
        if (!z3) {
        }
    }

    public void d() {
        synchronized (this) {
            if (!this.p) {
                this.p = true;
                this.f337j.b().f(new d(this)).a(new n(this)).d(new g(this));
            }
        }
        synchronized (this) {
            h<e> a2 = this.f337j.a();
            i0 i0Var = this.n;
            Objects.requireNonNull(i0Var);
            a2.f(new f.b.a.a.a.j.a(i0Var)).a(f.a).d(l.a);
        }
    }

    public void e() {
        this.f331d.l(Boolean.TRUE);
        this.f337j.c().f(new k(this)).d(new f.b.a.a.a.j.e(this)).a(new f.b.a.a.a.j.p(this));
    }

    public void f() {
        q<Boolean> qVar = this.f332e;
        Boolean bool = Boolean.FALSE;
        qVar.l(bool);
        this.f331d.l(bool);
    }

    public void g() {
        this.f332e.l(Boolean.FALSE);
        this.f337j.c().f(new c(this)).d(new m(this)).a(new j(this));
    }
}
