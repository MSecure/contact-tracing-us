package f.b.c.k.s;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.k.u.h;
import f.b.c.k.u.p.d;
import f.b.c.k.u.p.o;

public class g0 {
    public final f0 a;
    public final h b;
    public final boolean c;

    public g0(f0 f0Var, h hVar, boolean z) {
        this.a = f0Var;
        this.b = hVar;
        this.c = z;
    }

    public g0(f0 f0Var, h hVar, boolean z, e0 e0Var) {
        this.a = f0Var;
        this.b = hVar;
        this.c = z;
    }

    public void a(h hVar) {
        this.a.b.add(hVar);
    }

    public void b(h hVar, o oVar) {
        this.a.c.add(new d(hVar, oVar));
    }

    public RuntimeException c(String str) {
        String str2;
        h hVar = this.b;
        if (hVar == null || hVar.l()) {
            str2 = "";
        } else {
            StringBuilder i2 = a.i(" (found in field ");
            i2.append(this.b.c());
            i2.append(")");
            str2 = i2.toString();
        }
        return new IllegalArgumentException(a.d("Invalid data. ", str, str2));
    }

    public boolean d() {
        int ordinal = this.a.a.ordinal();
        if (ordinal == 0 || ordinal == 1 || ordinal == 2) {
            return true;
        }
        if (ordinal == 3 || ordinal == 4) {
            return false;
        }
        b.q0("Unexpected case for UserDataSource: %s", this.a.a.name());
        throw null;
    }
}
