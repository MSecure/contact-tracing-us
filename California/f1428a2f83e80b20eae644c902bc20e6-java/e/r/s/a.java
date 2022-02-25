package e.r.s;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.navigation.fragment.R$styleable;
import e.m.a.c0;
import e.m.a.l;
import e.m.a.s0;
import e.r.j;
import e.r.o;
import e.r.q;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@q.b("fragment")
public class a extends q<C0048a> {
    public final Context a;
    public final c0 b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayDeque<Integer> f1771d = new ArrayDeque<>();

    /* renamed from: e.r.s.a$a  reason: collision with other inner class name */
    public static class C0048a extends j {

        /* renamed from: j  reason: collision with root package name */
        public String f1772j;

        public C0048a(q<? extends C0048a> qVar) {
            super(qVar);
        }

        @Override // e.r.j
        public void k(Context context, AttributeSet attributeSet) {
            super.k(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.FragmentNavigator_android_name);
            if (string != null) {
                this.f1772j = string;
            }
            obtainAttributes.recycle();
        }

        @Override // e.r.j
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.f1772j;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    public static final class b implements q.a {
    }

    public a(Context context, c0 c0Var, int i2) {
        this.a = context;
        this.b = c0Var;
        this.c = i2;
    }

    /* Return type fixed from 'e.r.j' to match base method */
    @Override // e.r.q
    public C0048a a() {
        return new C0048a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.r.j, android.os.Bundle, e.r.o, e.r.q$a] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0198  */
    @Override // e.r.q
    public j b(C0048a aVar, Bundle bundle, o oVar, q.a aVar2) {
        C0048a aVar3 = aVar;
        if (this.b.U()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
        } else {
            String str = aVar3.f1772j;
            if (str != null) {
                boolean z = false;
                if (str.charAt(0) == '.') {
                    str = this.a.getPackageName() + str;
                }
                l a2 = this.b.M().a(this.a.getClassLoader(), str);
                a2.s0(bundle);
                e.m.a.a aVar4 = new e.m.a.a(this.b);
                int i2 = oVar != null ? oVar.f1758d : -1;
                int i3 = oVar != null ? oVar.f1759e : -1;
                int i4 = oVar != null ? oVar.f1760f : -1;
                int i5 = oVar != null ? oVar.f1761g : -1;
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
                    aVar4.b = i2;
                    aVar4.c = i3;
                    aVar4.f1636d = i4;
                    aVar4.f1637e = i5;
                }
                aVar4.f(this.c, a2, null);
                aVar4.q(a2);
                int i6 = aVar3.f1745d;
                boolean isEmpty = this.f1771d.isEmpty();
                boolean z2 = oVar != null && !isEmpty && oVar.a && this.f1771d.peekLast().intValue() == i6;
                if (!isEmpty) {
                    if (z2) {
                        if (this.f1771d.size() > 1) {
                            this.b.a0(f(this.f1771d.size(), this.f1771d.peekLast().intValue()), 1);
                            String f2 = f(this.f1771d.size(), i6);
                            if (aVar4.f1640h) {
                                aVar4.f1639g = true;
                                aVar4.f1641i = f2;
                            } else {
                                throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                            }
                        }
                        if (aVar2 instanceof b) {
                            Objects.requireNonNull((b) aVar2);
                            for (Map.Entry entry : Collections.unmodifiableMap(null).entrySet()) {
                                String str2 = (String) entry.getValue();
                                int[] iArr = s0.a;
                                AtomicInteger atomicInteger = e.i.i.l.a;
                                String transitionName = ((View) entry.getKey()).getTransitionName();
                                if (transitionName != null) {
                                    if (aVar4.n == null) {
                                        aVar4.n = new ArrayList<>();
                                        aVar4.o = new ArrayList<>();
                                    } else if (aVar4.o.contains(str2)) {
                                        throw new IllegalArgumentException(f.a.a.a.a.c("A shared element with the target name '", str2, "' has already been added to the transaction."));
                                    } else if (aVar4.n.contains(transitionName)) {
                                        throw new IllegalArgumentException(f.a.a.a.a.c("A shared element with the source name '", transitionName, "' has already been added to the transaction."));
                                    }
                                    aVar4.n.add(transitionName);
                                    aVar4.o.add(str2);
                                } else {
                                    throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
                                }
                            }
                        }
                        aVar4.p = true;
                        aVar4.c();
                        if (z) {
                            this.f1771d.add(Integer.valueOf(i6));
                            return aVar3;
                        }
                    } else {
                        String f3 = f(this.f1771d.size() + 1, i6);
                        if (aVar4.f1640h) {
                            aVar4.f1639g = true;
                            aVar4.f1641i = f3;
                        } else {
                            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                        }
                    }
                }
                z = true;
                if (aVar2 instanceof b) {
                }
                aVar4.p = true;
                aVar4.c();
                if (z) {
                }
            } else {
                throw new IllegalStateException("Fragment class was not set");
            }
        }
        return null;
    }

    @Override // e.r.q
    public void c(Bundle bundle) {
        int[] intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
        if (intArray != null) {
            this.f1771d.clear();
            for (int i2 : intArray) {
                this.f1771d.add(Integer.valueOf(i2));
            }
        }
    }

    @Override // e.r.q
    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f1771d.size()];
        Iterator<Integer> it = this.f1771d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    @Override // e.r.q
    public boolean e() {
        if (this.f1771d.isEmpty()) {
            return false;
        }
        if (this.b.U()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.b.a0(f(this.f1771d.size(), this.f1771d.peekLast().intValue()), 1);
        this.f1771d.removeLast();
        return true;
    }

    public final String f(int i2, int i3) {
        return i2 + "-" + i3;
    }
}
