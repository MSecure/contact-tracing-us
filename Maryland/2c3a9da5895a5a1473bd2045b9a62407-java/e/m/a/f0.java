package e.m.a;

import android.animation.Animator;
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
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.R$id;
import e.b.a.m;
import e.m.a.j0;
import e.m.a.l;
import e.m.a.o0;
import e.m.a.v0;
import e.p.a0;
import e.p.b0;
import e.p.c0;
import e.p.d0;
import e.p.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class f0 {
    public static boolean L = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public ArrayList<a> F;
    public ArrayList<Boolean> G;
    public ArrayList<l> H;
    public ArrayList<o> I;
    public j0 J;
    public Runnable K = new g();
    public final ArrayList<m> a = new ArrayList<>();
    public boolean b;
    public final n0 c = new n0();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f1604d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<l> f1605e;

    /* renamed from: f  reason: collision with root package name */
    public final d0 f1606f = new d0(this);

    /* renamed from: g  reason: collision with root package name */
    public OnBackPressedDispatcher f1607g;

    /* renamed from: h  reason: collision with root package name */
    public final e.a.b f1608h = new c(false);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f1609i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Bundle> f1610j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Object> f1611k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    public Map<l, HashSet<e.i.e.a>> f1612l = Collections.synchronizedMap(new HashMap());
    public final v0.a m = new d();
    public final e0 n = new e0(this);
    public final CopyOnWriteArrayList<k0> o = new CopyOnWriteArrayList<>();
    public int p = -1;
    public c0<?> q;
    public y r;
    public l s;
    public l t;
    public b0 u = new e();
    public e1 v = new f(this);
    public e.a.e.c<Intent> w;
    public e.a.e.c<e.a.e.e> x;
    public e.a.e.c<String[]> y;
    public ArrayDeque<l> z = new ArrayDeque<>();

    public class a implements e.a.e.b<e.a.e.a> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.a.e.b
        public void a(e.a.e.a aVar) {
            StringBuilder sb;
            e.a.e.a aVar2 = aVar;
            l pollFirst = f0.this.z.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No IntentSenders were started for ");
                sb.append(this);
            } else {
                String str = pollFirst.b;
                int i2 = pollFirst.c;
                l e2 = f0.this.c.e(str);
                if (e2 == null) {
                    sb = f.a.a.a.a.i("Intent Sender result delivered for unknown Fragment ", str);
                } else {
                    e2.I(i2, aVar2.b, aVar2.c);
                    return;
                }
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    public class b implements e.a.e.b<Map<String, Boolean>> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.a.e.b
        public void a(Map<String, Boolean> map) {
            String str;
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            l pollFirst = f0.this.z.pollFirst();
            if (pollFirst == null) {
                str = "No permissions were requested for " + this;
            } else {
                String str2 = pollFirst.b;
                l e2 = f0.this.c.e(str2);
                if (e2 == null) {
                    str = f.a.a.a.a.t("Permission request result delivered for unknown Fragment ", str2);
                } else {
                    e2.b0();
                    return;
                }
            }
            Log.w("FragmentManager", str);
        }
    }

    public class c extends e.a.b {
        public c(boolean z) {
            super(z);
        }

        @Override // e.a.b
        public void a() {
            f0 f0Var = f0.this;
            f0Var.D(true);
            if (f0Var.f1608h.a) {
                f0Var.b0();
            } else {
                f0Var.f1607g.b();
            }
        }
    }

    public class d implements v0.a {
        public d() {
        }

        public void a(l lVar, e.i.e.a aVar) {
            if (!aVar.b()) {
                f0 f0Var = f0.this;
                HashSet<e.i.e.a> hashSet = f0Var.f1612l.get(lVar);
                if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
                    f0Var.f1612l.remove(lVar);
                    if (lVar.b < 5) {
                        f0Var.j(lVar);
                        f0Var.Y(lVar, f0Var.p);
                    }
                }
            }
        }

        public void b(l lVar, e.i.e.a aVar) {
            f0 f0Var = f0.this;
            if (f0Var.f1612l.get(lVar) == null) {
                f0Var.f1612l.put(lVar, new HashSet<>());
            }
            f0Var.f1612l.get(lVar).add(aVar);
        }
    }

    public class e extends b0 {
        public e() {
        }

        @Override // e.m.a.b0
        public l a(ClassLoader classLoader, String str) {
            c0<?> c0Var = f0.this.q;
            Context context = c0Var.c;
            Objects.requireNonNull(c0Var);
            Object obj = l.W;
            try {
                return (l) b0.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e2) {
                throw new l.d(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
            } catch (IllegalAccessException e3) {
                throw new l.d(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
            } catch (NoSuchMethodException e4) {
                throw new l.d(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
            } catch (InvocationTargetException e5) {
                throw new l.d(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
            }
        }
    }

    public class f implements e1 {
        public f(f0 f0Var) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            f0.this.D(true);
        }
    }

    public class h implements k0 {
        public final /* synthetic */ l b;

        public h(f0 f0Var, l lVar) {
            this.b = lVar;
        }

        @Override // e.m.a.k0
        public void b(f0 f0Var, l lVar) {
            this.b.L();
        }
    }

    public class i implements e.a.e.b<e.a.e.a> {
        public i() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // e.a.e.b
        public void a(e.a.e.a aVar) {
            StringBuilder sb;
            e.a.e.a aVar2 = aVar;
            l pollFirst = f0.this.z.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No Activities were started for result for ");
                sb.append(this);
            } else {
                String str = pollFirst.b;
                int i2 = pollFirst.c;
                l e2 = f0.this.c.e(str);
                if (e2 == null) {
                    sb = f.a.a.a.a.i("Activity result delivered for unknown Fragment ", str);
                } else {
                    e2.I(i2, aVar2.b, aVar2.c);
                    return;
                }
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    public static class j extends e.a.e.f.a<e.a.e.e, e.a.e.a> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
        @Override // e.a.e.f.a
        public Intent a(Context context, e.a.e.e eVar) {
            Bundle bundleExtra;
            e.a.e.e eVar2 = eVar;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = eVar2.c;
            if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar2 = new e.a.e.e(eVar2.b, null, eVar2.f641d, eVar2.f642e);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar2);
            if (f0.Q(2)) {
                String str = "CreateIntent created the following intent: " + intent;
            }
            return intent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.a.e.f.a
        public e.a.e.a c(int i2, Intent intent) {
            return new e.a.e.a(i2, intent);
        }
    }

    public static abstract class k {
    }

    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();
        public String b;
        public int c;

        public class a implements Parcelable.Creator<l> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public l[] newArray(int i2) {
                return new l[i2];
            }
        }

        public l(Parcel parcel) {
            this.b = parcel.readString();
            this.c = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.b);
            parcel.writeInt(this.c);
        }
    }

    public interface m {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class n implements m {
        public final String a;
        public final int b;
        public final int c;

        public n(String str, int i2, int i3) {
            this.a = str;
            this.b = i2;
            this.c = i3;
        }

        @Override // e.m.a.f0.m
        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            l lVar = f0.this.t;
            if (lVar == null || this.b >= 0 || this.a != null || !lVar.j().b0()) {
                return f0.this.c0(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    public static class o implements l.f {
        public final boolean a;
        public final a b;
        public int c;

        public o(a aVar, boolean z) {
            this.a = z;
            this.b = aVar;
        }

        public void a() {
            boolean z = this.c > 0;
            for (l lVar : this.b.q.N()) {
                lVar.v0(null);
                if (z && lVar.F()) {
                    lVar.x0();
                }
            }
            a aVar = this.b;
            aVar.q.h(aVar, this.a, !z, true);
        }
    }

    public static boolean Q(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public final void A() {
        if (L) {
            Iterator it = ((HashSet) g()).iterator();
            while (it.hasNext()) {
                ((c1) it.next()).d();
            }
        } else if (!this.f1612l.isEmpty()) {
            for (l lVar : this.f1612l.keySet()) {
                e(lVar);
                X(lVar);
            }
        }
    }

    public void B(m mVar, boolean z2) {
        if (!z2) {
            if (this.q == null) {
                if (this.D) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (U()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            if (this.q != null) {
                this.a.add(mVar);
                i0();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void C(boolean z2) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.q == null) {
            if (this.D) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.q.f1584d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z2 || !U()) {
            if (this.F == null) {
                this.F = new ArrayList<>();
                this.G = new ArrayList<>();
            }
            this.b = true;
            try {
                G(null, null);
            } finally {
                this.b = false;
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
            ArrayList<a> arrayList = this.F;
            ArrayList<Boolean> arrayList2 = this.G;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    z3 = false;
                } else {
                    int size = this.a.size();
                    z3 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z3 |= this.a.get(i2).a(arrayList, arrayList2);
                    }
                    this.a.clear();
                    this.q.f1584d.removeCallbacks(this.K);
                }
            }
            if (z3) {
                this.b = true;
                try {
                    f0(this.F, this.G);
                    f();
                    z4 = true;
                } catch (Throwable th) {
                    f();
                    throw th;
                }
            } else {
                q0();
                y();
                this.c.b();
                return z4;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void E(m mVar, boolean z2) {
        if (!z2 || (this.q != null && !this.D)) {
            C(z2);
            ((a) mVar).a(this.F, this.G);
            this.b = true;
            try {
                f0(this.F, this.G);
                f();
                q0();
                y();
                this.c.b();
            } catch (Throwable th) {
                f();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: e.m.a.f0 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v23, resolved type: e.m.a.a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f5  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void F(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ?? r11;
        int i4;
        int i5;
        int i6;
        boolean z2;
        ViewGroup viewGroup;
        int i7;
        l lVar;
        int i8;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z3 = arrayList.get(i2).p;
        ArrayList<l> arrayList4 = this.H;
        if (arrayList4 == null) {
            this.H = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.H.addAll(this.c.j());
        l lVar2 = this.t;
        int i9 = i2;
        boolean z4 = false;
        while (true) {
            int i10 = 1;
            if (i9 < i3) {
                a aVar = arrayList.get(i9);
                int i11 = 3;
                if (!arrayList3.get(i9).booleanValue()) {
                    ArrayList<l> arrayList5 = this.H;
                    int i12 = 0;
                    while (i12 < aVar.a.size()) {
                        o0.a aVar2 = aVar.a.get(i12);
                        int i13 = aVar2.a;
                        if (i13 != i10) {
                            if (i13 == 2) {
                                lVar = aVar2.b;
                                int i14 = lVar.x;
                                int size = arrayList5.size() - 1;
                                boolean z5 = false;
                                while (size >= 0) {
                                    l lVar3 = arrayList5.get(size);
                                    if (lVar3.x != i14) {
                                        i8 = i14;
                                    } else if (lVar3 == lVar) {
                                        i8 = i14;
                                        z5 = true;
                                    } else {
                                        if (lVar3 == lVar2) {
                                            i8 = i14;
                                            aVar.a.add(i12, new o0.a(9, lVar3));
                                            i12++;
                                            lVar2 = null;
                                        } else {
                                            i8 = i14;
                                        }
                                        o0.a aVar3 = new o0.a(3, lVar3);
                                        aVar3.c = aVar2.c;
                                        aVar3.f1673e = aVar2.f1673e;
                                        aVar3.f1672d = aVar2.f1672d;
                                        aVar3.f1674f = aVar2.f1674f;
                                        aVar.a.add(i12, aVar3);
                                        arrayList5.remove(lVar3);
                                        i12++;
                                    }
                                    size--;
                                    i14 = i8;
                                }
                                if (z5) {
                                    aVar.a.remove(i12);
                                    i12--;
                                } else {
                                    i7 = 1;
                                    aVar2.a = 1;
                                    arrayList5.add(lVar);
                                    i12 += i7;
                                    i11 = 3;
                                    i10 = 1;
                                }
                            } else if (i13 == i11 || i13 == 6) {
                                arrayList5.remove(aVar2.b);
                                l lVar4 = aVar2.b;
                                if (lVar4 == lVar2) {
                                    aVar.a.add(i12, new o0.a(9, lVar4));
                                    i12++;
                                    lVar2 = null;
                                }
                            } else if (i13 != 7) {
                                if (i13 == 8) {
                                    aVar.a.add(i12, new o0.a(9, lVar2));
                                    i12++;
                                    lVar2 = aVar2.b;
                                }
                            }
                            i7 = 1;
                            i12 += i7;
                            i11 = 3;
                            i10 = 1;
                        }
                        i7 = 1;
                        lVar = aVar2.b;
                        arrayList5.add(lVar);
                        i12 += i7;
                        i11 = 3;
                        i10 = 1;
                    }
                } else {
                    int i15 = 1;
                    ArrayList<l> arrayList6 = this.H;
                    int size2 = aVar.a.size() - 1;
                    while (size2 >= 0) {
                        o0.a aVar4 = aVar.a.get(size2);
                        int i16 = aVar4.a;
                        if (i16 != i15) {
                            if (i16 != 3) {
                                switch (i16) {
                                    case 8:
                                        lVar2 = null;
                                        break;
                                    case 9:
                                        lVar2 = aVar4.b;
                                        break;
                                    case 10:
                                        aVar4.f1676h = aVar4.f1675g;
                                        break;
                                }
                                size2--;
                                i15 = 1;
                            }
                            arrayList6.add(aVar4.b);
                            size2--;
                            i15 = 1;
                        }
                        arrayList6.remove(aVar4.b);
                        size2--;
                        i15 = 1;
                    }
                }
                z4 = z4 || aVar.f1666g;
                i9++;
                arrayList3 = arrayList2;
            } else {
                this.H.clear();
                if (!z3 && this.p >= 1) {
                    if (L) {
                        for (int i17 = i2; i17 < i3; i17++) {
                            Iterator<o0.a> it = arrayList.get(i17).a.iterator();
                            while (it.hasNext()) {
                                l lVar5 = it.next().b;
                                if (lVar5 != null) {
                                    this.c.k(i(lVar5));
                                }
                            }
                        }
                    } else {
                        r11 = 1;
                        v0.p(this.q.c, this.r, arrayList, arrayList2, i2, i3, false, this.m);
                        i4 = i2;
                        while (i4 < i3) {
                            a aVar5 = arrayList.get(i4);
                            if (arrayList2.get(i4).booleanValue()) {
                                aVar5.g(-1);
                                aVar5.k(i4 == i3 + -1);
                            } else {
                                aVar5.g(r11);
                                aVar5.j();
                            }
                            i4++;
                        }
                        if (!L) {
                            boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
                            if (z3) {
                                for (int i18 = i2; i18 < i3; i18++) {
                                    a aVar6 = arrayList.get(i18);
                                    if (booleanValue) {
                                        int size3 = aVar6.a.size();
                                        int i19 = r11 == true ? 1 : 0;
                                        int i20 = r11 == true ? 1 : 0;
                                        int i21 = r11 == true ? 1 : 0;
                                        for (int i22 = size3 - i19; i22 >= 0; i22--) {
                                            l lVar6 = aVar6.a.get(i22).b;
                                            if (lVar6 != null) {
                                                i(lVar6).j();
                                            }
                                        }
                                    } else {
                                        Iterator<o0.a> it2 = aVar6.a.iterator();
                                        while (it2.hasNext()) {
                                            l lVar7 = it2.next().b;
                                            if (lVar7 != null) {
                                                i(lVar7).j();
                                            }
                                        }
                                    }
                                }
                                W(this.p, r11);
                            }
                            HashSet hashSet = new HashSet();
                            for (int i23 = i2; i23 < i3; i23++) {
                                Iterator<o0.a> it3 = arrayList.get(i23).a.iterator();
                                while (it3.hasNext()) {
                                    l lVar8 = it3.next().b;
                                    if (!(lVar8 == null || (viewGroup = lVar8.E) == null)) {
                                        hashSet.add(c1.e(viewGroup, O()));
                                    }
                                }
                            }
                            Iterator it4 = hashSet.iterator();
                            while (it4.hasNext()) {
                                c1 c1Var = (c1) it4.next();
                                c1Var.f1586d = booleanValue;
                                c1Var.f();
                                c1Var.c();
                            }
                            i5 = i2;
                        } else {
                            if (z3) {
                                e.e.c cVar = new e.e.c(0);
                                a(cVar);
                                i5 = i2;
                                int i24 = i3;
                                for (int i25 = i3 - 1; i25 >= i5; i25--) {
                                    a aVar7 = arrayList.get(i25);
                                    boolean booleanValue2 = arrayList2.get(i25).booleanValue();
                                    int i26 = 0;
                                    while (true) {
                                        if (i26 >= aVar7.a.size()) {
                                            z2 = false;
                                        } else if (a.n(aVar7.a.get(i26))) {
                                            z2 = true;
                                        } else {
                                            i26++;
                                        }
                                    }
                                    if (z2 && !aVar7.m(arrayList, i25 + 1, i3)) {
                                        if (this.I == null) {
                                            this.I = new ArrayList<>();
                                        }
                                        o oVar = new o(aVar7, booleanValue2);
                                        this.I.add(oVar);
                                        for (int i27 = 0; i27 < aVar7.a.size(); i27++) {
                                            o0.a aVar8 = aVar7.a.get(i27);
                                            if (a.n(aVar8)) {
                                                aVar8.b.v0(oVar);
                                            }
                                        }
                                        if (booleanValue2) {
                                            aVar7.j();
                                        } else {
                                            aVar7.k(false);
                                        }
                                        i24--;
                                        if (i25 != i24) {
                                            arrayList.remove(i25);
                                            arrayList.add(i24, aVar7);
                                        }
                                        a(cVar);
                                    }
                                }
                                int i28 = cVar.f1193d;
                                for (int i29 = 0; i29 < i28; i29++) {
                                    l lVar9 = (l) cVar.c[i29];
                                    if (!lVar9.f1637l) {
                                        View o0 = lVar9.o0();
                                        lVar9.L = o0.getAlpha();
                                        o0.setAlpha(0.0f);
                                    }
                                }
                                i6 = i24;
                            } else {
                                i5 = i2;
                                i6 = i3;
                            }
                            if (i6 != i5 && z3) {
                                if (this.p >= r11) {
                                    v0.p(this.q.c, this.r, arrayList, arrayList2, i2, i6, true, this.m);
                                }
                                W(this.p, r11);
                            }
                        }
                        while (i5 < i3) {
                            a aVar9 = arrayList.get(i5);
                            if (arrayList2.get(i5).booleanValue() && aVar9.s >= 0) {
                                aVar9.s = -1;
                            }
                            Objects.requireNonNull(aVar9);
                            i5++;
                        }
                        return;
                    }
                }
                r11 = 1;
                i4 = i2;
                while (i4 < i3) {
                }
                if (!L) {
                }
                while (i5 < i3) {
                }
                return;
            }
        }
    }

    public final void G(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<o> arrayList3 = this.I;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            o oVar = this.I.get(i2);
            if (arrayList == null || oVar.a || (indexOf2 = arrayList.indexOf(oVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((oVar.c == 0) || (arrayList != null && oVar.b.m(arrayList, 0, arrayList.size()))) {
                    this.I.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || oVar.a || (indexOf = arrayList.indexOf(oVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        oVar.a();
                    }
                }
                i2++;
            } else {
                this.I.remove(i2);
                i2--;
                size--;
            }
            a aVar = oVar.b;
            aVar.q.h(aVar, oVar.a, false, false);
            i2++;
        }
    }

    public l H(String str) {
        return this.c.d(str);
    }

    public l I(int i2) {
        n0 n0Var = this.c;
        int size = n0Var.a.size();
        while (true) {
            size--;
            if (size >= 0) {
                l lVar = n0Var.a.get(size);
                if (lVar != null && lVar.w == i2) {
                    return lVar;
                }
            } else {
                for (m0 m0Var : n0Var.b.values()) {
                    if (m0Var != null) {
                        l lVar2 = m0Var.c;
                        if (lVar2.w == i2) {
                            return lVar2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public l J(String str) {
        n0 n0Var = this.c;
        Objects.requireNonNull(n0Var);
        if (str != null) {
            int size = n0Var.a.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                l lVar = n0Var.a.get(size);
                if (lVar != null && str.equals(lVar.y)) {
                    return lVar;
                }
            }
        }
        if (str != null) {
            for (m0 m0Var : n0Var.b.values()) {
                if (m0Var != null) {
                    l lVar2 = m0Var.c;
                    if (str.equals(lVar2.y)) {
                        return lVar2;
                    }
                }
            }
        }
        return null;
    }

    public l K(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        l d2 = this.c.d(string);
        if (d2 != null) {
            return d2;
        }
        p0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public final ViewGroup L(l lVar) {
        ViewGroup viewGroup = lVar.E;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (lVar.x > 0 && this.r.g()) {
            View e2 = this.r.e(lVar.x);
            if (e2 instanceof ViewGroup) {
                return (ViewGroup) e2;
            }
        }
        return null;
    }

    public b0 M() {
        l lVar = this.s;
        return lVar != null ? lVar.s.M() : this.u;
    }

    public List<l> N() {
        return this.c.j();
    }

    public e1 O() {
        l lVar = this.s;
        return lVar != null ? lVar.s.O() : this.v;
    }

    public void P(l lVar) {
        if (Q(2)) {
            String str = "hide: " + lVar;
        }
        if (!lVar.z) {
            lVar.z = true;
            lVar.K = true ^ lVar.K;
            m0(lVar);
        }
    }

    public final boolean R(l lVar) {
        f0 f0Var = lVar.u;
        Iterator it = ((ArrayList) f0Var.c.h()).iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            l lVar2 = (l) it.next();
            if (lVar2 != null) {
                z2 = f0Var.R(lVar2);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public boolean S(l lVar) {
        f0 f0Var;
        if (lVar == null) {
            return true;
        }
        return lVar.C && ((f0Var = lVar.s) == null || f0Var.S(lVar.v));
    }

    public boolean T(l lVar) {
        if (lVar == null) {
            return true;
        }
        f0 f0Var = lVar.s;
        if (!lVar.equals(f0Var.t) || !T(f0Var.s)) {
            return false;
        }
        return true;
    }

    public boolean U() {
        return this.B || this.C;
    }

    public void V(l lVar) {
        Animator animator;
        if (this.c.c(lVar.f1631f)) {
            X(lVar);
            View view = lVar.F;
            if (!(view == null || !lVar.J || lVar.E == null)) {
                float f2 = lVar.L;
                if (f2 > 0.0f) {
                    view.setAlpha(f2);
                }
                lVar.L = 0.0f;
                lVar.J = false;
                v y0 = m.h.y0(this.q.c, lVar, true);
                if (y0 != null) {
                    Animation animation = y0.a;
                    if (animation != null) {
                        lVar.F.startAnimation(animation);
                    } else {
                        y0.b.setTarget(lVar.F);
                        y0.b.start();
                    }
                }
            }
            if (lVar.K) {
                if (lVar.F != null) {
                    v y02 = m.h.y0(this.q.c, lVar, !lVar.z);
                    if (y02 == null || (animator = y02.b) == null) {
                        if (y02 != null) {
                            lVar.F.startAnimation(y02.a);
                            y02.a.start();
                        }
                        lVar.F.setVisibility((!lVar.z || lVar.D()) ? 0 : 8);
                        if (lVar.D()) {
                            lVar.t0(false);
                        }
                    } else {
                        animator.setTarget(lVar.F);
                        if (!lVar.z) {
                            lVar.F.setVisibility(0);
                        } else if (lVar.D()) {
                            lVar.t0(false);
                        } else {
                            ViewGroup viewGroup = lVar.E;
                            View view2 = lVar.F;
                            viewGroup.startViewTransition(view2);
                            y02.b.addListener(new g0(this, viewGroup, view2, lVar));
                        }
                        y02.b.start();
                    }
                }
                if (lVar.f1637l && R(lVar)) {
                    this.A = true;
                }
                lVar.K = false;
                lVar.U();
            }
        } else if (Q(3)) {
            String str = "Ignoring moving " + lVar + " to state " + this.p + "since it is not added to " + this;
        }
    }

    public void W(int i2, boolean z2) {
        c0<?> c0Var;
        if (this.q == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.p) {
            this.p = i2;
            if (L) {
                n0 n0Var = this.c;
                Iterator<l> it = n0Var.a.iterator();
                while (it.hasNext()) {
                    m0 m0Var = n0Var.b.get(it.next().f1631f);
                    if (m0Var != null) {
                        m0Var.j();
                    }
                }
                for (m0 m0Var2 : n0Var.b.values()) {
                    if (m0Var2 != null) {
                        m0Var2.j();
                        l lVar = m0Var2.c;
                        if (lVar.m && !lVar.E()) {
                            n0Var.l(m0Var2);
                        }
                    }
                }
            } else {
                for (l lVar2 : this.c.j()) {
                    V(lVar2);
                }
                Iterator it2 = ((ArrayList) this.c.g()).iterator();
                while (it2.hasNext()) {
                    m0 m0Var3 = (m0) it2.next();
                    l lVar3 = m0Var3.c;
                    if (!lVar3.J) {
                        V(lVar3);
                    }
                    if (lVar3.m && !lVar3.E()) {
                        this.c.l(m0Var3);
                    }
                }
            }
            o0();
            if (this.A && (c0Var = this.q) != null && this.p == 7) {
                c0Var.m();
                this.A = false;
            }
        }
    }

    public void X(l lVar) {
        Y(lVar, this.p);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r2 != 5) goto L_0x0177;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0173  */
    public void Y(l lVar, int i2) {
        ViewGroup viewGroup;
        m0 i3 = this.c.i(lVar.f1631f);
        int i4 = 1;
        if (i3 == null) {
            i3 = new m0(this.n, this.c, lVar);
            i3.f1657e = 1;
        }
        if (lVar.n && lVar.o && lVar.b == 2) {
            i2 = Math.max(i2, 2);
        }
        int min = Math.min(i2, i3.c());
        int i5 = lVar.b;
        if (i5 <= min) {
            if (i5 < min && !this.f1612l.isEmpty()) {
                e(lVar);
            }
            int i6 = lVar.b;
            if (i6 != -1) {
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 4) {
                            }
                            if (min > 4) {
                                i3.p();
                            }
                            if (min > 5) {
                                i3.m();
                            }
                        }
                        if (min > 2) {
                            i3.a();
                        }
                        if (min > 4) {
                        }
                        if (min > 5) {
                        }
                    }
                    if (min > -1) {
                        i3.i();
                    }
                    if (min > 1) {
                        i3.e();
                    }
                    if (min > 2) {
                    }
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                }
            } else if (min > -1) {
                i3.b();
            }
            if (min > 0) {
                i3.d();
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
        } else if (i5 > min) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 4) {
                            if (i5 != 5) {
                                if (i5 == 7) {
                                    if (min < 7) {
                                        i3.k();
                                    }
                                }
                            }
                            if (min < 5) {
                                i3.q();
                            }
                        }
                        if (min < 4) {
                            if (Q(3)) {
                                String str = "movefrom ACTIVITY_CREATED: " + lVar;
                            }
                            if (lVar.F != null && this.q.l(lVar) && lVar.f1629d == null) {
                                i3.o();
                            }
                        }
                    }
                    if (min < 2) {
                        v vVar = null;
                        View view = lVar.F;
                        if (!(view == null || (viewGroup = lVar.E) == null)) {
                            viewGroup.endViewTransition(view);
                            lVar.F.clearAnimation();
                            if (!lVar.G()) {
                                if (this.p > -1 && !this.D && lVar.F.getVisibility() == 0 && lVar.L >= 0.0f) {
                                    vVar = m.h.y0(this.q.c, lVar, false);
                                }
                                lVar.L = 0.0f;
                                ViewGroup viewGroup2 = lVar.E;
                                View view2 = lVar.F;
                                if (vVar != null) {
                                    v0.a aVar = this.m;
                                    viewGroup2.startViewTransition(view2);
                                    e.i.e.a aVar2 = new e.i.e.a();
                                    aVar2.c(new s(lVar));
                                    d dVar = (d) aVar;
                                    dVar.b(lVar, aVar2);
                                    if (vVar.a != null) {
                                        w wVar = new w(vVar.a, viewGroup2, view2);
                                        lVar.q0(lVar.F);
                                        wVar.setAnimationListener(new t(viewGroup2, lVar, dVar, aVar2));
                                        lVar.F.startAnimation(wVar);
                                    } else {
                                        Animator animator = vVar.b;
                                        lVar.r0(animator);
                                        animator.addListener(new u(viewGroup2, view2, lVar, dVar, aVar2));
                                        animator.setTarget(lVar.F);
                                        animator.start();
                                    }
                                }
                                viewGroup2.removeView(view2);
                                if (viewGroup2 != lVar.E) {
                                    return;
                                }
                            }
                        }
                        if (this.f1612l.get(lVar) == null) {
                            i3.g();
                        }
                    }
                }
                if (min < 1) {
                    if (this.f1612l.get(lVar) == null) {
                        i3.f();
                    }
                    if (i4 < 0) {
                        i3.h();
                    }
                    min = i4;
                }
            }
            i4 = min;
            if (i4 < 0) {
            }
            min = i4;
        }
        if (lVar.b != min) {
            if (Q(3)) {
                String str2 = "moveToState: Fragment state for " + lVar + " not updated inline; expected state " + min + " found " + lVar.b;
            }
            lVar.b = min;
        }
    }

    public void Z() {
        if (this.q != null) {
            this.B = false;
            this.C = false;
            this.J.f1628h = false;
            for (l lVar : this.c.j()) {
                if (lVar != null) {
                    lVar.u.Z();
                }
            }
        }
    }

    public final void a(e.e.c<l> cVar) {
        int i2 = this.p;
        if (i2 >= 1) {
            int min = Math.min(i2, 5);
            for (l lVar : this.c.j()) {
                if (lVar.b < min) {
                    Y(lVar, min);
                    if (lVar.F != null && !lVar.z && lVar.J) {
                        cVar.add(lVar);
                    }
                }
            }
        }
    }

    public void a0(String str, int i2) {
        B(new n(str, -1, i2), false);
    }

    public void b(l lVar) {
        if (Q(2)) {
            String str = "add: " + lVar;
        }
        this.c.k(i(lVar));
        if (!lVar.A) {
            this.c.a(lVar);
            lVar.m = false;
            if (lVar.F == null) {
                lVar.K = false;
            }
            if (R(lVar)) {
                this.A = true;
            }
        }
    }

    public boolean b0() {
        D(false);
        C(true);
        l lVar = this.t;
        if (lVar != null && lVar.j().b0()) {
            return true;
        }
        boolean c0 = c0(this.F, this.G, null, -1, 0);
        if (c0) {
            this.b = true;
            try {
                f0(this.F, this.G);
            } finally {
                f();
            }
        }
        q0();
        y();
        this.c.b();
        return c0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    public void c(c0<?> c0Var, y yVar, l lVar) {
        c0<?> c0Var2;
        k0 k0Var;
        if (this.q == null) {
            this.q = c0Var;
            this.r = yVar;
            this.s = lVar;
            if (lVar != null) {
                k0Var = new h(this, lVar);
            } else {
                if (c0Var instanceof k0) {
                    k0Var = (k0) c0Var;
                }
                if (this.s != null) {
                    q0();
                }
                if (c0Var instanceof e.a.c) {
                    e.a.c cVar = (e.a.c) c0Var;
                    OnBackPressedDispatcher c2 = cVar.c();
                    this.f1607g = c2;
                    e.p.j jVar = cVar;
                    if (lVar != null) {
                        jVar = lVar;
                    }
                    c2.a(jVar, this.f1608h);
                }
                if (lVar == null) {
                    j0 j0Var = lVar.s.J;
                    j0 j0Var2 = j0Var.f1624d.get(lVar.f1631f);
                    if (j0Var2 == null) {
                        j0Var2 = new j0(j0Var.f1626f);
                        j0Var.f1624d.put(lVar.f1631f, j0Var2);
                    }
                    this.J = j0Var2;
                } else if (c0Var instanceof d0) {
                    c0 i2 = ((d0) c0Var).i();
                    b0.b bVar = j0.f1623i;
                    String canonicalName = j0.class.getCanonicalName();
                    if (canonicalName != null) {
                        String t2 = f.a.a.a.a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                        a0 a0Var = i2.a.get(t2);
                        if (!j0.class.isInstance(a0Var)) {
                            a0Var = bVar instanceof b0.c ? ((b0.c) bVar).c(t2, j0.class) : ((j0.a) bVar).a(j0.class);
                            a0 put = i2.a.put(t2, a0Var);
                            if (put != null) {
                                put.a();
                            }
                        } else if (bVar instanceof b0.e) {
                            ((b0.e) bVar).b(a0Var);
                        }
                        this.J = (j0) a0Var;
                    } else {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                } else {
                    this.J = new j0(false);
                }
                this.J.f1628h = U();
                this.c.c = this.J;
                c0Var2 = this.q;
                if (!(c0Var2 instanceof e.a.e.d)) {
                    ActivityResultRegistry f2 = ((e.a.e.d) c0Var2).f();
                    String t3 = f.a.a.a.a.t("FragmentManager:", lVar != null ? f.a.a.a.a.e(new StringBuilder(), lVar.f1631f, ":") : "");
                    this.w = f2.c(f.a.a.a.a.t(t3, "StartActivityForResult"), new e.a.e.f.c(), new i());
                    this.x = f2.c(f.a.a.a.a.t(t3, "StartIntentSenderForResult"), new j(), new a());
                    this.y = f2.c(f.a.a.a.a.t(t3, "RequestPermissions"), new e.a.e.f.b(), new b());
                    return;
                }
                return;
            }
            this.o.add(k0Var);
            if (this.s != null) {
            }
            if (c0Var instanceof e.a.c) {
            }
            if (lVar == null) {
            }
            this.J.f1628h = U();
            this.c.c = this.J;
            c0Var2 = this.q;
            if (!(c0Var2 instanceof e.a.e.d)) {
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public boolean c0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        Boolean bool = Boolean.TRUE;
        ArrayList<a> arrayList3 = this.f1604d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1604d.remove(size));
            arrayList2.add(bool);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f1604d.get(size2);
                    if ((str != null && str.equals(aVar.f1668i)) || (i2 >= 0 && i2 == aVar.s)) {
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
                        a aVar2 = this.f1604d.get(size2);
                        if ((str == null || !str.equals(aVar2.f1668i)) && (i2 < 0 || i2 != aVar2.s)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f1604d.size() - 1) {
                return false;
            }
            for (int size3 = this.f1604d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1604d.remove(size3));
                arrayList2.add(bool);
            }
        }
        return true;
    }

    public void d(l lVar) {
        if (Q(2)) {
            String str = "attach: " + lVar;
        }
        if (lVar.A) {
            lVar.A = false;
            if (!lVar.f1637l) {
                this.c.a(lVar);
                if (Q(2)) {
                    String str2 = "add from attach: " + lVar;
                }
                if (R(lVar)) {
                    this.A = true;
                }
            }
        }
    }

    public void d0(Bundle bundle, String str, l lVar) {
        if (lVar.s == this) {
            bundle.putString(str, lVar.f1631f);
        } else {
            p0(new IllegalStateException(f.a.a.a.a.s("Fragment ", lVar, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void e(l lVar) {
        HashSet<e.i.e.a> hashSet = this.f1612l.get(lVar);
        if (hashSet != null) {
            Iterator<e.i.e.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            j(lVar);
            this.f1612l.remove(lVar);
        }
    }

    public void e0(l lVar) {
        if (Q(2)) {
            String str = "remove: " + lVar + " nesting=" + lVar.r;
        }
        boolean z2 = !lVar.E();
        if (!lVar.A || z2) {
            this.c.m(lVar);
            if (R(lVar)) {
                this.A = true;
            }
            lVar.m = true;
            m0(lVar);
        }
    }

    public final void f() {
        this.b = false;
        this.G.clear();
        this.F.clear();
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

    public final Set<c1> g() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((m0) it.next()).c.E;
            if (viewGroup != null) {
                hashSet.add(c1.e(viewGroup, O()));
            }
        }
        return hashSet;
    }

    public void g0(Parcelable parcelable) {
        m0 m0Var;
        if (parcelable != null) {
            i0 i0Var = (i0) parcelable;
            if (i0Var.b != null) {
                this.c.b.clear();
                Iterator<l0> it = i0Var.b.iterator();
                while (it.hasNext()) {
                    l0 next = it.next();
                    if (next != null) {
                        l lVar = this.J.c.get(next.c);
                        if (lVar != null) {
                            if (Q(2)) {
                                String str = "restoreSaveState: re-attaching retained " + lVar;
                            }
                            m0Var = new m0(this.n, this.c, lVar, next);
                        } else {
                            m0Var = new m0(this.n, this.c, this.q.c.getClassLoader(), M(), next);
                        }
                        l lVar2 = m0Var.c;
                        lVar2.s = this;
                        if (Q(2)) {
                            StringBuilder h2 = f.a.a.a.a.h("restoreSaveState: active (");
                            h2.append(lVar2.f1631f);
                            h2.append("): ");
                            h2.append(lVar2);
                            h2.toString();
                        }
                        m0Var.l(this.q.c.getClassLoader());
                        this.c.k(m0Var);
                        m0Var.f1657e = this.p;
                    }
                }
                j0 j0Var = this.J;
                Objects.requireNonNull(j0Var);
                Iterator it2 = new ArrayList(j0Var.c.values()).iterator();
                while (it2.hasNext()) {
                    l lVar3 = (l) it2.next();
                    if (!this.c.c(lVar3.f1631f)) {
                        if (Q(2)) {
                            String str2 = "Discarding retained Fragment " + lVar3 + " that was not found in the set of active Fragments " + i0Var.b;
                        }
                        this.J.c(lVar3);
                        lVar3.s = this;
                        m0 m0Var2 = new m0(this.n, this.c, lVar3);
                        m0Var2.f1657e = 1;
                        m0Var2.j();
                        lVar3.m = true;
                        m0Var2.j();
                    }
                }
                n0 n0Var = this.c;
                ArrayList<String> arrayList = i0Var.c;
                n0Var.a.clear();
                if (arrayList != null) {
                    for (String str3 : arrayList) {
                        l d2 = n0Var.d(str3);
                        if (d2 != null) {
                            if (Q(2)) {
                                String str4 = "restoreSaveState: added (" + str3 + "): " + d2;
                            }
                            n0Var.a(d2);
                        } else {
                            throw new IllegalStateException(f.a.a.a.a.c("No instantiated fragment for (", str3, ")"));
                        }
                    }
                }
                if (i0Var.f1617d != null) {
                    this.f1604d = new ArrayList<>(i0Var.f1617d.length);
                    int i2 = 0;
                    while (true) {
                        b[] bVarArr = i0Var.f1617d;
                        if (i2 >= bVarArr.length) {
                            break;
                        }
                        b bVar = bVarArr[i2];
                        Objects.requireNonNull(bVar);
                        a aVar = new a(this);
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            int[] iArr = bVar.b;
                            if (i3 >= iArr.length) {
                                break;
                            }
                            o0.a aVar2 = new o0.a();
                            int i5 = i3 + 1;
                            aVar2.a = iArr[i3];
                            if (Q(2)) {
                                String str5 = "Instantiate " + aVar + " op #" + i4 + " base fragment #" + bVar.b[i5];
                            }
                            String str6 = bVar.c.get(i4);
                            aVar2.b = str6 != null ? this.c.d(str6) : null;
                            aVar2.f1675g = g.b.values()[bVar.f1575d[i4]];
                            aVar2.f1676h = g.b.values()[bVar.f1576e[i4]];
                            int[] iArr2 = bVar.b;
                            int i6 = i5 + 1;
                            int i7 = iArr2[i5];
                            aVar2.c = i7;
                            int i8 = i6 + 1;
                            int i9 = iArr2[i6];
                            aVar2.f1672d = i9;
                            int i10 = i8 + 1;
                            int i11 = iArr2[i8];
                            aVar2.f1673e = i11;
                            int i12 = iArr2[i10];
                            aVar2.f1674f = i12;
                            aVar.b = i7;
                            aVar.c = i9;
                            aVar.f1663d = i11;
                            aVar.f1664e = i12;
                            aVar.b(aVar2);
                            i4++;
                            i3 = i10 + 1;
                        }
                        aVar.f1665f = bVar.f1577f;
                        aVar.f1668i = bVar.f1578g;
                        aVar.s = bVar.f1579h;
                        aVar.f1666g = true;
                        aVar.f1669j = bVar.f1580i;
                        aVar.f1670k = bVar.f1581j;
                        aVar.f1671l = bVar.f1582k;
                        aVar.m = bVar.f1583l;
                        aVar.n = bVar.m;
                        aVar.o = bVar.n;
                        aVar.p = bVar.o;
                        aVar.g(1);
                        if (Q(2)) {
                            String str7 = "restoreAllState: back stack #" + i2 + " (index " + aVar.s + "): " + aVar;
                            PrintWriter printWriter = new PrintWriter(new b1("FragmentManager"));
                            aVar.i("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1604d.add(aVar);
                        i2++;
                    }
                } else {
                    this.f1604d = null;
                }
                this.f1609i.set(i0Var.f1618e);
                String str8 = i0Var.f1619f;
                if (str8 != null) {
                    l H2 = H(str8);
                    this.t = H2;
                    u(H2);
                }
                ArrayList<String> arrayList2 = i0Var.f1620g;
                if (arrayList2 != null) {
                    for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                        this.f1610j.put(arrayList2.get(i13), i0Var.f1621h.get(i13));
                    }
                }
                this.z = new ArrayDeque<>(i0Var.f1622i);
            }
        }
    }

    public void h(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.k(z4);
        } else {
            aVar.j();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3 && this.p >= 1) {
            v0.p(this.q.c, this.r, arrayList, arrayList2, 0, 1, true, this.m);
        }
        if (z4) {
            W(this.p, true);
        }
        Iterator it = ((ArrayList) this.c.h()).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (lVar != null && lVar.F != null && lVar.J && aVar.l(lVar.x)) {
                float f2 = lVar.L;
                if (f2 > 0.0f) {
                    lVar.F.setAlpha(f2);
                }
                if (z4) {
                    lVar.L = 0.0f;
                } else {
                    lVar.L = -1.0f;
                    lVar.J = false;
                }
            }
        }
    }

    public Parcelable h0() {
        ArrayList<String> arrayList;
        int size;
        if (L) {
            Iterator it = ((HashSet) g()).iterator();
            while (it.hasNext()) {
                c1 c1Var = (c1) it.next();
                if (c1Var.f1587e) {
                    c1Var.f1587e = false;
                    c1Var.c();
                }
            }
        } else if (this.I != null) {
            while (!this.I.isEmpty()) {
                this.I.remove(0).a();
            }
        }
        A();
        D(true);
        this.B = true;
        this.J.f1628h = true;
        n0 n0Var = this.c;
        Objects.requireNonNull(n0Var);
        ArrayList<l0> arrayList2 = new ArrayList<>(n0Var.b.size());
        for (m0 m0Var : n0Var.b.values()) {
            if (m0Var != null) {
                l lVar = m0Var.c;
                l0 l0Var = new l0(lVar);
                l lVar2 = m0Var.c;
                if (lVar2.b <= -1 || l0Var.n != null) {
                    l0Var.n = lVar2.c;
                } else {
                    Bundle n2 = m0Var.n();
                    l0Var.n = n2;
                    if (m0Var.c.f1634i != null) {
                        if (n2 == null) {
                            l0Var.n = new Bundle();
                        }
                        l0Var.n.putString("android:target_state", m0Var.c.f1634i);
                        int i2 = m0Var.c.f1635j;
                        if (i2 != 0) {
                            l0Var.n.putInt("android:target_req_state", i2);
                        }
                    }
                }
                arrayList2.add(l0Var);
                if (Q(2)) {
                    String str = "Saved state of " + lVar + ": " + l0Var.n;
                }
            }
        }
        b[] bVarArr = null;
        if (arrayList2.isEmpty()) {
            Q(2);
            return null;
        }
        n0 n0Var2 = this.c;
        synchronized (n0Var2.a) {
            if (n0Var2.a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(n0Var2.a.size());
                Iterator<l> it2 = n0Var2.a.iterator();
                while (it2.hasNext()) {
                    l next = it2.next();
                    arrayList.add(next.f1631f);
                    if (Q(2)) {
                        String str2 = "saveAllState: adding fragment (" + next.f1631f + "): " + next;
                    }
                }
            }
        }
        ArrayList<a> arrayList3 = this.f1604d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new b[size];
            for (int i3 = 0; i3 < size; i3++) {
                bVarArr[i3] = new b(this.f1604d.get(i3));
                if (Q(2)) {
                    String str3 = "saveAllState: adding back stack #" + i3 + ": " + this.f1604d.get(i3);
                }
            }
        }
        i0 i0Var = new i0();
        i0Var.b = arrayList2;
        i0Var.c = arrayList;
        i0Var.f1617d = bVarArr;
        i0Var.f1618e = this.f1609i.get();
        l lVar3 = this.t;
        if (lVar3 != null) {
            i0Var.f1619f = lVar3.f1631f;
        }
        i0Var.f1620g.addAll(this.f1610j.keySet());
        i0Var.f1621h.addAll(this.f1610j.values());
        i0Var.f1622i = new ArrayList<>(this.z);
        return i0Var;
    }

    public m0 i(l lVar) {
        m0 i2 = this.c.i(lVar.f1631f);
        if (i2 != null) {
            return i2;
        }
        m0 m0Var = new m0(this.n, this.c, lVar);
        m0Var.l(this.q.c.getClassLoader());
        m0Var.f1657e = this.p;
        return m0Var;
    }

    public void i0() {
        synchronized (this.a) {
            ArrayList<o> arrayList = this.I;
            boolean z2 = false;
            boolean z3 = arrayList != null && !arrayList.isEmpty();
            if (this.a.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.q.f1584d.removeCallbacks(this.K);
                this.q.f1584d.post(this.K);
                q0();
            }
        }
    }

    public final void j(l lVar) {
        lVar.j0();
        this.n.n(lVar, false);
        lVar.E = null;
        lVar.F = null;
        lVar.Q = null;
        lVar.R.l(null);
        lVar.o = false;
    }

    public void j0(l lVar, boolean z2) {
        ViewGroup L2 = L(lVar);
        if (L2 != null && (L2 instanceof z)) {
            ((z) L2).setDrawDisappearingViewsLast(!z2);
        }
    }

    public void k(l lVar) {
        if (Q(2)) {
            String str = "detach: " + lVar;
        }
        if (!lVar.A) {
            lVar.A = true;
            if (lVar.f1637l) {
                if (Q(2)) {
                    String str2 = "remove from detach: " + lVar;
                }
                this.c.m(lVar);
                if (R(lVar)) {
                    this.A = true;
                }
                m0(lVar);
            }
        }
    }

    public void k0(l lVar, g.b bVar) {
        if (!lVar.equals(H(lVar.f1631f)) || !(lVar.t == null || lVar.s == this)) {
            throw new IllegalArgumentException("Fragment " + lVar + " is not an active fragment of FragmentManager " + this);
        }
        lVar.O = bVar;
    }

    public void l(Configuration configuration) {
        for (l lVar : this.c.j()) {
            if (lVar != null) {
                lVar.onConfigurationChanged(configuration);
                lVar.u.l(configuration);
            }
        }
    }

    public void l0(l lVar) {
        if (lVar == null || (lVar.equals(H(lVar.f1631f)) && (lVar.t == null || lVar.s == this))) {
            l lVar2 = this.t;
            this.t = lVar;
            u(lVar2);
            u(this.t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + lVar + " is not an active fragment of FragmentManager " + this);
    }

    public boolean m(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (l lVar : this.c.j()) {
            if (lVar != null) {
                if (!lVar.z ? lVar.M() ? true : lVar.u.m(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void m0(l lVar) {
        ViewGroup L2 = L(lVar);
        if (L2 != null) {
            int i2 = R$id.visible_removing_fragment_view_tag;
            if (L2.getTag(i2) == null) {
                L2.setTag(i2, lVar);
            }
            ((l) L2.getTag(i2)).u0(lVar.s());
        }
    }

    public void n() {
        this.B = false;
        this.C = false;
        this.J.f1628h = false;
        x(1);
    }

    public void n0(l lVar) {
        if (Q(2)) {
            String str = "show: " + lVar;
        }
        if (lVar.z) {
            lVar.z = false;
            lVar.K = !lVar.K;
        }
    }

    public boolean o(Menu menu, MenuInflater menuInflater) {
        if (this.p < 1) {
            return false;
        }
        ArrayList<l> arrayList = null;
        boolean z2 = false;
        for (l lVar : this.c.j()) {
            if (lVar != null && S(lVar)) {
                if (!lVar.z ? lVar.u.o(menu, menuInflater) | false : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(lVar);
                    z2 = true;
                }
            }
        }
        if (this.f1605e != null) {
            for (int i2 = 0; i2 < this.f1605e.size(); i2++) {
                l lVar2 = this.f1605e.get(i2);
                if (arrayList == null || !arrayList.contains(lVar2)) {
                    Objects.requireNonNull(lVar2);
                }
            }
        }
        this.f1605e = arrayList;
        return z2;
    }

    public final void o0() {
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            m0 m0Var = (m0) it.next();
            l lVar = m0Var.c;
            if (lVar.G) {
                if (this.b) {
                    this.E = true;
                } else {
                    lVar.G = false;
                    if (L) {
                        m0Var.j();
                    } else {
                        Y(lVar, this.p);
                    }
                }
            }
        }
    }

    public void p() {
        this.D = true;
        D(true);
        A();
        x(-1);
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.f1607g != null) {
            this.f1608h.b();
            this.f1607g = null;
        }
        e.a.e.c<Intent> cVar = this.w;
        if (cVar != null) {
            cVar.b();
            this.x.b();
            this.y.b();
        }
    }

    public final void p0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new b1("FragmentManager"));
        c0<?> c0Var = this.q;
        if (c0Var != null) {
            try {
                c0Var.h("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            z("  ", null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public void q() {
        for (l lVar : this.c.j()) {
            if (lVar != null) {
                lVar.k0();
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
        if (T(r4.s) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r0.a = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r0 = r4.f1608h;
        r1 = r4.f1604d;
     */
    public final void q0() {
        synchronized (this.a) {
            boolean z2 = true;
            if (!this.a.isEmpty()) {
                this.f1608h.a = true;
            }
        }
    }

    public void r(boolean z2) {
        for (l lVar : this.c.j()) {
            if (lVar != null) {
                lVar.X();
                lVar.u.r(z2);
            }
        }
    }

    public boolean s(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (l lVar : this.c.j()) {
            if (lVar != null) {
                if (!lVar.z ? lVar.u.s(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public void t(Menu menu) {
        if (this.p >= 1) {
            for (l lVar : this.c.j()) {
                if (lVar != null && !lVar.z) {
                    lVar.u.t(menu);
                }
            }
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        l lVar = this.s;
        if (lVar != null) {
            sb.append(lVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.s;
        } else {
            c0<?> c0Var = this.q;
            if (c0Var != null) {
                sb.append(c0Var.getClass().getSimpleName());
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

    public final void u(l lVar) {
        if (lVar != null && lVar.equals(H(lVar.f1631f))) {
            boolean T = lVar.s.T(lVar);
            Boolean bool = lVar.f1636k;
            if (bool == null || bool.booleanValue() != T) {
                lVar.f1636k = Boolean.valueOf(T);
                lVar.a0(T);
                f0 f0Var = lVar.u;
                f0Var.q0();
                f0Var.u(f0Var.t);
            }
        }
    }

    public void v(boolean z2) {
        for (l lVar : this.c.j()) {
            if (lVar != null) {
                lVar.Z();
                lVar.u.v(z2);
            }
        }
    }

    public boolean w(Menu menu) {
        boolean z2 = false;
        if (this.p < 1) {
            return false;
        }
        for (l lVar : this.c.j()) {
            if (lVar != null && lVar.l0(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void x(int i2) {
        try {
            this.b = true;
            for (m0 m0Var : this.c.b.values()) {
                if (m0Var != null) {
                    m0Var.f1657e = i2;
                }
            }
            W(i2, false);
            if (L) {
                Iterator it = ((HashSet) g()).iterator();
                while (it.hasNext()) {
                    ((c1) it.next()).d();
                }
            }
            this.b = false;
            D(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void y() {
        if (this.E) {
            this.E = false;
            o0();
        }
    }

    public void z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2;
        String t2 = f.a.a.a.a.t(str, "    ");
        n0 n0Var = this.c;
        Objects.requireNonNull(n0Var);
        String str3 = str + "    ";
        if (!n0Var.b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (m0 m0Var : n0Var.b.values()) {
                printWriter.print(str);
                if (m0Var != null) {
                    l lVar = m0Var.c;
                    printWriter.println(lVar);
                    Objects.requireNonNull(lVar);
                    printWriter.print(str3);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(lVar.w));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(lVar.x));
                    printWriter.print(" mTag=");
                    printWriter.println(lVar.y);
                    printWriter.print(str3);
                    printWriter.print("mState=");
                    printWriter.print(lVar.b);
                    printWriter.print(" mWho=");
                    printWriter.print(lVar.f1631f);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(lVar.r);
                    printWriter.print(str3);
                    printWriter.print("mAdded=");
                    printWriter.print(lVar.f1637l);
                    printWriter.print(" mRemoving=");
                    printWriter.print(lVar.m);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(lVar.n);
                    printWriter.print(" mInLayout=");
                    printWriter.println(lVar.o);
                    printWriter.print(str3);
                    printWriter.print("mHidden=");
                    printWriter.print(lVar.z);
                    printWriter.print(" mDetached=");
                    printWriter.print(lVar.A);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(lVar.C);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(str3);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(lVar.B);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(lVar.H);
                    if (lVar.s != null) {
                        printWriter.print(str3);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(lVar.s);
                    }
                    if (lVar.t != null) {
                        printWriter.print(str3);
                        printWriter.print("mHost=");
                        printWriter.println(lVar.t);
                    }
                    if (lVar.v != null) {
                        printWriter.print(str3);
                        printWriter.print("mParentFragment=");
                        printWriter.println(lVar.v);
                    }
                    if (lVar.f1632g != null) {
                        printWriter.print(str3);
                        printWriter.print("mArguments=");
                        printWriter.println(lVar.f1632g);
                    }
                    if (lVar.c != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(lVar.c);
                    }
                    if (lVar.f1629d != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(lVar.f1629d);
                    }
                    if (lVar.f1630e != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(lVar.f1630e);
                    }
                    Object obj = lVar.f1633h;
                    if (obj == null) {
                        f0 f0Var = lVar.s;
                        obj = (f0Var == null || (str2 = lVar.f1634i) == null) ? null : f0Var.c.d(str2);
                    }
                    if (obj != null) {
                        printWriter.print(str3);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(lVar.f1635j);
                    }
                    if (lVar.s() != 0) {
                        printWriter.print(str3);
                        printWriter.print("mNextAnim=");
                        printWriter.println(lVar.s());
                    }
                    if (lVar.E != null) {
                        printWriter.print(str3);
                        printWriter.print("mContainer=");
                        printWriter.println(lVar.E);
                    }
                    if (lVar.F != null) {
                        printWriter.print(str3);
                        printWriter.print("mView=");
                        printWriter.println(lVar.F);
                    }
                    if (lVar.h() != null) {
                        printWriter.print(str3);
                        printWriter.print("mAnimatingAway=");
                        printWriter.println(lVar.h());
                    }
                    if (lVar.k() != null) {
                        e.q.a.a.b(lVar).a(str3, fileDescriptor, printWriter, strArr);
                    }
                    printWriter.print(str3);
                    printWriter.println("Child " + lVar.u + ":");
                    lVar.u.z(f.a.a.a.a.t(str3, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = n0Var.a.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(n0Var.a.get(i2).toString());
            }
        }
        ArrayList<l> arrayList = this.f1605e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f1605e.get(i3).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f1604d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1604d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.i(t2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1609i.get());
        synchronized (this.a) {
            int size4 = this.a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size4; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((m) this.a.get(i5));
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
        printWriter.print(this.B);
        printWriter.print(" mStopped=");
        printWriter.print(this.C);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.D);
        if (this.A) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.A);
        }
    }
}
