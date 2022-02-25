package f.b.a.a.a;

import android.app.Application;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import f.b.a.a.a.h.i;
import f.b.a.a.a.h.k;
import f.b.a.a.a.k.p;
import f.b.a.a.a.l.x;
import f.b.a.a.a.m.t;
import f.b.a.a.a.n.g0;
import f.b.a.a.a.r.v;
import f.b.a.a.a.r.y;
import f.b.a.a.a.t.f;
import f.b.a.a.a.u.e;
import f.b.a.a.a.w.q0;
import f.b.a.a.a.w.s;
import g.a.a.b.c.c;
import g.a.a.b.c.d;
import g.a.b.b;

public abstract class g extends Application implements b {
    public final c b = new c(new a());

    public class a implements d {
        public a() {
        }

        public Object a() {
            g.a.a.b.d.a aVar = new g.a.a.b.d.a(g.this);
            f.b.a.c.b.o.b.v(aVar, g.a.a.b.d.a.class);
            return new a(aVar, new i(), new s(), new p(), new k(), new g0(), new e(), new f.b.a.a.a.m.s(), new f.b.a.a.a.r.s(), new v(), new y(), new f.b.a.a.a.o.e(), new f.b.a.a.a.h.s.b(), new f(), new q0(), new t(), new x(), new f.b.a.a.a.x.e(), null);
        }
    }

    @Override // g.a.b.b
    public final Object d() {
        return this.b.d();
    }

    public void onCreate() {
        ((b) d()).c((ExposureNotificationApplication) this);
        super.onCreate();
    }
}
