package l.b.a.u;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import l.b.a.b;
import l.b.a.f;
import l.b.a.w.a;
import l.b.a.x.j;
import l.b.a.x.o;
/* loaded from: classes.dex */
public final class q extends a implements Serializable {

    /* renamed from: e */
    public static final q f4672e;

    /* renamed from: f */
    public static final q f4673f;

    /* renamed from: g */
    public static final q f4674g;

    /* renamed from: h */
    public static final q f4675h;

    /* renamed from: i */
    public static final q f4676i;

    /* renamed from: j */
    public static final AtomicReference<q[]> f4677j;
    public final int b;
    public final transient f c;

    /* renamed from: d */
    public final transient String f4678d;

    static {
        q qVar = new q(-1, f.P(1868, 9, 8), "Meiji");
        f4672e = qVar;
        q qVar2 = new q(0, f.P(1912, 7, 30), "Taisho");
        f4673f = qVar2;
        q qVar3 = new q(1, f.P(1926, 12, 25), "Showa");
        f4674g = qVar3;
        q qVar4 = new q(2, f.P(1989, 1, 8), "Heisei");
        f4675h = qVar4;
        q qVar5 = new q(3, f.P(2019, 5, 1), "Reiwa");
        f4676i = qVar5;
        f4677j = new AtomicReference<>(new q[]{qVar, qVar2, qVar3, qVar4, qVar5});
    }

    public q(int i2, f fVar, String str) {
        this.b = i2;
        this.c = fVar;
        this.f4678d = str;
    }

    public static q r(f fVar) {
        if (!fVar.J(f4672e.c)) {
            q[] qVarArr = f4677j.get();
            for (int length = qVarArr.length - 1; length >= 0; length--) {
                q qVar = qVarArr[length];
                if (fVar.compareTo(qVar.c) >= 0) {
                    return qVar;
                }
            }
            return null;
        }
        throw new b("Date too early: " + fVar);
    }

    private Object readResolve() {
        try {
            return s(this.b);
        } catch (b e2) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e2);
            throw invalidObjectException;
        }
    }

    public static q s(int i2) {
        q[] qVarArr = f4677j.get();
        if (i2 >= f4672e.b && i2 <= qVarArr[qVarArr.length - 1].b) {
            return qVarArr[i2 + 1];
        }
        throw new b("japaneseEra is invalid");
    }

    public static q[] t() {
        q[] qVarArr = f4677j.get();
        return (q[]) Arrays.copyOf(qVarArr, qVarArr.length);
    }

    private Object writeReplace() {
        return new u((byte) 2, this);
    }

    @Override // l.b.a.w.c, l.b.a.x.e
    public o a(j jVar) {
        l.b.a.x.a aVar = l.b.a.x.a.ERA;
        return jVar == aVar ? o.f4666e.u(aVar) : super.a(jVar);
    }

    public f q() {
        int i2 = this.b + 1;
        q[] t = t();
        if (i2 >= t.length - 1) {
            return f.f4613f;
        }
        return t[i2 + 1].c.M(1);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.f4678d;
    }
}
