package com.facebook.react.modules.core;

import android.view.Choreographer;

public class ChoreographerCompat {
    public static ChoreographerCompat sInstance;
    public Choreographer mChoreographer = Choreographer.getInstance();

    public static abstract class FrameCallback {
        public Choreographer.FrameCallback mFrameCallback;

        public abstract void doFrame(long j);
    }

    public void postFrameCallback(FrameCallback frameCallback) {
        if (frameCallback.mFrameCallback == null) {
            frameCallback.mFrameCallback = new Choreographer.FrameCallback() {
                /* class com.facebook.react.modules.core.ChoreographerCompat.FrameCallback.AnonymousClass1 */

                public void doFrame(long j) {
                    FrameCallback.this.doFrame(j);
                }
            };
        }
        this.mChoreographer.postFrameCallback(frameCallback.mFrameCallback);
    }
}
