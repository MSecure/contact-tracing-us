package e.s.s;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.navigation.R$styleable;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.R$id;
import e.b.a.m;
import e.n.a.a;
import e.n.a.m;
import e.n.a.y;
import e.q.e0;
import e.q.f0;
import e.q.g0;
import e.s.e;
import e.s.f;
import e.s.g;
import e.s.j;
import e.s.q;
import e.s.r;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class b extends m {
    public static final /* synthetic */ int b0 = 0;
    public e.s.m W;
    public Boolean X = null;
    public View Y;
    public int Z;
    public boolean a0;

    @Override // e.n.a.m
    public void N(Context context) {
        super.N(context);
        if (this.a0) {
            a aVar = new a(v());
            aVar.n(this);
            aVar.d();
        }
    }

    @Override // e.n.a.m
    public void Q(Bundle bundle) {
        Bundle bundle2;
        e0 e0Var;
        super.Q(bundle);
        e.s.m mVar = new e.s.m(t0());
        this.W = mVar;
        mVar.f189i = this;
        this.O.a(mVar.m);
        e.s.m mVar2 = this.W;
        OnBackPressedDispatcher onBackPressedDispatcher = s0().f5h;
        if (mVar2.f189i != null) {
            mVar2.n.b();
            onBackPressedDispatcher.a(mVar2.f189i, mVar2.n);
            e.s.m mVar3 = this.W;
            Boolean bool = this.X;
            int i2 = 0;
            mVar3.o = bool != null && bool.booleanValue();
            mVar3.h();
            Bundle bundle3 = null;
            this.X = null;
            e.s.m mVar4 = this.W;
            g0 i3 = i();
            if (mVar4.f188h.isEmpty()) {
                f0.b bVar = g.f1843d;
                String canonicalName = g.class.getCanonicalName();
                if (canonicalName != null) {
                    String w = f.a.a.a.a.w("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    e0 e0Var2 = i3.a.get(w);
                    if (!g.class.isInstance(e0Var2)) {
                        if (bVar instanceof f0.c) {
                            e0Var = ((f0.c) bVar).c(w, g.class);
                        } else {
                            e0Var = new g();
                        }
                        e0Var2 = e0Var;
                        e0 put = i3.a.put(w, e0Var2);
                        if (put != null) {
                            put.a();
                        }
                    } else if (bVar instanceof f0.e) {
                        ((f0.e) bVar).b(e0Var2);
                    }
                    mVar4.f190j = (g) e0Var2;
                    e.s.m mVar5 = this.W;
                    mVar5.f191k.a(new DialogFragmentNavigator(t0(), h()));
                    r rVar = mVar5.f191k;
                    Context t0 = t0();
                    e.n.a.e0 h2 = h();
                    int i4 = this.w;
                    if (i4 == 0 || i4 == -1) {
                        i4 = R$id.nav_host_fragment_container;
                    }
                    rVar.a(new a(t0, h2, i4));
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
                        if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                            this.a0 = true;
                            a aVar = new a(v());
                            aVar.n(this);
                            aVar.d();
                        }
                        this.Z = bundle.getInt("android-support-nav:fragment:graphId");
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        e.s.m mVar6 = this.W;
                        Objects.requireNonNull(mVar6);
                        bundle2.setClassLoader(mVar6.a.getClassLoader());
                        mVar6.f185e = bundle2.getBundle("android-support-nav:controller:navigatorState");
                        mVar6.f186f = bundle2.getParcelableArray("android-support-nav:controller:backStack");
                        mVar6.f187g = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled");
                    }
                    int i5 = this.Z;
                    if (i5 != 0) {
                        this.W.g(i5, null);
                        return;
                    }
                    Bundle bundle4 = this.f1727g;
                    if (bundle4 != null) {
                        i2 = bundle4.getInt("android-support-nav:fragment:graphId");
                    }
                    if (bundle4 != null) {
                        bundle3 = bundle4.getBundle("android-support-nav:fragment:startDestinationArgs");
                    }
                    if (i2 != 0) {
                        this.W.g(i2, bundle3);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        y yVar = new y(layoutInflater.getContext());
        int i2 = this.w;
        if (i2 == 0 || i2 == -1) {
            i2 = R$id.nav_host_fragment_container;
        }
        yVar.setId(i2);
        return yVar;
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        View view = this.Y;
        if (view != null && m.e.Z(view) == this.W) {
            this.Y.setTag(androidx.navigation.R$id.nav_controller_view_tag, null);
        }
        this.Y = null;
    }

    @Override // e.n.a.m
    public void a0(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.a0(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.Z = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.navigation.fragment.R$styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(androidx.navigation.fragment.R$styleable.NavHostFragment_defaultNavHost, false)) {
            this.a0 = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // e.n.a.m
    public void e0(boolean z) {
        e.s.m mVar = this.W;
        if (mVar != null) {
            mVar.o = z;
            mVar.h();
            return;
        }
        this.X = Boolean.valueOf(z);
    }

    @Override // e.n.a.m
    public void h0(Bundle bundle) {
        Bundle bundle2;
        e.s.m mVar = this.W;
        Objects.requireNonNull(mVar);
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle3 = new Bundle();
        for (Map.Entry<String, q<? extends j>> entry : mVar.f191k.a.entrySet()) {
            String key = entry.getKey();
            Bundle d2 = entry.getValue().d();
            if (d2 != null) {
                arrayList.add(key);
                bundle3.putBundle(key, d2);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle2 = new Bundle();
            bundle3.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle2.putBundle("android-support-nav:controller:navigatorState", bundle3);
        } else {
            bundle2 = null;
        }
        if (!mVar.f188h.isEmpty()) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[mVar.f188h.size()];
            int i2 = 0;
            for (e eVar : mVar.f188h) {
                parcelableArr[i2] = new f(eVar);
                i2++;
            }
            bundle2.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (mVar.f187g) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android-support-nav:controller:deepLinkHandled", mVar.f187g);
        }
        if (bundle2 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", bundle2);
        }
        if (this.a0) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i3 = this.Z;
        if (i3 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i3);
        }
    }

    @Override // e.n.a.m
    public void k0(View view, Bundle bundle) {
        if (view instanceof ViewGroup) {
            e.s.m mVar = this.W;
            int i2 = androidx.navigation.R$id.nav_controller_view_tag;
            view.setTag(i2, mVar);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.Y = view2;
                if (view2.getId() == this.w) {
                    this.Y.setTag(i2, this.W);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }
}
