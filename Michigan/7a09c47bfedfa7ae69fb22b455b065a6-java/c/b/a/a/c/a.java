package c.b.a.a.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.o.q;
import c.b.a.a.g.b.e;
import c.b.a.a.g.b.e5;
import c.b.a.a.g.b.f5;
import c.b.a.a.g.b.g3;
import c.b.a.a.g.b.g5;
import c.b.a.a.g.b.l;
import c.b.a.a.g.b.n;
import c.b.a.a.g.b.n4;
import c.b.a.a.g.b.o;
import c.b.a.a.g.b.o2;
import c.b.a.a.g.b.p2;
import c.b.a.a.g.b.r4;
import c.b.a.a.g.b.v4;
import c.b.a.a.g.b.w4;
import c.b.a.a.g.b.z0;
import c.b.a.a.g.b.z4;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public final class a {
    public static final a.g<z4> m = new a.g<>();
    public static final a.AbstractC0062a<z4, a.d.c> n;
    @Deprecated
    public static final c.b.a.a.d.k.a<a.d.c> o;
    public static final c.b.a.a.h.a[] p = new c.b.a.a.h.a[0];

    /* renamed from: a  reason: collision with root package name */
    public final Context f2893a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2894b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2895c;

    /* renamed from: d  reason: collision with root package name */
    public String f2896d;

    /* renamed from: e  reason: collision with root package name */
    public int f2897e = -1;

    /* renamed from: f  reason: collision with root package name */
    public String f2898f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2899g;
    public n4 h;
    public final c i;
    public final c.b.a.a.d.o.a j;
    public d k;
    public final b l;

    /* renamed from: c.b.a.a.c.a$a  reason: collision with other inner class name */
    public class C0061a {

        /* renamed from: a  reason: collision with root package name */
        public int f2900a;

        /* renamed from: b  reason: collision with root package name */
        public String f2901b;

        /* renamed from: c  reason: collision with root package name */
        public String f2902c;

        /* renamed from: d  reason: collision with root package name */
        public String f2903d = null;

        /* renamed from: e  reason: collision with root package name */
        public n4 f2904e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2905f;

        /* renamed from: g  reason: collision with root package name */
        public final w4 f2906g;
        public boolean h;

        public C0061a(byte[] bArr, b bVar) {
            a aVar = a.this;
            this.f2900a = aVar.f2897e;
            this.f2901b = aVar.f2896d;
            this.f2902c = aVar.f2898f;
            this.f2904e = aVar.h;
            this.f2905f = true;
            w4 w4Var = new w4();
            this.f2906g = w4Var;
            this.h = false;
            this.f2902c = a.this.f2898f;
            this.f2903d = null;
            w4Var.w = c.b.a.a.g.b.a.a(a.this.f2893a);
            w4 w4Var2 = this.f2906g;
            if (((c.b.a.a.d.o.b) a.this.j) != null) {
                w4Var2.f3459d = System.currentTimeMillis();
                w4 w4Var3 = this.f2906g;
                if (((c.b.a.a.d.o.b) a.this.j) != null) {
                    w4Var3.f3460e = SystemClock.elapsedRealtime();
                    w4 w4Var4 = this.f2906g;
                    w4Var4.q = (long) (TimeZone.getDefault().getOffset(w4Var4.f3459d) / 1000);
                    if (bArr != null) {
                        this.f2906g.l = bArr;
                        return;
                    }
                    return;
                }
                throw null;
            }
            throw null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:65:0x0160  */
        public void a() {
            List list;
            int i2;
            String str;
            r4.b bVar;
            String str2;
            int i3;
            String str3;
            if (!this.h) {
                boolean z = true;
                this.h = true;
                a aVar = a.this;
                f fVar = new f(new g5(aVar.f2894b, aVar.f2895c, this.f2900a, this.f2901b, this.f2902c, this.f2903d, aVar.f2899g, this.f2904e), this.f2906g, null, null, null, this.f2905f);
                e5 e5Var = (e5) a.this.l;
                if (e5Var != null) {
                    g5 g5Var = fVar.f2910b;
                    String str4 = g5Var.h;
                    int i4 = g5Var.f3287d;
                    w4 w4Var = fVar.j;
                    boolean z2 = false;
                    int i5 = w4Var != null ? w4Var.f3462g : 0;
                    if (!e5.i.a().booleanValue()) {
                        if (str4 == null || str4.isEmpty()) {
                            str4 = i4 >= 0 ? String.valueOf(i4) : null;
                        }
                        if (str4 != null) {
                            Context context = e5Var.f3264a;
                            if (context == null || !e5.c(context)) {
                                str = null;
                            } else {
                                e<String> eVar = e5.f3262f.get(str4);
                                if (eVar == null) {
                                    o oVar = e5.f3260d;
                                    if (oVar != null) {
                                        eVar = e.g(oVar, str4);
                                        e5.f3262f.put(str4, eVar);
                                    } else {
                                        throw null;
                                    }
                                }
                                str = eVar.a();
                            }
                            if (str != null) {
                                int indexOf = str.indexOf(44);
                                if (indexOf >= 0) {
                                    str2 = str.substring(0, indexOf);
                                    i3 = indexOf + 1;
                                } else {
                                    str2 = "";
                                    i3 = 0;
                                }
                                int indexOf2 = str.indexOf(47, i3);
                                if (indexOf2 <= 0) {
                                    str3 = "Failed to parse the rule: ";
                                    if (str.length() == 0) {
                                        new String(str3);
                                    }
                                } else {
                                    try {
                                        long parseLong = Long.parseLong(str.substring(i3, indexOf2));
                                        long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
                                        if (parseLong >= 0 && parseLong2 >= 0) {
                                            r4.b.a aVar2 = (r4.b.a) ((z0.a) r4.b.zzbiv.g(5, null, null));
                                            aVar2.h();
                                            r4.b.k((r4.b) aVar2.f3485c, str2);
                                            aVar2.h();
                                            r4.b bVar2 = (r4.b) aVar2.f3485c;
                                            bVar2.zzbb |= 4;
                                            bVar2.zzbit = parseLong;
                                            aVar2.h();
                                            r4.b bVar3 = (r4.b) aVar2.f3485c;
                                            bVar3.zzbb |= 8;
                                            bVar3.zzbiu = parseLong2;
                                            z0 z0Var = (z0) aVar2.i();
                                            byte byteValue = ((Byte) z0Var.g(1, null, null)).byteValue();
                                            if (byteValue == 1) {
                                                z2 = true;
                                            } else if (byteValue != 0) {
                                                z2 = p2.f3390c.b(z0Var).f(z0Var);
                                                z0Var.g(2, z2 ? z0Var : null, null);
                                            }
                                            if (z2) {
                                                bVar = (r4.b) z0Var;
                                                if (bVar != null) {
                                                    z = e5.b(e5.a(bVar.zzbis, e5.d(e5Var.f3264a)), bVar.zzbit, bVar.zzbiu);
                                                }
                                            } else {
                                                throw new g3();
                                            }
                                        }
                                    } catch (NumberFormatException unused) {
                                        str3 = "parseLong() failed while parsing: ";
                                        if (str.length() == 0) {
                                            new String(str3);
                                        }
                                    }
                                }
                                str3.concat(str);
                            }
                            bVar = null;
                            if (bVar != null) {
                            }
                        }
                    } else {
                        if (str4 == null || str4.isEmpty()) {
                            str4 = i4 >= 0 ? String.valueOf(i4) : null;
                        }
                        if (str4 != null) {
                            if (e5Var.f3264a == null) {
                                list = Collections.emptyList();
                            } else {
                                e<r4> eVar2 = e5.f3261e.get(str4);
                                if (eVar2 == null) {
                                    o oVar2 = e5.f3259c;
                                    r4 r4Var = r4.zzbir;
                                    n nVar = f5.f3267a;
                                    if (oVar2 != null) {
                                        l lVar = new l(oVar2, str4, r4Var, nVar);
                                        eVar2 = e5.f3261e.putIfAbsent(str4, lVar);
                                        if (eVar2 == null) {
                                            eVar2 = lVar;
                                        }
                                    } else {
                                        throw null;
                                    }
                                }
                                list = eVar2.a().zzbiq;
                            }
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                r4.b bVar4 = (r4.b) it.next();
                                if ((!((bVar4.zzbb & 1) == 1) || (i2 = bVar4.zzya) == 0 || i2 == i5) && !e5.b(e5.a(bVar4.zzbis, e5.d(e5Var.f3264a)), bVar4.zzbit, bVar4.zzbiu)) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (z) {
                        o2 o2Var = (o2) a.this.i;
                        if (o2Var != null) {
                            o2Var.doBestEffortWrite(new v4(fVar, o2Var.asGoogleApiClient()));
                            return;
                        }
                        throw null;
                    }
                    Status status = Status.f5979g;
                    t.D(status, "Result must not be null");
                    new q(null).setResult(status);
                    return;
                }
                throw null;
            }
            throw new IllegalStateException("do not reuse LogEventBuilder");
        }
    }

    public interface b {
    }

    public interface c {
        byte[] zza();
    }

    public static class d {
    }

    static {
        b bVar = new b();
        n = bVar;
        o = new c.b.a.a.d.k.a<>("ClearcutLogger.API", bVar, m);
    }

    public a(Context context, String str, String str2) {
        int i2;
        o2 o2Var = new o2(context);
        c.b.a.a.d.o.b bVar = c.b.a.a.d.o.b.f3172a;
        e5 e5Var = new e5(context);
        n4 n4Var = n4.DEFAULT;
        this.h = n4Var;
        this.f2893a = context;
        this.f2894b = context.getPackageName();
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.wtf("ClearcutLogger", "This can't happen.", e2);
            i2 = 0;
        }
        this.f2895c = i2;
        this.f2897e = -1;
        this.f2896d = str;
        this.f2898f = null;
        this.f2899g = false;
        this.i = o2Var;
        this.j = bVar;
        this.k = new d();
        this.h = n4Var;
        this.l = e5Var;
    }
}
