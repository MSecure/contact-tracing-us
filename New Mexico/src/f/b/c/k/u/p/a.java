package f.b.c.k.u.p;

import f.b.c.d;
import f.b.c.k.u.o;
import f.b.d.a.a;
import f.b.d.a.s;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a implements o {
    public final List<s> a;

    /* renamed from: f.b.c.k.u.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0117a extends a {
        public C0117a(List<s> list) {
            super(list);
        }

        @Override // f.b.c.k.u.p.a
        public s d(s sVar) {
            a.b e2 = a.e(sVar);
            for (s sVar2 : this.a) {
                int i2 = 0;
                while (i2 < ((f.b.d.a.a) e2.instance).i()) {
                    if (o.c(((f.b.d.a.a) e2.instance).h(i2), sVar2)) {
                        e2.copyOnWrite();
                        f.b.d.a.a.e((f.b.d.a.a) e2.instance, i2);
                    } else {
                        i2++;
                    }
                }
            }
            s.b z = s.z();
            z.b(e2);
            return z.build();
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public b(List<s> list) {
            super(list);
        }

        @Override // f.b.c.k.u.p.a
        public s d(s sVar) {
            a.b e2 = a.e(sVar);
            for (s sVar2 : this.a) {
                if (!o.b(e2, sVar2)) {
                    e2.copyOnWrite();
                    f.b.d.a.a.c((f.b.d.a.a) e2.instance, sVar2);
                }
            }
            s.b z = s.z();
            z.b(e2);
            return z.build();
        }
    }

    public a(List<s> list) {
        this.a = Collections.unmodifiableList(list);
    }

    public static a.b e(s sVar) {
        return o.d(sVar) ? sVar.n().toBuilder() : f.b.d.a.a.j();
    }

    @Override // f.b.c.k.u.p.o
    public s a(s sVar) {
        return null;
    }

    @Override // f.b.c.k.u.p.o
    public s b(s sVar, s sVar2) {
        return d(sVar);
    }

    @Override // f.b.c.k.u.p.o
    public s c(s sVar, d dVar) {
        return d(sVar);
    }

    public abstract s d(s sVar);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode() + (getClass().hashCode() * 31);
    }
}
