package e.z.x;

import android.text.TextUtils;
import e.z.l;
import e.z.o;
import e.z.r;
import e.z.u;
import e.z.x.t.d;
import e.z.x.t.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g extends r {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1891j = l.e("WorkContinuationImpl");
    public final l a;
    public final String b;
    public final e.z.g c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends u> f1892d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f1893e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f1894f;

    /* renamed from: g  reason: collision with root package name */
    public final List<g> f1895g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1896h;

    /* renamed from: i  reason: collision with root package name */
    public o f1897i;

    public g(l lVar, String str, e.z.g gVar, List<? extends u> list, List<g> list2) {
        this.a = lVar;
        this.b = str;
        this.c = gVar;
        this.f1892d = list;
        this.f1893e = new ArrayList(list.size());
        this.f1894f = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((u) list.get(i2)).a();
            this.f1893e.add(a2);
            this.f1894f.add(a2);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1893e);
        Set<String> c2 = c(gVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.f1895g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1893e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f1895g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1893e);
            }
        }
        return hashSet;
    }

    public o a() {
        if (!this.f1896h) {
            d dVar = new d(this);
            ((b) this.a.f1903d).a.execute(dVar);
            this.f1897i = dVar.c;
        } else {
            l.c().f(f1891j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1893e)), new Throwable[0]);
        }
        return this.f1897i;
    }
}
