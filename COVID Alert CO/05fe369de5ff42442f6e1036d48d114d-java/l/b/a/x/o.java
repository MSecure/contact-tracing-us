package l.b.a.x;

import java.io.Serializable;
import l.b.a.b;

public final class o implements Serializable {
    public final long b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4461d;

    /* renamed from: e  reason: collision with root package name */
    public final long f4462e;

    public o(long j2, long j3, long j4, long j5) {
        this.b = j2;
        this.c = j3;
        this.f4461d = j4;
        this.f4462e = j5;
    }

    public static o d(long j2, long j3) {
        if (j2 <= j3) {
            return new o(j2, j2, j3, j3);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static o e(long j2, long j3, long j4) {
        return f(j2, j2, j3, j4);
    }

    public static o f(long j2, long j3, long j4, long j5) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j4 > j5) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j3 <= j5) {
            return new o(j2, j3, j4, j5);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public int a(long j2, j jVar) {
        boolean z = false;
        if ((this.b >= -2147483648L && this.f4462e <= 2147483647L) && c(j2)) {
            z = true;
        }
        if (z) {
            return (int) j2;
        }
        throw new b("Invalid int value for " + jVar + ": " + j2);
    }

    public long b(long j2, j jVar) {
        if (c(j2)) {
            return j2;
        }
        if (jVar != null) {
            throw new b("Invalid value for " + jVar + " (valid values " + this + "): " + j2);
        }
        throw new b("Invalid value (valid values " + this + "): " + j2);
    }

    public boolean c(long j2) {
        return j2 >= this.b && j2 <= this.f4462e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.b == oVar.b && this.c == oVar.c && this.f4461d == oVar.f4461d && this.f4462e == oVar.f4462e;
    }

    public int hashCode() {
        long j2 = this.b;
        long j3 = this.c;
        long j4 = this.f4461d;
        long j5 = this.f4462e;
        long j6 = ((((((j2 + j3) << ((int) (j3 + 16))) >> ((int) (j4 + 48))) << ((int) (j4 + 32))) >> ((int) (32 + j5))) << ((int) (j5 + 48))) >> 16;
        return (int) (j6 ^ (j6 >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        if (this.b != this.c) {
            sb.append('/');
            sb.append(this.c);
        }
        sb.append(" - ");
        sb.append(this.f4461d);
        if (this.f4461d != this.f4462e) {
            sb.append('/');
            sb.append(this.f4462e);
        }
        return sb.toString();
    }
}
