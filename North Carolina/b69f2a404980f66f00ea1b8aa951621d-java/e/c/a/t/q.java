package e.c.a.t;

import e.c.a.e;
import e.c.a.v.a;
import e.c.a.w.j;
import e.c.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class q extends a implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final q f5037e = new q(-1, e.P(1868, 9, 8), "Meiji");
    public static final q f = new q(0, e.P(1912, 7, 30), "Taisho");
    public static final q g = new q(1, e.P(1926, 12, 25), "Showa");
    public static final q h = new q(2, e.P(1989, 1, 8), "Heisei");
    public static final q i;
    public static final AtomicReference<q[]> j;

    /* renamed from: b  reason: collision with root package name */
    public final int f5038b;

    /* renamed from: c  reason: collision with root package name */
    public final transient e f5039c;

    /* renamed from: d  reason: collision with root package name */
    public final transient String f5040d;

    static {
        q qVar = new q(3, e.P(2019, 5, 1), "Reiwa");
        i = qVar;
        j = new AtomicReference<>(new q[]{f5037e, f, g, h, qVar});
    }

    public q(int i2, e eVar, String str) {
        this.f5038b = i2;
        this.f5039c = eVar;
        this.f5040d = str;
    }

    private Object readResolve() {
        try {
            return u(this.f5038b);
        } catch (e.c.a.a e2) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e2);
            throw invalidObjectException;
        }
    }

    public static q t(e eVar) {
        if (!eVar.K(f5037e.f5039c)) {
            q[] qVarArr = j.get();
            for (int length = qVarArr.length - 1; length >= 0; length--) {
                q qVar = qVarArr[length];
                if (eVar.compareTo(qVar.f5039c) >= 0) {
                    return qVar;
                }
            }
            return null;
        }
        throw new e.c.a.a("Date too early: " + eVar);
    }

    public static q u(int i2) {
        q[] qVarArr = j.get();
        if (i2 >= f5037e.f5038b && i2 <= qVarArr[qVarArr.length - 1].f5038b) {
            return qVarArr[i2 + 1];
        }
        throw new e.c.a.a("japaneseEra is invalid");
    }

    public static q v(DataInput dataInput) {
        return u(dataInput.readByte());
    }

    public static q[] w() {
        q[] qVarArr = j.get();
        return (q[]) Arrays.copyOf(qVarArr, qVarArr.length);
    }

    private Object writeReplace() {
        return new u((byte) 2, this);
    }

    @Override // e.c.a.v.c, e.c.a.w.e
    public o b(j jVar) {
        return jVar == e.c.a.w.a.ERA ? o.f5032e.x(e.c.a.w.a.ERA) : super.b(jVar);
    }

    public e s() {
        int i2 = this.f5038b + 1;
        q[] w = w();
        if (i2 >= w.length - 1) {
            return e.f;
        }
        return w[i2 + 1].f5039c.N(1);
    }

    public String toString() {
        return this.f5040d;
    }
}
