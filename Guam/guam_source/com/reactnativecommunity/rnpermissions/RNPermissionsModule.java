package com.reactnativecommunity.rnpermissions;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = RNPermissionsModule.MODULE_NAME)
public class RNPermissionsModule extends ReactContextBaseJavaModule {
    public static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    public static final String MODULE_NAME = "RNPermissions";
    public static final String[][] PERMISSIONS = {new String[]{"ACCEPT_HANDOVER", "android.permission.ACCEPT_HANDOVER"}, new String[]{"ACCESS_BACKGROUND_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"}, new String[]{"ACCESS_COARSE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new String[]{"ACCESS_FINE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, new String[]{"ACTIVITY_RECOGNITION", "android.permission.ACTIVITY_RECOGNITION"}, new String[]{"ADD_VOICEMAIL", "com.android.voicemail.permission.ADD_VOICEMAIL"}, new String[]{"ANSWER_PHONE_CALLS", "android.permission.ANSWER_PHONE_CALLS"}, new String[]{"BODY_SENSORS", "android.permission.BODY_SENSORS"}, new String[]{"CALL_PHONE", "android.permission.CALL_PHONE"}, new String[]{"CAMERA", "android.permission.CAMERA"}, new String[]{"GET_ACCOUNTS", "android.permission.GET_ACCOUNTS"}, new String[]{"PROCESS_OUTGOING_CALLS", "android.permission.PROCESS_OUTGOING_CALLS"}, new String[]{"READ_CALENDAR", "android.permission.READ_CALENDAR"}, new String[]{"READ_CALL_LOG", "android.permission.READ_CALL_LOG"}, new String[]{"READ_CONTACTS", "android.permission.READ_CONTACTS"}, new String[]{"READ_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new String[]{"READ_PHONE_NUMBERS", "android.permission.READ_PHONE_NUMBERS"}, new String[]{"READ_PHONE_STATE", "android.permission.READ_PHONE_STATE"}, new String[]{"READ_SMS", "android.permission.READ_SMS"}, new String[]{"RECEIVE_MMS", "android.permission.RECEIVE_MMS"}, new String[]{"RECEIVE_SMS", "android.permission.RECEIVE_SMS"}, new String[]{"RECEIVE_WAP_PUSH", "android.permission.RECEIVE_WAP_PUSH"}, new String[]{"RECORD_AUDIO", "android.permission.RECORD_AUDIO"}, new String[]{"SEND_SMS", "android.permission.SEND_SMS"}, new String[]{"USE_SIP", "android.permission.USE_SIP"}, new String[]{"WRITE_CALENDAR", "android.permission.WRITE_CALENDAR"}, new String[]{"WRITE_CALL_LOG", "android.permission.WRITE_CALL_LOG"}, new String[]{"WRITE_CONTACTS", "android.permission.WRITE_CONTACTS"}, new String[]{"WRITE_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}};
    public static final String SETTING_NAME = "@RNPermissions:NonRequestables";
    public final SharedPreferences sharedPrefs;

    public RNPermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.sharedPrefs = reactApplicationContext.getSharedPreferences(SETTING_NAME, 0);
    }

    private boolean fieldExists(String str) {
        try {
            Manifest.permission.class.getField(str);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    @ReactMethod
    public void checkNotifications(Promise promise) {
        boolean z;
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(getReactApplicationContext());
        if (Build.VERSION.SDK_INT >= 24) {
            z = notificationManagerCompat.mNotificationManager.areNotificationsEnabled();
        } else {
            AppOpsManager appOpsManager = (AppOpsManager) notificationManagerCompat.mContext.getSystemService("appops");
            ApplicationInfo applicationInfo = notificationManagerCompat.mContext.getApplicationInfo();
            String packageName = notificationManagerCompat.mContext.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() != 0) {
                    z = false;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
            z = true;
        }
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        if (z) {
            createMap.putString("status", "granted");
        } else {
            createMap.putString("status", "blocked");
        }
        createMap.putMap("settings", createMap2);
        promise.resolve(createMap);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        WritableArray createArray = Arguments.createArray();
        String[][] strArr = PERMISSIONS;
        for (String[] strArr2 : strArr) {
            if (fieldExists(strArr2[0])) {
                createArray.pushString(strArr2[1]);
            }
        }
        hashMap.put("available", createArray);
        return hashMap;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void getNonRequestables(Promise promise) {
        WritableArray createArray = Arguments.createArray();
        for (Map.Entry<String, ?> entry : this.sharedPrefs.getAll().entrySet()) {
            createArray.pushString(entry.getKey());
        }
        promise.resolve(createArray);
    }

    @ReactMethod
    public void isNonRequestable(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(this.sharedPrefs.getBoolean(str, false)));
    }

    @ReactMethod
    public void openSettings(Promise promise) {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intent intent = new Intent();
            String packageName = reactApplicationContext.getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts("package", packageName, null));
            reactApplicationContext.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject("E_INVALID_ACTIVITY", e);
        }
    }

    @ReactMethod
    public void setNonRequestable(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(this.sharedPrefs.edit().putBoolean(str, true).commit()));
    }

    @ReactMethod
    public void setNonRequestables(ReadableArray readableArray, Promise promise) {
        SharedPreferences.Editor edit = this.sharedPrefs.edit();
        for (int i = 0; i < readableArray.size(); i++) {
            edit.putBoolean(readableArray.getString(i), true);
        }
        promise.resolve(Boolean.valueOf(edit.commit()));
    }
}
