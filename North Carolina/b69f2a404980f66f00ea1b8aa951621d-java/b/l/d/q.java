package b.l.d;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.i.h.a;
import b.i.l.m;
import b.l.d.g0;
import b.l.d.u;
import b.l.d.z;
import b.n.a0;
import b.n.f;
import b.n.j;
import b.n.x;
import b.n.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class q {
    public ArrayList<Fragment> A;
    public ArrayList<g> B;
    public u C;
    public Runnable D = new d();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<e> f1328a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f1329b;

    /* renamed from: c  reason: collision with root package name */
    public final y f1330c = new y();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f1331d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f1332e;
    public final o f = new o(this);
    public OnBackPressedDispatcher g;
    public final b.a.b h = new a(false);
    public final AtomicInteger i = new AtomicInteger();
    public ConcurrentHashMap<Fragment, HashSet<b.i.h.a>> j = new ConcurrentHashMap<>();
    public final g0.a k = new b();
    public final p l = new p(this);
    public int m = -1;
    public n<?> n;
    public j o;
    public Fragment p;
    public Fragment q;
    public m r = null;
    public m s = new c();
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public ArrayList<a> y;
    public ArrayList<Boolean> z;

    public class a extends b.a.b {
        public a(boolean z) {
            super(z);
        }
    }

    public class b implements g0.a {
        public b() {
        }

        public void a(Fragment fragment, b.i.h.a aVar) {
            boolean z;
            synchronized (aVar) {
                z = aVar.f1065a;
            }
            if (!z) {
                q qVar = q.this;
                HashSet<b.i.h.a> hashSet = qVar.j.get(fragment);
                if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
                    qVar.j.remove(fragment);
                    if (fragment.mState < 3) {
                        qVar.j(fragment);
                        qVar.W(fragment, fragment.getStateAfterAnimating());
                    }
                }
            }
        }

        public void b(Fragment fragment, b.i.h.a aVar) {
            q qVar = q.this;
            if (qVar.j.get(fragment) == null) {
                qVar.j.put(fragment, new HashSet<>());
            }
            qVar.j.get(fragment).add(aVar);
        }
    }

    public class c extends m {
        public c() {
        }

        @Override // b.l.d.m
        public Fragment a(ClassLoader classLoader, String str) {
            n<?> nVar = q.this.n;
            Context context = nVar.f1321c;
            if (nVar != null) {
                return Fragment.instantiate(context, str, null);
            }
            throw null;
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            q.this.D(true);
        }
    }

    public interface e {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class f implements e {

        /* renamed from: a  reason: collision with root package name */
        public final String f1337a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1338b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1339c;

        public f(String str, int i, int i2) {
            this.f1337a = str;
            this.f1338b = i;
            this.f1339c = i2;
        }

        @Override // b.l.d.q.e
        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = q.this.q;
            if (fragment == null || this.f1338b >= 0 || this.f1337a != null || !fragment.getChildFragmentManager().b0()) {
                return q.this.c0(arrayList, arrayList2, this.f1337a, this.f1338b, this.f1339c);
            }
            return false;
        }
    }

    public static class g implements Fragment.f {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1341a;

        /* renamed from: b  reason: collision with root package name */
        public final a f1342b;

        /* renamed from: c  reason: collision with root package name */
        public int f1343c;

        public g(a aVar, boolean z) {
            this.f1341a = z;
            this.f1342b = aVar;
        }

        public void a() {
            boolean z = this.f1343c > 0;
            for (Fragment fragment : this.f1342b.r.f1330c.g()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            a aVar = this.f1342b;
            aVar.r.i(aVar, this.f1341a, !z, true);
        }
    }

    public static boolean P(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public final void A() {
        if (!this.j.isEmpty()) {
            for (Fragment fragment : this.j.keySet()) {
                g(fragment);
                W(fragment, fragment.getStateAfterAnimating());
            }
        }
    }

    public void B(e eVar, boolean z2) {
        if (!z2) {
            if (this.n == null) {
                if (this.w) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (S()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1328a) {
            if (this.n != null) {
                this.f1328a.add(eVar);
                j0();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void C(boolean z2) {
        if (this.f1329b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.n == null) {
            if (this.w) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.n.f1322d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z2 || !S()) {
            if (this.y == null) {
                this.y = new ArrayList<>();
                this.z = new ArrayList<>();
            }
            this.f1329b = true;
            try {
                G(null, null);
            } finally {
                this.f1329b = false;
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean D(boolean z2) {
        boolean z3;
        C(z2);
        boolean z4 = false;
        while (true) {
            ArrayList<a> arrayList = this.y;
            ArrayList<Boolean> arrayList2 = this.z;
            synchronized (this.f1328a) {
                if (this.f1328a.isEmpty()) {
                    z3 = false;
                } else {
                    int size = this.f1328a.size();
                    z3 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z3 |= this.f1328a.get(i2).a(arrayList, arrayList2);
                    }
                    this.f1328a.clear();
                    this.n.f1322d.removeCallbacks(this.D);
                }
            }
            if (z3) {
                this.f1329b = true;
                try {
                    f0(this.y, this.z);
                    h();
                    z4 = true;
                } catch (Throwable th) {
                    h();
                    throw th;
                }
            } else {
                r0();
                y();
                this.f1330c.b();
                return z4;
            }
        }
    }

    public void E(e eVar, boolean z2) {
        if (!z2 || (this.n != null && !this.w)) {
            C(z2);
            if (eVar.a(this.y, this.z)) {
                this.f1329b = true;
                try {
                    f0(this.y, this.z);
                } finally {
                    h();
                }
            }
            r0();
            y();
            this.f1330c.b();
        }
    }

    public final void F(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        int i9;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z3 = arrayList.get(i2).p;
        ArrayList<Fragment> arrayList4 = this.A;
        if (arrayList4 == null) {
            this.A = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.A.addAll(this.f1330c.g());
        Fragment fragment = this.q;
        int i10 = i2;
        int i11 = 0;
        while (true) {
            int i12 = 1;
            if (i10 < i3) {
                a aVar = arrayList.get(i10);
                int i13 = 3;
                if (!arrayList3.get(i10).booleanValue()) {
                    ArrayList<Fragment> arrayList5 = this.A;
                    int i14 = 0;
                    while (i14 < aVar.f1365a.size()) {
                        z.a aVar2 = aVar.f1365a.get(i14);
                        int i15 = aVar2.f1370a;
                        if (i15 != i12) {
                            if (i15 == 2) {
                                Fragment fragment2 = aVar2.f1371b;
                                int i16 = fragment2.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z4 = false;
                                while (size >= 0) {
                                    Fragment fragment3 = arrayList5.get(size);
                                    if (fragment3.mContainerId != i16) {
                                        i9 = i16;
                                    } else if (fragment3 == fragment2) {
                                        i9 = i16;
                                        z4 = true;
                                    } else {
                                        if (fragment3 == fragment) {
                                            i9 = i16;
                                            aVar.f1365a.add(i14, new z.a(9, fragment3));
                                            i14++;
                                            fragment = null;
                                        } else {
                                            i9 = i16;
                                        }
                                        z.a aVar3 = new z.a(3, fragment3);
                                        aVar3.f1372c = aVar2.f1372c;
                                        aVar3.f1374e = aVar2.f1374e;
                                        aVar3.f1373d = aVar2.f1373d;
                                        aVar3.f = aVar2.f;
                                        aVar.f1365a.add(i14, aVar3);
                                        arrayList5.remove(fragment3);
                                        i14++;
                                    }
                                    size--;
                                    i16 = i9;
                                }
                                if (z4) {
                                    aVar.f1365a.remove(i14);
                                    i14--;
                                } else {
                                    i8 = 1;
                                    aVar2.f1370a = 1;
                                    arrayList5.add(fragment2);
                                    i14 += i8;
                                    i12 = i8;
                                    i13 = 3;
                                }
                            } else if (i15 == i13 || i15 == 6) {
                                arrayList5.remove(aVar2.f1371b);
                                Fragment fragment4 = aVar2.f1371b;
                                if (fragment4 == fragment) {
                                    aVar.f1365a.add(i14, new z.a(9, fragment4));
                                    i14++;
                                    fragment = null;
                                }
                            } else if (i15 == 7) {
                                i8 = 1;
                            } else if (i15 == 8) {
                                aVar.f1365a.add(i14, new z.a(9, fragment));
                                i14++;
                                fragment = aVar2.f1371b;
                            }
                            i8 = 1;
                            i14 += i8;
                            i12 = i8;
                            i13 = 3;
                        } else {
                            i8 = i12;
                        }
                        arrayList5.add(aVar2.f1371b);
                        i14 += i8;
                        i12 = i8;
                        i13 = 3;
                    }
                    i7 = i12;
                } else {
                    i7 = 1;
                    ArrayList<Fragment> arrayList6 = this.A;
                    for (int size2 = aVar.f1365a.size() - 1; size2 >= 0; size2--) {
                        z.a aVar4 = aVar.f1365a.get(size2);
                        int i17 = aVar4.f1370a;
                        if (i17 != 1) {
                            if (i17 != 3) {
                                switch (i17) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = aVar4.f1371b;
                                        break;
                                    case 10:
                                        aVar4.h = aVar4.g;
                                        break;
                                }
                            }
                            arrayList6.add(aVar4.f1371b);
                        }
                        arrayList6.remove(aVar4.f1371b);
                    }
                }
                i11 = (i11 != 0 || aVar.g) ? i7 : 0;
                i10++;
                arrayList3 = arrayList2;
            } else {
                this.A.clear();
                if (!z3) {
                    g0.p(this, arrayList, arrayList2, i2, i3, false, this.k);
                }
                int i18 = i2;
                while (i18 < i3) {
                    a aVar5 = arrayList.get(i18);
                    if (arrayList2.get(i18).booleanValue()) {
                        aVar5.l(-1);
                        aVar5.p(i18 == i3 + -1);
                    } else {
                        aVar5.l(1);
                        aVar5.o();
                    }
                    i18++;
                }
                if (z3) {
                    b.e.c<Fragment> cVar = new b.e.c<>();
                    a(cVar);
                    i5 = i2;
                    int i19 = i3;
                    for (int i20 = i3 - 1; i20 >= i5; i20--) {
                        a aVar6 = arrayList.get(i20);
                        boolean booleanValue = arrayList2.get(i20).booleanValue();
                        int i21 = 0;
                        while (true) {
                            if (i21 >= aVar6.f1365a.size()) {
                                z2 = false;
                            } else if (a.s(aVar6.f1365a.get(i21))) {
                                z2 = true;
                            } else {
                                i21++;
                            }
                        }
                        if (z2 && !aVar6.r(arrayList, i20 + 1, i3)) {
                            if (this.B == null) {
                                this.B = new ArrayList<>();
                            }
                            g gVar = new g(aVar6, booleanValue);
                            this.B.add(gVar);
                            for (int i22 = 0; i22 < aVar6.f1365a.size(); i22++) {
                                z.a aVar7 = aVar6.f1365a.get(i22);
                                if (a.s(aVar7)) {
                                    aVar7.f1371b.setOnStartEnterTransitionListener(gVar);
                                }
                            }
                            if (booleanValue) {
                                aVar6.o();
                            } else {
                                aVar6.p(false);
                            }
                            i19--;
                            if (i20 != i19) {
                                arrayList.remove(i20);
                                arrayList.add(i19, aVar6);
                            }
                            a(cVar);
                        }
                    }
                    i4 = 0;
                    int i23 = cVar.f798d;
                    for (int i24 = 0; i24 < i23; i24++) {
                        Fragment fragment5 = (Fragment) cVar.f797c[i24];
                        if (!fragment5.mAdded) {
                            View requireView = fragment5.requireView();
                            fragment5.mPostponedAlpha = requireView.getAlpha();
                            requireView.setAlpha(0.0f);
                        }
                    }
                    i6 = i19;
                } else {
                    i5 = i2;
                    i4 = 0;
                    i6 = i3;
                }
                if (i6 != i5 && z3) {
                    g0.p(this, arrayList, arrayList2, i2, i6, true, this.k);
                    V(this.m, true);
                }
                while (i5 < i3) {
                    a aVar8 = arrayList.get(i5);
                    if (arrayList2.get(i5).booleanValue() && aVar8.t >= 0) {
                        aVar8.t = -1;
                    }
                    if (aVar8.q != null) {
                        for (int i25 = i4; i25 < aVar8.q.size(); i25++) {
                            aVar8.q.get(i25).run();
                        }
                        aVar8.q = null;
                    }
                    i5++;
                }
                return;
            }
        }
    }

    public final void G(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<g> arrayList3 = this.B;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = this.B.get(i2);
            if (arrayList == null || gVar.f1341a || (indexOf2 = arrayList.indexOf(gVar.f1342b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((gVar.f1343c == 0) || (arrayList != null && gVar.f1342b.r(arrayList, 0, arrayList.size()))) {
                    this.B.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || gVar.f1341a || (indexOf = arrayList.indexOf(gVar.f1342b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        gVar.a();
                    }
                }
                i2++;
            } else {
                this.B.remove(i2);
                i2--;
                size--;
            }
            a aVar = gVar.f1342b;
            aVar.r.i(aVar, gVar.f1341a, false, false);
            i2++;
        }
    }

    public Fragment H(String str) {
        return this.f1330c.e(str);
    }

    public Fragment I(int i2) {
        y yVar = this.f1330c;
        int size = yVar.f1363a.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = yVar.f1363a.get(size);
                if (fragment != null && fragment.mFragmentId == i2) {
                    return fragment;
                }
            } else {
                for (w wVar : yVar.f1364b.values()) {
                    if (wVar != null) {
                        Fragment fragment2 = wVar.f1361b;
                        if (fragment2.mFragmentId == i2) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public Fragment J(String str) {
        y yVar = this.f1330c;
        if (yVar != null) {
            int size = yVar.f1363a.size();
            while (true) {
                size--;
                if (size >= 0) {
                    Fragment fragment = yVar.f1363a.get(size);
                    if (fragment != null && str.equals(fragment.mTag)) {
                        return fragment;
                    }
                } else {
                    for (w wVar : yVar.f1364b.values()) {
                        if (wVar != null) {
                            Fragment fragment2 = wVar.f1361b;
                            if (str.equals(fragment2.mTag)) {
                                return fragment2;
                            }
                        }
                    }
                    return null;
                }
            }
        } else {
            throw null;
        }
    }

    public Fragment K(String str) {
        Fragment findFragmentByWho;
        for (w wVar : this.f1330c.f1364b.values()) {
            if (!(wVar == null || (findFragmentByWho = wVar.f1361b.findFragmentByWho(str)) == null)) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public Fragment L(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment e2 = this.f1330c.e(string);
        if (e2 != null) {
            return e2;
        }
        q0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public final ViewGroup M(Fragment fragment) {
        if (fragment.mContainerId > 0 && this.o.b()) {
            View a2 = this.o.a(fragment.mContainerId);
            if (a2 instanceof ViewGroup) {
                return (ViewGroup) a2;
            }
        }
        return null;
    }

    public m N() {
        m mVar = this.r;
        if (mVar != null) {
            return mVar;
        }
        Fragment fragment = this.p;
        return fragment != null ? fragment.mFragmentManager.N() : this.s;
    }

    public void O(Fragment fragment) {
        if (P(2)) {
            String str = "hide: " + fragment;
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            n0(fragment);
        }
    }

    public final boolean Q(Fragment fragment) {
        boolean z2;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        q qVar = fragment.mChildFragmentManager;
        Iterator it = ((ArrayList) qVar.f1330c.f()).iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z3 = qVar.Q(fragment2);
                continue;
            }
            if (z3) {
                z2 = true;
                break;
            }
        }
        return z2;
    }

    public boolean R(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        q qVar = fragment.mFragmentManager;
        if (!fragment.equals(qVar.q) || !R(qVar.p)) {
            return false;
        }
        return true;
    }

    public boolean S() {
        return this.u || this.v;
    }

    public void T(Fragment fragment) {
        if (!this.f1330c.c(fragment.mWho)) {
            w wVar = new w(this.l, fragment);
            wVar.a(this.n.f1321c.getClassLoader());
            this.f1330c.f1364b.put(wVar.f1361b.mWho, wVar);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    c(fragment);
                } else {
                    g0(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            wVar.f1362c = this.m;
            if (P(2)) {
                String str = "Added fragment to active set " + fragment;
            }
        }
    }

    public void U(Fragment fragment) {
        Animator animator;
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (this.f1330c.c(fragment.mWho)) {
            W(fragment, this.m);
            View view = fragment.mView;
            if (view != null) {
                y yVar = this.f1330c;
                Fragment fragment2 = null;
                if (yVar != null) {
                    ViewGroup viewGroup2 = fragment.mContainer;
                    if (viewGroup2 != null && view != null) {
                        int indexOf = yVar.f1363a.indexOf(fragment);
                        while (true) {
                            indexOf--;
                            if (indexOf < 0) {
                                break;
                            }
                            Fragment fragment3 = yVar.f1363a.get(indexOf);
                            if (fragment3.mContainer == viewGroup2 && fragment3.mView != null) {
                                fragment2 = fragment3;
                                break;
                            }
                        }
                    }
                    if (fragment2 != null && (indexOfChild2 = viewGroup.indexOfChild(fragment.mView)) < (indexOfChild = (viewGroup = fragment.mContainer).indexOfChild(fragment2.mView))) {
                        viewGroup.removeViewAt(indexOfChild2);
                        viewGroup.addView(fragment.mView, indexOfChild);
                    }
                    if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                        float f2 = fragment.mPostponedAlpha;
                        if (f2 > 0.0f) {
                            fragment.mView.setAlpha(f2);
                        }
                        fragment.mPostponedAlpha = 0.0f;
                        fragment.mIsNewlyAdded = false;
                        h w0 = i.j.w0(this.n.f1321c, this.o, fragment, true);
                        if (w0 != null) {
                            Animation animation = w0.f1290a;
                            if (animation != null) {
                                fragment.mView.startAnimation(animation);
                            } else {
                                w0.f1291b.setTarget(fragment.mView);
                                w0.f1291b.start();
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
            if (fragment.mHiddenChanged) {
                if (fragment.mView != null) {
                    h w02 = i.j.w0(this.n.f1321c, this.o, fragment, !fragment.mHidden);
                    if (w02 == null || (animator = w02.f1291b) == null) {
                        if (w02 != null) {
                            fragment.mView.startAnimation(w02.f1290a);
                            w02.f1290a.start();
                        }
                        fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                        if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        }
                    } else {
                        animator.setTarget(fragment.mView);
                        if (!fragment.mHidden) {
                            fragment.mView.setVisibility(0);
                        } else if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        } else {
                            ViewGroup viewGroup3 = fragment.mContainer;
                            View view2 = fragment.mView;
                            viewGroup3.startViewTransition(view2);
                            w02.f1291b.addListener(new r(this, viewGroup3, view2, fragment));
                        }
                        w02.f1291b.start();
                    }
                }
                if (fragment.mAdded && Q(fragment)) {
                    this.t = true;
                }
                fragment.mHiddenChanged = false;
                fragment.onHiddenChanged(fragment.mHidden);
            }
        } else if (P(3)) {
            String str = "Ignoring moving " + fragment + " to state " + this.m + "since it is not added to " + this;
        }
    }

    public void V(int i2, boolean z2) {
        n<?> nVar;
        if (this.n == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.m) {
            this.m = i2;
            for (Fragment fragment : this.f1330c.g()) {
                U(fragment);
            }
            Iterator it = ((ArrayList) this.f1330c.f()).iterator();
            while (it.hasNext()) {
                Fragment fragment2 = (Fragment) it.next();
                if (fragment2 != null && !fragment2.mIsNewlyAdded) {
                    U(fragment2);
                }
            }
            p0();
            if (this.t && (nVar = this.n) != null && this.m == 4) {
                d.this.supportInvalidateOptionsMenu();
                this.t = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
        if (r2 != 3) goto L_0x06a5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:201:0x047d */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x047d A[LOOP:0: B:201:0x047d->B:329:0x047d, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x021a  */
    public void W(Fragment fragment, int i2) {
        boolean z2;
        Fragment e2;
        ViewGroup viewGroup;
        String str;
        w wVar = this.f1330c.f1364b.get(fragment.mWho);
        boolean z3 = true;
        if (wVar == null) {
            wVar = new w(this.l, fragment);
            wVar.f1362c = 1;
        }
        int i3 = wVar.f1362c;
        Fragment fragment2 = wVar.f1361b;
        if (fragment2.mFromLayout) {
            i3 = fragment2.mInLayout ? Math.max(i3, 1) : i3 < 2 ? Math.min(i3, fragment2.mState) : Math.min(i3, 1);
        }
        if (!wVar.f1361b.mAdded) {
            i3 = Math.min(i3, 1);
        }
        Fragment fragment3 = wVar.f1361b;
        if (fragment3.mRemoving) {
            i3 = fragment3.isInBackStack() ? Math.min(i3, 1) : Math.min(i3, -1);
        }
        Fragment fragment4 = wVar.f1361b;
        if (fragment4.mDeferStart && fragment4.mState < 3) {
            i3 = Math.min(i3, 2);
        }
        int ordinal = wVar.f1361b.mMaxState.ordinal();
        if (ordinal == 2) {
            i3 = Math.min(i3, 1);
        } else if (ordinal == 3) {
            i3 = Math.min(i3, 3);
        } else if (ordinal != 4) {
            i3 = Math.min(i3, -1);
        }
        int min = Math.min(i2, i3);
        int i4 = fragment.mState;
        h hVar = null;
        if (i4 <= min) {
            if (i4 < min && !this.j.isEmpty()) {
                g(fragment);
            }
            int i5 = fragment.mState;
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                        }
                        if (min > 2) {
                            if (P(3)) {
                                StringBuilder g2 = c.a.a.a.a.g("moveto STARTED: ");
                                g2.append(wVar.f1361b);
                                g2.toString();
                            }
                            wVar.f1361b.performStart();
                            wVar.f1360a.k(wVar.f1361b, false);
                        }
                        if (min > 3) {
                            if (P(3)) {
                                StringBuilder g3 = c.a.a.a.a.g("moveto RESUMED: ");
                                g3.append(wVar.f1361b);
                                g3.toString();
                            }
                            wVar.f1361b.performResume();
                            wVar.f1360a.i(wVar.f1361b, false);
                            Fragment fragment5 = wVar.f1361b;
                            fragment5.mSavedFragmentState = null;
                            fragment5.mSavedViewState = null;
                        }
                    }
                    if (min > -1) {
                        Fragment fragment6 = wVar.f1361b;
                        if (fragment6.mFromLayout && fragment6.mInLayout && !fragment6.mPerformedCreateView) {
                            if (P(3)) {
                                StringBuilder g4 = c.a.a.a.a.g("moveto CREATE_VIEW: ");
                                g4.append(wVar.f1361b);
                                g4.toString();
                            }
                            Fragment fragment7 = wVar.f1361b;
                            fragment7.performCreateView(fragment7.performGetLayoutInflater(fragment7.mSavedFragmentState), null, wVar.f1361b.mSavedFragmentState);
                            View view = wVar.f1361b.mView;
                            if (view != null) {
                                view.setSaveFromParentEnabled(false);
                                Fragment fragment8 = wVar.f1361b;
                                fragment8.mView.setTag(b.l.b.fragment_container_view_tag, fragment8);
                                Fragment fragment9 = wVar.f1361b;
                                if (fragment9.mHidden) {
                                    fragment9.mView.setVisibility(8);
                                }
                                Fragment fragment10 = wVar.f1361b;
                                fragment10.onViewCreated(fragment10.mView, fragment10.mSavedFragmentState);
                                p pVar = wVar.f1360a;
                                Fragment fragment11 = wVar.f1361b;
                                pVar.m(fragment11, fragment11.mView, fragment11.mSavedFragmentState, false);
                            }
                        }
                    }
                    if (min > 1) {
                        j jVar = this.o;
                        if (!wVar.f1361b.mFromLayout) {
                            if (P(3)) {
                                StringBuilder g5 = c.a.a.a.a.g("moveto CREATE_VIEW: ");
                                g5.append(wVar.f1361b);
                                g5.toString();
                            }
                            Fragment fragment12 = wVar.f1361b;
                            ViewGroup viewGroup2 = fragment12.mContainer;
                            if (viewGroup2 == null) {
                                int i6 = fragment12.mContainerId;
                                if (i6 == 0) {
                                    viewGroup2 = null;
                                } else if (i6 != -1) {
                                    viewGroup2 = (ViewGroup) jVar.a(i6);
                                    if (viewGroup2 == null) {
                                        Fragment fragment13 = wVar.f1361b;
                                        if (!fragment13.mRestored) {
                                            try {
                                                str = fragment13.getResources().getResourceName(wVar.f1361b.mContainerId);
                                            } catch (Resources.NotFoundException unused) {
                                                str = "unknown";
                                            }
                                            StringBuilder g6 = c.a.a.a.a.g("No view found for id 0x");
                                            g6.append(Integer.toHexString(wVar.f1361b.mContainerId));
                                            g6.append(" (");
                                            g6.append(str);
                                            g6.append(") for fragment ");
                                            g6.append(wVar.f1361b);
                                            throw new IllegalArgumentException(g6.toString());
                                        }
                                    }
                                } else {
                                    StringBuilder g7 = c.a.a.a.a.g("Cannot create fragment ");
                                    g7.append(wVar.f1361b);
                                    g7.append(" for a container view with no id");
                                    throw new IllegalArgumentException(g7.toString());
                                }
                            }
                            Fragment fragment14 = wVar.f1361b;
                            fragment14.mContainer = viewGroup2;
                            fragment14.performCreateView(fragment14.performGetLayoutInflater(fragment14.mSavedFragmentState), viewGroup2, wVar.f1361b.mSavedFragmentState);
                            View view2 = wVar.f1361b.mView;
                            if (view2 != null) {
                                view2.setSaveFromParentEnabled(false);
                                Fragment fragment15 = wVar.f1361b;
                                fragment15.mView.setTag(b.l.b.fragment_container_view_tag, fragment15);
                                if (viewGroup2 != null) {
                                    viewGroup2.addView(wVar.f1361b.mView);
                                }
                                Fragment fragment16 = wVar.f1361b;
                                if (fragment16.mHidden) {
                                    fragment16.mView.setVisibility(8);
                                }
                                m.R(wVar.f1361b.mView);
                                Fragment fragment17 = wVar.f1361b;
                                fragment17.onViewCreated(fragment17.mView, fragment17.mSavedFragmentState);
                                p pVar2 = wVar.f1360a;
                                Fragment fragment18 = wVar.f1361b;
                                pVar2.m(fragment18, fragment18.mView, fragment18.mSavedFragmentState, false);
                                Fragment fragment19 = wVar.f1361b;
                                if (fragment19.mView.getVisibility() != 0 || wVar.f1361b.mContainer == null) {
                                    z3 = false;
                                }
                                fragment19.mIsNewlyAdded = z3;
                            }
                        }
                        if (P(3)) {
                            StringBuilder g8 = c.a.a.a.a.g("moveto ACTIVITY_CREATED: ");
                            g8.append(wVar.f1361b);
                            g8.toString();
                        }
                        Fragment fragment20 = wVar.f1361b;
                        fragment20.performActivityCreated(fragment20.mSavedFragmentState);
                        p pVar3 = wVar.f1360a;
                        Fragment fragment21 = wVar.f1361b;
                        pVar3.a(fragment21, fragment21.mSavedFragmentState, false);
                        if (P(3)) {
                            StringBuilder g9 = c.a.a.a.a.g("moveto RESTORE_VIEW_STATE: ");
                            g9.append(wVar.f1361b);
                            g9.toString();
                        }
                        Fragment fragment22 = wVar.f1361b;
                        if (fragment22.mView != null) {
                            fragment22.restoreViewState(fragment22.mSavedFragmentState);
                        }
                        wVar.f1361b.mSavedFragmentState = null;
                    }
                    if (min > 2) {
                    }
                    if (min > 3) {
                    }
                }
            } else if (min > -1) {
                if (P(3)) {
                    String str2 = "moveto ATTACHED: " + fragment;
                }
                Fragment fragment23 = fragment.mTarget;
                if (fragment23 != null) {
                    if (fragment23.equals(H(fragment23.mWho))) {
                        Fragment fragment24 = fragment.mTarget;
                        if (fragment24.mState < 1) {
                            W(fragment24, 1);
                        }
                        fragment.mTargetWho = fragment.mTarget.mWho;
                        fragment.mTarget = null;
                    } else {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
                    }
                }
                String str3 = fragment.mTargetWho;
                if (str3 != null) {
                    Fragment e3 = this.f1330c.e(str3);
                    if (e3 == null) {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTargetWho + " that does not belong to this FragmentManager!");
                    } else if (e3.mState < 1) {
                        W(e3, 1);
                    }
                }
                n<?> nVar = this.n;
                Fragment fragment25 = this.p;
                Fragment fragment26 = wVar.f1361b;
                fragment26.mHost = nVar;
                fragment26.mParentFragment = fragment25;
                fragment26.mFragmentManager = this;
                wVar.f1360a.g(fragment26, nVar.f1321c, false);
                wVar.f1361b.performAttach();
                Fragment fragment27 = wVar.f1361b;
                Fragment fragment28 = fragment27.mParentFragment;
                if (fragment28 == null) {
                    d.this.onAttachFragment(fragment27);
                } else {
                    fragment28.onAttachFragment(fragment27);
                }
                wVar.f1360a.b(wVar.f1361b, nVar.f1321c, false);
            }
            if (min > 0) {
                if (P(3)) {
                    StringBuilder g10 = c.a.a.a.a.g("moveto CREATED: ");
                    g10.append(wVar.f1361b);
                    g10.toString();
                }
                Fragment fragment29 = wVar.f1361b;
                if (!fragment29.mIsCreated) {
                    wVar.f1360a.h(fragment29, fragment29.mSavedFragmentState, false);
                    Fragment fragment30 = wVar.f1361b;
                    fragment30.performCreate(fragment30.mSavedFragmentState);
                    p pVar4 = wVar.f1360a;
                    Fragment fragment31 = wVar.f1361b;
                    pVar4.c(fragment31, fragment31.mSavedFragmentState, false);
                } else {
                    fragment29.restoreChildFragmentState(fragment29.mSavedFragmentState);
                    wVar.f1361b.mState = 1;
                }
            }
            if (min > -1) {
            }
            if (min > 1) {
            }
            if (min > 2) {
            }
            if (min > 3) {
            }
        } else if (i4 > min) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 4) {
                                if (min < 4) {
                                    if (P(3)) {
                                        StringBuilder g11 = c.a.a.a.a.g("movefrom RESUMED: ");
                                        g11.append(wVar.f1361b);
                                        g11.toString();
                                    }
                                    wVar.f1361b.performPause();
                                    wVar.f1360a.f(wVar.f1361b, false);
                                }
                            }
                        }
                        if (min < 3) {
                            if (P(3)) {
                                StringBuilder g12 = c.a.a.a.a.g("movefrom STARTED: ");
                                g12.append(wVar.f1361b);
                                g12.toString();
                            }
                            wVar.f1361b.performStop();
                            wVar.f1360a.l(wVar.f1361b, false);
                        }
                    }
                    if (min < 2) {
                        if (P(3)) {
                            String str4 = "movefrom ACTIVITY_CREATED: " + fragment;
                        }
                        if (fragment.mView != null && (!d.this.isFinishing()) && fragment.mSavedViewState == null) {
                            wVar.c();
                        }
                        View view3 = fragment.mView;
                        if (!(view3 == null || (viewGroup = fragment.mContainer) == null)) {
                            viewGroup.endViewTransition(view3);
                            fragment.mView.clearAnimation();
                            if (!fragment.isRemovingParent()) {
                                if (this.m > -1 && !this.w && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f) {
                                    hVar = i.j.w0(this.n.f1321c, this.o, fragment, false);
                                }
                                fragment.mPostponedAlpha = 0.0f;
                                ViewGroup viewGroup3 = fragment.mContainer;
                                View view4 = fragment.mView;
                                if (hVar != null) {
                                    fragment.setStateAfterAnimating(min);
                                    g0.a aVar = this.k;
                                    View view5 = fragment.mView;
                                    ViewGroup viewGroup4 = fragment.mContainer;
                                    viewGroup4.startViewTransition(view5);
                                    b.i.h.a aVar2 = new b.i.h.a();
                                    e eVar = new e(fragment);
                                    synchronized (aVar2) {
                                        while (aVar2.f1067c) {
                                            aVar2.wait();
                                        }
                                        if (aVar2.f1066b != eVar) {
                                            aVar2.f1066b = eVar;
                                            if (aVar2.f1065a) {
                                                eVar.a();
                                            }
                                        }
                                    }
                                    b bVar = (b) aVar;
                                    bVar.b(fragment, aVar2);
                                    if (hVar.f1290a != null) {
                                        i iVar = new i(hVar.f1290a, viewGroup4, view5);
                                        fragment.setAnimatingAway(fragment.mView);
                                        iVar.setAnimationListener(new f(viewGroup4, fragment, bVar, aVar2));
                                        fragment.mView.startAnimation(iVar);
                                    } else {
                                        Animator animator = hVar.f1291b;
                                        fragment.setAnimator(animator);
                                        animator.addListener(new g(viewGroup4, view5, fragment, bVar, aVar2));
                                        animator.setTarget(fragment.mView);
                                        animator.start();
                                    }
                                }
                                viewGroup3.removeView(view4);
                                if (viewGroup3 != fragment.mContainer) {
                                    return;
                                }
                            }
                        }
                        if (this.j.get(fragment) == null) {
                            j(fragment);
                        } else {
                            fragment.setStateAfterAnimating(min);
                        }
                    }
                }
                if (min < 1) {
                    if ((fragment.mRemoving && !fragment.isInBackStack()) || this.C.a(fragment)) {
                        Fragment fragment32 = wVar.f1361b;
                        if (this.f1330c.c(fragment32.mWho)) {
                            if (P(2)) {
                                String str5 = "Removed fragment from active set " + fragment32;
                            }
                            y yVar = this.f1330c;
                            if (yVar != null) {
                                Fragment fragment33 = wVar.f1361b;
                                for (w wVar2 : yVar.f1364b.values()) {
                                    if (wVar2 != null) {
                                        Fragment fragment34 = wVar2.f1361b;
                                        if (fragment33.mWho.equals(fragment34.mTargetWho)) {
                                            fragment34.mTarget = fragment33;
                                            fragment34.mTargetWho = null;
                                        }
                                    }
                                }
                                yVar.f1364b.put(fragment33.mWho, null);
                                String str6 = fragment33.mTargetWho;
                                if (str6 != null) {
                                    fragment33.mTarget = yVar.e(str6);
                                }
                                g0(fragment32);
                            } else {
                                throw null;
                            }
                        }
                    } else {
                        String str7 = fragment.mTargetWho;
                        if (!(str7 == null || (e2 = this.f1330c.e(str7)) == null || !e2.getRetainInstance())) {
                            fragment.mTarget = e2;
                        }
                    }
                    if (this.j.get(fragment) != null) {
                        fragment.setStateAfterAnimating(min);
                        min = 1;
                    } else {
                        n<?> nVar2 = this.n;
                        u uVar = this.C;
                        if (P(3)) {
                            StringBuilder g13 = c.a.a.a.a.g("movefrom CREATED: ");
                            g13.append(wVar.f1361b);
                            g13.toString();
                        }
                        Fragment fragment35 = wVar.f1361b;
                        boolean z4 = fragment35.mRemoving && !fragment35.isInBackStack();
                        if (z4 || uVar.a(wVar.f1361b)) {
                            if (nVar2 instanceof a0) {
                                z2 = uVar.f1355e;
                            } else {
                                Context context = nVar2.f1321c;
                                z2 = context instanceof Activity ? !((Activity) context).isChangingConfigurations() : true;
                            }
                            if (z4 || z2) {
                                Fragment fragment36 = wVar.f1361b;
                                if (uVar != null) {
                                    if (P(3)) {
                                        String str8 = "Clearing non-config state for " + fragment36;
                                    }
                                    u uVar2 = uVar.f1352b.get(fragment36.mWho);
                                    if (uVar2 != null) {
                                        uVar2.onCleared();
                                        uVar.f1352b.remove(fragment36.mWho);
                                    }
                                    b.n.z zVar = uVar.f1353c.get(fragment36.mWho);
                                    if (zVar != null) {
                                        zVar.a();
                                        uVar.f1353c.remove(fragment36.mWho);
                                    }
                                } else {
                                    throw null;
                                }
                            }
                            wVar.f1361b.performDestroy();
                            wVar.f1360a.d(wVar.f1361b, false);
                        } else {
                            wVar.f1361b.mState = 0;
                        }
                    }
                }
            }
            if (min < 0) {
                u uVar3 = this.C;
                if (P(3)) {
                    StringBuilder g14 = c.a.a.a.a.g("movefrom ATTACHED: ");
                    g14.append(wVar.f1361b);
                    g14.toString();
                }
                wVar.f1361b.performDetach();
                wVar.f1360a.e(wVar.f1361b, false);
                Fragment fragment37 = wVar.f1361b;
                fragment37.mState = -1;
                fragment37.mHost = null;
                fragment37.mParentFragment = null;
                fragment37.mFragmentManager = null;
                if (!fragment37.mRemoving || fragment37.isInBackStack()) {
                    z3 = false;
                }
                if (z3 || uVar3.a(wVar.f1361b)) {
                    if (P(3)) {
                        StringBuilder g15 = c.a.a.a.a.g("initState called for fragment: ");
                        g15.append(wVar.f1361b);
                        g15.toString();
                    }
                    wVar.f1361b.initState();
                }
            }
        }
        if (fragment.mState != min) {
            if (P(3)) {
                String str9 = "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + min + " found " + fragment.mState;
            }
            fragment.mState = min;
        }
    }

    public void X() {
        if (this.n != null) {
            this.u = false;
            this.v = false;
            for (Fragment fragment : this.f1330c.g()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void Y(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.f1329b) {
            this.x = true;
            return;
        }
        fragment.mDeferStart = false;
        W(fragment, this.m);
    }

    public void Z() {
        B(new f(null, -1, 0), false);
    }

    public final void a(b.e.c<Fragment> cVar) {
        int i2 = this.m;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            for (Fragment fragment : this.f1330c.g()) {
                if (fragment.mState < min) {
                    W(fragment, min);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        cVar.add(fragment);
                    }
                }
            }
        }
    }

    public void a0(String str, int i2) {
        B(new f(null, -1, i2), false);
    }

    public void b(Fragment fragment) {
        if (P(2)) {
            String str = "add: " + fragment;
        }
        T(fragment);
        if (!fragment.mDetached) {
            this.f1330c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (Q(fragment)) {
                this.t = true;
            }
        }
    }

    public boolean b0() {
        D(false);
        C(true);
        Fragment fragment = this.q;
        if (fragment != null && fragment.getChildFragmentManager().b0()) {
            return true;
        }
        boolean c0 = c0(this.y, this.z, null, -1, 0);
        if (c0) {
            this.f1329b = true;
            try {
                f0(this.y, this.z);
            } finally {
                h();
            }
        }
        r0();
        y();
        this.f1330c.b();
        return c0;
    }

    public void c(Fragment fragment) {
        boolean z2;
        if (!S()) {
            u uVar = this.C;
            if (uVar.f1351a.containsKey(fragment.mWho)) {
                z2 = false;
            } else {
                uVar.f1351a.put(fragment.mWho, fragment);
                z2 = true;
            }
            if (z2 && P(2)) {
                String str = "Updating retained Fragments: Added " + fragment;
            }
        }
    }

    public boolean c0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<a> arrayList3 = this.f1331d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1331d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = this.f1331d.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f1331d.get(size2);
                    if ((str != null && str.equals(aVar.i)) || (i2 >= 0 && i2 == aVar.t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.f1331d.get(size2);
                        if ((str == null || !str.equals(aVar2.i)) && (i2 < 0 || i2 != aVar2.t)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f1331d.size() - 1) {
                return false;
            }
            for (int size3 = this.f1331d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1331d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v19, resolved type: b.a.c */
    /* JADX WARN: Multi-variable type inference failed */
    public void d(n<?> nVar, j jVar, Fragment fragment) {
        if (this.n == null) {
            this.n = nVar;
            this.o = jVar;
            this.p = fragment;
            if (fragment != null) {
                r0();
            }
            if (nVar instanceof b.a.c) {
                b.a.c cVar = (b.a.c) nVar;
                this.g = cVar.getOnBackPressedDispatcher();
                Fragment fragment2 = cVar;
                if (fragment != null) {
                    fragment2 = fragment;
                }
                OnBackPressedDispatcher onBackPressedDispatcher = this.g;
                b.a.b bVar = this.h;
                if (onBackPressedDispatcher != null) {
                    b.n.f lifecycle = fragment2.getLifecycle();
                    if (((j) lifecycle).f1392b != f.b.DESTROYED) {
                        bVar.f358b.add(new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(lifecycle, bVar));
                    }
                } else {
                    throw null;
                }
            }
            if (fragment != null) {
                u uVar = fragment.mFragmentManager.C;
                u uVar2 = uVar.f1352b.get(fragment.mWho);
                if (uVar2 == null) {
                    uVar2 = new u(uVar.f1354d);
                    uVar.f1352b.put(fragment.mWho, uVar2);
                }
                this.C = uVar2;
            } else if (nVar instanceof a0) {
                b.n.z viewModelStore = ((a0) nVar).getViewModelStore();
                y.b bVar2 = u.g;
                String canonicalName = u.class.getCanonicalName();
                if (canonicalName != null) {
                    String o2 = c.a.a.a.a.o("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    x xVar = viewModelStore.f1427a.get(o2);
                    if (!u.class.isInstance(xVar)) {
                        xVar = bVar2 instanceof y.c ? ((y.c) bVar2).c(o2, u.class) : ((u.a) bVar2).a(u.class);
                        x put = viewModelStore.f1427a.put(o2, xVar);
                        if (put != null) {
                            put.onCleared();
                        }
                    } else if (bVar2 instanceof y.e) {
                        ((y.e) bVar2).b(xVar);
                    }
                    this.C = (u) xVar;
                    return;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            } else {
                this.C = new u(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void d0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            q0(new IllegalStateException(c.a.a.a.a.n("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public void e(Fragment fragment) {
        if (P(2)) {
            String str = "attach: " + fragment;
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f1330c.a(fragment);
                if (P(2)) {
                    String str2 = "add from attach: " + fragment;
                }
                if (Q(fragment)) {
                    this.t = true;
                }
            }
        }
    }

    public void e0(Fragment fragment) {
        if (P(2)) {
            String str = "remove: " + fragment + " nesting=" + fragment.mBackStackNesting;
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.f1330c.h(fragment);
            if (Q(fragment)) {
                this.t = true;
            }
            fragment.mRemoving = true;
            n0(fragment);
        }
    }

    public z f() {
        return new a(this);
    }

    public final void f0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                G(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).p) {
                        if (i3 != i2) {
                            F(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).p) {
                                i3++;
                            }
                        }
                        F(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    F(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public final void g(Fragment fragment) {
        HashSet<b.i.h.a> hashSet = this.j.get(fragment);
        if (hashSet != null) {
            Iterator<b.i.h.a> it = hashSet.iterator();
            while (it.hasNext()) {
                b.i.h.a next = it.next();
                synchronized (next) {
                    if (!next.f1065a) {
                        next.f1065a = true;
                        next.f1067c = true;
                        a.AbstractC0020a aVar = next.f1066b;
                        if (aVar != null) {
                            try {
                                ((e) aVar).a();
                            } catch (Throwable th) {
                                synchronized (next) {
                                    next.f1067c = false;
                                    next.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (next) {
                            next.f1067c = false;
                            next.notifyAll();
                        }
                    }
                }
            }
            hashSet.clear();
            j(fragment);
            this.j.remove(fragment);
        }
    }

    public void g0(Fragment fragment) {
        if (!S()) {
            if ((this.C.f1351a.remove(fragment.mWho) != null) && P(2)) {
                String str = "Updating retained Fragments: Removed " + fragment;
            }
        }
    }

    public final void h() {
        this.f1329b = false;
        this.z.clear();
        this.y.clear();
    }

    public void h0(Parcelable parcelable) {
        w wVar;
        if (parcelable != null) {
            t tVar = (t) parcelable;
            if (tVar.f1347b != null) {
                this.f1330c.f1364b.clear();
                Iterator<v> it = tVar.f1347b.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next != null) {
                        Fragment fragment = this.C.f1351a.get(next.f1357c);
                        if (fragment != null) {
                            if (P(2)) {
                                String str = "restoreSaveState: re-attaching retained " + fragment;
                            }
                            wVar = new w(this.l, fragment, next);
                        } else {
                            wVar = new w(this.l, this.n.f1321c.getClassLoader(), N(), next);
                        }
                        Fragment fragment2 = wVar.f1361b;
                        fragment2.mFragmentManager = this;
                        if (P(2)) {
                            StringBuilder g2 = c.a.a.a.a.g("restoreSaveState: active (");
                            g2.append(fragment2.mWho);
                            g2.append("): ");
                            g2.append(fragment2);
                            g2.toString();
                        }
                        wVar.a(this.n.f1321c.getClassLoader());
                        this.f1330c.f1364b.put(wVar.f1361b.mWho, wVar);
                        wVar.f1362c = this.m;
                    }
                }
                for (Fragment fragment3 : this.C.f1351a.values()) {
                    if (!this.f1330c.c(fragment3.mWho)) {
                        if (P(2)) {
                            String str2 = "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + tVar.f1347b;
                        }
                        W(fragment3, 1);
                        fragment3.mRemoving = true;
                        W(fragment3, -1);
                    }
                }
                y yVar = this.f1330c;
                ArrayList<String> arrayList = tVar.f1348c;
                yVar.f1363a.clear();
                if (arrayList != null) {
                    for (String str3 : arrayList) {
                        Fragment e2 = yVar.e(str3);
                        if (e2 != null) {
                            if (P(2)) {
                                String str4 = "restoreSaveState: added (" + str3 + "): " + e2;
                            }
                            yVar.a(e2);
                        } else {
                            throw new IllegalStateException(c.a.a.a.a.p("No instantiated fragment for (", str3, ")"));
                        }
                    }
                }
                if (tVar.f1349d != null) {
                    this.f1331d = new ArrayList<>(tVar.f1349d.length);
                    int i2 = 0;
                    while (true) {
                        b[] bVarArr = tVar.f1349d;
                        if (i2 >= bVarArr.length) {
                            break;
                        }
                        b bVar = bVarArr[i2];
                        if (bVar != null) {
                            a aVar = new a(this);
                            int i3 = 0;
                            int i4 = 0;
                            while (i3 < bVar.f1248b.length) {
                                z.a aVar2 = new z.a();
                                int i5 = i3 + 1;
                                aVar2.f1370a = bVar.f1248b[i3];
                                if (P(2)) {
                                    String str5 = "Instantiate " + aVar + " op #" + i4 + " base fragment #" + bVar.f1248b[i5];
                                }
                                String str6 = bVar.f1249c.get(i4);
                                aVar2.f1371b = str6 != null ? this.f1330c.e(str6) : null;
                                aVar2.g = f.b.values()[bVar.f1250d[i4]];
                                aVar2.h = f.b.values()[bVar.f1251e[i4]];
                                int[] iArr = bVar.f1248b;
                                int i6 = i5 + 1;
                                int i7 = iArr[i5];
                                aVar2.f1372c = i7;
                                int i8 = i6 + 1;
                                int i9 = iArr[i6];
                                aVar2.f1373d = i9;
                                int i10 = i8 + 1;
                                int i11 = iArr[i8];
                                aVar2.f1374e = i11;
                                int i12 = iArr[i10];
                                aVar2.f = i12;
                                aVar.f1366b = i7;
                                aVar.f1367c = i9;
                                aVar.f1368d = i11;
                                aVar.f1369e = i12;
                                aVar.b(aVar2);
                                i4++;
                                i3 = i10 + 1;
                            }
                            aVar.f = bVar.f;
                            aVar.i = bVar.g;
                            aVar.t = bVar.h;
                            aVar.g = true;
                            aVar.j = bVar.i;
                            aVar.k = bVar.j;
                            aVar.l = bVar.k;
                            aVar.m = bVar.l;
                            aVar.n = bVar.m;
                            aVar.o = bVar.n;
                            aVar.p = bVar.o;
                            aVar.l(1);
                            if (P(2)) {
                                StringBuilder h2 = c.a.a.a.a.h("restoreAllState: back stack #", i2, " (index ");
                                h2.append(aVar.t);
                                h2.append("): ");
                                h2.append(aVar);
                                h2.toString();
                                PrintWriter printWriter = new PrintWriter(new b.i.k.a("FragmentManager"));
                                aVar.n("  ", printWriter, false);
                                printWriter.close();
                            }
                            this.f1331d.add(aVar);
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                } else {
                    this.f1331d = null;
                }
                this.i.set(tVar.f1350e);
                String str7 = tVar.f;
                if (str7 != null) {
                    Fragment e3 = this.f1330c.e(str7);
                    this.q = e3;
                    u(e3);
                }
            }
        }
    }

    public void i(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.p(z4);
        } else {
            aVar.o();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            g0.p(this, arrayList, arrayList2, 0, 1, true, this.k);
        }
        if (z4) {
            V(this.m, true);
        }
        Iterator it = ((ArrayList) this.f1330c.f()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.q(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z4) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public Parcelable i0() {
        ArrayList<String> arrayList;
        int size;
        if (this.B != null) {
            while (!this.B.isEmpty()) {
                this.B.remove(0).a();
            }
        }
        A();
        D(true);
        this.u = true;
        y yVar = this.f1330c;
        b[] bVarArr = null;
        if (yVar != null) {
            ArrayList<v> arrayList2 = new ArrayList<>(yVar.f1364b.size());
            for (w wVar : yVar.f1364b.values()) {
                if (wVar != null) {
                    Fragment fragment = wVar.f1361b;
                    v vVar = new v(fragment);
                    if (wVar.f1361b.mState <= -1 || vVar.n != null) {
                        vVar.n = wVar.f1361b.mSavedFragmentState;
                    } else {
                        Bundle b2 = wVar.b();
                        vVar.n = b2;
                        if (wVar.f1361b.mTargetWho != null) {
                            if (b2 == null) {
                                vVar.n = new Bundle();
                            }
                            vVar.n.putString("android:target_state", wVar.f1361b.mTargetWho);
                            int i2 = wVar.f1361b.mTargetRequestCode;
                            if (i2 != 0) {
                                vVar.n.putInt("android:target_req_state", i2);
                            }
                        }
                    }
                    arrayList2.add(vVar);
                    if (P(2)) {
                        String str = "Saved state of " + fragment + ": " + vVar.n;
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                return null;
            }
            y yVar2 = this.f1330c;
            synchronized (yVar2.f1363a) {
                if (yVar2.f1363a.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(yVar2.f1363a.size());
                    Iterator<Fragment> it = yVar2.f1363a.iterator();
                    while (it.hasNext()) {
                        Fragment next = it.next();
                        arrayList.add(next.mWho);
                        if (P(2)) {
                            String str2 = "saveAllState: adding fragment (" + next.mWho + "): " + next;
                        }
                    }
                }
            }
            ArrayList<a> arrayList3 = this.f1331d;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                bVarArr = new b[size];
                for (int i3 = 0; i3 < size; i3++) {
                    bVarArr[i3] = new b(this.f1331d.get(i3));
                    if (P(2)) {
                        StringBuilder h2 = c.a.a.a.a.h("saveAllState: adding back stack #", i3, ": ");
                        h2.append(this.f1331d.get(i3));
                        h2.toString();
                    }
                }
            }
            t tVar = new t();
            tVar.f1347b = arrayList2;
            tVar.f1348c = arrayList;
            tVar.f1349d = bVarArr;
            tVar.f1350e = this.i.get();
            Fragment fragment2 = this.q;
            if (fragment2 != null) {
                tVar.f = fragment2.mWho;
            }
            return tVar;
        }
        throw null;
    }

    public final void j(Fragment fragment) {
        fragment.performDestroyView();
        this.l.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public void j0() {
        synchronized (this.f1328a) {
            boolean z2 = false;
            boolean z3 = this.B != null && !this.B.isEmpty();
            if (this.f1328a.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.n.f1322d.removeCallbacks(this.D);
                this.n.f1322d.post(this.D);
                r0();
            }
        }
    }

    public void k(Fragment fragment) {
        if (P(2)) {
            String str = "detach: " + fragment;
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (P(2)) {
                    String str2 = "remove from detach: " + fragment;
                }
                this.f1330c.h(fragment);
                if (Q(fragment)) {
                    this.t = true;
                }
                n0(fragment);
            }
        }
    }

    public void k0(Fragment fragment, boolean z2) {
        ViewGroup M = M(fragment);
        if (M != null && (M instanceof k)) {
            ((k) M).setDrawDisappearingViewsLast(!z2);
        }
    }

    public void l(Configuration configuration) {
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public void l0(Fragment fragment, f.b bVar) {
        if (!fragment.equals(H(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = bVar;
    }

    public boolean m(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m0(Fragment fragment) {
        if (fragment == null || (fragment.equals(H(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.q;
            this.q = fragment;
            u(fragment2);
            u(this.q);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void n() {
        this.u = false;
        this.v = false;
        x(1);
    }

    public final void n0(Fragment fragment) {
        ViewGroup M = M(fragment);
        if (M != null) {
            if (M.getTag(b.l.b.visible_removing_fragment_view_tag) == null) {
                M.setTag(b.l.b.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) M.getTag(b.l.b.visible_removing_fragment_view_tag)).setNextAnim(fragment.getNextAnim());
        }
    }

    public boolean o(Menu menu, MenuInflater menuInflater) {
        if (this.m < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f1332e != null) {
            for (int i2 = 0; i2 < this.f1332e.size(); i2++) {
                Fragment fragment2 = this.f1332e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1332e = arrayList;
        return z2;
    }

    public void o0(Fragment fragment) {
        if (P(2)) {
            String str = "show: " + fragment;
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void p() {
        this.w = true;
        D(true);
        A();
        x(-1);
        this.n = null;
        this.o = null;
        this.p = null;
        if (this.g != null) {
            Iterator<b.a.a> it = this.h.f358b.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.g = null;
        }
    }

    public final void p0() {
        Iterator it = ((ArrayList) this.f1330c.f()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                Y(fragment);
            }
        }
    }

    public void q() {
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final void q0(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new b.i.k.a("FragmentManager"));
        n<?> nVar = this.n;
        if (nVar != null) {
            try {
                d.this.dump("  ", null, printWriter, new String[0]);
            } catch (Exception unused) {
            }
        } else {
            z("  ", null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public void r(boolean z2) {
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        r1 = r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r1 <= 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (R(r4.p) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r0.f357a = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r0 = r4.h;
        r1 = r4.f1331d;
     */
    public final void r0() {
        synchronized (this.f1328a) {
            boolean z2 = true;
            if (!this.f1328a.isEmpty()) {
                this.h.f357a = true;
            }
        }
    }

    public boolean s(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void t(Menu menu) {
        if (this.m >= 1) {
            for (Fragment fragment : this.f1330c.g()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder((int) RecyclerView.d0.FLAG_IGNORE);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.p;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.p;
        } else {
            n<?> nVar = this.n;
            if (nVar != null) {
                sb.append(nVar.getClass().getSimpleName());
                sb.append("{");
                obj = this.n;
            } else {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    public final void u(Fragment fragment) {
        if (fragment != null && fragment.equals(H(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public void v(boolean z2) {
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public boolean w(Menu menu) {
        boolean z2 = false;
        if (this.m < 1) {
            return false;
        }
        for (Fragment fragment : this.f1330c.g()) {
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void x(int i2) {
        try {
            this.f1329b = true;
            this.f1330c.d(i2);
            V(i2, false);
            this.f1329b = false;
            D(true);
        } catch (Throwable th) {
            this.f1329b = false;
            throw th;
        }
    }

    public final void y() {
        if (this.x) {
            this.x = false;
            p0();
        }
    }

    public void z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String o2 = c.a.a.a.a.o(str, "    ");
        y yVar = this.f1330c;
        if (yVar != null) {
            String o3 = c.a.a.a.a.o(str, "    ");
            if (!yVar.f1364b.isEmpty()) {
                printWriter.print(str);
                printWriter.print("Active Fragments:");
                for (w wVar : yVar.f1364b.values()) {
                    printWriter.print(str);
                    if (wVar != null) {
                        Fragment fragment = wVar.f1361b;
                        printWriter.println(fragment);
                        fragment.dump(o3, fileDescriptor, printWriter, strArr);
                    } else {
                        printWriter.println("null");
                    }
                }
            }
            int size3 = yVar.f1363a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (int i2 = 0; i2 < size3; i2++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(yVar.f1363a.get(i2).toString());
                }
            }
            ArrayList<Fragment> arrayList = this.f1332e;
            if (arrayList != null && (size2 = arrayList.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size2; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.f1332e.get(i3).toString());
                }
            }
            ArrayList<a> arrayList2 = this.f1331d;
            if (arrayList2 != null && (size = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i4 = 0; i4 < size; i4++) {
                    a aVar = this.f1331d.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.n(o2, printWriter, true);
                }
            }
            printWriter.print(str);
            printWriter.println("Back Stack Index: " + this.i.get());
            synchronized (this.f1328a) {
                int size4 = this.f1328a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println((e) this.f1328a.get(i5));
                    }
                }
            }
            printWriter.print(str);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(str);
            printWriter.print("  mHost=");
            printWriter.println(this.n);
            printWriter.print(str);
            printWriter.print("  mContainer=");
            printWriter.println(this.o);
            if (this.p != null) {
                printWriter.print(str);
                printWriter.print("  mParent=");
                printWriter.println(this.p);
            }
            printWriter.print(str);
            printWriter.print("  mCurState=");
            printWriter.print(this.m);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.u);
            printWriter.print(" mStopped=");
            printWriter.print(this.v);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.w);
            if (this.t) {
                printWriter.print(str);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.t);
                return;
            }
            return;
        }
        throw null;
    }
}
