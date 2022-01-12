package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class MaterialDatePicker<S> extends DialogFragment {
    public static final Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
    public static final Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
    public static final Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    public MaterialShapeDrawable background;
    public MaterialCalendar<S> calendar;
    public CalendarConstraints calendarConstraints;
    public Button confirmButton;
    public DateSelector<S> dateSelector;
    public boolean fullscreen;
    public TextView headerSelectionText;
    public CheckableImageButton headerToggleButton;
    public final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners = new LinkedHashSet<>();
    public final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners = new LinkedHashSet<>();
    public int overrideThemeResId;
    public PickerFragment<S> pickerFragment;
    public CharSequence titleText;
    public int titleTextResId;

    public static int getPaddedPickerWidth(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i = Month.today().daysInWeek;
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i;
        return ((i - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean isFullscreen(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ReactYogaConfigProvider.resolveOrThrow(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.today().timeInMillis;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = this.mArguments;
        }
        this.overrideThemeResId = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.dateSelector = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.titleTextResId = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.titleText = bundle.getCharSequence("TITLE_TEXT_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        Context requireContext2 = requireContext();
        int i = this.overrideThemeResId;
        if (i == 0) {
            i = this.dateSelector.getDefaultThemeResId(requireContext2);
        }
        Dialog dialog = new Dialog(requireContext, i);
        Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        int resolveOrThrow = ReactYogaConfigProvider.resolveOrThrow(context, R$attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context, (AttributeSet) null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar).build());
        this.background = materialShapeDrawable;
        materialShapeDrawable.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        materialShapeDrawable.updateZ();
        this.background.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        this.background.setElevation(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.fullscreen ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.fullscreen) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            View findViewById = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R$id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
            Resources resources = requireContext().getResources();
            findViewById2.setMinimumHeight(resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height) + (resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding) * (MonthAdapter.MAXIMUM_WEEKS - 1)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * MonthAdapter.MAXIMUM_WEEKS) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.headerSelectionText = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.headerToggleButton = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.titleText;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.titleTextResId);
        }
        this.headerToggleButton.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.headerToggleButton;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R$drawable.ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R$drawable.ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass4 */

            public void onClick(View view) {
                MaterialDatePicker.this.headerToggleButton.toggle();
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
                MaterialDatePicker.this.startPickerFragment();
            }
        });
        this.confirmButton = (Button) inflate.findViewById(R$id.confirm_button);
        if (this.dateSelector.isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag("CONFIRM_BUTTON_TAG");
        this.confirmButton.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass1 */

            public void onClick(View view) {
                Iterator<MaterialPickerOnPositiveButtonClickListener<? super S>> it = MaterialDatePicker.this.onPositiveButtonClickListeners.iterator();
                while (it.hasNext()) {
                    it.next().onPositiveButtonClick(MaterialDatePicker.this.dateSelector.getSelection());
                }
                MaterialDatePicker.this.dismissInternal(false, false);
            }
        });
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass2 */

            public void onClick(View view) {
                Iterator<View.OnClickListener> it = MaterialDatePicker.this.onNegativeButtonClickListeners.iterator();
                while (it.hasNext()) {
                    it.next().onClick(view);
                }
                MaterialDatePicker.this.dismissInternal(false, false);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.mView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.calendarConstraints);
        Month month = this.calendar.current;
        if (month != null) {
            builder.openAt = Long.valueOf(month.timeInMillis);
        }
        if (builder.openAt == null) {
            long thisMonthInUtcMilliseconds = thisMonthInUtcMilliseconds();
            if (builder.start > thisMonthInUtcMilliseconds || thisMonthInUtcMilliseconds > builder.end) {
                thisMonthInUtcMilliseconds = builder.start;
            }
            builder.openAt = Long.valueOf(thisMonthInUtcMilliseconds);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", builder.validator);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(Month.create(builder.start), Month.create(builder.end), Month.create(builder.openAt.longValue()), (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.titleTextResId);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.titleText);
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onStart() {
        this.mCalled = true;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
        }
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onStop() {
        this.pickerFragment.onSelectionChangedListeners.clear();
        this.mCalled = true;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public final void startPickerFragment() {
        PickerFragment<S> pickerFragment2;
        DateSelector<S> dateSelector2 = this.dateSelector;
        Context requireContext = requireContext();
        int i = this.overrideThemeResId;
        if (i == 0) {
            i = this.dateSelector.getDefaultThemeResId(requireContext);
        }
        CalendarConstraints calendarConstraints2 = this.calendarConstraints;
        MaterialCalendar<S> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector2);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints2.openAt);
        materialCalendar.setArguments(bundle);
        this.calendar = materialCalendar;
        if (this.headerToggleButton.isChecked()) {
            DateSelector<S> dateSelector3 = this.dateSelector;
            CalendarConstraints calendarConstraints3 = this.calendarConstraints;
            pickerFragment2 = new MaterialTextInputPicker<>();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelector3);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints3);
            pickerFragment2.setArguments(bundle2);
        } else {
            pickerFragment2 = this.calendar;
        }
        this.pickerFragment = pickerFragment2;
        updateHeader();
        FragmentManager childFragmentManager = getChildFragmentManager();
        if (childFragmentManager != null) {
            BackStackRecord backStackRecord = new BackStackRecord(childFragmentManager);
            int i2 = R$id.mtrl_calendar_frame;
            PickerFragment<S> pickerFragment3 = this.pickerFragment;
            if (i2 != 0) {
                backStackRecord.doAddOp(i2, pickerFragment3, null, 2);
                backStackRecord.disallowAddToBackStack();
                backStackRecord.mManager.execSingleAction(backStackRecord, false);
                PickerFragment<S> pickerFragment4 = this.pickerFragment;
                pickerFragment4.onSelectionChangedListeners.add(new OnSelectionChangedListener<S>() {
                    /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass3 */

                    @Override // com.google.android.material.datepicker.OnSelectionChangedListener
                    public void onSelectionChanged(S s) {
                        MaterialDatePicker.this.updateHeader();
                        if (MaterialDatePicker.this.dateSelector.isSelectionComplete()) {
                            MaterialDatePicker.this.confirmButton.setEnabled(true);
                        } else {
                            MaterialDatePicker.this.confirmButton.setEnabled(false);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        throw null;
    }

    public final void updateHeader() {
        String selectionDisplayString = this.dateSelector.getSelectionDisplayString(getContext());
        this.headerSelectionText.setContentDescription(String.format(getString(R$string.mtrl_picker_announce_current_selection), selectionDisplayString));
        this.headerSelectionText.setText(selectionDisplayString);
    }

    public final void updateToggleContentDescription(CheckableImageButton checkableImageButton) {
        String str;
        if (this.headerToggleButton.isChecked()) {
            str = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.headerToggleButton.setContentDescription(str);
    }
}
