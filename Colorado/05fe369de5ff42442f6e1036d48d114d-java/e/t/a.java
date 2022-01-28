package e.t;

import android.content.Context;
import e.t.g;
import e.v.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a {
    public final c.AbstractC0054c a;
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final g.d f1680d;

    /* renamed from: e  reason: collision with root package name */
    public final List<g.b> f1681e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1682f;

    /* renamed from: g  reason: collision with root package name */
    public final g.c f1683g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f1684h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f1685i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1686j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f1687k;

    /* renamed from: l  reason: collision with root package name */
    public final Set<Integer> f1688l;

    public a(Context context, String str, c.AbstractC0054c cVar, g.d dVar, List<g.b> list, boolean z, g.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.a = cVar;
        this.b = context;
        this.c = str;
        this.f1680d = dVar;
        this.f1681e = list;
        this.f1682f = z;
        this.f1683g = cVar2;
        this.f1684h = executor;
        this.f1685i = executor2;
        this.f1686j = z3;
        this.f1687k = z4;
        this.f1688l = set;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        return (!(i2 > i3) || !this.f1687k) && this.f1686j && ((set = this.f1688l) == null || !set.contains(Integer.valueOf(i2)));
    }
}
