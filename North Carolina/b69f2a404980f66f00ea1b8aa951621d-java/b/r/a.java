package b.r;

import android.content.Context;
import b.r.h;
import b.u.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.AbstractC0042c f1596a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1597b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1598c;

    /* renamed from: d  reason: collision with root package name */
    public final h.d f1599d;

    /* renamed from: e  reason: collision with root package name */
    public final List<h.b> f1600e;
    public final boolean f;
    public final h.c g;
    public final Executor h;
    public final Executor i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final Set<Integer> m;

    public a(Context context, String str, c.AbstractC0042c cVar, h.d dVar, List<h.b> list, boolean z, h.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.f1596a = cVar;
        this.f1597b = context;
        this.f1598c = str;
        this.f1599d = dVar;
        this.f1600e = list;
        this.f = z;
        this.g = cVar2;
        this.h = executor;
        this.i = executor2;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.m = set;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        if (!(i2 > i3) || !this.l) {
            return this.k && ((set = this.m) == null || !set.contains(Integer.valueOf(i2)));
        }
        return false;
    }
}
