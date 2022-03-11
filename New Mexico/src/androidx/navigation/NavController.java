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
import e.j.b.a;
import e.r.g0;
import e.r.h;
import e.r.j;
import e.r.l;
import e.t.e;
import e.t.f;
import e.t.g;
import e.t.i;
import e.t.j;
import e.t.k;
import e.t.n;
import e.t.o;
import e.t.q;
import e.t.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class NavController {
    public final Context a;
    public Activity b;
    public n c;

    /* renamed from: d */
    public k f184d;

    /* renamed from: e */
    public Bundle f185e;

    /* renamed from: f */
    public Parcelable[] f186f;

    /* renamed from: g */
    public boolean f187g;

    /* renamed from: i */
    public l f189i;

    /* renamed from: j */
    public g f190j;

    /* renamed from: h */
    public final Deque<e> f188h = new ArrayDeque();

    /* renamed from: k */
    public r f191k = new r();

    /* renamed from: l */
    public final CopyOnWriteArrayList<b> f192l = new CopyOnWriteArrayList<>();
    public final e.r.k m = new j() { // from class: androidx.navigation.NavController.1
        @Override // e.r.j
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
                            eVar.f1922h = bVar;
                            eVar.b();
                        }
                        bVar = h.b.STARTED;
                        eVar.f1922h = bVar;
                        eVar.b();
                    }
                    bVar = h.b.CREATED;
                    eVar.f1922h = bVar;
                    eVar.b();
                }
            }
        }
    };
    public final e.a.b n = new a(false);
    public boolean o = true;

    /* loaded from: classes.dex */
    public class a extends e.a.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z) {
            super(z);
            NavController.this = r1;
        }

        @Override // e.a.b
        public void a() {
            NavController.this.e();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NavController navController, e.t.j jVar, Bundle bundle);
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
        rVar.a(new e.t.l(rVar));
        this.f191k.a(new e.t.a(this.a));
    }

    public final boolean a() {
        h.b bVar = h.b.STARTED;
        h.b bVar2 = h.b.RESUMED;
        while (!this.f188h.isEmpty() && (this.f188h.peekLast().c instanceof k) && f(this.f188h.peekLast().c.f1935d, true)) {
        }
        if (this.f188h.isEmpty()) {
            return false;
        }
        e.t.j jVar = this.f188h.peekLast().c;
        e.t.j jVar2 = null;
        if (jVar instanceof e.t.b) {
            Iterator<e> descendingIterator = this.f188h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                e.t.j jVar3 = descendingIterator.next().c;
                if (!((jVar3 instanceof k) || (jVar3 instanceof e.t.b))) {
                    jVar2 = jVar3;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<e> descendingIterator2 = this.f188h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            e next = descendingIterator2.next();
            h.b bVar3 = next.f1923i;
            e.t.j jVar4 = next.c;
            if (jVar != null && jVar4.f1935d == jVar.f1935d) {
                if (bVar3 != bVar2) {
                    hashMap.put(next, bVar2);
                }
                jVar = jVar.c;
            } else if (jVar2 == null || jVar4.f1935d != jVar2.f1935d) {
                next.f1923i = h.b.CREATED;
                next.b();
            } else {
                if (bVar3 == bVar2) {
                    next.f1923i = bVar;
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
                eVar.f1923i = bVar4;
                eVar.b();
            } else {
                eVar.b();
            }
        }
        e peekLast = this.f188h.peekLast();
        Iterator<b> it = this.f192l.iterator();
        while (it.hasNext()) {
            it.next().a(this, peekLast.c, peekLast.f1918d);
        }
        return true;
    }

    public e.t.j b(int i2) {
        e.t.j jVar;
        k kVar;
        k kVar2 = this.f184d;
        if (kVar2 == null) {
            return null;
        }
        if (kVar2.f1935d == i2) {
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

    public e.t.j c() {
        e last = this.f188h.isEmpty() ? null : this.f188h.getLast();
        if (last != null) {
            return last.c;
        }
        return null;
    }

    public final void d(e.t.j jVar, Bundle bundle, o oVar, q.a aVar) {
        int i2;
        boolean z = false;
        boolean f2 = (oVar == null || (i2 = oVar.b) == -1) ? false : f(i2, oVar.c);
        q c = this.f191k.c(jVar.b);
        Bundle h2 = jVar.h(bundle);
        e.t.j b2 = c.b(jVar, h2, oVar, null);
        if (b2 != null) {
            if (!(b2 instanceof e.t.b)) {
                while (!this.f188h.isEmpty() && (this.f188h.peekLast().c instanceof e.t.b) && f(this.f188h.peekLast().c.f1935d, true)) {
                }
            }
            if (this.f188h.isEmpty()) {
                this.f188h.add(new e(this.a, this.f184d, h2, this.f189i, this.f190j));
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            e.t.j jVar2 = b2;
            while (jVar2 != null && b(jVar2.f1935d) == null) {
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
                peekLast.f1918d = bundle;
            }
            z = true;
        }
        h();
        if (f2 || b2 != null || z) {
            a();
        }
    }

    public boolean e() {
        if (!this.f188h.isEmpty() && f(c().f1935d, true) && a()) {
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
            e.t.j jVar = descendingIterator.next().c;
            q c = this.f191k.c(jVar.b);
            if (z || jVar.f1935d != i2) {
                arrayList.add(c);
            }
            if (jVar.f1935d == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            e.t.j.i(this.a, i2);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((q) it.next()).e()) {
            e removeLast = this.f188h.removeLast();
            removeLast.f1923i = h.b.DESTROYED;
            removeLast.b();
            g gVar = this.f190j;
            if (!(gVar == null || (remove = gVar.c.remove(removeLast.f1921g)) == null)) {
                remove.a();
            }
            z3 = true;
        }
        h();
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x02fd, code lost:
        if (r0 == false) goto L_0x0300;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void g(int i2, Bundle bundle) {
        Activity activity;
        boolean z;
        String str;
        k kVar;
        e.t.j jVar;
        k kVar2;
        j.a j2;
        ArrayList<String> stringArrayList;
        if (this.c == null) {
            this.c = new n(this.a, this.f191k);
        }
        k c = this.c.c(i2);
        k kVar3 = this.f184d;
        boolean z2 = true;
        if (kVar3 != null) {
            f(kVar3.f1935d, true);
        }
        this.f184d = c;
        Bundle bundle2 = this.f185e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                q c2 = this.f191k.c(next);
                Bundle bundle3 = this.f185e.getBundle(next);
                if (bundle3 != null) {
                    c2.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f186f;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                f fVar = (f) parcelable;
                e.t.j b2 = b(fVar.c);
                if (b2 != null) {
                    Bundle bundle4 = fVar.f1926d;
                    if (bundle4 != null) {
                        bundle4.setClassLoader(this.a.getClassLoader());
                    }
                    this.f188h.add(new e(this.a, b2, bundle4, this.f189i, this.f190j, fVar.b, fVar.f1927e));
                } else {
                    StringBuilder j3 = f.a.a.a.a.j("Restoring the Navigation back stack failed: destination ", e.t.j.i(this.a, fVar.c), " cannot be found from the current destination ");
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
                    e.t.j jVar2 = j2.b;
                    Objects.requireNonNull(jVar2);
                    ArrayDeque arrayDeque = new ArrayDeque();
                    while (true) {
                        k kVar4 = jVar2.c;
                        if (kVar4 == null || kVar4.f1945k != jVar2.f1935d) {
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
                        intArray[i3] = ((e.t.j) it2.next()).f1935d;
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
                            if (jVar.f1935d != i5) {
                                jVar = null;
                            }
                        } else {
                            jVar = kVar5.n(i5);
                        }
                        if (jVar == null) {
                            str = e.t.j.i(this.a, i5);
                            break;
                        }
                        if (i4 != intArray.length - 1) {
                            while (true) {
                                kVar2 = (k) jVar;
                                if (!(kVar2.n(kVar2.f1945k) instanceof k)) {
                                    break;
                                }
                                jVar = kVar2.n(kVar2.f1945k);
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
                                        Intent z0 = m.e.z0(context, component);
                                        if (z0 == null) {
                                            break;
                                        }
                                        arrayList.add(size, z0);
                                        component = z0.getComponent();
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        throw new IllegalArgumentException(e2);
                                    }
                                }
                            }
                            arrayList.add(intent);
                            if (!arrayList.isEmpty()) {
                                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                                Object obj = e.j.b.a.a;
                                a.C0036a.a(context, intentArr, null);
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
                                f(this.f184d.f1935d, true);
                            }
                            int i7 = 0;
                            while (i7 < intArray.length) {
                                int i8 = i7 + 1;
                                int i9 = intArray[i7];
                                e.t.j b3 = b(i9);
                                if (b3 != null) {
                                    d(b3, bundle5, new o(false, -1, false, 0, 0, -1, -1), null);
                                    i7 = i8;
                                } else {
                                    StringBuilder j4 = f.a.a.a.a.j("Deep Linking failed: destination ", e.t.j.i(this.a, i9), " cannot be found from the current destination ");
                                    j4.append(c());
                                    throw new IllegalStateException(j4.toString());
                                }
                            }
                        } else {
                            k kVar6 = this.f184d;
                            int i10 = 0;
                            while (i10 < intArray.length) {
                                int i11 = intArray[i10];
                                e.t.j n = i10 == 0 ? this.f184d : kVar6.n(i11);
                                if (n != null) {
                                    if (i10 != intArray.length - 1) {
                                        while (true) {
                                            kVar = (k) n;
                                            if (!(kVar.n(kVar.f1945k) instanceof k)) {
                                                break;
                                            }
                                            n = kVar.n(kVar.f1945k);
                                        }
                                        kVar6 = kVar;
                                    } else {
                                        d(n, n.h(bundle5), new o(false, this.f184d.f1935d, true, 0, 0, -1, -1), null);
                                    }
                                    i10++;
                                } else {
                                    throw new IllegalStateException("Deep Linking failed: destination " + e.t.j.i(this.a, i11) + " cannot be found in graph " + kVar6);
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
