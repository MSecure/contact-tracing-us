package com.facebook.react.animated;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

public abstract class AnimationDriver {
    public ValueAnimatedNode mAnimatedValue;
    public Callback mEndCallback;
    public boolean mHasFinished = false;
    public int mId;

    public void resetConfig(ReadableMap readableMap) {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Animation config for ");
        outline15.append(getClass().getSimpleName());
        outline15.append(" cannot be reset");
        throw new JSApplicationCausedNativeException(outline15.toString());
    }

    public abstract void runAnimationStep(long j);
}
