package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TimePicker;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class RNDismissableTimePickerDialog extends MinuteIntervalSnappableTimePickerDialog {
    public RNDismissableTimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, onTimeSetListener, i, i2, i3, z, rNTimePickerDisplay);
        fixSpinner(context, i, i2, z, rNTimePickerDisplay);
    }

    public final void fixSpinner(Context context, int i, int i2, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        if (Build.VERSION.SDK_INT == 24 && rNTimePickerDisplay == RNTimePickerDisplay.SPINNER) {
            try {
                context.obtainStyledAttributes(null, (int[]) Class.forName("com.android.internal.R$styleable").getField("TimePicker").get(null), 16843933, 0).recycle();
                TimePicker timePicker = (TimePicker) MoreExecutors.findField(TimePickerDialog.class, TimePicker.class, "mTimePicker").get(this);
                Field findField = MoreExecutors.findField(TimePicker.class, Class.forName("android.widget.TimePicker$TimePickerDelegate"), "mDelegate");
                Object obj = findField.get(timePicker);
                Class<?> cls = Class.forName("android.widget.TimePickerSpinnerDelegate");
                if (obj.getClass() != cls) {
                    findField.set(timePicker, null);
                    timePicker.removeAllViews();
                    Constructor<?> constructor = cls.getConstructor(TimePicker.class, Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE);
                    constructor.setAccessible(true);
                    findField.set(timePicker, constructor.newInstance(timePicker, context, null, 16843933, 0));
                    timePicker.setIs24HourView(Boolean.valueOf(z));
                    timePicker.setCurrentHour(Integer.valueOf(i));
                    timePicker.setCurrentMinute(Integer.valueOf(i2));
                    timePicker.setOnTimeChangedListener(this);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onStop() {
        super.onStop();
    }

    public RNDismissableTimePickerDialog(Context context, int i, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, i, onTimeSetListener, i2, i3, i4, z, rNTimePickerDisplay);
        fixSpinner(context, i2, i3, z, rNTimePickerDisplay);
    }
}
