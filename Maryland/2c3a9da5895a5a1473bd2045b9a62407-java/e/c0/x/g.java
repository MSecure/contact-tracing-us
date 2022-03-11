package e.c0.x;

import android.text.TextUtils;
import e.c0.l;
import e.c0.o;
import e.c0.r;
import e.c0.u;
import e.c0.x.t.d;
import e.c0.x.t.q.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g extends r {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1036j = l.e("WorkContinuationImpl");
    public final l a;
    public final String b;
    public final e.c0.g c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends u> f1037d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f1038e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f1039f;

    /* renamed from: g  reason: collision with root package name */
    public final List<g> f1040g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1041h;

    /* renamed from: i  reason: collision with root package name */
    public o f1042i;

    public g(l lVar, String str, e.c0.g gVar, List<? extends u> list, List<g> list2) {
        this.a = lVar;
        this.b = str;
        this.c = gVar;
        this.f1037d = list;
        this.f1038e = new ArrayList(list.size());
        this.f1039f = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((u) list.get(i2)).a();
            this.f1038e.add(a2);
            this.f1039f.add(a2);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1038e);
        Set<String> c2 = c(gVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.f1040g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1038e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f1040g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1038e);
            }
        }
        return hashSet;
    }

    public o a() {
        if (!this.f1041h) {
            d dVar = new d(this);
            ((b) this.a.f1048d).a.execute(dVar);
            this.f1042i = dVar.c;
        } else {
            l.c().f(f1036j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1038e)), new Throwable[0]);
        }
        return this.f1042i;
    }
}
