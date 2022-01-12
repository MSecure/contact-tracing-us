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
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Animation config for ");
        outline17.append(getClass().getSimpleName());
        outline17.append(" cannot be reset");
        throw new JSApplicationCausedNativeException(outline17.toString());
    }

    public abstract void runAnimationStep(long j);
}
