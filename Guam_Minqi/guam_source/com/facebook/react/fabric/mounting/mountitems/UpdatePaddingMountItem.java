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
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("UpdatePaddingMountItem [");
        outline15.append(this.mReactTag);
        outline15.append("] - left: ");
        outline15.append(this.mLeft);
        outline15.append(" - top: ");
        outline15.append(this.mTop);
        outline15.append(" - right: ");
        outline15.append(this.mRight);
        outline15.append(" - bottom: ");
        outline15.append(this.mBottom);
        return outline15.toString();
    }
}
