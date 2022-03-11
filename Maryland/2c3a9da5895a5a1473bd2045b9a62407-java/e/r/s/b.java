package e.r.s;

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
import e.m.a.a;
import e.m.a.f0;
import e.m.a.l;
import e.m.a.z;
import e.p.a0;
import e.p.b0;
import e.p.c0;
import e.r.e;
import e.r.f;
import e.r.g;
import e.r.j;
import e.r.m;
import e.r.q;
import e.r.r;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class b extends l {
    public static final /* synthetic */ int c0 = 0;
    public m X;
    public Boolean Y = null;
    public View Z;
    public int a0;
    public boolean b0;

    @Override // e.m.a.l
    public void K(Context context) {
        super.K(context);
        if (this.b0) {
            a aVar = new a(t());
            aVar.q(this);
            aVar.c();
        }
    }

    @Override // e.m.a.l
    public void N(Bundle bundle) {
        Bundle bundle2;
        a0 a0Var;
        super.N(bundle);
        m mVar = new m(n0());
        this.X = mVar;
        mVar.f185i = this;
        this.P.a(mVar.m);
        m mVar2 = this.X;
        OnBackPressedDispatcher onBackPressedDispatcher = m0().f5h;
        if (mVar2.f185i != null) {
            mVar2.n.b();
            onBackPressedDispatcher.a(mVar2.f185i, mVar2.n);
            m mVar3 = this.X;
            Boolean bool = this.Y;
            int i2 = 0;
            mVar3.o = bool != null && bool.booleanValue();
            mVar3.h();
            Bundle bundle3 = null;
            this.Y = null;
            m mVar4 = this.X;
            c0 i3 = i();
            if (mVar4.f184h.isEmpty()) {
                b0.b bVar = g.f1752d;
                String canonicalName = g.class.getCanonicalName();
                if (canonicalName != null) {
                    String t = f.a.a.a.a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    a0 a0Var2 = i3.a.get(t);
                    if (!g.class.isInstance(a0Var2)) {
                        if (bVar instanceof b0.c) {
                            a0Var = ((b0.c) bVar).c(t, g.class);
                        } else {
                            a0Var = new g();
                        }
                        a0Var2 = a0Var;
                        a0 put = i3.a.put(t, a0Var2);
                        if (put != null) {
                            put.a();
                        }
                    } else if (bVar instanceof b0.e) {
                        ((b0.e) bVar).b(a0Var2);
                    }
                    mVar4.f186j = (g) a0Var2;
                    m mVar5 = this.X;
                    mVar5.f187k.a(new DialogFragmentNavigator(n0(), j()));
                    r rVar = mVar5.f187k;
                    Context n0 = n0();
                    f0 j2 = j();
                    int i4 = this.w;
                    if (i4 == 0 || i4 == -1) {
                        i4 = R$id.nav_host_fragment_container;
                    }
                    rVar.a(new a(n0, j2, i4));
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
                        if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                            this.b0 = true;
                            a aVar = new a(t());
                            aVar.q(this);
                            aVar.c();
                        }
                        this.a0 = bundle.getInt("android-support-nav:fragment:graphId");
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        m mVar6 = this.X;
                        Objects.requireNonNull(mVar6);
                        bundle2.setClassLoader(mVar6.a.getClassLoader());
                        mVar6.f181e = bundle2.getBundle("android-support-nav:controller:navigatorState");
                        mVar6.f182f = bundle2.getParcelableArray("android-support-nav:controller:backStack");
                        mVar6.f183g = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled");
                    }
                    int i5 = this.a0;
                    if (i5 != 0) {
                        this.X.g(i5, null);
                        return;
                    }
                    Bundle bundle4 = this.f1632g;
                    if (bundle4 != null) {
                        i2 = bundle4.getInt("android-support-nav:fragment:graphId");
                    }
                    if (bundle4 != null) {
                        bundle3 = bundle4.getBundle("android-support-nav:fragment:startDestinationArgs");
                    }
                    if (i2 != 0) {
                        this.X.g(i2, bundle3);
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

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        z zVar = new z(layoutInflater.getContext());
        int i2 = this.w;
        if (i2 == 0 || i2 == -1) {
            i2 = R$id.nav_host_fragment_container;
        }
        zVar.setId(i2);
        return zVar;
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        View view = this.Z;
        if (view != null && m.h.X(view) == this.X) {
            this.Z.setTag(androidx.navigation.R$id.nav_controller_view_tag, null);
        }
        this.Z = null;
    }

    @Override // e.m.a.l
    public void W(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.W(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.a0 = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.navigation.fragment.R$styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(androidx.navigation.fragment.R$styleable.NavHostFragment_defaultNavHost, false)) {
            this.b0 = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // e.m.a.l
    public void a0(boolean z) {
        e.r.m mVar = this.X;
        if (mVar != null) {
            mVar.o = z;
            mVar.h();
            return;
        }
        this.Y = Boolean.valueOf(z);
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        Bundle bundle2;
        e.r.m mVar = this.X;
        Objects.requireNonNull(mVar);
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle3 = new Bundle();
        for (Map.Entry<String, q<? extends j>> entry : mVar.f187k.a.entrySet()) {
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
        if (!mVar.f184h.isEmpty()) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[mVar.f184h.size()];
            int i2 = 0;
            for (e eVar : mVar.f184h) {
                parcelableArr[i2] = new f(eVar);
                i2++;
            }
            bundle2.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (mVar.f183g) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android-support-nav:controller:deepLinkHandled", mVar.f183g);
        }
        if (bundle2 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", bundle2);
        }
        if (this.b0) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i3 = this.a0;
        if (i3 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i3);
        }
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        if (view instanceof ViewGroup) {
            e.r.m mVar = this.X;
            int i2 = androidx.navigation.R$id.nav_controller_view_tag;
            view.setTag(i2, mVar);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.Z = view2;
                if (view2.getId() == this.w) {
                    this.Z.setTag(i2, this.X);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }
}
