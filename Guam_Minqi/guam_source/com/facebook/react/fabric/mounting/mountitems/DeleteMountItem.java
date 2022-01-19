package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;

public class DeleteMountItem implements MountItem {
    public int mReactTag;

    public DeleteMountItem(int i) {
        this.mReactTag = i;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline11(GeneratedOutlineSupport.outline15("DeleteMountItem ["), this.mReactTag, "]");
    }
}
