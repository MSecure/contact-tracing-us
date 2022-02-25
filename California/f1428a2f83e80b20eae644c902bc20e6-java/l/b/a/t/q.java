package l.b.a.t;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import l.b.a.e;
import l.b.a.v.a;
import l.b.a.w.j;
import l.b.a.w.o;

public final class q extends a implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final q f4093e;

    /* renamed from: f  reason: collision with root package name */
    public static final q f4094f;

    /* renamed from: g  reason: collision with root package name */
    public static final q f4095g;

    /* renamed from: h  reason: collision with root package name */
    public static final q f4096h;

    /* renamed from: i  reason: collision with root package name */
    public static final q f4097i;

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReference<q[]> f4098j;
    public final int b;
    public final transient e c;

    /* renamed from: d  reason: collision with root package name */
    public final transient String f4099d;

    static {
        q qVar = new q(-1, e.P(1868, 9, 8), "Meiji");
        f4093e = qVar;
        q qVar2 = new q(0, e.P(1912, 7, 30), "Taisho");
        f4094f = qVar2;
        q qVar3 = new q(1, e.P(1926, 12, 25), "Showa");
        f4095g = qVar3;
        q qVar4 = new q(2, e.P(1989, 1, 8), "Heisei");
        f4096h = qVar4;
        q qVar5 = new q(3, e.P(2019, 5, 1), "Reiwa");
        f4097i = qVar5;
        f4098j = new AtomicReference<>(new q[]{qVar, qVar2, qVar3, qVar4, qVar5});
    }

    public q(int i2, e eVar, String str) {
        this.b = i2;
        this.c = eVar;
        this.f4099d = str;
    }

    public static q r(e eVar) {
        if (!eVar.J(f4093e.c)) {
            q[] qVarArr = f4098j.get();
            for (int length = qVarArr.length - 1; length >= 0; length--) {
                q qVar = qVarArr[length];
                if (eVar.compareTo(qVar.c) >= 0) {
                    return qVar;
                }
            }
            return null;
        }
        throw new l.b.a.a("Date too early: " + eVar);
    }

    private Object readResolve() {
        try {
            return s(this.b);
        } catch (l.b.a.a e2) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e2);
            throw invalidObjectException;
        }
    }

    public static q s(int i2) {
        q[] qVarArr = f4098j.get();
        if (i2 >= f4093e.b && i2 <= qVarArr[qVarArr.length - 1].b) {
            return qVarArr[i2 + 1];
        }
        throw new l.b.a.a("japaneseEra is invalid");
    }

    public static q[] t() {
        q[] qVarArr = f4098j.get();
        return (q[]) Arrays.copyOf(qVarArr, qVarArr.length);
    }

    private Object writeReplace() {
        return new u((byte) 2, this);
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        l.b.a.w.a aVar = l.b.a.w.a.ERA;
        return jVar == aVar ? o.f4087e.u(aVar) : super.a(jVar);
    }

    public e q() {
        int i2 = this.b + 1;
        q[] t = t();
        if (i2 >= t.length - 1) {
            return e.f4034f;
        }
        return t[i2 + 1].c.M(1);
    }

    public String toString() {
        return this.f4099d;
    }
}
