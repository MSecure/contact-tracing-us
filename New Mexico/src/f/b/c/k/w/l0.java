package f.b.c.k.w;

import f.b.a.c.b.o.b;
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
/* loaded from: classes.dex */
public final class l0 implements r0.a {
    public final c a;
    public final r b;

    /* renamed from: d */
    public final f0 f3658d;

    /* renamed from: f */
    public final s0 f3660f;

    /* renamed from: g */
    public final t0 f3661g;

    /* renamed from: h */
    public r0 f3662h;

    /* renamed from: e */
    public boolean f3659e = false;
    public final Map<Integer, d1> c = new HashMap();

    /* renamed from: i */
    public final Deque<f> f3663i = new ArrayDeque();

    /* loaded from: classes.dex */
    public class a implements s0.a {
        public a() {
            l0.this = r1;
        }

        @Override // f.b.c.k.w.n0
        public void c() {
            l0 l0Var = l0.this;
            for (d1 d1Var : l0Var.c.values()) {
                l0Var.f(d1Var);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v20, types: [java.util.List, java.util.List<java.lang.Integer>] */
        /* JADX WARN: Type inference failed for: r5v21, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v23, types: [java.util.ArrayList] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // f.b.c.k.w.s0.a
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void d(m mVar, q0 q0Var) {
            boolean z;
            l0 l0Var = l0.this;
            l0Var.f3658d.c(v.ONLINE);
            f.b.a.c.b.o.b.P0((l0Var.f3660f == null || l0Var.f3662h == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
            boolean z2 = q0Var instanceof q0.d;
            q0.d dVar = z2 ? (q0.d) q0Var : null;
            if (dVar == null || !dVar.a.equals(q0.e.Removed) || dVar.f3673d == null) {
                if (q0Var instanceof q0.b) {
                    r0 r0Var = l0Var.f3662h;
                    q0.b bVar = (q0.b) q0Var;
                    Objects.requireNonNull(r0Var);
                    i iVar = bVar.f3672d;
                    f.b.c.k.u.f fVar = bVar.c;
                    for (Integer num : bVar.a) {
                        int intValue = num.intValue();
                        if (iVar instanceof f.b.c.k.u.c) {
                            if (r0Var.c(intValue) != null) {
                                f.b.c.k.s.f fVar2 = r0Var.f(intValue, iVar.a) ? f.b.c.k.s.f.MODIFIED : f.b.c.k.s.f.ADDED;
                                p0 a = r0Var.a(intValue);
                                f.b.c.k.u.f fVar3 = iVar.a;
                                a.c = true;
                                a.b.put(fVar3, fVar2);
                                r0Var.c.put(iVar.a, iVar);
                                f.b.c.k.u.f fVar4 = iVar.a;
                                Set<Integer> set = r0Var.f3678d.get(fVar4);
                                if (set == null) {
                                    set = new HashSet<>();
                                    r0Var.f3678d.put(fVar4, set);
                                }
                                set.add(Integer.valueOf(intValue));
                            }
                        } else if (iVar instanceof j) {
                            r0Var.d(intValue, fVar, iVar);
                        }
                    }
                    for (Integer num2 : bVar.b) {
                        r0Var.d(num2.intValue(), fVar, bVar.f3672d);
                    }
                } else if (q0Var instanceof q0.c) {
                    r0 r0Var2 = l0Var.f3662h;
                    q0.c cVar = (q0.c) q0Var;
                    Objects.requireNonNull(r0Var2);
                    int i2 = cVar.a;
                    int i3 = cVar.b.a;
                    d1 c = r0Var2.c(i2);
                    if (c != null) {
                        c0 c0Var = c.a;
                        if (!c0Var.c()) {
                            o0 b = r0Var2.a(i2).b();
                            if (((long) ((b.c.size() + ((l0) r0Var2.a).a.d(i2).size()) - b.f3669e.size())) != ((long) i3)) {
                                r0Var2.e(i2);
                                r0Var2.f3679e.add(Integer.valueOf(i2));
                            }
                        } else if (i3 == 0) {
                            f.b.c.k.u.f fVar5 = new f.b.c.k.u.f(c0Var.f3525d);
                            r0Var2.d(i2, fVar5, new j(fVar5, m.c, false));
                        } else {
                            f.b.a.c.b.o.b.P0(i3 == 1, "Single document existence filter with count: %d", Integer.valueOf(i3));
                        }
                    }
                } else {
                    f.b.a.c.b.o.b.P0(z2, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
                    r0 r0Var3 = l0Var.f3662h;
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
                        p0 a2 = r0Var3.a(intValue2);
                        int ordinal = dVar2.a.ordinal();
                        if (ordinal != 0) {
                            if (ordinal == 1) {
                                a2.a--;
                                if (!a2.a()) {
                                    a2.c = false;
                                    a2.b.clear();
                                }
                            } else if (ordinal == 2) {
                                a2.a--;
                                if (!a2.a()) {
                                    r0Var3.b.remove(Integer.valueOf(intValue2));
                                }
                                f.b.a.c.b.o.b.P0(dVar2.f3673d == null, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                            } else if (ordinal != 3) {
                                if (ordinal != 4) {
                                    f.b.a.c.b.o.b.r0("Unknown target watch change state: %s", dVar2.a);
                                    throw null;
                                } else if (r0Var3.b(intValue2)) {
                                    r0Var3.e(intValue2);
                                }
                            } else if (r0Var3.b(intValue2)) {
                                a2.c = true;
                                a2.f3671e = true;
                            }
                            a2.c(dVar2.c);
                        } else if (r0Var3.b(intValue2)) {
                            a2.c(dVar2.c);
                        }
                    }
                }
                m mVar2 = m.c;
                if (!mVar.equals(mVar2) && mVar.compareTo(l0Var.b.f3611g.a()) >= 0) {
                    f.b.a.c.b.o.b.P0(!mVar.equals(mVar2), "Can't raise event for unknown SnapshotVersion", new Object[0]);
                    r0 r0Var4 = l0Var.f3662h;
                    Objects.requireNonNull(r0Var4);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<Integer, p0> entry : r0Var4.b.entrySet()) {
                        int intValue3 = entry.getKey().intValue();
                        p0 value = entry.getValue();
                        d1 c2 = r0Var4.c(intValue3);
                        if (c2 != null) {
                            if (value.f3671e && c2.a.c()) {
                                f.b.c.k.u.f fVar6 = new f.b.c.k.u.f(c2.a.f3525d);
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
                    for (Map.Entry<f.b.c.k.u.f, Set<Integer>> entry2 : r0Var4.f3678d.entrySet()) {
                        f.b.c.k.u.f key = entry2.getKey();
                        Iterator<Integer> it = entry2.getValue().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = true;
                                break;
                            }
                            d1 c3 = r0Var4.c(it.next().intValue());
                            if (!(c3 == null || c3.f3595d.equals(h0.LIMBO_RESOLUTION))) {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            hashSet.add(key);
                        }
                    }
                    g0 g0Var = new g0(mVar, Collections.unmodifiableMap(hashMap), Collections.unmodifiableSet(r0Var4.f3679e), Collections.unmodifiableMap(r0Var4.c), Collections.unmodifiableSet(hashSet));
                    r0Var4.c = new HashMap();
                    r0Var4.f3678d = new HashMap();
                    r0Var4.f3679e = new HashSet();
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
                            l0Var.c.put(Integer.valueOf(intValue5), d1Var2.a(f.b.g.j.c, d1Var2.f3596e));
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
            f.b.a.c.b.o.b.P0(true, "Processing target error without a cause", new Object[0]);
            for (Integer num6 : dVar.b) {
                if (l0Var.c.containsKey(num6)) {
                    l0Var.c.remove(num6);
                    l0Var.f3662h.b.remove(Integer.valueOf(num6.intValue()));
                    l0Var.a.e(num6.intValue(), dVar.f3673d);
                }
            }
        }

        @Override // f.b.c.k.w.n0
        public void e(c1 c1Var) {
            l0 l0Var = l0.this;
            Objects.requireNonNull(l0Var);
            v vVar = v.UNKNOWN;
            boolean z = true;
            if (c1.f4087f.equals(c1Var)) {
                f.b.a.c.b.o.b.P0(!l0Var.g(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
            }
            l0Var.f3662h = null;
            if (l0Var.g()) {
                f0 f0Var = l0Var.f3658d;
                if (f0Var.a == v.ONLINE) {
                    f0Var.b(vVar);
                    f.b.a.c.b.o.b.P0(f0Var.b == 0, "watchStreamFailures must be 0", new Object[0]);
                    if (f0Var.c != null) {
                        z = false;
                    }
                    f.b.a.c.b.o.b.P0(z, "onlineStateTimer must be null", new Object[0]);
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
            l0Var.f3658d.c(vVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements t0.a {
        public b() {
            l0.this = r1;
        }

        @Override // f.b.c.k.w.t0.a
        public void a(m mVar, List<h> list) {
            l0 l0Var = l0.this;
            f poll = l0Var.f3663i.poll();
            f.b.g.j jVar = l0Var.f3661g.r;
            f.b.a.c.b.o.b.P0(poll.f3628d.size() == list.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(poll.f3628d.size()), Integer.valueOf(list.size()));
            d<f.b.c.k.u.f, ?> dVar = f.b.c.k.u.d.a;
            List<e> list2 = poll.f3628d;
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
            rVar.a.h("Set stream token", new n(rVar, l0Var.f3661g.r));
            for (f fVar : l0Var.f3663i) {
                l0Var.f3661g.j(fVar.f3628d);
            }
        }

        @Override // f.b.c.k.w.n0
        public void c() {
            t0 t0Var = l0.this.f3661g;
            f.b.a.c.b.o.b.P0(t0Var.c(), "Writing handshake requires an opened stream", new Object[0]);
            f.b.a.c.b.o.b.P0(!t0Var.q, "Handshake already completed", new Object[0]);
            u.b g2 = u.g();
            String str = t0Var.p.b;
            g2.copyOnWrite();
            u.c((u) g2.instance, str);
            t0Var.i(g2.build());
        }

        @Override // f.b.c.k.w.n0
        public void e(c1 c1Var) {
            l0 l0Var = l0.this;
            Objects.requireNonNull(l0Var);
            boolean z = true;
            if (c1.f4087f.equals(c1Var)) {
                f.b.a.c.b.o.b.P0(!l0Var.h(), "Write stream was stopped gracefully while still needed.", new Object[0]);
            }
            if (!c1Var.e() && !l0Var.f3663i.isEmpty()) {
                if (l0Var.f3661g.q) {
                    f.b.a.c.b.o.b.P0(!c1Var.e(), "Handling write error with status OK.", new Object[0]);
                    if (!j.a(c1Var) || c1Var.a.equals(c1.b.ABORTED)) {
                        z = false;
                    }
                    if (z) {
                        l0Var.f3661g.b();
                        l0Var.a.a(l0Var.f3663i.poll().a, c1Var);
                        l0Var.c();
                    }
                } else {
                    f.b.a.c.b.o.b.P0(!c1Var.e(), "Handling write error with status OK.", new Object[0]);
                    if (j.a(c1Var)) {
                        f.b.c.k.x.m.a(m.a.DEBUG, "RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", f.b.c.k.x.r.c(l0Var.f3661g.r), c1Var);
                        t0 t0Var = l0Var.f3661g;
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
                f.b.a.c.b.o.b.P0(l0Var.h(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
                l0Var.f3661g.g();
            }
        }
    }

    /* loaded from: classes.dex */
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
        this.f3658d = new f0(cVar2, new i0(cVar));
        a aVar = new a();
        Objects.requireNonNull(jVar);
        this.f3660f = new s0(jVar.c, jVar.b, jVar.a, aVar);
        this.f3661g = new t0(jVar.c, jVar.b, jVar.a, new b());
        j0 j0Var = new f.b.c.k.x.g(this, cVar2) { // from class: f.b.c.k.w.j0
            public final l0 a;
            public final c b;

            {
                this.a = r1;
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                  (wrap: f.b.c.k.x.c : 0x0002: IGET  (r1v0 f.b.c.k.x.c A[REMOVE]) = (r2v0 'this' f.b.c.k.w.j0 A[IMMUTABLE_TYPE, THIS]) f.b.c.k.w.j0.b f.b.c.k.x.c)
                  (wrap: f.b.c.k.w.k0 : 0x0008: CONSTRUCTOR  (r3v2 f.b.c.k.w.k0 A[REMOVE]) = 
                  (wrap: f.b.c.k.w.l0 : 0x0000: IGET  (r0v0 f.b.c.k.w.l0 A[REMOVE]) = (r2v0 'this' f.b.c.k.w.j0 A[IMMUTABLE_TYPE, THIS]) f.b.c.k.w.j0.a f.b.c.k.w.l0)
                 call: f.b.c.k.w.k0.<init>(f.b.c.k.w.l0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.c.k.x.c.b(java.lang.Runnable):void in method: f.b.c.k.w.j0.a(java.lang.Object):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.c.k.w.k0, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // f.b.c.k.x.g
            public void a(java.lang.Object r3) {
                /*
                    r2 = this;
                    f.b.c.k.w.l0 r0 = r2.a
                    f.b.c.k.x.c r1 = r2.b
                    f.b.c.k.w.i$a r3 = (f.b.c.k.w.i.a) r3
                    f.b.c.k.w.k0 r3 = new f.b.c.k.w.k0
                    r3.<init>(r0)
                    r1.b(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.c.k.w.j0.a(java.lang.Object):void");
            }
        };
        h hVar = (h) iVar;
        synchronized (hVar.c) {
            hVar.c.add(j0Var);
        }
    }

    public final boolean a() {
        return this.f3659e && this.f3663i.size() < 10;
    }

    public void b() {
        this.f3659e = true;
        t0 t0Var = this.f3661g;
        f.b.g.j a2 = this.b.b.a();
        Objects.requireNonNull(t0Var);
        Objects.requireNonNull(a2);
        t0Var.r = a2;
        if (g()) {
            i();
        } else {
            this.f3658d.c(v.UNKNOWN);
        }
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void c() {
        l0 l0Var;
        int i2;
        f d2;
        if (this.f3663i.isEmpty()) {
            i2 = -1;
            l0Var = this;
            if (l0Var.a()) {
                d2 = l0Var.b.b.d(i2);
                if (d2 != null) {
                    f.b.a.c.b.o.b.P0(l0Var.a(), "addToWritePipeline called when pipeline is full", new Object[0]);
                    l0Var.f3663i.add(d2);
                    if (l0Var.f3661g.c()) {
                        t0 t0Var = l0Var.f3661g;
                        if (t0Var.q) {
                            t0Var.j(d2.f3628d);
                        }
                    }
                    i2 = d2.a;
                    if (l0Var.a()) {
                    }
                } else if (l0Var.f3663i.size() == 0) {
                    l0Var.f3661g.e();
                }
            }
            if (!l0Var.h()) {
                f.b.a.c.b.o.b.P0(l0Var.h(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
                l0Var.f3661g.g();
                return;
            }
            return;
        }
        d2 = this.f3663i.getLast();
        l0Var = this;
        i2 = d2.a;
        if (l0Var.a()) {
        }
        if (!l0Var.h()) {
        }
    }

    public final void d() {
        this.f3659e = false;
        m0 m0Var = m0.Initial;
        s0 s0Var = this.f3660f;
        if (s0Var.d()) {
            s0Var.a(m0Var, c1.f4087f);
        }
        t0 t0Var = this.f3661g;
        if (t0Var.d()) {
            t0Var.a(m0Var, c1.f4087f);
        }
        if (!this.f3663i.isEmpty()) {
            f.b.c.k.x.m.a(m.a.DEBUG, "RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.f3663i.size()));
            this.f3663i.clear();
        }
        this.f3662h = null;
        this.f3658d.c(v.UNKNOWN);
        this.f3661g.b();
        this.f3660f.b();
        b();
    }

    public final void e(int i2) {
        this.f3662h.a(i2).a++;
        s0 s0Var = this.f3660f;
        f.b.a.c.b.o.b.P0(s0Var.c(), "Unwatching targets requires an open stream", new Object[0]);
        l.b h2 = l.h();
        String str = s0Var.p.b;
        h2.copyOnWrite();
        l.d((l) h2.instance, str);
        h2.copyOnWrite();
        l.f((l) h2.instance, i2);
        s0Var.i(h2.build());
    }

    public final void f(d1 d1Var) {
        String str;
        this.f3662h.a(d1Var.b).a++;
        s0 s0Var = this.f3660f;
        f.b.a.c.b.o.b.P0(s0Var.c(), "Watching queries requires an open stream", new Object[0]);
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
        f.b.g.j jVar = d1Var.f3598g;
        g2.copyOnWrite();
        q.e((q) g2.instance, jVar);
        h2.copyOnWrite();
        l.e((l) h2.instance, g2.build());
        Objects.requireNonNull(s0Var.p);
        h0 h0Var2 = d1Var.f3595d;
        int ordinal = h0Var2.ordinal();
        HashMap hashMap = null;
        if (ordinal == 0) {
            str = null;
        } else if (ordinal == 1) {
            str = "existence-filter-mismatch";
        } else if (ordinal == 2) {
            str = "limbo-document";
        } else {
            f.b.a.c.b.o.b.r0("Unrecognized query purpose: %s", h0Var2);
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
        s0Var.i(h2.build());
    }

    public final boolean g() {
        return this.f3659e && !this.f3660f.d() && !this.c.isEmpty();
    }

    public final boolean h() {
        return this.f3659e && !this.f3661g.d() && !this.f3663i.isEmpty();
    }

    public final void i() {
        f.b.a.c.b.o.b.P0(g(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.f3662h = new r0(this);
        this.f3660f.g();
        f0 f0Var = this.f3658d;
        if (f0Var.b == 0) {
            f0Var.b(v.UNKNOWN);
            f.b.a.c.b.o.b.P0(f0Var.c == null, "onlineStateTimer shouldn't be started yet", new Object[0]);
            f0Var.c = f0Var.f3651e.a(c.d.ONLINE_STATE_TIMEOUT, 10000, new Runnable(f0Var) { // from class: f.b.c.k.w.e0
                public final f0 b;

                {
                    this.b = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    f0 f0Var2 = this.b;
                    f0Var2.c = null;
                    b.P0(f0Var2.a == v.UNKNOWN, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
                    f0Var2.a(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", 10));
                    f0Var2.b(v.OFFLINE);
                }
            });
        }
    }
}
