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
    public static final String f1016j = l.e("WorkContinuationImpl");
    public final l a;
    public final String b;
    public final e.b0.g c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends u> f1017d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f1018e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f1019f;

    /* renamed from: g  reason: collision with root package name */
    public final List<g> f1020g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1021h;

    /* renamed from: i  reason: collision with root package name */
    public o f1022i;

    public g(l lVar, String str, e.b0.g gVar, List<? extends u> list, List<g> list2) {
        this.a = lVar;
        this.b = str;
        this.c = gVar;
        this.f1017d = list;
        this.f1018e = new ArrayList(list.size());
        this.f1019f = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((u) list.get(i2)).a();
            this.f1018e.add(a2);
            this.f1019f.add(a2);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1018e);
        Set<String> c2 = c(gVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.f1020g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1018e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f1020g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1018e);
            }
        }
        return hashSet;
    }

    public o a() {
        if (!this.f1021h) {
            d dVar = new d(this);
            ((b) this.a.f1028d).a.execute(dVar);
            this.f1022i = dVar.c;
        } else {
            l.c().f(f1016j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1018e)), new Throwable[0]);
        }
        return this.f1022i;
    }
}
