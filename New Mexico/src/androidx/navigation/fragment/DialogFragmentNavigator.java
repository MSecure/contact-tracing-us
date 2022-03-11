package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.navigation.NavController;
import e.b.a.m;
import e.o.a.e0;
import e.o.a.m;
import e.r.h;
import e.r.j;
import e.r.l;
import e.t.o;
import e.t.q;
import e.t.s.b;
@q.b("dialog")
/* loaded from: classes.dex */
public final class DialogFragmentNavigator extends q<a> {
    public final Context a;
    public final e0 b;
    public int c = 0;

    /* renamed from: d */
    public j f193d = new j(this) { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        public void d(l lVar, h.a aVar) {
            NavController a0;
            if (aVar == h.a.ON_STOP) {
                e.o.a.l lVar2 = (e.o.a.l) lVar;
                if (!lVar2.J0().isShowing()) {
                    int i2 = b.b0;
                    m mVar = lVar2;
                    while (true) {
                        if (mVar == null) {
                            View view = lVar2.F;
                            if (view != null) {
                                a0 = m.e.a0(view);
                            } else {
                                throw new IllegalStateException("Fragment " + lVar2 + " does not have a NavController set");
                            }
                        } else if (mVar instanceof b) {
                            a0 = ((b) mVar).W;
                            if (a0 == null) {
                                throw new IllegalStateException("NavController is not available before onCreate()");
                            }
                        } else {
                            e.o.a.m mVar2 = mVar.w().t;
                            if (mVar2 instanceof b) {
                                a0 = ((b) mVar2).W;
                                if (a0 == null) {
                                    throw new IllegalStateException("NavController is not available before onCreate()");
                                }
                            } else {
                                mVar = mVar.v;
                            }
                        }
                    }
                    a0.e();
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public static class a extends e.t.j implements e.t.b {

        /* renamed from: j */
        public String f194j;

        public a(q<? extends a> qVar) {
            super(qVar);
        }

        public void k(Context context, AttributeSet attributeSet) {
            super.k(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                this.f194j = string;
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, e0 e0Var) {
        this.a = context;
        this.b = e0Var;
    }

    @Override // e.t.q
    public a a() {
        return new a(this);
    }

    @Override // e.t.q
    public e.t.j b(e.t.j jVar, Bundle bundle, o oVar, q.a aVar) {
        a aVar2 = (a) jVar;
        if (this.b.T()) {
            return null;
        }
        String str = aVar2.f194j;
        if (str != null) {
            if (str.charAt(0) == '.') {
                str = this.a.getPackageName() + str;
            }
            e.o.a.m a2 = this.b.M().a(this.a.getClassLoader(), str);
            if (!e.o.a.l.class.isAssignableFrom(a2.getClass())) {
                StringBuilder h2 = f.a.a.a.a.h("Dialog destination ");
                String str2 = aVar2.f194j;
                if (str2 != null) {
                    throw new IllegalArgumentException(f.a.a.a.a.e(h2, str2, " is not an instance of DialogFragment"));
                }
                throw new IllegalStateException("DialogFragment class was not set");
            }
            e.o.a.l lVar = (e.o.a.l) a2;
            lVar.A0(bundle);
            lVar.O.a(this.f193d);
            e0 e0Var = this.b;
            StringBuilder h3 = f.a.a.a.a.h("androidx-nav-fragment:navigator:dialog:");
            int i2 = this.c;
            this.c = i2 + 1;
            h3.append(i2);
            lVar.K0(e0Var, h3.toString());
            return aVar2;
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    public void c(Bundle bundle) {
        this.c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        for (int i2 = 0; i2 < this.c; i2++) {
            e0 e0Var = this.b;
            e.o.a.l lVar = (e.o.a.l) e0Var.I("androidx-nav-fragment:navigator:dialog:" + i2);
            if (lVar != null) {
                lVar.O.a(this.f193d);
            } else {
                throw new IllegalStateException(f.a.a.a.a.v("DialogFragment ", i2, " doesn't exist in the FragmentManager"));
            }
        }
    }

    public Bundle d() {
        if (this.c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.c);
        return bundle;
    }

    public boolean e() {
        if (this.c == 0 || this.b.T()) {
            return false;
        }
        e0 e0Var = this.b;
        StringBuilder h2 = f.a.a.a.a.h("androidx-nav-fragment:navigator:dialog:");
        int i2 = this.c - 1;
        this.c = i2;
        h2.append(i2);
        e.o.a.m I = e0Var.I(h2.toString());
        if (I != null) {
            I.O.b(this.f193d);
            ((e.o.a.l) I).H0(false, false);
        }
        return true;
    }
}
