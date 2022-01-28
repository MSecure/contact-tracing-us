package com.th3rdwave.safeareacontext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.view.ReactViewGroup;
import com.horcrux.svg.PathParser;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public class SafeAreaView extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {
    public EnumSet<SafeAreaViewEdges> mEdges;
    public EdgeInsets mInsets;
    public SafeAreaViewMode mMode = SafeAreaViewMode.PADDING;
    public View mProviderView;

    public SafeAreaView(Context context) {
        super(context);
    }

    public static ReactContext getReactContext(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public final boolean maybeUpdateInsets() {
        EdgeInsets safeAreaInsets;
        EdgeInsets edgeInsets;
        View view = this.mProviderView;
        if (view == null || (safeAreaInsets = PathParser.getSafeAreaInsets(view)) == null || ((edgeInsets = this.mInsets) != null && edgeInsets.equalsToEdgeInsets(safeAreaInsets))) {
            return false;
        }
        this.mInsets = safeAreaInsets;
        updateInsets();
        return true;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void onAttachedToWindow() {
        View view;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (parent == null) {
                view = this;
                break;
            } else if (parent instanceof SafeAreaProvider) {
                view = (View) parent;
                break;
            } else {
                parent = parent.getParent();
            }
        }
        this.mProviderView = view;
        view.getViewTreeObserver().addOnPreDrawListener(this);
        maybeUpdateInsets();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.mProviderView;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.mProviderView = null;
    }

    public boolean onPreDraw() {
        boolean maybeUpdateInsets = maybeUpdateInsets();
        if (maybeUpdateInsets) {
            requestLayout();
        }
        return !maybeUpdateInsets;
    }

    public void setEdges(EnumSet<SafeAreaViewEdges> enumSet) {
        this.mEdges = enumSet;
        updateInsets();
    }

    public void setMode(SafeAreaViewMode safeAreaViewMode) {
        this.mMode = safeAreaViewMode;
        updateInsets();
    }

    public final void updateInsets() {
        if (this.mInsets != null) {
            EnumSet<SafeAreaViewEdges> enumSet = this.mEdges;
            if (enumSet == null) {
                enumSet = EnumSet.allOf(SafeAreaViewEdges.class);
            }
            SafeAreaViewLocalData safeAreaViewLocalData = new SafeAreaViewLocalData(this.mInsets, this.mMode, enumSet);
            UIManagerModule uIManagerModule = (UIManagerModule) getReactContext(this).getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), safeAreaViewLocalData);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                long nanoTime = System.nanoTime();
                getReactContext(this).runOnNativeModulesQueueThread(new Runnable() {
                    /* class com.th3rdwave.safeareacontext.SafeAreaView.AnonymousClass1 */

                    public void run() {
                        synchronized (atomicBoolean) {
                            atomicBoolean.set(true);
                            atomicBoolean.notify();
                        }
                    }
                });
                synchronized (atomicBoolean) {
                    long j = 0;
                    while (!atomicBoolean.get() && j < 5000000000L) {
                        try {
                            atomicBoolean.wait(WebsocketJavaScriptExecutor.CONNECT_TIMEOUT_MS);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        j = System.nanoTime() - nanoTime;
                    }
                    if (j >= 5000000000L) {
                        Log.w("SafeAreaView", "Timed out waiting for layout.");
                    }
                }
            }
        }
    }
}
