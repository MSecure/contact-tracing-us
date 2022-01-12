package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ColorPropConverter;

@DoNotStrip
public class BatchMountItem implements MountItem {
    public final int mCommitNumber;
    public final MountItem[] mMountItems;
    public final int mSize;

    public BatchMountItem(MountItem[] mountItemArr, int i, int i2) {
        if (mountItemArr == null) {
            throw null;
        } else if (i < 0 || i > mountItemArr.length) {
            StringBuilder outline18 = GeneratedOutlineSupport.outline18("Invalid size received by parameter size: ", i, " items.size = ");
            outline18.append(mountItemArr.length);
            throw new IllegalArgumentException(outline18.toString());
        } else {
            this.mMountItems = mountItemArr;
            this.mSize = i;
            this.mCommitNumber = i2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.mSize) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("BatchMountItem (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(ColorPropConverter.PATH_DELIMITER);
            sb.append(this.mSize);
            sb.append("): ");
            sb.append(this.mMountItems[i]);
            i = i2;
        }
        return sb.toString();
    }
}
