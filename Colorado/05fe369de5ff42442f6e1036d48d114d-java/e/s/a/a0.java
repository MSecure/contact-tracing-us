package e.s.a;

import androidx.recyclerview.widget.RecyclerView;
import e.e.e;
import e.e.h;

public class a0 {
    public final h<RecyclerView.b0, a> a = new h<>();
    public final e<RecyclerView.b0> b = new e<>();

    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static e.i.h.b<a> f1607d = new e.i.h.b<>(20);
        public int a;
        public RecyclerView.j.c b;
        public RecyclerView.j.c c;

        public static a a() {
            a a2 = f1607d.a();
            return a2 == null ? new a() : a2;
        }

        public static void b(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            f1607d.b(aVar);
        }
    }

    public interface b {
    }

    public void a(RecyclerView.b0 b0Var) {
        a orDefault = this.a.getOrDefault(b0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(b0Var, orDefault);
        }
        orDefault.a |= 1;
    }

    public void b(RecyclerView.b0 b0Var, RecyclerView.j.c cVar) {
        a orDefault = this.a.getOrDefault(b0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(b0Var, orDefault);
        }
        orDefault.c = cVar;
        orDefault.a |= 8;
    }

    public void c(RecyclerView.b0 b0Var, RecyclerView.j.c cVar) {
        a orDefault = this.a.getOrDefault(b0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(b0Var, orDefault);
        }
        orDefault.b = cVar;
        orDefault.a |= 4;
    }

    public boolean d(RecyclerView.b0 b0Var) {
        a orDefault = this.a.getOrDefault(b0Var, null);
        return (orDefault == null || (orDefault.a & 1) == 0) ? false : true;
    }

    public final RecyclerView.j.c e(RecyclerView.b0 b0Var, int i2) {
        a k2;
        RecyclerView.j.c cVar;
        int e2 = this.a.e(b0Var);
        if (e2 >= 0 && (k2 = this.a.k(e2)) != null) {
            int i3 = k2.a;
            if ((i3 & i2) != 0) {
                int i4 = (~i2) & i3;
                k2.a = i4;
                if (i2 == 4) {
                    cVar = k2.b;
                } else if (i2 == 8) {
                    cVar = k2.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i4 & 12) == 0) {
                    this.a.i(e2);
                    a.b(k2);
                }
                return cVar;
            }
        }
        return null;
    }

    public void f(RecyclerView.b0 b0Var) {
        a orDefault = this.a.getOrDefault(b0Var, null);
        if (orDefault != null) {
            orDefault.a &= -2;
        }
    }

    public void g(RecyclerView.b0 b0Var) {
        int h2 = this.b.h() - 1;
        while (true) {
            if (h2 < 0) {
                break;
            } else if (b0Var == this.b.i(h2)) {
                e<RecyclerView.b0> eVar = this.b;
                Object[] objArr = eVar.f1007d;
                Object obj = objArr[h2];
                Object obj2 = e.f1006f;
                if (obj != obj2) {
                    objArr[h2] = obj2;
                    eVar.b = true;
                }
            } else {
                h2--;
            }
        }
        a remove = this.a.remove(b0Var);
        if (remove != null) {
            a.b(remove);
        }
    }
}
