package e.c0.a0;

import android.text.TextUtils;
import e.c0.a0.t.e;
import e.c0.a0.t.t.b;
import e.c0.h;
import e.c0.n;
import e.c0.q;
import e.c0.u;
import e.c0.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g extends u {

    /* renamed from: j */
    public static final String f1092j = n.e("WorkContinuationImpl");
    public final l a;
    public final String b;
    public final h c;

    /* renamed from: d */
    public final List<? extends x> f1093d;

    /* renamed from: e */
    public final List<String> f1094e;

    /* renamed from: h */
    public boolean f1097h;

    /* renamed from: i */
    public q f1098i;

    /* renamed from: g */
    public final List<g> f1096g = null;

    /* renamed from: f */
    public final List<String> f1095f = new ArrayList();

    public g(l lVar, String str, h hVar, List<? extends x> list, List<g> list2) {
        this.a = lVar;
        this.b = str;
        this.c = hVar;
        this.f1093d = list;
        this.f1094e = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a = ((x) list.get(i2)).a();
            this.f1094e.add(a);
            this.f1095f.add(a);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1094e);
        Set<String> c = c(gVar);
        for (String str : set) {
            if (((HashSet) c).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.f1096g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1094e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f1096g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1094e);
            }
        }
        return hashSet;
    }

    public q a() {
        if (!this.f1097h) {
            e eVar = new e(this);
            ((b) this.a.f1106d).a.execute(eVar);
            this.f1098i = eVar.c;
        } else {
            n.c().f(f1092j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1094e)), new Throwable[0]);
        }
        return this.f1098i;
    }
}
