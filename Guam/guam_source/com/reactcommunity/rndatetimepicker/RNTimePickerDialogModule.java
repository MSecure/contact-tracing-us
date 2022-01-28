package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import java.util.Calendar;

@ReactModule(name = RNTimePickerDialogModule.FRAGMENT_TAG)
public class RNTimePickerDialogModule extends ReactContextBaseJavaModule {
    public static final String FRAGMENT_TAG = "RNTimePickerAndroid";

    public class TimePickerDialogListener implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        public final Promise mPromise;
        public boolean mPromiseResolved = false;

        public TimePickerDialogListener(Promise promise) {
            this.mPromise = promise;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mPromiseResolved && RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", "neutralButtonAction");
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", "dismissedAction");
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (!this.mPromiseResolved && RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", TimePickerDialogModule.ACTION_TIME_SET);
                writableNativeMap.putInt(TimePickerDialogModule.ARG_HOUR, i);
                writableNativeMap.putInt(TimePickerDialogModule.ARG_MINUTE, i2);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }
    }

    public RNTimePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey(TimePickerDialogModule.ARG_IS24HOUR) && !readableMap.isNull(TimePickerDialogModule.ARG_IS24HOUR)) {
            bundle.putBoolean(TimePickerDialogModule.ARG_IS24HOUR, readableMap.getBoolean(TimePickerDialogModule.ARG_IS24HOUR));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundle.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey("neutralButtonLabel") && !readableMap.isNull("neutralButtonLabel")) {
            bundle.putString("neutralButtonLabel", readableMap.getString("neutralButtonLabel"));
        }
        return bundle;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return FRAGMENT_TAG;
    }

    @ReactMethod
    public void open(final ReadableMap readableMap, Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to open a TimePicker dialog while not attached to an Activity");
            return;
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        final RNTimePickerDialogFragment rNTimePickerDialogFragment = (RNTimePickerDialogFragment) supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (rNTimePickerDialogFragment == null || readableMap == null) {
            RNTimePickerDialogFragment rNTimePickerDialogFragment2 = new RNTimePickerDialogFragment();
            if (readableMap != null) {
                rNTimePickerDialogFragment2.setArguments(createFragmentArguments(readableMap));
            }
            TimePickerDialogListener timePickerDialogListener = new TimePickerDialogListener(promise);
            rNTimePickerDialogFragment2.mOnDismissListener = timePickerDialogListener;
            rNTimePickerDialogFragment2.mOnTimeSetListener = timePickerDialogListener;
            RNTimePickerDialogFragment.mOnNeutralButtonActionListener = timePickerDialogListener;
            rNTimePickerDialogFragment2.show(supportFragmentManager, FRAGMENT_TAG);
            return;
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.reactcommunity.rndatetimepicker.RNTimePickerDialogModule.AnonymousClass1 */

            public void run() {
                RNTimePickerDialogFragment rNTimePickerDialogFragment = rNTimePickerDialogFragment;
                Bundle createFragmentArguments = RNTimePickerDialogModule.this.createFragmentArguments(readableMap);
                if (rNTimePickerDialogFragment != null) {
                    Calendar instance = Calendar.getInstance();
                    if (createFragmentArguments != null && createFragmentArguments.containsKey("value")) {
                        instance.setTimeInMillis(createFragmentArguments.getLong("value"));
                    }
                    rNTimePickerDialogFragment.instance.updateTime(instance.get(11), instance.get(12));
                    return;
                }
                throw null;
            }
        });
    }
}
