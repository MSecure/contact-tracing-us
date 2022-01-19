package com.facebook.react.uimanager.events;

import android.util.SparseArray;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

public class ReactEventEmitter implements RCTEventEmitter {
    public static final String TAG = "ReactEventEmitter";
    public final SparseArray<RCTEventEmitter> mEventEmitters = new SparseArray<>();
    public final ReactApplicationContext mReactContext;

    public ReactEventEmitter(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
    }

    private RCTEventEmitter getEventEmitter(int i) {
        int uIManagerType = ReactYogaConfigProvider.getUIManagerType(i);
        RCTEventEmitter rCTEventEmitter = this.mEventEmitters.get(uIManagerType);
        if (rCTEventEmitter != null) {
            return rCTEventEmitter;
        }
        FLog.e(TAG, "Unable to find event emitter for reactTag: %d - uiManagerType: %d", Integer.valueOf(i), Integer.valueOf(uIManagerType));
        if (this.mReactContext.hasActiveCatalystInstance()) {
            return (RCTEventEmitter) this.mReactContext.getJSModule(RCTEventEmitter.class);
        }
        ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context for reactTag: " + i + " - uiManagerType: " + uIManagerType + " - No active Catalyst instance!"));
        return rCTEventEmitter;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int i, String str, WritableMap writableMap) {
        RCTEventEmitter eventEmitter = getEventEmitter(i);
        if (eventEmitter != null) {
            eventEmitter.receiveEvent(i, str, writableMap);
        }
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(writableArray.size() > 0);
        RCTEventEmitter eventEmitter = getEventEmitter(writableArray.getMap(0).getInt("target"));
        if (eventEmitter != null) {
            eventEmitter.receiveTouches(str, writableArray, writableArray2);
        }
    }

    public void register(int i, RCTEventEmitter rCTEventEmitter) {
        this.mEventEmitters.put(i, rCTEventEmitter);
    }

    public void unregister(int i) {
        this.mEventEmitters.remove(i);
    }
}
