package com.facebook.drawee.view;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {
    public DraweeController mController = null;
    public final DraweeEventTracker mEventTracker;
    public DH mHierarchy;
    public boolean mIsControllerAttached = false;
    public boolean mIsHolderAttached = false;
    public boolean mIsVisible = true;

    public DraweeHolder(DH dh) {
        this.mEventTracker = DraweeEventTracker.sEnabled ? new DraweeEventTracker() : DraweeEventTracker.sInstance;
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public final void attachController() {
        DraweeEventTracker.Event event = DraweeEventTracker.Event.ON_ATTACH_CONTROLLER;
        if (!this.mIsControllerAttached) {
            this.mEventTracker.recordEvent(event);
            this.mIsControllerAttached = true;
            DraweeController draweeController = this.mController;
            if (draweeController != null && ((AbstractDraweeController) draweeController).mSettableDraweeHierarchy != null) {
                AbstractDraweeController abstractDraweeController = (AbstractDraweeController) draweeController;
                if (abstractDraweeController != null) {
                    FrescoSystrace.isTracing();
                    if (FLog.isLoggable(2)) {
                        FLog.v(AbstractDraweeController.TAG, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(abstractDraweeController)), abstractDraweeController.mId, abstractDraweeController.mIsRequestSubmitted ? "request already submitted" : "request needs submit");
                    }
                    abstractDraweeController.mEventTracker.recordEvent(event);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(abstractDraweeController.mSettableDraweeHierarchy);
                    abstractDraweeController.mDeferredReleaser.cancelDeferredRelease(abstractDraweeController);
                    abstractDraweeController.mIsAttached = true;
                    if (!abstractDraweeController.mIsRequestSubmitted) {
                        abstractDraweeController.submitRequest();
                    }
                    FrescoSystrace.isTracing();
                    return;
                }
                throw null;
            }
        }
    }

    public final void attachOrDetachController() {
        if (!this.mIsHolderAttached || !this.mIsVisible) {
            detachController();
        } else {
            attachController();
        }
    }

    public final void detachController() {
        DraweeEventTracker.Event event = DraweeEventTracker.Event.ON_DETACH_CONTROLLER;
        if (this.mIsControllerAttached) {
            this.mEventTracker.recordEvent(event);
            this.mIsControllerAttached = false;
            if (isControllerValid()) {
                AbstractDraweeController abstractDraweeController = (AbstractDraweeController) this.mController;
                if (abstractDraweeController != null) {
                    FrescoSystrace.isTracing();
                    if (FLog.isLoggable(2)) {
                        FLog.v(AbstractDraweeController.TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(abstractDraweeController)), abstractDraweeController.mId);
                    }
                    abstractDraweeController.mEventTracker.recordEvent(event);
                    abstractDraweeController.mIsAttached = false;
                    DeferredReleaser deferredReleaser = abstractDraweeController.mDeferredReleaser;
                    if (deferredReleaser != null) {
                        DeferredReleaser.ensureOnUiThread();
                        if (deferredReleaser.mPendingReleasables.add(abstractDraweeController) && deferredReleaser.mPendingReleasables.size() == 1) {
                            deferredReleaser.mUiHandler.post(deferredReleaser.releaseRunnable);
                        }
                        FrescoSystrace.isTracing();
                        return;
                    }
                    throw null;
                }
                throw null;
            }
        }
    }

    public Drawable getTopLevelDrawable() {
        DH dh = this.mHierarchy;
        if (dh == null) {
            return null;
        }
        return dh.getTopLevelDrawable();
    }

    public boolean isControllerValid() {
        DraweeController draweeController = this.mController;
        return draweeController != null && ((AbstractDraweeController) draweeController).mSettableDraweeHierarchy == this.mHierarchy;
    }

    public void onAttach() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mIsHolderAttached = true;
        attachOrDetachController();
    }

    public void onDetach() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mIsHolderAttached = false;
        attachOrDetachController();
    }

    public void onVisibilityChange(boolean z) {
        if (this.mIsVisible != z) {
            this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
            this.mIsVisible = z;
            attachOrDetachController();
        }
    }

    public void setController(DraweeController draweeController) {
        boolean z = this.mIsControllerAttached;
        if (z) {
            detachController();
        }
        if (isControllerValid()) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.mController.setHierarchy(null);
        }
        this.mController = draweeController;
        if (draweeController != null) {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.mController.setHierarchy(this.mHierarchy);
        } else {
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            attachController();
        }
    }

    public void setHierarchy(DH dh) {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean isControllerValid = isControllerValid();
        Drawable topLevelDrawable = getTopLevelDrawable();
        if (topLevelDrawable instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) topLevelDrawable).setVisibilityCallback(null);
        }
        if (dh != null) {
            this.mHierarchy = dh;
            Drawable topLevelDrawable2 = dh.getTopLevelDrawable();
            onVisibilityChange(topLevelDrawable2 == null || topLevelDrawable2.isVisible());
            Drawable topLevelDrawable3 = getTopLevelDrawable();
            if (topLevelDrawable3 instanceof VisibilityAwareDrawable) {
                ((VisibilityAwareDrawable) topLevelDrawable3).setVisibilityCallback(this);
            }
            if (isControllerValid) {
                this.mController.setHierarchy(dh);
                return;
            }
            return;
        }
        throw null;
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = AppCompatDelegateImpl.ConfigurationImplApi17.toStringHelper(this);
        stringHelper.add("controllerAttached", this.mIsControllerAttached);
        stringHelper.add("holderAttached", this.mIsHolderAttached);
        stringHelper.add("drawableVisible", this.mIsVisible);
        stringHelper.addHolder("events", this.mEventTracker.toString());
        return stringHelper.toString();
    }
}
