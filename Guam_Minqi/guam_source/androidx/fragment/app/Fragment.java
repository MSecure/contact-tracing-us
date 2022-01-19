package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    public static final Object USE_DEFAULT_TRANSITION = new Object();
    public boolean mAdded;
    public AnimationInfo mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    public boolean mCalled;
    public FragmentManager mChildFragmentManager = new FragmentManagerImpl();
    public ViewGroup mContainer;
    public int mContainerId;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public FragmentManager mFragmentManager;
    public boolean mFromLayout;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public FragmentHostCallback<?> mHost;
    public boolean mInLayout;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    public Boolean mIsPrimaryNavigationFragment = null;
    public LayoutInflater mLayoutInflater;
    public LifecycleRegistry mLifecycleRegistry;
    public Lifecycle.State mMaxState = Lifecycle.State.RESUMED;
    public boolean mMenuVisible = true;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public SavedStateRegistryController mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState = -1;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho = null;
    public boolean mUserVisibleHint = true;
    public View mView;
    public FragmentViewLifecycleOwner mViewLifecycleOwner;
    public MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData = new MutableLiveData<>();
    public String mWho = UUID.randomUUID().toString();

    public static class AnimationInfo {
        public Boolean mAllowEnterTransitionOverlap;
        public Boolean mAllowReturnTransitionOverlap;
        public View mAnimatingAway;
        public Animator mAnimator;
        public Object mEnterTransition = null;
        public SharedElementCallback mEnterTransitionCallback;
        public boolean mEnterTransitionPostponed;
        public Object mExitTransition;
        public SharedElementCallback mExitTransitionCallback;
        public boolean mIsHideReplaced;
        public int mNextAnim;
        public int mNextTransition;
        public Object mReenterTransition;
        public Object mReturnTransition;
        public Object mSharedElementEnterTransition;
        public Object mSharedElementReturnTransition;
        public OnStartEnterTransitionListener mStartEnterTransitionListener;
        public int mStateAfterAnimating;

        public AnimationInfo() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = obj;
            this.mExitTransition = null;
            this.mReenterTransition = obj;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = obj;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public interface OnStartEnterTransitionListener {
    }

    public Fragment() {
        initLifecycle();
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e) {
            throw new InstantiationException(GeneratedOutlineSupport.outline9("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException(GeneratedOutlineSupport.outline9("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException(GeneratedOutlineSupport.outline9("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException(GeneratedOutlineSupport.outline9("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public void callStartTransitionListener() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        Object obj = null;
        if (animationInfo != null) {
            animationInfo.mEnterTransitionPostponed = false;
            Object obj2 = animationInfo.mStartEnterTransitionListener;
            animationInfo.mStartEnterTransitionListener = null;
            obj = obj2;
        }
        if (obj != null) {
            FragmentManager.StartEnterTransitionListener startEnterTransitionListener = (FragmentManager.StartEnterTransitionListener) obj;
            int i = startEnterTransitionListener.mNumPostponed - 1;
            startEnterTransitionListener.mNumPostponed = i;
            if (i == 0) {
                startEnterTransitionListener.mRecord.mManager.scheduleCommit();
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
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
        printWriter.println(false);
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
        Fragment fragment = this.mTarget;
        if (fragment == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragment = (fragmentManager == null || (str2 = this.mTargetWho) == null) ? null : fragmentManager.findActiveFragment(str2);
        }
        if (fragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
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
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ColorPropConverter.PACKAGE_DELIMITER);
        this.mChildFragmentManager.dump(GeneratedOutlineSupport.outline8(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.mActivity;
    }

    public View getAnimatingAway() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mAnimatingAway;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline7("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.mContext;
    }

    public Object getEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransition;
    }

    public void getEnterTransitionCallback() {
        if (this.mAnimationInfo == null) {
        }
    }

    public Object getExitTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransition;
    }

    public void getExitTransitionCallback() {
        if (this.mAnimationInfo == null) {
        }
    }

    @Deprecated
    public LayoutInflater getLayoutInflater() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            FragmentActivity.HostCallbacks hostCallbacks = (FragmentActivity.HostCallbacks) fragmentHostCallback;
            LayoutInflater cloneInContext = FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
            cloneInContext.setFactory2(this.mChildFragmentManager.mLayoutInflaterFactory);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public int getNextAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mNextAnim;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline7("Fragment ", this, " not associated with a fragment manager."));
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.mRegistry;
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mSharedElementEnterTransition;
    }

    public int getStateAfterAnimating() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mStateAfterAnimating;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            FragmentManagerViewModel fragmentManagerViewModel = fragmentManager.mNonConfig;
            ViewModelStore viewModelStore = fragmentManagerViewModel.mViewModelStores.get(this.mWho);
            if (viewModelStore != null) {
                return viewModelStore;
            }
            ViewModelStore viewModelStore2 = new ViewModelStore();
            fragmentManagerViewModel.mViewModelStores.put(this.mWho, viewModelStore2);
            return viewModelStore2;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = new SavedStateRegistryController(this);
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() {
            /* class androidx.fragment.app.Fragment.AnonymousClass2 */

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                View view;
                if (event == Lifecycle.Event.ON_STOP && (view = Fragment.this.mView) != null) {
                    view.cancelPendingInputEvents();
                }
            }
        });
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public boolean isHideReplaced() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mIsHideReplaced;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isRemovingParent() {
        Fragment fragment = this.mParentFragment;
        return fragment != null && (fragment.mRemoving || fragment.isRemovingParent());
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttach(Context context) {
        Activity activity;
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            activity = null;
        } else {
            activity = fragmentHostCallback.mActivity;
        }
        if (activity != null) {
            this.mCalled = false;
            onAttach();
        }
    }

    public void onAttachFragment() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        Parcelable parcelable;
        boolean z = true;
        this.mCalled = true;
        if (!(bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null)) {
            this.mChildFragmentManager.restoreSaveState(parcelable);
            this.mChildFragmentManager.dispatchCreate();
        }
        if (this.mChildFragmentManager.mCurState < 1) {
            z = false;
        }
        if (!z) {
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator() {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline7("Fragment ", this, " not attached to an activity."));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater();
    }

    public void onHiddenChanged() {
    }

    public void onInflate(AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            activity = null;
        } else {
            activity = fragmentHostCallback.mActivity;
        }
        if (activity != null) {
            this.mCalled = false;
            onInflate();
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged() {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged() {
    }

    public void onPrimaryNavigationFragmentChanged() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
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

    public void onViewStateRestored() {
        this.mCalled = true;
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (!this.mHidden) {
            return false | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
        }
        return false;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        boolean z = true;
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner();
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
            if (fragmentViewLifecycleOwner.mLifecycleRegistry == null) {
                fragmentViewLifecycleOwner.mLifecycleRegistry = new LifecycleRegistry(fragmentViewLifecycleOwner);
            }
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.mLifecycleRegistry == null) {
            z = false;
        }
        if (!z) {
            this.mViewLifecycleOwner = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        if (!this.mHidden) {
            return false | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
        }
        return false;
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline7("Fragment ", this, " not attached to a context."));
    }

    public final View requireView() {
        View view = this.mView;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline7("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void setAnimatingAway(View view) {
        ensureAnimationInfo().mAnimatingAway = view;
    }

    public void setAnimator(Animator animator) {
        ensureAnimationInfo().mAnimator = animator;
    }

    public void setArguments(Bundle bundle) {
        boolean z;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            if (fragmentManager == null) {
                z = false;
            } else {
                z = fragmentManager.isStateSaved();
            }
            if (z) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.mArguments = bundle;
    }

    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().mIsHideReplaced = z;
    }

    public void setNextAnim(int i) {
        if (this.mAnimationInfo != null || i != 0) {
            ensureAnimationInfo().mNextAnim = i;
        }
    }

    public void setOnStartEnterTransitionListener(OnStartEnterTransitionListener onStartEnterTransitionListener) {
        ensureAnimationInfo();
        OnStartEnterTransitionListener onStartEnterTransitionListener2 = this.mAnimationInfo.mStartEnterTransitionListener;
        if (onStartEnterTransitionListener != onStartEnterTransitionListener2) {
            if (onStartEnterTransitionListener == null || onStartEnterTransitionListener2 == null) {
                AnimationInfo animationInfo = this.mAnimationInfo;
                if (animationInfo.mEnterTransitionPostponed) {
                    animationInfo.mStartEnterTransitionListener = onStartEnterTransitionListener;
                }
                if (onStartEnterTransitionListener != null) {
                    ((FragmentManager.StartEnterTransitionListener) onStartEnterTransitionListener).mNumPostponed++;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void setStateAfterAnimating(int i) {
        ensureAnimationInfo().mStateAfterAnimating = i;
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }
        return false;
    }

    public void startPostponedEnterTransition() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || fragmentManager.mHost == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != this.mFragmentManager.mHost.mHandler.getLooper()) {
            this.mFragmentManager.mHost.mHandler.postAtFrontOfQueue(new Runnable() {
                /* class androidx.fragment.app.Fragment.AnonymousClass3 */

                public void run() {
                    Fragment.this.callStartTransitionListener();
                }
            });
        } else {
            callStartTransitionListener();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    @Deprecated
    public void onAttach() {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate() {
        this.mCalled = true;
    }
}
