package e.t.s;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.navigation.fragment.R$styleable;
import e.j.j.v;
import e.o.a.e0;
import e.o.a.m;
import e.o.a.t0;
import e.t.j;
import e.t.o;
import e.t.q;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
@q.b("fragment")
/* loaded from: classes.dex */
public class a extends q<C0057a> {
    public final Context a;
    public final e0 b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayDeque<Integer> f1961d = new ArrayDeque<>();

    /* renamed from: e.t.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a extends j {

        /* renamed from: j  reason: collision with root package name */
        public String f1962j;

        public C0057a(q<? extends C0057a> qVar) {
            super(qVar);
        }

        public void k(Context context, AttributeSet attributeSet) {
            super.k(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.FragmentNavigator_android_name);
            if (string != null) {
                this.f1962j = string;
            }
            obtainAttributes.recycle();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.f1962j;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements q.a {
    }

    public a(Context context, e0 e0Var, int i2) {
        this.a = context;
        this.b = e0Var;
        this.c = i2;
    }

    @Override // e.t.q
    public C0057a a() {
        return new C0057a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017f  */
    @Override // e.t.q
    /* Code decompiled incorrectly, please refer to instructions dump */
    public j b(j jVar, Bundle bundle, o oVar, q.a aVar) {
        C0057a aVar2 = (C0057a) jVar;
        if (!this.b.T()) {
            String str = aVar2.f1962j;
            if (str != null) {
                boolean z = false;
                if (str.charAt(0) == '.') {
                    str = this.a.getPackageName() + str;
                }
                m a = this.b.M().a(this.a.getClassLoader(), str);
                a.A0(bundle);
                e.o.a.a aVar3 = new e.o.a.a(this.b);
                int i2 = oVar != null ? oVar.f1948d : -1;
                int i3 = oVar != null ? oVar.f1949e : -1;
                int i4 = oVar != null ? oVar.f1950f : -1;
                int i5 = oVar != null ? oVar.f1951g : -1;
                if (!(i2 == -1 && i3 == -1 && i4 == -1 && i5 == -1)) {
                    if (i2 == -1) {
                        i2 = 0;
                    }
                    if (i3 == -1) {
                        i3 = 0;
                    }
                    if (i4 == -1) {
                        i4 = 0;
                    }
                    if (i5 == -1) {
                        i5 = 0;
                    }
                    aVar3.b = i2;
                    aVar3.c = i3;
                    aVar3.f1827d = i4;
                    aVar3.f1828e = i5;
                }
                aVar3.g(this.c, a, null);
                aVar3.p(a);
                int i6 = aVar2.f1935d;
                boolean isEmpty = this.f1961d.isEmpty();
                boolean z2 = oVar != null && !isEmpty && oVar.a && this.f1961d.peekLast().intValue() == i6;
                if (!isEmpty) {
                    if (z2) {
                        if (this.f1961d.size() > 1) {
                            this.b.Y(f(this.f1961d.size(), this.f1961d.peekLast().intValue()), 1);
                            aVar3.c(f(this.f1961d.size(), i6));
                        }
                        if (aVar instanceof b) {
                            Objects.requireNonNull((b) aVar);
                            for (Map.Entry entry : Collections.unmodifiableMap(null).entrySet()) {
                                String str2 = (String) entry.getValue();
                                int[] iArr = t0.a;
                                AtomicInteger atomicInteger = v.a;
                                String k2 = v.i.k((View) entry.getKey());
                                if (k2 != null) {
                                    if (aVar3.n == null) {
                                        aVar3.n = new ArrayList<>();
                                        aVar3.o = new ArrayList<>();
                                    } else if (aVar3.o.contains(str2)) {
                                        throw new IllegalArgumentException(f.a.a.a.a.c("A shared element with the target name '", str2, "' has already been added to the transaction."));
                                    } else if (aVar3.n.contains(k2)) {
                                        throw new IllegalArgumentException(f.a.a.a.a.c("A shared element with the source name '", k2, "' has already been added to the transaction."));
                                    }
                                    aVar3.n.add(k2);
                                    aVar3.o.add(str2);
                                } else {
                                    throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
                                }
                            }
                        }
                        aVar3.p = true;
                        aVar3.d();
                        if (z) {
                            this.f1961d.add(Integer.valueOf(i6));
                            return aVar2;
                        }
                    } else {
                        aVar3.c(f(this.f1961d.size() + 1, i6));
                    }
                }
                z = true;
                if (aVar instanceof b) {
                }
                aVar3.p = true;
                aVar3.d();
                if (z) {
                }
            } else {
                throw new IllegalStateException("Fragment class was not set");
            }
        }
        return null;
    }

    public void c(Bundle bundle) {
        int[] intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
        if (intArray != null) {
            this.f1961d.clear();
            for (int i2 : intArray) {
                this.f1961d.add(Integer.valueOf(i2));
            }
        }
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f1961d.size()];
        Iterator<Integer> it = this.f1961d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            iArr[i2] = it.next().intValue();
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    public boolean e() {
        if (this.f1961d.isEmpty() || this.b.T()) {
            return false;
        }
        this.b.Y(f(this.f1961d.size(), this.f1961d.peekLast().intValue()), 1);
        this.f1961d.removeLast();
        return true;
    }

    public final String f(int i2, int i3) {
        return i2 + "-" + i3;
    }
}
