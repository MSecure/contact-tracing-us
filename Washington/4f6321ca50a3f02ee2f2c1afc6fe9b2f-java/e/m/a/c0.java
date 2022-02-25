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
import androidx.fragment.R$id;
import e.b.a.m;
import e.m.a.g0;
import e.m.a.l;
import e.m.a.l0;
import e.m.a.s0;
import e.p.a0;
import e.p.b0;
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

public abstract class c0 {
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
    public g0 J;
    public Runnable K = new g();
    public final ArrayList<m> a = new ArrayList<>();
    public boolean b;
    public final k0 c = new k0();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f1570d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<l> f1571e;

    /* renamed from: f  reason: collision with root package name */
    public final a0 f1572f = new a0(this);

    /* renamed from: g  reason: collision with root package name */
    public OnBackPressedDispatcher f1573g;

    /* renamed from: h  reason: collision with root package name */
    public final e.a.b f1574h = new c(false);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f1575i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Bundle> f1576j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Object> f1577k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    public Map<l, HashSet<e.i.e.a>> f1578l = Collections.synchronizedMap(new HashMap());
    public final s0.a m = new d();
    public final b0 n = new b0(this);
    public final CopyOnWriteArrayList<h0> o = new CopyOnWriteArrayList<>();
    public int p = -1;
    public z<?> q;
    public v r;
    public l s;
    public l t;
    public y u = new e();
    public b1 v = new f(this);
    public e.a.e.c<Intent> w;
    public e.a.e.c<Object> x;
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
            l pollFirst = c0.this.z.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No IntentSenders were started for ");
                sb.append(this);
            } else {
                String str = pollFirst.b;
                int i2 = pollFirst.c;
                l e2 = c0.this.c.e(str);
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
            l pollFirst = c0.this.z.pollFirst();
            if (pollFirst == null) {
                str = "No permissions were requested for " + this;
            } else {
                String str2 = pollFirst.b;
                l e2 = c0.this.c.e(str2);
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
            c0 c0Var = c0.this;
            c0Var.D(true);
            if (c0Var.f1574h.a) {
                c0Var.b0();
            } else {
                c0Var.f1573g.b();
            }
        }
    }

    public class d implements s0.a {
        public d() {
        }

        public void a(l lVar, e.i.e.a aVar) {
            if (!aVar.b()) {
                c0 c0Var = c0.this;
                HashSet<e.i.e.a> hashSet = c0Var.f1578l.get(lVar);
                if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
                    c0Var.f1578l.remove(lVar);
                    if (lVar.b < 5) {
                        c0Var.j(lVar);
                        c0Var.Y(lVar, c0Var.p);
                    }
                }
            }
        }

        public void b(l lVar, e.i.e.a aVar) {
            c0 c0Var = c0.this;
            if (c0Var.f1578l.get(lVar) == null) {
                c0Var.f1578l.put(lVar, new HashSet<>());
            }
            c0Var.f1578l.get(lVar).add(aVar);
        }
    }

    public class e extends y {
        public e() {
        }

        @Override // e.m.a.y
        public l a(ClassLoader classLoader, String str) {
            z<?> zVar = c0.this.q;
            Context context = zVar.c;
            Objects.requireNonNull(zVar);
            Object obj = l.V;
            try {
                return (l) y.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e2) {
                throw new l.c(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
            } catch (IllegalAccessException e3) {
                throw new l.c(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
            } catch (NoSuchMethodException e4) {
                throw new l.c(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
            } catch (InvocationTargetException e5) {
                throw new l.c(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
            }
        }
    }

    public class f implements b1 {
        public f(c0 c0Var) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            c0.this.D(true);
        }
    }

    public class h implements h0 {
        public final /* synthetic */ l b;

        public h(c0 c0Var, l lVar) {
            this.b = lVar;
        }

        @Override // e.m.a.h0
        public void d(c0 c0Var, l lVar) {
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
            l pollFirst = c0.this.z.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No Activities were started for result for ");
                sb.append(this);
            } else {
                String str = pollFirst.b;
                int i2 = pollFirst.c;
                l e2 = c0.this.c.e(str);
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

    public static class j extends e.a.e.f.a<Object, e.a.e.a> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.a.e.f.a
        public e.a.e.a a(int i2, Intent intent) {
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

        @Override // e.m.a.c0.m
        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            l lVar = c0.this.t;
            if (lVar == null || this.b >= 0 || this.a != null || !lVar.j().b0()) {
                return c0.this.c0(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    public static class o implements l.e {
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
                ((z0) it.next()).d();
            }
        } else if (!this.f1578l.isEmpty()) {
            for (l lVar : this.f1578l.keySet()) {
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
        } else if (Looper.myLooper() != this.q.f1692d.getLooper()) {
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
                    this.q.f1692d.removeCallbacks(this.K);
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

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: e.m.a.c0 */
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
                        l0.a aVar2 = aVar.a.get(i12);
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
                                            aVar.a.add(i12, new l0.a(9, lVar3));
                                            i12++;
                                            lVar2 = null;
                                        } else {
                                            i8 = i14;
                                        }
                                        l0.a aVar3 = new l0.a(3, lVar3);
                                        aVar3.c = aVar2.c;
                                        aVar3.f1645e = aVar2.f1645e;
                                        aVar3.f1644d = aVar2.f1644d;
                                        aVar3.f1646f = aVar2.f1646f;
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
                                    aVar.a.add(i12, new l0.a(9, lVar4));
                                    i12++;
                                    lVar2 = null;
                                }
                            } else if (i13 != 7) {
                                if (i13 == 8) {
                                    aVar.a.add(i12, new l0.a(9, lVar2));
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
                        l0.a aVar4 = aVar.a.get(size2);
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
                                        aVar4.f1648h = aVar4.f1647g;
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
                z4 = z4 || aVar.f1638g;
                i9++;
                arrayList3 = arrayList2;
            } else {
                this.H.clear();
                if (!z3 && this.p >= 1) {
                    if (L) {
                        for (int i17 = i2; i17 < i3; i17++) {
                            Iterator<l0.a> it = arrayList.get(i17).a.iterator();
                            while (it.hasNext()) {
                                l lVar5 = it.next().b;
                                if (lVar5 != null) {
                                    this.c.k(i(lVar5));
                                }
                            }
                        }
                    } else {
                        r11 = 1;
                        s0.p(this.q.c, this.r, arrayList, arrayList2, i2, i3, false, this.m);
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
                                        Iterator<l0.a> it2 = aVar6.a.iterator();
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
                                Iterator<l0.a> it3 = arrayList.get(i23).a.iterator();
                                while (it3.hasNext()) {
                                    l lVar8 = it3.next().b;
                                    if (!(lVar8 == null || (viewGroup = lVar8.E) == null)) {
                                        hashSet.add(z0.e(viewGroup, O()));
                                    }
                                }
                            }
                            Iterator it4 = hashSet.iterator();
                            while (it4.hasNext()) {
                                z0 z0Var = (z0) it4.next();
                                z0Var.f1694d = booleanValue;
                                z0Var.f();
                                z0Var.c();
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
                                            l0.a aVar8 = aVar7.a.get(i27);
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
                                int i28 = cVar.f1180d;
                                for (int i29 = 0; i29 < i28; i29++) {
                                    l lVar9 = (l) cVar.c[i29];
                                    if (!lVar9.f1625l) {
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
                                    s0.p(this.q.c, this.r, arrayList, arrayList2, i2, i6, true, this.m);
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
        k0 k0Var = this.c;
        int size = k0Var.a.size();
        while (true) {
            size--;
            if (size >= 0) {
                l lVar = k0Var.a.get(size);
                if (lVar != null && lVar.w == i2) {
                    return lVar;
                }
            } else {
                for (j0 j0Var : k0Var.b.values()) {
                    if (j0Var != null) {
                        l lVar2 = j0Var.c;
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
        k0 k0Var = this.c;
        Objects.requireNonNull(k0Var);
        if (str != null) {
            int size = k0Var.a.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                l lVar = k0Var.a.get(size);
                if (lVar != null && str.equals(lVar.y)) {
                    return lVar;
                }
            }
        }
        if (str != null) {
            for (j0 j0Var : k0Var.b.values()) {
                if (j0Var != null) {
                    l lVar2 = j0Var.c;
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
            View f2 = this.r.f(lVar.x);
            if (f2 instanceof ViewGroup) {
                return (ViewGroup) f2;
            }
        }
        return null;
    }

    public y M() {
        l lVar = this.s;
        return lVar != null ? lVar.s.M() : this.u;
    }

    public List<l> N() {
        return this.c.j();
    }

    public b1 O() {
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
        c0 c0Var = lVar.u;
        Iterator it = ((ArrayList) c0Var.c.h()).iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            l lVar2 = (l) it.next();
            if (lVar2 != null) {
                z2 = c0Var.R(lVar2);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public boolean S(l lVar) {
        c0 c0Var;
        if (lVar == null) {
            return true;
        }
        return lVar.C && ((c0Var = lVar.s) == null || c0Var.S(lVar.v));
    }

    public boolean T(l lVar) {
        if (lVar == null) {
            return true;
        }
        c0 c0Var = lVar.s;
        if (!lVar.equals(c0Var.t) || !T(c0Var.s)) {
            return false;
        }
        return true;
    }

    public boolean U() {
        return this.B || this.C;
    }

    public void V(l lVar) {
        Animator animator;
        if (this.c.c(lVar.f1619f)) {
            X(lVar);
            View view = lVar.F;
            if (!(view == null || !lVar.J || lVar.E == null)) {
                float f2 = lVar.L;
                if (f2 > 0.0f) {
                    view.setAlpha(f2);
                }
                lVar.L = 0.0f;
                lVar.J = false;
                s A0 = m.h.A0(this.q.c, lVar, true);
                if (A0 != null) {
                    Animation animation = A0.a;
                    if (animation != null) {
                        lVar.F.startAnimation(animation);
                    } else {
                        A0.b.setTarget(lVar.F);
                        A0.b.start();
                    }
                }
            }
            if (lVar.K) {
                if (lVar.F != null) {
                    s A02 = m.h.A0(this.q.c, lVar, !lVar.z);
                    if (A02 == null || (animator = A02.b) == null) {
                        if (A02 != null) {
                            lVar.F.startAnimation(A02.a);
                            A02.a.start();
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
                            A02.b.addListener(new d0(this, viewGroup, view2, lVar));
                        }
                        A02.b.start();
                    }
                }
                if (lVar.f1625l && R(lVar)) {
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
        z<?> zVar;
        if (this.q == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.p) {
            this.p = i2;
            if (L) {
                k0 k0Var = this.c;
                Iterator<l> it = k0Var.a.iterator();
                while (it.hasNext()) {
                    j0 j0Var = k0Var.b.get(it.next().f1619f);
                    if (j0Var != null) {
                        j0Var.j();
                    }
                }
                for (j0 j0Var2 : k0Var.b.values()) {
                    if (j0Var2 != null) {
                        j0Var2.j();
                        l lVar = j0Var2.c;
                        if (lVar.m && !lVar.E()) {
                            k0Var.l(j0Var2);
                        }
                    }
                }
            } else {
                for (l lVar2 : this.c.j()) {
                    V(lVar2);
                }
                Iterator it2 = ((ArrayList) this.c.g()).iterator();
                while (it2.hasNext()) {
                    j0 j0Var3 = (j0) it2.next();
                    l lVar3 = j0Var3.c;
                    if (!lVar3.J) {
                        V(lVar3);
                    }
                    if (lVar3.m && !lVar3.E()) {
                        this.c.l(j0Var3);
                    }
                }
            }
            o0();
            if (this.A && (zVar = this.q) != null && this.p == 7) {
                zVar.m();
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
        j0 i3 = this.c.i(lVar.f1619f);
        int i4 = 1;
        if (i3 == null) {
            i3 = new j0(this.n, this.c, lVar);
            i3.f1613e = 1;
        }
        if (lVar.n && lVar.o && lVar.b == 2) {
            i2 = Math.max(i2, 2);
        }
        int min = Math.min(i2, i3.c());
        int i5 = lVar.b;
        if (i5 <= min) {
            if (i5 < min && !this.f1578l.isEmpty()) {
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
                            if (lVar.F != null && this.q.l(lVar) && lVar.f1617d == null) {
                                i3.o();
                            }
                        }
                    }
                    if (min < 2) {
                        s sVar = null;
                        View view = lVar.F;
                        if (!(view == null || (viewGroup = lVar.E) == null)) {
                            viewGroup.endViewTransition(view);
                            lVar.F.clearAnimation();
                            if (!lVar.G()) {
                                if (this.p > -1 && !this.D && lVar.F.getVisibility() == 0 && lVar.L >= 0.0f) {
                                    sVar = m.h.A0(this.q.c, lVar, false);
                                }
                                lVar.L = 0.0f;
                                ViewGroup viewGroup2 = lVar.E;
                                View view2 = lVar.F;
                                if (sVar != null) {
                                    s0.a aVar = this.m;
                                    viewGroup2.startViewTransition(view2);
                                    e.i.e.a aVar2 = new e.i.e.a();
                                    aVar2.c(new p(lVar));
                                    d dVar = (d) aVar;
                                    dVar.b(lVar, aVar2);
                                    if (sVar.a != null) {
                                        t tVar = new t(sVar.a, viewGroup2, view2);
                                        lVar.q0(lVar.F);
                                        tVar.setAnimationListener(new q(viewGroup2, lVar, dVar, aVar2));
                                        lVar.F.startAnimation(tVar);
                                    } else {
                                        Animator animator = sVar.b;
                                        lVar.r0(animator);
                                        animator.addListener(new r(viewGroup2, view2, lVar, dVar, aVar2));
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
                        if (this.f1578l.get(lVar) == null) {
                            i3.g();
                        }
                    }
                }
                if (min < 1) {
                    if (this.f1578l.get(lVar) == null) {
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
            this.J.f1599h = false;
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
    public void c(z<?> zVar, v vVar, l lVar) {
        z<?> zVar2;
        h0 h0Var;
        if (this.q == null) {
            this.q = zVar;
            this.r = vVar;
            this.s = lVar;
            if (lVar != null) {
                h0Var = new h(this, lVar);
            } else {
                if (zVar instanceof h0) {
                    h0Var = (h0) zVar;
                }
                if (this.s != null) {
                    q0();
                }
                if (zVar instanceof e.a.c) {
                    e.a.c cVar = (e.a.c) zVar;
                    OnBackPressedDispatcher b2 = cVar.b();
                    this.f1573g = b2;
                    e.p.j jVar = cVar;
                    if (lVar != null) {
                        jVar = lVar;
                    }
                    b2.a(jVar, this.f1574h);
                }
                if (lVar == null) {
                    g0 g0Var = lVar.s.J;
                    g0 g0Var2 = g0Var.f1595d.get(lVar.f1619f);
                    if (g0Var2 == null) {
                        g0Var2 = new g0(g0Var.f1597f);
                        g0Var.f1595d.put(lVar.f1619f, g0Var2);
                    }
                    this.J = g0Var2;
                } else if (zVar instanceof d0) {
                    e.p.c0 h2 = ((d0) zVar).h();
                    b0.b bVar = g0.f1594i;
                    String canonicalName = g0.class.getCanonicalName();
                    if (canonicalName != null) {
                        String t2 = f.a.a.a.a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                        a0 a0Var = h2.a.get(t2);
                        if (!g0.class.isInstance(a0Var)) {
                            a0Var = bVar instanceof b0.c ? ((b0.c) bVar).c(t2, g0.class) : ((g0.a) bVar).a(g0.class);
                            a0 put = h2.a.put(t2, a0Var);
                            if (put != null) {
                                put.a();
                            }
                        } else if (bVar instanceof b0.e) {
                            ((b0.e) bVar).b(a0Var);
                        }
                        this.J = (g0) a0Var;
                    } else {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                } else {
                    this.J = new g0(false);
                }
                this.J.f1599h = U();
                this.c.c = this.J;
                zVar2 = this.q;
                if (!(zVar2 instanceof e.a.e.e)) {
                    e.a.e.d e2 = ((e.a.e.e) zVar2).e();
                    String t3 = f.a.a.a.a.t("FragmentManager:", lVar != null ? f.a.a.a.a.e(new StringBuilder(), lVar.f1619f, ":") : "");
                    this.w = e2.b(f.a.a.a.a.t(t3, "StartActivityForResult"), new e.a.e.f.c(), new i());
                    this.x = e2.b(f.a.a.a.a.t(t3, "StartIntentSenderForResult"), new j(), new a());
                    this.y = e2.b(f.a.a.a.a.t(t3, "RequestPermissions"), new e.a.e.f.b(), new b());
                    return;
                }
                return;
            }
            this.o.add(h0Var);
            if (this.s != null) {
            }
            if (zVar instanceof e.a.c) {
            }
            if (lVar == null) {
            }
            this.J.f1599h = U();
            this.c.c = this.J;
            zVar2 = this.q;
            if (!(zVar2 instanceof e.a.e.e)) {
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public boolean c0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        Boolean bool = Boolean.TRUE;
        ArrayList<a> arrayList3 = this.f1570d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1570d.remove(size));
            arrayList2.add(bool);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f1570d.get(size2);
                    if ((str != null && str.equals(aVar.f1640i)) || (i2 >= 0 && i2 == aVar.s)) {
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
                        a aVar2 = this.f1570d.get(size2);
                        if ((str == null || !str.equals(aVar2.f1640i)) && (i2 < 0 || i2 != aVar2.s)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f1570d.size() - 1) {
                return false;
            }
            for (int size3 = this.f1570d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1570d.remove(size3));
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
            if (!lVar.f1625l) {
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
            bundle.putString(str, lVar.f1619f);
        } else {
            p0(new IllegalStateException(f.a.a.a.a.s("Fragment ", lVar, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void e(l lVar) {
        HashSet<e.i.e.a> hashSet = this.f1578l.get(lVar);
        if (hashSet != null) {
            Iterator<e.i.e.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            j(lVar);
            this.f1578l.remove(lVar);
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

    public final Set<z0> g() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((j0) it.next()).c.E;
            if (viewGroup != null) {
                hashSet.add(z0.e(viewGroup, O()));
            }
        }
        return hashSet;
    }

    public void g0(Parcelable parcelable) {
        j0 j0Var;
        if (parcelable != null) {
            f0 f0Var = (f0) parcelable;
            if (f0Var.b != null) {
                this.c.b.clear();
                Iterator<i0> it = f0Var.b.iterator();
                while (it.hasNext()) {
                    i0 next = it.next();
                    if (next != null) {
                        l lVar = this.J.c.get(next.c);
                        if (lVar != null) {
                            if (Q(2)) {
                                String str = "restoreSaveState: re-attaching retained " + lVar;
                            }
                            j0Var = new j0(this.n, this.c, lVar, next);
                        } else {
                            j0Var = new j0(this.n, this.c, this.q.c.getClassLoader(), M(), next);
                        }
                        l lVar2 = j0Var.c;
                        lVar2.s = this;
                        if (Q(2)) {
                            StringBuilder h2 = f.a.a.a.a.h("restoreSaveState: active (");
                            h2.append(lVar2.f1619f);
                            h2.append("): ");
                            h2.append(lVar2);
                            h2.toString();
                        }
                        j0Var.l(this.q.c.getClassLoader());
                        this.c.k(j0Var);
                        j0Var.f1613e = this.p;
                    }
                }
                g0 g0Var = this.J;
                Objects.requireNonNull(g0Var);
                Iterator it2 = new ArrayList(g0Var.c.values()).iterator();
                while (it2.hasNext()) {
                    l lVar3 = (l) it2.next();
                    if (!this.c.c(lVar3.f1619f)) {
                        if (Q(2)) {
                            String str2 = "Discarding retained Fragment " + lVar3 + " that was not found in the set of active Fragments " + f0Var.b;
                        }
                        this.J.c(lVar3);
                        lVar3.s = this;
                        j0 j0Var2 = new j0(this.n, this.c, lVar3);
                        j0Var2.f1613e = 1;
                        j0Var2.j();
                        lVar3.m = true;
                        j0Var2.j();
                    }
                }
                k0 k0Var = this.c;
                ArrayList<String> arrayList = f0Var.c;
                k0Var.a.clear();
                if (arrayList != null) {
                    for (String str3 : arrayList) {
                        l d2 = k0Var.d(str3);
                        if (d2 != null) {
                            if (Q(2)) {
                                String str4 = "restoreSaveState: added (" + str3 + "): " + d2;
                            }
                            k0Var.a(d2);
                        } else {
                            throw new IllegalStateException(f.a.a.a.a.c("No instantiated fragment for (", str3, ")"));
                        }
                    }
                }
                if (f0Var.f1588d != null) {
                    this.f1570d = new ArrayList<>(f0Var.f1588d.length);
                    int i2 = 0;
                    while (true) {
                        b[] bVarArr = f0Var.f1588d;
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
                            l0.a aVar2 = new l0.a();
                            int i5 = i3 + 1;
                            aVar2.a = iArr[i3];
                            if (Q(2)) {
                                String str5 = "Instantiate " + aVar + " op #" + i4 + " base fragment #" + bVar.b[i5];
                            }
                            String str6 = bVar.c.get(i4);
                            aVar2.b = str6 != null ? this.c.d(str6) : null;
                            aVar2.f1647g = g.b.values()[bVar.f1561d[i4]];
                            aVar2.f1648h = g.b.values()[bVar.f1562e[i4]];
                            int[] iArr2 = bVar.b;
                            int i6 = i5 + 1;
                            int i7 = iArr2[i5];
                            aVar2.c = i7;
                            int i8 = i6 + 1;
                            int i9 = iArr2[i6];
                            aVar2.f1644d = i9;
                            int i10 = i8 + 1;
                            int i11 = iArr2[i8];
                            aVar2.f1645e = i11;
                            int i12 = iArr2[i10];
                            aVar2.f1646f = i12;
                            aVar.b = i7;
                            aVar.c = i9;
                            aVar.f1635d = i11;
                            aVar.f1636e = i12;
                            aVar.b(aVar2);
                            i4++;
                            i3 = i10 + 1;
                        }
                        aVar.f1637f = bVar.f1563f;
                        aVar.f1640i = bVar.f1564g;
                        aVar.s = bVar.f1565h;
                        aVar.f1638g = true;
                        aVar.f1641j = bVar.f1566i;
                        aVar.f1642k = bVar.f1567j;
                        aVar.f1643l = bVar.f1568k;
                        aVar.m = bVar.f1569l;
                        aVar.n = bVar.m;
                        aVar.o = bVar.n;
                        aVar.p = bVar.o;
                        aVar.g(1);
                        if (Q(2)) {
                            String str7 = "restoreAllState: back stack #" + i2 + " (index " + aVar.s + "): " + aVar;
                            PrintWriter printWriter = new PrintWriter(new y0("FragmentManager"));
                            aVar.i("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1570d.add(aVar);
                        i2++;
                    }
                } else {
                    this.f1570d = null;
                }
                this.f1575i.set(f0Var.f1589e);
                String str8 = f0Var.f1590f;
                if (str8 != null) {
                    l H2 = H(str8);
                    this.t = H2;
                    u(H2);
                }
                ArrayList<String> arrayList2 = f0Var.f1591g;
                if (arrayList2 != null) {
                    for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                        this.f1576j.put(arrayList2.get(i13), f0Var.f1592h.get(i13));
                    }
                }
                this.z = new ArrayDeque<>(f0Var.f1593i);
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
            s0.p(this.q.c, this.r, arrayList, arrayList2, 0, 1, true, this.m);
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
                z0 z0Var = (z0) it.next();
                if (z0Var.f1695e) {
                    z0Var.f1695e = false;
                    z0Var.c();
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
        this.J.f1599h = true;
        k0 k0Var = this.c;
        Objects.requireNonNull(k0Var);
        ArrayList<i0> arrayList2 = new ArrayList<>(k0Var.b.size());
        for (j0 j0Var : k0Var.b.values()) {
            if (j0Var != null) {
                l lVar = j0Var.c;
                i0 i0Var = new i0(lVar);
                l lVar2 = j0Var.c;
                if (lVar2.b <= -1 || i0Var.n != null) {
                    i0Var.n = lVar2.c;
                } else {
                    Bundle n2 = j0Var.n();
                    i0Var.n = n2;
                    if (j0Var.c.f1622i != null) {
                        if (n2 == null) {
                            i0Var.n = new Bundle();
                        }
                        i0Var.n.putString("android:target_state", j0Var.c.f1622i);
                        int i2 = j0Var.c.f1623j;
                        if (i2 != 0) {
                            i0Var.n.putInt("android:target_req_state", i2);
                        }
                    }
                }
                arrayList2.add(i0Var);
                if (Q(2)) {
                    String str = "Saved state of " + lVar + ": " + i0Var.n;
                }
            }
        }
        b[] bVarArr = null;
        if (arrayList2.isEmpty()) {
            Q(2);
            return null;
        }
        k0 k0Var2 = this.c;
        synchronized (k0Var2.a) {
            if (k0Var2.a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(k0Var2.a.size());
                Iterator<l> it2 = k0Var2.a.iterator();
                while (it2.hasNext()) {
                    l next = it2.next();
                    arrayList.add(next.f1619f);
                    if (Q(2)) {
                        String str2 = "saveAllState: adding fragment (" + next.f1619f + "): " + next;
                    }
                }
            }
        }
        ArrayList<a> arrayList3 = this.f1570d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new b[size];
            for (int i3 = 0; i3 < size; i3++) {
                bVarArr[i3] = new b(this.f1570d.get(i3));
                if (Q(2)) {
                    String str3 = "saveAllState: adding back stack #" + i3 + ": " + this.f1570d.get(i3);
                }
            }
        }
        f0 f0Var = new f0();
        f0Var.b = arrayList2;
        f0Var.c = arrayList;
        f0Var.f1588d = bVarArr;
        f0Var.f1589e = this.f1575i.get();
        l lVar3 = this.t;
        if (lVar3 != null) {
            f0Var.f1590f = lVar3.f1619f;
        }
        f0Var.f1591g.addAll(this.f1576j.keySet());
        f0Var.f1592h.addAll(this.f1576j.values());
        f0Var.f1593i = new ArrayList<>(this.z);
        return f0Var;
    }

    public j0 i(l lVar) {
        j0 i2 = this.c.i(lVar.f1619f);
        if (i2 != null) {
            return i2;
        }
        j0 j0Var = new j0(this.n, this.c, lVar);
        j0Var.l(this.q.c.getClassLoader());
        j0Var.f1613e = this.p;
        return j0Var;
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
                this.q.f1692d.removeCallbacks(this.K);
                this.q.f1692d.post(this.K);
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
        if (L2 != null && (L2 instanceof w)) {
            ((w) L2).setDrawDisappearingViewsLast(!z2);
        }
    }

    public void k(l lVar) {
        if (Q(2)) {
            String str = "detach: " + lVar;
        }
        if (!lVar.A) {
            lVar.A = true;
            if (lVar.f1625l) {
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
        if (!lVar.equals(H(lVar.f1619f)) || !(lVar.t == null || lVar.s == this)) {
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
        if (lVar == null || (lVar.equals(H(lVar.f1619f)) && (lVar.t == null || lVar.s == this))) {
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
        this.J.f1599h = false;
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
        if (this.f1571e != null) {
            for (int i2 = 0; i2 < this.f1571e.size(); i2++) {
                l lVar2 = this.f1571e.get(i2);
                if (arrayList == null || !arrayList.contains(lVar2)) {
                    Objects.requireNonNull(lVar2);
                }
            }
        }
        this.f1571e = arrayList;
        return z2;
    }

    public final void o0() {
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            j0 j0Var = (j0) it.next();
            l lVar = j0Var.c;
            if (lVar.G) {
                if (this.b) {
                    this.E = true;
                } else {
                    lVar.G = false;
                    if (L) {
                        j0Var.j();
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
        if (this.f1573g != null) {
            this.f1574h.b();
            this.f1573g = null;
        }
        e.a.e.c<Intent> cVar = this.w;
        if (cVar != null) {
            cVar.a();
            this.x.a();
            this.y.a();
        }
    }

    public final void p0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new y0("FragmentManager"));
        z<?> zVar = this.q;
        if (zVar != null) {
            try {
                zVar.i("  ", null, printWriter, new String[0]);
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
        r0 = r4.f1574h;
        r1 = r4.f1570d;
     */
    public final void q0() {
        synchronized (this.a) {
            boolean z2 = true;
            if (!this.a.isEmpty()) {
                this.f1574h.a = true;
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
            z<?> zVar = this.q;
            if (zVar != null) {
                sb.append(zVar.getClass().getSimpleName());
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
        if (lVar != null && lVar.equals(H(lVar.f1619f))) {
            boolean T = lVar.s.T(lVar);
            Boolean bool = lVar.f1624k;
            if (bool == null || bool.booleanValue() != T) {
                lVar.f1624k = Boolean.valueOf(T);
                lVar.a0(T);
                c0 c0Var = lVar.u;
                c0Var.q0();
                c0Var.u(c0Var.t);
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
            for (j0 j0Var : this.c.b.values()) {
                if (j0Var != null) {
                    j0Var.f1613e = i2;
                }
            }
            W(i2, false);
            if (L) {
                Iterator it = ((HashSet) g()).iterator();
                while (it.hasNext()) {
                    ((z0) it.next()).d();
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
        k0 k0Var = this.c;
        Objects.requireNonNull(k0Var);
        String str3 = str + "    ";
        if (!k0Var.b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (j0 j0Var : k0Var.b.values()) {
                printWriter.print(str);
                if (j0Var != null) {
                    l lVar = j0Var.c;
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
                    printWriter.print(lVar.f1619f);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(lVar.r);
                    printWriter.print(str3);
                    printWriter.print("mAdded=");
                    printWriter.print(lVar.f1625l);
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
                    if (lVar.f1620g != null) {
                        printWriter.print(str3);
                        printWriter.print("mArguments=");
                        printWriter.println(lVar.f1620g);
                    }
                    if (lVar.c != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(lVar.c);
                    }
                    if (lVar.f1617d != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(lVar.f1617d);
                    }
                    if (lVar.f1618e != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(lVar.f1618e);
                    }
                    Object obj = lVar.f1621h;
                    if (obj == null) {
                        c0 c0Var = lVar.s;
                        obj = (c0Var == null || (str2 = lVar.f1622i) == null) ? null : c0Var.c.d(str2);
                    }
                    if (obj != null) {
                        printWriter.print(str3);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(lVar.f1623j);
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
                    if (lVar.i() != null) {
                        printWriter.print(str3);
                        printWriter.print("mAnimatingAway=");
                        printWriter.println(lVar.i());
                    }
                    if (lVar.l() != null) {
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
        int size3 = k0Var.a.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(k0Var.a.get(i2).toString());
            }
        }
        ArrayList<l> arrayList = this.f1571e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f1571e.get(i3).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f1570d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1570d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.i(t2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1575i.get());
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
