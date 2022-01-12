package com.facebook.react.views.scroll;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.BaseViewManager;

public class OnScrollDispatchHelper {
    public long mLastScrollEventTimeMs = -11;
    public int mPrevX = RecyclerView.UNDEFINED_DURATION;
    public int mPrevY = RecyclerView.UNDEFINED_DURATION;
    public float mXFlingVelocity = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public float mYFlingVelocity = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;

    public boolean onScrollChanged(int i, int i2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = (uptimeMillis - this.mLastScrollEventTimeMs <= 10 && this.mPrevX == i && this.mPrevY == i2) ? false : true;
        long j = this.mLastScrollEventTimeMs;
        if (uptimeMillis - j != 0) {
            this.mXFlingVelocity = ((float) (i - this.mPrevX)) / ((float) (uptimeMillis - j));
            this.mYFlingVelocity = ((float) (i2 - this.mPrevY)) / ((float) (uptimeMillis - j));
        }
        this.mLastScrollEventTimeMs = uptimeMillis;
        this.mPrevX = i;
        this.mPrevY = i2;
        return z;
    }
}
