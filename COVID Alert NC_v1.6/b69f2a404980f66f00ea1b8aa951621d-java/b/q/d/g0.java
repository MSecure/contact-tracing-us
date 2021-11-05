package b.q.d;

import androidx.recyclerview.widget.RecyclerView;
import b.e.e;
import b.e.h;
import b.i.k.c;

public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final h<RecyclerView.d0, a> f1505a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final e<RecyclerView.d0> f1506b = new e<>();

    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static c<a> f1507d = new c<>(20);

        /* renamed from: a  reason: collision with root package name */
        public int f1508a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.l.c f1509b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.l.c f1510c;

        public static a a() {
            a a2 = f1507d.a();
            return a2 == null ? new a() : a2;
        }

        public static void b(a aVar) {
            aVar.f1508a = 0;
            aVar.f1509b = null;
            aVar.f1510c = null;
            f1507d.b(aVar);
        }
    }

    public interface b {
    }

    public void a(RecyclerView.d0 d0Var) {
        a orDefault = this.f1505a.getOrDefault(d0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f1505a.put(d0Var, orDefault);
        }
        orDefault.f1508a |= 1;
    }

    public void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a orDefault = this.f1505a.getOrDefault(d0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f1505a.put(d0Var, orDefault);
        }
        orDefault.f1510c = cVar;
        orDefault.f1508a |= 8;
    }

    public void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a orDefault = this.f1505a.getOrDefault(d0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f1505a.put(d0Var, orDefault);
        }
        orDefault.f1509b = cVar;
        orDefault.f1508a |= 4;
    }

    public boolean d(RecyclerView.d0 d0Var) {
        a orDefault = this.f1505a.getOrDefault(d0Var, null);
        return (orDefault == null || (orDefault.f1508a & 1) == 0) ? false : true;
    }

    public final RecyclerView.l.c e(RecyclerView.d0 d0Var, int i) {
        a k;
        RecyclerView.l.c cVar;
        int e2 = this.f1505a.e(d0Var);
        if (e2 >= 0 && (k = this.f1505a.k(e2)) != null) {
            int i2 = k.f1508a;
            if ((i2 & i) != 0) {
                k.f1508a = (~i) & i2;
                if (i == 4) {
                    cVar = k.f1509b;
                } else if (i == 8) {
                    cVar = k.f1510c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((k.f1508a & 12) == 0) {
                    this.f1505a.i(e2);
                    a.b(k);
                }
                return cVar;
            }
        }
        return null;
    }

    public void f(RecyclerView.d0 d0Var) {
        a orDefault = this.f1505a.getOrDefault(d0Var, null);
        if (orDefault != null) {
            orDefault.f1508a &= -2;
        }
    }

    public void g(RecyclerView.d0 d0Var) {
        int h = this.f1506b.h() - 1;
        while (true) {
            if (h < 0) {
                break;
            } else if (d0Var == this.f1506b.i(h)) {
                e<RecyclerView.d0> eVar = this.f1506b;
                Object[] objArr = eVar.f805d;
                Object obj = objArr[h];
                Object obj2 = e.f;
                if (obj != obj2) {
                    objArr[h] = obj2;
                    eVar.f803b = true;
                }
            } else {
                h--;
            }
        }
        a remove = this.f1505a.remove(d0Var);
        if (remove != null) {
            a.b(remove);
        }
    }
}
