package e.t;

import android.content.Context;
import e.t.g;
import e.v.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a {
    public final c.AbstractC0055c a;
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final g.d f1832d;

    /* renamed from: e  reason: collision with root package name */
    public final List<g.b> f1833e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1834f;

    /* renamed from: g  reason: collision with root package name */
    public final g.c f1835g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f1836h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f1837i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1838j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f1839k;

    /* renamed from: l  reason: collision with root package name */
    public final Set<Integer> f1840l;

    public a(Context context, String str, c.AbstractC0055c cVar, g.d dVar, List<g.b> list, boolean z, g.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.a = cVar;
        this.b = context;
        this.c = str;
        this.f1832d = dVar;
        this.f1833e = list;
        this.f1834f = z;
        this.f1835g = cVar2;
        this.f1836h = executor;
        this.f1837i = executor2;
        this.f1838j = z3;
        this.f1839k = z4;
        this.f1840l = set;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        return (!(i2 > i3) || !this.f1839k) && this.f1838j && ((set = this.f1840l) == null || !set.contains(Integer.valueOf(i2)));
    }
}
