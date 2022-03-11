package f.b.a.c.b.l.l;

import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.a.c;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b<O extends a.c> {
    public final int a;
    public final a<O> b;
    public final O c;

    public b(a<O> aVar, O o) {
        this.b = aVar;
        this.c = o;
        this.a = Arrays.hashCode(new Object[]{aVar, o});
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
        return m.e.X(this.b, bVar.b) && m.e.X(this.c, bVar.c);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.a;
    }
}
