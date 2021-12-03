package e.b0.a0;

import android.text.TextUtils;
import e.b0.a0.t.e;
import e.b0.a0.t.t.b;
import e.b0.h;
import e.b0.n;
import e.b0.q;
import e.b0.u;
import e.b0.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g extends u {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1013j = n.e("WorkContinuationImpl");
    public final l a;
    public final String b;
    public final h c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends x> f1014d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f1015e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f1016f;

    /* renamed from: g  reason: collision with root package name */
    public final List<g> f1017g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1018h;

    /* renamed from: i  reason: collision with root package name */
    public q f1019i;

    public g(l lVar, String str, h hVar, List<? extends x> list, List<g> list2) {
        this.a = lVar;
        this.b = str;
        this.c = hVar;
        this.f1014d = list;
        this.f1015e = new ArrayList(list.size());
        this.f1016f = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((x) list.get(i2)).a();
            this.f1015e.add(a2);
            this.f1016f.add(a2);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1015e);
        Set<String> c2 = c(gVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.f1017g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1015e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f1017g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1015e);
            }
        }
        return hashSet;
    }

    public q a() {
        if (!this.f1018h) {
            e eVar = new e(this);
            ((b) this.a.f1027d).a.execute(eVar);
            this.f1019i = eVar.c;
        } else {
            n.c().f(f1013j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1015e)), new Throwable[0]);
        }
        return this.f1019i;
    }
}
