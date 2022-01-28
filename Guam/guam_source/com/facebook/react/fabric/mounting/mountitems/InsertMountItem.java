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
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("InsertMountItem [");
        outline15.append(this.mReactTag);
        outline15.append("] - parentTag: ");
        outline15.append(this.mParentReactTag);
        outline15.append(" - index: ");
        outline15.append(this.mIndex);
        return outline15.toString();
    }
}
