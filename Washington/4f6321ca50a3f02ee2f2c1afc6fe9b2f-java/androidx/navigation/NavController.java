package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import e.b.a.m;
import e.p.c0;
import e.p.g;
import e.p.h;
import e.p.i;
import e.p.j;
import e.r.e;
import e.r.f;
import e.r.g;
import e.r.j;
import e.r.k;
import e.r.l;
import e.r.n;
import e.r.o;
import e.r.q;
import e.r.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController {
    public final Context a;
    public Activity b;
    public n c;

    /* renamed from: d  reason: collision with root package name */
    public k f172d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f173e;

    /* renamed from: f  reason: collision with root package name */
    public Parcelable[] f174f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f175g;

    /* renamed from: h  reason: collision with root package name */
    public final Deque<e> f176h = new ArrayDeque();

    /* renamed from: i  reason: collision with root package name */
    public j f177i;

    /* renamed from: j  reason: collision with root package name */
    public g f178j;

    /* renamed from: k  reason: collision with root package name */
    public r f179k = new r();

    /* renamed from: l  reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f180l = new CopyOnWriteArrayList<>();
    public final i m = new h() {
        /* class androidx.navigation.NavController.AnonymousClass1 */

        @Override // e.p.h
        public void d(j jVar, g.a aVar) {
            g.b bVar;
            NavController navController = NavController.this;
            if (navController.f172d != null) {
                for (e eVar : navController.f176h) {
                    Objects.requireNonNull(eVar);
                    int ordinal = aVar.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                bVar = g.b.RESUMED;
                            } else if (ordinal != 3) {
                                if (ordinal != 4) {
                                    if (ordinal == 5) {
                                        bVar = g.b.DESTROYED;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected event value " + aVar);
                                    }
                                }
                            }
                            eVar.f1731h = bVar;
                            eVar.d();
                        }
                        bVar = g.b.STARTED;
                        eVar.f1731h = bVar;
                        eVar.d();
                    }
                    bVar = g.b.CREATED;
                    eVar.f1731h = bVar;
                    eVar.d();
                }
            }
        }
    };
    public final e.a.b n = new a(false);
    public boolean o = true;

    public class a extends e.a.b {
        public a(boolean z) {
            super(z);
        }

        @Override // e.a.b
        public void a() {
            NavController.this.e();
        }
    }

    public interface b {
        void a(NavController navController, e.r.j jVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        r rVar = this.f179k;
        rVar.a(new l(rVar));
        this.f179k.a(new e.r.a(this.a));
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000d  */
    public final boolean a() {
        g.b bVar = g.b.STARTED;
        g.b bVar2 = g.b.RESUMED;
        while (!this.f176h.isEmpty() && (this.f176h.peekLast().c instanceof k) && f(this.f176h.peekLast().c.f1744d, true)) {
            while (!this.f176h.isEmpty()) {
                while (!this.f176h.isEmpty()) {
                }
            }
        }
        if (this.f176h.isEmpty()) {
            return false;
        }
        e.r.j jVar = this.f176h.peekLast().c;
        e.r.j jVar2 = null;
        if (jVar instanceof e.r.b) {
            Iterator<e> descendingIterator = this.f176h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                e.r.j jVar3 = descendingIterator.next().c;
                if (!((jVar3 instanceof k) || (jVar3 instanceof e.r.b))) {
                    jVar2 = jVar3;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<e> descendingIterator2 = this.f176h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            e next = descendingIterator2.next();
            g.b bVar3 = next.f1732i;
            e.r.j jVar4 = next.c;
            if (jVar != null && jVar4.f1744d == jVar.f1744d) {
                if (bVar3 != bVar2) {
                    hashMap.put(next, bVar2);
                }
                jVar = jVar.c;
            } else if (jVar2 == null || jVar4.f1744d != jVar2.f1744d) {
                next.f1732i = g.b.CREATED;
                next.d();
            } else {
                if (bVar3 == bVar2) {
                    next.f1732i = bVar;
                    next.d();
                } else if (bVar3 != bVar) {
                    hashMap.put(next, bVar);
                }
                jVar2 = jVar2.c;
            }
        }
        for (e eVar : this.f176h) {
            g.b bVar4 = (g.b) hashMap.get(eVar);
            if (bVar4 != null) {
                eVar.f1732i = bVar4;
                eVar.d();
            } else {
                eVar.d();
            }
        }
        e peekLast = this.f176h.peekLast();
        Iterator<b> it = this.f180l.iterator();
        while (it.hasNext()) {
            it.next().a(this, peekLast.c, peekLast.f1727d);
        }
        return true;
    }

    public e.r.j b(int i2) {
        e.r.j jVar;
        k kVar;
        k kVar2 = this.f172d;
        if (kVar2 == null) {
            return null;
        }
        if (kVar2.f1744d == i2) {
            return kVar2;
        }
        if (this.f176h.isEmpty()) {
            jVar = this.f172d;
        } else {
            jVar = this.f176h.getLast().c;
        }
        if (jVar instanceof k) {
            kVar = (k) jVar;
        } else {
            kVar = jVar.c;
        }
        return kVar.o(i2, true);
    }

    public e.r.j c() {
        e last = this.f176h.isEmpty() ? null : this.f176h.getLast();
        if (last != null) {
            return last.c;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e A[LOOP:0: B:10:0x002e->B:15:0x0054, LOOP_START] */
    public final void d(e.r.j jVar, Bundle bundle, o oVar, q.a aVar) {
        int i2;
        boolean z = false;
        boolean f2 = (oVar == null || (i2 = oVar.b) == -1) ? false : f(i2, oVar.c);
        q c2 = this.f179k.c(jVar.b);
        Bundle h2 = jVar.h(bundle);
        e.r.j b2 = c2.b(jVar, h2, oVar, null);
        if (b2 != null) {
            if (!(b2 instanceof e.r.b)) {
                while (!this.f176h.isEmpty() && (this.f176h.peekLast().c instanceof e.r.b) && f(this.f176h.peekLast().c.f1744d, true)) {
                }
            }
            if (this.f176h.isEmpty()) {
                this.f176h.add(new e(this.a, this.f172d, h2, this.f177i, this.f178j));
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            e.r.j jVar2 = b2;
            while (jVar2 != null && b(jVar2.f1744d) == null) {
                jVar2 = jVar2.c;
                if (jVar2 != null) {
                    arrayDeque.addFirst(new e(this.a, jVar2, h2, this.f177i, this.f178j));
                }
            }
            this.f176h.addAll(arrayDeque);
            this.f176h.add(new e(this.a, b2, b2.h(h2), this.f177i, this.f178j));
        } else if (oVar != null && oVar.a) {
            e peekLast = this.f176h.peekLast();
            if (peekLast != null) {
                peekLast.f1727d = bundle;
            }
            z = true;
        }
        h();
        if (f2 || b2 != null || z) {
            a();
        }
    }

    public boolean e() {
        if (!this.f176h.isEmpty() && f(c().f1744d, true) && a()) {
            return true;
        }
        return false;
    }

    public boolean f(int i2, boolean z) {
        boolean z2;
        c0 remove;
        boolean z3 = false;
        if (this.f176h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e> descendingIterator = this.f176h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            e.r.j jVar = descendingIterator.next().c;
            q c2 = this.f179k.c(jVar.b);
            if (z || jVar.f1744d != i2) {
                arrayList.add(c2);
            }
            if (jVar.f1744d == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            String i3 = e.r.j.i(this.a, i2);
            Log.i("NavController", "Ignoring popBackStack to destination " + i3 + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((q) it.next()).e()) {
            e removeLast = this.f176h.removeLast();
            removeLast.f1732i = g.b.DESTROYED;
            removeLast.d();
            e.r.g gVar = this.f178j;
            if (!(gVar == null || (remove = gVar.c.remove(removeLast.f1730g)) == null)) {
                remove.a();
            }
            z3 = true;
        }
        h();
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:150:0x030a, code lost:
        if (r0 == false) goto L_0x030d;
     */
    public void g(int i2, Bundle bundle) {
        Activity activity;
        boolean z;
        String str;
        k kVar;
        e.r.j jVar;
        k kVar2;
        j.a j2;
        ArrayList<String> stringArrayList;
        if (this.c == null) {
            this.c = new n(this.a, this.f179k);
        }
        k c2 = this.c.c(i2);
        k kVar3 = this.f172d;
        boolean z2 = true;
        if (kVar3 != null) {
            f(kVar3.f1744d, true);
        }
        this.f172d = c2;
        Bundle bundle2 = this.f173e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                q c3 = this.f179k.c(next);
                Bundle bundle3 = this.f173e.getBundle(next);
                if (bundle3 != null) {
                    c3.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f174f;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                f fVar = (f) parcelable;
                e.r.j b2 = b(fVar.c);
                if (b2 != null) {
                    Bundle bundle4 = fVar.f1735d;
                    if (bundle4 != null) {
                        bundle4.setClassLoader(this.a.getClassLoader());
                    }
                    this.f176h.add(new e(this.a, b2, bundle4, this.f177i, this.f178j, fVar.b, fVar.f1736e));
                } else {
                    StringBuilder j3 = f.a.a.a.a.j("Restoring the Navigation back stack failed: destination ", e.r.j.i(this.a, fVar.c), " cannot be found from the current destination ");
                    j3.append(c());
                    throw new IllegalStateException(j3.toString());
                }
            }
            h();
            this.f174f = null;
        }
        if (this.f172d == null || !this.f176h.isEmpty()) {
            a();
            return;
        }
        if (!this.f175g && (activity = this.b) != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Bundle extras = intent.getExtras();
                int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
                Bundle bundle5 = new Bundle();
                Bundle bundle6 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
                if (bundle6 != null) {
                    bundle5.putAll(bundle6);
                }
                if (!(!(intArray == null || intArray.length == 0) || intent.getData() == null || (j2 = this.f172d.j(new e.r.i(intent))) == null)) {
                    e.r.j jVar2 = j2.b;
                    Objects.requireNonNull(jVar2);
                    ArrayDeque arrayDeque = new ArrayDeque();
                    while (true) {
                        k kVar4 = jVar2.c;
                        if (kVar4 == null || kVar4.f1754k != jVar2.f1744d) {
                            arrayDeque.addFirst(jVar2);
                        }
                        if (kVar4 == null) {
                            break;
                        }
                        jVar2 = kVar4;
                    }
                    intArray = new int[arrayDeque.size()];
                    Iterator it2 = arrayDeque.iterator();
                    int i3 = 0;
                    while (it2.hasNext()) {
                        intArray[i3] = ((e.r.j) it2.next()).f1744d;
                        i3++;
                    }
                    bundle5.putAll(j2.c);
                }
                if (!(intArray == null || intArray.length == 0)) {
                    k kVar5 = this.f172d;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= intArray.length) {
                            str = null;
                            break;
                        }
                        int i5 = intArray[i4];
                        if (i4 == 0) {
                            jVar = this.f172d;
                            if (jVar.f1744d != i5) {
                                jVar = null;
                            }
                        } else {
                            jVar = kVar5.n(i5);
                        }
                        if (jVar == null) {
                            str = e.r.j.i(this.a, i5);
                            break;
                        }
                        if (i4 != intArray.length - 1) {
                            while (true) {
                                kVar2 = (k) jVar;
                                if (!(kVar2.n(kVar2.f1754k) instanceof k)) {
                                    break;
                                }
                                jVar = kVar2.n(kVar2.f1754k);
                            }
                            kVar5 = kVar2;
                        }
                        i4++;
                    }
                    if (str != null) {
                        Log.i("NavController", "Could not find destination " + str + " in the navigation graph, ignoring the deep link from " + intent);
                    } else {
                        bundle5.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                        int flags = intent.getFlags();
                        int i6 = 268435456 & flags;
                        if (i6 != 0 && (flags & 32768) == 0) {
                            intent.addFlags(32768);
                            Context context = this.a;
                            ArrayList arrayList = new ArrayList();
                            ComponentName component = intent.getComponent();
                            if (component == null) {
                                component = intent.resolveActivity(context.getPackageManager());
                            }
                            if (component != null) {
                                int size = arrayList.size();
                                while (true) {
                                    try {
                                        Intent l0 = m.h.l0(context, component);
                                        if (l0 == null) {
                                            break;
                                        }
                                        arrayList.add(size, l0);
                                        component = l0.getComponent();
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                                        throw new IllegalArgumentException(e2);
                                    }
                                }
                            }
                            arrayList.add(intent);
                            if (!arrayList.isEmpty()) {
                                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                                Object obj = e.i.b.a.a;
                                context.startActivities(intentArr, null);
                                Activity activity2 = this.b;
                                if (activity2 != null) {
                                    activity2.finish();
                                    this.b.overridePendingTransition(0, 0);
                                }
                            } else {
                                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
                            }
                        } else if (i6 != 0) {
                            if (!this.f176h.isEmpty()) {
                                f(this.f172d.f1744d, true);
                            }
                            int i7 = 0;
                            while (i7 < intArray.length) {
                                int i8 = i7 + 1;
                                int i9 = intArray[i7];
                                e.r.j b3 = b(i9);
                                if (b3 != null) {
                                    d(b3, bundle5, new o(false, -1, false, 0, 0, -1, -1), null);
                                    i7 = i8;
                                } else {
                                    StringBuilder j4 = f.a.a.a.a.j("Deep Linking failed: destination ", e.r.j.i(this.a, i9), " cannot be found from the current destination ");
                                    j4.append(c());
                                    throw new IllegalStateException(j4.toString());
                                }
                            }
                        } else {
                            k kVar6 = this.f172d;
                            int i10 = 0;
                            while (i10 < intArray.length) {
                                int i11 = intArray[i10];
                                e.r.j n2 = i10 == 0 ? this.f172d : kVar6.n(i11);
                                if (n2 != null) {
                                    if (i10 != intArray.length - 1) {
                                        while (true) {
                                            kVar = (k) n2;
                                            if (!(kVar.n(kVar.f1754k) instanceof k)) {
                                                break;
                                            }
                                            n2 = kVar.n(kVar.f1754k);
                                        }
                                        kVar6 = kVar;
                                    } else {
                                        d(n2, n2.h(bundle5), new o(false, this.f172d.f1744d, true, 0, 0, -1, -1), null);
                                    }
                                    i10++;
                                } else {
                                    throw new IllegalStateException("Deep Linking failed: destination " + e.r.j.i(this.a, i11) + " cannot be found in graph " + kVar6);
                                }
                            }
                            this.f175g = true;
                        }
                        z = true;
                    }
                }
            }
            z = false;
        }
        z2 = false;
        if (!z2) {
            d(this.f172d, bundle, null, null);
        }
    }

    public final void h() {
        e.a.b bVar = this.n;
        boolean z = false;
        if (this.o) {
            int i2 = 0;
            for (e eVar : this.f176h) {
                if (!(eVar.c instanceof k)) {
                    i2++;
                }
            }
            if (i2 > 1) {
                z = true;
            }
        }
        bVar.a = z;
    }
}
