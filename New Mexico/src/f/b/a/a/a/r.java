package f.b.a.a.a;

import android.app.Application;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import f.b.a.a.a.a0.u;
import f.b.a.a.a.a0.v;
import f.b.a.a.a.c0.r1;
import f.b.a.a.a.g0.m;
import f.b.a.a.a.g0.s.o;
import f.b.a.a.a.n0.d1;
import f.b.a.a.a.n0.w;
import f.b.a.a.a.p0.k;
import f.b.a.a.a.t.b0;
import f.b.a.a.a.t.d0;
import f.b.a.a.a.y.p;
import f.b.a.a.a.z.h0;
import g.b.a.c.c.d;
import g.b.a.c.c.e;
import g.b.a.c.c.f;
import g.b.b.b;
/* loaded from: classes.dex */
public abstract class r extends Application implements b {
    public final e b = new e(new a());

    /* loaded from: classes.dex */
    public class a implements f {
        public a() {
            r.this = r1;
        }

        public Object a() {
            g.b.a.c.d.a aVar = new g.b.a.c.d.a(r.this);
            f.b.a.a.a.s.f fVar = new f.b.a.a.a.s.f();
            d.a(aVar, g.b.a.c.d.a.class);
            return new k(fVar, aVar, new b0(), new w(), new p(), new d0(), new r1(), new f.b.a.a.a.k0.d(), new u(), new o(), new m(), new f.b.a.a.a.g0.r(), new f.b.a.a.a.d0.e(), new f.b.a.a.a.t.q0.b(), new f.b.a.a.a.j0.f(), new d1(), new v(), new h0(), new k(), null);
        }
    }

    @Override // g.b.b.b
    public final Object e() {
        return this.b.e();
    }

    @Override // android.app.Application
    public void onCreate() {
        ((l) e()).e((ExposureNotificationApplication) this);
        super.onCreate();
    }
}
