package f.b.a.b.h.b;

import f.a.a.a.a;

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
        StringBuilder i2 = a.i("LogResponse{nextRequestWaitMillis=");
        i2.append(this.a);
        i2.append("}");
        return i2.toString();
    }
}
