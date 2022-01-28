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

public final class q extends a implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final q f4352e;

    /* renamed from: f  reason: collision with root package name */
    public static final q f4353f;

    /* renamed from: g  reason: collision with root package name */
    public static final q f4354g;

    /* renamed from: h  reason: collision with root package name */
    public static final q f4355h;

    /* renamed from: i  reason: collision with root package name */
    public static final q f4356i;

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReference<q[]> f4357j;
    public final int b;
    public final transient f c;

    /* renamed from: d  reason: collision with root package name */
    public final transient String f4358d;

    static {
        q qVar = new q(-1, f.P(1868, 9, 8), "Meiji");
        f4352e = qVar;
        q qVar2 = new q(0, f.P(1912, 7, 30), "Taisho");
        f4353f = qVar2;
        q qVar3 = new q(1, f.P(1926, 12, 25), "Showa");
        f4354g = qVar3;
        q qVar4 = new q(2, f.P(1989, 1, 8), "Heisei");
        f4355h = qVar4;
        q qVar5 = new q(3, f.P(2019, 5, 1), "Reiwa");
        f4356i = qVar5;
        f4357j = new AtomicReference<>(new q[]{qVar, qVar2, qVar3, qVar4, qVar5});
    }

    public q(int i2, f fVar, String str) {
        this.b = i2;
        this.c = fVar;
        this.f4358d = str;
    }

    public static q r(f fVar) {
        if (!fVar.J(f4352e.c)) {
            q[] qVarArr = f4357j.get();
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
        q[] qVarArr = f4357j.get();
        if (i2 >= f4352e.b && i2 <= qVarArr[qVarArr.length - 1].b) {
            return qVarArr[i2 + 1];
        }
        throw new b("japaneseEra is invalid");
    }

    public static q[] t() {
        q[] qVarArr = f4357j.get();
        return (q[]) Arrays.copyOf(qVarArr, qVarArr.length);
    }

    private Object writeReplace() {
        return new u((byte) 2, this);
    }

    @Override // l.b.a.x.e, l.b.a.w.c
    public o a(j jVar) {
        l.b.a.x.a aVar = l.b.a.x.a.ERA;
        return jVar == aVar ? o.f4346e.u(aVar) : super.a(jVar);
    }

    public f q() {
        int i2 = this.b + 1;
        q[] t = t();
        if (i2 >= t.length - 1) {
            return f.f4293f;
        }
        return t[i2 + 1].c.M(1);
    }

    public String toString() {
        return this.f4358d;
    }
}
