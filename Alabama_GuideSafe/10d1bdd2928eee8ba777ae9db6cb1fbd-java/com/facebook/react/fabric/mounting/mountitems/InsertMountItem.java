package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;

public class InsertMountItem implements MountItem {
    public int mIndex;
    public int mParentReactTag;
    public int mReactTag;

    public InsertMountItem(int i, int i2, int i3) {
        this.mReactTag = i;
        this.mParentReactTag = i2;
        this.mIndex = i3;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("InsertMountItem [");
        outline17.append(this.mReactTag);
        outline17.append("] - parentTag: ");
        outline17.append(this.mParentReactTag);
        outline17.append(" - index: ");
        outline17.append(this.mIndex);
        return outline17.toString();
    }
}
