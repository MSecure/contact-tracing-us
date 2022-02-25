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
import e.m.a.l;
import e.m.a.w;
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
    public static final /* synthetic */ int b0 = 0;
    public m W;
    public Boolean X = null;
    public View Y;
    public int Z;
    public boolean a0;

    @Override // e.m.a.l
    public void K(Context context) {
        super.K(context);
        if (this.a0) {
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
        this.W = mVar;
        mVar.f177i = this;
        this.P.a(mVar.m);
        m mVar2 = this.W;
        OnBackPressedDispatcher onBackPressedDispatcher = m0().f5h;
        if (mVar2.f177i != null) {
            mVar2.n.b();
            onBackPressedDispatcher.a(mVar2.f177i, mVar2.n);
            m mVar3 = this.W;
            Boolean bool = this.X;
            int i2 = 0;
            mVar3.o = bool != null && bool.booleanValue();
            mVar3.h();
            Bundle bundle3 = null;
            this.X = null;
            m mVar4 = this.W;
            c0 h2 = h();
            if (mVar4.f176h.isEmpty()) {
                b0.b bVar = g.f1738d;
                String canonicalName = g.class.getCanonicalName();
                if (canonicalName != null) {
                    String t = f.a.a.a.a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    a0 a0Var2 = h2.a.get(t);
                    if (!g.class.isInstance(a0Var2)) {
                        if (bVar instanceof b0.c) {
                            a0Var = ((b0.c) bVar).c(t, g.class);
                        } else {
                            a0Var = new g();
                        }
                        a0Var2 = a0Var;
                        a0 put = h2.a.put(t, a0Var2);
                        if (put != null) {
                            put.a();
                        }
                    } else if (bVar instanceof b0.e) {
                        ((b0.e) bVar).b(a0Var2);
                    }
                    mVar4.f178j = (g) a0Var2;
                    m mVar5 = this.W;
                    mVar5.f179k.a(new DialogFragmentNavigator(n0(), j()));
                    r rVar = mVar5.f179k;
                    Context n0 = n0();
                    e.m.a.c0 j2 = j();
                    int i3 = this.w;
                    if (i3 == 0 || i3 == -1) {
                        i3 = R$id.nav_host_fragment_container;
                    }
                    rVar.a(new a(n0, j2, i3));
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
                        if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                            this.a0 = true;
                            a aVar = new a(t());
                            aVar.q(this);
                            aVar.c();
                        }
                        this.Z = bundle.getInt("android-support-nav:fragment:graphId");
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        m mVar6 = this.W;
                        Objects.requireNonNull(mVar6);
                        bundle2.setClassLoader(mVar6.a.getClassLoader());
                        mVar6.f173e = bundle2.getBundle("android-support-nav:controller:navigatorState");
                        mVar6.f174f = bundle2.getParcelableArray("android-support-nav:controller:backStack");
                        mVar6.f175g = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled");
                    }
                    int i4 = this.Z;
                    if (i4 != 0) {
                        this.W.g(i4, null);
                        return;
                    }
                    Bundle bundle4 = this.f1621g;
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

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        w wVar = new w(layoutInflater.getContext());
        int i2 = this.w;
        if (i2 == 0 || i2 == -1) {
            i2 = R$id.nav_host_fragment_container;
        }
        wVar.setId(i2);
        return wVar;
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        View view = this.Y;
        if (view != null && m.h.X(view) == this.W) {
            this.Y.setTag(androidx.navigation.R$id.nav_controller_view_tag, null);
        }
        this.Y = null;
    }

    @Override // e.m.a.l
    public void W(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.W(context, attributeSet, bundle);
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

    @Override // e.m.a.l
    public void a0(boolean z) {
        e.r.m mVar = this.W;
        if (mVar != null) {
            mVar.o = z;
            mVar.h();
            return;
        }
        this.X = Boolean.valueOf(z);
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        Bundle bundle2;
        e.r.m mVar = this.W;
        Objects.requireNonNull(mVar);
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle3 = new Bundle();
        for (Map.Entry<String, q<? extends j>> entry : mVar.f179k.a.entrySet()) {
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
        if (!mVar.f176h.isEmpty()) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[mVar.f176h.size()];
            int i2 = 0;
            for (e eVar : mVar.f176h) {
                parcelableArr[i2] = new f(eVar);
                i2++;
            }
            bundle2.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (mVar.f175g) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android-support-nav:controller:deepLinkHandled", mVar.f175g);
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

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        if (view instanceof ViewGroup) {
            e.r.m mVar = this.W;
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
