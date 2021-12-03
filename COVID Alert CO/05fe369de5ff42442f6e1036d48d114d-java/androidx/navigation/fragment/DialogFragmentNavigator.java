package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.navigation.NavController;
import e.b.a.m;
import e.m.a.e0;
import e.m.a.m;
import e.p.h;
import e.p.j;
import e.p.l;
import e.r.o;
import e.r.q;
import e.r.s.b;

@q.b("dialog")
public final class DialogFragmentNavigator extends q<a> {
    public final Context a;
    public final e0 b;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public j f192d = new j(this) {
        /* class androidx.navigation.fragment.DialogFragmentNavigator.AnonymousClass1 */

        @Override // e.p.j
        public void d(l lVar, h.a aVar) {
            NavController X;
            if (aVar == h.a.ON_STOP) {
                e.m.a.l lVar2 = (e.m.a.l) lVar;
                if (!lVar2.C0().isShowing()) {
                    int i2 = b.b0;
                    m mVar = lVar2;
                    while (true) {
                        if (mVar == null) {
                            View view = lVar2.F;
                            if (view != null) {
                                X = m.h.X(view);
                            } else {
                                throw new IllegalStateException("Fragment " + lVar2 + " does not have a NavController set");
                            }
                        } else if (mVar instanceof b) {
                            X = ((b) mVar).W;
                            if (X == null) {
                                throw new IllegalStateException("NavController is not available before onCreate()");
                            }
                        } else {
                            e.m.a.m mVar2 = mVar.u().t;
                            if (mVar2 instanceof b) {
                                X = ((b) mVar2).W;
                                if (X == null) {
                                    throw new IllegalStateException("NavController is not available before onCreate()");
                                }
                            } else {
                                mVar = mVar.v;
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
        public String f193j;

        public a(q<? extends a> qVar) {
            super(qVar);
        }

        @Override // e.r.j
        public void k(Context context, AttributeSet attributeSet) {
            super.k(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                this.f193j = string;
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, e0 e0Var) {
        this.a = context;
        this.b = e0Var;
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
        if (this.b.S()) {
            return null;
        }
        String str = aVar3.f193j;
        if (str != null) {
            if (str.charAt(0) == '.') {
                str = this.a.getPackageName() + str;
            }
            e.m.a.m a2 = this.b.L().a(this.a.getClassLoader(), str);
            if (!e.m.a.l.class.isAssignableFrom(a2.getClass())) {
                StringBuilder i2 = f.a.a.a.a.i("Dialog destination ");
                String str2 = aVar3.f193j;
                if (str2 != null) {
                    throw new IllegalArgumentException(f.a.a.a.a.f(i2, str2, " is not an instance of DialogFragment"));
                }
                throw new IllegalStateException("DialogFragment class was not set");
            }
            e.m.a.l lVar = (e.m.a.l) a2;
            lVar.t0(bundle);
            lVar.O.a(this.f192d);
            e0 e0Var = this.b;
            StringBuilder i3 = f.a.a.a.a.i("androidx-nav-fragment:navigator:dialog:");
            int i4 = this.c;
            this.c = i4 + 1;
            i3.append(i4);
            lVar.D0(e0Var, i3.toString());
            return aVar3;
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    @Override // e.r.q
    public void c(Bundle bundle) {
        this.c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        for (int i2 = 0; i2 < this.c; i2++) {
            e0 e0Var = this.b;
            e.m.a.l lVar = (e.m.a.l) e0Var.I("androidx-nav-fragment:navigator:dialog:" + i2);
            if (lVar != null) {
                lVar.O.a(this.f192d);
            } else {
                throw new IllegalStateException(f.a.a.a.a.w("DialogFragment ", i2, " doesn't exist in the FragmentManager"));
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
        if (this.c == 0 || this.b.S()) {
            return false;
        }
        e0 e0Var = this.b;
        StringBuilder i2 = f.a.a.a.a.i("androidx-nav-fragment:navigator:dialog:");
        int i3 = this.c - 1;
        this.c = i3;
        i2.append(i3);
        e.m.a.m I = e0Var.I(i2.toString());
        if (I != null) {
            I.O.b(this.f192d);
            ((e.m.a.l) I).A0(false, false);
        }
        return true;
    }
}
