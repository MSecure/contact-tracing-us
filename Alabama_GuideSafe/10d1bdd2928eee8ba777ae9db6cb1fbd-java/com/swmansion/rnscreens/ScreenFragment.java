package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayList;
import java.util.List;

public class ScreenFragment extends Fragment {
    public List<ScreenContainer> mChildScreenContainers = new ArrayList();
    public Screen mScreenView;

    public ScreenFragment() {
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public static View recycleView(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.endViewTransition(view);
            viewGroup.removeView(view);
        }
        view.setVisibility(0);
        return view;
    }

    public void dispatchOnAppear() {
        ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenAppearEvent(this.mScreenView.getId()));
        for (ScreenContainer screenContainer : this.mChildScreenContainers) {
            if (screenContainer.getScreenCount() > 0) {
                screenContainer.getScreenAt(screenContainer.getScreenCount() - 1).getFragment().dispatchOnAppear();
            }
        }
    }

    public void dispatchOnDisappear() {
        ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenDisappearEvent(this.mScreenView.getId()));
        for (ScreenContainer screenContainer : this.mChildScreenContainers) {
            if (screenContainer.getScreenCount() > 0) {
                screenContainer.getScreenAt(screenContainer.getScreenCount() - 1).getFragment().dispatchOnDisappear();
            }
        }
    }

    public void dispatchOnWillAppear() {
        ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenWillAppearEvent(this.mScreenView.getId()));
        for (ScreenContainer screenContainer : this.mChildScreenContainers) {
            if (screenContainer.getScreenCount() > 0) {
                screenContainer.getScreenAt(screenContainer.getScreenCount() - 1).getFragment().dispatchOnWillAppear();
            }
        }
    }

    public void dispatchOnWillDisappear() {
        ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenWillDisappearEvent(this.mScreenView.getId()));
        for (ScreenContainer screenContainer : this.mChildScreenContainers) {
            if (screenContainer.getScreenCount() > 0) {
                screenContainer.getScreenAt(screenContainer.getScreenCount() - 1).getFragment().dispatchOnWillDisappear();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mScreenView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Screen screen = this.mScreenView;
        recycleView(screen);
        frameLayout.addView(screen);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mCalled = true;
        ScreenContainer container = this.mScreenView.getContainer();
        if (container == null || !container.hasScreen(this)) {
            ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenDismissedEvent(this.mScreenView.getId()));
        }
        this.mChildScreenContainers.clear();
    }

    public void onViewAnimationEnd() {
        if (isResumed()) {
            dispatchOnAppear();
        } else {
            dispatchOnDisappear();
        }
    }

    @SuppressLint({"ValidFragment"})
    public ScreenFragment(Screen screen) {
        this.mScreenView = screen;
    }
}
