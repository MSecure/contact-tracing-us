package f.b.a.b.h.b;

import f.a.a.a.a;
/* loaded from: classes.dex */
public final class m extends s {
    public final long a;

    public m(long j2) {
        this.a = j2;
    }

    @Override // f.b.a.b.h.b.s
    public long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof s) && this.a == ((s) obj).a();
    }

    public int hashCode() {
        long j2 = this.a;
        return 1000003 ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder h2 = a.h("LogResponse{nextRequestWaitMillis=");
        h2.append(this.a);
        h2.append("}");
        return h2.toString();
    }
}
