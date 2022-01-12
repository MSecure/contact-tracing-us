package com.google.android.material.snackbar;

import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.behavior.SwipeDismissBehavior;

public class BaseTransientBottomBar$BehaviorDelegate {
    public BaseTransientBottomBar$BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.alphaStartSwipeDistance = SwipeDismissBehavior.clamp(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0.1f, 1.0f);
        swipeDismissBehavior.alphaEndSwipeDistance = SwipeDismissBehavior.clamp(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0.6f, 1.0f);
        swipeDismissBehavior.swipeDirection = 0;
    }
}
