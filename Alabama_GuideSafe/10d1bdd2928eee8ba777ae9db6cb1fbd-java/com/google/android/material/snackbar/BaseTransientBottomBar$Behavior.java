package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final BaseTransientBottomBar$BehaviorDelegate delegate = new BaseTransientBottomBar$BehaviorDelegate(this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public boolean canSwipeDismissView(View view) {
        if (this.delegate != null) {
            return view instanceof BaseTransientBottomBar$SnackbarBaseLayout;
        }
        throw null;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.delegate != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    if (SnackbarManager.snackbarManager == null) {
                        SnackbarManager.snackbarManager = new SnackbarManager();
                    }
                    synchronized (SnackbarManager.snackbarManager.lock) {
                    }
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (SnackbarManager.snackbarManager == null) {
                    SnackbarManager.snackbarManager = new SnackbarManager();
                }
                synchronized (SnackbarManager.snackbarManager.lock) {
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
        throw null;
    }
}
