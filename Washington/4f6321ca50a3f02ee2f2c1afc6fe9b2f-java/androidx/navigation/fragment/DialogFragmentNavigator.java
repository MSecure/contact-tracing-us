package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.navigation.NavController;
import e.b.a.m;
import e.m.a.c0;
import e.m.a.k;
import e.m.a.l;
import e.p.g;
import e.p.h;
import e.p.j;
import e.r.o;
import e.r.q;
import e.r.s.b;

@q.b("dialog")
public final class DialogFragmentNavigator extends q<a> {
    public final Context a;
    public final c0 b;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public h f181d = new h(this) {
        /* class androidx.navigation.fragment.DialogFragmentNavigator.AnonymousClass1 */

        @Override // e.p.h
        public void d(j jVar, g.a aVar) {
            NavController X;
            if (aVar == g.a.ON_STOP) {
                k kVar = (k) jVar;
                if (!kVar.A0().isShowing()) {
                    int i2 = b.b0;
                    l lVar = kVar;
                    while (true) {
                        if (lVar == null) {
                            View view = kVar.F;
                            if (view != null) {
                                X = m.h.X(view);
                            } else {
                                throw new IllegalStateException("Fragment " + kVar + " does not have a NavController set");
                            }
                        } else if (lVar instanceof b) {
                            X = ((b) lVar).W;
                            if (X == null) {
                                throw new IllegalStateException("NavController is not available before onCreate()");
                            }
                        } else {
                            l lVar2 = lVar.t().t;
                            if (lVar2 instanceof b) {
                                X = ((b) lVar2).W;
                                if (X == null) {
                                    throw new IllegalStateException("NavController is not available before onCreate()");
                                }
                            } else {
                                lVar = lVar.v;
                            }
                        }
                    }
                    X.e();
                }
            }
        }
    };

    public static class a extends e.r.j implements e.r.b {

        /* renamed from: j  reason: collision with root package name */
        public String f182j;

        public a(q<? extends a> qVar) {
            super(qVar);
        }

        @Override // e.r.j
        public void k(Context context, AttributeSet attributeSet) {
            super.k(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                this.f182j = string;
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, c0 c0Var) {
        this.a = context;
        this.b = c0Var;
    }

    /* Return type fixed from 'e.r.j' to match base method */
    @Override // e.r.q
    public a a() {
        return new a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.r.j, android.os.Bundle, e.r.o, e.r.q$a] */
    @Override // e.r.q
    public e.r.j b(a aVar, Bundle bundle, o oVar, q.a aVar2) {
        a aVar3 = aVar;
        if (this.b.U()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String str = aVar3.f182j;
        if (str != null) {
            if (str.charAt(0) == '.') {
                str = this.a.getPackageName() + str;
            }
            l a2 = this.b.M().a(this.a.getClassLoader(), str);
            if (!k.class.isAssignableFrom(a2.getClass())) {
                StringBuilder h2 = f.a.a.a.a.h("Dialog destination ");
                String str2 = aVar3.f182j;
                if (str2 != null) {
                    throw new IllegalArgumentException(f.a.a.a.a.e(h2, str2, " is not an instance of DialogFragment"));
                }
                throw new IllegalStateException("DialogFragment class was not set");
            }
            k kVar = (k) a2;
            kVar.s0(bundle);
            kVar.P.a(this.f181d);
            c0 c0Var = this.b;
            StringBuilder h3 = f.a.a.a.a.h("androidx-nav-fragment:navigator:dialog:");
            int i2 = this.c;
            this.c = i2 + 1;
            h3.append(i2);
            kVar.B0(c0Var, h3.toString());
            return aVar3;
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    @Override // e.r.q
    public void c(Bundle bundle) {
        this.c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        for (int i2 = 0; i2 < this.c; i2++) {
            c0 c0Var = this.b;
            k kVar = (k) c0Var.J("androidx-nav-fragment:navigator:dialog:" + i2);
            if (kVar != null) {
                kVar.P.a(this.f181d);
            } else {
                throw new IllegalStateException(f.a.a.a.a.r("DialogFragment ", i2, " doesn't exist in the FragmentManager"));
            }
        }
    }

    @Override // e.r.q
    public Bundle d() {
        if (this.c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.c);
        return bundle;
    }

    @Override // e.r.q
    public boolean e() {
        if (this.c == 0) {
            return false;
        }
        if (this.b.U()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        c0 c0Var = this.b;
        StringBuilder h2 = f.a.a.a.a.h("androidx-nav-fragment:navigator:dialog:");
        int i2 = this.c - 1;
        this.c = i2;
        h2.append(i2);
        l J = c0Var.J(h2.toString());
        if (J != null) {
            J.P.b(this.f181d);
            ((k) J).y0(false, false);
        }
        return true;
    }
}
