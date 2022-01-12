package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;

public class UpdatePaddingMountItem implements MountItem {
    public final int mBottom;
    public final int mLeft;
    public final int mReactTag;
    public final int mRight;
    public final int mTop;

    public UpdatePaddingMountItem(int i, int i2, int i3, int i4, int i5) {
        this.mReactTag = i;
        this.mLeft = i2;
        this.mTop = i3;
        this.mRight = i4;
        this.mBottom = i5;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("UpdatePaddingMountItem [");
        outline17.append(this.mReactTag);
        outline17.append("] - left: ");
        outline17.append(this.mLeft);
        outline17.append(" - top: ");
        outline17.append(this.mTop);
        outline17.append(" - right: ");
        outline17.append(this.mRight);
        outline17.append(" - bottom: ");
        outline17.append(this.mBottom);
        return outline17.toString();
    }
}
