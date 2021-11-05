package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import b.i.d.o;
import b.l.d.c0;
import b.l.d.d0;
import b.l.d.m;
import b.l.d.s;
import b.l.d.u0;
import b.l.d.v;
import b.l.d.w;
import b.l.d.w0;
import b.l.d.y0;
import b.l.d.z;
import b.o.a0;
import b.o.f;
import b.o.p;
import b.o.u;
import b.o.y;
import b.p.a.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, b.o.i, a0, b.o.e, b.t.d {
    public static final int ACTIVITY_CREATED = 4;
    public static final int ATTACHED = 0;
    public static final int AWAITING_ENTER_EFFECTS = 6;
    public static final int AWAITING_EXIT_EFFECTS = 3;
    public static final int CREATED = 1;
    public static final int INITIALIZING = -1;
    public static final int RESUMED = 7;
    public static final int STARTED = 5;
    public static final Object USE_DEFAULT_TRANSITION = new Object();
    public static final int VIEW_CREATED = 2;
    public boolean mAdded;
    public i mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    public boolean mCalled;
    public z mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    public int mContentLayoutId;
    public y.b mDefaultFactory;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public z mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public w<?> mHost;
    public boolean mInLayout;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    public Boolean mIsPrimaryNavigationFragment;
    public LayoutInflater mLayoutInflater;
    public b.o.j mLifecycleRegistry;
    public f.b mMaxState;
    public boolean mMenuVisible;
    public final AtomicInteger mNextLocalRequestCode;
    public final ArrayList<k> mOnPreAttachedListeners;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    public Runnable mPostponedDurationRunnable;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public b.t.c mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public Bundle mSavedViewRegistryState;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    public u0 mViewLifecycleOwner;
    public p<b.o.i> mViewLifecycleOwnerLiveData;
    public String mWho;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w0 f218b;

        public c(Fragment fragment, w0 w0Var) {
            this.f218b = w0Var;
        }

        public void run() {
            this.f218b.c();
        }
    }

    public class d extends s {
        public d() {
        }

        @Override // b.l.d.s
        public View b(int i) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            StringBuilder h = c.a.a.a.a.h("Fragment ");
            h.append(Fragment.this);
            h.append(" does not have a view");
            throw new IllegalStateException(h.toString());
        }

        @Override // b.l.d.s
        public boolean c() {
            return Fragment.this.mView != null;
        }
    }

    public class e implements b.c.a.c.a<Void, ActivityResultRegistry> {
        public e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.c.a.c.a
        public ActivityResultRegistry a(Void r3) {
            Fragment fragment = Fragment.this;
            w<?> wVar = fragment.mHost;
            return wVar instanceof b.a.e.d ? ((b.a.e.d) wVar).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    public class f implements b.c.a.c.a<Void, ActivityResultRegistry> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityResultRegistry f221a;

        public f(Fragment fragment, ActivityResultRegistry activityResultRegistry) {
            this.f221a = activityResultRegistry;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // b.c.a.c.a
        public ActivityResultRegistry a(Void r1) {
            return this.f221a;
        }
    }

    public class g extends k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c.a.c.a f222a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f223b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.e.f.a f224c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.e.b f225d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(b.c.a.c.a aVar, AtomicReference atomicReference, b.a.e.f.a aVar2, b.a.e.b bVar) {
            super(null);
            this.f222a = aVar;
            this.f223b = atomicReference;
            this.f224c = aVar2;
            this.f225d = bVar;
        }

        @Override // androidx.fragment.app.Fragment.k
        public void a() {
            this.f223b.set(((ActivityResultRegistry) this.f222a.a(null)).d(Fragment.this.generateActivityResultKey(), Fragment.this, this.f224c, this.f225d));
        }
    }

    public class h extends b.a.e.c<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f227a;

        public h(Fragment fragment, AtomicReference atomicReference, b.a.e.f.a aVar) {
            this.f227a = atomicReference;
        }

        @Override // b.a.e.c
        public void a(I i, b.i.d.b bVar) {
            b.a.e.c cVar = (b.a.e.c) this.f227a.get();
            if (cVar != null) {
                cVar.a(i, bVar);
                return;
            }
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }

        @Override // b.a.e.c
        public void b() {
            b.a.e.c cVar = (b.a.e.c) this.f227a.getAndSet(null);
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public View f228a;

        /* renamed from: b  reason: collision with root package name */
        public Animator f229b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f230c;

        /* renamed from: d  reason: collision with root package name */
        public int f231d;

        /* renamed from: e  reason: collision with root package name */
        public int f232e;

        /* renamed from: f  reason: collision with root package name */
        public int f233f;

        /* renamed from: g  reason: collision with root package name */
        public int f234g;
        public int h;
        public ArrayList<String> i;
        public ArrayList<String> j;
        public Object k = null;
        public Object l;
        public Object m;
        public Object n;
        public Object o;
        public Object p;
        public Boolean q;
        public Boolean r;
        public o s;
        public o t;
        public float u;
        public View v;
        public boolean w;
        public l x;
        public boolean y;

        public i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.l = obj;
            this.m = null;
            this.n = obj;
            this.o = null;
            this.p = obj;
            this.s = null;
            this.t = null;
            this.u = 1.0f;
            this.v = null;
        }
    }

    public static class j extends RuntimeException {
        public j(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class k {
        public k() {
        }

        public k(a aVar) {
        }

        public abstract void a();
    }

    public interface l {
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f235b;

        public class a implements Parcelable.ClassLoaderCreator<m> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new m[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }
        }

        public m(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f235b = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f235b);
        }
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new b.l.d.a0();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new a();
        this.mMaxState = f.b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new p<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        initLifecycle();
    }

    public Fragment(int i2) {
        this();
        this.mContentLayoutId = i2;
    }

    private i ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        f.b bVar = this.mMaxState;
        return (bVar == f.b.INITIALIZED || this.mParentFragment == null) ? this.mMaxState.ordinal() : Math.min(bVar.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new b.o.j(this);
        this.mSavedStateRegistryController = new b.t.c(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) v.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e2) {
            throw new j(c.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (IllegalAccessException e3) {
            throw new j(c.a.a.a.a.c("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
        } catch (NoSuchMethodException e4) {
            throw new j(c.a.a.a.a.c("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
        } catch (InvocationTargetException e5) {
            throw new j(c.a.a.a.a.c("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
        }
    }

    private <I, O> b.a.e.c<I> prepareCallInternal(b.a.e.f.a<I, O> aVar, b.c.a.c.a<Void, ActivityResultRegistry> aVar2, b.a.e.b<O> bVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            registerOnPreAttachListener(new g(aVar2, atomicReference, aVar, bVar));
            return new h(this, atomicReference, aVar);
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    private void registerOnPreAttachListener(k kVar) {
        if (this.mState >= 0) {
            kVar.a();
        } else {
            this.mOnPreAttachedListeners.add(kVar);
        }
    }

    private void restoreViewState() {
        if (z.P(3)) {
            String str = "moveto RESTORE_VIEW_STATE: " + this;
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        z zVar;
        i iVar = this.mAnimationInfo;
        Object obj = null;
        if (iVar != null) {
            iVar.w = false;
            Object obj2 = iVar.x;
            iVar.x = null;
            obj = obj2;
        }
        if (obj != null) {
            z.n nVar = (z.n) obj;
            int i2 = nVar.f2201c - 1;
            nVar.f2201c = i2;
            if (i2 == 0) {
                nVar.f2200b.r.h0();
            }
        } else if (this.mView != null && (viewGroup = this.mContainer) != null && (zVar = this.mFragmentManager) != null) {
            w0 f2 = w0.f(viewGroup, zVar);
            f2.h();
            if (z) {
                this.mHost.f2144d.post(new c(this, f2));
            } else {
                f2.c();
            }
        }
    }

    public s createFragmentContainer() {
        return new d();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            b.p.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.z(c.a.a.a.a.q(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.f2180c.e(str);
    }

    public String generateActivityResultKey() {
        StringBuilder h2 = c.a.a.a.a.h("fragment_");
        h2.append(this.mWho);
        h2.append("_rq#");
        h2.append(this.mNextLocalRequestCode.getAndIncrement());
        return h2.toString();
    }

    public final b.l.d.m getActivity() {
        w<?> wVar = this.mHost;
        if (wVar == null) {
            return null;
        }
        return (b.l.d.m) wVar.f2142b;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f228a;
    }

    public Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f229b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final z getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        w<?> wVar = this.mHost;
        if (wVar == null) {
            return null;
        }
        return wVar.f2143c;
    }

    @Override // b.o.e
    public y.b getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Application application = null;
                Context applicationContext = requireContext().getApplicationContext();
                while (true) {
                    if (!(applicationContext instanceof ContextWrapper)) {
                        break;
                    } else if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else {
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    }
                }
                if (application == null && z.P(3)) {
                    StringBuilder h2 = c.a.a.a.a.h("Could not find Application instance from Context ");
                    h2.append(requireContext().getApplicationContext());
                    h2.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    h2.toString();
                }
                this.mDefaultFactory = new u(application, this, getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public int getEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f231d;
    }

    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.k;
    }

    public o getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        return null;
    }

    public int getExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f232e;
    }

    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.m;
    }

    public o getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        return null;
    }

    public View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.v;
    }

    @Deprecated
    public final z getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        w<?> wVar = this.mHost;
        if (wVar == null) {
            return null;
        }
        return b.l.d.m.this;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        w<?> wVar = this.mHost;
        if (wVar != null) {
            m.c cVar = (m.c) wVar;
            LayoutInflater cloneInContext = b.l.d.m.this.getLayoutInflater().cloneInContext(b.l.d.m.this);
            cloneInContext.setFactory2(this.mChildFragmentManager.f2183f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Override // b.o.i
    public b.o.f getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public b.p.a.a getLoaderManager() {
        return b.p.a.a.b(this);
    }

    public int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final z getParentFragmentManager() {
        z zVar = this.mFragmentManager;
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f230c;
    }

    public int getPopEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f233f;
    }

    public int getPopExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f234g;
    }

    public float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.u;
    }

    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // b.t.d
    public final b.t.b getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f2585b;
    }

    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.o;
    }

    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.i) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.j) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        z zVar = this.mFragmentManager;
        if (zVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return zVar.H(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public b.o.i getViewLifecycleOwner() {
        u0 u0Var = this.mViewLifecycleOwner;
        if (u0Var != null) {
            return u0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<b.o.i> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // b.o.a0
    public b.o.z getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        } else if (getMinimumMaxLifecycleState() != 1) {
            c0 c0Var = this.mFragmentManager.L;
            b.o.z zVar = c0Var.f1995c.get(this.mWho);
            if (zVar != null) {
                return zVar;
            }
            b.o.z zVar2 = new b.o.z();
            c0Var.f1995c.put(this.mWho, zVar2);
            return zVar2;
        } else {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new b.l.d.a0();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.y;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        z zVar;
        return this.mMenuVisible && ((zVar = this.mFragmentManager) == null || zVar.R(this.mParentFragment));
    }

    public boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.w;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        z zVar = this.mFragmentManager;
        if (zVar == null) {
            return false;
        }
        return zVar.T();
    }

    public final boolean isVisible() {
        View view;
        return isAdded() && !isHidden() && (view = this.mView) != null && view.getWindowToken() != null && this.mView.getVisibility() == 0;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.W();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (z.P(2)) {
            String str = "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent;
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        w<?> wVar = this.mHost;
        Activity activity = wVar == null ? null : wVar.f2142b;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.p < 1) {
            z = false;
        }
        if (!z) {
            this.mChildFragmentManager.n();
        }
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        w<?> wVar = this.mHost;
        Activity activity = wVar == null ? null : wVar.f2142b;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.W();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            restoreViewState();
            z zVar = this.mChildFragmentManager;
            zVar.D = false;
            zVar.E = false;
            zVar.L.f1999g = false;
            zVar.x(4);
            return;
        }
        throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        Iterator<k> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f2143c);
        if (this.mCalled) {
            z zVar = this.mFragmentManager;
            Iterator<d0> it2 = zVar.o.iterator();
            while (it2.hasNext()) {
                it2.next().a(zVar, this);
            }
            z zVar2 = this.mChildFragmentManager;
            zVar2.D = false;
            zVar2.E = false;
            zVar2.L.f1999g = false;
            zVar2.x(0);
            return;
        }
        throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onAttach()"));
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.l(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.m(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.W();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new b.o.g() {
            /* class androidx.fragment.app.Fragment.AnonymousClass5 */

            @Override // b.o.g
            public void d(b.o.i iVar, f.a aVar) {
                View view;
                if (aVar == f.a.ON_STOP && (view = Fragment.this.mView) != null) {
                    view.cancelPendingInputEvents();
                }
            }
        });
        this.mSavedStateRegistryController.a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.e(f.a.ON_CREATE);
            return;
        }
        throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onCreate()"));
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.o(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.W();
        boolean z = true;
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new u0();
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            u0 u0Var = this.mViewLifecycleOwner;
            if (u0Var.f2137b == null) {
                u0Var.f2137b = new b.o.j(u0Var);
                u0Var.f2138c = new b.t.c(u0Var);
            }
            this.mView.setTag(b.o.b0.a.view_tree_lifecycle_owner, this.mViewLifecycleOwner);
            this.mView.setTag(b.o.c0.a.view_tree_view_model_store_owner, this);
            this.mView.setTag(b.t.a.view_tree_saved_state_registry_owner, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.f2137b == null) {
            z = false;
        }
        if (!z) {
            this.mViewLifecycleOwner = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.p();
        this.mLifecycleRegistry.e(f.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.x(1);
        if (this.mView != null) {
            if (((b.o.j) this.mViewLifecycleOwner.getLifecycle()).f2221b.compareTo(f.b.CREATED) >= 0) {
                this.mViewLifecycleOwner.a(f.a.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            b.c cVar = ((b.p.a.b) b.p.a.a.b(this)).f2265b;
            int h2 = cVar.f2269a.h();
            for (int i2 = 0; i2 < h2; i2++) {
                b.o.i iVar = cVar.f2269a.i(i2).f2266a;
            }
            this.mPerformedCreateView = false;
            return;
        }
        throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            z zVar = this.mChildFragmentManager;
            if (!zVar.F) {
                zVar.p();
                this.mChildFragmentManager = new b.l.d.a0();
                return;
            }
            return;
        }
        throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onDetach()"));
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.q();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.r(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (!this.mHasMenu || !this.mMenuVisible || !onOptionsItemSelected(menuItem)) {
            return this.mChildFragmentManager.s(menuItem);
        }
        return true;
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.t(menu);
        }
    }

    public void performPause() {
        this.mChildFragmentManager.x(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(f.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(f.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.v(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.w(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean S = this.mFragmentManager.S(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != S) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(S);
            onPrimaryNavigationFragmentChanged(S);
            z zVar = this.mChildFragmentManager;
            zVar.p0();
            zVar.u(zVar.t);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.W();
        this.mChildFragmentManager.D(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            this.mLifecycleRegistry.e(f.a.ON_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(f.a.ON_RESUME);
            }
            z zVar = this.mChildFragmentManager;
            zVar.D = false;
            zVar.E = false;
            zVar.L.f1999g = false;
            zVar.x(7);
            return;
        }
        throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onResume()"));
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        Parcelable g0 = this.mChildFragmentManager.g0();
        if (g0 != null) {
            bundle.putParcelable(b.l.d.m.FRAGMENTS_TAG, g0);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.W();
        this.mChildFragmentManager.D(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            this.mLifecycleRegistry.e(f.a.ON_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(f.a.ON_START);
            }
            z zVar = this.mChildFragmentManager;
            zVar.D = false;
            zVar.E = false;
            zVar.L.f1999g = false;
            zVar.x(5);
            return;
        }
        throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onStart()"));
    }

    public void performStop() {
        z zVar = this.mChildFragmentManager;
        zVar.E = true;
        zVar.L.f1999g = true;
        zVar.x(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(f.a.ON_STOP);
        }
        this.mLifecycleRegistry.e(f.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.x(2);
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().w = true;
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().w = true;
        z zVar = this.mFragmentManager;
        if (zVar != null) {
            handler = zVar.q.f2144d;
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> b.a.e.c<I> registerForActivityResult(b.a.e.f.a<I, O> aVar, ActivityResultRegistry activityResultRegistry, b.a.e.b<O> bVar) {
        return prepareCallInternal(aVar, new f(this, activityResultRegistry), bVar);
    }

    public final <I, O> b.a.e.c<I> registerForActivityResult(b.a.e.f.a<I, O> aVar, b.a.e.b<O> bVar) {
        return prepareCallInternal(aVar, new e(), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i2) {
        if (this.mHost != null) {
            z parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.A != null) {
                parentFragmentManager.B.addLast(new z.k(this.mWho, i2));
                parentFragmentManager.A.a(strArr, null);
            } else if (parentFragmentManager.q == null) {
                throw null;
            }
        } else {
            throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not attached to Activity"));
        }
    }

    public final b.l.d.m requireActivity() {
        b.l.d.m activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final z requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable(b.l.d.m.FRAGMENTS_TAG)) != null) {
            this.mChildFragmentManager.f0(parcelable);
            this.mChildFragmentManager.n();
        }
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            u0 u0Var = this.mViewLifecycleOwner;
            u0Var.f2138c.a(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new y0(c.a.a.a.a.p("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.a(f.a.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().r = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().q = Boolean.valueOf(z);
    }

    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f228a = view;
    }

    public void setAnimations(int i2, int i3, int i4, int i5) {
        if (this.mAnimationInfo != null || i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
            ensureAnimationInfo().f231d = i2;
            ensureAnimationInfo().f232e = i3;
            ensureAnimationInfo().f233f = i4;
            ensureAnimationInfo().f234g = i5;
        }
    }

    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f229b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(o oVar) {
        ensureAnimationInfo();
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().k = obj;
    }

    public void setExitSharedElementCallback(o oVar) {
        ensureAnimationInfo();
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().m = obj;
    }

    public void setFocusedView(View view) {
        ensureAnimationInfo().v = view;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                b.l.d.m.this.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().y = z;
    }

    public void setInitialSavedState(m mVar) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (mVar == null || (bundle = mVar.f235b) == null) {
                bundle = null;
            }
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                b.l.d.m.this.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i2) {
        if (this.mAnimationInfo != null || i2 != 0) {
            ensureAnimationInfo();
            this.mAnimationInfo.h = i2;
        }
    }

    public void setOnStartEnterTransitionListener(l lVar) {
        ensureAnimationInfo();
        l lVar2 = this.mAnimationInfo.x;
        if (lVar != lVar2) {
            if (lVar == null || lVar2 == null) {
                i iVar = this.mAnimationInfo;
                if (iVar.w) {
                    iVar.x = lVar;
                }
                if (lVar != null) {
                    ((z.n) lVar).f2201c++;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo != null) {
            ensureAnimationInfo().f230c = z;
        }
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        ensureAnimationInfo().u = f2;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        z zVar = this.mFragmentManager;
        if (zVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            zVar.L.a(this);
        } else {
            zVar.L.b(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().o = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        iVar.i = arrayList;
        iVar.j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i2) {
        z zVar = this.mFragmentManager;
        z zVar2 = fragment != null ? fragment.mFragmentManager : null;
        if (zVar == null || zVar2 == null || zVar == zVar2) {
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
                if (fragment2.equals(this)) {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
            } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
                this.mTargetRequestCode = i2;
                return;
            } else {
                this.mTargetWho = fragment.mWho;
            }
            this.mTarget = null;
            this.mTargetRequestCode = i2;
            return;
        }
        throw new IllegalArgumentException(c.a.a.a.a.p("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            z zVar = this.mFragmentManager;
            zVar.X(zVar.i(this));
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        w<?> wVar = this.mHost;
        if (wVar != null) {
            return b.i.d.a.n(b.l.d.m.this, str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        w<?> wVar = this.mHost;
        if (wVar != null) {
            b.i.e.a.e(wVar.f2143c, intent, bundle);
            return;
        }
        throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.mHost != null) {
            z parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.y != null) {
                parentFragmentManager.B.addLast(new z.k(this.mWho, i2));
                if (!(intent == null || bundle == null)) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                parentFragmentManager.y.a(intent, null);
                return;
            }
            w<?> wVar = parentFragmentManager.q;
            if (wVar == null) {
                throw null;
            } else if (i2 == -1) {
                b.i.e.a.e(wVar.f2143c, intent, bundle);
            } else {
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        } else {
            throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not attached to Activity"));
        }
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Intent intent2 = intent;
        if (this.mHost != null) {
            if (z.P(2)) {
                String str = "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i2 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle;
            }
            z parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.z != null) {
                if (bundle != null) {
                    if (intent2 == null) {
                        intent2 = new Intent();
                        intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                    }
                    if (z.P(2)) {
                        String str2 = "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this;
                    }
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                b.a.e.e eVar = new b.a.e.e(intentSender, intent2, i3, i4);
                parentFragmentManager.B.addLast(new z.k(this.mWho, i2));
                if (z.P(2)) {
                    String str3 = "Fragment " + this + "is launching an IntentSender for result ";
                }
                parentFragmentManager.z.a(eVar, null);
                return;
            }
            w<?> wVar = parentFragmentManager.q;
            if (wVar == null) {
                throw null;
            } else if (i2 == -1) {
                b.i.d.a.p(wVar.f2142b, intentSender, i2, intent, i3, i4, i5, bundle);
            } else {
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        } else {
            throw new IllegalStateException(c.a.a.a.a.p("Fragment ", this, " not attached to Activity"));
        }
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null && ensureAnimationInfo().w) {
            if (this.mHost == null) {
                ensureAnimationInfo().w = false;
            } else if (Looper.myLooper() != this.mHost.f2144d.getLooper()) {
                this.mHost.f2144d.postAtFrontOfQueue(new b());
            } else {
                callStartTransitionListener(true);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) RecyclerView.a0.FLAG_IGNORE);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}
