package f.b.c.k.w;

import f.b.c.k.s.v;
import f.b.c.k.x.c;
import f.b.c.k.x.m;

public class f0 {
    public v a = v.UNKNOWN;
    public int b;
    public c.b c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3133d = true;

    /* renamed from: e  reason: collision with root package name */
    public final c f3134e;

    /* renamed from: f  reason: collision with root package name */
    public final a f3135f;

    public interface a {
    }

    public f0(c cVar, a aVar) {
        this.f3134e = cVar;
        this.f3135f = aVar;
    }

    public final void a(String str) {
        String format = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", str);
        Object[] objArr = new Object[1];
        if (this.f3133d) {
            objArr[0] = format;
            m.a(m.a.WARN, "OnlineStateTracker", "%s", objArr);
            this.f3133d = false;
            return;
        }
        objArr[0] = format;
        m.a(m.a.DEBUG, "OnlineStateTracker", "%s", objArr);
    }

    public final void b(v vVar) {
        if (vVar != this.a) {
            this.a = vVar;
            ((i0) this.f3135f).a.f(vVar);
        }
    }

    public void c(v vVar) {
        c.b bVar = this.c;
        if (bVar != null) {
            bVar.a();
            this.c = null;
        }
        this.b = 0;
        if (vVar == v.ONLINE) {
            this.f3133d = false;
        }
        b(vVar);
    }
}
