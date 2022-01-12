package com.facebook.react.common;

import android.net.Uri;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.devsupport.StackTraceHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class DebugServerException extends RuntimeException {
    public DebugServerException(String str, String str2, int i, int i2) {
        super(str + "\n  at " + str2 + ColorPropConverter.PACKAGE_DELIMITER + i + ColorPropConverter.PACKAGE_DELIMITER + i2);
    }

    public static DebugServerException makeGeneric(String str, String str2, String str3, Throwable th) {
        return new DebugServerException(GeneratedOutlineSupport.outline11(str2, "\n\nTry the following to fix the issue:\n• Ensure that the packager server is running\n• Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n• Ensure Airplane Mode is disabled\n• If you're on a physical device connected to the same machine, run 'adb reverse tcp:<PORT> tcp:<PORT>' to forward requests from your device\n• If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:<PORT>\n\n".replace("<PORT>", String.valueOf(Uri.parse(str).getPort())), str3), th);
    }

    public static DebugServerException parse(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("filename");
            String string2 = jSONObject.getString("message");
            String[] split = string.split(ColorPropConverter.PATH_DELIMITER);
            return new DebugServerException(string2, split[split.length - 1], jSONObject.getInt("lineNumber"), jSONObject.getInt(StackTraceHelper.COLUMN_KEY));
        } catch (JSONException e) {
            FLog.w("ReactNative", "Could not parse DebugServerException from: " + str2, e);
            return null;
        }
    }

    public DebugServerException(String str) {
        super(str);
    }

    public DebugServerException(String str, Throwable th) {
        super(str, th);
    }
}
