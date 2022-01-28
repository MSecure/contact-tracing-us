package org.matomo.sdk.tools;

import android.content.Context;
import org.matomo.sdk.Matomo;

public class DeviceHelper {
    public static final String TAG = Matomo.tag(DeviceHelper.class);
    public final BuildInfo mBuildInfo;
    public final Context mContext;
    public final PropertySource mPropertySource;

    public DeviceHelper(Context context, PropertySource propertySource, BuildInfo buildInfo) {
        this.mContext = context;
        this.mPropertySource = propertySource;
        this.mBuildInfo = buildInfo;
    }
}
