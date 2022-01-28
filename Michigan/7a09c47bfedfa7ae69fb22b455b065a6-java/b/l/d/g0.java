package b.l.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import b.i.l.m;
import b.l.b;
import b.l.d.w0;
import b.o.a0;
import b.o.f;
import b.o.z;
import java.util.ArrayList;
import java.util.Iterator;

public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final y f2019a;

    /* renamed from: b  reason: collision with root package name */
    public final h0 f2020b;

    /* renamed from: c  reason: collision with root package name */
    public final Fragment f2021c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2022d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f2023e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2024b;

        public a(g0 g0Var, View view) {
            this.f2024b = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f2024b.removeOnAttachStateChangeListener(this);
            m.S(this.f2024b);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public g0(y yVar, h0 h0Var, Fragment fragment) {
        this.f2019a = yVar;
        this.f2020b = h0Var;
        this.f2021c = fragment;
    }

    public g0(y yVar, h0 h0Var, Fragment fragment, f0 f0Var) {
        this.f2019a = yVar;
        this.f2020b = h0Var;
        this.f2021c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        Fragment fragment3 = this.f2021c;
        fragment3.mTarget = null;
        Bundle bundle = f0Var.n;
        fragment3.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    public g0(y yVar, h0 h0Var, ClassLoader classLoader, v vVar, f0 f0Var) {
        this.f2019a = yVar;
        this.f2020b = h0Var;
        this.f2021c = vVar.a(classLoader, f0Var.f2010b);
        Bundle bundle = f0Var.k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.f2021c.setArguments(f0Var.k);
        Fragment fragment = this.f2021c;
        fragment.mWho = f0Var.f2011c;
        fragment.mFromLayout = f0Var.f2012d;
        fragment.mRestored = true;
        fragment.mFragmentId = f0Var.f2013e;
        fragment.mContainerId = f0Var.f2014f;
        fragment.mTag = f0Var.f2015g;
        fragment.mRetainInstance = f0Var.h;
        fragment.mRemoving = f0Var.i;
        fragment.mDetached = f0Var.j;
        fragment.mHidden = f0Var.l;
        fragment.mMaxState = f.b.values()[f0Var.m];
        Bundle bundle2 = f0Var.n;
        if (bundle2 != null) {
            this.f2021c.mSavedFragmentState = bundle2;
        } else {
            this.f2021c.mSavedFragmentState = new Bundle();
        }
        if (z.P(2)) {
            StringBuilder h = c.a.a.a.a.h("Instantiated fragment ");
            h.append(this.f2021c);
            h.toString();
        }
    }

    public void a() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("moveto ACTIVITY_CREATED: ");
            h.append(this.f2021c);
            h.toString();
        }
        Fragment fragment = this.f2021c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        y yVar = this.f2019a;
        Fragment fragment2 = this.f2021c;
        yVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void b() {
        View view;
        View view2;
        h0 h0Var = this.f2020b;
        Fragment fragment = this.f2021c;
        if (h0Var != null) {
            ViewGroup viewGroup = fragment.mContainer;
            int i = -1;
            if (viewGroup != null) {
                int indexOf = h0Var.f2029a.indexOf(fragment);
                int i2 = indexOf - 1;
                while (true) {
                    if (i2 < 0) {
                        while (true) {
                            indexOf++;
                            if (indexOf >= h0Var.f2029a.size()) {
                                break;
                            }
                            Fragment fragment2 = h0Var.f2029a.get(indexOf);
                            if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                                i = viewGroup.indexOfChild(view);
                                break;
                            }
                        }
                    } else {
                        Fragment fragment3 = h0Var.f2029a.get(i2);
                        if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                            i = viewGroup.indexOfChild(view2) + 1;
                            break;
                        }
                        i2--;
                    }
                }
            }
            Fragment fragment4 = this.f2021c;
            fragment4.mContainer.addView(fragment4.mView, i);
            return;
        }
        throw null;
    }

    public void c() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("moveto ATTACHED: ");
            h.append(this.f2021c);
            h.toString();
        }
        Fragment fragment = this.f2021c;
        Fragment fragment2 = fragment.mTarget;
        g0 g0Var = null;
        if (fragment2 != null) {
            g0 h2 = this.f2020b.h(fragment2.mWho);
            if (h2 != null) {
                Fragment fragment3 = this.f2021c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                g0Var = h2;
            } else {
                StringBuilder h3 = c.a.a.a.a.h("Fragment ");
                h3.append(this.f2021c);
                h3.append(" declared target fragment ");
                h3.append(this.f2021c.mTarget);
                h3.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(h3.toString());
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (g0Var = this.f2020b.h(str)) == null) {
                StringBuilder h4 = c.a.a.a.a.h("Fragment ");
                h4.append(this.f2021c);
                h4.append(" declared target fragment ");
                h4.append(this.f2021c.mTargetWho);
                h4.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(h4.toString());
            }
        }
        if (g0Var != null) {
            g0Var.k();
        }
        Fragment fragment4 = this.f2021c;
        z zVar = fragment4.mFragmentManager;
        fragment4.mHost = zVar.q;
        fragment4.mParentFragment = zVar.s;
        this.f2019a.g(fragment4, false);
        this.f2021c.performAttach();
        this.f2019a.b(this.f2021c, false);
    }

    public int d() {
        w0.d dVar;
        w0.d.b bVar;
        Fragment fragment = this.f2021c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i = this.f2023e;
        int ordinal = fragment.mMaxState.ordinal();
        if (ordinal == 1) {
            i = Math.min(i, 0);
        } else if (ordinal == 2) {
            i = Math.min(i, 1);
        } else if (ordinal == 3) {
            i = Math.min(i, 5);
        } else if (ordinal != 4) {
            i = Math.min(i, -1);
        }
        Fragment fragment2 = this.f2021c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i = Math.max(this.f2023e, 2);
                View view = this.f2021c.mView;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.f2023e < 4 ? Math.min(i, fragment2.mState) : Math.min(i, 1);
            }
        }
        if (!this.f2021c.mAdded) {
            i = Math.min(i, 1);
        }
        Fragment fragment3 = this.f2021c;
        ViewGroup viewGroup = fragment3.mContainer;
        w0.d.b bVar2 = null;
        if (viewGroup != null) {
            w0 f2 = w0.f(viewGroup, fragment3.getParentFragmentManager());
            if (f2 != null) {
                w0.d d2 = f2.d(this.f2021c);
                if (d2 != null) {
                    bVar = d2.f2156b;
                } else {
                    Fragment fragment4 = this.f2021c;
                    Iterator<w0.d> it = f2.f2148c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            dVar = null;
                            break;
                        }
                        dVar = it.next();
                        if (dVar.f2157c.equals(fragment4) && !dVar.f2160f) {
                            break;
                        }
                    }
                    if (dVar != null) {
                        bVar = dVar.f2156b;
                    }
                }
                bVar2 = bVar;
            } else {
                throw null;
            }
        }
        if (bVar2 == w0.d.b.ADDING) {
            i = Math.min(i, 6);
        } else if (bVar2 == w0.d.b.REMOVING) {
            i = Math.max(i, 3);
        } else {
            Fragment fragment5 = this.f2021c;
            if (fragment5.mRemoving) {
                i = fragment5.isInBackStack() ? Math.min(i, 1) : Math.min(i, -1);
            }
        }
        Fragment fragment6 = this.f2021c;
        if (fragment6.mDeferStart && fragment6.mState < 5) {
            i = Math.min(i, 4);
        }
        if (z.P(2)) {
            StringBuilder i2 = c.a.a.a.a.i("computeExpectedState() of ", i, " for ");
            i2.append(this.f2021c);
            i2.toString();
        }
        return i;
    }

    public void e() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("moveto CREATED: ");
            h.append(this.f2021c);
            h.toString();
        }
        Fragment fragment = this.f2021c;
        if (!fragment.mIsCreated) {
            this.f2019a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f2021c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            y yVar = this.f2019a;
            Fragment fragment3 = this.f2021c;
            yVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f2021c.mState = 1;
    }

    public void f() {
        String str;
        if (!this.f2021c.mFromLayout) {
            if (z.P(3)) {
                StringBuilder h = c.a.a.a.a.h("moveto CREATE_VIEW: ");
                h.append(this.f2021c);
                h.toString();
            }
            Fragment fragment = this.f2021c;
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = null;
            Fragment fragment2 = this.f2021c;
            ViewGroup viewGroup2 = fragment2.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i = fragment2.mContainerId;
                if (i != 0) {
                    if (i != -1) {
                        viewGroup = (ViewGroup) fragment2.mFragmentManager.r.b(i);
                        if (viewGroup == null) {
                            Fragment fragment3 = this.f2021c;
                            if (!fragment3.mRestored) {
                                try {
                                    str = fragment3.getResources().getResourceName(this.f2021c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                StringBuilder h2 = c.a.a.a.a.h("No view found for id 0x");
                                h2.append(Integer.toHexString(this.f2021c.mContainerId));
                                h2.append(" (");
                                h2.append(str);
                                h2.append(") for fragment ");
                                h2.append(this.f2021c);
                                throw new IllegalArgumentException(h2.toString());
                            }
                        }
                    } else {
                        StringBuilder h3 = c.a.a.a.a.h("Cannot create fragment ");
                        h3.append(this.f2021c);
                        h3.append(" for a container view with no id");
                        throw new IllegalArgumentException(h3.toString());
                    }
                }
            }
            Fragment fragment4 = this.f2021c;
            fragment4.mContainer = viewGroup;
            fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
            View view = this.f2021c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment5 = this.f2021c;
                fragment5.mView.setTag(b.fragment_container_view_tag, fragment5);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment6 = this.f2021c;
                if (fragment6.mHidden) {
                    fragment6.mView.setVisibility(8);
                }
                if (m.B(this.f2021c.mView)) {
                    this.f2021c.mView.requestApplyInsets();
                } else {
                    View view2 = this.f2021c.mView;
                    view2.addOnAttachStateChangeListener(new a(this, view2));
                }
                this.f2021c.performViewCreated();
                y yVar = this.f2019a;
                Fragment fragment7 = this.f2021c;
                yVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
                int visibility = this.f2021c.mView.getVisibility();
                this.f2021c.setPostOnViewCreatedAlpha(this.f2021c.mView.getAlpha());
                Fragment fragment8 = this.f2021c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.f2021c.setFocusedView(findFocus);
                        if (z.P(2)) {
                            String str2 = "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f2021c;
                        }
                    }
                    this.f2021c.mView.setAlpha(0.0f);
                }
            }
            this.f2021c.mState = 2;
        }
    }

    public void g() {
        Fragment d2;
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("movefrom CREATED: ");
            h.append(this.f2021c);
            h.toString();
        }
        Fragment fragment = this.f2021c;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2 || this.f2020b.f2031c.c(this.f2021c)) {
            w<?> wVar = this.f2021c.mHost;
            if (wVar instanceof a0) {
                z = this.f2020b.f2031c.f1997e;
            } else {
                Context context = wVar.f2143c;
                if (context instanceof Activity) {
                    z = true ^ ((Activity) context).isChangingConfigurations();
                }
            }
            if (z2 || z) {
                c0 c0Var = this.f2020b.f2031c;
                Fragment fragment2 = this.f2021c;
                if (c0Var != null) {
                    if (z.P(3)) {
                        String str = "Clearing non-config state for " + fragment2;
                    }
                    c0 c0Var2 = c0Var.f1994b.get(fragment2.mWho);
                    if (c0Var2 != null) {
                        c0Var2.onCleared();
                        c0Var.f1994b.remove(fragment2.mWho);
                    }
                    z zVar = c0Var.f1995c.get(fragment2.mWho);
                    if (zVar != null) {
                        zVar.a();
                        c0Var.f1995c.remove(fragment2.mWho);
                    }
                } else {
                    throw null;
                }
            }
            this.f2021c.performDestroy();
            this.f2019a.d(this.f2021c, false);
            Iterator it = ((ArrayList) this.f2020b.f()).iterator();
            while (it.hasNext()) {
                g0 g0Var = (g0) it.next();
                if (g0Var != null) {
                    Fragment fragment3 = g0Var.f2021c;
                    if (this.f2021c.mWho.equals(fragment3.mTargetWho)) {
                        fragment3.mTarget = this.f2021c;
                        fragment3.mTargetWho = null;
                    }
                }
            }
            Fragment fragment4 = this.f2021c;
            String str2 = fragment4.mTargetWho;
            if (str2 != null) {
                fragment4.mTarget = this.f2020b.d(str2);
            }
            this.f2020b.k(this);
            return;
        }
        String str3 = this.f2021c.mTargetWho;
        if (!(str3 == null || (d2 = this.f2020b.d(str3)) == null || !d2.mRetainInstance)) {
            this.f2021c.mTarget = d2;
        }
        this.f2021c.mState = 0;
    }

    public void h() {
        View view;
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("movefrom CREATE_VIEW: ");
            h.append(this.f2021c);
            h.toString();
        }
        Fragment fragment = this.f2021c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f2021c.performDestroyView();
        this.f2019a.n(this.f2021c, false);
        Fragment fragment2 = this.f2021c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue(null);
        this.f2021c.mInLayout = false;
    }

    public void i() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("movefrom ATTACHED: ");
            h.append(this.f2021c);
            h.toString();
        }
        this.f2021c.performDetach();
        boolean z = false;
        this.f2019a.e(this.f2021c, false);
        Fragment fragment = this.f2021c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || this.f2020b.f2031c.c(this.f2021c)) {
            if (z.P(3)) {
                StringBuilder h2 = c.a.a.a.a.h("initState called for fragment: ");
                h2.append(this.f2021c);
                h2.toString();
            }
            this.f2021c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.f2021c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (z.P(3)) {
                StringBuilder h = c.a.a.a.a.h("moveto CREATE_VIEW: ");
                h.append(this.f2021c);
                h.toString();
            }
            Fragment fragment2 = this.f2021c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f2021c.mSavedFragmentState);
            View view = this.f2021c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f2021c;
                fragment3.mView.setTag(b.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f2021c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f2021c.performViewCreated();
                y yVar = this.f2019a;
                Fragment fragment5 = this.f2021c;
                yVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f2021c.mState = 2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void k() {
        w0.d.b bVar = w0.d.b.NONE;
        if (!this.f2022d) {
            boolean z = false;
            ?? r3 = 1;
            try {
                while (true) {
                    int d2 = d();
                    if (d2 == this.f2021c.mState) {
                        if (this.f2021c.mHiddenChanged) {
                            if (!(this.f2021c.mView == null || this.f2021c.mContainer == null)) {
                                w0 f2 = w0.f(this.f2021c.mContainer, this.f2021c.getParentFragmentManager());
                                if (this.f2021c.mHidden) {
                                    if (f2 != null) {
                                        if (z.P(2)) {
                                            String str = "SpecialEffectsController: Enqueuing hide operation for fragment " + this.f2021c;
                                        }
                                        f2.a(w0.d.c.GONE, bVar, this);
                                    } else {
                                        throw null;
                                    }
                                } else if (f2 != null) {
                                    if (z.P(2)) {
                                        String str2 = "SpecialEffectsController: Enqueuing show operation for fragment " + this.f2021c;
                                    }
                                    f2.a(w0.d.c.VISIBLE, bVar, this);
                                } else {
                                    throw null;
                                }
                            }
                            if (this.f2021c.mFragmentManager != null) {
                                z zVar = this.f2021c.mFragmentManager;
                                Fragment fragment = this.f2021c;
                                if (zVar == null) {
                                    throw null;
                                } else if (fragment.mAdded && zVar.Q(fragment)) {
                                    zVar.C = r3;
                                }
                            }
                            this.f2021c.mHiddenChanged = z;
                            this.f2021c.onHiddenChanged(this.f2021c.mHidden);
                        }
                        this.f2022d = z;
                        return;
                    } else if (d2 > this.f2021c.mState) {
                        switch (this.f2021c.mState + r3) {
                            case 0:
                                c();
                                continue;
                            case 1:
                                e();
                                continue;
                            case 2:
                                j();
                                f();
                                continue;
                            case 3:
                                a();
                                continue;
                            case 4:
                                if (!(this.f2021c.mView == null || this.f2021c.mContainer == null)) {
                                    w0 f3 = w0.f(this.f2021c.mContainer, this.f2021c.getParentFragmentManager());
                                    w0.d.c d3 = w0.d.c.d(this.f2021c.mView.getVisibility());
                                    if (f3 != null) {
                                        if (z.P(2)) {
                                            String str3 = "SpecialEffectsController: Enqueuing add operation for fragment " + this.f2021c;
                                        }
                                        f3.a(d3, w0.d.b.ADDING, this);
                                    } else {
                                        throw null;
                                    }
                                }
                                this.f2021c.mState = 4;
                                continue;
                            case 5:
                                p();
                                continue;
                            case 6:
                                this.f2021c.mState = 6;
                                continue;
                            case 7:
                                n();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (this.f2021c.mState - (r3 == true ? 1 : 0)) {
                            case -1:
                                i();
                                continue;
                            case 0:
                                g();
                                continue;
                            case 1:
                                h();
                                this.f2021c.mState = r3;
                                continue;
                            case 2:
                                this.f2021c.mInLayout = z;
                                this.f2021c.mState = 2;
                                continue;
                            case 3:
                                if (z.P(3)) {
                                    String str4 = "movefrom ACTIVITY_CREATED: " + this.f2021c;
                                }
                                if (this.f2021c.mView != null && this.f2021c.mSavedViewState == null) {
                                    o();
                                }
                                if (!(this.f2021c.mView == null || this.f2021c.mContainer == null)) {
                                    w0 f4 = w0.f(this.f2021c.mContainer, this.f2021c.getParentFragmentManager());
                                    if (f4 != null) {
                                        if (z.P(2)) {
                                            String str5 = "SpecialEffectsController: Enqueuing remove operation for fragment " + this.f2021c;
                                        }
                                        f4.a(w0.d.c.REMOVED, w0.d.b.REMOVING, this);
                                    } else {
                                        throw null;
                                    }
                                }
                                this.f2021c.mState = 3;
                                continue;
                            case 4:
                                q();
                                continue;
                            case 5:
                                this.f2021c.mState = 5;
                                continue;
                            case 6:
                                l();
                                continue;
                            default:
                                continue;
                        }
                    }
                }
            } finally {
                this.f2022d = z;
            }
        } else if (z.P(2)) {
            StringBuilder h = c.a.a.a.a.h("Ignoring re-entrant call to moveToExpectedState() for ");
            h.append(this.f2021c);
            h.toString();
        }
    }

    public void l() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("movefrom RESUMED: ");
            h.append(this.f2021c);
            h.toString();
        }
        this.f2021c.performPause();
        this.f2019a.f(this.f2021c, false);
    }

    public void m(ClassLoader classLoader) {
        Bundle bundle = this.f2021c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f2021c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f2021c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f2021c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f2021c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f2021c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f2021c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f2021c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    public void n() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("moveto RESUMED: ");
            h.append(this.f2021c);
            h.toString();
        }
        View focusedView = this.f2021c.getFocusedView();
        if (focusedView != null) {
            boolean z = true;
            if (focusedView != this.f2021c.mView) {
                ViewParent parent = focusedView.getParent();
                while (true) {
                    if (parent == null) {
                        z = false;
                        break;
                    } else if (parent == this.f2021c.mView) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            if (z) {
                boolean requestFocus = focusedView.requestFocus();
                if (z.P(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("requestFocus: Restoring focused view ");
                    sb.append(focusedView);
                    sb.append(" ");
                    sb.append(requestFocus ? "succeeded" : "failed");
                    sb.append(" on Fragment ");
                    sb.append(this.f2021c);
                    sb.append(" resulting in focused view ");
                    sb.append(this.f2021c.mView.findFocus());
                    sb.toString();
                }
            }
        }
        this.f2021c.setFocusedView(null);
        this.f2021c.performResume();
        this.f2019a.i(this.f2021c, false);
        Fragment fragment = this.f2021c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public void o() {
        if (this.f2021c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f2021c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f2021c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f2021c.mViewLifecycleOwner.f2138c.b(bundle);
            if (!bundle.isEmpty()) {
                this.f2021c.mSavedViewRegistryState = bundle;
            }
        }
    }

    public void p() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("moveto STARTED: ");
            h.append(this.f2021c);
            h.toString();
        }
        this.f2021c.performStart();
        this.f2019a.k(this.f2021c, false);
    }

    public void q() {
        if (z.P(3)) {
            StringBuilder h = c.a.a.a.a.h("movefrom STARTED: ");
            h.append(this.f2021c);
            h.toString();
        }
        this.f2021c.performStop();
        this.f2019a.l(this.f2021c, false);
    }
}
