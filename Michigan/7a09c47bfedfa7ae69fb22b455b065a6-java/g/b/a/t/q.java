package g.b.a.t;

import g.b.a.e;
import g.b.a.v.a;
import g.b.a.w.j;
import g.b.a.w.o;
import java.io.DataInput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class q extends a implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final q f6488e = new q(-1, e.f0(1868, 9, 8), "Meiji");

    /* renamed from: f  reason: collision with root package name */
    public static final q f6489f = new q(0, e.f0(1912, 7, 30), "Taisho");

    /* renamed from: g  reason: collision with root package name */
    public static final q f6490g = new q(1, e.f0(1926, 12, 25), "Showa");
    public static final q h = new q(2, e.f0(1989, 1, 8), "Heisei");
    public static final q i;
    public static final AtomicReference<q[]> j;

    /* renamed from: b  reason: collision with root package name */
    public final int f6491b;

    /* renamed from: c  reason: collision with root package name */
    public final transient e f6492c;

    /* renamed from: d  reason: collision with root package name */
    public final transient String f6493d;

    static {
        q qVar = new q(3, e.f0(2019, 5, 1), "Reiwa");
        i = qVar;
        j = new AtomicReference<>(new q[]{f6488e, f6489f, f6490g, h, qVar});
    }

    public q(int i2, e eVar, String str) {
        this.f6491b = i2;
        this.f6492c = eVar;
        this.f6493d = str;
    }

    public static q B(e eVar) {
        if (!eVar.a0(f6488e.f6492c)) {
            q[] qVarArr = j.get();
            for (int length = qVarArr.length - 1; length >= 0; length--) {
                q qVar = qVarArr[length];
                if (eVar.compareTo(qVar.f6492c) >= 0) {
                    return qVar;
                }
            }
            return null;
        }
        throw new g.b.a.a("Date too early: " + eVar);
    }

    public static q D(int i2) {
        q[] qVarArr = j.get();
        if (i2 >= f6488e.f6491b && i2 <= qVarArr[qVarArr.length - 1].f6491b) {
            return qVarArr[i2 + 1];
        }
        throw new g.b.a.a("japaneseEra is invalid");
    }

    public static q F(DataInput dataInput) {
        return D(dataInput.readByte());
    }

    public static q[] G() {
        q[] qVarArr = j.get();
        return (q[]) Arrays.copyOf(qVarArr, qVarArr.length);
    }

    private Object readResolve() {
        try {
            return D(this.f6491b);
        } catch (g.b.a.a e2) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e2);
            throw invalidObjectException;
        }
    }

    private Object writeReplace() {
        return new u((byte) 2, this);
    }

    public e A() {
        int i2 = this.f6491b + 1;
        q[] G = G();
        if (i2 >= G.length - 1) {
            return e.f6407f;
        }
        return G[i2 + 1].f6492c.d0(1);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        return jVar == g.b.a.w.a.ERA ? o.f6481e.F(g.b.a.w.a.ERA) : super.b(jVar);
    }

    public String toString() {
        return this.f6493d;
    }
}
