package b.z.y;

import android.text.TextUtils;
import b.z.f;
import b.z.m;
import b.z.p;
import b.z.t;
import b.z.w;
import b.z.y.s.d;
import b.z.y.s.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g extends t {
    public static final String j = m.e("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    public final k f1955a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1956b;

    /* renamed from: c  reason: collision with root package name */
    public final f f1957c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends w> f1958d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f1959e = new ArrayList(this.f1958d.size());
    public final List<String> f = new ArrayList();
    public final List<g> g = null;
    public boolean h;
    public p i;

    public g(k kVar, String str, f fVar, List<? extends w> list, List<g> list2) {
        this.f1955a = kVar;
        this.f1956b = str;
        this.f1957c = fVar;
        this.f1958d = list;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((w) list.get(i2)).a();
            this.f1959e.add(a2);
            this.f.add(a2);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1959e);
        Set<String> c2 = c(gVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1959e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1959e);
            }
        }
        return hashSet;
    }

    public p a() {
        if (!this.h) {
            d dVar = new d(this);
            ((b) this.f1955a.f1972d).f2183a.execute(dVar);
            this.i = dVar.f2115c;
        } else {
            m.c().f(j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1959e)), new Throwable[0]);
        }
        return this.i;
    }
}
