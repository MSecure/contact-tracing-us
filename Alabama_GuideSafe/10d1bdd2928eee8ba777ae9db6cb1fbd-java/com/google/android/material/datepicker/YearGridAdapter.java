package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar2) {
        this.materialCalendar = materialCalendar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.calendarConstraints.yearSpan;
    }

    public int getPositionForYear(int i) {
        return i - this.materialCalendar.calendarConstraints.start.year;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        final int i2 = this.materialCalendar.calendarConstraints.start.year + i;
        String string = viewHolder2.textView.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        viewHolder2.textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        viewHolder2.textView.setContentDescription(String.format(string, Integer.valueOf(i2)));
        CalendarStyle calendarStyle = this.materialCalendar.calendarStyle;
        Calendar todayCalendar = ReactYogaConfigProvider.getTodayCalendar();
        CalendarItemStyle calendarItemStyle = todayCalendar.get(1) == i2 ? calendarStyle.todayYear : calendarStyle.year;
        for (Long l : this.materialCalendar.dateSelector.getSelectedDays()) {
            todayCalendar.setTimeInMillis(l.longValue());
            if (todayCalendar.get(1) == i2) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(viewHolder2.textView);
        viewHolder2.textView.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.datepicker.YearGridAdapter.AnonymousClass1 */

            public void onClick(View view) {
                YearGridAdapter.this.materialCalendar.setCurrentMonth(Month.create(i2, YearGridAdapter.this.materialCalendar.current.month));
                YearGridAdapter.this.materialCalendar.setSelector(MaterialCalendar.CalendarSelector.DAY);
            }
        });
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
