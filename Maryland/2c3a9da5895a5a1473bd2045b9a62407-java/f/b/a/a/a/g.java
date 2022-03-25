package f.b.a.a.a;

import android.app.Application;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import f.b.a.a.a.h.i;
import f.b.a.a.a.h.k;
import f.b.a.a.a.m.p;
import f.b.a.a.a.n.y;
import f.b.a.a.a.o.s;
import f.b.a.a.a.p.g0;
import f.b.a.a.a.t.w;
import f.b.a.a.a.t.z;
import f.b.a.a.a.v.f;
import f.b.a.a.a.w.e;
import f.b.a.a.a.y.t;
import f.b.a.a.a.y.t0;
import g.a.a.c.c.c;
import g.a.a.c.c.d;
import g.a.b.b;

public abstract class g extends Application implements b {
    public final c b = new c(new a());

    public class a implements d {
        public a() {
        }

        public Object a() {
            g.a.a.c.d.a aVar = new g.a.a.c.d.a(g.this);
            f.b.a.c.b.o.b.v(aVar, g.a.a.c.d.a.class);
            return new a(aVar, new i(), new t(), new p(), new k(), new g0(), new e(), new s(), new f.b.a.a.a.t.t(), new w(), new z(), new f.b.a.a.a.q.e(), new f.b.a.a.a.h.s.b(), new f(), new t0(), new f.b.a.a.a.o.t(), new y(), new f.b.a.a.a.z.f(), null);
        }
    }

    @Override // g.a.b.b
    public final Object e() {
        return this.b.e();
    }

    public void onCreate() {
        ((b) e()).c((ExposureNotificationApplication) this);
        super.onCreate();
    }
}
