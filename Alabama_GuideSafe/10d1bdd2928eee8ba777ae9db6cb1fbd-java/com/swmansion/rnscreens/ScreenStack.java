package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.swmansion.rnscreens.Screen;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ScreenStack extends ScreenContainer<ScreenStackFragment> {
    public final FragmentManager.OnBackStackChangedListener mBackStackListener = new FragmentManager.OnBackStackChangedListener() {
        /* class com.swmansion.rnscreens.ScreenStack.AnonymousClass1 */

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public void onBackStackChanged() {
            ArrayList<BackStackRecord> arrayList = ScreenStack.this.mFragmentManager.mBackStack;
            if ((arrayList != null ? arrayList.size() : 0) == 0) {
                ScreenStack screenStack = ScreenStack.this;
                screenStack.mDismissed.add(screenStack.mTopScreen);
                screenStack.markUpdated();
            }
        }
    };
    public final Set<ScreenStackFragment> mDismissed = new HashSet();
    public final FragmentManager.FragmentLifecycleCallbacks mLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() {
        /* class com.swmansion.rnscreens.ScreenStack.AnonymousClass2 */
    };
    public boolean mRemovalTransitionStarted = false;
    public final ArrayList<ScreenStackFragment> mStack = new ArrayList<>();
    public ScreenStackFragment mTopScreen = null;

    public ScreenStack(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setupBackHandlerIfNeeded(ScreenStackFragment screenStackFragment) {
        ScreenStackFragment screenStackFragment2;
        if (this.mTopScreen.isResumed()) {
            FragmentManager fragmentManager = this.mFragmentManager;
            FragmentManager.OnBackStackChangedListener onBackStackChangedListener = this.mBackStackListener;
            ArrayList<FragmentManager.OnBackStackChangedListener> arrayList = fragmentManager.mBackStackChangeListeners;
            if (arrayList != null) {
                arrayList.remove(onBackStackChangedListener);
            }
            FragmentManager fragmentManager2 = this.mFragmentManager;
            int i = 0;
            fragmentManager2.enqueueAction(new FragmentManager.PopBackStackState("RN_SCREEN_LAST", -1, 1), false);
            int size = this.mStack.size();
            while (true) {
                if (i >= size) {
                    screenStackFragment2 = null;
                    break;
                }
                screenStackFragment2 = this.mStack.get(i);
                if (!this.mDismissed.contains(screenStackFragment2)) {
                    break;
                }
                i++;
            }
            if (screenStackFragment != screenStackFragment2 && screenStackFragment.mScreenView.mGestureEnabled) {
                FragmentManager fragmentManager3 = this.mFragmentManager;
                if (fragmentManager3 != null) {
                    BackStackRecord backStackRecord = new BackStackRecord(fragmentManager3);
                    FragmentManager fragmentManager4 = screenStackFragment.mFragmentManager;
                    if (fragmentManager4 == null || fragmentManager4 == backStackRecord.mManager) {
                        backStackRecord.addOp(new FragmentTransaction.Op(5, screenStackFragment));
                        if (backStackRecord.mAllowAddToBackStack) {
                            backStackRecord.mAddToBackStack = true;
                            backStackRecord.mName = "RN_SCREEN_LAST";
                            FragmentManager fragmentManager5 = screenStackFragment.mFragmentManager;
                            if (fragmentManager5 == null || fragmentManager5 == backStackRecord.mManager) {
                                backStackRecord.addOp(new FragmentTransaction.Op(8, screenStackFragment));
                                backStackRecord.commitAllowingStateLoss();
                                FragmentManager fragmentManager6 = this.mFragmentManager;
                                FragmentManager.OnBackStackChangedListener onBackStackChangedListener2 = this.mBackStackListener;
                                if (fragmentManager6.mBackStackChangeListeners == null) {
                                    fragmentManager6.mBackStackChangeListeners = new ArrayList<>();
                                }
                                fragmentManager6.mBackStackChangeListeners.add(onBackStackChangedListener2);
                                return;
                            }
                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
                            outline17.append(screenStackFragment.toString());
                            outline17.append(" is already attached to a FragmentManager.");
                            throw new IllegalStateException(outline17.toString());
                        }
                        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                    }
                    StringBuilder outline172 = GeneratedOutlineSupport.outline17("Cannot show Fragment attached to a different FragmentManager. Fragment ");
                    outline172.append(screenStackFragment.toString());
                    outline172.append(" is already attached to a FragmentManager.");
                    throw new IllegalStateException(outline172.toString());
                }
                throw null;
            }
        }
    }

    /* Return type fixed from 'com.swmansion.rnscreens.ScreenFragment' to match base method */
    @Override // com.swmansion.rnscreens.ScreenContainer
    public ScreenStackFragment adapt(Screen screen) {
        return new ScreenStackFragment(screen);
    }

    public final void dispatchOnFinishTransitioning() {
        ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new StackFinishTransitioningEvent(getId()));
    }

    public void endViewTransition(View view) {
        super.endViewTransition(view);
        if (this.mRemovalTransitionStarted) {
            this.mRemovalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public Screen getRootScreen() {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            Screen screenAt = getScreenAt(i);
            if (!this.mDismissed.contains(screenAt.getFragment())) {
                return screenAt;
            }
        }
        throw new IllegalStateException("Stack has no root screen set");
    }

    public Screen getTopScreen() {
        ScreenStackFragment screenStackFragment = this.mTopScreen;
        if (screenStackFragment != null) {
            return screenStackFragment.mScreenView;
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public boolean hasScreen(ScreenFragment screenFragment) {
        return this.mScreenFragments.contains(screenFragment) && !this.mDismissed.contains(screenFragment);
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFragmentManager.mLifecycleCallbacksDispatcher.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksDispatcher.FragmentLifecycleCallbacksHolder(this.mLifecycleCallbacks, false));
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void onDetachedFromWindow() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            FragmentManager.OnBackStackChangedListener onBackStackChangedListener = this.mBackStackListener;
            ArrayList<FragmentManager.OnBackStackChangedListener> arrayList = fragmentManager.mBackStackChangeListeners;
            if (arrayList != null) {
                arrayList.remove(onBackStackChangedListener);
            }
            FragmentManager fragmentManager2 = this.mFragmentManager;
            FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks = this.mLifecycleCallbacks;
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = fragmentManager2.mLifecycleCallbacksDispatcher;
            synchronized (fragmentLifecycleCallbacksDispatcher.mLifecycleCallbacks) {
                int size = fragmentLifecycleCallbacksDispatcher.mLifecycleCallbacks.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (fragmentLifecycleCallbacksDispatcher.mLifecycleCallbacks.get(i).mCallback == fragmentLifecycleCallbacks) {
                        fragmentLifecycleCallbacksDispatcher.mLifecycleCallbacks.remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (!this.mFragmentManager.isStateSaved()) {
                FragmentManager fragmentManager3 = this.mFragmentManager;
                fragmentManager3.enqueueAction(new FragmentManager.PopBackStackState("RN_SCREEN_LAST", -1, 1), false);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void performUpdate() {
        boolean z = true;
        int size = this.mScreenFragments.size() - 1;
        ScreenStackFragment screenStackFragment = null;
        final ScreenStackFragment screenStackFragment2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            ScreenStackFragment screenStackFragment3 = (ScreenStackFragment) this.mScreenFragments.get(size);
            if (!this.mDismissed.contains(screenStackFragment3)) {
                if (screenStackFragment2 != null) {
                    screenStackFragment = screenStackFragment3;
                    break;
                } else if (screenStackFragment3.mScreenView.getStackPresentation() != Screen.StackPresentation.TRANSPARENT_MODAL) {
                    screenStackFragment2 = screenStackFragment3;
                    break;
                } else {
                    screenStackFragment2 = screenStackFragment3;
                }
            }
            size--;
        }
        boolean contains = this.mStack.contains(screenStackFragment2);
        int i = 4099;
        int i2 = ReactTextInputManager.INPUT_TYPE_KEYBOARD_DECIMAL_PAD;
        if (!contains) {
            ScreenStackFragment screenStackFragment4 = this.mTopScreen;
            if (!(screenStackFragment4 == null || screenStackFragment2 == null)) {
                if (this.mScreenFragments.contains(screenStackFragment4) || screenStackFragment2.mScreenView.getReplaceAnimation() != Screen.ReplaceAnimation.POP) {
                    i2 = 4097;
                }
                int ordinal = screenStackFragment2.mScreenView.getStackAnimation().ordinal();
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            getOrCreateTransaction().setCustomAnimations(R$anim.rns_slide_in_from_right, R$anim.rns_slide_out_to_left);
                        } else if (ordinal != 4) {
                            i = i2;
                        } else {
                            getOrCreateTransaction().setCustomAnimations(R$anim.rns_slide_in_from_left, R$anim.rns_slide_out_to_right);
                        }
                    }
                    i2 = i;
                    z = false;
                } else {
                    z = false;
                    i2 = 0;
                }
                if (!z) {
                    getOrCreateTransaction().mTransition = i2;
                }
            }
        } else {
            ScreenStackFragment screenStackFragment5 = this.mTopScreen;
            if (screenStackFragment5 != null && !screenStackFragment5.equals(screenStackFragment2)) {
                int ordinal2 = this.mTopScreen.mScreenView.getStackAnimation().ordinal();
                if (ordinal2 != 1) {
                    if (ordinal2 != 2) {
                        if (ordinal2 == 3) {
                            getOrCreateTransaction().setCustomAnimations(R$anim.rns_slide_in_from_left, R$anim.rns_slide_out_to_right);
                        } else if (ordinal2 != 4) {
                            i = 8194;
                        } else {
                            getOrCreateTransaction().setCustomAnimations(R$anim.rns_slide_in_from_right, R$anim.rns_slide_out_to_left);
                        }
                    }
                    i2 = i;
                    z = false;
                } else {
                    z = false;
                    i2 = 0;
                }
                if (!z) {
                    getOrCreateTransaction().mTransition = i2;
                }
            }
        }
        Iterator<ScreenStackFragment> it = this.mStack.iterator();
        while (it.hasNext()) {
            ScreenStackFragment next = it.next();
            if (!this.mScreenFragments.contains(next) || this.mDismissed.contains(next)) {
                getOrCreateTransaction().remove(next);
            }
        }
        Iterator<T> it2 = this.mScreenFragments.iterator();
        while (it2.hasNext()) {
            ScreenStackFragment screenStackFragment6 = (ScreenStackFragment) it2.next();
            if (!(screenStackFragment6 == screenStackFragment2 || screenStackFragment6 == screenStackFragment || this.mDismissed.contains(screenStackFragment6))) {
                getOrCreateTransaction().remove(screenStackFragment6);
            }
        }
        if (screenStackFragment != null && !screenStackFragment.isAdded()) {
            FragmentTransaction orCreateTransaction = getOrCreateTransaction();
            orCreateTransaction.add(getId(), screenStackFragment);
            AnonymousClass3 r1 = new Runnable() {
                /* class com.swmansion.rnscreens.ScreenStack.AnonymousClass3 */

                public void run() {
                    screenStackFragment2.mScreenView.bringToFront();
                }
            };
            orCreateTransaction.disallowAddToBackStack();
            if (orCreateTransaction.mCommitRunnables == null) {
                orCreateTransaction.mCommitRunnables = new ArrayList<>();
            }
            orCreateTransaction.mCommitRunnables.add(r1);
        }
        if (screenStackFragment2 != null && !screenStackFragment2.isAdded()) {
            getOrCreateTransaction().add(getId(), screenStackFragment2);
        }
        this.mTopScreen = screenStackFragment2;
        this.mStack.clear();
        this.mStack.addAll(this.mScreenFragments);
        tryCommitTransaction();
        ScreenStackFragment screenStackFragment7 = this.mTopScreen;
        if (screenStackFragment7 != null) {
            setupBackHandlerIfNeeded(screenStackFragment7);
        }
        Iterator<ScreenStackFragment> it3 = this.mStack.iterator();
        while (it3.hasNext()) {
            View childAt = it3.next().mScreenView.getChildAt(0);
            if (childAt instanceof ScreenStackHeaderConfig) {
                ((ScreenStackHeaderConfig) childAt).onUpdate();
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeAllScreens() {
        this.mDismissed.clear();
        super.removeAllScreens();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeScreenAt(int i) {
        this.mDismissed.remove(this.mScreenFragments.get(i).mScreenView.getFragment());
        super.removeScreenAt(i);
    }

    public void startViewTransition(View view) {
        super.startViewTransition(view);
        this.mRemovalTransitionStarted = true;
    }
}
