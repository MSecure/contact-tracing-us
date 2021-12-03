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
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.R$id;
import e.b.a.m;
import e.m.a.h0;
import e.m.a.m;
import e.m.a.m0;
import e.m.a.t0;
import e.p.f0;
import e.p.g0;
import e.p.h;
import e.p.h0;
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
    public Runnable K = new g();
    public final ArrayList<l> a = new ArrayList<>();
    public boolean b;
    public final l0 c = new l0();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f1415d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<m> f1416e;

    /* renamed from: f  reason: collision with root package name */
    public final c0 f1417f = new c0(this);

    /* renamed from: g  reason: collision with root package name */
    public OnBackPressedDispatcher f1418g;

    /* renamed from: h  reason: collision with root package name */
    public final e.a.b f1419h = new c(false);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f1420i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Bundle> f1421j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Object> f1422k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    public Map<m, HashSet<e.i.e.a>> f1423l = Collections.synchronizedMap(new HashMap());
    public final t0.a m = new d();
    public final d0 n = new d0(this);
    public final CopyOnWriteArrayList<i0> o = new CopyOnWriteArrayList<>();
    public int p = -1;
    public b0<?> q;
    public x r;
    public m s;
    public m t;
    public a0 u = new e();
    public b1 v = new f(this);
    public e.a.e.c<Intent> w;
    public e.a.e.c<e.a.e.e> x;
    public e.a.e.c<String[]> y;
    public ArrayDeque<k> z = new ArrayDeque<>();

    public class a implements e.a.e.b<e.a.e.a> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
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
                e2.H(i2, aVar2.b, aVar2.c);
            }
        }
    }

    public class b implements e.a.e.b<Map<String, Boolean>> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
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
                e2.b0();
            }
        }
    }

    public class c extends e.a.b {
        public c(boolean z) {
            super(z);
        }

        @Override // e.a.b
        public void a() {
            e0 e0Var = e0.this;
            e0Var.C(true);
            if (e0Var.f1419h.a) {
                e0Var.Y();
            } else {
                e0Var.f1418g.b();
            }
        }
    }

    public class d implements t0.a {
        public d() {
        }

        public void a(m mVar, e.i.e.a aVar) {
            boolean z;
            synchronized (aVar) {
                z = aVar.a;
            }
            if (!z) {
                e0 e0Var = e0.this;
                HashSet<e.i.e.a> hashSet = e0Var.f1423l.get(mVar);
                if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
                    e0Var.f1423l.remove(mVar);
                    if (mVar.b < 5) {
                        e0Var.i(mVar);
                        e0Var.U(mVar, e0Var.p);
                    }
                }
            }
        }

        public void b(m mVar, e.i.e.a aVar) {
            e0 e0Var = e0.this;
            if (e0Var.f1423l.get(mVar) == null) {
                e0Var.f1423l.put(mVar, new HashSet<>());
            }
            e0Var.f1423l.get(mVar).add(aVar);
        }
    }

    public class e extends a0 {
        public e() {
        }

        @Override // e.m.a.a0
        public m a(ClassLoader classLoader, String str) {
            b0<?> b0Var = e0.this.q;
            Context context = b0Var.c;
            Objects.requireNonNull(b0Var);
            Object obj = m.V;
            try {
                return (m) a0.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e2) {
                throw new m.e(f.a.a.a.a.d("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
            } catch (IllegalAccessException e3) {
                throw new m.e(f.a.a.a.a.d("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
            } catch (NoSuchMethodException e4) {
                throw new m.e(f.a.a.a.a.d("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
            } catch (InvocationTargetException e5) {
                throw new m.e(f.a.a.a.a.d("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
            }
        }
    }

    public class f implements b1 {
        public f(e0 e0Var) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            e0.this.C(true);
        }
    }

    public class h implements i0 {
        public final /* synthetic */ m b;

        public h(e0 e0Var, m mVar) {
            this.b = mVar;
        }

        @Override // e.m.a.i0
        public void b(e0 e0Var, m mVar) {
            this.b.K();
        }
    }

    public class i implements e.a.e.b<e.a.e.a> {
        public i() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
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
                e2.H(i2, aVar2.b, aVar2.c);
            }
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
                    eVar2 = new e.a.e.e(eVar2.b, null, eVar2.f643d, eVar2.f644e);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", eVar2);
            if (e0.O(2)) {
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

    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();
        public String b;
        public int c;

        public class a implements Parcelable.Creator<k> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public k[] newArray(int i2) {
                return new k[i2];
            }
        }

        public k(Parcel parcel) {
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

    public interface l {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class m implements l {
        public final String a;
        public final int b;
        public final int c;

        public m(String str, int i2, int i3) {
            this.a = str;
            this.b = i2;
            this.c = i3;
        }

        @Override // e.m.a.e0.l
        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            m mVar = e0.this.t;
            if (mVar == null || this.b >= 0 || this.a != null || !mVar.h().Y()) {
                return e0.this.Z(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    public static class n implements m.g {
        public final boolean a;
        public final a b;
        public int c;

        public void a() {
            boolean z = this.c > 0;
            for (m mVar : this.b.q.c.i()) {
                mVar.x0(null);
                if (z && mVar.E()) {
                    mVar.z0();
                }
            }
            a aVar = this.b;
            aVar.q.g(aVar, this.a, !z, true);
        }
    }

    public static boolean O(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public void A(l lVar, boolean z2) {
        if (!z2) {
            if (this.q == null) {
                if (this.D) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (S()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            if (this.q != null) {
                this.a.add(lVar);
                f0();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void B(boolean z2) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.q == null) {
            if (this.D) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.q.f1407d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z2 || !S()) {
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

    /* JADX INFO: finally extract failed */
    public boolean C(boolean z2) {
        boolean z3;
        B(z2);
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
                    this.q.f1407d.removeCallbacks(this.K);
                }
            }
            if (z3) {
                this.b = true;
                try {
                    c0(this.F, this.G);
                    e();
                    z4 = true;
                } catch (Throwable th) {
                    e();
                    throw th;
                }
            } else {
                n0();
                x();
                this.c.b();
                return z4;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void D(l lVar, boolean z2) {
        if (!z2 || (this.q != null && !this.D)) {
            B(z2);
            ((a) lVar).a(this.F, this.G);
            this.b = true;
            try {
                c0(this.F, this.G);
                e();
                n0();
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
        boolean z2 = arrayList.get(i2).p;
        ArrayList<m> arrayList4 = this.H;
        if (arrayList4 == null) {
            this.H = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.H.addAll(this.c.i());
        m mVar = this.t;
        int i6 = i2;
        boolean z3 = false;
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
                            if (i10 == 2) {
                                m mVar2 = aVar2.b;
                                int i11 = mVar2.x;
                                int size = arrayList5.size() - 1;
                                boolean z4 = false;
                                while (size >= 0) {
                                    m mVar3 = arrayList5.get(size);
                                    if (mVar3.x != i11) {
                                        i5 = i11;
                                    } else if (mVar3 == mVar2) {
                                        i5 = i11;
                                        z4 = true;
                                    } else {
                                        if (mVar3 == mVar) {
                                            i5 = i11;
                                            aVar.a.add(i9, new m0.a(9, mVar3));
                                            i9++;
                                            mVar = null;
                                        } else {
                                            i5 = i11;
                                        }
                                        m0.a aVar3 = new m0.a(3, mVar3);
                                        aVar3.c = aVar2.c;
                                        aVar3.f1479e = aVar2.f1479e;
                                        aVar3.f1478d = aVar2.f1478d;
                                        aVar3.f1480f = aVar2.f1480f;
                                        aVar.a.add(i9, aVar3);
                                        arrayList5.remove(mVar3);
                                        i9++;
                                    }
                                    size--;
                                    i11 = i5;
                                }
                                if (z4) {
                                    aVar.a.remove(i9);
                                    i9--;
                                } else {
                                    i4 = 1;
                                    aVar2.a = 1;
                                    arrayList5.add(mVar2);
                                    i9 += i4;
                                    i7 = 1;
                                    i8 = 3;
                                }
                            } else if (i10 == i8 || i10 == 6) {
                                arrayList5.remove(aVar2.b);
                                m mVar4 = aVar2.b;
                                if (mVar4 == mVar) {
                                    aVar.a.add(i9, new m0.a(9, mVar4));
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
                                        aVar4.f1482h = aVar4.f1481g;
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
                z3 = z3 || aVar.f1472g;
                i6++;
                arrayList3 = arrayList2;
            } else {
                this.H.clear();
                if (!z2 && this.p >= 1) {
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
                        aVar5.g(-1);
                        aVar5.k(i15 == i3 + -1);
                    } else {
                        aVar5.g(1);
                        aVar5.j();
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
                T(this.p, true);
                HashSet hashSet = new HashSet();
                for (int i17 = i2; i17 < i3; i17++) {
                    Iterator<m0.a> it3 = arrayList.get(i17).a.iterator();
                    while (it3.hasNext()) {
                        m mVar8 = it3.next().b;
                        if (!(mVar8 == null || (viewGroup = mVar8.E) == null)) {
                            hashSet.add(a1.f(viewGroup, M()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    a1 a1Var = (a1) it4.next();
                    a1Var.f1386d = booleanValue;
                    a1Var.g();
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
                if ((nVar.c == 0) || (arrayList != null && nVar.b.m(arrayList, 0, arrayList.size()))) {
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

    public m J(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        m d2 = this.c.d(string);
        if (d2 != null) {
            return d2;
        }
        m0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public final ViewGroup K(m mVar) {
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

    public a0 L() {
        m mVar = this.s;
        return mVar != null ? mVar.s.L() : this.u;
    }

    public b1 M() {
        m mVar = this.s;
        return mVar != null ? mVar.s.M() : this.v;
    }

    public void N(m mVar) {
        if (O(2)) {
            String str = "hide: " + mVar;
        }
        if (!mVar.z) {
            mVar.z = true;
            mVar.J = true ^ mVar.J;
            j0(mVar);
        }
    }

    public final boolean P(m mVar) {
        e0 e0Var = mVar.u;
        Iterator it = ((ArrayList) e0Var.c.g()).iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            m mVar2 = (m) it.next();
            if (mVar2 != null) {
                z2 = e0Var.P(mVar2);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public boolean Q(m mVar) {
        e0 e0Var;
        if (mVar == null) {
            return true;
        }
        return mVar.C && ((e0Var = mVar.s) == null || e0Var.Q(mVar.v));
    }

    public boolean R(m mVar) {
        if (mVar == null) {
            return true;
        }
        e0 e0Var = mVar.s;
        if (!mVar.equals(e0Var.t) || !R(e0Var.s)) {
            return false;
        }
        return true;
    }

    public boolean S() {
        return this.B || this.C;
    }

    public void T(int i2, boolean z2) {
        b0<?> b0Var;
        if (this.q == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.p) {
            this.p = i2;
            l0 l0Var = this.c;
            Iterator<m> it = l0Var.a.iterator();
            while (it.hasNext()) {
                k0 k0Var = l0Var.b.get(it.next().f1453f);
                if (k0Var != null) {
                    k0Var.k();
                }
            }
            Iterator<k0> it2 = l0Var.b.values().iterator();
            while (true) {
                boolean z3 = false;
                if (!it2.hasNext()) {
                    break;
                }
                k0 next = it2.next();
                if (next != null) {
                    next.k();
                    m mVar = next.c;
                    if (mVar.m && !mVar.D()) {
                        z3 = true;
                    }
                    if (z3) {
                        l0Var.k(next);
                    }
                }
            }
            l0();
            if (this.A && (b0Var = this.q) != null && this.p == 7) {
                b0Var.m();
                this.A = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r2 != 5) goto L_0x019d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0199  */
    public void U(m mVar, int i2) {
        ViewGroup viewGroup;
        k0 h2 = this.c.h(mVar.f1453f);
        int i3 = 1;
        if (h2 == null) {
            h2 = new k0(this.n, this.c, mVar);
            h2.f1450e = 1;
        }
        if (mVar.n && mVar.o && mVar.b == 2) {
            i2 = Math.max(i2, 2);
        }
        int min = Math.min(i2, h2.d());
        int i4 = mVar.b;
        if (i4 <= min) {
            if (i4 < min && !this.f1423l.isEmpty()) {
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
                            if (O(3)) {
                                String str = "movefrom ACTIVITY_CREATED: " + mVar;
                            }
                            if (mVar.F != null && this.q.l(mVar) && mVar.f1451d == null) {
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
                            if (!mVar.F()) {
                                if (this.p > -1 && !this.D && mVar.F.getVisibility() == 0 && mVar.K >= 0.0f) {
                                    vVar = m.h.E0(this.q.c, mVar, false);
                                }
                                mVar.K = 0.0f;
                                ViewGroup viewGroup2 = mVar.E;
                                View view2 = mVar.F;
                                if (vVar != null) {
                                    t0.a aVar = this.m;
                                    viewGroup2.startViewTransition(view2);
                                    e.i.e.a aVar2 = new e.i.e.a();
                                    aVar2.b(new s(mVar));
                                    d dVar = (d) aVar;
                                    dVar.b(mVar, aVar2);
                                    if (vVar.a != null) {
                                        w wVar = new w(vVar.a, viewGroup2, view2);
                                        mVar.r0(mVar.F);
                                        wVar.setAnimationListener(new t(viewGroup2, mVar, dVar, aVar2));
                                        mVar.F.startAnimation(wVar);
                                    } else {
                                        Animator animator = vVar.b;
                                        mVar.s0(animator);
                                        animator.addListener(new u(viewGroup2, view2, mVar, dVar, aVar2));
                                        animator.setTarget(mVar.F);
                                        animator.start();
                                    }
                                }
                                viewGroup2.removeView(view2);
                                if (O(2)) {
                                    String str2 = "Removing view " + view2 + " for fragment " + mVar + " from container " + viewGroup2;
                                }
                                if (viewGroup2 != mVar.E) {
                                    return;
                                }
                            }
                        }
                        if (this.f1423l.get(mVar) == null) {
                            h2.h();
                        }
                    }
                }
                if (min < 1) {
                    if (this.f1423l.get(mVar) == null) {
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
            if (O(3)) {
                String str3 = "moveToState: Fragment state for " + mVar + " not updated inline; expected state " + min + " found " + mVar.b;
            }
            mVar.b = min;
        }
    }

    public void V() {
        if (this.q != null) {
            this.B = false;
            this.C = false;
            this.J.f1438h = false;
            for (m mVar : this.c.i()) {
                if (mVar != null) {
                    mVar.u.V();
                }
            }
        }
    }

    public void W() {
        A(new m(null, -1, 0), false);
    }

    public void X(String str, int i2) {
        A(new m(str, -1, i2), false);
    }

    public boolean Y() {
        C(false);
        B(true);
        m mVar = this.t;
        if (mVar != null && mVar.h().Y()) {
            return true;
        }
        boolean Z = Z(this.F, this.G, null, -1, 0);
        if (Z) {
            this.b = true;
            try {
                c0(this.F, this.G);
            } finally {
                e();
            }
        }
        n0();
        x();
        this.c.b();
        return Z;
    }

    public boolean Z(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<a> arrayList3 = this.f1415d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1415d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.f1415d.get(size2);
                    if ((str != null && str.equals(aVar.f1474i)) || (i2 >= 0 && i2 == aVar.s)) {
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
                        a aVar2 = this.f1415d.get(size2);
                        if ((str == null || !str.equals(aVar2.f1474i)) && (i2 < 0 || i2 != aVar2.s)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f1415d.size() - 1) {
                return false;
            }
            for (int size3 = this.f1415d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1415d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void a(m mVar) {
        if (O(2)) {
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
            if (P(mVar)) {
                this.A = true;
            }
        }
    }

    public void a0(Bundle bundle, String str, m mVar) {
        if (mVar.s == this) {
            bundle.putString(str, mVar.f1453f);
        } else {
            m0(new IllegalStateException(f.a.a.a.a.x("Fragment ", mVar, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
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
                    n0();
                }
                if (b0Var instanceof e.a.c) {
                    e.a.c cVar = (e.a.c) b0Var;
                    OnBackPressedDispatcher c2 = cVar.c();
                    this.f1418g = c2;
                    e.p.l lVar = cVar;
                    if (mVar != null) {
                        lVar = mVar;
                    }
                    c2.a(lVar, this.f1419h);
                }
                if (mVar == null) {
                    h0 h0Var = mVar.s.J;
                    h0 h0Var2 = h0Var.f1434d.get(mVar.f1453f);
                    if (h0Var2 == null) {
                        h0Var2 = new h0(h0Var.f1436f);
                        h0Var.f1434d.put(mVar.f1453f, h0Var2);
                    }
                    this.J = h0Var2;
                } else if (b0Var instanceof h0) {
                    g0 i2 = ((h0) b0Var).i();
                    f0.b bVar = h0.f1433i;
                    String canonicalName = h0.class.getCanonicalName();
                    if (canonicalName != null) {
                        String c3 = f.a.a.a.a.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                        e.p.e0 e0Var = i2.a.get(c3);
                        if (!h0.class.isInstance(e0Var)) {
                            e0Var = bVar instanceof f0.c ? ((f0.c) bVar).c(c3, h0.class) : ((h0.a) bVar).a(h0.class);
                            e.p.e0 put = i2.a.put(c3, e0Var);
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
                this.J.f1438h = S();
                this.c.c = this.J;
                b0Var2 = this.q;
                if (!(b0Var2 instanceof e.a.e.d)) {
                    ActivityResultRegistry f2 = ((e.a.e.d) b0Var2).f();
                    String c4 = f.a.a.a.a.c("FragmentManager:", mVar != null ? f.a.a.a.a.f(new StringBuilder(), mVar.f1453f, ":") : "");
                    this.w = f2.c(f.a.a.a.a.c(c4, "StartActivityForResult"), new e.a.e.f.c(), new i());
                    this.x = f2.c(f.a.a.a.a.c(c4, "StartIntentSenderForResult"), new j(), new a());
                    this.y = f2.c(f.a.a.a.a.c(c4, "RequestPermissions"), new e.a.e.f.b(), new b());
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
            this.J.f1438h = S();
            this.c.c = this.J;
            b0Var2 = this.q;
            if (!(b0Var2 instanceof e.a.e.d)) {
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void b0(m mVar) {
        if (O(2)) {
            String str = "remove: " + mVar + " nesting=" + mVar.r;
        }
        boolean z2 = !mVar.D();
        if (!mVar.A || z2) {
            this.c.l(mVar);
            if (P(mVar)) {
                this.A = true;
            }
            mVar.m = true;
            j0(mVar);
        }
    }

    public void c(m mVar) {
        if (O(2)) {
            String str = "attach: " + mVar;
        }
        if (mVar.A) {
            mVar.A = false;
            if (!mVar.f1459l) {
                this.c.a(mVar);
                if (O(2)) {
                    String str2 = "add from attach: " + mVar;
                }
                if (P(mVar)) {
                    this.A = true;
                }
            }
        }
    }

    public final void c0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
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

    public final void d(m mVar) {
        HashSet<e.i.e.a> hashSet = this.f1423l.get(mVar);
        if (hashSet != null) {
            Iterator<e.i.e.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            i(mVar);
            this.f1423l.remove(mVar);
        }
    }

    public void d0(Parcelable parcelable) {
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
                            if (O(2)) {
                                String str = "restoreSaveState: re-attaching retained " + mVar;
                            }
                            k0Var = new k0(this.n, this.c, mVar, next);
                        } else {
                            k0Var = new k0(this.n, this.c, this.q.c.getClassLoader(), L(), next);
                        }
                        m mVar2 = k0Var.c;
                        mVar2.s = this;
                        if (O(2)) {
                            StringBuilder i2 = f.a.a.a.a.i("restoreSaveState: active (");
                            i2.append(mVar2.f1453f);
                            i2.append("): ");
                            i2.append(mVar2);
                            i2.toString();
                        }
                        k0Var.m(this.q.c.getClassLoader());
                        this.c.j(k0Var);
                        k0Var.f1450e = this.p;
                    }
                }
                h0 h0Var = this.J;
                Objects.requireNonNull(h0Var);
                Iterator it2 = new ArrayList(h0Var.c.values()).iterator();
                while (it2.hasNext()) {
                    m mVar3 = (m) it2.next();
                    if (!this.c.c(mVar3.f1453f)) {
                        if (O(2)) {
                            String str2 = "Discarding retained Fragment " + mVar3 + " that was not found in the set of active Fragments " + g0Var.b;
                        }
                        this.J.c(mVar3);
                        mVar3.s = this;
                        k0 k0Var2 = new k0(this.n, this.c, mVar3);
                        k0Var2.f1450e = 1;
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
                            if (O(2)) {
                                String str4 = "restoreSaveState: added (" + str3 + "): " + d2;
                            }
                            l0Var.a(d2);
                        } else {
                            throw new IllegalStateException(f.a.a.a.a.d("No instantiated fragment for (", str3, ")"));
                        }
                    }
                }
                if (g0Var.f1425d != null) {
                    this.f1415d = new ArrayList<>(g0Var.f1425d.length);
                    int i3 = 0;
                    while (true) {
                        b[] bVarArr = g0Var.f1425d;
                        if (i3 >= bVarArr.length) {
                            break;
                        }
                        b bVar = bVarArr[i3];
                        Objects.requireNonNull(bVar);
                        a aVar = new a(this);
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            int[] iArr = bVar.b;
                            if (i4 >= iArr.length) {
                                break;
                            }
                            m0.a aVar2 = new m0.a();
                            int i6 = i4 + 1;
                            aVar2.a = iArr[i4];
                            if (O(2)) {
                                String str5 = "Instantiate " + aVar + " op #" + i5 + " base fragment #" + bVar.b[i6];
                            }
                            String str6 = bVar.c.get(i5);
                            aVar2.b = str6 != null ? this.c.d(str6) : null;
                            aVar2.f1481g = h.b.values()[bVar.f1398d[i5]];
                            aVar2.f1482h = h.b.values()[bVar.f1399e[i5]];
                            int[] iArr2 = bVar.b;
                            int i7 = i6 + 1;
                            int i8 = iArr2[i6];
                            aVar2.c = i8;
                            int i9 = i7 + 1;
                            int i10 = iArr2[i7];
                            aVar2.f1478d = i10;
                            int i11 = i9 + 1;
                            int i12 = iArr2[i9];
                            aVar2.f1479e = i12;
                            int i13 = iArr2[i11];
                            aVar2.f1480f = i13;
                            aVar.b = i8;
                            aVar.c = i10;
                            aVar.f1469d = i12;
                            aVar.f1470e = i13;
                            aVar.b(aVar2);
                            i5++;
                            i4 = i11 + 1;
                        }
                        aVar.f1471f = bVar.f1400f;
                        aVar.f1474i = bVar.f1401g;
                        aVar.s = bVar.f1402h;
                        aVar.f1472g = true;
                        aVar.f1475j = bVar.f1403i;
                        aVar.f1476k = bVar.f1404j;
                        aVar.f1477l = bVar.f1405k;
                        aVar.m = bVar.f1406l;
                        aVar.n = bVar.m;
                        aVar.o = bVar.n;
                        aVar.p = bVar.o;
                        aVar.g(1);
                        if (O(2)) {
                            String str7 = "restoreAllState: back stack #" + i3 + " (index " + aVar.s + "): " + aVar;
                            PrintWriter printWriter = new PrintWriter(new z0("FragmentManager"));
                            aVar.i("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1415d.add(aVar);
                        i3++;
                    }
                } else {
                    this.f1415d = null;
                }
                this.f1420i.set(g0Var.f1426e);
                String str8 = g0Var.f1427f;
                if (str8 != null) {
                    m G2 = G(str8);
                    this.t = G2;
                    t(G2);
                }
                ArrayList<String> arrayList2 = g0Var.f1428g;
                if (arrayList2 != null) {
                    for (int i14 = 0; i14 < arrayList2.size(); i14++) {
                        this.f1421j.put(arrayList2.get(i14), g0Var.f1429h.get(i14));
                    }
                }
                this.z = new ArrayDeque<>(g0Var.f1430i);
            }
        }
    }

    public final void e() {
        this.b = false;
        this.G.clear();
        this.F.clear();
    }

    public Parcelable e0() {
        int i2;
        b[] bVarArr;
        ArrayList<String> arrayList;
        int size;
        Iterator it = ((HashSet) f()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a1 a1Var = (a1) it.next();
            if (a1Var.f1387e) {
                a1Var.f1387e = false;
                a1Var.c();
            }
        }
        z();
        C(true);
        this.B = true;
        this.J.f1438h = true;
        l0 l0Var = this.c;
        Objects.requireNonNull(l0Var);
        ArrayList<j0> arrayList2 = new ArrayList<>(l0Var.b.size());
        Iterator<k0> it2 = l0Var.b.values().iterator();
        while (true) {
            bVarArr = null;
            Bundle bundle = null;
            bVarArr = null;
            if (!it2.hasNext()) {
                break;
            }
            k0 next = it2.next();
            if (next != null) {
                m mVar = next.c;
                j0 j0Var = new j0(mVar);
                m mVar2 = next.c;
                if (mVar2.b <= -1 || j0Var.n != null) {
                    j0Var.n = mVar2.c;
                } else {
                    Bundle bundle2 = new Bundle();
                    m mVar3 = next.c;
                    mVar3.d0(bundle2);
                    mVar3.S.b(bundle2);
                    Parcelable e0 = mVar3.u.e0();
                    if (e0 != null) {
                        bundle2.putParcelable("android:support:fragments", e0);
                    }
                    next.a.j(next.c, bundle2, false);
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                    if (next.c.F != null) {
                        next.o();
                    }
                    if (next.c.f1451d != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", next.c.f1451d);
                    }
                    if (next.c.f1452e != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", next.c.f1452e);
                    }
                    if (!next.c.H) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", next.c.H);
                    }
                    j0Var.n = bundle;
                    if (next.c.f1456i != null) {
                        if (bundle == null) {
                            j0Var.n = new Bundle();
                        }
                        j0Var.n.putString("android:target_state", next.c.f1456i);
                        int i3 = next.c.f1457j;
                        if (i3 != 0) {
                            j0Var.n.putInt("android:target_req_state", i3);
                        }
                    }
                }
                arrayList2.add(j0Var);
                if (O(2)) {
                    String str = "Saved state of " + mVar + ": " + j0Var.n;
                }
            }
        }
        if (arrayList2.isEmpty()) {
            O(2);
            return null;
        }
        l0 l0Var2 = this.c;
        synchronized (l0Var2.a) {
            if (l0Var2.a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(l0Var2.a.size());
                Iterator<m> it3 = l0Var2.a.iterator();
                while (it3.hasNext()) {
                    m next2 = it3.next();
                    arrayList.add(next2.f1453f);
                    if (O(2)) {
                        String str2 = "saveAllState: adding fragment (" + next2.f1453f + "): " + next2;
                    }
                }
            }
        }
        ArrayList<a> arrayList3 = this.f1415d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new b[size];
            for (i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new b(this.f1415d.get(i2));
                if (O(2)) {
                    String str3 = "saveAllState: adding back stack #" + i2 + ": " + this.f1415d.get(i2);
                }
            }
        }
        g0 g0Var = new g0();
        g0Var.b = arrayList2;
        g0Var.c = arrayList;
        g0Var.f1425d = bVarArr;
        g0Var.f1426e = this.f1420i.get();
        m mVar4 = this.t;
        if (mVar4 != null) {
            g0Var.f1427f = mVar4.f1453f;
        }
        g0Var.f1428g.addAll(this.f1421j.keySet());
        g0Var.f1429h.addAll(this.f1421j.values());
        g0Var.f1430i = new ArrayList<>(this.z);
        return g0Var;
    }

    public final Set<a1> f() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((k0) it.next()).c.E;
            if (viewGroup != null) {
                hashSet.add(a1.f(viewGroup, M()));
            }
        }
        return hashSet;
    }

    public void f0() {
        synchronized (this.a) {
            ArrayList<n> arrayList = this.I;
            boolean z2 = false;
            boolean z3 = arrayList != null && !arrayList.isEmpty();
            if (this.a.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.q.f1407d.removeCallbacks(this.K);
                this.q.f1407d.post(this.K);
                n0();
            }
        }
    }

    public void g(a aVar, boolean z2, boolean z3, boolean z4) {
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
            t0.p(this.q.c, this.r, arrayList, arrayList2, 0, 1, true, this.m);
        }
        if (z4) {
            T(this.p, true);
        }
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (mVar != null) {
                View view = mVar.F;
            }
        }
    }

    public void g0(m mVar, boolean z2) {
        ViewGroup K2 = K(mVar);
        if (K2 != null && (K2 instanceof y)) {
            ((y) K2).setDrawDisappearingViewsLast(!z2);
        }
    }

    public k0 h(m mVar) {
        k0 h2 = this.c.h(mVar.f1453f);
        if (h2 != null) {
            return h2;
        }
        k0 k0Var = new k0(this.n, this.c, mVar);
        k0Var.m(this.q.c.getClassLoader());
        k0Var.f1450e = this.p;
        return k0Var;
    }

    public void h0(m mVar, h.b bVar) {
        if (!mVar.equals(G(mVar.f1453f)) || !(mVar.t == null || mVar.s == this)) {
            throw new IllegalArgumentException("Fragment " + mVar + " is not an active fragment of FragmentManager " + this);
        }
        mVar.N = bVar;
    }

    public final void i(m mVar) {
        mVar.j0();
        this.n.n(mVar, false);
        mVar.E = null;
        mVar.F = null;
        mVar.P = null;
        mVar.Q.l(null);
        mVar.o = false;
    }

    public void i0(m mVar) {
        if (mVar == null || (mVar.equals(G(mVar.f1453f)) && (mVar.t == null || mVar.s == this))) {
            m mVar2 = this.t;
            this.t = mVar;
            t(mVar2);
            t(this.t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + mVar + " is not an active fragment of FragmentManager " + this);
    }

    public void j(m mVar) {
        if (O(2)) {
            String str = "detach: " + mVar;
        }
        if (!mVar.A) {
            mVar.A = true;
            if (mVar.f1459l) {
                if (O(2)) {
                    String str2 = "remove from detach: " + mVar;
                }
                this.c.l(mVar);
                if (P(mVar)) {
                    this.A = true;
                }
                j0(mVar);
            }
        }
    }

    public final void j0(m mVar) {
        ViewGroup K2 = K(mVar);
        if (K2 != null && mVar.t() > 0) {
            int i2 = R$id.visible_removing_fragment_view_tag;
            if (K2.getTag(i2) == null) {
                K2.setTag(i2, mVar);
            }
            ((m) K2.getTag(i2)).w0(mVar.t());
        }
    }

    public void k(Configuration configuration) {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.onConfigurationChanged(configuration);
                mVar.u.k(configuration);
            }
        }
    }

    public void k0(m mVar) {
        if (O(2)) {
            String str = "show: " + mVar;
        }
        if (mVar.z) {
            mVar.z = false;
            mVar.J = !mVar.J;
        }
    }

    public boolean l(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                if (!mVar.z ? mVar.L() ? true : mVar.u.l(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void l0() {
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

    public void m() {
        this.B = false;
        this.C = false;
        this.J.f1438h = false;
        w(1);
    }

    public final void m0(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new z0("FragmentManager"));
        b0<?> b0Var = this.q;
        if (b0Var != null) {
            try {
                b0Var.h("  ", null, printWriter, new String[0]);
            } catch (Exception unused) {
            }
        } else {
            y("  ", null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public boolean n(Menu menu, MenuInflater menuInflater) {
        if (this.p < 1) {
            return false;
        }
        ArrayList<m> arrayList = null;
        boolean z2 = false;
        for (m mVar : this.c.i()) {
            if (mVar != null && Q(mVar)) {
                if (!mVar.z ? mVar.u.n(menu, menuInflater) | false : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(mVar);
                    z2 = true;
                }
            }
        }
        if (this.f1416e != null) {
            for (int i2 = 0; i2 < this.f1416e.size(); i2++) {
                m mVar2 = this.f1416e.get(i2);
                if (arrayList == null || !arrayList.contains(mVar2)) {
                    Objects.requireNonNull(mVar2);
                }
            }
        }
        this.f1416e = arrayList;
        return z2;
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
        if (R(r4.s) == false) goto L_0x002b;
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
        r0 = r4.f1419h;
        r1 = r4.f1415d;
     */
    public final void n0() {
        synchronized (this.a) {
            boolean z2 = true;
            if (!this.a.isEmpty()) {
                this.f1419h.a = true;
            }
        }
    }

    public void o() {
        this.D = true;
        C(true);
        z();
        w(-1);
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.f1418g != null) {
            this.f1419h.b();
            this.f1418g = null;
        }
        e.a.e.c<Intent> cVar = this.w;
        if (cVar != null) {
            cVar.b();
            this.x.b();
            this.y.b();
        }
    }

    public void p() {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.l0();
            }
        }
    }

    public void q(boolean z2) {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.X();
                mVar.u.q(z2);
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
        if (mVar != null && mVar.equals(G(mVar.f1453f))) {
            boolean R = mVar.s.R(mVar);
            Boolean bool = mVar.f1458k;
            if (bool == null || bool.booleanValue() != R) {
                mVar.f1458k = Boolean.valueOf(R);
                mVar.a0(R);
                e0 e0Var = mVar.u;
                e0Var.n0();
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

    public void u(boolean z2) {
        for (m mVar : this.c.i()) {
            if (mVar != null) {
                mVar.Z();
                mVar.u.u(z2);
            }
        }
    }

    public boolean v(Menu menu) {
        boolean z2 = false;
        if (this.p < 1) {
            return false;
        }
        for (m mVar : this.c.i()) {
            if (mVar != null && Q(mVar) && mVar.m0(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void w(int i2) {
        try {
            this.b = true;
            for (k0 k0Var : this.c.b.values()) {
                if (k0Var != null) {
                    k0Var.f1450e = i2;
                }
            }
            T(i2, false);
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
            l0();
        }
    }

    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2;
        String c2 = f.a.a.a.a.c(str, "    ");
        l0 l0Var = this.c;
        Objects.requireNonNull(l0Var);
        String str3 = str + "    ";
        if (!l0Var.b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
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
                    printWriter.print(mVar.f1453f);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(mVar.r);
                    printWriter.print(str3);
                    printWriter.print("mAdded=");
                    printWriter.print(mVar.f1459l);
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
                    if (mVar.f1454g != null) {
                        printWriter.print(str3);
                        printWriter.print("mArguments=");
                        printWriter.println(mVar.f1454g);
                    }
                    if (mVar.c != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(mVar.c);
                    }
                    if (mVar.f1451d != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(mVar.f1451d);
                    }
                    if (mVar.f1452e != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(mVar.f1452e);
                    }
                    Object obj = mVar.f1455h;
                    if (obj == null) {
                        e0 e0Var = mVar.s;
                        obj = (e0Var == null || (str2 = mVar.f1456i) == null) ? null : e0Var.c.d(str2);
                    }
                    if (obj != null) {
                        printWriter.print(str3);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(mVar.f1457j);
                    }
                    if (mVar.t() != 0) {
                        printWriter.print(str3);
                        printWriter.print("mNextAnim=");
                        printWriter.println(mVar.t());
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
                    if (mVar.g() != null) {
                        printWriter.print(str3);
                        printWriter.print("mAnimatingAway=");
                        printWriter.println(mVar.g());
                    }
                    if (mVar.j() != null) {
                        e.q.a.a.b(mVar).a(str3, fileDescriptor, printWriter, strArr);
                    }
                    printWriter.print(str3);
                    printWriter.println("Child " + mVar.u + ":");
                    mVar.u.y(f.a.a.a.a.c(str3, "  "), fileDescriptor, printWriter, strArr);
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
        ArrayList<m> arrayList = this.f1416e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f1416e.get(i3).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f1415d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1415d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.i(c2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1420i.get());
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
