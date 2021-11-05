package c.b.a.a.f;

import b.b.k.i;
import c.b.a.a.c.k.a;
import java.util.Arrays;

public final class a implements a.d {
    public static final a j = new a();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2826a = false;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2827b = false;

    /* renamed from: c  reason: collision with root package name */
    public final String f2828c = null;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2829d = false;

    /* renamed from: e  reason: collision with root package name */
    public final String f2830e = null;
    public final String f = null;
    public final boolean g = false;
    public final Long h = null;
    public final Long i = null;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2826a == aVar.f2826a && this.f2827b == aVar.f2827b && i.j.X(this.f2828c, aVar.f2828c) && this.f2829d == aVar.f2829d && this.g == aVar.g && i.j.X(this.f2830e, aVar.f2830e) && i.j.X(this.f, aVar.f) && i.j.X(this.h, aVar.h) && i.j.X(this.i, aVar.i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f2826a), Boolean.valueOf(this.f2827b), this.f2828c, Boolean.valueOf(this.f2829d), Boolean.valueOf(this.g), this.f2830e, this.f, this.h, this.i});
    }
}
