package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.fbreact.specs.NativeLinkingSpec;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = IntentModule.NAME)
public class IntentModule extends NativeLinkingSpec {
    public static final String NAME = "IntentAndroid";

    public IntentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void canOpenURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid URL: ", str)));
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            promise.resolve(Boolean.valueOf(intent.resolveActivity(getReactApplicationContext().getPackageManager()) != null));
        } catch (Exception e) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Could not check if URL '", str, "' can be opened: ");
            outline17.append(e.getMessage());
            promise.reject(new JSApplicationIllegalArgumentException(outline17.toString()));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void getInitialURL(Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            String str = null;
            if (currentActivity != null) {
                Intent intent = currentActivity.getIntent();
                String action = intent.getAction();
                Uri data = intent.getData();
                if (data != null && ("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action))) {
                    str = data.toString();
                }
            }
            promise.resolve(str);
        } catch (Exception e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Could not get the initial URL : ");
            outline15.append(e.getMessage());
            promise.reject(new JSApplicationIllegalArgumentException(outline15.toString()));
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void openSettings(Promise promise) {
        try {
            Intent intent = new Intent();
            Activity currentActivity = getCurrentActivity();
            String packageName = getReactApplicationContext().getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + packageName));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            currentActivity.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Could not open the Settings: ");
            outline15.append(e.getMessage());
            promise.reject(new JSApplicationIllegalArgumentException(outline15.toString()));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void openURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Invalid URL: ", str)));
            return;
        }
        try {
            Activity currentActivity = getCurrentActivity();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).normalizeScheme());
            String packageName = getReactApplicationContext().getPackageName();
            ComponentName resolveActivity = intent.resolveActivity(getReactApplicationContext().getPackageManager());
            String packageName2 = resolveActivity != null ? resolveActivity.getPackageName() : "";
            if (currentActivity == null || !packageName.equals(packageName2)) {
                intent.addFlags(268435456);
            }
            if (currentActivity != null) {
                currentActivity.startActivity(intent);
            } else {
                getReactApplicationContext().startActivity(intent);
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Could not open URL '", str, "': ");
            outline17.append(e.getMessage());
            promise.reject(new JSApplicationIllegalArgumentException(outline17.toString()));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void removeListeners(double d) {
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void sendIntent(String str, ReadableArray readableArray, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline9("Invalid Action: ", str, ".")));
            return;
        }
        Intent intent = new Intent(str);
        if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) == null) {
            promise.reject(new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline9("Could not launch Intent with action ", str, ".")));
            return;
        }
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                String nextKey = map.keySetIterator().nextKey();
                int ordinal = map.getType(nextKey).ordinal();
                if (ordinal == 1) {
                    intent.putExtra(nextKey, map.getBoolean(nextKey));
                } else if (ordinal == 2) {
                    intent.putExtra(nextKey, Double.valueOf(map.getDouble(nextKey)));
                } else if (ordinal != 3) {
                    promise.reject(new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline9("Extra type for ", nextKey, " not supported.")));
                    return;
                } else {
                    intent.putExtra(nextKey, map.getString(nextKey));
                }
            }
        }
        getReactApplicationContext().startActivity(intent);
    }
}
