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

public class ScreenFragment extends Fragment {
    public Screen mScreenView;

    public ScreenFragment() {
        throw new IllegalStateException("Screen fragments should never be restored");
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
    }

    public void onViewAnimationEnd() {
        ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenAppearEvent(this.mScreenView.getId()));
    }

    @SuppressLint({"ValidFragment"})
    public ScreenFragment(Screen screen) {
        this.mScreenView = screen;
    }
}
