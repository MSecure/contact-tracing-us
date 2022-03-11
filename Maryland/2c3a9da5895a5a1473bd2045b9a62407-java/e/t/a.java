package e.t;

import android.content.Context;
import e.t.g;
import e.v.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a {
    public final c.AbstractC0059c a;
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final g.d f1864d;

    /* renamed from: e  reason: collision with root package name */
    public final List<g.b> f1865e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1866f;

    /* renamed from: g  reason: collision with root package name */
    public final g.c f1867g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f1868h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f1869i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1870j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f1871k;

    /* renamed from: l  reason: collision with root package name */
    public final Set<Integer> f1872l;

    public a(Context context, String str, c.AbstractC0059c cVar, g.d dVar, List<g.b> list, boolean z, g.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.a = cVar;
        this.b = context;
        this.c = str;
        this.f1864d = dVar;
        this.f1865e = list;
        this.f1866f = z;
        this.f1867g = cVar2;
        this.f1868h = executor;
        this.f1869i = executor2;
        this.f1870j = z3;
        this.f1871k = z4;
        this.f1872l = set;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        return (!(i2 > i3) || !this.f1871k) && this.f1870j && ((set = this.f1872l) == null || !set.contains(Integer.valueOf(i2)));
    }
}
