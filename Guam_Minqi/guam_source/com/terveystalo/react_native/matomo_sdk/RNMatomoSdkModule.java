package com.terveystalo.react_native.matomo_sdk;

import android.text.TextUtils;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.matomo.sdk.Matomo;
import org.matomo.sdk.QueryParams;
import org.matomo.sdk.TrackMe;
import org.matomo.sdk.Tracker;
import org.matomo.sdk.TrackerBuilder;
import org.matomo.sdk.extra.CustomDimension;
import org.matomo.sdk.extra.TrackHelper;

public class RNMatomoSdkModule extends ReactContextBaseJavaModule {
    public Map<Integer, String> mCustomDimensions = new HashMap();
    public final ReactApplicationContext reactContext;
    public Tracker tracker;

    public RNMatomoSdkModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    /* access modifiers changed from: public */
    private TrackMe onTrackCallback(TrackMe trackMe) {
        for (Map.Entry<Integer, String> entry : this.mCustomDimensions.entrySet()) {
            CustomDimension customDimension = new CustomDimension(entry.getKey().intValue(), entry.getValue());
            CustomDimension.setDimension(trackMe, customDimension.mId, customDimension.mValue);
        }
        return trackMe;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNMatomoSdk";
    }

    public void initialize(String str, int i, Promise promise) {
        try {
            if (this.tracker == null) {
                TrackerBuilder trackerBuilder = new TrackerBuilder(str, i, "Default Tracker");
                Matomo instance = Matomo.getInstance(this.reactContext);
                if (trackerBuilder.mApplicationBaseUrl == null) {
                    trackerBuilder.mApplicationBaseUrl = String.format("https://%s/", instance.mContext.getPackageName());
                }
                this.tracker = new Tracker(instance, trackerBuilder);
                this.tracker.mTrackingCallbacks.add(new Tracker.Callback() {
                    /* class com.terveystalo.react_native.matomo_sdk.$$Lambda$RNMatomoSdkModule$Cuu9CORlVBfznTPI0eHCGnpjs */

                    @Override // org.matomo.sdk.Tracker.Callback
                    public final TrackMe onTrack(TrackMe trackMe) {
                        return RNMatomoSdkModule.m9lambda$Cuu9CORlVBfznTPI0eHCGnpjs(RNMatomoSdkModule.this, trackMe);
                    }
                });
            }
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void setCustomDimension(int i, String str, Promise promise) {
        if (str != null) {
            try {
                this.mCustomDimensions.put(Integer.valueOf(i), str);
            } catch (Exception e) {
                promise.reject(e);
                return;
            }
        } else {
            this.mCustomDimensions.remove(Integer.valueOf(i));
        }
        promise.resolve(null);
    }

    public void setUserId(String str, Promise promise) {
        try {
            Tracker tracker2 = this.tracker;
            tracker2.mDefaultTrackMe.set(QueryParams.USER_ID, str);
            tracker2.getPreferences().edit().putString("tracker.userid", str).apply();
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void trackEvent(String str, String str2, ReadableMap readableMap, Promise promise) {
        try {
            TrackHelper.EventBuilder eventBuilder = new TrackHelper.EventBuilder(new TrackHelper(), str, str2);
            if (readableMap.hasKey("name")) {
                eventBuilder.mName = readableMap.getString("name");
            }
            if (readableMap.hasKey("value")) {
                eventBuilder.mValue = Float.valueOf((float) readableMap.getDouble("value"));
            }
            eventBuilder.with(this.tracker);
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public void trackView(ReadableArray readableArray, Promise promise) {
        try {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < readableArray.size(); i++) {
                linkedList.add(readableArray.getString(i));
            }
            String join = TextUtils.join(ColorPropConverter.PATH_DELIMITER, linkedList);
            TrackHelper.Screen screen = new TrackHelper.Screen(new TrackHelper(), join);
            screen.mTitle = join;
            screen.with(this.tracker);
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
