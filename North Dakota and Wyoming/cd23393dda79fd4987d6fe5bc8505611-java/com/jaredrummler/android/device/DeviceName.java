package com.jaredrummler.android.device;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceName {
    private static final String SHARED_PREF_NAME = "device_names";
    private static Context context;

    public interface Callback {
        void onFinished(DeviceInfo deviceInfo, Exception exc);
    }

    public static void init(Context context2) {
        context = context2.getApplicationContext();
    }

    public static Request with(Context context2) {
        return new Request(context2.getApplicationContext());
    }

    public static String getDeviceName() {
        return getDeviceName(Build.DEVICE, Build.MODEL, capitalize(Build.MODEL));
    }

    public static String getDeviceName(String str, String str2) {
        return getDeviceName(str, str, str2);
    }

    public static String getDeviceName(String str, String str2, String str3) {
        String str4 = getDeviceInfo(context(), str, str2).marketName;
        return str4 == null ? str3 : str4;
    }

    public static DeviceInfo getDeviceInfo(Context context2) {
        return getDeviceInfo(context2.getApplicationContext(), Build.DEVICE, Build.MODEL);
    }

    public static DeviceInfo getDeviceInfo(Context context2, String str) {
        return getDeviceInfo(context2, str, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        r7.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        throw r0;
     */
    public static DeviceInfo getDeviceInfo(Context context2, String str, String str2) {
        SharedPreferences sharedPreferences = context2.getSharedPreferences(SHARED_PREF_NAME, 0);
        String format = String.format("%s:%s", str, str2);
        String string = sharedPreferences.getString(format, null);
        if (string != null) {
            try {
                return new DeviceInfo(new JSONObject(string));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            DeviceDatabase deviceDatabase = new DeviceDatabase(context2);
            DeviceInfo queryToDevice = deviceDatabase.queryToDevice(str, str2);
            if (queryToDevice != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("manufacturer", queryToDevice.manufacturer);
                jSONObject.put("codename", queryToDevice.codename);
                jSONObject.put("model", queryToDevice.model);
                jSONObject.put("market_name", queryToDevice.marketName);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(format, jSONObject.toString());
                edit.apply();
                deviceDatabase.close();
                return queryToDevice;
            }
            deviceDatabase.close();
            if (!str.equals(Build.DEVICE) || !Build.MODEL.equals(str2)) {
                return new DeviceInfo(null, null, str, str2);
            }
            return new DeviceInfo(Build.MANUFACTURER, str, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            } else {
                sb.append(Character.toUpperCase(c));
                z = false;
            }
        }
        return sb.toString();
    }

    public static final class Request {
        String codename;
        final Context context;
        final Handler handler;
        String model;

        private Request(Context context2) {
            this.context = context2;
            this.handler = new Handler(context2.getMainLooper());
        }

        public Request setCodename(String str) {
            this.codename = str;
            return this;
        }

        public Request setModel(String str) {
            this.model = str;
            return this;
        }

        public void request(Callback callback) {
            if (this.codename == null && this.model == null) {
                this.codename = Build.DEVICE;
                this.model = Build.MODEL;
            }
            GetDeviceRunnable getDeviceRunnable = new GetDeviceRunnable(callback);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(getDeviceRunnable).start();
            } else {
                getDeviceRunnable.run();
            }
        }

        private final class GetDeviceRunnable implements Runnable {
            final Callback callback;
            DeviceInfo deviceInfo;
            Exception error;

            GetDeviceRunnable(Callback callback2) {
                this.callback = callback2;
            }

            public void run() {
                try {
                    this.deviceInfo = DeviceName.getDeviceInfo(Request.this.context, Request.this.codename, Request.this.model);
                } catch (Exception e) {
                    this.error = e;
                }
                Request.this.handler.post(new Runnable() {
                    /* class com.jaredrummler.android.device.DeviceName.Request.GetDeviceRunnable.AnonymousClass1 */

                    public void run() {
                        GetDeviceRunnable.this.callback.onFinished(GetDeviceRunnable.this.deviceInfo, GetDeviceRunnable.this.error);
                    }
                });
            }
        }
    }

    public static final class DeviceInfo {
        public final String codename;
        @Deprecated
        public final String manufacturer;
        public final String marketName;
        public final String model;

        public DeviceInfo(String str, String str2, String str3) {
            this(null, str, str2, str3);
        }

        public DeviceInfo(String str, String str2, String str3, String str4) {
            this.manufacturer = str;
            this.marketName = str2;
            this.codename = str3;
            this.model = str4;
        }

        private DeviceInfo(JSONObject jSONObject) throws JSONException {
            this.manufacturer = jSONObject.getString("manufacturer");
            this.marketName = jSONObject.getString("market_name");
            this.codename = jSONObject.getString("codename");
            this.model = jSONObject.getString("model");
        }

        public String getName() {
            if (!TextUtils.isEmpty(this.marketName)) {
                return this.marketName;
            }
            return DeviceName.capitalize(this.model);
        }
    }

    private static Context context() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Exception unused) {
            try {
                return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
            } catch (Exception unused2) {
                throw new RuntimeException("DeviceName must be initialized before usage.");
            }
        }
    }
}
