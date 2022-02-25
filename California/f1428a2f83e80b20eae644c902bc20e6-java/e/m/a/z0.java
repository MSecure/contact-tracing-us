package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import e.i.e.a;
import e.m.a.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class z0 {
    public final ViewGroup a;
    public final ArrayList<d> b = new ArrayList<>();
    public final HashMap<l, d> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1695d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1696e = false;

    public class a implements a.AbstractC0031a {
        public final /* synthetic */ c a;
        public final /* synthetic */ e.i.e.a b;

        public a(c cVar, e.i.e.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // e.i.e.a.AbstractC0031a
        public void a() {
            synchronized (z0.this.b) {
                z0.this.b.remove(this.a);
                z0.this.c.remove(this.a.c);
                this.b.a();
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ c b;

        public b(c cVar) {
            this.b = cVar;
        }

        public void run() {
            if (!this.b.f1698d.b()) {
                z0.this.c.remove(this.b.c);
            }
        }
    }

    public static class c extends d {

        /* renamed from: f  reason: collision with root package name */
        public final j0 f1697f;

        public c(d.c cVar, d.b bVar, j0 j0Var, e.i.e.a aVar) {
            super(cVar, bVar, j0Var.c, aVar);
            this.f1697f = j0Var;
        }

        @Override // e.m.a.z0.d
        public void a() {
            super.a();
            this.f1697f.j();
        }
    }

    public static class d {
        public c a;
        public b b;
        public final l c;

        /* renamed from: d  reason: collision with root package name */
        public final e.i.e.a f1698d = new e.i.e.a();

        /* renamed from: e  reason: collision with root package name */
        public final List<Runnable> f1699e = new ArrayList();

        public class a implements a.AbstractC0031a {
            public a() {
            }

            @Override // e.i.e.a.AbstractC0031a
            public void a() {
                d.this.f1698d.a();
            }
        }

        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c b(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException(f.a.a.a.a.q("Unknown visibility ", i2));
            }

            public static c c(View view) {
                return b(view.getVisibility());
            }

            public void a(View view) {
                int i2;
                int ordinal = ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        i2 = 0;
                    } else if (ordinal == 2) {
                        i2 = 8;
                    } else if (ordinal == 3) {
                        i2 = 4;
                    } else {
                        return;
                    }
                    view.setVisibility(i2);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
        }

        public d(c cVar, b bVar, l lVar, e.i.e.a aVar) {
            this.a = cVar;
            this.b = bVar;
            this.c = lVar;
            aVar.c(new a());
        }

        public void a() {
            for (Runnable runnable : this.f1699e) {
                runnable.run();
            }
        }
    }

    public z0(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static z0 e(ViewGroup viewGroup, b1 b1Var) {
        int i2 = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof z0) {
            return (z0) tag;
        }
        Objects.requireNonNull((c0.f) b1Var);
        d dVar = new d(viewGroup);
        viewGroup.setTag(i2, dVar);
        return dVar;
    }

    public final void a(d.c cVar, d.b bVar, j0 j0Var, e.i.e.a aVar) {
        d.b bVar2;
        if (!aVar.b()) {
            synchronized (this.b) {
                e.i.e.a aVar2 = new e.i.e.a();
                d dVar = this.c.get(j0Var.c);
                if (dVar != null) {
                    d.c cVar2 = d.c.REMOVED;
                    int ordinal = bVar.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                dVar.a = cVar2;
                                bVar2 = d.b.REMOVING;
                            }
                        } else if (dVar.a == cVar2) {
                            dVar.a = d.c.VISIBLE;
                            bVar2 = d.b.ADDING;
                        }
                        dVar.b = bVar2;
                    } else if (dVar.a != cVar2) {
                        dVar.a = cVar;
                    }
                    aVar.c(new a1(dVar));
                    return;
                }
                c cVar3 = new c(cVar, bVar, j0Var, aVar2);
                this.b.add(cVar3);
                this.c.put(cVar3.c, cVar3);
                aVar.c(new a(cVar3, aVar2));
                cVar3.f1699e.add(new b(cVar3));
            }
        }
    }

    public abstract void b(List<d> list, boolean z);

    public void c() {
        if (!this.f1696e) {
            synchronized (this.b) {
                if (!this.b.isEmpty()) {
                    b(new ArrayList(this.b), this.f1695d);
                    this.b.clear();
                    this.f1695d = false;
                }
            }
        }
    }

    public void d() {
        synchronized (this.b) {
            for (d dVar : this.c.values()) {
                dVar.f1698d.a();
                dVar.a.a(dVar.c.F);
                dVar.a();
            }
            this.c.clear();
            this.b.clear();
        }
    }

    public void f() {
        synchronized (this.b) {
            this.f1696e = false;
            int size = this.b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = this.b.get(size);
                d.c c2 = d.c.c(dVar.c.F);
                d.c cVar = dVar.a;
                d.c cVar2 = d.c.VISIBLE;
                if (cVar == cVar2 && c2 != cVar2) {
                    this.f1696e = dVar.c.F();
                    break;
                }
                size--;
            }
        }
    }
}
