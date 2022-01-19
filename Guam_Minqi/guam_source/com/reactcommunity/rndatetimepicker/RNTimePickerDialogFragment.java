package com.reactcommunity.rndatetimepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import java.util.Calendar;
import java.util.Locale;

public class RNTimePickerDialogFragment extends DialogFragment {
    public static DialogInterface.OnClickListener mOnNeutralButtonActionListener;
    public TimePickerDialog instance;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public TimePickerDialog.OnTimeSetListener mOnTimeSetListener;

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        RNDismissableTimePickerDialog rNDismissableTimePickerDialog;
        Bundle bundle2 = this.mArguments;
        FragmentActivity activity = getActivity();
        TimePickerDialog.OnTimeSetListener onTimeSetListener = this.mOnTimeSetListener;
        Calendar instance2 = Calendar.getInstance();
        if (bundle2 != null && bundle2.containsKey("value")) {
            instance2.setTimeInMillis(bundle2.getLong("value"));
        }
        int i = instance2.get(11);
        int i2 = instance2.get(12);
        boolean is24HourFormat = DateFormat.is24HourFormat(activity);
        RNTimePickerDisplay rNTimePickerDisplay = RNTimePickerDisplay.DEFAULT;
        if (!(bundle2 == null || bundle2.getString("display", null) == null)) {
            rNTimePickerDisplay = RNTimePickerDisplay.valueOf(bundle2.getString("display").toUpperCase(Locale.US));
        }
        if (bundle2 != null) {
            is24HourFormat = bundle2.getBoolean(TimePickerDialogModule.ARG_IS24HOUR, DateFormat.is24HourFormat(activity));
        }
        int ordinal = rNTimePickerDisplay.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            rNDismissableTimePickerDialog = new RNDismissableTimePickerDialog(activity, activity.getResources().getIdentifier(rNTimePickerDisplay == RNTimePickerDisplay.CLOCK ? "ClockTimePickerDialog" : "SpinnerTimePickerDialog", "style", activity.getPackageName()), onTimeSetListener, i, i2, is24HourFormat, rNTimePickerDisplay);
        } else {
            rNDismissableTimePickerDialog = new RNDismissableTimePickerDialog(activity, onTimeSetListener, i, i2, is24HourFormat, rNTimePickerDisplay);
        }
        if (bundle2 != null && bundle2.containsKey("neutralButtonLabel")) {
            rNDismissableTimePickerDialog.setButton(-3, bundle2.getString("neutralButtonLabel"), mOnNeutralButtonActionListener);
        }
        this.instance = rNDismissableTimePickerDialog;
        return rNDismissableTimePickerDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
