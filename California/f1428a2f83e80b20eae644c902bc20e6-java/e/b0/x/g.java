package e.b0.x;

import android.text.TextUtils;
import e.b0.l;
import e.b0.o;
import e.b0.r;
import e.b0.u;
import e.b0.x.t.d;
import e.b0.x.t.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g extends r {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1017j = l.e("WorkContinuationImpl");
    public final l a;
    public final String b;
    public final e.b0.g c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends u> f1018d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f1019e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f1020f;

    /* renamed from: g  reason: collision with root package name */
    public final List<g> f1021g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1022h;

    /* renamed from: i  reason: collision with root package name */
    public o f1023i;

    public g(l lVar, String str, e.b0.g gVar, List<? extends u> list, List<g> list2) {
        this.a = lVar;
        this.b = str;
        this.c = gVar;
        this.f1018d = list;
        this.f1019e = new ArrayList(list.size());
        this.f1020f = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((u) list.get(i2)).a();
            this.f1019e.add(a2);
            this.f1020f.add(a2);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1019e);
        Set<String> c2 = c(gVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.f1021g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1019e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f1021g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1019e);
            }
        }
        return hashSet;
    }

    public o a() {
        if (!this.f1022h) {
            d dVar = new d(this);
            ((b) this.a.f1029d).a.execute(dVar);
            this.f1023i = dVar.c;
        } else {
            l.c().f(f1017j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1019e)), new Throwable[0]);
        }
        return this.f1023i;
    }
}
