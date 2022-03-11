package e.v;

import android.content.Context;
import e.v.g;
import e.x.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class a {
    public final c.AbstractC0064c a;
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final g.d f2040d;

    /* renamed from: e  reason: collision with root package name */
    public final List<g.b> f2041e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2042f;

    /* renamed from: g  reason: collision with root package name */
    public final g.c f2043g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f2044h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f2045i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f2046j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f2047k;

    /* renamed from: l  reason: collision with root package name */
    public final Set<Integer> f2048l;

    public a(Context context, String str, c.AbstractC0064c cVar, g.d dVar, List<g.b> list, boolean z, g.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.a = cVar;
        this.b = context;
        this.c = str;
        this.f2040d = dVar;
        this.f2041e = list;
        this.f2042f = z;
        this.f2043g = cVar2;
        this.f2044h = executor;
        this.f2045i = executor2;
        this.f2046j = z3;
        this.f2047k = z4;
        this.f2048l = set;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        return (!(i2 > i3) || !this.f2047k) && this.f2046j && ((set = this.f2048l) == null || !set.contains(Integer.valueOf(i2)));
    }
}
