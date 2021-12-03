package e.u;

import android.content.Context;
import e.u.g;
import e.w.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a {
    public final c.AbstractC0060c a;
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final g.d f1955d;

    /* renamed from: e  reason: collision with root package name */
    public final List<g.b> f1956e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1957f;

    /* renamed from: g  reason: collision with root package name */
    public final g.c f1958g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f1959h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f1960i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f1961j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f1962k;

    /* renamed from: l  reason: collision with root package name */
    public final Set<Integer> f1963l;

    public a(Context context, String str, c.AbstractC0060c cVar, g.d dVar, List<g.b> list, boolean z, g.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.a = cVar;
        this.b = context;
        this.c = str;
        this.f1955d = dVar;
        this.f1956e = list;
        this.f1957f = z;
        this.f1958g = cVar2;
        this.f1959h = executor;
        this.f1960i = executor2;
        this.f1961j = z3;
        this.f1962k = z4;
        this.f1963l = set;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        return (!(i2 > i3) || !this.f1962k) && this.f1961j && ((set = this.f1963l) == null || !set.contains(Integer.valueOf(i2)));
    }
}
