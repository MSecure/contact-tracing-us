package org.matomo.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.react.bridge.ColorPropConverter;
import java.util.HashMap;
import java.util.Map;
import org.matomo.sdk.dispatcher.DefaultDispatcherFactory;
import org.matomo.sdk.tools.BuildInfo;
import org.matomo.sdk.tools.DeviceHelper;
import org.matomo.sdk.tools.PropertySource;

public class Matomo {
    public static final String TAG = tag(Matomo.class);
    @SuppressLint({"StaticFieldLeak"})
    public static Matomo sInstance;
    public final SharedPreferences mBasePreferences;
    public final Context mContext;
    public DefaultDispatcherFactory mDispatcherFactory = new DefaultDispatcherFactory();
    public final Map<Tracker, SharedPreferences> mPreferenceMap = new HashMap();

    public Matomo(Context context) {
        this.mContext = context.getApplicationContext();
        this.mBasePreferences = context.getSharedPreferences("org.matomo.sdk", 0);
    }

    public static synchronized Matomo getInstance(Context context) {
        Matomo matomo;
        synchronized (Matomo.class) {
            if (sInstance == null) {
                synchronized (Matomo.class) {
                    if (sInstance == null) {
                        sInstance = new Matomo(context);
                    }
                }
            }
            matomo = sInstance;
        }
        return matomo;
    }

    public static String tag(Class... clsArr) {
        int length = clsArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < clsArr.length; i++) {
            strArr[i] = clsArr[i].getSimpleName();
        }
        StringBuilder sb = new StringBuilder("MATOMO:");
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(strArr[i2]);
            if (i2 < length - 1) {
                sb.append(ColorPropConverter.PACKAGE_DELIMITER);
            }
        }
        return sb.toString();
    }

    public DeviceHelper getDeviceHelper() {
        return new DeviceHelper(this.mContext, new PropertySource(), new BuildInfo());
    }
}
