package com.reactcommunity.rndatetimepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
public class RNDatePickerDialogFragment extends DialogFragment {
    public static DialogInterface.OnClickListener mOnNeutralButtonActionListener;
    public DatePickerDialog instance;
    public DatePickerDialog.OnDateSetListener mOnDateSetListener;
    public DialogInterface.OnDismissListener mOnDismissListener;

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        RNDismissableDatePickerDialog rNDismissableDatePickerDialog;
        Bundle bundle2 = this.mArguments;
        FragmentActivity activity = getActivity();
        DatePickerDialog.OnDateSetListener onDateSetListener = this.mOnDateSetListener;
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        if (bundle2 != null && bundle2.containsKey("value")) {
            instance3.setTimeInMillis(bundle2.getLong("value"));
        }
        int i = instance3.get(1);
        int i2 = instance3.get(2);
        int i3 = instance3.get(5);
        RNDatePickerDisplay rNDatePickerDisplay = RNDatePickerDisplay.DEFAULT;
        if (!(bundle2 == null || bundle2.getString("display", null) == null)) {
            rNDatePickerDisplay = RNDatePickerDisplay.valueOf(bundle2.getString("display").toUpperCase(Locale.US));
        }
        int ordinal = rNDatePickerDisplay.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            rNDismissableDatePickerDialog = new RNDismissableDatePickerDialog(activity, activity.getResources().getIdentifier(rNDatePickerDisplay == RNDatePickerDisplay.CALENDAR ? "CalendarDatePickerDialog" : "SpinnerDatePickerDialog", "style", activity.getPackageName()), onDateSetListener, i, i2, i3, rNDatePickerDisplay);
        } else {
            rNDismissableDatePickerDialog = new RNDismissableDatePickerDialog(activity, onDateSetListener, i, i2, i3, rNDatePickerDisplay);
        }
        if (bundle2 != null && bundle2.containsKey("neutralButtonLabel")) {
            rNDismissableDatePickerDialog.setButton(-3, bundle2.getString("neutralButtonLabel"), mOnNeutralButtonActionListener);
        }
        DatePicker datePicker = rNDismissableDatePickerDialog.getDatePicker();
        if (bundle2 == null || !bundle2.containsKey("minimumDate")) {
            datePicker.setMinDate(-2208988800001L);
        } else {
            instance2.setTimeInMillis(bundle2.getLong("minimumDate"));
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            instance2.set(14, 0);
            datePicker.setMinDate(instance2.getTimeInMillis());
        }
        if (bundle2 != null && bundle2.containsKey("maximumDate")) {
            instance2.setTimeInMillis(bundle2.getLong("maximumDate"));
            instance2.set(11, 23);
            instance2.set(12, 59);
            instance2.set(13, 59);
            instance2.set(14, 999);
            datePicker.setMaxDate(instance2.getTimeInMillis());
        }
        this.instance = rNDismissableDatePickerDialog;
        return rNDismissableDatePickerDialog;
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
