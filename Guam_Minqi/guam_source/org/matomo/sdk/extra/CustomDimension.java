package org.matomo.sdk.extra;

import org.matomo.sdk.Matomo;
import org.matomo.sdk.TrackMe;
import timber.log.Timber;

public class CustomDimension {
    public static final String TAG = Matomo.tag(CustomDimension.class);
    public final int mId;
    public final String mValue;

    public CustomDimension(int i, String str) {
        this.mId = i;
        this.mValue = str;
    }

    public static boolean setDimension(TrackMe trackMe, int i, String str) {
        if (i < 1) {
            Timber.tag(TAG).e("dimensionId should be great than 0 (arg: %d)", Integer.valueOf(i));
            return false;
        }
        if (str != null && str.length() > 255) {
            str = str.substring(0, 255);
            Timber.tag(TAG).w("dimensionValue was truncated to 255 chars.", new Object[0]);
        }
        if (str != null && str.length() == 0) {
            str = null;
        }
        trackMe.set("dimension" + i, str);
        return true;
    }
}
