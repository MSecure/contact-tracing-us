package e.r.s;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.navigation.fragment.R$styleable;
import e.m.a.e0;
import e.m.a.m;
import e.m.a.t0;
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
public class a extends q<C0047a> {
    public final Context a;
    public final e0 b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayDeque<Integer> f1601d = new ArrayDeque<>();

    /* renamed from: e.r.s.a$a  reason: collision with other inner class name */
    public static class C0047a extends j {

        /* renamed from: j  reason: collision with root package name */
        public String f1602j;

        public C0047a(q<? extends C0047a> qVar) {
            super(qVar);
        }

        @Override // e.r.j
        public void k(Context context, AttributeSet attributeSet) {
            super.k(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.FragmentNavigator_android_name);
            if (string != null) {
                this.f1602j = string;
            }
            obtainAttributes.recycle();
        }

        @Override // e.r.j
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.f1602j;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    public static final class b implements q.a {
    }

    public a(Context context, e0 e0Var, int i2) {
        this.a = context;
        this.b = e0Var;
        this.c = i2;
    }

    /* Return type fixed from 'e.r.j' to match base method */
    @Override // e.r.q
    public C0047a a() {
        return new C0047a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.r.j, android.os.Bundle, e.r.o, e.r.q$a] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017f  */
    @Override // e.r.q
    public j b(C0047a aVar, Bundle bundle, o oVar, q.a aVar2) {
        C0047a aVar3 = aVar;
        if (!this.b.S()) {
            String str = aVar3.f1602j;
            if (str != null) {
                boolean z = false;
                if (str.charAt(0) == '.') {
                    str = this.a.getPackageName() + str;
                }
                m a2 = this.b.L().a(this.a.getClassLoader(), str);
                a2.t0(bundle);
                e.m.a.a aVar4 = new e.m.a.a(this.b);
                int i2 = oVar != null ? oVar.f1588d : -1;
                int i3 = oVar != null ? oVar.f1589e : -1;
                int i4 = oVar != null ? oVar.f1590f : -1;
                int i5 = oVar != null ? oVar.f1591g : -1;
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
                    aVar4.f1469d = i4;
                    aVar4.f1470e = i5;
                }
                aVar4.f(this.c, a2, null);
                aVar4.n(a2);
                int i6 = aVar3.f1575d;
                boolean isEmpty = this.f1601d.isEmpty();
                boolean z2 = oVar != null && !isEmpty && oVar.a && this.f1601d.peekLast().intValue() == i6;
                if (!isEmpty) {
                    if (z2) {
                        if (this.f1601d.size() > 1) {
                            this.b.X(f(this.f1601d.size(), this.f1601d.peekLast().intValue()), 1);
                            aVar4.c(f(this.f1601d.size(), i6));
                        }
                        if (aVar2 instanceof b) {
                            Objects.requireNonNull((b) aVar2);
                            for (Map.Entry entry : Collections.unmodifiableMap(null).entrySet()) {
                                String str2 = (String) entry.getValue();
                                int[] iArr = t0.a;
                                AtomicInteger atomicInteger = e.i.i.m.a;
                                String transitionName = ((View) entry.getKey()).getTransitionName();
                                if (transitionName != null) {
                                    if (aVar4.n == null) {
                                        aVar4.n = new ArrayList<>();
                                        aVar4.o = new ArrayList<>();
                                    } else if (aVar4.o.contains(str2)) {
                                        throw new IllegalArgumentException(f.a.a.a.a.d("A shared element with the target name '", str2, "' has already been added to the transaction."));
                                    } else if (aVar4.n.contains(transitionName)) {
                                        throw new IllegalArgumentException(f.a.a.a.a.d("A shared element with the source name '", transitionName, "' has already been added to the transaction."));
                                    }
                                    aVar4.n.add(transitionName);
                                    aVar4.o.add(str2);
                                } else {
                                    throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
                                }
                            }
                        }
                        aVar4.p = true;
                        aVar4.d();
                        if (z) {
                            this.f1601d.add(Integer.valueOf(i6));
                            return aVar3;
                        }
                    } else {
                        aVar4.c(f(this.f1601d.size() + 1, i6));
                    }
                }
                z = true;
                if (aVar2 instanceof b) {
                }
                aVar4.p = true;
                aVar4.d();
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
            this.f1601d.clear();
            for (int i2 : intArray) {
                this.f1601d.add(Integer.valueOf(i2));
            }
        }
    }

    @Override // e.r.q
    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f1601d.size()];
        Iterator<Integer> it = this.f1601d.iterator();
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
        if (this.f1601d.isEmpty() || this.b.S()) {
            return false;
        }
        this.b.X(f(this.f1601d.size(), this.f1601d.peekLast().intValue()), 1);
        this.f1601d.removeLast();
        return true;
    }

    public final String f(int i2, int i3) {
        return i2 + "-" + i3;
    }
}
