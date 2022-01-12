package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Iterator;

public class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final CalendarConstraints calendarConstraints;
    public final DateSelector<?> dateSelector;
    public final int itemHeight;
    public final MaterialCalendar.OnDayClickListener onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final MaterialCalendarGridView monthGrid;
        public final TextView monthTitle;

        public ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (!z) {
                this.monthTitle.setVisibility(8);
            }
        }
    }

    public MonthsPagerAdapter(Context context, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2, MaterialCalendar.OnDayClickListener onDayClickListener2) {
        Month month = calendarConstraints2.start;
        Month month2 = calendarConstraints2.end;
        Month month3 = calendarConstraints2.openAt;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (month3.compareTo(month2) <= 0) {
            this.itemHeight = (MaterialCalendar.getDayHeight(context) * MonthAdapter.MAXIMUM_WEEKS) + (MaterialDatePicker.isFullscreen(context) ? context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) : 0);
            this.calendarConstraints = calendarConstraints2;
            this.dateSelector = dateSelector2;
            this.onDayClickListener = onDayClickListener2;
            if (!this.mObservable.hasObservers()) {
                this.mHasStableIds = true;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.monthSpan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.calendarConstraints.start.monthsLater(i).firstOfMonth.getTimeInMillis();
    }

    public Month getPageMonth(int i) {
        return this.calendarConstraints.start.monthsLater(i);
    }

    public int getPosition(Month month) {
        return this.calendarConstraints.start.monthsUntil(month);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        Month monthsLater = this.calendarConstraints.start.monthsLater(i);
        viewHolder2.monthTitle.setText(monthsLater.longName);
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.monthGrid.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.google.android.material.datepicker.MonthsPagerAdapter.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MonthAdapter adapter = materialCalendarGridView.getAdapter();
                if (i >= adapter.firstPositionInMonth() && i <= adapter.lastPositionInMonth()) {
                    MaterialCalendar.OnDayClickListener onDayClickListener = MonthsPagerAdapter.this.onDayClickListener;
                    long longValue = materialCalendarGridView.getAdapter().getItem(i).longValue();
                    MaterialCalendar.AnonymousClass3 r1 = (MaterialCalendar.AnonymousClass3) onDayClickListener;
                    if (MaterialCalendar.this.calendarConstraints.validator.isValid(longValue)) {
                        MaterialCalendar.this.dateSelector.select(longValue);
                        Iterator<OnSelectionChangedListener<S>> it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                        while (it.hasNext()) {
                            it.next().onSelectionChanged(MaterialCalendar.this.dateSelector.getSelection());
                        }
                        MaterialCalendar.this.recyclerView.getAdapter().mObservable.notifyChanged();
                        RecyclerView recyclerView = MaterialCalendar.this.yearSelector;
                        if (recyclerView != null) {
                            recyclerView.getAdapter().mObservable.notifyChanged();
                        }
                    }
                }
            }
        });
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(linearLayout, true);
    }
}
