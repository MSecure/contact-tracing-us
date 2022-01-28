package b.s;

import android.content.Context;
import b.s.h;
import b.w.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.AbstractC0052c f2452a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2453b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2454c;

    /* renamed from: d  reason: collision with root package name */
    public final h.d f2455d;

    /* renamed from: e  reason: collision with root package name */
    public final List<h.b> f2456e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2457f;

    /* renamed from: g  reason: collision with root package name */
    public final h.c f2458g;
    public final Executor h;
    public final Executor i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final Set<Integer> m;

    public a(Context context, String str, c.AbstractC0052c cVar, h.d dVar, List<h.b> list, boolean z, h.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.f2452a = cVar;
        this.f2453b = context;
        this.f2454c = str;
        this.f2455d = dVar;
        this.f2456e = list;
        this.f2457f = z;
        this.f2458g = cVar2;
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
