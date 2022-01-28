package b.l.d;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.l.d.c0;
import b.l.d.i0;
import b.l.d.p0;
import b.o.a0;
import b.o.f;
import b.o.x;
import b.o.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class z {
    public b.a.e.c<String[]> A;
    public ArrayDeque<k> B = new ArrayDeque<>();
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public ArrayList<a> H;
    public ArrayList<Boolean> I;
    public ArrayList<Fragment> J;
    public ArrayList<n> K;
    public c0 L;
    public Runnable M = new g();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<l> f2178a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f2179b;

    /* renamed from: c  reason: collision with root package name */
    public final h0 f2180c = new h0();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f2181d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f2182e;

    /* renamed from: f  reason: collision with root package name */
    public final x f2183f = new x(this);

    /* renamed from: g  reason: collision with root package name */
    public OnBackPressedDispatcher f2184g;
    public final b.a.b h = new c(false);
    public final AtomicInteger i = new AtomicInteger();
    public final Map<String, Bundle> j = Collections.synchronizedMap(new HashMap());
    public final Map<String, Object> k = Collections.synchronizedMap(new HashMap());
    public Map<Fragment, HashSet<b.i.h.a>> l = Collections.synchronizedMap(new HashMap());
    public final p0.a m = new d();
    public final y n = new y(this);
    public final CopyOnWriteArrayList<d0> o = new CopyOnWriteArrayList<>();
    public int p = -1;
    public w<?> q;
    public s r;
    public Fragment s;
    public Fragment t;
    public v u = null;
    public v v = new e();
    public x0 w = null;
    public x0 x = new f(this);
    public b.a.e.c<Intent> y;
    public b.a.e.c<b.a.e.e> z;

    public class a implements b.a.e.b<b.a.e.a> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.e.b
        public void a(b.a.e.a aVar) {
            b.a.e.a aVar2 = aVar;
            k pollFirst = z.this.B.pollFirst();
            if (pollFirst == null) {
                String str = "No IntentSenders were started for " + this;
                return;
            }
            String str2 = pollFirst.f2193b;
            int i = pollFirst.f2194c;
            Fragment e2 = z.this.f2180c.e(str2);
            if (e2 != null) {
                e2.onActivityResult(i, aVar2.f500b, aVar2.f501c);
            }
        }
    }

    public class b implements b.a.e.b<Map<String, Boolean>> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.e.b
        @SuppressLint({"SyntheticAccessor"})
        public void a(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            k pollFirst = z.this.B.pollFirst();
            if (pollFirst == null) {
                String str = "No permissions were requested for " + this;
                return;
            }
            String str2 = pollFirst.f2193b;
            int i2 = pollFirst.f2194c;
            Fragment e2 = z.this.f2180c.e(str2);
            if (e2 != null) {
                e2.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }

    public class c extends b.a.b {
        public c(boolean z) {
            super(z);
        }
    }

    public class d implements p0.a {
        public d() {
        }

        public void a(Fragment fragment, b.i.h.a aVar) {
            boolean z;
            synchronized (aVar) {
                z = aVar.f1764a;
            }
            if (!z) {
                z zVar = z.this;
                HashSet<b.i.h.a> hashSet = zVar.l.get(fragment);
                if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
                    zVar.l.remove(fragment);
                    if (fragment.mState < 5) {
                        zVar.j(fragment);
                        zVar.V(fragment, zVar.p);
                    }
                }
            }
        }

        public void b(Fragment fragment, b.i.h.a aVar) {
            z zVar = z.this;
            if (zVar.l.get(fragment) == null) {
                zVar.l.put(fragment, new HashSet<>());
            }
            zVar.l.get(fragment).add(aVar);
        }
    }

    public class e extends v {
        public e() {
        }

        @Override // b.l.d.v
        public Fragment a(ClassLoader classLoader, String str) {
            w<?> wVar = z.this.q;
            Context context = wVar.f2143c;
            if (wVar != null) {
                return Fragment.instantiate(context, str, null);
            }
            throw null;
        }
    }

    public class f implements x0 {
        public f(z zVar) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            z.this.D(true);
        }
    }

    public class h implements d0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Fragment f2191b;

        public h(z zVar, Fragment fragment) {
            this.f2191b = fragment;
        }

        @Override // b.l.d.d0
        public void a(z zVar, Fragment fragment) {
            this.f2191b.onAttachFragment(fragment);
        }
    }

    public class i implements b.a.e.b<b.a.e.a> {
        public i() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.a.e.b
        public void a(b.a.e.a aVar) {
            b.a.e.a aVar2 = aVar;
            k pollFirst = z.this.B.pollFirst();
            if (pollFirst == null) {
                String str = "No Activities were started for result for " + this;
                return;
            }
            String str2 = pollFirst.f2193b;
            int i = pollFirst.f2194c;
            Fragment e2 = z.this.f2180c.e(str2);
            if (e2 != null) {
                e2.onActivityResult(i, aVar2.f500b, aVar2.f501c);
            }
        }
    }

    public static class j extends b.a.e.f.a<b.a.e.e, b.a.e.a> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
        @Override // b.a.e.f.a
        public Intent a(Context context, b.a.e.e eVar) {
            Bundle bundleExtra;
            b.a.e.e eVar2 = eVar;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = eVar2.f503c;
            if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar2 = new b.a.e.e(eVar2.f502b, null, eVar2.f504d, eVar2.f505e);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar2);
            if (z.P(2)) {
                String str = "CreateIntent created the following intent: " + intent;
            }
            return intent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.f.a
        public b.a.e.a c(int i, Intent intent) {
            return new b.a.e.a(i, intent);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public String f2193b;

        /* renamed from: c  reason: collision with root package name */
        public int f2194c;

        public class a implements Parcelable.Creator<k> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public k[] newArray(int i) {
                return new k[i];
            }
        }

        public k(Parcel parcel) {
            this.f2193b = parcel.readString();
            this.f2194c = parcel.readInt();
        }

        public k(String str, int i) {
            this.f2193b = str;
            this.f2194c = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2193b);
            parcel.writeInt(this.f2194c);
        }
    }

    public interface l {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class m implements l {

        /* renamed from: a  reason: collision with root package name */
        public final String f2195a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2196b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2197c;

        public m(String str, int i, int i2) {
            this.f2195a = str;
            this.f2196b = i;
            this.f2197c = i2;
        }

        @Override // b.l.d.z.l
        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = z.this.t;
            if (fragment == null || this.f2196b >= 0 || this.f2195a != null || !fragment.getChildFragmentManager().a0()) {
                return z.this.b0(arrayList, arrayList2, this.f2195a, this.f2196b, this.f2197c);
            }
            return false;
        }
    }

    public static class n implements Fragment.l {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f2199a;

        /* renamed from: b  reason: collision with root package name */
        public final a f2200b;

        /* renamed from: c  reason: collision with root package name */
        public int f2201c;

        public void a() {
            boolean z = this.f2201c > 0;
            for (Fragment fragment : this.f2200b.r.f2180c.i()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            a aVar = this.f2200b;
            aVar.r.h(aVar, this.f2199a, !z, true);
        }
    }

    public static boolean P(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public final void A() {
        Iterator it = ((HashSet) g()).iterator();
        while (it.hasNext()) {
            ((w0) it.next()).e();
        }
    }

    public void B(l lVar, boolean z2) {
        if (!z2) {
            if (this.q == null) {
                if (this.F) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (T()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f2178a) {
            if (this.q != null) {
                this.f2178a.add(lVar);
                h0();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void C(boolean z2) {
        if (this.f2179b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.q == null) {
            if (this.F) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.q.f2144d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z2 || !T()) {
            if (this.H == null) {
                this.H = new ArrayList<>();
                this.I = new ArrayList<>();
            }
            this.f2179b = true;
            try {
                G(null, null);
            } finally {
                this.f2179b = false;
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
            ArrayList<a> arrayList = this.H;
            ArrayList<Boolean> arrayList2 = this.I;
            synchronized (this.f2178a) {
                if (this.f2178a.isEmpty()) {
                    z3 = false;
                } else {
                    int size = this.f2178a.size();
                    z3 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z3 |= this.f2178a.get(i2).a(arrayList, arrayList2);
                    }
                    this.f2178a.clear();
                    this.q.f2144d.removeCallbacks(this.M);
                }
            }
            if (z3) {
                this.f2179b = true;
                try {
                    e0(this.H, this.I);
                    f();
                    z4 = true;
                } catch (Throwable th) {
                    f();
                    throw th;
                }
            } else {
                p0();
                y();
                this.f2180c.b();
                return z4;
            }
        }
    }

    public void E(l lVar, boolean z2) {
        if (!z2 || (this.q != null && !this.F)) {
            C(z2);
            if (lVar.a(this.H, this.I)) {
                this.f2179b = true;
                try {
                    e0(this.H, this.I);
                } finally {
                    f();
                }
            }
            p0();
            y();
            this.f2180c.b();
        }
    }

    public final void F(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        int i4;
        int i5;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z2 = arrayList.get(i2).p;
        ArrayList<Fragment> arrayList4 = this.J;
        if (arrayList4 == null) {
            this.J = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.J.addAll(this.f2180c.i());
        Fragment fragment = this.t;
        int i6 = i2;
        boolean z3 = false;
        while (true) {
            int i7 = 1;
            if (i6 < i3) {
                a aVar = arrayList.get(i6);
                int i8 = 3;
                if (!arrayList3.get(i6).booleanValue()) {
                    ArrayList<Fragment> arrayList5 = this.J;
                    int i9 = 0;
                    while (i9 < aVar.f2035a.size()) {
                        i0.a aVar2 = aVar.f2035a.get(i9);
                        int i10 = aVar2.f2042a;
                        if (i10 != i7) {
                            if (i10 == 2) {
                                Fragment fragment2 = aVar2.f2043b;
                                int i11 = fragment2.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z4 = false;
                                while (size >= 0) {
                                    Fragment fragment3 = arrayList5.get(size);
                                    if (fragment3.mContainerId != i11) {
                                        i5 = i11;
                                    } else if (fragment3 == fragment2) {
                                        i5 = i11;
                                        z4 = true;
                                    } else {
                                        if (fragment3 == fragment) {
                                            i5 = i11;
                                            aVar.f2035a.add(i9, new i0.a(9, fragment3));
                                            i9++;
                                            fragment = null;
                                        } else {
                                            i5 = i11;
                                        }
                                        i0.a aVar3 = new i0.a(3, fragment3);
                                        aVar3.f2044c = aVar2.f2044c;
                                        aVar3.f2046e = aVar2.f2046e;
                                        aVar3.f2045d = aVar2.f2045d;
                                        aVar3.f2047f = aVar2.f2047f;
                                        aVar.f2035a.add(i9, aVar3);
                                        arrayList5.remove(fragment3);
                                        i9++;
                                    }
                                    size--;
                                    i11 = i5;
                                }
                                if (z4) {
                                    aVar.f2035a.remove(i9);
                                    i9--;
                                } else {
                                    i4 = 1;
                                    aVar2.f2042a = 1;
                                    arrayList5.add(fragment2);
                                    i9 += i4;
                                    i7 = i4;
                                    i8 = 3;
                                }
                            } else if (i10 == i8 || i10 == 6) {
                                arrayList5.remove(aVar2.f2043b);
                                Fragment fragment4 = aVar2.f2043b;
                                if (fragment4 == fragment) {
                                    aVar.f2035a.add(i9, new i0.a(9, fragment4));
                                    i9++;
                                    i4 = 1;
                                    fragment = null;
                                    i9 += i4;
                                    i7 = i4;
                                    i8 = 3;
                                }
                            } else if (i10 == 7) {
                                i4 = 1;
                            } else if (i10 == 8) {
                                aVar.f2035a.add(i9, new i0.a(9, fragment));
                                i9++;
                                fragment = aVar2.f2043b;
                            }
                            i4 = 1;
                            i9 += i4;
                            i7 = i4;
                            i8 = 3;
                        } else {
                            i4 = i7;
                        }
                        arrayList5.add(aVar2.f2043b);
                        i9 += i4;
                        i7 = i4;
                        i8 = 3;
                    }
                } else {
                    int i12 = 1;
                    ArrayList<Fragment> arrayList6 = this.J;
                    int size2 = aVar.f2035a.size() - 1;
                    while (size2 >= 0) {
                        i0.a aVar4 = aVar.f2035a.get(size2);
                        int i13 = aVar4.f2042a;
                        if (i13 != i12) {
                            if (i13 != 3) {
                                switch (i13) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = aVar4.f2043b;
                                        break;
                                    case 10:
                                        aVar4.h = aVar4.f2048g;
                                        break;
                                }
                                size2--;
                                i12 = 1;
                            }
                            arrayList6.add(aVar4.f2043b);
                            size2--;
                            i12 = 1;
                        }
                        arrayList6.remove(aVar4.f2043b);
                        size2--;
                        i12 = 1;
                    }
                }
                z3 = z3 || aVar.f2041g;
                i6++;
                arrayList3 = arrayList2;
            } else {
                this.J.clear();
                if (!z2 && this.p >= 1) {
                    for (int i14 = i2; i14 < i3; i14++) {
                        Iterator<i0.a> it = arrayList.get(i14).f2035a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment5 = it.next().f2043b;
                            if (!(fragment5 == null || fragment5.mFragmentManager == null)) {
                                this.f2180c.j(i(fragment5));
                            }
                        }
                    }
                }
                int i15 = i2;
                while (i15 < i3) {
                    a aVar5 = arrayList.get(i15);
                    if (arrayList2.get(i15).booleanValue()) {
                        aVar5.k(-1);
                        aVar5.o(i15 == i3 + -1);
                    } else {
                        aVar5.k(1);
                        aVar5.n();
                    }
                    i15++;
                }
                boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
                for (int i16 = i2; i16 < i3; i16++) {
                    a aVar6 = arrayList.get(i16);
                    if (booleanValue) {
                        for (int size3 = aVar6.f2035a.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment6 = aVar6.f2035a.get(size3).f2043b;
                            if (fragment6 != null) {
                                i(fragment6).k();
                            }
                        }
                    } else {
                        Iterator<i0.a> it2 = aVar6.f2035a.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment7 = it2.next().f2043b;
                            if (fragment7 != null) {
                                i(fragment7).k();
                            }
                        }
                    }
                }
                U(this.p, true);
                HashSet hashSet = new HashSet();
                for (int i17 = i2; i17 < i3; i17++) {
                    Iterator<i0.a> it3 = arrayList.get(i17).f2035a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment8 = it3.next().f2043b;
                        if (!(fragment8 == null || (viewGroup = fragment8.mContainer) == null)) {
                            hashSet.add(w0.g(viewGroup, N()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    w0 w0Var = (w0) it4.next();
                    w0Var.f2149d = booleanValue;
                    w0Var.h();
                    w0Var.c();
                }
                for (int i18 = i2; i18 < i3; i18++) {
                    a aVar7 = arrayList.get(i18);
                    if (arrayList2.get(i18).booleanValue() && aVar7.t >= 0) {
                        aVar7.t = -1;
                    }
                    if (aVar7.q != null) {
                        for (int i19 = 0; i19 < aVar7.q.size(); i19++) {
                            aVar7.q.get(i19).run();
                        }
                        aVar7.q = null;
                    }
                }
                return;
            }
        }
    }

    public final void G(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<n> arrayList3 = this.K;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            n nVar = this.K.get(i2);
            if (arrayList == null || nVar.f2199a || (indexOf2 = arrayList.indexOf(nVar.f2200b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((nVar.f2201c == 0) || (arrayList != null && nVar.f2200b.q(arrayList, 0, arrayList.size()))) {
                    this.K.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || nVar.f2199a || (indexOf = arrayList.indexOf(nVar.f2200b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        nVar.a();
                    }
                }
                i2++;
            } else {
                this.K.remove(i2);
                i2--;
                size--;
            }
            a aVar = nVar.f2200b;
            aVar.r.h(aVar, nVar.f2199a, false, false);
            i2++;
        }
    }

    public Fragment H(String str) {
        return this.f2180c.d(str);
    }

    public Fragment I(int i2) {
        h0 h0Var = this.f2180c;
        int size = h0Var.f2029a.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = h0Var.f2029a.get(size);
                if (fragment != null && fragment.mFragmentId == i2) {
                    return fragment;
                }
            } else {
                for (g0 g0Var : h0Var.f2030b.values()) {
                    if (g0Var != null) {
                        Fragment fragment2 = g0Var.f2021c;
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
        h0 h0Var = this.f2180c;
        if (h0Var != null) {
            if (str != null) {
                int size = h0Var.f2029a.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    Fragment fragment = h0Var.f2029a.get(size);
                    if (fragment != null && str.equals(fragment.mTag)) {
                        return fragment;
                    }
                }
            }
            if (str == null) {
                return null;
            }
            for (g0 g0Var : h0Var.f2030b.values()) {
                if (g0Var != null) {
                    Fragment fragment2 = g0Var.f2021c;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
            return null;
        }
        throw null;
    }

    public Fragment K(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment d2 = this.f2180c.d(string);
        if (d2 != null) {
            return d2;
        }
        o0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public final ViewGroup L(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.r.c()) {
            View b2 = this.r.b(fragment.mContainerId);
            if (b2 instanceof ViewGroup) {
                return (ViewGroup) b2;
            }
        }
        return null;
    }

    public v M() {
        v vVar = this.u;
        if (vVar != null) {
            return vVar;
        }
        Fragment fragment = this.s;
        return fragment != null ? fragment.mFragmentManager.M() : this.v;
    }

    public x0 N() {
        x0 x0Var = this.w;
        if (x0Var != null) {
            return x0Var;
        }
        Fragment fragment = this.s;
        return fragment != null ? fragment.mFragmentManager.N() : this.x;
    }

    public void O(Fragment fragment) {
        if (P(2)) {
            String str = "hide: " + fragment;
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            l0(fragment);
        }
    }

    public final boolean Q(Fragment fragment) {
        boolean z2;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        z zVar = fragment.mChildFragmentManager;
        Iterator it = ((ArrayList) zVar.f2180c.g()).iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z3 = zVar.Q(fragment2);
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
        return fragment.isMenuVisible();
    }

    public boolean S(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        z zVar = fragment.mFragmentManager;
        if (!fragment.equals(zVar.t) || !S(zVar.s)) {
            return false;
        }
        return true;
    }

    public boolean T() {
        return this.D || this.E;
    }

    public void U(int i2, boolean z2) {
        w<?> wVar;
        if (this.q == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.p) {
            this.p = i2;
            h0 h0Var = this.f2180c;
            Iterator<Fragment> it = h0Var.f2029a.iterator();
            while (it.hasNext()) {
                g0 g0Var = h0Var.f2030b.get(it.next().mWho);
                if (g0Var != null) {
                    g0Var.k();
                }
            }
            Iterator<g0> it2 = h0Var.f2030b.values().iterator();
            while (true) {
                boolean z3 = false;
                if (!it2.hasNext()) {
                    break;
                }
                g0 next = it2.next();
                if (next != null) {
                    next.k();
                    Fragment fragment = next.f2021c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        z3 = true;
                    }
                    if (z3) {
                        h0Var.k(next);
                    }
                }
            }
            n0();
            if (this.C && (wVar = this.q) != null && this.p == 7) {
                m.this.supportInvalidateOptionsMenu();
                this.C = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r1 != 5) goto L_0x01b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ae  */
    public void V(Fragment fragment, int i2) {
        ViewGroup viewGroup;
        g0 h2 = this.f2180c.h(fragment.mWho);
        int i3 = 1;
        if (h2 == null) {
            h2 = new g0(this.n, this.f2180c, fragment);
            h2.f2023e = 1;
        }
        int min = Math.min((!fragment.mFromLayout || !fragment.mInLayout || fragment.mState != 2) ? i2 : Math.max(i2, 2), h2.d());
        int i4 = fragment.mState;
        if (i4 <= min) {
            if (i4 < min && !this.l.isEmpty()) {
                e(fragment);
            }
            int i5 = fragment.mState;
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 4) {
                            }
                            if (min > 4) {
                                h2.p();
                            }
                            if (min > 5) {
                                h2.n();
                            }
                        }
                        if (min > 2) {
                            h2.a();
                        }
                        if (min > 4) {
                        }
                        if (min > 5) {
                        }
                    }
                    if (min > -1) {
                        h2.j();
                    }
                    if (min > 1) {
                        h2.f();
                    }
                    if (min > 2) {
                    }
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                }
            } else if (min > -1) {
                h2.c();
            }
            if (min > 0) {
                h2.e();
            }
            if (min > -1) {
            }
            if (min > 1) {
            }
            if (min > 2) {
            }
            if (min > 4) {
            }
            if (min > 5) {
            }
        } else if (i4 > min) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                if (i4 == 7) {
                                    if (min < 7) {
                                        h2.l();
                                    }
                                }
                            }
                            if (min < 5) {
                                h2.q();
                            }
                        }
                        if (min < 4) {
                            if (P(3)) {
                                String str = "movefrom ACTIVITY_CREATED: " + fragment;
                            }
                            if (fragment.mView != null && (!m.this.isFinishing()) && fragment.mSavedViewState == null) {
                                h2.o();
                            }
                        }
                    }
                    if (min < 2) {
                        q qVar = null;
                        View view = fragment.mView;
                        if (!(view == null || (viewGroup = fragment.mContainer) == null)) {
                            viewGroup.endViewTransition(view);
                            fragment.mView.clearAnimation();
                            if (!fragment.isRemovingParent()) {
                                if (this.p > -1 && !this.F && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f) {
                                    qVar = i.j.N(this.q.f2143c, fragment, false, fragment.getPopDirection());
                                }
                                fragment.mPostponedAlpha = 0.0f;
                                ViewGroup viewGroup2 = fragment.mContainer;
                                View view2 = fragment.mView;
                                if (qVar != null) {
                                    p0.a aVar = this.m;
                                    viewGroup2.startViewTransition(view2);
                                    b.i.h.a aVar2 = new b.i.h.a();
                                    aVar2.b(new n(fragment));
                                    d dVar = (d) aVar;
                                    dVar.b(fragment, aVar2);
                                    if (qVar.f2105a != null) {
                                        r rVar = new r(qVar.f2105a, viewGroup2, view2);
                                        fragment.setAnimatingAway(fragment.mView);
                                        rVar.setAnimationListener(new o(viewGroup2, fragment, dVar, aVar2));
                                        fragment.mView.startAnimation(rVar);
                                    } else {
                                        Animator animator = qVar.f2106b;
                                        fragment.setAnimator(animator);
                                        animator.addListener(new p(viewGroup2, view2, fragment, dVar, aVar2));
                                        animator.setTarget(fragment.mView);
                                        animator.start();
                                    }
                                }
                                viewGroup2.removeView(view2);
                                if (P(2)) {
                                    String str2 = "Removing view " + view2 + " for fragment " + fragment + " from container " + viewGroup2;
                                }
                                if (viewGroup2 != fragment.mContainer) {
                                    return;
                                }
                            }
                        }
                        if (this.l.get(fragment) == null) {
                            h2.h();
                        }
                    }
                }
                if (min < 1) {
                    if (this.l.get(fragment) == null) {
                        h2.g();
                    }
                    if (i3 < 0) {
                        h2.i();
                    }
                    min = i3;
                }
            }
            i3 = min;
            if (i3 < 0) {
            }
            min = i3;
        }
        if (fragment.mState != min) {
            if (P(3)) {
                String str3 = "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + min + " found " + fragment.mState;
            }
            fragment.mState = min;
        }
    }

    public void W() {
        if (this.q != null) {
            this.D = false;
            this.E = false;
            this.L.f1999g = false;
            for (Fragment fragment : this.f2180c.i()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void X(g0 g0Var) {
        Fragment fragment = g0Var.f2021c;
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.f2179b) {
            this.G = true;
            return;
        }
        fragment.mDeferStart = false;
        g0Var.k();
    }

    public void Y() {
        B(new m(null, -1, 0), false);
    }

    public void Z(String str, int i2) {
        B(new m(null, -1, i2), false);
    }

    public g0 a(Fragment fragment) {
        if (P(2)) {
            String str = "add: " + fragment;
        }
        g0 i2 = i(fragment);
        fragment.mFragmentManager = this;
        this.f2180c.j(i2);
        if (!fragment.mDetached) {
            this.f2180c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (Q(fragment)) {
                this.C = true;
            }
        }
        return i2;
    }

    public boolean a0() {
        D(false);
        C(true);
        Fragment fragment = this.t;
        if (fragment != null && fragment.getChildFragmentManager().a0()) {
            return true;
        }
        boolean b0 = b0(this.H, this.I, null, -1, 0);
        if (b0) {
            this.f2179b = true;
            try {
                e0(this.H, this.I);
            } finally {
                f();
            }
        }
        p0();
        y();
        this.f2180c.b();
        return b0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v29, resolved type: b.a.c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"SyntheticAccessor"})
    public void b(w<?> wVar, s sVar, Fragment fragment) {
        w<?> wVar2;
        String str;
        d0 d0Var;
        if (this.q == null) {
            this.q = wVar;
            this.r = sVar;
            this.s = fragment;
            if (fragment != null) {
                d0Var = new h(this, fragment);
            } else {
                if (wVar instanceof d0) {
                    d0Var = (d0) wVar;
                }
                if (this.s != null) {
                    p0();
                }
                if (wVar instanceof b.a.c) {
                    b.a.c cVar = (b.a.c) wVar;
                    this.f2184g = cVar.getOnBackPressedDispatcher();
                    Fragment fragment2 = cVar;
                    if (fragment != null) {
                        fragment2 = fragment;
                    }
                    OnBackPressedDispatcher onBackPressedDispatcher = this.f2184g;
                    b.a.b bVar = this.h;
                    if (onBackPressedDispatcher != null) {
                        b.o.f lifecycle = fragment2.getLifecycle();
                        if (((b.o.j) lifecycle).f2221b != f.b.DESTROYED) {
                            bVar.f497b.add(new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(lifecycle, bVar));
                        }
                    } else {
                        throw null;
                    }
                }
                if (fragment == null) {
                    c0 c0Var = fragment.mFragmentManager.L;
                    c0 c0Var2 = c0Var.f1994b.get(fragment.mWho);
                    if (c0Var2 == null) {
                        c0Var2 = new c0(c0Var.f1996d);
                        c0Var.f1994b.put(fragment.mWho, c0Var2);
                    }
                    this.L = c0Var2;
                } else if (wVar instanceof a0) {
                    b.o.z viewModelStore = ((a0) wVar).getViewModelStore();
                    y.b bVar2 = c0.h;
                    String canonicalName = c0.class.getCanonicalName();
                    if (canonicalName != null) {
                        String q2 = c.a.a.a.a.q("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                        x xVar = viewModelStore.f2263a.get(q2);
                        if (!c0.class.isInstance(xVar)) {
                            xVar = bVar2 instanceof y.c ? ((y.c) bVar2).c(q2, c0.class) : ((c0.a) bVar2).a(c0.class);
                            x put = viewModelStore.f2263a.put(q2, xVar);
                            if (put != null) {
                                put.onCleared();
                            }
                        } else if (bVar2 instanceof y.e) {
                            ((y.e) bVar2).b(xVar);
                        }
                        this.L = (c0) xVar;
                    } else {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                } else {
                    this.L = new c0(false);
                }
                this.L.f1999g = T();
                this.f2180c.f2031c = this.L;
                wVar2 = this.q;
                if (!(wVar2 instanceof b.a.e.d)) {
                    ActivityResultRegistry activityResultRegistry = ((b.a.e.d) wVar2).getActivityResultRegistry();
                    if (fragment != null) {
                        str = fragment.mWho + ":";
                    } else {
                        str = "";
                    }
                    String q3 = c.a.a.a.a.q("FragmentManager:", str);
                    this.y = activityResultRegistry.c(c.a.a.a.a.q(q3, "StartActivityForResult"), new b.a.e.f.c(), new i());
                    this.z = activityResultRegistry.c(c.a.a.a.a.q(q3, "StartIntentSenderForResult"), new j(), new a());
                    this.A = activityResultRegistry.c(c.a.a.a.a.q(q3, "RequestPermissions"), new b.a.e.f.b(), new b());
                    return;
                }
                return;
            }
            this.o.add(d0Var);
            if (this.s != null) {
            }
            if (wVar instanceof b.a.c) {
            }
            if (fragment == null) {
            }
            this.L.f1999g = T();
            this.f2180c.f2031c = this.L;
            wVar2 = this.q;
            if (!(wVar2 instanceof b.a.e.d)) {
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public boolean b0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<a> arrayList3 = this.f2181d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2181d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = this.f2181d.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f2181d.get(size2);
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
                        a aVar2 = this.f2181d.get(size2);
                        if ((str == null || !str.equals(aVar2.i)) && (i2 < 0 || i2 != aVar2.t)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f2181d.size() - 1) {
                return false;
            }
            for (int size3 = this.f2181d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f2181d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void c(Fragment fragment) {
        if (P(2)) {
            String str = "attach: " + fragment;
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f2180c.a(fragment);
                if (P(2)) {
                    String str2 = "add from attach: " + fragment;
                }
                if (Q(fragment)) {
                    this.C = true;
                }
            }
        }
    }

    public void c0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            o0(new IllegalStateException(c.a.a.a.a.p("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public i0 d() {
        return new a(this);
    }

    public void d0(Fragment fragment) {
        if (P(2)) {
            String str = "remove: " + fragment + " nesting=" + fragment.mBackStackNesting;
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.f2180c.l(fragment);
            if (Q(fragment)) {
                this.C = true;
            }
            fragment.mRemoving = true;
            l0(fragment);
        }
    }

    public final void e(Fragment fragment) {
        HashSet<b.i.h.a> hashSet = this.l.get(fragment);
        if (hashSet != null) {
            Iterator<b.i.h.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            j(fragment);
            this.l.remove(fragment);
        }
    }

    public final void e0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
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

    public final void f() {
        this.f2179b = false;
        this.I.clear();
        this.H.clear();
    }

    public void f0(Parcelable parcelable) {
        g0 g0Var;
        if (parcelable != null) {
            b0 b0Var = (b0) parcelable;
            if (b0Var.f1976b != null) {
                this.f2180c.f2030b.clear();
                Iterator<f0> it = b0Var.f1976b.iterator();
                while (it.hasNext()) {
                    f0 next = it.next();
                    if (next != null) {
                        Fragment fragment = this.L.f1993a.get(next.f2011c);
                        if (fragment != null) {
                            if (P(2)) {
                                String str = "restoreSaveState: re-attaching retained " + fragment;
                            }
                            g0Var = new g0(this.n, this.f2180c, fragment, next);
                        } else {
                            g0Var = new g0(this.n, this.f2180c, this.q.f2143c.getClassLoader(), M(), next);
                        }
                        Fragment fragment2 = g0Var.f2021c;
                        fragment2.mFragmentManager = this;
                        if (P(2)) {
                            StringBuilder h2 = c.a.a.a.a.h("restoreSaveState: active (");
                            h2.append(fragment2.mWho);
                            h2.append("): ");
                            h2.append(fragment2);
                            h2.toString();
                        }
                        g0Var.m(this.q.f2143c.getClassLoader());
                        this.f2180c.j(g0Var);
                        g0Var.f2023e = this.p;
                    }
                }
                c0 c0Var = this.L;
                if (c0Var != null) {
                    Iterator it2 = new ArrayList(c0Var.f1993a.values()).iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = (Fragment) it2.next();
                        if (!this.f2180c.c(fragment3.mWho)) {
                            if (P(2)) {
                                String str2 = "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + b0Var.f1976b;
                            }
                            this.L.b(fragment3);
                            fragment3.mFragmentManager = this;
                            g0 g0Var2 = new g0(this.n, this.f2180c, fragment3);
                            g0Var2.f2023e = 1;
                            g0Var2.k();
                            fragment3.mRemoving = true;
                            g0Var2.k();
                        }
                    }
                    h0 h0Var = this.f2180c;
                    ArrayList<String> arrayList = b0Var.f1977c;
                    h0Var.f2029a.clear();
                    if (arrayList != null) {
                        for (String str3 : arrayList) {
                            Fragment d2 = h0Var.d(str3);
                            if (d2 != null) {
                                if (P(2)) {
                                    String str4 = "restoreSaveState: added (" + str3 + "): " + d2;
                                }
                                h0Var.a(d2);
                            } else {
                                throw new IllegalStateException(c.a.a.a.a.c("No instantiated fragment for (", str3, ")"));
                            }
                        }
                    }
                    if (b0Var.f1978d != null) {
                        this.f2181d = new ArrayList<>(b0Var.f1978d.length);
                        int i2 = 0;
                        while (true) {
                            b[] bVarArr = b0Var.f1978d;
                            if (i2 >= bVarArr.length) {
                                break;
                            }
                            b bVar = bVarArr[i2];
                            if (bVar != null) {
                                a aVar = new a(this);
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < bVar.f1970b.length) {
                                    i0.a aVar2 = new i0.a();
                                    int i5 = i3 + 1;
                                    aVar2.f2042a = bVar.f1970b[i3];
                                    if (P(2)) {
                                        String str5 = "Instantiate " + aVar + " op #" + i4 + " base fragment #" + bVar.f1970b[i5];
                                    }
                                    String str6 = bVar.f1971c.get(i4);
                                    aVar2.f2043b = str6 != null ? this.f2180c.d(str6) : null;
                                    aVar2.f2048g = f.b.values()[bVar.f1972d[i4]];
                                    aVar2.h = f.b.values()[bVar.f1973e[i4]];
                                    int[] iArr = bVar.f1970b;
                                    int i6 = i5 + 1;
                                    int i7 = iArr[i5];
                                    aVar2.f2044c = i7;
                                    int i8 = i6 + 1;
                                    int i9 = iArr[i6];
                                    aVar2.f2045d = i9;
                                    int i10 = i8 + 1;
                                    int i11 = iArr[i8];
                                    aVar2.f2046e = i11;
                                    int i12 = iArr[i10];
                                    aVar2.f2047f = i12;
                                    aVar.f2036b = i7;
                                    aVar.f2037c = i9;
                                    aVar.f2038d = i11;
                                    aVar.f2039e = i12;
                                    aVar.b(aVar2);
                                    i4++;
                                    i3 = i10 + 1;
                                }
                                aVar.f2040f = bVar.f1974f;
                                aVar.i = bVar.f1975g;
                                aVar.t = bVar.h;
                                aVar.f2041g = true;
                                aVar.j = bVar.i;
                                aVar.k = bVar.j;
                                aVar.l = bVar.k;
                                aVar.m = bVar.l;
                                aVar.n = bVar.m;
                                aVar.o = bVar.n;
                                aVar.p = bVar.o;
                                aVar.k(1);
                                if (P(2)) {
                                    StringBuilder i13 = c.a.a.a.a.i("restoreAllState: back stack #", i2, " (index ");
                                    i13.append(aVar.t);
                                    i13.append("): ");
                                    i13.append(aVar);
                                    i13.toString();
                                    PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
                                    aVar.m("  ", printWriter, false);
                                    printWriter.close();
                                }
                                this.f2181d.add(aVar);
                                i2++;
                            } else {
                                throw null;
                            }
                        }
                    } else {
                        this.f2181d = null;
                    }
                    this.i.set(b0Var.f1979e);
                    String str7 = b0Var.f1980f;
                    if (str7 != null) {
                        Fragment H2 = H(str7);
                        this.t = H2;
                        u(H2);
                    }
                    ArrayList<String> arrayList2 = b0Var.f1981g;
                    if (arrayList2 != null) {
                        for (int i14 = 0; i14 < arrayList2.size(); i14++) {
                            this.j.put(arrayList2.get(i14), b0Var.h.get(i14));
                        }
                    }
                    this.B = new ArrayDeque<>(b0Var.i);
                    return;
                }
                throw null;
            }
        }
    }

    public final Set<w0> g() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.f2180c.f()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((g0) it.next()).f2021c.mContainer;
            if (viewGroup != null) {
                hashSet.add(w0.g(viewGroup, N()));
            }
        }
        return hashSet;
    }

    public Parcelable g0() {
        int i2;
        ArrayList<String> arrayList;
        int size;
        Iterator it = ((HashSet) g()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            w0 w0Var = (w0) it.next();
            if (w0Var.f2150e) {
                w0Var.f2150e = false;
                w0Var.c();
            }
        }
        A();
        D(true);
        this.D = true;
        this.L.f1999g = true;
        h0 h0Var = this.f2180c;
        b[] bVarArr = null;
        if (h0Var != null) {
            ArrayList<f0> arrayList2 = new ArrayList<>(h0Var.f2030b.size());
            for (g0 g0Var : h0Var.f2030b.values()) {
                if (g0Var != null) {
                    Fragment fragment = g0Var.f2021c;
                    f0 f0Var = new f0(fragment);
                    if (g0Var.f2021c.mState <= -1 || f0Var.n != null) {
                        f0Var.n = g0Var.f2021c.mSavedFragmentState;
                    } else {
                        Bundle bundle = new Bundle();
                        g0Var.f2021c.performSaveInstanceState(bundle);
                        g0Var.f2019a.j(g0Var.f2021c, bundle, false);
                        if (bundle.isEmpty()) {
                            bundle = null;
                        }
                        if (g0Var.f2021c.mView != null) {
                            g0Var.o();
                        }
                        if (g0Var.f2021c.mSavedViewState != null) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putSparseParcelableArray("android:view_state", g0Var.f2021c.mSavedViewState);
                        }
                        if (g0Var.f2021c.mSavedViewRegistryState != null) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putBundle("android:view_registry_state", g0Var.f2021c.mSavedViewRegistryState);
                        }
                        if (!g0Var.f2021c.mUserVisibleHint) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putBoolean("android:user_visible_hint", g0Var.f2021c.mUserVisibleHint);
                        }
                        f0Var.n = bundle;
                        if (g0Var.f2021c.mTargetWho != null) {
                            if (bundle == null) {
                                f0Var.n = new Bundle();
                            }
                            f0Var.n.putString("android:target_state", g0Var.f2021c.mTargetWho);
                            int i3 = g0Var.f2021c.mTargetRequestCode;
                            if (i3 != 0) {
                                f0Var.n.putInt("android:target_req_state", i3);
                            }
                        }
                    }
                    arrayList2.add(f0Var);
                    if (P(2)) {
                        String str = "Saved state of " + fragment + ": " + f0Var.n;
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                return null;
            }
            h0 h0Var2 = this.f2180c;
            synchronized (h0Var2.f2029a) {
                if (h0Var2.f2029a.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(h0Var2.f2029a.size());
                    Iterator<Fragment> it2 = h0Var2.f2029a.iterator();
                    while (it2.hasNext()) {
                        Fragment next = it2.next();
                        arrayList.add(next.mWho);
                        if (P(2)) {
                            String str2 = "saveAllState: adding fragment (" + next.mWho + "): " + next;
                        }
                    }
                }
            }
            ArrayList<a> arrayList3 = this.f2181d;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                bVarArr = new b[size];
                for (i2 = 0; i2 < size; i2++) {
                    bVarArr[i2] = new b(this.f2181d.get(i2));
                    if (P(2)) {
                        StringBuilder i4 = c.a.a.a.a.i("saveAllState: adding back stack #", i2, ": ");
                        i4.append(this.f2181d.get(i2));
                        i4.toString();
                    }
                }
            }
            b0 b0Var = new b0();
            b0Var.f1976b = arrayList2;
            b0Var.f1977c = arrayList;
            b0Var.f1978d = bVarArr;
            b0Var.f1979e = this.i.get();
            Fragment fragment2 = this.t;
            if (fragment2 != null) {
                b0Var.f1980f = fragment2.mWho;
            }
            b0Var.f1981g.addAll(this.j.keySet());
            b0Var.h.addAll(this.j.values());
            b0Var.i = new ArrayList<>(this.B);
            return b0Var;
        }
        throw null;
    }

    public void h(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.o(z4);
        } else {
            aVar.n();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3 && this.p >= 1) {
            p0.q(this.q.f2143c, this.r, arrayList, arrayList2, 0, 1, true, this.m);
        }
        if (z4) {
            U(this.p, true);
        }
        Iterator it = ((ArrayList) this.f2180c.g()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.p(fragment.mContainerId)) {
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

    public void h0() {
        synchronized (this.f2178a) {
            boolean z2 = false;
            boolean z3 = this.K != null && !this.K.isEmpty();
            if (this.f2178a.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.q.f2144d.removeCallbacks(this.M);
                this.q.f2144d.post(this.M);
                p0();
            }
        }
    }

    public g0 i(Fragment fragment) {
        g0 h2 = this.f2180c.h(fragment.mWho);
        if (h2 != null) {
            return h2;
        }
        g0 g0Var = new g0(this.n, this.f2180c, fragment);
        g0Var.m(this.q.f2143c.getClassLoader());
        g0Var.f2023e = this.p;
        return g0Var;
    }

    public void i0(Fragment fragment, boolean z2) {
        ViewGroup L2 = L(fragment);
        if (L2 != null && (L2 instanceof t)) {
            ((t) L2).setDrawDisappearingViewsLast(!z2);
        }
    }

    public final void j(Fragment fragment) {
        fragment.performDestroyView();
        this.n.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public void j0(Fragment fragment, f.b bVar) {
        if (!fragment.equals(H(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = bVar;
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
                this.f2180c.l(fragment);
                if (Q(fragment)) {
                    this.C = true;
                }
                l0(fragment);
            }
        }
    }

    public void k0(Fragment fragment) {
        if (fragment == null || (fragment.equals(H(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.t;
            this.t = fragment;
            u(fragment2);
            u(this.t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void l(Configuration configuration) {
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final void l0(Fragment fragment) {
        ViewGroup L2 = L(fragment);
        if (L2 != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (L2.getTag(b.l.b.visible_removing_fragment_view_tag) == null) {
                    L2.setTag(b.l.b.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) L2.getTag(b.l.b.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public boolean m(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m0(Fragment fragment) {
        if (P(2)) {
            String str = "show: " + fragment;
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void n() {
        this.D = false;
        this.E = false;
        this.L.f1999g = false;
        x(1);
    }

    public final void n0() {
        Iterator it = ((ArrayList) this.f2180c.f()).iterator();
        while (it.hasNext()) {
            X((g0) it.next());
        }
    }

    public boolean o(Menu menu, MenuInflater menuInflater) {
        if (this.p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null && R(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f2182e != null) {
            for (int i2 = 0; i2 < this.f2182e.size(); i2++) {
                Fragment fragment2 = this.f2182e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2182e = arrayList;
        return z2;
    }

    public final void o0(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
        w<?> wVar = this.q;
        if (wVar != null) {
            try {
                m.this.dump("  ", null, printWriter, new String[0]);
            } catch (Exception unused) {
            }
        } else {
            z("  ", null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public void p() {
        this.F = true;
        D(true);
        A();
        x(-1);
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.f2184g != null) {
            Iterator<b.a.a> it = this.h.f497b.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f2184g = null;
        }
        b.a.e.c<Intent> cVar = this.y;
        if (cVar != null) {
            cVar.b();
            this.z.b();
            this.A.b();
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
        if (S(r4.s) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r0.f496a = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r0 = r4.h;
        r1 = r4.f2181d;
     */
    public final void p0() {
        synchronized (this.f2178a) {
            boolean z2 = true;
            if (!this.f2178a.isEmpty()) {
                this.h.f496a = true;
            }
        }
    }

    public void q() {
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void r(boolean z2) {
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    public boolean s(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void t(Menu menu) {
        if (this.p >= 1) {
            for (Fragment fragment : this.f2180c.i()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder((int) RecyclerView.a0.FLAG_IGNORE);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.s;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.s;
        } else {
            w<?> wVar = this.q;
            if (wVar != null) {
                sb.append(wVar.getClass().getSimpleName());
                sb.append("{");
                obj = this.q;
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
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public boolean w(Menu menu) {
        boolean z2 = false;
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.f2180c.i()) {
            if (fragment != null && R(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void x(int i2) {
        try {
            this.f2179b = true;
            for (g0 g0Var : this.f2180c.f2030b.values()) {
                if (g0Var != null) {
                    g0Var.f2023e = i2;
                }
            }
            U(i2, false);
            Iterator it = ((HashSet) g()).iterator();
            while (it.hasNext()) {
                ((w0) it.next()).e();
            }
            this.f2179b = false;
            D(true);
        } catch (Throwable th) {
            this.f2179b = false;
            throw th;
        }
    }

    public final void y() {
        if (this.G) {
            this.G = false;
            n0();
        }
    }

    public void z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String q2 = c.a.a.a.a.q(str, "    ");
        h0 h0Var = this.f2180c;
        if (h0Var != null) {
            String q3 = c.a.a.a.a.q(str, "    ");
            if (!h0Var.f2030b.isEmpty()) {
                printWriter.print(str);
                printWriter.print("Active Fragments:");
                for (g0 g0Var : h0Var.f2030b.values()) {
                    printWriter.print(str);
                    if (g0Var != null) {
                        Fragment fragment = g0Var.f2021c;
                        printWriter.println(fragment);
                        fragment.dump(q3, fileDescriptor, printWriter, strArr);
                    } else {
                        printWriter.println("null");
                    }
                }
            }
            int size3 = h0Var.f2029a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (int i2 = 0; i2 < size3; i2++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(h0Var.f2029a.get(i2).toString());
                }
            }
            ArrayList<Fragment> arrayList = this.f2182e;
            if (arrayList != null && (size2 = arrayList.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size2; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.f2182e.get(i3).toString());
                }
            }
            ArrayList<a> arrayList2 = this.f2181d;
            if (arrayList2 != null && (size = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i4 = 0; i4 < size; i4++) {
                    a aVar = this.f2181d.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.m(q2, printWriter, true);
                }
            }
            printWriter.print(str);
            printWriter.println("Back Stack Index: " + this.i.get());
            synchronized (this.f2178a) {
                int size4 = this.f2178a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println((l) this.f2178a.get(i5));
                    }
                }
            }
            printWriter.print(str);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(str);
            printWriter.print("  mHost=");
            printWriter.println(this.q);
            printWriter.print(str);
            printWriter.print("  mContainer=");
            printWriter.println(this.r);
            if (this.s != null) {
                printWriter.print(str);
                printWriter.print("  mParent=");
                printWriter.println(this.s);
            }
            printWriter.print(str);
            printWriter.print("  mCurState=");
            printWriter.print(this.p);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.D);
            printWriter.print(" mStopped=");
            printWriter.print(this.E);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.F);
            if (this.C) {
                printWriter.print(str);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.C);
                return;
            }
            return;
        }
        throw null;
    }
}
