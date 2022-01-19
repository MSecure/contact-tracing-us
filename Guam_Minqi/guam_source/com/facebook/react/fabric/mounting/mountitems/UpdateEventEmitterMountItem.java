package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.fabric.events.EventEmitterWrapper;

public class UpdateEventEmitterMountItem implements MountItem {
    public final EventEmitterWrapper mEventHandler;
    public final int mReactTag;

    public UpdateEventEmitterMountItem(int i, EventEmitterWrapper eventEmitterWrapper) {
        this.mReactTag = i;
        this.mEventHandler = eventEmitterWrapper;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline11(GeneratedOutlineSupport.outline15("UpdateEventEmitterMountItem ["), this.mReactTag, "]");
    }
}
