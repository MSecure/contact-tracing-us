package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;

public class SystemBroadcastReceiver extends BroadcastReceiver {
    public final Map<String, BreadcrumbType> actions;
    public final Client client;
    public final Logger logger;

    public SystemBroadcastReceiver(Client client2, Logger logger2) {
        this.client = client2;
        this.logger = logger2;
        HashMap hashMap = new HashMap();
        if (this.client.immutableConfig.shouldRecordBreadcrumbType(BreadcrumbType.USER)) {
            hashMap.put("android.appwidget.action.APPWIDGET_DELETED", BreadcrumbType.USER);
            hashMap.put("android.appwidget.action.APPWIDGET_DISABLED", BreadcrumbType.USER);
            hashMap.put("android.appwidget.action.APPWIDGET_ENABLED", BreadcrumbType.USER);
            hashMap.put("android.intent.action.CAMERA_BUTTON", BreadcrumbType.USER);
            hashMap.put("android.intent.action.CLOSE_SYSTEM_DIALOGS", BreadcrumbType.USER);
            hashMap.put("android.intent.action.DOCK_EVENT", BreadcrumbType.USER);
        }
        if (this.client.immutableConfig.shouldRecordBreadcrumbType(BreadcrumbType.STATE)) {
            hashMap.put("android.appwidget.action.APPWIDGET_HOST_RESTORED", BreadcrumbType.STATE);
            hashMap.put("android.appwidget.action.APPWIDGET_RESTORED", BreadcrumbType.STATE);
            hashMap.put("android.appwidget.action.APPWIDGET_UPDATE", BreadcrumbType.STATE);
            hashMap.put("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.ACTION_POWER_CONNECTED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.ACTION_POWER_DISCONNECTED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.ACTION_SHUTDOWN", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.AIRPLANE_MODE", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.BATTERY_LOW", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.BATTERY_OKAY", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.BOOT_COMPLETED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.CONFIGURATION_CHANGED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.CONTENT_CHANGED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.DATE_CHANGED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.DEVICE_STORAGE_LOW", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.DEVICE_STORAGE_OK", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.INPUT_METHOD_CHANGED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.LOCALE_CHANGED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.REBOOT", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.SCREEN_OFF", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.SCREEN_ON", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.TIMEZONE_CHANGED", BreadcrumbType.STATE);
            hashMap.put("android.intent.action.TIME_SET", BreadcrumbType.STATE);
            hashMap.put("android.os.action.DEVICE_IDLE_MODE_CHANGED", BreadcrumbType.STATE);
            hashMap.put("android.os.action.POWER_SAVE_MODE_CHANGED", BreadcrumbType.STATE);
        }
        if (this.client.immutableConfig.shouldRecordBreadcrumbType(BreadcrumbType.NAVIGATION)) {
            hashMap.put("android.intent.action.DREAMING_STARTED", BreadcrumbType.NAVIGATION);
            hashMap.put("android.intent.action.DREAMING_STOPPED", BreadcrumbType.NAVIGATION);
        }
        this.actions = hashMap;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            HashMap hashMap = new HashMap();
            String action = intent.getAction();
            if (action != null) {
                String substring = action.startsWith("android.") ? action.substring(action.lastIndexOf(".") + 1) : action;
                hashMap.put("Intent Action", action);
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str : extras.keySet()) {
                        Object obj = extras.get(str);
                        if (obj != null) {
                            String obj2 = obj.toString();
                            if (str.startsWith("android.")) {
                                hashMap.put("Extra", String.format("%s: %s", substring, obj2));
                            } else {
                                hashMap.put(str, obj2);
                            }
                        }
                    }
                }
                BreadcrumbType breadcrumbType = this.actions.get(action);
                if (breadcrumbType == null) {
                    breadcrumbType = BreadcrumbType.STATE;
                }
                this.client.leaveBreadcrumb(substring, hashMap, breadcrumbType);
            }
        } catch (Exception e) {
            Logger logger2 = this.logger;
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Failed to leave breadcrumb in SystemBroadcastReceiver: ");
            outline15.append(e.getMessage());
            logger2.w(outline15.toString());
        }
    }
}
