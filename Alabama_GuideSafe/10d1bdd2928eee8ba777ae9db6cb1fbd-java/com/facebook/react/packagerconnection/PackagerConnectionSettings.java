package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$integer;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;

public class PackagerConnectionSettings {
    public final Context mAppContext;
    public final String mPackageName;
    public final SharedPreferences mPreferences;

    public PackagerConnectionSettings(Context context) {
        this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPackageName = context.getPackageName();
        this.mAppContext = context;
    }

    public String getDebugServerHost() {
        String string = this.mPreferences.getString("debug_http_host", null);
        if (!TextUtils.isEmpty(string)) {
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(string);
            return string;
        }
        String serverIpAddress = AndroidInfoHelpers.getServerIpAddress(Integer.valueOf(this.mAppContext.getResources().getInteger(R$integer.react_native_dev_server_port)).intValue());
        if (serverIpAddress.equals("localhost")) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("You seem to be running on device. Run '");
            Integer valueOf = Integer.valueOf(this.mAppContext.getResources().getInteger(R$integer.react_native_dev_server_port));
            outline17.append("adb reverse tcp:" + valueOf + " tcp:" + valueOf);
            outline17.append("' to forward the debug server's port to the device.");
            FLog.w("PackagerConnectionSettings", outline17.toString());
        }
        return serverIpAddress;
    }
}
