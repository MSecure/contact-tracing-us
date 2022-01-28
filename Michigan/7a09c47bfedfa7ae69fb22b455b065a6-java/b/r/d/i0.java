package b.r.d;

import androidx.recyclerview.widget.RecyclerView;
import b.e.e;
import b.e.h;

public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final h<RecyclerView.a0, a> f2355a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final e<RecyclerView.a0> f2356b = new e<>();

    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static b.i.k.b<a> f2357d = new b.i.k.b<>(20);

        /* renamed from: a  reason: collision with root package name */
        public int f2358a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.j.c f2359b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.j.c f2360c;

        public static a a() {
            a a2 = f2357d.a();
            return a2 == null ? new a() : a2;
        }

        public static void b(a aVar) {
            aVar.f2358a = 0;
            aVar.f2359b = null;
            aVar.f2360c = null;
            f2357d.b(aVar);
        }
    }

    public interface b {
    }

    public void a(RecyclerView.a0 a0Var) {
        a orDefault = this.f2355a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f2355a.put(a0Var, orDefault);
        }
        orDefault.f2358a |= 1;
    }

    public void b(RecyclerView.a0 a0Var, RecyclerView.j.c cVar) {
        a orDefault = this.f2355a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f2355a.put(a0Var, orDefault);
        }
        orDefault.f2360c = cVar;
        orDefault.f2358a |= 8;
    }

    public void c(RecyclerView.a0 a0Var, RecyclerView.j.c cVar) {
        a orDefault = this.f2355a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f2355a.put(a0Var, orDefault);
        }
        orDefault.f2359b = cVar;
        orDefault.f2358a |= 4;
    }

    public boolean d(RecyclerView.a0 a0Var) {
        a orDefault = this.f2355a.getOrDefault(a0Var, null);
        return (orDefault == null || (orDefault.f2358a & 1) == 0) ? false : true;
    }

    public final RecyclerView.j.c e(RecyclerView.a0 a0Var, int i) {
        a k;
        RecyclerView.j.c cVar;
        int e2 = this.f2355a.e(a0Var);
        if (e2 >= 0 && (k = this.f2355a.k(e2)) != null) {
            int i2 = k.f2358a;
            if ((i2 & i) != 0) {
                k.f2358a = (~i) & i2;
                if (i == 4) {
                    cVar = k.f2359b;
                } else if (i == 8) {
                    cVar = k.f2360c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((k.f2358a & 12) == 0) {
                    this.f2355a.i(e2);
                    a.b(k);
                }
                return cVar;
            }
        }
        return null;
    }

    public void f(RecyclerView.a0 a0Var) {
        a orDefault = this.f2355a.getOrDefault(a0Var, null);
        if (orDefault != null) {
            orDefault.f2358a &= -2;
        }
    }

    public void g(RecyclerView.a0 a0Var) {
        int h = this.f2356b.h() - 1;
        while (true) {
            if (h < 0) {
                break;
            } else if (a0Var == this.f2356b.i(h)) {
                e<RecyclerView.a0> eVar = this.f2356b;
                Object[] objArr = eVar.f1384d;
                Object obj = objArr[h];
                Object obj2 = e.f1381f;
                if (obj != obj2) {
                    objArr[h] = obj2;
                    eVar.f1382b = true;
                }
            } else {
                h--;
            }
        }
        a remove = this.f2355a.remove(a0Var);
        if (remove != null) {
            a.b(remove);
        }
    }
}
