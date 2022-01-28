package f.b.c.k.t;

import f.b.c.g.a.f;
import f.b.c.k.u.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class j0 {
    public f<c> a;
    public f<c> b = new f<>(Collections.emptyList(), b.a);

    public j0() {
        List emptyList = Collections.emptyList();
        int i2 = c.c;
        this.a = new f<>(emptyList, a.a);
    }

    public void a(f.b.c.k.u.f fVar, int i2) {
        c cVar = new c(fVar, i2);
        this.a = new f<>(this.a.b.l(cVar, null));
        this.b = new f<>(this.b.b.l(cVar, null));
    }

    public void b(f<f.b.c.k.u.f> fVar, int i2) {
        Iterator<f.b.c.k.u.f> it = fVar.iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                a((f.b.c.k.u.f) aVar.next(), i2);
            } else {
                return;
            }
        }
    }

    public boolean c(f.b.c.k.u.f fVar) {
        Iterator<Map.Entry<T, Void>> m = this.a.b.m(new c(fVar, 0));
        if (!m.hasNext()) {
            return false;
        }
        return m.next().getKey().a.equals(fVar);
    }

    public f<f.b.c.k.u.f> d(int i2) {
        f<f.b.c.k.u.f> fVar = f.b.c.k.u.f.c;
        Iterator<Map.Entry<T, Void>> m = this.b.b.m(new c(new f.b.c.k.u.f(l.r(Collections.emptyList())), i2));
        f<f.b.c.k.u.f> fVar2 = f.b.c.k.u.f.c;
        while (m.hasNext()) {
            T key = m.next().getKey();
            if (key.b != i2) {
                break;
            }
            fVar2 = fVar2.h(key.a);
        }
        return fVar2;
    }

    public void e(f.b.c.k.u.f fVar, int i2) {
        c cVar = new c(fVar, i2);
        this.a = this.a.i(cVar);
        this.b = this.b.i(cVar);
    }

    public void f(f<f.b.c.k.u.f> fVar, int i2) {
        Iterator<f.b.c.k.u.f> it = fVar.iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                e((f.b.c.k.u.f) aVar.next(), i2);
            } else {
                return;
            }
        }
    }

    public f<f.b.c.k.u.f> g(int i2) {
        f<f.b.c.k.u.f> fVar = f.b.c.k.u.f.c;
        Iterator<Map.Entry<T, Void>> m = this.b.b.m(new c(new f.b.c.k.u.f(l.r(Collections.emptyList())), i2));
        f<f.b.c.k.u.f> fVar2 = f.b.c.k.u.f.c;
        while (m.hasNext()) {
            T key = m.next().getKey();
            if (key.b != i2) {
                break;
            }
            fVar2 = fVar2.h(key.a);
            this.a = this.a.i(key);
            this.b = this.b.i(key);
        }
        return fVar2;
    }
}
