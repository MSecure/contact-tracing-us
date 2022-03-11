package e.o.a;

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
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.R$id;
import e.b.a.m;
import e.o.a.h0;
import e.o.a.m;
import e.o.a.m0;
import e.o.a.t0;
import e.r.f0;
import e.r.g0;
import e.r.h;
import e.r.h0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class e0 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public ArrayList<a> F;
    public ArrayList<Boolean> G;
    public ArrayList<m> H;
    public ArrayList<n> I;
    public h0 J;
    public boolean b;

    /* renamed from: d */
    public ArrayList<a> f1773d;

    /* renamed from: e */
    public ArrayList<m> f1774e;

    /* renamed from: g */
    public OnBackPressedDispatcher f1776g;
    public b0<?> q;
    public x r;
    public m s;
    public m t;
    public e.a.e.c<Intent> w;
    public e.a.e.c<e.a.e.e> x;
    public e.a.e.c<String[]> y;
    public final ArrayList<l> a = new ArrayList<>();
    public final l0 c = new l0();

    /* renamed from: f */
    public final c0 f1775f = new c0(this);

    /* renamed from: h */
    public final e.a.b f1777h = new c(false);

    /* renamed from: i */
    public final AtomicInteger f1778i = new AtomicInteger();

    /* renamed from: j */
    public final Map<String, Bundle> f1779j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k */
    public final Map<String, Object> f1780k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l */
    public Map<m, HashSet<e.j.f.a>> f1781l = Collections.synchronizedMap(new HashMap());
    public final t0.a m = new d();
    public final d0 n = new d0(this);
    public final CopyOnWriteArrayList<i0> o = new CopyOnWriteArrayList<>();
    public int p = -1;
    public a0 u = new e();
    public b1 v = new f(this);
    public ArrayDeque<k> z = new ArrayDeque<>();
    public Runnable K = new g();

    /* loaded from: classes.dex */
    public class a implements e.a.e.b<e.a.e.a> {
        public a() {
            e0.this = r1;
        }

        @Override // e.a.e.b
        public void a(e.a.e.a aVar) {
            e.a.e.a aVar2 = aVar;
            k pollFirst = e0.this.z.pollFirst();
            if (pollFirst == null) {
                String str = "No IntentSenders were started for " + this;
                return;
            }
            String str2 = pollFirst.b;
            int i2 = pollFirst.c;
            m e2 = e0.this.c.e(str2);
            if (e2 != null) {
                e2.N(i2, aVar2.b, aVar2.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e.a.e.b<Map<String, Boolean>> {
        public b() {
            e0.this = r1;
        }

        @Override // e.a.e.b
        public void a(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            k pollFirst = e0.this.z.pollFirst();
            if (pollFirst == null) {
                String str = "No permissions were requested for " + this;
                return;
            }
            m e2 = e0.this.c.e(pollFirst.b);
            if (e2 != null) {
                e2.h0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends e.a.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z) {
            super(z);
            e0.this = r1;
        }

        @Override // e.a.b
        public void a() {
            e0 e0Var = e0.this;
            e0Var.C(true);
            if (e0Var.f1777h.a) {
                e0Var.Z();
            } else {
                e0Var.f1776g.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements t0.a {
        public d() {
            e0.this = r1;
        }

        public void a(m mVar, e.j.f.a aVar) {
            boolean z;
            synchronized (aVar) {
                z = aVar.a;
            }
            if (!z) {
                e0 e0Var = e0.this;
                HashSet<e.j.f.a> hashSet = e0Var.f1781l.get(mVar);
                if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
                    e0Var.f1781l.remove(mVar);
                    if (mVar.b < 5) {
                        e0Var.i(mVar);
                        e0Var.V(mVar, e0Var.p);
                    }
                }
            }
        }

        public void b(m mVar, e.j.f.a aVar) {
            e0 e0Var = e0.this;
            if (e0Var.f1781l.get(mVar) == null) {
                e0Var.f1781l.put(mVar, new HashSet<>());
            }
            e0Var.f1781l.get(mVar).add(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class e extends a0 {
        public e() {
            e0.this = r1;
        }

        @Override // e.o.a.a0
        public m a(ClassLoader classLoader, String str) {
            b0<?> b0Var = e0.this.q;
            Context context = b0Var.c;
            Objects.requireNonNull(b0Var);
            Object obj = m.V;
            try {
                return (m) a0.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new m.e(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
            } catch (InstantiationException e3) {
                throw new m.e(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
            } catch (NoSuchMethodException e4) {
                throw new m.e(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
            } catch (InvocationTargetException e5) {
                throw new m.e(f.a.a.a.a.c("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b1 {
        public f(e0 e0Var) {
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
            e0.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.C(true);
        }
    }

    /* loaded from: classes.dex */
    public class h implements i0 {
        public final /* synthetic */ m b;

        public h(e0 e0Var, m mVar) {
            this.b = mVar;
        }

        @Override // e.o.a.i0
        public void b(e0 e0Var, m mVar) {
            this.b.Q();
        }
    }

    /* loaded from: classes.dex */
    public class i implements e.a.e.b<e.a.e.a> {
        public i() {
            e0.this = r1;
        }

        @Override // e.a.e.b
        public void a(e.a.e.a aVar) {
            e.a.e.a aVar2 = aVar;
            k pollFirst = e0.this.z.pollFirst();
            if (pollFirst == null) {
                String str = "No Activities were started for result for " + this;
                return;
            }
            String str2 = pollFirst.b;
            int i2 = pollFirst.c;
            m e2 = e0.this.c.e(str2);
            if (e2 != null) {
                e2.N(i2, aVar2.b, aVar2.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j extends e.a.e.f.a<e.a.e.e, e.a.e.a> {
        @Override // e.a.e.f.a
        public Intent a(Context context, Object obj) {
            Bundle bundleExtra;
            e.a.e.e eVar = (e.a.e.e) obj;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = eVar.c;
            if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    eVar = new e.a.e.e(eVar.b, null, eVar.f652d, eVar.f653e);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar);
            if (e0.P(2)) {
                String str = "CreateIntent created the following intent: " + intent;
            }
            return intent;
        }

        public Object c(int i2, Intent intent) {
            return new e.a.e.a(i2, intent);
        }
    }

    /* loaded from: classes.dex */
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();
        public String b;
        public int c;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<k> {
            @Override // android.os.Parcelable.Creator
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public k[] newArray(int i2) {
                return new k[i2];
            }
        }

        public k(Parcel parcel) {
            this.b = parcel.readString();
            this.c = parcel.readInt();
        }

        public k(String str, int i2) {
            this.b = str;
            this.c = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.b);
            parcel.writeInt(this.c);
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    public class m implements l {
        public final String a;
        public final int b;
        public final int c;

        public m(String str, int i2, int i3) {
            e0.this = r1;
            this.a = str;
            this.b = i2;
            this.c = i3;
        }

        @Override // e.o.a.e0.l
        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            m mVar = e0.this.t;
            if (mVar == null || this.b >= 0 || this.a != null || !mVar.j().Z()) {
                return e0.this.a0(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class n implements m.g {
        public final boolean a;
        public final a b;
        public int c;

        public void a() {
            boolean z = this.c > 0;
            for (m mVar : this.b.q.c.i()) {
                mVar.D0(null);
                if (z && mVar.K()) {
                    mVar.G0();
                }
            }
            a aVar = this.b;
            aVar.q.g(aVar, this.a, !z, true);
        }
    }

    public static boolean P(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public void A(l lVar, boolean z) {
        if (!z) {
            if (this.q == null) {
                if (this.D) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (T()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            if (this.q != null) {
                this.a.add(lVar);
                g0();
            } else if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void B(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.q == null) {
            if (this.D) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.q.f1764d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z || !T()) {
            if (this.F == null) {
                this.F = new ArrayList<>();
                this.G = new ArrayList<>();
            }
            this.b = true;
            try {
                F(null, null);
            } finally {
                this.b = false;
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX WARN: Finally extract failed */
    public boolean C(boolean z) {
        boolean z2;
        B(z);
        boolean z3 = false;
        while (true) {
            ArrayList<a> arrayList = this.F;
            ArrayList<Boolean> arrayList2 = this.G;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    z2 = false;
                } else {
                    int size = this.a.size();
                    z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z2 |= this.a.get(i2).a(arrayList, arrayList2);
                    }
                    this.a.clear();
                    this.q.f1764d.removeCallbacks(this.K);
                }
            }
            if (z2) {
                this.b = true;
                try {
                    d0(this.F, this.G);
                    e();
                    z3 = true;
                } catch (Throwable th) {
                    e();
                    throw th;
                }
            } else {
                o0();
                x();
                this.c.b();
                return z3;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public void D(l lVar, boolean z) {
        if (!z || (this.q != null && !this.D)) {
            B(z);
            ((a) lVar).a(this.F, this.G);
            this.b = true;
            try {
                d0(this.F, this.G);
                e();
                o0();
                x();
                this.c.b();
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
    }

    public final void E(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        int i4;
        int i5;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z = arrayList.get(i2).p;
        ArrayList<m> arrayList4 = this.H;
        if (arrayList4 == null) {
            this.H = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.H.addAll(this.c.i());
        m mVar = this.t;
        int i6 = i2;
        boolean z2 = false;
        while (true) {
            int i7 = 1;
            if (i6 < i3) {
                a aVar = arrayList.get(i6);
                int i8 = 3;
                if (!arrayList3.get(i6).booleanValue()) {
                    ArrayList<m> arrayList5 = this.H;
                    int i9 = 0;
                    while (i9 < aVar.a.size()) {
                        m0.a aVar2 = aVar.a.get(i9);
                        int i10 = aVar2.a;
                        if (i10 != i7) {
                            if (i10 != 2) {
                                if (i10 == i8 || i10 == 6) {
                                    arrayList5.remove(aVar2.b);
                                    m mVar2 = aVar2.b;
                                    if (mVar2 == mVar) {
                                        aVar.a.add(i9, new m0.a(9, mVar2));
                                        i9++;
                                        i4 = 1;
                                        mVar = null;
                                        i9 += i4;
                                        i7 = 1;
                                        i8 = 3;
                                    }
                                } else if (i10 != 7) {
                                    if (i10 == 8) {
                                        aVar.a.add(i9, new m0.a(9, mVar));
                                        i9++;
                                        mVar = aVar2.b;
                                    }
                                }
                                i4 = 1;
                                i9 += i4;
                                i7 = 1;
                                i8 = 3;
                            } else {
                                m mVar3 = aVar2.b;
                                int i11 = mVar3.x;
                                int size = arrayList5.size() - 1;
                                boolean z3 = false;
                                while (size >= 0) {
                                    m mVar4 = arrayList5.get(size);
                                    if (mVar4.x != i11) {
                                        i5 = i11;
                                    } else if (mVar4 == mVar3) {
                                        i5 = i11;
                                        z3 = true;
                                    } else {
                                        if (mVar4 == mVar) {
                                            i5 = i11;
                                            aVar.a.add(i9, new m0.a(9, mVar4));
                                            i9++;
                                            mVar = null;
                                        } else {
                                            i5 = i11;
                                        }
                                        m0.a aVar3 = new m0.a(3, mVar4);
                                        aVar3.c = aVar2.c;
                                        aVar3.f1837e = aVar2.f1837e;
                                        aVar3.f1836d = aVar2.f1836d;
                                        aVar3.f1838f = aVar2.f1838f;
                                        aVar.a.add(i9, aVar3);
                                        arrayList5.remove(mVar4);
                                        i9++;
                                    }
                                    size--;
                                    i11 = i5;
                                }
                                if (z3) {
                                    aVar.a.remove(i9);
                                    i9--;
                                    i4 = 1;
                                    i9 += i4;
                                    i7 = 1;
                                    i8 = 3;
                                } else {
                                    i4 = 1;
                                    aVar2.a = 1;
                                    arrayList5.add(mVar3);
                                    i9 += i4;
                                    i7 = 1;
                                    i8 = 3;
                                }
                            }
                        }
                        i4 = 1;
                        arrayList5.add(aVar2.b);
                        i9 += i4;
                        i7 = 1;
                        i8 = 3;
                    }
                } else {
                    int i12 = 1;
                    ArrayList<m> arrayList6 = this.H;
                    int size2 = aVar.a.size() - 1;
                    while (size2 >= 0) {
                        m0.a aVar4 = aVar.a.get(size2);
                        int i13 = aVar4.a;
                        if (i13 != i12) {
                            if (i13 != 3) {
                                switch (i13) {
                                    case 8:
                                        mVar = null;
                                        break;
                                    case 9:
                                        mVar = aVar4.b;
                                        break;
                                    case 10:
                                        aVar4.f1840h = aVar4.f1839g;
                                        break;
                                }
                                size2--;
                                i12 = 1;
                            }
                            arrayList6.add(aVar4.b);
                            size2--;
                            i12 = 1;
                        }
                        arrayList6.remove(aVar4.b);
                        size2--;
                        i12 = 1;
                    }
                }
                z2 = z2 || aVar.f1830g;
                i6++;
                arrayList3 = arrayList2;
            } else {
                this.H.clear();
                if (!z && this.p >= 1) {
                    for (int i14 = i2; i14 < i3; i14++) {
                        Iterator<m0.a> it = arrayList.get(i14).a.iterator();
                        while (it.hasNext()) {
                            m mVar5 = it.next().b;
                            if (!(mVar5 == null || mVar5.s == null)) {
                                this.c.j(h(mVar5));
                            }
                        }
                    }
                }
                int i15 = i2;
                while (i15 < i3) {
                    a aVar5 = arrayList.get(i15);
                    if (arrayList2.get(i15).booleanValue()) {
                        aVar5.h(-1);
                        aVar5.l(i15 == i3 + -1);
                    } else {
                        aVar5.h(1);
                        aVar5.k();
                    }
                    i15++;
                }
                boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
                for (int i16 = i2; i16 < i3; i16++) {
                    a aVar6 = arrayList.get(i16);
                    if (booleanValue) {
                        for (int size3 = aVar6.a.size() - 1; size3 >= 0; size3--) {
                            m mVar6 = aVar6.a.get(size3).b;
                            if (mVar6 != null) {
                                h(mVar6).k();
                            }
                        }
                    } else {
                        Iterator<m0.a> it2 = aVar6.a.iterator();
                        while (it2.hasNext()) {
                            m mVar7 = it2.next().b;
                            if (mVar7 != null) {
                                h(mVar7).k();
                            }
                        }
                    }
                }
                U(this.p, true);
                HashSet hashSet = new HashSet();
                for (int i17 = i2; i17 < i3; i17++) {
                    Iterator<m0.a> it3 = arrayList.get(i17).a.iterator();
                    while (it3.hasNext()) {
                        m mVar8 = it3.next().b;
                        if (!(mVar8 == null || (viewGroup = mVar8.E) == null)) {
                            hashSet.add(a1.g(viewGroup, N()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    a1 a1Var = (a1) it4.next();
                    a1Var.f1743d = booleanValue;
                    a1Var.h();
                    a1Var.c();
                }
                for (int i18 = i2; i18 < i3; i18++) {
                    a aVar7 = arrayList.get(i18);
                    if (arrayList2.get(i18).booleanValue() && aVar7.s >= 0) {
                        aVar7.s = -1;
                    }
                    Objects.requireNonNull(aVar7);
                }
                return;
            }
        }
    }

    public final void F(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<n> arrayList3 = this.I;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            n nVar = this.I.get(i2);
            if (arrayList == null || nVar.a || (indexOf2 = arrayList.indexOf(nVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((nVar.c == 0) || (arrayList != null && nVar.b.n(arrayList, 0, arrayList.size()))) {
                    this.I.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || nVar.a || (indexOf = arrayList.indexOf(nVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        nVar.a();
                    }
                }
                i2++;
            } else {
                this.I.remove(i2);
                i2--;
                size--;
            }
            a aVar = nVar.b;
            aVar.q.g(aVar, nVar.a, false, false);
            i2++;
        }
    }

    public m G(String str) {
        return this.c.d(str);
    }

    public m H(int i2) {
        l0 l0Var = this.c;
        int size = l0Var.a.size();
        while (true) {
            size--;
            if (size >= 0) {
                m mVar = l0Var.a.get(size);
                if (mVar != null && mVar.w == i2) {
                    return mVar;
                }
            } else {
                for (k0 k0Var : l0Var.b.values()) {
                    if (k0Var != null) {
                        m mVar2 = k0Var.c;
                        if (mVar2.w == i2) {
                            return mVar2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public m I(String str) {
        l0 l0Var = this.c;
        Objects.requireNonNull(l0Var);
        if (str != null) {
            int size = l0Var.a.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                m mVar = l0Var.a.get(size);
                if (mVar != null && str.equals(mVar.y)) {
                    return mVar;
                }
            }
        }
        if (str != null) {
            for (k0 k0Var : l0Var.b.values()) {
                if (k0Var != null) {
                    m mVar2 = k0Var.c;
                    if (str.equals(mVar2.y)) {
                        return mVar2;
                    }
                }
            }
        }
        return null;
    }

    public final void J() {
        Iterator it = ((HashSet) f()).iterator();
        while (it.hasNext()) {
            a1 a1Var = (a1) it.next();
            if (a1Var.f1744e) {
                a1Var.f1744e = false;
                a1Var.c();
            }
        }
    }

    public m K(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        m d2 = this.c.d(string);
        if (d2 != null) {
            return d2;
        }
        n0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public final ViewGroup L(m mVar) {
        ViewGroup viewGroup = mVar.E;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (mVar.x > 0 && this.r.g()) {
            View e2 = this.r.e(mVar.x);
            if (e2 instanceof ViewGroup) {
                return (ViewGroup) e2;
            }
        }
        return null;
    }

    public a0 M() {
        m mVar = this.s;
        return mVar != null ? mVar.s.M() : this.u;
    }

    public b1 N() {
        m mVar = this.s;
        return mVar != null ? mVar.s.N() : this.v;
    }

    public void O(m mVar) {
        if (P(2)) {
            String str = "hide: " + mVar;
        }
        if (!mVar.z) {
            mVar.z = true;
            mVar.J = true ^ mVar.J;
            k0(mVar);
        }
    }

    public final boolean Q(m mVar) {
        e0 e0Var = mVar.u;
        Iterator it = ((ArrayList) e0Var.c.g()).iterator();
        boolean z = false;
        while (it.hasNext()) {
            m mVar2 = (m) it.next();
            if (mVar2 != null) {
                z = e0Var.Q(mVar2);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public boolean R(m mVar) {
        e0 e0Var;
        if (mVar == null) {
            return true;
        }
        return mVar.C && ((e0Var = mVar.s) == null || e0Var.R(mVar.v));
    }

    public boolean S(m mVar) {
        if (mVar == null) {
            return true;
        }
        e0 e0Var = mVar.s;
        if (!mVar.equals(e0Var.t) || !S(e0Var.s)) {
            return false;
        }
        return true;
    }

    public boolean T() {
        return this.B || this.C;
    }

    public void U(int i2, boolean z) {
        b0<?> b0Var;
        if (this.q == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z || i2 != this.p) {
            this.p = i2;
            l0 l0Var = this.c;
            Iterator<m> it = l0Var.a.iterator();
            while (it.hasNext()) {
                k0 k0Var = l0Var.b.get(it.next().f1811f);
                if (k0Var != null) {
                    k0Var.k();
                }
            }
            Iterator<k0> it2 = l0Var.b.values().iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                k0 next = it2.next();
                if (next != null) {
                    next.k();
                    m mVar = next.c;
                    if (mVar.m && !mVar.J()) {
                        z2 = true;
                    }
                    if (z2) {
                        l0Var.k(next);
                    }
                }
            }
            m0();
            if (this.A && (b0Var = this.q) != null && this.p == 7) {
                b0Var.m();
                this.A = false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (r2 != 5) goto L_0x01a1;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019d  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void V(m mVar, int i2) {
        ViewGroup viewGroup;
        k0 h2 = this.c.h(mVar.f1811f);
        int i3 = 1;
        if (h2 == null) {
            h2 = new k0(this.n, this.c, mVar);
            h2.f1808e = 1;
        }
        if (mVar.n && mVar.o && mVar.b == 2) {
            i2 = Math.max(i2, 2);
        }
        int min = Math.min(i2, h2.d());
        int i4 = mVar.b;
        if (i4 <= min) {
            if (i4 < min && !this.f1781l.isEmpty()) {
                d(mVar);
            }
            int i5 = mVar.b;
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
                                String str = "movefrom ACTIVITY_CREATED: " + mVar;
                            }
                            if (mVar.F != null && this.q.l(mVar) && mVar.f1809d == null) {
                                h2.o();
                            }
                        }
                    }
                    if (min < 2) {
                        v vVar = null;
                        View view = mVar.F;
                        if (!(view == null || (viewGroup = mVar.E) == null)) {
                            viewGroup.endViewTransition(view);
                            mVar.F.clearAnimation();
                            if (!mVar.L()) {
                                if (this.p > -1 && !this.D && mVar.F.getVisibility() == 0 && mVar.K >= 0.0f) {
                                    vVar = m.e.V0(this.q.c, mVar, false, mVar.x());
                                }
                                mVar.K = 0.0f;
                                ViewGroup viewGroup2 = mVar.E;
                                View view2 = mVar.F;
                                if (vVar != null) {
                                    t0.a aVar = this.m;
                                    viewGroup2.startViewTransition(view2);
                                    e.j.f.a aVar2 = new e.j.f.a();
                                    aVar2.b(new s(mVar));
                                    d dVar = (d) aVar;
                                    dVar.b(mVar, aVar2);
                                    if (vVar.a != null) {
                                        w wVar = new w(vVar.a, viewGroup2, view2);
                                        mVar.x0(mVar.F);
                                        wVar.setAnimationListener(new t(viewGroup2, mVar, dVar, aVar2));
                                        mVar.F.startAnimation(wVar);
                                    } else {
                                        Animator animator = vVar.b;
                                        mVar.z0(animator);
                                        animator.addListener(new u(viewGroup2, view2, mVar, dVar, aVar2));
                                        animator.setTarget(mVar.F);
                                        animator.start();
                                    }
                                }
                                viewGroup2.removeView(view2);
                                if (P(2)) {
                                    String str2 = "Removing view " + view2 + " for fragment " + mVar + " from container " + viewGroup2;
                                }
                                if (viewGroup2 != mVar.E) {
                                    return;
                                }
                            }
                        }
                        if (this.f1781l.get(mVar) == null) {
                            h2.h();
                        }
                    }
                }
                if (min < 1) {
                    if (this.f1781l.get(mVar) == null) {
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
        if (mVar.b != min) {
            if (P(3)) {
                String str3 = "moveToState: Fragment state for " + mVar + " not updated inline; expected state " + min + " found " + mVar.b;
            }
            mVar.b = min;
        }
    }

    public void W() {
        if (this.q != null) {
            this.B = false;
            this.C = false;
            this.J.f1796h = false;
            for (m mVar : this.c.i()) {
                if (mVar != null) {
                    mVar.u.W();
                }
            }
        }
    }

    public void X() {
        A(new m(null, -1, 0), false);
    }

    public void Y(String str, int i2) {
        A(new m(str, -1, i2), false);
    }

    public boolean Z() {
        C(false);
        B(true);
        m mVar = this.t;
        if (mVar != null && mVar.j().Z()) {
            return true;
        }
        boolean a0 = a0(this.F, this.G, null, -1, 0);
        if (a0) {
            this.b = true;
            try {
                d0(this.F, this.G);
            } finally {
                e();
            }
        }
        o0();
        x();
        this.c.b();
        return a0;
    }

    public k0 a(m mVar) {
        if (P(2)) {
            String str = "add: " + mVar;
        }
        k0 h2 = h(mVar);
        mVar.s = this;
        this.c.j(h2);
        if (!mVar.A) {
            this.c.a(mVar);
            mVar.m = false;
            if (mVar.F == null) {
                mVar.J = false;
            }
            if (Q(mVar)) {
                this.A = true;
            }
        }
        return h2;
    }

    public boolean a0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<a> arrayList3 = this.f1773d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1773d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f1773d.get(size2);
                    if ((str != null && str.equals(aVar.f1832i)) || (i2 >= 0 && i2 == aVar.s)) {
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
                        a aVar2 = this.f1773d.get(size2);
                        if (str == null || !str.equals(aVar2.f1832i)) {
                            if (i2 < 0 || i2 != aVar2.s) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f1773d.size() - 1) {
                return false;
            }
            for (int size3 = this.f1773d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1773d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void b(b0<?> b0Var, x xVar, m mVar) {
        b0<?> b0Var2;
        i0 i0Var;
        if (this.q == null) {
            this.q = b0Var;
            this.r = xVar;
            this.s = mVar;
            if (mVar != null) {
                i0Var = new h(this, mVar);
            } else {
                if (b0Var instanceof i0) {
                    i0Var = (i0) b0Var;
                }
                if (this.s != null) {
                    o0();
                }
                if (b0Var instanceof e.a.c) {
                    e.a.c cVar = (e.a.c) b0Var;
                    OnBackPressedDispatcher c2 = cVar.c();
                    this.f1776g = c2;
                    e.r.l lVar = cVar;
                    if (mVar != null) {
                        lVar = mVar;
                    }
                    c2.a(lVar, this.f1777h);
                }
                if (mVar == null) {
                    h0 h0Var = mVar.s.J;
                    h0 h0Var2 = h0Var.f1792d.get(mVar.f1811f);
                    if (h0Var2 == null) {
                        h0Var2 = new h0(h0Var.f1794f);
                        h0Var.f1792d.put(mVar.f1811f, h0Var2);
                    }
                    this.J = h0Var2;
                } else if (b0Var instanceof h0) {
                    g0 i2 = ((h0) b0Var).i();
                    f0.b bVar = h0.f1791i;
                    String canonicalName = h0.class.getCanonicalName();
                    if (canonicalName != null) {
                        String x = f.a.a.a.a.x("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                        e.r.e0 e0Var = i2.a.get(x);
                        if (!h0.class.isInstance(e0Var)) {
                            e0Var = bVar instanceof f0.c ? ((f0.c) bVar).c(x, h0.class) : ((h0.a) bVar).a(h0.class);
                            e.r.e0 put = i2.a.put(x, e0Var);
                            if (put != null) {
                                put.a();
                            }
                        } else if (bVar instanceof f0.e) {
                            ((f0.e) bVar).b(e0Var);
                        }
                        this.J = (h0) e0Var;
                    } else {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                } else {
                    this.J = new h0(false);
                }
                this.J.f1796h = T();
                this.c.c = this.J;
                b0Var2 = this.q;
                if (!(b0Var2 instanceof e.a.e.d)) {
                    ActivityResultRegistry f2 = ((e.a.e.d) b0Var2).f();
                    String x2 = f.a.a.a.a.x("FragmentManager:", mVar != null ? f.a.a.a.a.e(new StringBuilder(), mVar.f1811f, ":") : "");
                    this.w = f2.c(f.a.a.a.a.x(x2, "StartActivityForResult"), new e.a.e.f.c(), new i());
                    this.x = f2.c(f.a.a.a.a.x(x2, "StartIntentSenderForResult"), new j(), new a());
                    this.y = f2.c(f.a.a.a.a.x(x2, "RequestPermissions"), new e.a.e.f.b(), new b());
                    return;
                }
                return;
            }
            this.o.add(i0Var);
            if (this.s != null) {
            }
            if (b0Var instanceof e.a.c) {
            }
            if (mVar == null) {
            }
            this.J.f1796h = T();
            this.c.c = this.J;
            b0Var2 = this.q;
            if (!(b0Var2 instanceof e.a.e.d)) {
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void b0(Bundle bundle, String str, m mVar) {
        if (mVar.s == this) {
            bundle.putString(str, mVar.f1811f);
        } else {
            n0(new IllegalStateException(f.a.a.a.a.w("Fragment ", mVar, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public void c(m mVar) {
        if (P(2)) {
            String str = "attach: " + mVar;
        }
        if (mVar.A) {
            mVar.A = false;
            if (!mVar.f1817l) {
                this.c.a(mVar);
                if (P(2)) {
                    String str2 = "add from attach: " + mVar;
                }
                if (Q(mVar)) {
                    this.A = true;
                }
            }
        }
    }

    public void c0(m mVar) {
        if (P(2)) {
            String str = "remove: " + mVar + " nesting=" + mVar.r;
        }
        boolean z = !mVar.J();
        if (!mVar.A || z) {
            this.c.l(mVar);
            if (Q(mVar)) {
                this.A = true;
            }
            mVar.m = true;
            k0(mVar);
        }
    }

    public final void d(m mVar) {
        HashSet<e.j.f.a> hashSet = this.f1781l.get(mVar);
        if (hashSet != null) {
            Iterator<e.j.f.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            i(mVar);
            this.f1781l.remove(mVar);
        }
    }

    public final void d0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                F(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).p) {
                        if (i3 != i2) {
                            E(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).p) {
                                i3++;
                            }
                        }
                        E(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    E(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public final void e() {
        this.b = false;
        this.G.clear();
        this.F.clear();
    }

    public void e0(Parcelable parcelable) {
        k0 k0Var;
        if (parcelable != null) {
            g0 g0Var = (g0) parcelable;
            if (g0Var.b != null) {
                this.c.b.clear();
                Iterator<j0> it = g0Var.b.iterator();
                while (it.hasNext()) {
                    j0 next = it.next();
                    if (next != null) {
                        m mVar = this.J.c.get(next.c);
                        if (mVar != null) {
                            if (P(2)) {
                                String str = "restoreSaveState: re-attaching retained " + mVar;
                            }
                            k0Var = new k0(this.n, this.c, mVar, next);
                        } else {
                            k0Var = new k0(this.n, this.c, this.q.c.getClassLoader(), M(), next);
                        }
                        m mVar2 = k0Var.c;
                        mVar2.s = this;
                        if (P(2)) {
                            StringBuilder h2 = f.a.a.a.a.h("restoreSaveState: active (");
                            h2.append(mVar2.f1811f);
                            h2.append("): ");
                            h2.append(mVar2);
                            h2.toString();
                        }
                        k0Var.m(this.q.c.getClassLoader());
                        this.c.j(k0Var);
                        k0Var.f1808e = this.p;
                    }
                }
                h0 h0Var = this.J;
                Objects.requireNonNull(h0Var);
                Iterator it2 = new ArrayList(h0Var.c.values()).iterator();
                while (it2.hasNext()) {
                    m mVar3 = (m) it2.next();
                    if (!this.c.c(mVar3.f1811f)) {
                        if (P(2)) {
                            String str2 = "Discarding retained Fragment " + mVar3 + " that was not found in the set of active Fragments " + g0Var.b;
                        }
                        this.J.c(mVar3);
                        mVar3.s = this;
                        k0 k0Var2 = new k0(this.n, this.c, mVar3);
                        k0Var2.f1808e = 1;
                        k0Var2.k();
                        mVar3.m = true;
                        k0Var2.k();
                    }
                }
                l0 l0Var = this.c;
                ArrayList<String> arrayList = g0Var.c;
                l0Var.a.clear();
                if (arrayList != null) {
                    for (String str3 : arrayList) {
                        m d2 = l0Var.d(str3);
                        if (d2 != null) {
                            if (P(2)) {
                                String str4 = "restoreSaveState: added (" + str3 + "): " + d2;
                            }
                            l0Var.a(d2);
                        } else {
                            throw new IllegalStateException(f.a.a.a.a.c("No instantiated fragment for (", str3, ")"));
                        }
                    }
                }
                if (g0Var.f1783d != null) {
                    this.f1773d = new ArrayList<>(g0Var.f1783d.length);
                    int i2 = 0;
                    while (true) {
                        b[] bVarArr = g0Var.f1783d;
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
                            m0.a aVar2 = new m0.a();
                            int i5 = i3 + 1;
                            aVar2.a = iArr[i3];
                            if (P(2)) {
                                String str5 = "Instantiate " + aVar + " op #" + i4 + " base fragment #" + bVar.b[i5];
                            }
                            String str6 = bVar.c.get(i4);
                            aVar2.b = str6 != null ? this.c.d(str6) : null;
                            aVar2.f1839g = h.b.values()[bVar.f1755d[i4]];
                            aVar2.f1840h = h.b.values()[bVar.f1756e[i4]];
                            int[] iArr2 = bVar.b;
                            int i6 = i5 + 1;
                            int i7 = iArr2[i5];
                            aVar2.c = i7;
                            int i8 = i6 + 1;
                            int i9 = iArr2[i6];
                            aVar2.f1836d = i9;
                            int i10 = i8 + 1;
                            int i11 = iArr2[i8];
                            aVar2.f1837e = i11;
                            i3 = i10 + 1;
                            int i12 = iArr2[i10];
                            aVar2.f1838f = i12;
                            aVar.b = i7;
                            aVar.c = i9;
                            aVar.f1827d = i11;
                            aVar.f1828e = i12;
                            aVar.b(aVar2);
                            i4++;
                        }
                        aVar.f1829f = bVar.f1757f;
                        aVar.f1832i = bVar.f1758g;
                        aVar.s = bVar.f1759h;
                        aVar.f1830g = true;
                        aVar.f1833j = bVar.f1760i;
                        aVar.f1834k = bVar.f1761j;
                        aVar.f1835l = bVar.f1762k;
                        aVar.m = bVar.f1763l;
                        aVar.n = bVar.m;
                        aVar.o = bVar.n;
                        aVar.p = bVar.o;
                        aVar.h(1);
                        if (P(2)) {
                            String str7 = "restoreAllState: back stack #" + i2 + " (index " + aVar.s + "): " + aVar;
                            PrintWriter printWriter = new PrintWriter(new z0("FragmentManager"));
                            aVar.j("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1773d.add(aVar);
                        i2++;
                    }
                } else {
                    this.f1773d = null;
                }
                this.f1778i.set(g0Var.f1784e);
                String str8 = g0Var.f1785f;
                if (str8 != null) {
                    m G = G(str8);
                    this.t = G;
                    t(G);
                }
                ArrayList<String> arrayList2 = g0Var.f1786g;
                if (arrayList2 != null) {
                    for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                        Bundle bundle = g0Var.f1787h.get(i13);
                        bundle.setClassLoader(this.q.c.getClassLoader());
                        this.f1779j.put(arrayList2.get(i13), bundle);
                    }
                }
                this.z = new ArrayDeque<>(g0Var.f1788i);
            }
        }
    }

    public final Set<a1> f() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((k0) it.next()).c.E;
            if (viewGroup != null) {
                hashSet.add(a1.g(viewGroup, N()));
            }
        }
        return hashSet;
    }

    public Parcelable f0() {
        int i2;
        b[] bVarArr;
        ArrayList<String> arrayList;
        int size;
        J();
        z();
        C(true);
        this.B = true;
        this.J.f1796h = true;
        l0 l0Var = this.c;
        Objects.requireNonNull(l0Var);
        ArrayList<j0> arrayList2 = new ArrayList<>(l0Var.b.size());
        Iterator<k0> it = l0Var.b.values().iterator();
        while (true) {
            bVarArr = null;
            Bundle bundle = null;
            bVarArr = null;
            if (!it.hasNext()) {
                break;
            }
            k0 next = it.next();
            if (next != null) {
                m mVar = next.c;
                j0 j0Var = new j0(mVar);
                m mVar2 = next.c;
                if (mVar2.b <= -1 || j0Var.n != null) {
                    j0Var.n = mVar2.c;
                } else {
                    Bundle bundle2 = new Bundle();
                    m mVar3 = next.c;
                    mVar3.j0(bundle2);
                    mVar3.S.b(bundle2);
                    Parcelable f0 = mVar3.u.f0();
                    if (f0 != null) {
                        bundle2.putParcelable("android:support:fragments", f0);
                    }
                    next.a.j(next.c, bundle2, false);
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                    if (next.c.F != null) {
                        next.o();
                    }
                    if (next.c.f1809d != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", next.c.f1809d);
                    }
                    if (next.c.f1810e != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", next.c.f1810e);
                    }
                    if (!next.c.H) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", next.c.H);
                    }
                    j0Var.n = bundle;
                    if (next.c.f1814i != null) {
                        if (bundle == null) {
                            j0Var.n = new Bundle();
                        }
                        j0Var.n.putString("android:target_state", next.c.f1814i);
                        int i3 = next.c.f1815j;
                        if (i3 != 0) {
                            j0Var.n.putInt("android:target_req_state", i3);
                        }
                    }
                }
                arrayList2.add(j0Var);
                if (P(2)) {
                    String str = "Saved state of " + mVar + ": " + j0Var.n;
                }
            }
        }
        if (arrayList2.isEmpty()) {
            P(2);
            return null;
        }
        l0 l0Var2 = this.c;
        synchronized (l0Var2.a) {
            if (l0Var2.a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(l0Var2.a.size());
                Iterator<m> it2 = l0Var2.a.iterator();
                while (it2.hasNext()) {
                    m next2 = it2.next();
                    arrayList.add(next2.f1811f);
                    if (P(2)) {
                        String str2 = "saveAllState: adding fragment (" + next2.f1811f + "): " + next2;
                    }
                }
            }
        }
        ArrayList<a> arrayList3 = this.f1773d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new b[size];
            for (i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new b(this.f1773d.get(i2));
                if (P(2)) {
                    String str3 = "saveAllState: adding back stack #" + i2 + ": " + this.f1773d.get(i2);
                }
            }
        }
        g0 g0Var = new g0();
        g0Var.b = arrayList2;
        g0Var.c = arrayList;
        g0Var.f1783d = bVarArr;
        g0Var.f1784e = this.f1778i.get();
        m mVar4 = this.t;
        if (mVar4 != null) {
            g0Var.f1785f = mVar4.f1811f;
        }
        g0Var.f1786g.addAll(this.f1779j.keySet());
        g0Var.f1787h.addAll(this.f1779j.values());
        g0Var.f1788i = new ArrayList<>(this.z);
        return g0Var;
    }

    public void g(a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.l(z3);
        } else {
            aVar.k();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.p >= 1) {
            t0.p(this.q.c, this.r, arrayList, arrayList2, 0, 1, true, this.m);
        }
        if (z3) {
            U(this.p, true);
        }
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (mVar != null) {
                View view = mVar.F;
            }
        }
    }

    public void g0() {
        synchronized (this.a) {
            ArrayList<n> arrayList = this.I;
            boolean z = false;
            boolean z2 = arrayList != null && !arrayList.isEmpty();
            if (this.a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.q.f1764d.removeCallbacks(this.K);
                this.q.f1764d.post(this.K);
                o0();
            }
        }
    }

    public k0 h(m mVar) {
        k0 h2 = this.c.h(mVar.f1811f);
        if (h2 != null) {
            return h2;
        }
        k0 k0Var = new k0(this.n, this.c, mVar);
        k0Var.m(this.q.c.getClassLoader());
        k0Var.f1808e = this.p;
        return k0Var;
    }

    public void h0(m mVar, boolean z) {
        ViewGroup L = L(mVar);
        if (L != null && (L instanceof y)) {
            ((y) L).setDrawDisappearingViewsLast(!z);
        }
    }

    public final void i(m mVar) {
        mVar.p0();
        this.n.n(mVar, false);
        mVar.E = null;
        mVar.F = null;
        mVar.P = null;
        mVar.Q.l(null);
        mVar.o = false;
    }

    public void i0(m mVar, h.b bVar) {
        if (!mVar.equals(G(mVar.f1811f)) || !(mVar.t == null || mVar.s == this)) {
            throw new IllegalArgumentException("Fragment " + mVar + " is not an active fragment of FragmentManager " + this);
        }
        mVar.N = bVar;
    }

    public void j(m mVar) {
        if (P(2)) {
            String str = "detach: " + mVar;
        }
        if (!mVar.A) {
            mVar.A = true;
            if (mVar.f1817l) {
                if (P(2)) {
                    String str2 = "remove from detach: " + mVar;
                }
                this.c.l(mVar);
                if (Q(mVar)) {
                    this.A = true;
                }
                k0(mVar);
            }
        }
    }

    public void j0(m mVar) {
        if (mVar == null || (mVar.equals(G(mVar.f1811f)) && (mVar.t == null || mVar.s == this))) {
            m mVar2 = this.t;
            this.t = mVar;
            t(mVar2);
            t(this.t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + mVar + " is not an active fragment of FragmentManager " + this);
    }

    public void k(Configuration configuration) {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.onConfigurationChanged(configuration);
                mVar.u.k(configuration);
            }
        }
    }

    public final void k0(m mVar) {
        ViewGroup L = L(mVar);
        if (L != null) {
            if (mVar.z() + mVar.y() + mVar.p() + mVar.m() > 0) {
                int i2 = R$id.visible_removing_fragment_view_tag;
                if (L.getTag(i2) == null) {
                    L.setTag(i2, mVar);
                }
                ((m) L.getTag(i2)).E0(mVar.x());
            }
        }
    }

    public boolean l(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                if (!mVar.z ? mVar.R() ? true : mVar.u.l(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public void l0(m mVar) {
        if (P(2)) {
            String str = "show: " + mVar;
        }
        if (mVar.z) {
            mVar.z = false;
            mVar.J = !mVar.J;
        }
    }

    public void m() {
        this.B = false;
        this.C = false;
        this.J.f1796h = false;
        w(1);
    }

    public final void m0() {
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            k0 k0Var = (k0) it.next();
            m mVar = k0Var.c;
            if (mVar.G) {
                if (this.b) {
                    this.E = true;
                } else {
                    mVar.G = false;
                    k0Var.k();
                }
            }
        }
    }

    public boolean n(Menu menu, MenuInflater menuInflater) {
        if (this.p < 1) {
            return false;
        }
        ArrayList<m> arrayList = null;
        boolean z = false;
        for (m mVar : this.c.i()) {
            if (mVar != null && R(mVar)) {
                if (!mVar.z ? mVar.u.n(menu, menuInflater) | false : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(mVar);
                    z = true;
                }
            }
        }
        if (this.f1774e != null) {
            for (int i2 = 0; i2 < this.f1774e.size(); i2++) {
                m mVar2 = this.f1774e.get(i2);
                if (arrayList == null || !arrayList.contains(mVar2)) {
                    Objects.requireNonNull(mVar2);
                }
            }
        }
        this.f1774e = arrayList;
        return z;
    }

    public final void n0(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new z0("FragmentManager"));
        b0<?> b0Var = this.q;
        try {
            if (b0Var != null) {
                b0Var.h("  ", null, printWriter, new String[0]);
            } else {
                y("  ", null, printWriter, new String[0]);
            }
        } catch (Exception unused) {
        }
        throw runtimeException;
    }

    public void o() {
        this.D = true;
        C(true);
        z();
        w(-1);
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.f1776g != null) {
            this.f1777h.b();
            this.f1776g = null;
        }
        e.a.e.c<Intent> cVar = this.w;
        if (cVar != null) {
            cVar.b();
            this.x.b();
            this.y.b();
        }
    }

    public final void o0() {
        synchronized (this.a) {
            boolean z = true;
            if (!this.a.isEmpty()) {
                this.f1777h.a = true;
                return;
            }
            e.a.b bVar = this.f1777h;
            ArrayList<a> arrayList = this.f1773d;
            if ((arrayList != null ? arrayList.size() : 0) <= 0 || !S(this.s)) {
                z = false;
            }
            bVar.a = z;
        }
    }

    public void p() {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.r0();
            }
        }
    }

    public void q(boolean z) {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.d0();
                mVar.u.q(z);
            }
        }
    }

    public boolean r(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                if (!mVar.z ? mVar.u.r(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public void s(Menu menu) {
        if (this.p >= 1) {
            for (m mVar : this.c.i()) {
                if (mVar != null && !mVar.z) {
                    mVar.u.s(menu);
                }
            }
        }
    }

    public final void t(m mVar) {
        if (mVar != null && mVar.equals(G(mVar.f1811f))) {
            boolean S = mVar.s.S(mVar);
            Boolean bool = mVar.f1816k;
            if (bool == null || bool.booleanValue() != S) {
                mVar.f1816k = Boolean.valueOf(S);
                mVar.g0(S);
                e0 e0Var = mVar.u;
                e0Var.o0();
                e0Var.t(e0Var.t);
            }
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        m mVar = this.s;
        if (mVar != null) {
            sb.append(mVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.s;
        } else {
            b0<?> b0Var = this.q;
            if (b0Var != null) {
                sb.append(b0Var.getClass().getSimpleName());
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

    public void u(boolean z) {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.f0();
                mVar.u.u(z);
            }
        }
    }

    public boolean v(Menu menu) {
        boolean z = false;
        if (this.p < 1) {
            return false;
        }
        for (m mVar : this.c.i()) {
            if (mVar != null && R(mVar) && mVar.s0(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Finally extract failed */
    public final void w(int i2) {
        try {
            this.b = true;
            for (k0 k0Var : this.c.b.values()) {
                if (k0Var != null) {
                    k0Var.f1808e = i2;
                }
            }
            U(i2, false);
            Iterator it = ((HashSet) f()).iterator();
            while (it.hasNext()) {
                ((a1) it.next()).e();
            }
            this.b = false;
            C(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void x() {
        if (this.E) {
            this.E = false;
            m0();
        }
    }

    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2;
        String x = f.a.a.a.a.x(str, "    ");
        l0 l0Var = this.c;
        Objects.requireNonNull(l0Var);
        String str3 = str + "    ";
        if (!l0Var.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (k0 k0Var : l0Var.b.values()) {
                printWriter.print(str);
                if (k0Var != null) {
                    m mVar = k0Var.c;
                    printWriter.println(mVar);
                    Objects.requireNonNull(mVar);
                    printWriter.print(str3);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(mVar.w));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(mVar.x));
                    printWriter.print(" mTag=");
                    printWriter.println(mVar.y);
                    printWriter.print(str3);
                    printWriter.print("mState=");
                    printWriter.print(mVar.b);
                    printWriter.print(" mWho=");
                    printWriter.print(mVar.f1811f);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(mVar.r);
                    printWriter.print(str3);
                    printWriter.print("mAdded=");
                    printWriter.print(mVar.f1817l);
                    printWriter.print(" mRemoving=");
                    printWriter.print(mVar.m);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(mVar.n);
                    printWriter.print(" mInLayout=");
                    printWriter.println(mVar.o);
                    printWriter.print(str3);
                    printWriter.print("mHidden=");
                    printWriter.print(mVar.z);
                    printWriter.print(" mDetached=");
                    printWriter.print(mVar.A);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(mVar.C);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(str3);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(mVar.B);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(mVar.H);
                    if (mVar.s != null) {
                        printWriter.print(str3);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(mVar.s);
                    }
                    if (mVar.t != null) {
                        printWriter.print(str3);
                        printWriter.print("mHost=");
                        printWriter.println(mVar.t);
                    }
                    if (mVar.v != null) {
                        printWriter.print(str3);
                        printWriter.print("mParentFragment=");
                        printWriter.println(mVar.v);
                    }
                    if (mVar.f1812g != null) {
                        printWriter.print(str3);
                        printWriter.print("mArguments=");
                        printWriter.println(mVar.f1812g);
                    }
                    if (mVar.c != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(mVar.c);
                    }
                    if (mVar.f1809d != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(mVar.f1809d);
                    }
                    if (mVar.f1810e != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(mVar.f1810e);
                    }
                    Object obj = mVar.f1813h;
                    if (obj == null) {
                        e0 e0Var = mVar.s;
                        obj = (e0Var == null || (str2 = mVar.f1814i) == null) ? null : e0Var.c.d(str2);
                    }
                    if (obj != null) {
                        printWriter.print(str3);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(mVar.f1815j);
                    }
                    printWriter.print(str3);
                    printWriter.print("mPopDirection=");
                    printWriter.println(mVar.x());
                    if (mVar.m() != 0) {
                        printWriter.print(str3);
                        printWriter.print("getEnterAnim=");
                        printWriter.println(mVar.m());
                    }
                    if (mVar.p() != 0) {
                        printWriter.print(str3);
                        printWriter.print("getExitAnim=");
                        printWriter.println(mVar.p());
                    }
                    if (mVar.y() != 0) {
                        printWriter.print(str3);
                        printWriter.print("getPopEnterAnim=");
                        printWriter.println(mVar.y());
                    }
                    if (mVar.z() != 0) {
                        printWriter.print(str3);
                        printWriter.print("getPopExitAnim=");
                        printWriter.println(mVar.z());
                    }
                    if (mVar.E != null) {
                        printWriter.print(str3);
                        printWriter.print("mContainer=");
                        printWriter.println(mVar.E);
                    }
                    if (mVar.F != null) {
                        printWriter.print(str3);
                        printWriter.print("mView=");
                        printWriter.println(mVar.F);
                    }
                    if (mVar.h() != null) {
                        printWriter.print(str3);
                        printWriter.print("mAnimatingAway=");
                        printWriter.println(mVar.h());
                    }
                    if (mVar.k() != null) {
                        e.s.a.a.b(mVar).a(str3, fileDescriptor, printWriter, strArr);
                    }
                    printWriter.print(str3);
                    printWriter.println("Child " + mVar.u + ":");
                    mVar.u.y(f.a.a.a.a.x(str3, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = l0Var.a.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(l0Var.a.get(i2).toString());
            }
        }
        ArrayList<m> arrayList = this.f1774e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f1774e.get(i3).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f1773d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1773d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.j(x, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1778i.get());
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
                    printWriter.println((l) this.a.get(i5));
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

    public final void z() {
        Iterator it = ((HashSet) f()).iterator();
        while (it.hasNext()) {
            ((a1) it.next()).e();
        }
    }
}
