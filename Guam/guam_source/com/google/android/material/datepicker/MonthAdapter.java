package com.google.android.material.datepicker;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$layout;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = ReactYogaConfigProvider.getUtcCalendar().getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector<?> dateSelector;
    public final Month month;

    public MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    public int getCount() {
        return firstPositionInMonth() + this.month.daysInMonth;
    }

    public long getItemId(int i) {
        return (long) (i / this.month.daysInWeek);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e5  */
    public View getView(int i, View view, ViewGroup viewGroup) {
        Long item;
        String str;
        String str2;
        Context context = viewGroup.getContext();
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i - firstPositionInMonth();
        if (firstPositionInMonth >= 0) {
            Month month2 = this.month;
            if (firstPositionInMonth < month2.daysInMonth) {
                int i2 = firstPositionInMonth + 1;
                textView.setTag(month2);
                textView.setText(String.valueOf(i2));
                Calendar dayCopy = ReactYogaConfigProvider.getDayCopy(this.month.firstOfMonth);
                dayCopy.set(5, i2);
                long timeInMillis = dayCopy.getTimeInMillis();
                if (this.month.year == Month.today().year) {
                    Locale locale = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMEd", locale);
                        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
                        str2 = instanceForSkeleton.format(new Date(timeInMillis));
                    } else {
                        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(0, locale);
                        dateInstance.setTimeZone(ReactYogaConfigProvider.getTimeZone());
                        str2 = dateInstance.format(new Date(timeInMillis));
                    }
                    textView.setContentDescription(str2);
                } else {
                    Locale locale2 = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        DateFormat instanceForSkeleton2 = DateFormat.getInstanceForSkeleton("yMMMEd", locale2);
                        instanceForSkeleton2.setTimeZone(TimeZone.getTimeZone("UTC"));
                        str = instanceForSkeleton2.format(new Date(timeInMillis));
                    } else {
                        java.text.DateFormat dateInstance2 = java.text.DateFormat.getDateInstance(0, locale2);
                        dateInstance2.setTimeZone(ReactYogaConfigProvider.getTimeZone());
                        str = dateInstance2.format(new Date(timeInMillis));
                    }
                    textView.setContentDescription(str);
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i);
                if (item != null) {
                    if (this.calendarConstraints.validator.isValid(item.longValue())) {
                        textView.setEnabled(true);
                        Iterator<Long> it = this.dateSelector.getSelectedDays().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (ReactYogaConfigProvider.canonicalYearMonthDay(item.longValue()) == ReactYogaConfigProvider.canonicalYearMonthDay(it.next().longValue())) {
                                    this.calendarStyle.selectedDay.styleItem(textView);
                                    break;
                                }
                            } else if (ReactYogaConfigProvider.getTodayCalendar().getTimeInMillis() == item.longValue()) {
                                this.calendarStyle.todayDay.styleItem(textView);
                            } else {
                                this.calendarStyle.day.styleItem(textView);
                            }
                        }
                    } else {
                        textView.setEnabled(false);
                        this.calendarStyle.invalidDay.styleItem(textView);
                    }
                }
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        item = getItem(i);
        if (item != null) {
        }
        return textView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public Long getItem(int i) {
        if (i < this.month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        Month month2 = this.month;
        Calendar dayCopy = ReactYogaConfigProvider.getDayCopy(month2.firstOfMonth);
        dayCopy.set(5, (i - month2.daysFromStartOfWeekToFirstOfMonth()) + 1);
        return Long.valueOf(dayCopy.getTimeInMillis());
    }
}
