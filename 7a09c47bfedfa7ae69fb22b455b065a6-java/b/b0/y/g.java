package b.b0.y;

import android.text.TextUtils;
import b.b0.f;
import b.b0.m;
import b.b0.p;
import b.b0.t;
import b.b0.w;
import b.b0.y.s.d;
import b.b0.y.s.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class g extends t {
    public static final String j = m.e("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    public final k f1077a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1078b;

    /* renamed from: c  reason: collision with root package name */
    public final f f1079c;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends w> f1080d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f1081e = new ArrayList(this.f1080d.size());

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f1082f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<g> f1083g = null;
    public boolean h;
    public p i;

    public g(k kVar, String str, f fVar, List<? extends w> list, List<g> list2) {
        this.f1077a = kVar;
        this.f1078b = str;
        this.f1079c = fVar;
        this.f1080d = list;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((w) list.get(i2)).a();
            this.f1081e.add(a2);
            this.f1082f.add(a2);
        }
    }

    public static boolean b(g gVar, Set<String> set) {
        set.addAll(gVar.f1081e);
        Set<String> c2 = c(gVar);
        for (String str : set) {
            if (((HashSet) c2).contains(str)) {
                return true;
            }
        }
        List<g> list = gVar.f1083g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                if (b(gVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.f1081e);
        return false;
    }

    public static Set<String> c(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> list = gVar.f1083g;
        if (list != null && !list.isEmpty()) {
            for (g gVar2 : list) {
                hashSet.addAll(gVar2.f1081e);
            }
        }
        return hashSet;
    }

    public p a() {
        if (!this.h) {
            d dVar = new d(this);
            ((b) this.f1077a.f1097d).f1334a.execute(dVar);
            this.i = dVar.f1262c;
        } else {
            m.c().f(j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f1081e)), new Throwable[0]);
        }
        return this.i;
    }
}
