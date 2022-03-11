package l.b.a.u;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import l.b.a.b;
import l.b.a.f;
import l.b.a.h;
import l.b.a.x.a;
import l.b.a.x.d;
import l.b.a.x.i;
import l.b.a.x.j;
import l.b.a.x.m;
import l.b.a.x.n;
import l.b.a.x.o;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public final class p extends a<p> implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final f f4670e = f.P(1873, 1, 1);
    public final f b;
    public transient q c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f4671d;

    public p(f fVar) {
        if (!fVar.J(f4670e)) {
            q r = q.r(fVar);
            this.c = r;
            this.f4671d = fVar.b - (r.c.b - 1);
            this.b = fVar;
            return;
        }
        throw new b("Minimum supported date is January 1st Meiji 6");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        q r = q.r(this.b);
        this.c = r;
        this.f4671d = this.b.b - (r.c.b - 1);
    }

    private Object writeReplace() {
        return new u((byte) 1, this);
    }

    @Override // l.b.a.u.a
    public a<p> A(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    public a B(long j2) {
        return G(this.b.V(j2));
    }

    public a C(long j2) {
        return G(this.b.W(j2));
    }

    public a D(long j2) {
        return G(this.b.Y(j2));
    }

    public final o E(int i2) {
        Calendar instance = Calendar.getInstance(o.f4665d);
        instance.set(0, this.c.b + 2);
        int i3 = this.f4671d;
        f fVar = this.b;
        instance.set(i3, fVar.c - 1, fVar.f4615d);
        return o.d((long) instance.getActualMinimum(i2), (long) instance.getActualMaximum(i2));
    }

    public final long F() {
        return (long) (this.f4671d == 1 ? (this.b.H() - this.c.c.H()) + 1 : this.b.H());
    }

    public final p G(f fVar) {
        return fVar.equals(this.b) ? this : new p(fVar);
    }

    /* renamed from: H */
    public p z(j jVar, long j2) {
        if (!(jVar instanceof a)) {
            return (p) jVar.c(this, j2);
        }
        a aVar = (a) jVar;
        if (i(aVar) == j2) {
            return this;
        }
        int ordinal = aVar.ordinal();
        if (ordinal == 19 || ordinal == 25 || ordinal == 27) {
            int a = o.f4666e.u(aVar).a(j2, aVar);
            int ordinal2 = aVar.ordinal();
            if (ordinal2 == 19) {
                return G(this.b.V(((long) a) - F()));
            }
            if (ordinal2 == 25) {
                return I(this.c, a);
            }
            if (ordinal2 == 27) {
                return I(q.s(a), this.f4671d);
            }
        }
        return G(this.b.z(jVar, j2));
    }

    public final p I(q qVar, int i2) {
        Objects.requireNonNull(o.f4666e);
        if (qVar instanceof q) {
            o.d(1, (long) ((qVar.q().b - qVar.c.b) + 1)).b((long) i2, a.YEAR_OF_ERA);
            return G(this.b.c0((qVar.c.b + i2) - 1));
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    public o a(j jVar) {
        int i2;
        if (!(jVar instanceof a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            a aVar = (a) jVar;
            int ordinal = aVar.ordinal();
            if (ordinal == 19) {
                i2 = 6;
            } else if (ordinal != 25) {
                return o.f4666e.u(aVar);
            } else {
                i2 = 1;
            }
            return E(i2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    public d e(l.b.a.x.f fVar) {
        return (p) o.f4666e.e(fVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return this.b.equals(((p) obj).b);
        }
        return false;
    }

    public boolean f(j jVar) {
        if (jVar == a.ALIGNED_DAY_OF_WEEK_IN_MONTH || jVar == a.ALIGNED_DAY_OF_WEEK_IN_YEAR || jVar == a.ALIGNED_WEEK_OF_MONTH || jVar == a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.f(jVar);
    }

    public d h(long j2, m mVar) {
        return (p) super.h(j2, mVar);
    }

    public int hashCode() {
        Objects.requireNonNull(o.f4666e);
        return -688086063 ^ this.b.hashCode();
    }

    public long i(j jVar) {
        if (!(jVar instanceof a)) {
            return jVar.f(this);
        }
        int ordinal = ((a) jVar).ordinal();
        if (!(ordinal == 16 || ordinal == 17)) {
            if (ordinal == 19) {
                return F();
            }
            if (ordinal == 25) {
                return (long) this.f4671d;
            }
            if (ordinal == 27) {
                return (long) this.c.b;
            }
            if (!(ordinal == 21 || ordinal == 22)) {
                return this.b.i(jVar);
            }
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    public d m(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    public final c<p> q(h hVar) {
        return new d(this, hVar);
    }

    public h s() {
        return o.f4666e;
    }

    public i t() {
        return this.c;
    }

    public b u(long j2, m mVar) {
        return (p) super.h(j2, mVar);
    }

    public b v(long j2, m mVar) {
        return (p) super.v(j2, mVar);
    }

    public b w(i iVar) {
        return (p) o.f4666e.e(((l.b.a.m) iVar).b(this));
    }

    public long x() {
        return this.b.x();
    }

    public b y(l.b.a.x.f fVar) {
        return (p) o.f4666e.e(fVar.n(this));
    }
}
