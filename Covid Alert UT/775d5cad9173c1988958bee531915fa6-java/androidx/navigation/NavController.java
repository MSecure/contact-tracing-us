package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import e.b.a.m;
import e.i.b.a;
import e.q.g0;
import e.q.h;
import e.q.j;
import e.q.l;
import e.s.e;
import e.s.f;
import e.s.g;
import e.s.i;
import e.s.j;
import e.s.k;
import e.s.n;
import e.s.o;
import e.s.q;
import e.s.r;
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
    public k f184d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f185e;

    /* renamed from: f  reason: collision with root package name */
    public Parcelable[] f186f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f187g;

    /* renamed from: h  reason: collision with root package name */
    public final Deque<e> f188h = new ArrayDeque();

    /* renamed from: i  reason: collision with root package name */
    public l f189i;

    /* renamed from: j  reason: collision with root package name */
    public g f190j;

    /* renamed from: k  reason: collision with root package name */
    public r f191k = new r();

    /* renamed from: l  reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f192l = new CopyOnWriteArrayList<>();
    public final e.q.k m = new j() {
        /* class androidx.navigation.NavController.AnonymousClass1 */

        @Override // e.q.j
        public void d(l lVar, h.a aVar) {
            h.b bVar;
            NavController navController = NavController.this;
            if (navController.f184d != null) {
                for (e eVar : navController.f188h) {
                    Objects.requireNonNull(eVar);
                    int ordinal = aVar.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                bVar = h.b.RESUMED;
                            } else if (ordinal != 3) {
                                if (ordinal != 4) {
                                    if (ordinal == 5) {
                                        bVar = h.b.DESTROYED;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected event value " + aVar);
                                    }
                                }
                            }
                            eVar.f1837h = bVar;
                            eVar.b();
                        }
                        bVar = h.b.STARTED;
                        eVar.f1837h = bVar;
                        eVar.b();
                    }
                    bVar = h.b.CREATED;
                    eVar.f1837h = bVar;
                    eVar.b();
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
        void a(NavController navController, e.s.j jVar, Bundle bundle);
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
        r rVar = this.f191k;
        rVar.a(new e.s.l(rVar));
        this.f191k.a(new e.s.a(this.a));
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000d  */
    public final boolean a() {
        h.b bVar = h.b.STARTED;
        h.b bVar2 = h.b.RESUMED;
        while (!this.f188h.isEmpty() && (this.f188h.peekLast().c instanceof k) && f(this.f188h.peekLast().c.f1850d, true)) {
            while (!this.f188h.isEmpty()) {
                while (!this.f188h.isEmpty()) {
                }
            }
        }
        if (this.f188h.isEmpty()) {
            return false;
        }
        e.s.j jVar = this.f188h.peekLast().c;
        e.s.j jVar2 = null;
        if (jVar instanceof e.s.b) {
            Iterator<e> descendingIterator = this.f188h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                e.s.j jVar3 = descendingIterator.next().c;
                if (!((jVar3 instanceof k) || (jVar3 instanceof e.s.b))) {
                    jVar2 = jVar3;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<e> descendingIterator2 = this.f188h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            e next = descendingIterator2.next();
            h.b bVar3 = next.f1838i;
            e.s.j jVar4 = next.c;
            if (jVar != null && jVar4.f1850d == jVar.f1850d) {
                if (bVar3 != bVar2) {
                    hashMap.put(next, bVar2);
                }
                jVar = jVar.c;
            } else if (jVar2 == null || jVar4.f1850d != jVar2.f1850d) {
                next.f1838i = h.b.CREATED;
                next.b();
            } else {
                if (bVar3 == bVar2) {
                    next.f1838i = bVar;
                    next.b();
                } else if (bVar3 != bVar) {
                    hashMap.put(next, bVar);
                }
                jVar2 = jVar2.c;
            }
        }
        for (e eVar : this.f188h) {
            h.b bVar4 = (h.b) hashMap.get(eVar);
            if (bVar4 != null) {
                eVar.f1838i = bVar4;
                eVar.b();
            } else {
                eVar.b();
            }
        }
        e peekLast = this.f188h.peekLast();
        Iterator<b> it = this.f192l.iterator();
        while (it.hasNext()) {
            it.next().a(this, peekLast.c, peekLast.f1833d);
        }
        return true;
    }

    public e.s.j b(int i2) {
        e.s.j jVar;
        k kVar;
        k kVar2 = this.f184d;
        if (kVar2 == null) {
            return null;
        }
        if (kVar2.f1850d == i2) {
            return kVar2;
        }
        if (this.f188h.isEmpty()) {
            jVar = this.f184d;
        } else {
            jVar = this.f188h.getLast().c;
        }
        if (jVar instanceof k) {
            kVar = (k) jVar;
        } else {
            kVar = jVar.c;
        }
        return kVar.o(i2, true);
    }

    public e.s.j c() {
        e last = this.f188h.isEmpty() ? null : this.f188h.getLast();
        if (last != null) {
            return last.c;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e A[LOOP:0: B:10:0x002e->B:15:0x0054, LOOP_START] */
    public final void d(e.s.j jVar, Bundle bundle, o oVar, q.a aVar) {
        int i2;
        boolean z = false;
        boolean f2 = (oVar == null || (i2 = oVar.b) == -1) ? false : f(i2, oVar.c);
        q c2 = this.f191k.c(jVar.b);
        Bundle h2 = jVar.h(bundle);
        e.s.j b2 = c2.b(jVar, h2, oVar, null);
        if (b2 != null) {
            if (!(b2 instanceof e.s.b)) {
                while (!this.f188h.isEmpty() && (this.f188h.peekLast().c instanceof e.s.b) && f(this.f188h.peekLast().c.f1850d, true)) {
                }
            }
            if (this.f188h.isEmpty()) {
                this.f188h.add(new e(this.a, this.f184d, h2, this.f189i, this.f190j));
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            e.s.j jVar2 = b2;
            while (jVar2 != null && b(jVar2.f1850d) == null) {
                jVar2 = jVar2.c;
                if (jVar2 != null) {
                    arrayDeque.addFirst(new e(this.a, jVar2, h2, this.f189i, this.f190j));
                }
            }
            this.f188h.addAll(arrayDeque);
            this.f188h.add(new e(this.a, b2, b2.h(h2), this.f189i, this.f190j));
        } else if (oVar != null && oVar.a) {
            e peekLast = this.f188h.peekLast();
            if (peekLast != null) {
                peekLast.f1833d = bundle;
            }
            z = true;
        }
        h();
        if (f2 || b2 != null || z) {
            a();
        }
    }

    public boolean e() {
        if (!this.f188h.isEmpty() && f(c().f1850d, true) && a()) {
            return true;
        }
        return false;
    }

    public boolean f(int i2, boolean z) {
        boolean z2;
        g0 remove;
        boolean z3 = false;
        if (this.f188h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e> descendingIterator = this.f188h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            e.s.j jVar = descendingIterator.next().c;
            q c2 = this.f191k.c(jVar.b);
            if (z || jVar.f1850d != i2) {
                arrayList.add(c2);
            }
            if (jVar.f1850d == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            e.s.j.i(this.a, i2);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((q) it.next()).e()) {
            e removeLast = this.f188h.removeLast();
            removeLast.f1838i = h.b.DESTROYED;
            removeLast.b();
            g gVar = this.f190j;
            if (!(gVar == null || (remove = gVar.c.remove(removeLast.f1836g)) == null)) {
                remove.a();
            }
            z3 = true;
        }
        h();
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02fd, code lost:
        if (r0 == false) goto L_0x0300;
     */
    public void g(int i2, Bundle bundle) {
        Activity activity;
        boolean z;
        String str;
        k kVar;
        e.s.j jVar;
        k kVar2;
        j.a j2;
        ArrayList<String> stringArrayList;
        if (this.c == null) {
            this.c = new n(this.a, this.f191k);
        }
        k c2 = this.c.c(i2);
        k kVar3 = this.f184d;
        boolean z2 = true;
        if (kVar3 != null) {
            f(kVar3.f1850d, true);
        }
        this.f184d = c2;
        Bundle bundle2 = this.f185e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                q c3 = this.f191k.c(next);
                Bundle bundle3 = this.f185e.getBundle(next);
                if (bundle3 != null) {
                    c3.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f186f;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                f fVar = (f) parcelable;
                e.s.j b2 = b(fVar.c);
                if (b2 != null) {
                    Bundle bundle4 = fVar.f1841d;
                    if (bundle4 != null) {
                        bundle4.setClassLoader(this.a.getClassLoader());
                    }
                    this.f188h.add(new e(this.a, b2, bundle4, this.f189i, this.f190j, fVar.b, fVar.f1842e));
                } else {
                    StringBuilder j3 = f.a.a.a.a.j("Restoring the Navigation back stack failed: destination ", e.s.j.i(this.a, fVar.c), " cannot be found from the current destination ");
                    j3.append(c());
                    throw new IllegalStateException(j3.toString());
                }
            }
            h();
            this.f186f = null;
        }
        if (this.f184d == null || !this.f188h.isEmpty()) {
            a();
            return;
        }
        if (!this.f187g && (activity = this.b) != null) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Bundle extras = intent.getExtras();
                int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
                Bundle bundle5 = new Bundle();
                Bundle bundle6 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
                if (bundle6 != null) {
                    bundle5.putAll(bundle6);
                }
                if (!(!(intArray == null || intArray.length == 0) || intent.getData() == null || (j2 = this.f184d.j(new i(intent))) == null)) {
                    e.s.j jVar2 = j2.b;
                    Objects.requireNonNull(jVar2);
                    ArrayDeque arrayDeque = new ArrayDeque();
                    while (true) {
                        k kVar4 = jVar2.c;
                        if (kVar4 == null || kVar4.f1860k != jVar2.f1850d) {
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
                        intArray[i3] = ((e.s.j) it2.next()).f1850d;
                        i3++;
                    }
                    bundle5.putAll(j2.c);
                }
                if (!(intArray == null || intArray.length == 0)) {
                    k kVar5 = this.f184d;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= intArray.length) {
                            str = null;
                            break;
                        }
                        int i5 = intArray[i4];
                        if (i4 == 0) {
                            jVar = this.f184d;
                            if (jVar.f1850d != i5) {
                                jVar = null;
                            }
                        } else {
                            jVar = kVar5.n(i5);
                        }
                        if (jVar == null) {
                            str = e.s.j.i(this.a, i5);
                            break;
                        }
                        if (i4 != intArray.length - 1) {
                            while (true) {
                                kVar2 = (k) jVar;
                                if (!(kVar2.n(kVar2.f1860k) instanceof k)) {
                                    break;
                                }
                                jVar = kVar2.n(kVar2.f1860k);
                            }
                            kVar5 = kVar2;
                        }
                        i4++;
                    }
                    if (str != null) {
                        String str2 = "Could not find destination " + str + " in the navigation graph, ignoring the deep link from " + intent;
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
                                        Intent x0 = m.e.x0(context, component);
                                        if (x0 == null) {
                                            break;
                                        }
                                        arrayList.add(size, x0);
                                        component = x0.getComponent();
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        throw new IllegalArgumentException(e2);
                                    }
                                }
                            }
                            arrayList.add(intent);
                            if (!arrayList.isEmpty()) {
                                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                                Object obj = e.i.b.a.a;
                                a.C0033a.a(context, intentArr, null);
                                Activity activity2 = this.b;
                                if (activity2 != null) {
                                    activity2.finish();
                                    this.b.overridePendingTransition(0, 0);
                                }
                            } else {
                                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
                            }
                        } else if (i6 != 0) {
                            if (!this.f188h.isEmpty()) {
                                f(this.f184d.f1850d, true);
                            }
                            int i7 = 0;
                            while (i7 < intArray.length) {
                                int i8 = i7 + 1;
                                int i9 = intArray[i7];
                                e.s.j b3 = b(i9);
                                if (b3 != null) {
                                    d(b3, bundle5, new o(false, -1, false, 0, 0, -1, -1), null);
                                    i7 = i8;
                                } else {
                                    StringBuilder j4 = f.a.a.a.a.j("Deep Linking failed: destination ", e.s.j.i(this.a, i9), " cannot be found from the current destination ");
                                    j4.append(c());
                                    throw new IllegalStateException(j4.toString());
                                }
                            }
                        } else {
                            k kVar6 = this.f184d;
                            int i10 = 0;
                            while (i10 < intArray.length) {
                                int i11 = intArray[i10];
                                e.s.j n2 = i10 == 0 ? this.f184d : kVar6.n(i11);
                                if (n2 != null) {
                                    if (i10 != intArray.length - 1) {
                                        while (true) {
                                            kVar = (k) n2;
                                            if (!(kVar.n(kVar.f1860k) instanceof k)) {
                                                break;
                                            }
                                            n2 = kVar.n(kVar.f1860k);
                                        }
                                        kVar6 = kVar;
                                    } else {
                                        d(n2, n2.h(bundle5), new o(false, this.f184d.f1850d, true, 0, 0, -1, -1), null);
                                    }
                                    i10++;
                                } else {
                                    throw new IllegalStateException("Deep Linking failed: destination " + e.s.j.i(this.a, i11) + " cannot be found in graph " + kVar6);
                                }
                            }
                            this.f187g = true;
                        }
                        z = true;
                    }
                }
            }
            z = false;
        }
        z2 = false;
        if (!z2) {
            d(this.f184d, bundle, null, null);
        }
    }

    public final void h() {
        e.a.b bVar = this.n;
        boolean z = false;
        if (this.o) {
            int i2 = 0;
            for (e eVar : this.f188h) {
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
