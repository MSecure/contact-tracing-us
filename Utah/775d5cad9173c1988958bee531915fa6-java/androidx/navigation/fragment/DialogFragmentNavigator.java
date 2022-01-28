package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.navigation.NavController;
import e.b.a.m;
import e.n.a.e0;
import e.n.a.m;
import e.q.h;
import e.q.j;
import e.q.l;
import e.s.o;
import e.s.q;
import e.s.s.b;

@q.b("dialog")
public final class DialogFragmentNavigator extends q<a> {
    public final Context a;
    public final e0 b;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public j f193d = new j(this) {
        /* class androidx.navigation.fragment.DialogFragmentNavigator.AnonymousClass1 */

        @Override // e.q.j
        public void d(l lVar, h.a aVar) {
            NavController Z;
            if (aVar == h.a.ON_STOP) {
                e.n.a.l lVar2 = (e.n.a.l) lVar;
                if (!lVar2.H0().isShowing()) {
                    int i2 = b.b0;
                    m mVar = lVar2;
                    while (true) {
                        if (mVar == null) {
                            View view = lVar2.F;
                            if (view != null) {
                                Z = m.e.Z(view);
                            } else {
                                throw new IllegalStateException("Fragment " + lVar2 + " does not have a NavController set");
                            }
                        } else if (mVar instanceof b) {
                            Z = ((b) mVar).W;
                            if (Z == null) {
                                throw new IllegalStateException("NavController is not available before onCreate()");
                            }
                        } else {
                            e.n.a.m mVar2 = mVar.v().t;
                            if (mVar2 instanceof b) {
                                Z = ((b) mVar2).W;
                                if (Z == null) {
                                    throw new IllegalStateException("NavController is not available before onCreate()");
                                }
                            } else {
                                mVar = mVar.v;
                            }
                        }
                    }
                    Z.e();
                }
            }
        }
    };

    public static class a extends e.s.j implements e.s.b {

        /* renamed from: j  reason: collision with root package name */
        public String f194j;

        public a(q<? extends a> qVar) {
            super(qVar);
        }

        @Override // e.s.j
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

    /* Return type fixed from 'e.s.j' to match base method */
    @Override // e.s.q
    public a a() {
        return new a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.s.j, android.os.Bundle, e.s.o, e.s.q$a] */
    @Override // e.s.q
    public e.s.j b(a aVar, Bundle bundle, o oVar, q.a aVar2) {
        a aVar3 = aVar;
        if (this.b.S()) {
            return null;
        }
        String str = aVar3.f194j;
        if (str != null) {
            if (str.charAt(0) == '.') {
                str = this.a.getPackageName() + str;
            }
            e.n.a.m a2 = this.b.L().a(this.a.getClassLoader(), str);
            if (!e.n.a.l.class.isAssignableFrom(a2.getClass())) {
                StringBuilder h2 = f.a.a.a.a.h("Dialog destination ");
                String str2 = aVar3.f194j;
                if (str2 != null) {
                    throw new IllegalArgumentException(f.a.a.a.a.e(h2, str2, " is not an instance of DialogFragment"));
                }
                throw new IllegalStateException("DialogFragment class was not set");
            }
            e.n.a.l lVar = (e.n.a.l) a2;
            lVar.y0(bundle);
            lVar.O.a(this.f193d);
            e0 e0Var = this.b;
            StringBuilder h3 = f.a.a.a.a.h("androidx-nav-fragment:navigator:dialog:");
            int i2 = this.c;
            this.c = i2 + 1;
            h3.append(i2);
            lVar.I0(e0Var, h3.toString());
            return aVar3;
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    @Override // e.s.q
    public void c(Bundle bundle) {
        this.c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        for (int i2 = 0; i2 < this.c; i2++) {
            e0 e0Var = this.b;
            e.n.a.l lVar = (e.n.a.l) e0Var.I("androidx-nav-fragment:navigator:dialog:" + i2);
            if (lVar != null) {
                lVar.O.a(this.f193d);
            } else {
                throw new IllegalStateException(f.a.a.a.a.u("DialogFragment ", i2, " doesn't exist in the FragmentManager"));
            }
        }
    }

    @Override // e.s.q
    public Bundle d() {
        if (this.c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.c);
        return bundle;
    }

    @Override // e.s.q
    public boolean e() {
        if (this.c == 0 || this.b.S()) {
            return false;
        }
        e0 e0Var = this.b;
        StringBuilder h2 = f.a.a.a.a.h("androidx-nav-fragment:navigator:dialog:");
        int i2 = this.c - 1;
        this.c = i2;
        h2.append(i2);
        e.n.a.m I = e0Var.I(h2.toString());
        if (I != null) {
            I.O.b(this.f193d);
            ((e.n.a.l) I).F0(false, false);
        }
        return true;
    }
}
