package f.b.c.k.w;

import f.b.c.g.a.d;
import f.b.c.k.s.c0;
import f.b.c.k.s.v;
import f.b.c.k.t.d1;
import f.b.c.k.t.h0;
import f.b.c.k.t.n;
import f.b.c.k.t.r;
import f.b.c.k.u.i;
import f.b.c.k.u.j;
import f.b.c.k.u.m;
import f.b.c.k.u.p.e;
import f.b.c.k.u.p.f;
import f.b.c.k.u.p.g;
import f.b.c.k.u.p.h;
import f.b.c.k.w.q0;
import f.b.c.k.w.r0;
import f.b.c.k.w.s0;
import f.b.c.k.w.t0;
import f.b.c.k.x.c;
import f.b.c.k.x.m;
import f.b.d.a.l;
import f.b.d.a.q;
import f.b.d.a.u;
import f.b.g.n0;
import h.a.c1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class l0 implements r0.a {
    public final c a;
    public final r b;
    public final Map<Integer, d1> c;

    /* renamed from: d  reason: collision with root package name */
    public final f0 f3403d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3404e = false;

    /* renamed from: f  reason: collision with root package name */
    public final s0 f3405f;

    /* renamed from: g  reason: collision with root package name */
    public final t0 f3406g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f3407h;

    /* renamed from: i  reason: collision with root package name */
    public final Deque<f> f3408i;

    public class a implements s0.a {
        public a() {
        }

        @Override // f.b.c.k.w.n0
        public void c() {
            l0 l0Var = l0.this;
            for (d1 d1Var : l0Var.c.values()) {
                l0Var.f(d1Var);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:167:0x01d6 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v20, types: [java.util.List, java.util.List<java.lang.Integer>] */
        /* JADX WARN: Type inference failed for: r5v21, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v23, types: [java.util.ArrayList] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // f.b.c.k.w.s0.a
        public void d(m mVar, q0 q0Var) {
            boolean z;
            l0 l0Var = l0.this;
            l0Var.f3403d.c(v.ONLINE);
            f.b.a.c.b.o.b.O0((l0Var.f3405f == null || l0Var.f3407h == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
            boolean z2 = q0Var instanceof q0.d;
            q0.d dVar = z2 ? (q0.d) q0Var : null;
            if (dVar == null || !dVar.a.equals(q0.e.Removed) || dVar.f3418d == null) {
                if (q0Var instanceof q0.b) {
                    r0 r0Var = l0Var.f3407h;
                    q0.b bVar = (q0.b) q0Var;
                    Objects.requireNonNull(r0Var);
                    i iVar = bVar.f3417d;
                    f.b.c.k.u.f fVar = bVar.c;
                    for (Integer num : bVar.a) {
                        int intValue = num.intValue();
                        if (iVar instanceof f.b.c.k.u.c) {
                            if (r0Var.c(intValue) != null) {
                                f.b.c.k.s.f fVar2 = r0Var.f(intValue, iVar.a) ? f.b.c.k.s.f.MODIFIED : f.b.c.k.s.f.ADDED;
                                p0 a2 = r0Var.a(intValue);
                                f.b.c.k.u.f fVar3 = iVar.a;
                                a2.c = true;
                                a2.b.put(fVar3, fVar2);
                                r0Var.c.put(iVar.a, iVar);
                                f.b.c.k.u.f fVar4 = iVar.a;
                                Set<Integer> set = r0Var.f3423d.get(fVar4);
                                if (set == null) {
                                    set = new HashSet<>();
                                    r0Var.f3423d.put(fVar4, set);
                                }
                                set.add(Integer.valueOf(intValue));
                            }
                        } else if (iVar instanceof j) {
                            r0Var.d(intValue, fVar, iVar);
                        }
                    }
                    for (Integer num2 : bVar.b) {
                        r0Var.d(num2.intValue(), fVar, bVar.f3417d);
                    }
                } else if (q0Var instanceof q0.c) {
                    r0 r0Var2 = l0Var.f3407h;
                    q0.c cVar = (q0.c) q0Var;
                    Objects.requireNonNull(r0Var2);
                    int i2 = cVar.a;
                    int i3 = cVar.b.a;
                    d1 c = r0Var2.c(i2);
                    if (c != null) {
                        c0 c0Var = c.a;
                        if (!c0Var.c()) {
                            o0 b = r0Var2.a(i2).b();
                            if (((long) ((b.c.size() + ((l0) r0Var2.a).a.d(i2).size()) - b.f3414e.size())) != ((long) i3)) {
                                r0Var2.e(i2);
                                r0Var2.f3424e.add(Integer.valueOf(i2));
                            }
                        } else if (i3 == 0) {
                            f.b.c.k.u.f fVar5 = new f.b.c.k.u.f(c0Var.f3270d);
                            r0Var2.d(i2, fVar5, new j(fVar5, m.c, false));
                        } else {
                            f.b.a.c.b.o.b.O0(i3 == 1, "Single document existence filter with count: %d", Integer.valueOf(i3));
                        }
                    }
                } else {
                    f.b.a.c.b.o.b.O0(z2, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
                    r0 r0Var3 = l0Var.f3407h;
                    q0.d dVar2 = (q0.d) q0Var;
                    Objects.requireNonNull(r0Var3);
                    ?? r5 = dVar2.b;
                    if (r5.isEmpty()) {
                        r5 = new ArrayList();
                        for (Integer num3 : r0Var3.b.keySet()) {
                            if (r0Var3.b(num3.intValue())) {
                                r5.add(num3);
                            }
                        }
                    }
                    for (Integer num4 : r5) {
                        int intValue2 = num4.intValue();
                        p0 a3 = r0Var3.a(intValue2);
                        int ordinal = dVar2.a.ordinal();
                        if (ordinal != 0) {
                            if (ordinal == 1) {
                                a3.a--;
                                if (!a3.a()) {
                                    a3.c = false;
                                    a3.b.clear();
                                }
                            } else if (ordinal == 2) {
                                a3.a--;
                                if (!a3.a()) {
                                    r0Var3.b.remove(Integer.valueOf(intValue2));
                                }
                                f.b.a.c.b.o.b.O0(dVar2.f3418d == null, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                            } else if (ordinal != 3) {
                                if (ordinal != 4) {
                                    f.b.a.c.b.o.b.q0("Unknown target watch change state: %s", dVar2.a);
                                    throw null;
                                } else if (r0Var3.b(intValue2)) {
                                    r0Var3.e(intValue2);
                                }
                            } else if (r0Var3.b(intValue2)) {
                                a3.c = true;
                                a3.f3416e = true;
                            }
                        } else if (!r0Var3.b(intValue2)) {
                        }
                        a3.c(dVar2.c);
                    }
                }
                m mVar2 = m.c;
                if (!mVar.equals(mVar2) && mVar.compareTo(l0Var.b.f3356g.a()) >= 0) {
                    f.b.a.c.b.o.b.O0(!mVar.equals(mVar2), "Can't raise event for unknown SnapshotVersion", new Object[0]);
                    r0 r0Var4 = l0Var.f3407h;
                    Objects.requireNonNull(r0Var4);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<Integer, p0> entry : r0Var4.b.entrySet()) {
                        int intValue3 = entry.getKey().intValue();
                        p0 value = entry.getValue();
                        d1 c2 = r0Var4.c(intValue3);
                        if (c2 != null) {
                            if (value.f3416e && c2.a.c()) {
                                f.b.c.k.u.f fVar6 = new f.b.c.k.u.f(c2.a.f3270d);
                                if (r0Var4.c.get(fVar6) == null && !r0Var4.f(intValue3, fVar6)) {
                                    r0Var4.d(intValue3, fVar6, new j(fVar6, mVar, false));
                                }
                            }
                            if (value.c) {
                                hashMap.put(Integer.valueOf(intValue3), value.b());
                                value.c = false;
                                value.b.clear();
                            }
                        }
                    }
                    HashSet hashSet = new HashSet();
                    for (Map.Entry<f.b.c.k.u.f, Set<Integer>> entry2 : r0Var4.f3423d.entrySet()) {
                        f.b.c.k.u.f key = entry2.getKey();
                        Iterator<Integer> it = entry2.getValue().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = true;
                                break;
                            }
                            d1 c3 = r0Var4.c(it.next().intValue());
                            if (!(c3 == null || c3.f3340d.equals(h0.LIMBO_RESOLUTION))) {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            hashSet.add(key);
                        }
                    }
                    g0 g0Var = new g0(mVar, Collections.unmodifiableMap(hashMap), Collections.unmodifiableSet(r0Var4.f3424e), Collections.unmodifiableMap(r0Var4.c), Collections.unmodifiableSet(hashSet));
                    r0Var4.c = new HashMap();
                    r0Var4.f3423d = new HashMap();
                    r0Var4.f3424e = new HashSet();
                    for (Map.Entry<Integer, o0> entry3 : g0Var.b.entrySet()) {
                        o0 value2 = entry3.getValue();
                        if (!value2.a.isEmpty()) {
                            int intValue4 = entry3.getKey().intValue();
                            d1 d1Var = l0Var.c.get(Integer.valueOf(intValue4));
                            if (d1Var != null) {
                                l0Var.c.put(Integer.valueOf(intValue4), d1Var.a(value2.a, mVar));
                            }
                        }
                    }
                    for (Integer num5 : g0Var.c) {
                        int intValue5 = num5.intValue();
                        d1 d1Var2 = l0Var.c.get(Integer.valueOf(intValue5));
                        if (d1Var2 != null) {
                            l0Var.c.put(Integer.valueOf(intValue5), d1Var2.a(f.b.g.j.c, d1Var2.f3341e));
                            l0Var.e(intValue5);
                            c0 c0Var2 = d1Var2.a;
                            long j2 = d1Var2.c;
                            h0 h0Var = h0.EXISTENCE_FILTER_MISMATCH;
                            m mVar3 = m.c;
                            l0Var.f(new d1(c0Var2, intValue5, j2, h0Var, mVar3, mVar3, s0.q));
                        }
                    }
                    l0Var.a.b(g0Var);
                    return;
                }
                return;
            }
            f.b.a.c.b.o.b.O0(true, "Processing target error without a cause", new Object[0]);
            for (Integer num6 : dVar.b) {
                if (l0Var.c.containsKey(num6)) {
                    l0Var.c.remove(num6);
                    l0Var.f3407h.b.remove(Integer.valueOf(num6.intValue()));
                    l0Var.a.e(num6.intValue(), dVar.f3418d);
                }
            }
        }

        @Override // f.b.c.k.w.n0
        public void e(c1 c1Var) {
            l0 l0Var = l0.this;
            Objects.requireNonNull(l0Var);
            v vVar = v.UNKNOWN;
            boolean z = true;
            if (c1.f3832f.equals(c1Var)) {
                f.b.a.c.b.o.b.O0(!l0Var.g(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
            }
            l0Var.f3407h = null;
            if (l0Var.g()) {
                f0 f0Var = l0Var.f3403d;
                if (f0Var.a == v.ONLINE) {
                    f0Var.b(vVar);
                    f.b.a.c.b.o.b.O0(f0Var.b == 0, "watchStreamFailures must be 0", new Object[0]);
                    if (f0Var.c != null) {
                        z = false;
                    }
                    f.b.a.c.b.o.b.O0(z, "onlineStateTimer must be null", new Object[0]);
                } else {
                    int i2 = f0Var.b + 1;
                    f0Var.b = i2;
                    if (i2 >= 1) {
                        c.b bVar = f0Var.c;
                        if (bVar != null) {
                            bVar.a();
                            f0Var.c = null;
                        }
                        f0Var.a(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", 1, c1Var));
                        f0Var.b(v.OFFLINE);
                    }
                }
                l0Var.i();
                return;
            }
            l0Var.f3403d.c(vVar);
        }
    }

    public class b implements t0.a {
        public b() {
        }

        @Override // f.b.c.k.w.t0.a
        public void a(m mVar, List<h> list) {
            l0 l0Var = l0.this;
            f poll = l0Var.f3408i.poll();
            f.b.g.j jVar = l0Var.f3406g.r;
            f.b.a.c.b.o.b.O0(poll.f3373d.size() == list.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(poll.f3373d.size()), Integer.valueOf(list.size()));
            d<f.b.c.k.u.f, ?> dVar = f.b.c.k.u.d.a;
            List<e> list2 = poll.f3373d;
            d<f.b.c.k.u.f, ?> dVar2 = dVar;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                dVar2 = dVar2.l(list2.get(i2).a, list.get(i2).a);
            }
            l0Var.a.c(new g(poll, mVar, list, jVar, dVar2));
            l0Var.c();
        }

        @Override // f.b.c.k.w.t0.a
        public void b() {
            l0 l0Var = l0.this;
            r rVar = l0Var.b;
            rVar.a.h("Set stream token", new n(rVar, l0Var.f3406g.r));
            for (f fVar : l0Var.f3408i) {
                l0Var.f3406g.j(fVar.f3373d);
            }
        }

        @Override // f.b.c.k.w.n0
        public void c() {
            t0 t0Var = l0.this.f3406g;
            f.b.a.c.b.o.b.O0(t0Var.c(), "Writing handshake requires an opened stream", new Object[0]);
            f.b.a.c.b.o.b.O0(!t0Var.q, "Handshake already completed", new Object[0]);
            u.b g2 = u.g();
            String str = t0Var.p.b;
            g2.copyOnWrite();
            u.c((u) g2.instance, str);
            t0Var.i((u) g2.build());
        }

        @Override // f.b.c.k.w.n0
        public void e(c1 c1Var) {
            l0 l0Var = l0.this;
            Objects.requireNonNull(l0Var);
            boolean z = true;
            if (c1.f3832f.equals(c1Var)) {
                f.b.a.c.b.o.b.O0(!l0Var.h(), "Write stream was stopped gracefully while still needed.", new Object[0]);
            }
            if (!c1Var.e() && !l0Var.f3408i.isEmpty()) {
                if (l0Var.f3406g.q) {
                    f.b.a.c.b.o.b.O0(!c1Var.e(), "Handling write error with status OK.", new Object[0]);
                    if (!j.a(c1Var) || c1Var.a.equals(c1.b.ABORTED)) {
                        z = false;
                    }
                    if (z) {
                        l0Var.f3406g.b();
                        l0Var.a.a(l0Var.f3408i.poll().a, c1Var);
                        l0Var.c();
                    }
                } else {
                    f.b.a.c.b.o.b.O0(!c1Var.e(), "Handling write error with status OK.", new Object[0]);
                    if (j.a(c1Var)) {
                        f.b.c.k.x.m.a(m.a.DEBUG, "RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", f.b.c.k.x.r.c(l0Var.f3406g.r), c1Var);
                        t0 t0Var = l0Var.f3406g;
                        f.b.g.j jVar = t0.s;
                        Objects.requireNonNull(t0Var);
                        Objects.requireNonNull(jVar);
                        t0Var.r = jVar;
                        r rVar = l0Var.b;
                        rVar.a.h("Set stream token", new n(rVar, jVar));
                    }
                }
            }
            if (l0Var.h()) {
                f.b.a.c.b.o.b.O0(l0Var.h(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
                l0Var.f3406g.g();
            }
        }
    }

    public interface c {
        void a(int i2, c1 c1Var);

        void b(g0 g0Var);

        void c(g gVar);

        f.b.c.g.a.f<f.b.c.k.u.f> d(int i2);

        void e(int i2, c1 c1Var);

        void f(v vVar);
    }

    public l0(c cVar, r rVar, j jVar, f.b.c.k.x.c cVar2, i iVar) {
        this.a = cVar;
        this.b = rVar;
        this.c = new HashMap();
        this.f3408i = new ArrayDeque();
        this.f3403d = new f0(cVar2, new i0(cVar));
        a aVar = new a();
        Objects.requireNonNull(jVar);
        this.f3405f = new s0(jVar.c, jVar.b, jVar.a, aVar);
        this.f3406g = new t0(jVar.c, jVar.b, jVar.a, new b());
        j0 j0Var = new j0(this, cVar2);
        h hVar = (h) iVar;
        synchronized (hVar.c) {
            hVar.c.add(j0Var);
        }
    }

    public final boolean a() {
        return this.f3404e && this.f3408i.size() < 10;
    }

    public void b() {
        this.f3404e = true;
        t0 t0Var = this.f3406g;
        f.b.g.j a2 = this.b.b.a();
        Objects.requireNonNull(t0Var);
        Objects.requireNonNull(a2);
        t0Var.r = a2;
        if (g()) {
            i();
        } else {
            this.f3403d.c(v.UNKNOWN);
        }
        c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001d  */
    public void c() {
        l0 l0Var;
        int i2;
        f d2;
        if (this.f3408i.isEmpty()) {
            i2 = -1;
            l0Var = this;
            if (l0Var.a()) {
                d2 = l0Var.b.b.d(i2);
                if (d2 != null) {
                    f.b.a.c.b.o.b.O0(l0Var.a(), "addToWritePipeline called when pipeline is full", new Object[0]);
                    l0Var.f3408i.add(d2);
                    if (l0Var.f3406g.c()) {
                        t0 t0Var = l0Var.f3406g;
                        if (t0Var.q) {
                            t0Var.j(d2.f3373d);
                        }
                    }
                }
                if (l0Var.f3408i.size() == 0) {
                    l0Var.f3406g.e();
                }
            }
            if (!l0Var.h()) {
                f.b.a.c.b.o.b.O0(l0Var.h(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
                l0Var.f3406g.g();
                return;
            }
            return;
        }
        d2 = this.f3408i.getLast();
        l0Var = this;
        i2 = d2.a;
        if (l0Var.a()) {
        }
        if (!l0Var.h()) {
        }
    }

    public final void d() {
        this.f3404e = false;
        m0 m0Var = m0.Initial;
        s0 s0Var = this.f3405f;
        if (s0Var.d()) {
            s0Var.a(m0Var, c1.f3832f);
        }
        t0 t0Var = this.f3406g;
        if (t0Var.d()) {
            t0Var.a(m0Var, c1.f3832f);
        }
        if (!this.f3408i.isEmpty()) {
            f.b.c.k.x.m.a(m.a.DEBUG, "RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.f3408i.size()));
            this.f3408i.clear();
        }
        this.f3407h = null;
        this.f3403d.c(v.UNKNOWN);
        this.f3406g.b();
        this.f3405f.b();
        b();
    }

    public final void e(int i2) {
        this.f3407h.a(i2).a++;
        s0 s0Var = this.f3405f;
        f.b.a.c.b.o.b.O0(s0Var.c(), "Unwatching targets requires an open stream", new Object[0]);
        l.b h2 = l.h();
        String str = s0Var.p.b;
        h2.copyOnWrite();
        l.d((l) h2.instance, str);
        h2.copyOnWrite();
        l.f((l) h2.instance, i2);
        s0Var.i((l) h2.build());
    }

    public final void f(d1 d1Var) {
        String str;
        this.f3407h.a(d1Var.b).a++;
        s0 s0Var = this.f3405f;
        f.b.a.c.b.o.b.O0(s0Var.c(), "Watching queries requires an open stream", new Object[0]);
        l.b h2 = l.h();
        String str2 = s0Var.p.b;
        h2.copyOnWrite();
        l.d((l) h2.instance, str2);
        h0 h0Var = s0Var.p;
        Objects.requireNonNull(h0Var);
        q.b g2 = q.g();
        c0 c0Var = d1Var.a;
        if (c0Var.c()) {
            q.c h3 = h0Var.h(c0Var);
            g2.copyOnWrite();
            q.d((q) g2.instance, h3);
        } else {
            q.d m = h0Var.m(c0Var);
            g2.copyOnWrite();
            q.c((q) g2.instance, m);
        }
        int i2 = d1Var.b;
        g2.copyOnWrite();
        q.f((q) g2.instance, i2);
        f.b.g.j jVar = d1Var.f3343g;
        g2.copyOnWrite();
        q.e((q) g2.instance, jVar);
        h2.copyOnWrite();
        l.e((l) h2.instance, (q) g2.build());
        Objects.requireNonNull(s0Var.p);
        h0 h0Var2 = d1Var.f3340d;
        int ordinal = h0Var2.ordinal();
        HashMap hashMap = null;
        if (ordinal == 0) {
            str = null;
        } else if (ordinal == 1) {
            str = "existence-filter-mismatch";
        } else if (ordinal == 2) {
            str = "limbo-document";
        } else {
            f.b.a.c.b.o.b.q0("Unrecognized query purpose: %s", h0Var2);
            throw null;
        }
        if (str != null) {
            hashMap = new HashMap(1);
            hashMap.put("goog-listen-tags", str);
        }
        if (hashMap != null) {
            h2.copyOnWrite();
            ((n0) l.c((l) h2.instance)).putAll(hashMap);
        }
        s0Var.i((l) h2.build());
    }

    public final boolean g() {
        return this.f3404e && !this.f3405f.d() && !this.c.isEmpty();
    }

    public final boolean h() {
        return this.f3404e && !this.f3406g.d() && !this.f3408i.isEmpty();
    }

    public final void i() {
        f.b.a.c.b.o.b.O0(g(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.f3407h = new r0(this);
        this.f3405f.g();
        f0 f0Var = this.f3403d;
        if (f0Var.b == 0) {
            f0Var.b(v.UNKNOWN);
            f.b.a.c.b.o.b.O0(f0Var.c == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            f0Var.c = f0Var.f3396e.a(c.d.ONLINE_STATE_TIMEOUT, 10000, new e0(f0Var));
        }
    }
}
