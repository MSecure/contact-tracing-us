package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
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
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import java.util.Calendar;

@ReactModule(name = RNDatePickerDialogModule.FRAGMENT_TAG)
public class RNDatePickerDialogModule extends ReactContextBaseJavaModule {
    public static final String FRAGMENT_TAG = "RNDatePickerAndroid";

    public class DatePickerDialogListener implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        public final Promise mPromise;
        public boolean mPromiseResolved = false;

        public DatePickerDialogListener(Promise promise) {
            this.mPromise = promise;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mPromiseResolved && RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", "neutralButtonAction");
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            if (!this.mPromiseResolved && RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", DatePickerDialogModule.ACTION_DATE_SET);
                writableNativeMap.putInt("year", i);
                writableNativeMap.putInt("month", i2);
                writableNativeMap.putInt("day", i3);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", "dismissedAction");
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }
    }

    public RNDatePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey("minimumDate") && !readableMap.isNull("minimumDate")) {
            bundle.putLong("minimumDate", (long) readableMap.getDouble("minimumDate"));
        }
        if (readableMap.hasKey("maximumDate") && !readableMap.isNull("maximumDate")) {
            bundle.putLong("maximumDate", (long) readableMap.getDouble("maximumDate"));
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
            promise.reject("E_NO_ACTIVITY", "Tried to open a DatePicker dialog while not attached to an Activity");
            return;
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        final RNDatePickerDialogFragment rNDatePickerDialogFragment = (RNDatePickerDialogFragment) supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (rNDatePickerDialogFragment == null || readableMap == null) {
            RNDatePickerDialogFragment rNDatePickerDialogFragment2 = new RNDatePickerDialogFragment();
            if (readableMap != null) {
                rNDatePickerDialogFragment2.setArguments(createFragmentArguments(readableMap));
            }
            DatePickerDialogListener datePickerDialogListener = new DatePickerDialogListener(promise);
            rNDatePickerDialogFragment2.mOnDismissListener = datePickerDialogListener;
            rNDatePickerDialogFragment2.mOnDateSetListener = datePickerDialogListener;
            RNDatePickerDialogFragment.mOnNeutralButtonActionListener = datePickerDialogListener;
            rNDatePickerDialogFragment2.show(supportFragmentManager, FRAGMENT_TAG);
            return;
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.reactcommunity.rndatetimepicker.RNDatePickerDialogModule.AnonymousClass1 */

            public void run() {
                RNDatePickerDialogFragment rNDatePickerDialogFragment = rNDatePickerDialogFragment;
                Bundle createFragmentArguments = RNDatePickerDialogModule.this.createFragmentArguments(readableMap);
                if (rNDatePickerDialogFragment != null) {
                    Calendar instance = Calendar.getInstance();
                    if (createFragmentArguments != null && createFragmentArguments.containsKey("value")) {
                        instance.setTimeInMillis(createFragmentArguments.getLong("value"));
                    }
                    rNDatePickerDialogFragment.instance.updateDate(instance.get(1), instance.get(2), instance.get(5));
                    return;
                }
                throw null;
            }
        });
    }
}
