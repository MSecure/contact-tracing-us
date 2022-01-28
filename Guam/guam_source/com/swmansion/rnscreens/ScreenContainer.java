package com.swmansion.rnscreens;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import com.swmansion.rnscreens.ScreenFragment;
import java.util.ArrayList;
import java.util.HashSet;

public class ScreenContainer<T extends ScreenFragment> extends ViewGroup {
    public FragmentTransaction mCurrentTransaction;
    public FragmentManager mFragmentManager;
    public final ChoreographerCompat.FrameCallback mFrameCallback = new ChoreographerCompat.FrameCallback() {
        /* class com.swmansion.rnscreens.ScreenContainer.AnonymousClass1 */

        @Override // com.facebook.react.modules.core.ChoreographerCompat.FrameCallback
        public void doFrame(long j) {
            ScreenContainer.this.updateIfNeeded();
        }
    };
    public boolean mIsAttached;
    public final ChoreographerCompat.FrameCallback mLayoutCallback = new ChoreographerCompat.FrameCallback() {
        /* class com.swmansion.rnscreens.ScreenContainer.AnonymousClass2 */

        @Override // com.facebook.react.modules.core.ChoreographerCompat.FrameCallback
        public void doFrame(long j) {
            ScreenContainer screenContainer = ScreenContainer.this;
            screenContainer.mLayoutEnqueued = false;
            screenContainer.measure(View.MeasureSpec.makeMeasureSpec(screenContainer.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ScreenContainer.this.getHeight(), 1073741824));
            ScreenContainer screenContainer2 = ScreenContainer.this;
            screenContainer2.layout(screenContainer2.getLeft(), ScreenContainer.this.getTop(), ScreenContainer.this.getRight(), ScreenContainer.this.getBottom());
        }
    };
    public boolean mLayoutEnqueued = false;
    public boolean mNeedUpdate;
    public FragmentTransaction mProcessingTransaction;
    public final ArrayList<T> mScreenFragments = new ArrayList<>();

    public ScreenContainer(Context context) {
        super(context);
    }

    private void setFragmentManager(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        updateIfNeeded();
    }

    public T adapt(Screen screen) {
        return (T) new ScreenFragment(screen);
    }

    public FragmentTransaction getOrCreateTransaction() {
        if (this.mCurrentTransaction == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            if (fragmentManager != null) {
                BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
                this.mCurrentTransaction = backStackRecord;
                backStackRecord.mReorderingAllowed = true;
            } else {
                throw null;
            }
        }
        return this.mCurrentTransaction;
    }

    public Screen getScreenAt(int i) {
        return this.mScreenFragments.get(i).mScreenView;
    }

    public int getScreenCount() {
        return this.mScreenFragments.size();
    }

    public boolean hasScreen(ScreenFragment screenFragment) {
        return this.mScreenFragments.contains(screenFragment);
    }

    public void markUpdated() {
        if (!this.mNeedUpdate) {
            this.mNeedUpdate = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mFrameCallback);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    public void onAttachedToWindow() {
        boolean z;
        boolean z2;
        super.onAttachedToWindow();
        this.mIsAttached = true;
        this.mNeedUpdate = true;
        ViewParent viewParent = this;
        while (true) {
            z = viewParent instanceof ReactRootView;
            if (!z && !(viewParent instanceof Screen) && viewParent.getParent() != null) {
                viewParent = viewParent.getParent();
            }
        }
        if (viewParent instanceof Screen) {
            setFragmentManager(((Screen) viewParent).getFragment().getChildFragmentManager());
        } else if (z) {
            Context context = ((ReactRootView) viewParent).getContext();
            while (true) {
                z2 = context instanceof FragmentActivity;
                if (!z2 && (context instanceof ContextWrapper)) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else if (!z2) {
                    setFragmentManager(((FragmentActivity) context).getSupportFragmentManager());
                    return;
                } else {
                    throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity");
                }
            }
            if (!z2) {
            }
        } else {
            throw new IllegalStateException("ScreenContainer is not attached under ReactRootView");
        }
    }

    public void onDetachedFromWindow() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null && !fragmentManager.mDestroyed) {
            BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
            boolean z = false;
            for (Fragment fragment : this.mFragmentManager.getFragments()) {
                if ((fragment instanceof ScreenFragment) && ((ScreenFragment) fragment).mScreenView.getContainer() == this) {
                    backStackRecord.remove(fragment);
                    z = true;
                }
            }
            if (z) {
                backStackRecord.disallowAddToBackStack();
                backStackRecord.mManager.execSingleAction(backStackRecord, true);
            }
            FragmentManager fragmentManager2 = this.mFragmentManager;
            fragmentManager2.execPendingActions(true);
            fragmentManager2.forcePostponedTransactions();
        }
        super.onDetachedFromWindow();
        this.mIsAttached = false;
        removeAllViews();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(0, 0, getWidth(), getHeight());
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
        }
    }

    public void performUpdate() {
        HashSet hashSet = new HashSet(this.mFragmentManager.getFragments());
        int size = this.mScreenFragments.size();
        for (int i = 0; i < size; i++) {
            T t = this.mScreenFragments.get(i);
            if (!t.mScreenView.mActive && t.isAdded()) {
                getOrCreateTransaction().remove(t);
            }
            hashSet.remove(t);
        }
        if (!hashSet.isEmpty()) {
            Object[] array = hashSet.toArray();
            for (int i2 = 0; i2 < array.length; i2++) {
                if ((array[i2] instanceof ScreenFragment) && ((ScreenFragment) array[i2]).mScreenView.getContainer() == null) {
                    getOrCreateTransaction().remove((ScreenFragment) array[i2]);
                }
            }
        }
        int size2 = this.mScreenFragments.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.mScreenFragments.get(i4).mScreenView.mActive) {
                i3++;
            }
        }
        boolean z = i3 > 1;
        int size3 = this.mScreenFragments.size();
        boolean z2 = false;
        for (int i5 = 0; i5 < size3; i5++) {
            T t2 = this.mScreenFragments.get(i5);
            boolean z3 = t2.mScreenView.mActive;
            if (z3 && !t2.isAdded()) {
                getOrCreateTransaction().add(getId(), t2);
                z2 = true;
            } else if (z3 && z2) {
                FragmentTransaction orCreateTransaction = getOrCreateTransaction();
                orCreateTransaction.remove(t2);
                orCreateTransaction.add(getId(), t2);
            }
            t2.mScreenView.setTransitioning(z);
        }
        tryCommitTransaction();
    }

    public void removeAllScreens() {
        int size = this.mScreenFragments.size();
        for (int i = 0; i < size; i++) {
            this.mScreenFragments.get(i).mScreenView.setContainer(null);
        }
        this.mScreenFragments.clear();
        markUpdated();
    }

    public void removeScreenAt(int i) {
        this.mScreenFragments.get(i).mScreenView.setContainer(null);
        this.mScreenFragments.remove(i);
        markUpdated();
    }

    public void requestLayout() {
        super.requestLayout();
        if (!this.mLayoutEnqueued && this.mLayoutCallback != null) {
            this.mLayoutEnqueued = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mLayoutCallback);
        }
    }

    public void tryCommitTransaction() {
        final FragmentTransaction fragmentTransaction = this.mCurrentTransaction;
        if (fragmentTransaction != null) {
            this.mProcessingTransaction = fragmentTransaction;
            AnonymousClass3 r1 = new Runnable() {
                /* class com.swmansion.rnscreens.ScreenContainer.AnonymousClass3 */

                public void run() {
                    ScreenContainer screenContainer = ScreenContainer.this;
                    if (screenContainer.mProcessingTransaction == fragmentTransaction) {
                        screenContainer.mProcessingTransaction = null;
                    }
                }
            };
            fragmentTransaction.disallowAddToBackStack();
            if (fragmentTransaction.mCommitRunnables == null) {
                fragmentTransaction.mCommitRunnables = new ArrayList<>();
            }
            fragmentTransaction.mCommitRunnables.add(r1);
            this.mCurrentTransaction.commitAllowingStateLoss();
            this.mCurrentTransaction = null;
        }
    }

    public final void updateIfNeeded() {
        FragmentManager fragmentManager;
        if (this.mNeedUpdate && this.mIsAttached && (fragmentManager = this.mFragmentManager) != null) {
            this.mNeedUpdate = false;
            fragmentManager.execPendingActions(true);
            fragmentManager.forcePostponedTransactions();
            performUpdate();
        }
    }
}
