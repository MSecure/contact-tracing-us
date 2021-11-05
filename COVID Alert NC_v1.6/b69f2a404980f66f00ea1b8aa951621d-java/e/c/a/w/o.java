package e.c.a.w;

import e.c.a.a;
import java.io.Serializable;

public final class o implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final long f5182b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5183c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5184d;

    /* renamed from: e  reason: collision with root package name */
    public final long f5185e;

    public o(long j, long j2, long j3, long j4) {
        this.f5182b = j;
        this.f5183c = j2;
        this.f5184d = j3;
        this.f5185e = j4;
    }

    public static o d(long j, long j2) {
        if (j <= j2) {
            return new o(j, j, j2, j2);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static o e(long j, long j2, long j3) {
        return f(j, j, j2, j3);
    }

    public static o f(long j, long j2, long j3, long j4) {
        if (j > j2) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j3 > j4) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j2 <= j4) {
            return new o(j, j2, j3, j4);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public int a(long j, j jVar) {
        boolean z = true;
        if (!(this.f5182b >= -2147483648L && this.f5185e <= 2147483647L) || !c(j)) {
            z = false;
        }
        if (z) {
            return (int) j;
        }
        throw new a("Invalid int value for " + jVar + ": " + j);
    }

    public long b(long j, j jVar) {
        if (c(j)) {
            return j;
        }
        if (jVar != null) {
            throw new a("Invalid value for " + jVar + " (valid values " + this + "): " + j);
        }
        throw new a("Invalid value (valid values " + this + "): " + j);
    }

    public boolean c(long j) {
        return j >= this.f5182b && j <= this.f5185e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f5182b == oVar.f5182b && this.f5183c == oVar.f5183c && this.f5184d == oVar.f5184d && this.f5185e == oVar.f5185e;
    }

    public int hashCode() {
        long j = this.f5182b;
        long j2 = this.f5183c;
        long j3 = (j + j2) << ((int) (j2 + 16));
        long j4 = this.f5184d;
        long j5 = (j3 >> ((int) (j4 + 48))) << ((int) (j4 + 32));
        long j6 = this.f5185e;
        long j7 = ((j5 >> ((int) (32 + j6))) << ((int) (j6 + 48))) >> 16;
        return (int) (j7 ^ (j7 >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5182b);
        if (this.f5182b != this.f5183c) {
            sb.append('/');
            sb.append(this.f5183c);
        }
        sb.append(" - ");
        sb.append(this.f5184d);
        if (this.f5184d != this.f5185e) {
            sb.append('/');
            sb.append(this.f5185e);
        }
        return sb.toString();
    }
}
