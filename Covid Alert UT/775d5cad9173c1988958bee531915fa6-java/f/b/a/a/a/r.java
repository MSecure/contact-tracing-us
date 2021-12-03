package f.b.a.a.a;

import android.app.Application;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import f.b.a.a.a.b0.j1;
import f.b.a.a.a.f0.s.m;
import f.b.a.a.a.l0.v;
import f.b.a.a.a.l0.y0;
import f.b.a.a.a.s.p;
import f.b.a.a.a.y.h0;
import f.b.a.a.a.z.u;
import g.b.a.c.c.d;
import g.b.a.c.c.e;
import g.b.a.c.c.f;
import g.b.b.b;

public abstract class r extends Application implements b {
    public final e b = new e(new a());

    public class a implements f {
        public a() {
        }

        public Object a() {
            g.b.a.c.d.a aVar = new g.b.a.c.d.a(r.this);
            d.a(aVar, g.b.a.c.d.a.class);
            return new k(aVar, new p(), new v(), new f.b.a.a.a.x.p(), new f.b.a.a.a.s.r(), new j1(), new f.b.a.a.a.i0.d(), new u(), new m(), new f.b.a.a.a.f0.m(), new f.b.a.a.a.f0.r(), new f.b.a.a.a.c0.e(), new f.b.a.a.a.s.e0.b(), new f.b.a.a.a.h0.f(), new y0(), new f.b.a.a.a.z.v(), new h0(), new f.b.a.a.a.n0.f(), null);
        }
    }

    @Override // g.b.b.b
    public final Object e() {
        return this.b.e();
    }

    public void onCreate() {
        ((l) e()).e((ExposureNotificationApplication) this);
        super.onCreate();
    }
}
