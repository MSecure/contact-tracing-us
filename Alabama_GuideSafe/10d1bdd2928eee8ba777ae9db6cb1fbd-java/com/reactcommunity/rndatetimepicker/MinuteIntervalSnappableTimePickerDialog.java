package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import java.util.ArrayList;

public class MinuteIntervalSnappableTimePickerDialog extends TimePickerDialog {
    public Handler handler = new Handler();
    public Context mContext;
    public RNTimePickerDisplay mDisplay;
    public TimePicker mTimePicker;
    public int mTimePickerInterval;
    public final TimePickerDialog.OnTimeSetListener mTimeSetListener;
    public Runnable runnable;

    public MinuteIntervalSnappableTimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, onTimeSetListener, i, i2, z);
        this.mTimePickerInterval = i3;
        this.mTimeSetListener = onTimeSetListener;
        this.mDisplay = rNTimePickerDisplay;
        this.mContext = context;
    }

    public static boolean isValidMinuteInterval(int i) {
        return i >= 1 && i <= 30 && 60 % i == 0;
    }

    public final int getRealMinutes() {
        int intValue = this.mTimePicker.getCurrentMinute().intValue();
        return this.mDisplay == RNTimePickerDisplay.SPINNER ? intValue * this.mTimePickerInterval : intValue;
    }

    public final boolean isSpinner() {
        return this.mDisplay == RNTimePickerDisplay.SPINNER;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (timePickerHasCustomMinuteInterval()) {
            TimePicker timePicker = (TimePicker) findViewById(this.mContext.getResources().getIdentifier("timePicker", "id", "android"));
            this.mTimePicker = timePicker;
            int intValue = timePicker.getCurrentMinute().intValue();
            if (isSpinner()) {
                NumberPicker numberPicker = (NumberPicker) findViewById(this.mContext.getResources().getIdentifier(TimePickerDialogModule.ARG_MINUTE, "id", "android"));
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue((60 / this.mTimePickerInterval) - 1);
                ArrayList arrayList = new ArrayList(60 / this.mTimePickerInterval);
                int i = 0;
                while (i < 60) {
                    arrayList.add(String.format("%02d", Integer.valueOf(i)));
                    i += this.mTimePickerInterval;
                }
                numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
                this.mTimePicker.setCurrentMinute(Integer.valueOf(snapRealMinutesToInterval(intValue) / this.mTimePickerInterval));
                return;
            }
            this.mTimePicker.setCurrentMinute(Integer.valueOf(snapRealMinutesToInterval(intValue)));
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.mTimePicker == null || i != -1 || !timePickerHasCustomMinuteInterval()) {
            super.onClick(dialogInterface, i);
            return;
        }
        int intValue = this.mTimePicker.getCurrentHour().intValue();
        int realMinutes = getRealMinutes();
        if (!isSpinner()) {
            realMinutes = snapRealMinutesToInterval(realMinutes);
        }
        TimePickerDialog.OnTimeSetListener onTimeSetListener = this.mTimeSetListener;
        if (onTimeSetListener != null) {
            onTimeSetListener.onTimeSet(this.mTimePicker, intValue, realMinutes);
        }
    }

    public void onDetachedFromWindow() {
        this.handler.removeCallbacks(this.runnable);
        super.onDetachedFromWindow();
    }

    public void onTimeChanged(final TimePicker timePicker, final int i, int i2) {
        int i3 = this.mDisplay == RNTimePickerDisplay.SPINNER ? this.mTimePickerInterval * i2 : i2;
        this.handler.removeCallbacks(this.runnable);
        if (!isSpinner()) {
            if (!isSpinner()) {
                if (timePickerHasCustomMinuteInterval() && i3 != snapRealMinutesToInterval(i3)) {
                    final int snapRealMinutesToInterval = snapRealMinutesToInterval(i3);
                    if (!isSpinner()) {
                        final EditText editText = (EditText) timePicker.findFocus();
                        AnonymousClass1 r11 = new Runnable() {
                            /* class com.reactcommunity.rndatetimepicker.MinuteIntervalSnappableTimePickerDialog.AnonymousClass1 */

                            public void run() {
                                MinuteIntervalSnappableTimePickerDialog minuteIntervalSnappableTimePickerDialog = MinuteIntervalSnappableTimePickerDialog.this;
                                View findViewById = minuteIntervalSnappableTimePickerDialog.findViewById(minuteIntervalSnappableTimePickerDialog.mContext.getResources().getIdentifier("input_mode", "id", "android"));
                                if (findViewById != null && findViewById.hasFocus()) {
                                    timePicker.setCurrentHour(Integer.valueOf(i));
                                    timePicker.setCurrentMinute(Integer.valueOf(snapRealMinutesToInterval));
                                    EditText editText = editText;
                                    editText.setSelection(editText.getText().length());
                                    return;
                                }
                                timePicker.setCurrentHour(Integer.valueOf(i));
                                timePicker.setCurrentMinute(0);
                                timePicker.setCurrentMinute(Integer.valueOf(snapRealMinutesToInterval));
                            }
                        };
                        this.runnable = r11;
                        this.handler.postDelayed(r11, 500);
                        return;
                    }
                    throw new RuntimeException("spinner never needs to be corrected because wrong values are not offered to user (both in scrolling and textInput mode)!");
                }
            } else {
                throw new RuntimeException("minutesNeedCorrection is not intended to be used with spinner, spinner won't allow picking invalid values");
            }
        }
        super.onTimeChanged(timePicker, i, i2);
    }

    public final int snapRealMinutesToInterval(int i) {
        int round = Math.round(((float) i) / ((float) this.mTimePickerInterval));
        int i2 = this.mTimePickerInterval;
        int i3 = round * i2;
        return i3 == 60 ? i3 - i2 : i3;
    }

    public final boolean timePickerHasCustomMinuteInterval() {
        return this.mTimePickerInterval != 1;
    }

    public void updateTime(int i, int i2) {
        if (!timePickerHasCustomMinuteInterval()) {
            super.updateTime(i, i2);
        } else if (isSpinner()) {
            super.updateTime(i, snapRealMinutesToInterval(getRealMinutes()) / this.mTimePickerInterval);
        } else {
            super.updateTime(i, snapRealMinutesToInterval(i2));
        }
    }

    public MinuteIntervalSnappableTimePickerDialog(Context context, int i, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, i, onTimeSetListener, i2, i3, z);
        this.mTimePickerInterval = i4;
        this.mTimeSetListener = onTimeSetListener;
        this.mDisplay = rNTimePickerDisplay;
        this.mContext = context;
    }
}
