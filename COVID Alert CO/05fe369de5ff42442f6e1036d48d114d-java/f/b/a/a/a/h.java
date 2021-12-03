package f.b.a.a.a;

import android.app.Application;
import com.google.android.apps.exposurenotification.ExposureNotificationApplication;
import f.b.a.a.a.b0.v;
import f.b.a.a.a.b0.y0;
import f.b.a.a.a.i.q;
import f.b.a.a.a.i.s;
import f.b.a.a.a.n.p;
import f.b.a.a.a.o.i0;
import f.b.a.a.a.p.w;
import f.b.a.a.a.q.j1;
import f.b.a.a.a.u.r;
import f.b.a.a.a.u.t.m;
import f.b.a.a.a.x.f;
import g.b.a.c.c.c;
import g.b.a.c.c.d;
import g.b.a.c.c.e;
import g.b.b.b;

public abstract class h extends Application implements b {
    public final d b = new d(new a());

    public class a implements e {
        public a() {
        }

        public Object a() {
            g.b.a.c.d.a aVar = new g.b.a.c.d.a(h.this);
            c.a(aVar, g.b.a.c.d.a.class);
            return new b(aVar, new q(), new v(), new p(), new s(), new j1(), new f.b.a.a.a.y.e(), new f.b.a.a.a.p.v(), new m(), new f.b.a.a.a.u.m(), new r(), new f.b.a.a.a.r.e(), new f.b.a.a.a.i.f0.b(), new f(), new y0(), new w(), new i0(), new f.b.a.a.a.d0.f(), null);
        }
    }

    @Override // g.b.b.b
    public final Object e() {
        return this.b.e();
    }

    public void onCreate() {
        ((c) e()).e((ExposureNotificationApplication) this);
        super.onCreate();
    }
}
