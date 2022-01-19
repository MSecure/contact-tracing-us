package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.core.util.LogWriter;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider$KeyedFactory;
import androidx.lifecycle.ViewModelProvider$OnRequeryFactory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    public ArrayList<BackStackRecord> mBackStack;
    public ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    public final AtomicInteger mBackStackIndex = new AtomicInteger();
    public FragmentContainer mContainer;
    public ArrayList<Fragment> mCreatedMenus;
    public int mCurState = -1;
    public boolean mDestroyed;
    public Runnable mExecCommit = new Runnable() {
        /* class androidx.fragment.app.FragmentManager.AnonymousClass4 */

        public void run() {
            FragmentManager.this.execPendingActions(true);
        }
    };
    public boolean mExecutingActions;
    public ConcurrentHashMap<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals = new ConcurrentHashMap<>();
    public FragmentFactory mFragmentFactory = null;
    public final FragmentStore mFragmentStore = new FragmentStore();
    public final FragmentTransition.Callback mFragmentTransitionCallback = new FragmentTransition.Callback() {
        /* class androidx.fragment.app.FragmentManager.AnonymousClass2 */

        public void onComplete(Fragment fragment, CancellationSignal cancellationSignal) {
            boolean z;
            synchronized (cancellationSignal) {
                z = cancellationSignal.mIsCanceled;
            }
            if (!z) {
                FragmentManager fragmentManager = FragmentManager.this;
                HashSet<CancellationSignal> hashSet = fragmentManager.mExitAnimationCancellationSignals.get(fragment);
                if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
                    fragmentManager.mExitAnimationCancellationSignals.remove(fragment);
                    if (fragment.mState < 3) {
                        fragmentManager.destroyFragmentView(fragment);
                        fragmentManager.moveToState(fragment, fragment.getStateAfterAnimating());
                    }
                }
            }
        }

        public void onStart(Fragment fragment, CancellationSignal cancellationSignal) {
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.mExitAnimationCancellationSignals.get(fragment) == null) {
                fragmentManager.mExitAnimationCancellationSignals.put(fragment, new HashSet<>());
            }
            fragmentManager.mExitAnimationCancellationSignals.get(fragment).add(cancellationSignal);
        }
    };
    public boolean mHavePendingDeferredStart;
    public FragmentHostCallback<?> mHost;
    public FragmentFactory mHostFragmentFactory = new FragmentFactory() {
        /* class androidx.fragment.app.FragmentManager.AnonymousClass3 */

        @Override // androidx.fragment.app.FragmentFactory
        public Fragment instantiate(ClassLoader classLoader, String str) {
            FragmentHostCallback<?> fragmentHostCallback = FragmentManager.this.mHost;
            Context context = fragmentHostCallback.mContext;
            if (fragmentHostCallback != null) {
                return Fragment.instantiate(context, str, null);
            }
            throw null;
        }
    };
    public final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    public final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
    public boolean mNeedMenuInvalidate;
    public FragmentManagerViewModel mNonConfig;
    public final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) {
        /* class androidx.fragment.app.FragmentManager.AnonymousClass1 */
    };
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    public Fragment mParent;
    public final ArrayList<OpGenerator> mPendingActions = new ArrayList<>();
    public ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    public Fragment mPrimaryNav;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList<Fragment> mTmpAddedFragments;
    public ArrayList<Boolean> mTmpIsPop;
    public ArrayList<BackStackRecord> mTmpRecords;

    public static abstract class FragmentLifecycleCallbacks {
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    public interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class PopBackStackState implements OpGenerator {
        public final int mFlags;
        public final int mId;
        public final String mName;

        public PopBackStackState(String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.mPrimaryNav;
            if (fragment == null || this.mId >= 0 || this.mName != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
                return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
            }
            return false;
        }
    }

    public static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        public final boolean mIsBack;
        public int mNumPostponed;
        public final BackStackRecord mRecord;

        public StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void completeTransaction() {
            boolean z = this.mNumPostponed > 0;
            for (Fragment fragment : this.mRecord.mManager.getFragments()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z) {
                    Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
                    if (animationInfo == null ? false : animationInfo.mEnterTransitionPostponed) {
                        fragment.startPostponedEnterTransition();
                    }
                }
            }
            BackStackRecord backStackRecord = this.mRecord;
            backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, !z, true);
        }
    }

    public static boolean isLoggingEnabled(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public final void addAddedFragments(ArraySet<Fragment> arraySet) {
        int i = this.mCurState;
        if (i >= 1) {
            int min = Math.min(i, 3);
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment.mState < min) {
                    moveToState(fragment, min);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    public void addFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            String str = "add: " + fragment;
        }
        makeActive(fragment);
        if (!fragment.mDetached) {
            this.mFragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v19, resolved type: androidx.activity.OnBackPressedDispatcherOwner */
    /* JADX WARN: Multi-variable type inference failed */
    public void attachController(FragmentHostCallback<?> fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        ViewModel viewModel;
        if (this.mHost == null) {
            this.mHost = fragmentHostCallback;
            this.mContainer = fragmentContainer;
            this.mParent = fragment;
            if (fragment != null) {
                updateOnBackPressedCallbackEnabled();
            }
            if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
                this.mOnBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
                Fragment fragment2 = onBackPressedDispatcherOwner;
                if (fragment != null) {
                    fragment2 = fragment;
                }
                OnBackPressedDispatcher onBackPressedDispatcher = this.mOnBackPressedDispatcher;
                OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
                if (onBackPressedDispatcher != null) {
                    Lifecycle lifecycle = fragment2.getLifecycle();
                    if (((LifecycleRegistry) lifecycle).mState != Lifecycle.State.DESTROYED) {
                        onBackPressedCallback.mCancellables.add(new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
                    }
                } else {
                    throw null;
                }
            }
            if (fragment != null) {
                FragmentManagerViewModel fragmentManagerViewModel = fragment.mFragmentManager.mNonConfig;
                FragmentManagerViewModel fragmentManagerViewModel2 = fragmentManagerViewModel.mChildNonConfigs.get(fragment.mWho);
                if (fragmentManagerViewModel2 == null) {
                    fragmentManagerViewModel2 = new FragmentManagerViewModel(fragmentManagerViewModel.mStateAutomaticallySaved);
                    fragmentManagerViewModel.mChildNonConfigs.put(fragment.mWho, fragmentManagerViewModel2);
                }
                this.mNonConfig = fragmentManagerViewModel2;
            } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore();
                ViewModelProvider$Factory viewModelProvider$Factory = FragmentManagerViewModel.FACTORY;
                String canonicalName = FragmentManagerViewModel.class.getCanonicalName();
                if (canonicalName != null) {
                    String outline8 = GeneratedOutlineSupport.outline8("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    ViewModel viewModel2 = viewModelStore.mMap.get(outline8);
                    if (!FragmentManagerViewModel.class.isInstance(viewModel2)) {
                        if (viewModelProvider$Factory instanceof ViewModelProvider$KeyedFactory) {
                            viewModel = ((ViewModelProvider$KeyedFactory) viewModelProvider$Factory).create(outline8, FragmentManagerViewModel.class);
                        } else {
                            viewModel = ((FragmentManagerViewModel.AnonymousClass1) viewModelProvider$Factory).create(FragmentManagerViewModel.class);
                        }
                        viewModel2 = viewModel;
                        ViewModel put = viewModelStore.mMap.put(outline8, viewModel2);
                        if (put != null) {
                            put.onCleared();
                        }
                    } else if (viewModelProvider$Factory instanceof ViewModelProvider$OnRequeryFactory) {
                        ViewModelProvider$OnRequeryFactory viewModelProvider$OnRequeryFactory = (ViewModelProvider$OnRequeryFactory) viewModelProvider$Factory;
                    }
                    this.mNonConfig = (FragmentManagerViewModel) viewModel2;
                    return;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            } else {
                this.mNonConfig = new FragmentManagerViewModel(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void attachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            String str = "attach: " + fragment;
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.mFragmentStore.addFragment(fragment);
                if (isLoggingEnabled(2)) {
                    String str2 = "add from attach: " + fragment;
                }
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public final void cancelExitAnimation(Fragment fragment) {
        HashSet<CancellationSignal> hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null) {
            Iterator<CancellationSignal> it = hashSet.iterator();
            while (it.hasNext()) {
                CancellationSignal next = it.next();
                synchronized (next) {
                    if (!next.mIsCanceled) {
                        next.mIsCanceled = true;
                        next.mCancelInProgress = true;
                        CancellationSignal.OnCancelListener onCancelListener = next.mOnCancelListener;
                        if (onCancelListener != null) {
                            try {
                                ((FragmentAnim$1) onCancelListener).onCancel();
                            } catch (Throwable th) {
                                synchronized (next) {
                                    next.mCancelInProgress = false;
                                    next.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (next) {
                            next.mCancelInProgress = false;
                            next.notifyAll();
                        }
                    }
                }
            }
            hashSet.clear();
            destroyFragmentView(fragment);
            this.mExitAnimationCancellationSignals.remove(fragment);
        }
    }

    public final void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public void completeExecute(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.executePopOps(z3);
        } else {
            backStackRecord.executeOps();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, 0, 1, true, this.mFragmentTransitionCallback);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        Iterator it = ((ArrayList) this.mFragmentStore.getActiveFragments()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.interactsWith(fragment.mContainerId)) {
                float f = fragment.mPostponedAlpha;
                if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    fragment.mView.setAlpha(f);
                }
                if (z3) {
                    fragment.mPostponedAlpha = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public final void destroyFragmentView(Fragment fragment) {
        fragment.mChildFragmentManager.dispatchStateChange(1);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        fragment.mState = 1;
        fragment.mCalled = false;
        fragment.onDestroyView();
        if (fragment.mCalled) {
            LoaderManagerImpl.LoaderViewModel loaderViewModel = ((LoaderManagerImpl) LoaderManager.getInstance(fragment)).mLoaderViewModel;
            int size = loaderViewModel.mLoaders.size();
            for (int i = 0; i < size; i++) {
                LifecycleOwner lifecycleOwner = loaderViewModel.mLoaders.valueAt(i).mLifecycleOwner;
            }
            fragment.mPerformedCreateView = false;
            this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(fragment, false);
            fragment.mContainer = null;
            fragment.mView = null;
            fragment.mViewLifecycleOwner = null;
            fragment.mViewLifecycleOwnerLiveData.setValue(null);
            fragment.mInLayout = false;
            return;
        }
        throw new SuperNotCalledException(GeneratedOutlineSupport.outline7("Fragment ", fragment, " did not call through to super.onDestroyView()"));
    }

    public void detachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            String str = "detach: " + fragment;
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (isLoggingEnabled(2)) {
                    String str2 = "remove from detach: " + fragment;
                }
                this.mFragmentStore.removeFragment(fragment);
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.onConfigurationChanged(configuration);
                fragment.mChildFragmentManager.dispatchConfigurationChanged(configuration);
            }
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                if (!fragment.mHidden && (fragment.onContextItemSelected() || fragment.mChildFragmentManager.dispatchContextItemSelected(menuItem))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        boolean z = false;
        ArrayList<Fragment> arrayList = null;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                Fragment fragment2 = this.mCreatedMenus.get(i);
                if ((arrayList == null || !arrayList.contains(fragment2)) && fragment2 == null) {
                    throw null;
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            Iterator<Cancellable> it = this.mOnBackPressedCallback.mCancellables.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.mOnBackPressedDispatcher = null;
        }
    }

    public void dispatchLowMemory() {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.onMultiWindowModeChanged();
                fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(z);
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                if (!fragment.mHidden && fragment.mChildFragmentManager.dispatchOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState >= 1) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null && !fragment.mHidden) {
                    fragment.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null && fragment.equals(findActiveFragment(fragment.mWho))) {
            boolean isPrimaryNavigation = fragment.mFragmentManager.isPrimaryNavigation(fragment);
            Boolean bool = fragment.mIsPrimaryNavigationFragment;
            if (bool == null || bool.booleanValue() != isPrimaryNavigation) {
                fragment.mIsPrimaryNavigationFragment = Boolean.valueOf(isPrimaryNavigation);
                fragment.onPrimaryNavigationFragmentChanged();
                FragmentManager fragmentManager = fragment.mChildFragmentManager;
                fragmentManager.updateOnBackPressedCallbackEnabled();
                fragmentManager.dispatchParentPrimaryNavigationFragmentChanged(fragmentManager.mPrimaryNav);
            }
        }
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.onPictureInPictureModeChanged();
                fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: finally extract failed */
    public final void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.dispatchStateChange(i);
            moveToState(i, false);
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    public final void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String outline8 = GeneratedOutlineSupport.outline8(str, "    ");
        FragmentStore fragmentStore = this.mFragmentStore;
        if (fragmentStore != null) {
            String outline82 = GeneratedOutlineSupport.outline8(str, "    ");
            if (!fragmentStore.mActive.isEmpty()) {
                printWriter.print(str);
                printWriter.print("Active Fragments:");
                for (FragmentStateManager fragmentStateManager : fragmentStore.mActive.values()) {
                    printWriter.print(str);
                    if (fragmentStateManager != null) {
                        Fragment fragment = fragmentStateManager.mFragment;
                        printWriter.println(fragment);
                        fragment.dump(outline82, fileDescriptor, printWriter, strArr);
                    } else {
                        printWriter.println("null");
                    }
                }
            }
            int size3 = fragmentStore.mAdded.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (int i = 0; i < size3; i++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragmentStore.mAdded.get(i).toString());
                }
            }
            ArrayList<Fragment> arrayList = this.mCreatedMenus;
            if (arrayList != null && (size2 = arrayList.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i2 = 0; i2 < size2; i2++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(this.mCreatedMenus.get(i2).toString());
                }
            }
            ArrayList<BackStackRecord> arrayList2 = this.mBackStack;
            if (arrayList2 != null && (size = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i3 = 0; i3 < size; i3++) {
                    BackStackRecord backStackRecord = this.mBackStack.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(outline8, printWriter, true);
                }
            }
            printWriter.print(str);
            printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
            synchronized (this.mPendingActions) {
                int size4 = this.mPendingActions.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println((OpGenerator) this.mPendingActions.get(i4));
                    }
                }
            }
            printWriter.print(str);
            printWriter.println("FragmentManager misc state:");
            printWriter.print(str);
            printWriter.print("  mHost=");
            printWriter.println(this.mHost);
            printWriter.print(str);
            printWriter.print("  mContainer=");
            printWriter.println(this.mContainer);
            if (this.mParent != null) {
                printWriter.print(str);
                printWriter.print("  mParent=");
                printWriter.println(this.mParent);
            }
            printWriter.print(str);
            printWriter.print("  mCurState=");
            printWriter.print(this.mCurState);
            printWriter.print(" mStateSaved=");
            printWriter.print(this.mStateSaved);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            if (this.mNeedMenuInvalidate) {
                printWriter.print(str);
                printWriter.print("  mNeedMenuInvalidate=");
                printWriter.println(this.mNeedMenuInvalidate);
                return;
            }
            return;
        }
        throw null;
    }

    public final void endAnimatingAwayFragments() {
        if (!this.mExitAnimationCancellationSignals.isEmpty()) {
            for (Fragment fragment : this.mExitAnimationCancellationSignals.keySet()) {
                cancelExitAnimation(fragment);
                moveToState(fragment, fragment.getStateAfterAnimating());
            }
        }
    }

    public void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.mHost == null) {
                if (this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (isStateSaved()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.mPendingActions) {
            if (this.mHost != null) {
                this.mPendingActions.add(opGenerator);
                scheduleCommit();
            } else if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z || !isStateSaved()) {
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList<>();
                this.mTmpIsPop = new ArrayList<>();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction(null, null);
            } finally {
                this.mExecutingActions = false;
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean execPendingActions(boolean z) {
        boolean z2;
        ensureExecReady(z);
        boolean z3 = false;
        while (true) {
            ArrayList<BackStackRecord> arrayList = this.mTmpRecords;
            ArrayList<Boolean> arrayList2 = this.mTmpIsPop;
            synchronized (this.mPendingActions) {
                if (this.mPendingActions.isEmpty()) {
                    z2 = false;
                } else {
                    int size = this.mPendingActions.size();
                    z2 = false;
                    for (int i = 0; i < size; i++) {
                        z2 |= this.mPendingActions.get(i).generateOps(arrayList, arrayList2);
                    }
                    this.mPendingActions.clear();
                    this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                }
            }
            if (z2) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                    cleanupExec();
                    z3 = true;
                } catch (Throwable th) {
                    cleanupExec();
                    throw th;
                }
            } else {
                updateOnBackPressedCallbackEnabled();
                doPendingDeferredStart();
                this.mFragmentStore.burpActive();
                return z3;
            }
        }
    }

    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z);
            if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            updateOnBackPressedCallbackEnabled();
            doPendingDeferredStart();
            this.mFragmentStore.burpActive();
        }
    }

    public final void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        int i7;
        int i8;
        int i9;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z4 = arrayList.get(i).mReorderingAllowed;
        ArrayList<Fragment> arrayList4 = this.mTmpAddedFragments;
        if (arrayList4 == null) {
            this.mTmpAddedFragments = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment fragment = this.mPrimaryNav;
        int i10 = i;
        int i11 = 0;
        while (true) {
            int i12 = 1;
            if (i10 < i2) {
                BackStackRecord backStackRecord = arrayList.get(i10);
                int i13 = 3;
                if (!arrayList3.get(i10).booleanValue()) {
                    ArrayList<Fragment> arrayList5 = this.mTmpAddedFragments;
                    int i14 = 0;
                    while (i14 < backStackRecord.mOps.size()) {
                        FragmentTransaction.Op op = backStackRecord.mOps.get(i14);
                        int i15 = op.mCmd;
                        if (i15 != i12) {
                            if (i15 == 2) {
                                Fragment fragment2 = op.mFragment;
                                int i16 = fragment2.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z5 = false;
                                while (size >= 0) {
                                    Fragment fragment3 = arrayList5.get(size);
                                    if (fragment3.mContainerId != i16) {
                                        i9 = i16;
                                    } else if (fragment3 == fragment2) {
                                        i9 = i16;
                                        z5 = true;
                                    } else {
                                        if (fragment3 == fragment) {
                                            i9 = i16;
                                            backStackRecord.mOps.add(i14, new FragmentTransaction.Op(9, fragment3));
                                            i14++;
                                            fragment = null;
                                        } else {
                                            i9 = i16;
                                        }
                                        FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment3);
                                        op2.mEnterAnim = op.mEnterAnim;
                                        op2.mPopEnterAnim = op.mPopEnterAnim;
                                        op2.mExitAnim = op.mExitAnim;
                                        op2.mPopExitAnim = op.mPopExitAnim;
                                        backStackRecord.mOps.add(i14, op2);
                                        arrayList5.remove(fragment3);
                                        i14++;
                                    }
                                    size--;
                                    i16 = i9;
                                }
                                if (z5) {
                                    backStackRecord.mOps.remove(i14);
                                    i14--;
                                } else {
                                    i8 = 1;
                                    op.mCmd = 1;
                                    arrayList5.add(fragment2);
                                    i14 += i8;
                                    i12 = i8;
                                    i13 = 3;
                                }
                            } else if (i15 == i13 || i15 == 6) {
                                arrayList5.remove(op.mFragment);
                                Fragment fragment4 = op.mFragment;
                                if (fragment4 == fragment) {
                                    backStackRecord.mOps.add(i14, new FragmentTransaction.Op(9, fragment4));
                                    i14++;
                                    fragment = null;
                                }
                            } else if (i15 == 7) {
                                i8 = 1;
                            } else if (i15 == 8) {
                                backStackRecord.mOps.add(i14, new FragmentTransaction.Op(9, fragment));
                                i14++;
                                fragment = op.mFragment;
                            }
                            i8 = 1;
                            i14 += i8;
                            i12 = i8;
                            i13 = 3;
                        } else {
                            i8 = i12;
                        }
                        arrayList5.add(op.mFragment);
                        i14 += i8;
                        i12 = i8;
                        i13 = 3;
                    }
                    i7 = i12;
                } else {
                    i7 = 1;
                    ArrayList<Fragment> arrayList6 = this.mTmpAddedFragments;
                    for (int size2 = backStackRecord.mOps.size() - 1; size2 >= 0; size2--) {
                        FragmentTransaction.Op op3 = backStackRecord.mOps.get(size2);
                        int i17 = op3.mCmd;
                        if (i17 != 1) {
                            if (i17 != 3) {
                                switch (i17) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = op3.mFragment;
                                        break;
                                    case 10:
                                        op3.mCurrentMaxState = op3.mOldMaxState;
                                        break;
                                }
                            }
                            arrayList6.add(op3.mFragment);
                        }
                        arrayList6.remove(op3.mFragment);
                    }
                }
                i11 = (i11 != 0 || backStackRecord.mAddToBackStack) ? i7 : 0;
                i10++;
                arrayList3 = arrayList2;
            } else {
                this.mTmpAddedFragments.clear();
                if (!z4) {
                    z = true;
                    i3 = -1;
                    FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i2, false, this.mFragmentTransitionCallback);
                } else {
                    z = true;
                    i3 = -1;
                }
                int i18 = i;
                while (i18 < i2) {
                    BackStackRecord backStackRecord2 = arrayList.get(i18);
                    if (arrayList2.get(i18).booleanValue()) {
                        backStackRecord2.bumpBackStackNesting(i3);
                        backStackRecord2.executePopOps(i18 == i2 + -1 ? z : false);
                    } else {
                        int i19 = z ? 1 : 0;
                        int i20 = z ? 1 : 0;
                        int i21 = z ? 1 : 0;
                        backStackRecord2.bumpBackStackNesting(i19);
                        backStackRecord2.executeOps();
                    }
                    i18++;
                }
                if (z4) {
                    ArraySet<Fragment> arraySet = new ArraySet<>(0);
                    addAddedFragments(arraySet);
                    i4 = i;
                    int i22 = i2;
                    for (int i23 = i2 - 1; i23 >= i4; i23--) {
                        BackStackRecord backStackRecord3 = arrayList.get(i23);
                        boolean booleanValue = arrayList2.get(i23).booleanValue();
                        int i24 = 0;
                        while (true) {
                            if (i24 >= backStackRecord3.mOps.size()) {
                                z2 = false;
                            } else if (BackStackRecord.isFragmentPostponed(backStackRecord3.mOps.get(i24))) {
                                z2 = z;
                            } else {
                                i24++;
                            }
                        }
                        if (!z2 || backStackRecord3.interactsWith(arrayList, i23 + 1, i2)) {
                            z3 = false;
                        } else {
                            boolean z6 = z ? 1 : 0;
                            Object[] objArr = z ? 1 : 0;
                            Object[] objArr2 = z ? 1 : 0;
                            z3 = z6;
                        }
                        if (z3) {
                            if (this.mPostponedTransactions == null) {
                                this.mPostponedTransactions = new ArrayList<>();
                            }
                            StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord3, booleanValue);
                            this.mPostponedTransactions.add(startEnterTransitionListener);
                            for (int i25 = 0; i25 < backStackRecord3.mOps.size(); i25++) {
                                FragmentTransaction.Op op4 = backStackRecord3.mOps.get(i25);
                                if (BackStackRecord.isFragmentPostponed(op4)) {
                                    op4.mFragment.setOnStartEnterTransitionListener(startEnterTransitionListener);
                                }
                            }
                            if (booleanValue) {
                                backStackRecord3.executeOps();
                            } else {
                                backStackRecord3.executePopOps(false);
                            }
                            i22--;
                            if (i23 != i22) {
                                arrayList.remove(i23);
                                arrayList.add(i22, backStackRecord3);
                            }
                            addAddedFragments(arraySet);
                        }
                    }
                    i5 = 0;
                    int i26 = arraySet.mSize;
                    for (int i27 = 0; i27 < i26; i27++) {
                        Fragment fragment5 = (Fragment) arraySet.mArray[i27];
                        if (!fragment5.mAdded) {
                            View requireView = fragment5.requireView();
                            fragment5.mPostponedAlpha = requireView.getAlpha();
                            requireView.setAlpha(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                        }
                    }
                    i6 = i22;
                } else {
                    i4 = i;
                    i5 = 0;
                    i6 = i2;
                }
                if (i6 != i4 && z4) {
                    FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i6, true, this.mFragmentTransitionCallback);
                    moveToState(this.mCurState, z);
                }
                while (i4 < i2) {
                    BackStackRecord backStackRecord4 = arrayList.get(i4);
                    if (arrayList2.get(i4).booleanValue() && backStackRecord4.mIndex >= 0) {
                        backStackRecord4.mIndex = -1;
                    }
                    if (backStackRecord4.mCommitRunnables != null) {
                        for (int i28 = i5; i28 < backStackRecord4.mCommitRunnables.size(); i28++) {
                            backStackRecord4.mCommitRunnables.get(i28).run();
                        }
                        backStackRecord4.mCommitRunnables = null;
                    }
                    i4++;
                }
                if (!(i11 == 0 || this.mBackStackChangeListeners == null)) {
                    while (i5 < this.mBackStackChangeListeners.size()) {
                        this.mBackStackChangeListeners.get(i5).onBackStackChanged();
                        i5++;
                    }
                    return;
                }
                return;
            }
        }
    }

    public final void executePostponedTransaction(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<StartEnterTransitionListener> arrayList3 = this.mPostponedTransactions;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            StartEnterTransitionListener startEnterTransitionListener = this.mPostponedTransactions.get(i);
            if (arrayList == null || startEnterTransitionListener.mIsBack || (indexOf2 = arrayList.indexOf(startEnterTransitionListener.mRecord)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((startEnterTransitionListener.mNumPostponed == 0) || (arrayList != null && startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size()))) {
                    this.mPostponedTransactions.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || startEnterTransitionListener.mIsBack || (indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        startEnterTransitionListener.completeTransaction();
                    } else {
                        BackStackRecord backStackRecord = startEnterTransitionListener.mRecord;
                        backStackRecord.mManager.completeExecute(backStackRecord, startEnterTransitionListener.mIsBack, false, false);
                    }
                }
            } else {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                BackStackRecord backStackRecord2 = startEnterTransitionListener.mRecord;
                backStackRecord2.mManager.completeExecute(backStackRecord2, startEnterTransitionListener.mIsBack, false, false);
            }
            i++;
        }
    }

    public Fragment findActiveFragment(String str) {
        return this.mFragmentStore.findActiveFragment(str);
    }

    public Fragment findFragmentById(int i) {
        FragmentStore fragmentStore = this.mFragmentStore;
        int size = fragmentStore.mAdded.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = fragmentStore.mAdded.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            } else {
                for (FragmentStateManager fragmentStateManager : fragmentStore.mActive.values()) {
                    if (fragmentStateManager != null) {
                        Fragment fragment2 = fragmentStateManager.mFragment;
                        if (fragment2.mFragmentId == i) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public Fragment findFragmentByTag(String str) {
        FragmentStore fragmentStore = this.mFragmentStore;
        if (fragmentStore != null) {
            int size = fragmentStore.mAdded.size();
            while (true) {
                size--;
                if (size >= 0) {
                    Fragment fragment = fragmentStore.mAdded.get(size);
                    if (fragment != null && str.equals(fragment.mTag)) {
                        return fragment;
                    }
                } else {
                    for (FragmentStateManager fragmentStateManager : fragmentStore.mActive.values()) {
                        if (fragmentStateManager != null) {
                            Fragment fragment2 = fragmentStateManager.mFragment;
                            if (str.equals(fragment2.mTag)) {
                                return fragment2;
                            }
                        }
                    }
                    return null;
                }
            }
        } else {
            throw null;
        }
    }

    public Fragment findFragmentByWho(String str) {
        for (FragmentStateManager fragmentStateManager : this.mFragmentStore.mActive.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment = fragmentStateManager.mFragment;
                if (!str.equals(fragment.mWho)) {
                    fragment = fragment.mChildFragmentManager.findFragmentByWho(str);
                }
                if (fragment != null) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }

    public final ViewGroup getFragmentContainer(Fragment fragment) {
        if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
            View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    public void hideFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            String str = "hide: " + fragment;
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            setVisibleRemovingFragment(fragment);
        }
    }

    public final boolean isMenuAvailable(Fragment fragment) {
        boolean z;
        FragmentManager fragmentManager = fragment.mChildFragmentManager;
        Iterator it = ((ArrayList) fragmentManager.mFragmentStore.getActiveFragments()).iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z2 = fragmentManager.isMenuAvailable(fragment2);
                continue;
            }
            if (z2) {
                z = true;
                break;
            }
        }
        return z;
    }

    public boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.mPrimaryNav) || !isPrimaryNavigation(fragmentManager.mParent)) {
            return false;
        }
        return true;
    }

    public boolean isStateSaved() {
        return this.mStateSaved || this.mStopped;
    }

    public void makeActive(Fragment fragment) {
        boolean z;
        if (!this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
            FragmentStateManager fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragment);
            fragmentStateManager.restoreState(this.mHost.mContext.getClassLoader());
            this.mFragmentStore.mActive.put(fragmentStateManager.mFragment.mWho, fragmentStateManager);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (!fragment.mRetainInstance) {
                    removeRetainedFragment(fragment);
                } else if (!isStateSaved()) {
                    FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
                    if (fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho)) {
                        z = false;
                    } else {
                        fragmentManagerViewModel.mRetainedFragments.put(fragment.mWho, fragment);
                        z = true;
                    }
                    if (z && isLoggingEnabled(2)) {
                        String str = "Updating retained Fragments: Added " + fragment;
                    }
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            fragmentStateManager.mFragmentManagerState = this.mCurState;
            if (isLoggingEnabled(2)) {
                String str2 = "Added fragment to active set " + fragment;
            }
        }
    }

    public void moveFragmentToExpectedState(final Fragment fragment) {
        Animator animator;
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
            moveToState(fragment, this.mCurState);
            View view = fragment.mView;
            if (view != null) {
                FragmentStore fragmentStore = this.mFragmentStore;
                Fragment fragment2 = null;
                if (fragmentStore != null) {
                    ViewGroup viewGroup2 = fragment.mContainer;
                    if (viewGroup2 != null && view != null) {
                        int indexOf = fragmentStore.mAdded.indexOf(fragment);
                        while (true) {
                            indexOf--;
                            if (indexOf < 0) {
                                break;
                            }
                            Fragment fragment3 = fragmentStore.mAdded.get(indexOf);
                            if (fragment3.mContainer == viewGroup2 && fragment3.mView != null) {
                                fragment2 = fragment3;
                                break;
                            }
                        }
                    }
                    if (fragment2 != null && (indexOfChild2 = viewGroup.indexOfChild(fragment.mView)) < (indexOfChild = (viewGroup = fragment.mContainer).indexOfChild(fragment2.mView))) {
                        viewGroup.removeViewAt(indexOfChild2);
                        viewGroup.addView(fragment.mView, indexOfChild);
                    }
                    if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                        float f = fragment.mPostponedAlpha;
                        if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                            fragment.mView.setAlpha(f);
                        }
                        fragment.mPostponedAlpha = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                        fragment.mIsNewlyAdded = false;
                        FragmentAnim$AnimationOrAnimator loadAnimation = AppCompatDelegateImpl.ConfigurationImplApi17.loadAnimation(this.mHost.mContext, this.mContainer, fragment, true);
                        if (loadAnimation != null) {
                            Animation animation = loadAnimation.animation;
                            if (animation != null) {
                                fragment.mView.startAnimation(animation);
                            } else {
                                loadAnimation.animator.setTarget(fragment.mView);
                                loadAnimation.animator.start();
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
            if (fragment.mHiddenChanged) {
                if (fragment.mView != null) {
                    FragmentAnim$AnimationOrAnimator loadAnimation2 = AppCompatDelegateImpl.ConfigurationImplApi17.loadAnimation(this.mHost.mContext, this.mContainer, fragment, !fragment.mHidden);
                    if (loadAnimation2 == null || (animator = loadAnimation2.animator) == null) {
                        if (loadAnimation2 != null) {
                            fragment.mView.startAnimation(loadAnimation2.animation);
                            loadAnimation2.animation.start();
                        }
                        fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                        if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        }
                    } else {
                        animator.setTarget(fragment.mView);
                        if (!fragment.mHidden) {
                            fragment.mView.setVisibility(0);
                        } else if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        } else {
                            final ViewGroup viewGroup3 = fragment.mContainer;
                            final View view2 = fragment.mView;
                            viewGroup3.startViewTransition(view2);
                            loadAnimation2.animator.addListener(new AnimatorListenerAdapter(this) {
                                /* class androidx.fragment.app.FragmentManager.AnonymousClass5 */

                                public void onAnimationEnd(Animator animator) {
                                    viewGroup3.endViewTransition(view2);
                                    animator.removeListener(this);
                                    Fragment fragment = fragment;
                                    View view = fragment.mView;
                                    if (view != null && fragment.mHidden) {
                                        view.setVisibility(8);
                                    }
                                }
                            });
                        }
                        loadAnimation2.animator.start();
                    }
                }
                if (fragment.mAdded && isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mHiddenChanged = false;
                fragment.onHiddenChanged();
            }
        } else if (isLoggingEnabled(3)) {
            String str = "Ignoring moving " + fragment + " to state " + this.mCurState + "since it is not added to " + this;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
        if (r2 != 3) goto L_0x08ac;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:256:0x0608 */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0608 A[LOOP:0: B:256:0x0608->B:396:0x0608, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0211  */
    public void moveToState(Fragment fragment, int i) {
        boolean z;
        Fragment findActiveFragment;
        ViewGroup viewGroup;
        String str;
        Parcelable parcelable;
        FragmentStateManager fragmentStateManager = this.mFragmentStore.mActive.get(fragment.mWho);
        boolean z2 = true;
        if (fragmentStateManager == null) {
            fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragment);
            fragmentStateManager.mFragmentManagerState = 1;
        }
        int i2 = fragmentStateManager.mFragmentManagerState;
        Fragment fragment2 = fragmentStateManager.mFragment;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i2 = Math.max(i2, 1);
            } else if (i2 < 2) {
                i2 = Math.min(i2, fragment2.mState);
            } else {
                i2 = Math.min(i2, 1);
            }
        }
        if (!fragmentStateManager.mFragment.mAdded) {
            i2 = Math.min(i2, 1);
        }
        Fragment fragment3 = fragmentStateManager.mFragment;
        if (fragment3.mRemoving) {
            if (fragment3.isInBackStack()) {
                i2 = Math.min(i2, 1);
            } else {
                i2 = Math.min(i2, -1);
            }
        }
        Fragment fragment4 = fragmentStateManager.mFragment;
        if (fragment4.mDeferStart && fragment4.mState < 3) {
            i2 = Math.min(i2, 2);
        }
        int ordinal = fragmentStateManager.mFragment.mMaxState.ordinal();
        if (ordinal == 2) {
            i2 = Math.min(i2, 1);
        } else if (ordinal == 3) {
            i2 = Math.min(i2, 3);
        } else if (ordinal != 4) {
            i2 = Math.min(i2, -1);
        }
        int min = Math.min(i, i2);
        int i3 = fragment.mState;
        FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = null;
        if (i3 <= min) {
            if (i3 < min && !this.mExitAnimationCancellationSignals.isEmpty()) {
                cancelExitAnimation(fragment);
            }
            int i4 = fragment.mState;
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                        }
                        if (min > 2) {
                            if (isLoggingEnabled(3)) {
                                StringBuilder outline15 = GeneratedOutlineSupport.outline15("moveto STARTED: ");
                                outline15.append(fragmentStateManager.mFragment);
                                outline15.toString();
                            }
                            Fragment fragment5 = fragmentStateManager.mFragment;
                            fragment5.mChildFragmentManager.noteStateNotSaved();
                            fragment5.mChildFragmentManager.execPendingActions(true);
                            fragment5.mState = 3;
                            fragment5.mCalled = false;
                            fragment5.onStart();
                            if (fragment5.mCalled) {
                                fragment5.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                                if (fragment5.mView != null) {
                                    fragment5.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
                                }
                                FragmentManager fragmentManager = fragment5.mChildFragmentManager;
                                fragmentManager.mStateSaved = false;
                                fragmentManager.mStopped = false;
                                fragmentManager.dispatchStateChange(3);
                                fragmentStateManager.mDispatcher.dispatchOnFragmentStarted(fragmentStateManager.mFragment, false);
                            } else {
                                throw new SuperNotCalledException(GeneratedOutlineSupport.outline7("Fragment ", fragment5, " did not call through to super.onStart()"));
                            }
                        }
                        if (min > 3) {
                            if (isLoggingEnabled(3)) {
                                StringBuilder outline152 = GeneratedOutlineSupport.outline15("moveto RESUMED: ");
                                outline152.append(fragmentStateManager.mFragment);
                                outline152.toString();
                            }
                            Fragment fragment6 = fragmentStateManager.mFragment;
                            fragment6.mChildFragmentManager.noteStateNotSaved();
                            fragment6.mChildFragmentManager.execPendingActions(true);
                            fragment6.mState = 4;
                            fragment6.mCalled = false;
                            fragment6.onResume();
                            if (fragment6.mCalled) {
                                fragment6.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                                if (fragment6.mView != null) {
                                    fragment6.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                                }
                                FragmentManager fragmentManager2 = fragment6.mChildFragmentManager;
                                fragmentManager2.mStateSaved = false;
                                fragmentManager2.mStopped = false;
                                fragmentManager2.dispatchStateChange(4);
                                fragmentStateManager.mDispatcher.dispatchOnFragmentResumed(fragmentStateManager.mFragment, false);
                                Fragment fragment7 = fragmentStateManager.mFragment;
                                fragment7.mSavedFragmentState = null;
                                fragment7.mSavedViewState = null;
                            } else {
                                throw new SuperNotCalledException(GeneratedOutlineSupport.outline7("Fragment ", fragment6, " did not call through to super.onResume()"));
                            }
                        }
                    }
                    if (min > -1) {
                        Fragment fragment8 = fragmentStateManager.mFragment;
                        if (fragment8.mFromLayout && fragment8.mInLayout && !fragment8.mPerformedCreateView) {
                            if (isLoggingEnabled(3)) {
                                StringBuilder outline153 = GeneratedOutlineSupport.outline15("moveto CREATE_VIEW: ");
                                outline153.append(fragmentStateManager.mFragment);
                                outline153.toString();
                            }
                            Fragment fragment9 = fragmentStateManager.mFragment;
                            LayoutInflater onGetLayoutInflater = fragment9.onGetLayoutInflater(fragment9.mSavedFragmentState);
                            fragment9.mLayoutInflater = onGetLayoutInflater;
                            fragment9.performCreateView(onGetLayoutInflater, null, fragmentStateManager.mFragment.mSavedFragmentState);
                            View view = fragmentStateManager.mFragment.mView;
                            if (view != null) {
                                view.setSaveFromParentEnabled(false);
                                Fragment fragment10 = fragmentStateManager.mFragment;
                                fragment10.mView.setTag(R$id.fragment_container_view_tag, fragment10);
                                Fragment fragment11 = fragmentStateManager.mFragment;
                                if (fragment11.mHidden) {
                                    fragment11.mView.setVisibility(8);
                                }
                                Fragment fragment12 = fragmentStateManager.mFragment;
                                fragment12.onViewCreated(fragment12.mView, fragment12.mSavedFragmentState);
                                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = fragmentStateManager.mDispatcher;
                                Fragment fragment13 = fragmentStateManager.mFragment;
                                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment13, fragment13.mView, fragment13.mSavedFragmentState, false);
                            }
                        }
                    }
                    if (min > 1) {
                        FragmentContainer fragmentContainer = this.mContainer;
                        if (!fragmentStateManager.mFragment.mFromLayout) {
                            if (isLoggingEnabled(3)) {
                                StringBuilder outline154 = GeneratedOutlineSupport.outline15("moveto CREATE_VIEW: ");
                                outline154.append(fragmentStateManager.mFragment);
                                outline154.toString();
                            }
                            Fragment fragment14 = fragmentStateManager.mFragment;
                            ViewGroup viewGroup2 = fragment14.mContainer;
                            if (viewGroup2 == null) {
                                int i5 = fragment14.mContainerId;
                                if (i5 == 0) {
                                    viewGroup2 = null;
                                } else if (i5 != -1) {
                                    viewGroup2 = (ViewGroup) fragmentContainer.onFindViewById(i5);
                                    if (viewGroup2 == null) {
                                        Fragment fragment15 = fragmentStateManager.mFragment;
                                        if (!fragment15.mRestored) {
                                            try {
                                                str = fragment15.getResources().getResourceName(fragmentStateManager.mFragment.mContainerId);
                                            } catch (Resources.NotFoundException unused) {
                                                str = "unknown";
                                            }
                                            StringBuilder outline155 = GeneratedOutlineSupport.outline15("No view found for id 0x");
                                            outline155.append(Integer.toHexString(fragmentStateManager.mFragment.mContainerId));
                                            outline155.append(" (");
                                            outline155.append(str);
                                            outline155.append(") for fragment ");
                                            outline155.append(fragmentStateManager.mFragment);
                                            throw new IllegalArgumentException(outline155.toString());
                                        }
                                    }
                                } else {
                                    StringBuilder outline156 = GeneratedOutlineSupport.outline15("Cannot create fragment ");
                                    outline156.append(fragmentStateManager.mFragment);
                                    outline156.append(" for a container view with no id");
                                    throw new IllegalArgumentException(outline156.toString());
                                }
                            }
                            Fragment fragment16 = fragmentStateManager.mFragment;
                            fragment16.mContainer = viewGroup2;
                            LayoutInflater onGetLayoutInflater2 = fragment16.onGetLayoutInflater(fragment16.mSavedFragmentState);
                            fragment16.mLayoutInflater = onGetLayoutInflater2;
                            fragment16.performCreateView(onGetLayoutInflater2, viewGroup2, fragmentStateManager.mFragment.mSavedFragmentState);
                            View view2 = fragmentStateManager.mFragment.mView;
                            if (view2 != null) {
                                view2.setSaveFromParentEnabled(false);
                                Fragment fragment17 = fragmentStateManager.mFragment;
                                fragment17.mView.setTag(R$id.fragment_container_view_tag, fragment17);
                                if (viewGroup2 != null) {
                                    viewGroup2.addView(fragmentStateManager.mFragment.mView);
                                }
                                Fragment fragment18 = fragmentStateManager.mFragment;
                                if (fragment18.mHidden) {
                                    fragment18.mView.setVisibility(8);
                                }
                                ViewCompat.requestApplyInsets(fragmentStateManager.mFragment.mView);
                                Fragment fragment19 = fragmentStateManager.mFragment;
                                fragment19.onViewCreated(fragment19.mView, fragment19.mSavedFragmentState);
                                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher2 = fragmentStateManager.mDispatcher;
                                Fragment fragment20 = fragmentStateManager.mFragment;
                                fragmentLifecycleCallbacksDispatcher2.dispatchOnFragmentViewCreated(fragment20, fragment20.mView, fragment20.mSavedFragmentState, false);
                                Fragment fragment21 = fragmentStateManager.mFragment;
                                fragment21.mIsNewlyAdded = fragment21.mView.getVisibility() == 0 && fragmentStateManager.mFragment.mContainer != null;
                            }
                        }
                        if (isLoggingEnabled(3)) {
                            StringBuilder outline157 = GeneratedOutlineSupport.outline15("moveto ACTIVITY_CREATED: ");
                            outline157.append(fragmentStateManager.mFragment);
                            outline157.toString();
                        }
                        Fragment fragment22 = fragmentStateManager.mFragment;
                        Bundle bundle = fragment22.mSavedFragmentState;
                        fragment22.mChildFragmentManager.noteStateNotSaved();
                        fragment22.mState = 2;
                        fragment22.mCalled = false;
                        fragment22.onActivityCreated(bundle);
                        if (fragment22.mCalled) {
                            FragmentManager fragmentManager3 = fragment22.mChildFragmentManager;
                            fragmentManager3.mStateSaved = false;
                            fragmentManager3.mStopped = false;
                            fragmentManager3.dispatchStateChange(2);
                            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher3 = fragmentStateManager.mDispatcher;
                            Fragment fragment23 = fragmentStateManager.mFragment;
                            fragmentLifecycleCallbacksDispatcher3.dispatchOnFragmentActivityCreated(fragment23, fragment23.mSavedFragmentState, false);
                            if (isLoggingEnabled(3)) {
                                StringBuilder outline158 = GeneratedOutlineSupport.outline15("moveto RESTORE_VIEW_STATE: ");
                                outline158.append(fragmentStateManager.mFragment);
                                outline158.toString();
                            }
                            Fragment fragment24 = fragmentStateManager.mFragment;
                            View view3 = fragment24.mView;
                            if (view3 != null) {
                                SparseArray<Parcelable> sparseArray = fragment24.mSavedViewState;
                                if (sparseArray != null) {
                                    view3.restoreHierarchyState(sparseArray);
                                    fragment24.mSavedViewState = null;
                                }
                                fragment24.mCalled = false;
                                fragment24.onViewStateRestored();
                                if (!fragment24.mCalled) {
                                    throw new SuperNotCalledException(GeneratedOutlineSupport.outline7("Fragment ", fragment24, " did not call through to super.onViewStateRestored()"));
                                } else if (fragment24.mView != null) {
                                    fragment24.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
                                }
                            }
                            fragmentStateManager.mFragment.mSavedFragmentState = null;
                        } else {
                            throw new SuperNotCalledException(GeneratedOutlineSupport.outline7("Fragment ", fragment22, " did not call through to super.onActivityCreated()"));
                        }
                    }
                    if (min > 2) {
                    }
                    if (min > 3) {
                    }
                }
            } else if (min > -1) {
                if (isLoggingEnabled(3)) {
                    String str2 = "moveto ATTACHED: " + fragment;
                }
                Fragment fragment25 = fragment.mTarget;
                if (fragment25 != null) {
                    if (fragment25.equals(findActiveFragment(fragment25.mWho))) {
                        Fragment fragment26 = fragment.mTarget;
                        if (fragment26.mState < 1) {
                            moveToState(fragment26, 1);
                        }
                        fragment.mTargetWho = fragment.mTarget.mWho;
                        fragment.mTarget = null;
                    } else {
                        throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
                    }
                }
                String str3 = fragment.mTargetWho;
                if (str3 != null) {
                    Fragment findActiveFragment2 = this.mFragmentStore.findActiveFragment(str3);
                    if (findActiveFragment2 == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Fragment ");
                        sb.append(fragment);
                        sb.append(" declared target fragment ");
                        throw new IllegalStateException(GeneratedOutlineSupport.outline12(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
                    } else if (findActiveFragment2.mState < 1) {
                        moveToState(findActiveFragment2, 1);
                    }
                }
                FragmentHostCallback<?> fragmentHostCallback = this.mHost;
                Fragment fragment27 = this.mParent;
                Fragment fragment28 = fragmentStateManager.mFragment;
                fragment28.mHost = fragmentHostCallback;
                fragment28.mParentFragment = fragment27;
                fragment28.mFragmentManager = this;
                fragmentStateManager.mDispatcher.dispatchOnFragmentPreAttached(fragment28, fragmentHostCallback.mContext, false);
                Fragment fragment29 = fragmentStateManager.mFragment;
                fragment29.mChildFragmentManager.attachController(fragment29.mHost, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x015a: INVOKE  
                      (wrap: androidx.fragment.app.FragmentManager : 0x0151: IGET  (r10v29 androidx.fragment.app.FragmentManager) = (r9v43 'fragment29' androidx.fragment.app.Fragment) androidx.fragment.app.Fragment.mChildFragmentManager androidx.fragment.app.FragmentManager)
                      (wrap: androidx.fragment.app.FragmentHostCallback<?> : 0x0153: IGET  (r11v13 androidx.fragment.app.FragmentHostCallback<?>) = (r9v43 'fragment29' androidx.fragment.app.Fragment) androidx.fragment.app.Fragment.mHost androidx.fragment.app.FragmentHostCallback)
                      (wrap: androidx.fragment.app.Fragment$4 : 0x0157: CONSTRUCTOR  (r12v1 androidx.fragment.app.Fragment$4) = (r9v43 'fragment29' androidx.fragment.app.Fragment) call: androidx.fragment.app.Fragment.4.<init>(androidx.fragment.app.Fragment):void type: CONSTRUCTOR)
                      (r9v43 'fragment29' androidx.fragment.app.Fragment)
                     type: VIRTUAL call: androidx.fragment.app.FragmentManager.attachController(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void in method: androidx.fragment.app.FragmentManager.moveToState(androidx.fragment.app.Fragment, int):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0157: CONSTRUCTOR  (r12v1 androidx.fragment.app.Fragment$4) = (r9v43 'fragment29' androidx.fragment.app.Fragment) call: androidx.fragment.app.Fragment.4.<init>(androidx.fragment.app.Fragment):void type: CONSTRUCTOR in method: androidx.fragment.app.FragmentManager.moveToState(androidx.fragment.app.Fragment, int):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 26 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.fragment.app.Fragment, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 32 more
                    */
                /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
                    if (r2 != 3) goto L_0x08ac;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:256:0x0608 */
                /* JADX WARNING: Removed duplicated region for block: B:111:0x0277  */
                /* JADX WARNING: Removed duplicated region for block: B:173:0x0409  */
                /* JADX WARNING: Removed duplicated region for block: B:185:0x0469  */
                /* JADX WARNING: Removed duplicated region for block: B:256:0x0608 A[LOOP:0: B:256:0x0608->B:396:0x0608, LOOP_START, SYNTHETIC] */
                /* JADX WARNING: Removed duplicated region for block: B:95:0x0211  */
                /*
                // Method dump skipped, instructions count: 2268
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.moveToState(androidx.fragment.app.Fragment, int):void");
            }

            public void noteStateNotSaved() {
                if (this.mHost != null) {
                    this.mStateSaved = false;
                    this.mStopped = false;
                    for (Fragment fragment : this.mFragmentStore.getFragments()) {
                        if (fragment != null) {
                            fragment.mChildFragmentManager.noteStateNotSaved();
                        }
                    }
                }
            }

            public boolean popBackStackImmediate() {
                execPendingActions(false);
                ensureExecReady(true);
                Fragment fragment = this.mPrimaryNav;
                if (fragment != null && fragment.getChildFragmentManager().popBackStackImmediate()) {
                    return true;
                }
                boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, null, -1, 0);
                if (popBackStackState) {
                    this.mExecutingActions = true;
                    try {
                        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                    } finally {
                        cleanupExec();
                    }
                }
                updateOnBackPressedCallbackEnabled();
                doPendingDeferredStart();
                this.mFragmentStore.burpActive();
                return popBackStackState;
            }

            public boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
                ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
                if (arrayList3 == null) {
                    return false;
                }
                if (str == null && i < 0 && (i2 & 1) == 0) {
                    int size = arrayList3.size() - 1;
                    if (size < 0) {
                        return false;
                    }
                    arrayList.add(this.mBackStack.remove(size));
                    arrayList2.add(Boolean.TRUE);
                } else {
                    int i3 = -1;
                    if (str != null || i >= 0) {
                        int size2 = this.mBackStack.size() - 1;
                        while (size2 >= 0) {
                            BackStackRecord backStackRecord = this.mBackStack.get(size2);
                            if ((str != null && str.equals(backStackRecord.mName)) || (i >= 0 && i == backStackRecord.mIndex)) {
                                break;
                            }
                            size2--;
                        }
                        if (size2 < 0) {
                            return false;
                        }
                        if ((i2 & 1) != 0) {
                            while (true) {
                                size2--;
                                if (size2 < 0) {
                                    break;
                                }
                                BackStackRecord backStackRecord2 = this.mBackStack.get(size2);
                                if ((str == null || !str.equals(backStackRecord2.mName)) && (i < 0 || i != backStackRecord2.mIndex)) {
                                    break;
                                }
                            }
                        }
                        i3 = size2;
                    }
                    if (i3 == this.mBackStack.size() - 1) {
                        return false;
                    }
                    for (int size3 = this.mBackStack.size() - 1; size3 > i3; size3--) {
                        arrayList.add(this.mBackStack.remove(size3));
                        arrayList2.add(Boolean.TRUE);
                    }
                }
                return true;
            }

            public void removeFragment(Fragment fragment) {
                if (isLoggingEnabled(2)) {
                    String str = "remove: " + fragment + " nesting=" + fragment.mBackStackNesting;
                }
                boolean z = !fragment.isInBackStack();
                if (!fragment.mDetached || z) {
                    this.mFragmentStore.removeFragment(fragment);
                    if (isMenuAvailable(fragment)) {
                        this.mNeedMenuInvalidate = true;
                    }
                    fragment.mRemoving = true;
                    setVisibleRemovingFragment(fragment);
                }
            }

            public final void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
                if (!arrayList.isEmpty()) {
                    if (arrayList.size() == arrayList2.size()) {
                        executePostponedTransaction(arrayList, arrayList2);
                        int size = arrayList.size();
                        int i = 0;
                        int i2 = 0;
                        while (i < size) {
                            if (!arrayList.get(i).mReorderingAllowed) {
                                if (i2 != i) {
                                    executeOpsTogether(arrayList, arrayList2, i2, i);
                                }
                                i2 = i + 1;
                                if (arrayList2.get(i).booleanValue()) {
                                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).mReorderingAllowed) {
                                        i2++;
                                    }
                                }
                                executeOpsTogether(arrayList, arrayList2, i, i2);
                                i = i2 - 1;
                            }
                            i++;
                        }
                        if (i2 != size) {
                            executeOpsTogether(arrayList, arrayList2, i2, size);
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("Internal error with the back stack records");
                }
            }

            public void removeRetainedFragment(Fragment fragment) {
                if (!isStateSaved()) {
                    if ((this.mNonConfig.mRetainedFragments.remove(fragment.mWho) != null) && isLoggingEnabled(2)) {
                        String str = "Updating retained Fragments: Removed " + fragment;
                    }
                }
            }

            public void restoreSaveState(Parcelable parcelable) {
                FragmentStateManager fragmentStateManager;
                if (parcelable != null) {
                    FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
                    if (fragmentManagerState.mActive != null) {
                        this.mFragmentStore.mActive.clear();
                        Iterator<FragmentState> it = fragmentManagerState.mActive.iterator();
                        while (it.hasNext()) {
                            FragmentState next = it.next();
                            if (next != null) {
                                Fragment fragment = this.mNonConfig.mRetainedFragments.get(next.mWho);
                                if (fragment != null) {
                                    if (isLoggingEnabled(2)) {
                                        String str = "restoreSaveState: re-attaching retained " + fragment;
                                    }
                                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragment, next);
                                } else {
                                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mHost.mContext.getClassLoader(), getFragmentFactory(), next);
                                }
                                Fragment fragment2 = fragmentStateManager.mFragment;
                                fragment2.mFragmentManager = this;
                                if (isLoggingEnabled(2)) {
                                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("restoreSaveState: active (");
                                    outline15.append(fragment2.mWho);
                                    outline15.append("): ");
                                    outline15.append(fragment2);
                                    outline15.toString();
                                }
                                fragmentStateManager.restoreState(this.mHost.mContext.getClassLoader());
                                this.mFragmentStore.mActive.put(fragmentStateManager.mFragment.mWho, fragmentStateManager);
                                fragmentStateManager.mFragmentManagerState = this.mCurState;
                            }
                        }
                        for (Fragment fragment3 : this.mNonConfig.mRetainedFragments.values()) {
                            if (!this.mFragmentStore.containsActiveFragment(fragment3.mWho)) {
                                if (isLoggingEnabled(2)) {
                                    String str2 = "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive;
                                }
                                moveToState(fragment3, 1);
                                fragment3.mRemoving = true;
                                moveToState(fragment3, -1);
                            }
                        }
                        FragmentStore fragmentStore = this.mFragmentStore;
                        ArrayList<String> arrayList = fragmentManagerState.mAdded;
                        fragmentStore.mAdded.clear();
                        if (arrayList != null) {
                            for (String str3 : arrayList) {
                                Fragment findActiveFragment = fragmentStore.findActiveFragment(str3);
                                if (findActiveFragment != null) {
                                    if (isLoggingEnabled(2)) {
                                        String str4 = "restoreSaveState: added (" + str3 + "): " + findActiveFragment;
                                    }
                                    fragmentStore.addFragment(findActiveFragment);
                                } else {
                                    throw new IllegalStateException(GeneratedOutlineSupport.outline9("No instantiated fragment for (", str3, ")"));
                                }
                            }
                        }
                        if (fragmentManagerState.mBackStack != null) {
                            this.mBackStack = new ArrayList<>(fragmentManagerState.mBackStack.length);
                            int i = 0;
                            while (true) {
                                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                                if (i >= backStackStateArr.length) {
                                    break;
                                }
                                BackStackState backStackState = backStackStateArr[i];
                                if (backStackState != null) {
                                    BackStackRecord backStackRecord = new BackStackRecord(this);
                                    int i2 = 0;
                                    int i3 = 0;
                                    while (i2 < backStackState.mOps.length) {
                                        FragmentTransaction.Op op = new FragmentTransaction.Op();
                                        int i4 = i2 + 1;
                                        op.mCmd = backStackState.mOps[i2];
                                        if (isLoggingEnabled(2)) {
                                            String str5 = "Instantiate " + backStackRecord + " op #" + i3 + " base fragment #" + backStackState.mOps[i4];
                                        }
                                        String str6 = backStackState.mFragmentWhos.get(i3);
                                        if (str6 != null) {
                                            op.mFragment = this.mFragmentStore.findActiveFragment(str6);
                                        } else {
                                            op.mFragment = null;
                                        }
                                        op.mOldMaxState = Lifecycle.State.values()[backStackState.mOldMaxLifecycleStates[i3]];
                                        op.mCurrentMaxState = Lifecycle.State.values()[backStackState.mCurrentMaxLifecycleStates[i3]];
                                        int[] iArr = backStackState.mOps;
                                        int i5 = i4 + 1;
                                        int i6 = iArr[i4];
                                        op.mEnterAnim = i6;
                                        int i7 = i5 + 1;
                                        int i8 = iArr[i5];
                                        op.mExitAnim = i8;
                                        int i9 = i7 + 1;
                                        int i10 = iArr[i7];
                                        op.mPopEnterAnim = i10;
                                        int i11 = iArr[i9];
                                        op.mPopExitAnim = i11;
                                        backStackRecord.mEnterAnim = i6;
                                        backStackRecord.mExitAnim = i8;
                                        backStackRecord.mPopEnterAnim = i10;
                                        backStackRecord.mPopExitAnim = i11;
                                        backStackRecord.addOp(op);
                                        i3++;
                                        i2 = i9 + 1;
                                    }
                                    backStackRecord.mTransition = backStackState.mTransition;
                                    backStackRecord.mName = backStackState.mName;
                                    backStackRecord.mIndex = backStackState.mIndex;
                                    backStackRecord.mAddToBackStack = true;
                                    backStackRecord.mBreadCrumbTitleRes = backStackState.mBreadCrumbTitleRes;
                                    backStackRecord.mBreadCrumbTitleText = backStackState.mBreadCrumbTitleText;
                                    backStackRecord.mBreadCrumbShortTitleRes = backStackState.mBreadCrumbShortTitleRes;
                                    backStackRecord.mBreadCrumbShortTitleText = backStackState.mBreadCrumbShortTitleText;
                                    backStackRecord.mSharedElementSourceNames = backStackState.mSharedElementSourceNames;
                                    backStackRecord.mSharedElementTargetNames = backStackState.mSharedElementTargetNames;
                                    backStackRecord.mReorderingAllowed = backStackState.mReorderingAllowed;
                                    backStackRecord.bumpBackStackNesting(1);
                                    if (isLoggingEnabled(2)) {
                                        StringBuilder outline16 = GeneratedOutlineSupport.outline16("restoreAllState: back stack #", i, " (index ");
                                        outline16.append(backStackRecord.mIndex);
                                        outline16.append("): ");
                                        outline16.append(backStackRecord);
                                        outline16.toString();
                                        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                                        backStackRecord.dump("  ", printWriter, false);
                                        printWriter.close();
                                    }
                                    this.mBackStack.add(backStackRecord);
                                    i++;
                                } else {
                                    throw null;
                                }
                            }
                        } else {
                            this.mBackStack = null;
                        }
                        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
                        String str7 = fragmentManagerState.mPrimaryNavActiveWho;
                        if (str7 != null) {
                            Fragment findActiveFragment2 = this.mFragmentStore.findActiveFragment(str7);
                            this.mPrimaryNav = findActiveFragment2;
                            dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment2);
                        }
                    }
                }
            }

            public Parcelable saveAllState() {
                int i;
                ArrayList<String> arrayList;
                int size;
                forcePostponedTransactions();
                endAnimatingAwayFragments();
                execPendingActions(true);
                this.mStateSaved = true;
                FragmentStore fragmentStore = this.mFragmentStore;
                BackStackState[] backStackStateArr = null;
                if (fragmentStore != null) {
                    ArrayList<FragmentState> arrayList2 = new ArrayList<>(fragmentStore.mActive.size());
                    Iterator<FragmentStateManager> it = fragmentStore.mActive.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        FragmentStateManager next = it.next();
                        if (next != null) {
                            Fragment fragment = next.mFragment;
                            FragmentState fragmentState = new FragmentState(fragment);
                            if (next.mFragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
                                fragmentState.mSavedFragmentState = next.mFragment.mSavedFragmentState;
                            } else {
                                Bundle bundle = new Bundle();
                                Fragment fragment2 = next.mFragment;
                                fragment2.onSaveInstanceState(bundle);
                                fragment2.mSavedStateRegistryController.performSave(bundle);
                                Parcelable saveAllState = fragment2.mChildFragmentManager.saveAllState();
                                if (saveAllState != null) {
                                    bundle.putParcelable("android:support:fragments", saveAllState);
                                }
                                next.mDispatcher.dispatchOnFragmentSaveInstanceState(next.mFragment, bundle, false);
                                if (bundle.isEmpty()) {
                                    bundle = null;
                                }
                                if (next.mFragment.mView != null) {
                                    next.saveViewState();
                                }
                                if (next.mFragment.mSavedViewState != null) {
                                    if (bundle == null) {
                                        bundle = new Bundle();
                                    }
                                    bundle.putSparseParcelableArray("android:view_state", next.mFragment.mSavedViewState);
                                }
                                if (!next.mFragment.mUserVisibleHint) {
                                    if (bundle == null) {
                                        bundle = new Bundle();
                                    }
                                    bundle.putBoolean("android:user_visible_hint", next.mFragment.mUserVisibleHint);
                                }
                                fragmentState.mSavedFragmentState = bundle;
                                if (next.mFragment.mTargetWho != null) {
                                    if (bundle == null) {
                                        fragmentState.mSavedFragmentState = new Bundle();
                                    }
                                    fragmentState.mSavedFragmentState.putString("android:target_state", next.mFragment.mTargetWho);
                                    int i2 = next.mFragment.mTargetRequestCode;
                                    if (i2 != 0) {
                                        fragmentState.mSavedFragmentState.putInt("android:target_req_state", i2);
                                    }
                                }
                            }
                            arrayList2.add(fragmentState);
                            if (isLoggingEnabled(2)) {
                                String str = "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState;
                            }
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        return null;
                    }
                    FragmentStore fragmentStore2 = this.mFragmentStore;
                    synchronized (fragmentStore2.mAdded) {
                        if (fragmentStore2.mAdded.isEmpty()) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList<>(fragmentStore2.mAdded.size());
                            Iterator<Fragment> it2 = fragmentStore2.mAdded.iterator();
                            while (it2.hasNext()) {
                                Fragment next2 = it2.next();
                                arrayList.add(next2.mWho);
                                if (isLoggingEnabled(2)) {
                                    String str2 = "saveAllState: adding fragment (" + next2.mWho + "): " + next2;
                                }
                            }
                        }
                    }
                    ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
                    if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                        backStackStateArr = new BackStackState[size];
                        for (i = 0; i < size; i++) {
                            backStackStateArr[i] = new BackStackState(this.mBackStack.get(i));
                            if (isLoggingEnabled(2)) {
                                StringBuilder outline16 = GeneratedOutlineSupport.outline16("saveAllState: adding back stack #", i, ": ");
                                outline16.append(this.mBackStack.get(i));
                                outline16.toString();
                            }
                        }
                    }
                    FragmentManagerState fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.mActive = arrayList2;
                    fragmentManagerState.mAdded = arrayList;
                    fragmentManagerState.mBackStack = backStackStateArr;
                    fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
                    Fragment fragment3 = this.mPrimaryNav;
                    if (fragment3 != null) {
                        fragmentManagerState.mPrimaryNavActiveWho = fragment3.mWho;
                    }
                    return fragmentManagerState;
                }
                throw null;
            }

            public void scheduleCommit() {
                synchronized (this.mPendingActions) {
                    boolean z = false;
                    boolean z2 = this.mPostponedTransactions != null && !this.mPostponedTransactions.isEmpty();
                    if (this.mPendingActions.size() == 1) {
                        z = true;
                    }
                    if (z2 || z) {
                        this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                        this.mHost.mHandler.post(this.mExecCommit);
                        updateOnBackPressedCallbackEnabled();
                    }
                }
            }

            public void setExitAnimationOrder(Fragment fragment, boolean z) {
                ViewGroup fragmentContainer = getFragmentContainer(fragment);
                if (fragmentContainer != null && (fragmentContainer instanceof FragmentContainerView)) {
                    ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
                }
            }

            public void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
                if (!fragment.equals(findActiveFragment(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
                    throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
                }
                fragment.mMaxState = state;
            }

            public void setPrimaryNavigationFragment(Fragment fragment) {
                if (fragment == null || (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
                    Fragment fragment2 = this.mPrimaryNav;
                    this.mPrimaryNav = fragment;
                    dispatchParentPrimaryNavigationFragmentChanged(fragment2);
                    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
                    return;
                }
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }

            public final void setVisibleRemovingFragment(Fragment fragment) {
                ViewGroup fragmentContainer = getFragmentContainer(fragment);
                if (fragmentContainer != null) {
                    if (fragmentContainer.getTag(R$id.visible_removing_fragment_view_tag) == null) {
                        fragmentContainer.setTag(R$id.visible_removing_fragment_view_tag, fragment);
                    }
                    ((Fragment) fragmentContainer.getTag(R$id.visible_removing_fragment_view_tag)).setNextAnim(fragment.getNextAnim());
                }
            }

            public void showFragment(Fragment fragment) {
                if (isLoggingEnabled(2)) {
                    String str = "show: " + fragment;
                }
                if (fragment.mHidden) {
                    fragment.mHidden = false;
                    fragment.mHiddenChanged = !fragment.mHiddenChanged;
                }
            }

            public final void startPendingDeferredFragments() {
                Iterator it = ((ArrayList) this.mFragmentStore.getActiveFragments()).iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    if (fragment != null && fragment.mDeferStart) {
                        if (this.mExecutingActions) {
                            this.mHavePendingDeferredStart = true;
                        } else {
                            fragment.mDeferStart = false;
                            moveToState(fragment, this.mCurState);
                        }
                    }
                }
            }

            public String toString() {
                StringBuilder sb = new StringBuilder(128);
                sb.append("FragmentManager{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" in ");
                Fragment fragment = this.mParent;
                if (fragment != null) {
                    sb.append(fragment.getClass().getSimpleName());
                    sb.append("{");
                    sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
                    sb.append("}");
                } else {
                    FragmentHostCallback<?> fragmentHostCallback = this.mHost;
                    if (fragmentHostCallback != null) {
                        sb.append(fragmentHostCallback.getClass().getSimpleName());
                        sb.append("{");
                        sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                        sb.append("}");
                    } else {
                        sb.append("null");
                    }
                }
                sb.append("}}");
                return sb.toString();
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
                if (r1 == null) goto L_0x001f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
                r1 = r1.size();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
                r1 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
                if (r1 <= 0) goto L_0x002b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
                if (isPrimaryNavigation(r4.mParent) == false) goto L_0x002b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
                r0.mEnabled = r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
                r0 = r4.mOnBackPressedCallback;
                r1 = r4.mBackStack;
             */
            public final void updateOnBackPressedCallbackEnabled() {
                synchronized (this.mPendingActions) {
                    boolean z = true;
                    if (!this.mPendingActions.isEmpty()) {
                        this.mOnBackPressedCallback.mEnabled = true;
                    }
                }
            }

            public void moveToState(int i, boolean z) {
                FragmentHostCallback<?> fragmentHostCallback;
                if (this.mHost == null && i != -1) {
                    throw new IllegalStateException("No activity");
                } else if (z || i != this.mCurState) {
                    this.mCurState = i;
                    for (Fragment fragment : this.mFragmentStore.getFragments()) {
                        moveFragmentToExpectedState(fragment);
                    }
                    Iterator it = ((ArrayList) this.mFragmentStore.getActiveFragments()).iterator();
                    while (it.hasNext()) {
                        Fragment fragment2 = (Fragment) it.next();
                        if (fragment2 != null && !fragment2.mIsNewlyAdded) {
                            moveFragmentToExpectedState(fragment2);
                        }
                    }
                    startPendingDeferredFragments();
                    if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 4) {
                        FragmentActivity.this.supportInvalidateOptionsMenu();
                        this.mNeedMenuInvalidate = false;
                    }
                }
            }
        }
