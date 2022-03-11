package f.b.c.k.s;

import f.a.a.a.a;
import f.b.c.k.u.b;
/* loaded from: classes.dex */
public final class e {
    public final b a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3537d;

    public e(b bVar, String str, String str2, boolean z) {
        this.a = bVar;
        this.b = str;
        this.c = str2;
        this.f3537d = z;
    }

    public String toString() {
        StringBuilder h2 = a.h("DatabaseInfo(databaseId:");
        h2.append(this.a);
        h2.append(" host:");
        return a.e(h2, this.c, ")");
    }
}
