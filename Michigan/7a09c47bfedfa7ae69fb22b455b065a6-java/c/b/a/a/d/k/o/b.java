package c.b.a.a.d.k.o;

import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.a.d;
import java.util.Arrays;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    public final int f2952a;

    /* renamed from: b  reason: collision with root package name */
    public final a<O> f2953b;

    /* renamed from: c  reason: collision with root package name */
    public final O f2954c;

    public b(a<O> aVar, O o) {
        this.f2953b = aVar;
        this.f2954c = o;
        this.f2952a = Arrays.hashCode(new Object[]{aVar, o});
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return t.j1(this.f2953b, bVar.f2953b) && t.j1(this.f2954c, bVar.f2954c);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.f2952a;
    }
}
