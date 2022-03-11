package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.k.u.c;
import f.b.c.k.u.i;
import f.b.c.k.u.m;
/* loaded from: classes.dex */
public final class k {
    public static final k c = new k(null, null);
    public final m a;
    public final Boolean b;

    public k(m mVar, Boolean bool) {
        b.P0(mVar == null || bool == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.a = mVar;
        this.b = bool;
    }

    public static k a(boolean z) {
        return new k(null, Boolean.valueOf(z));
    }

    public boolean b() {
        return this.a == null && this.b == null;
    }

    public boolean c(i iVar) {
        m mVar = this.a;
        if (mVar == null) {
            Boolean bool = this.b;
            if (bool == null) {
                b.P0(b(), "Precondition should be empty", new Object[0]);
                return true;
            } else if (bool.booleanValue() == (iVar instanceof c)) {
                return true;
            } else {
                return false;
            }
        } else if (!(iVar instanceof c) || !iVar.b.equals(mVar)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        m mVar = this.a;
        if (mVar == null ? kVar.a != null : !mVar.equals(kVar.a)) {
            return false;
        }
        Boolean bool = this.b;
        Boolean bool2 = kVar.b;
        return bool != null ? bool.equals(bool2) : bool2 == null;
    }

    public int hashCode() {
        m mVar = this.a;
        int i2 = 0;
        int hashCode = (mVar != null ? mVar.hashCode() : 0) * 31;
        Boolean bool = this.b;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        Object obj;
        StringBuilder sb;
        if (b()) {
            return "Precondition{<none>}";
        }
        if (this.a != null) {
            sb = a.h("Precondition{updateTime=");
            obj = this.a;
        } else if (this.b != null) {
            sb = a.h("Precondition{exists=");
            obj = this.b;
        } else {
            b.r0("Invalid Precondition", new Object[0]);
            throw null;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
