package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

public final class MaterialCalendar<S> extends PickerFragment<S> {
    public static final Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
    public static final Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
    public static final Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
    public static final Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    public CalendarConstraints calendarConstraints;
    public CalendarSelector calendarSelector;
    public CalendarStyle calendarStyle;
    public Month current;
    public DateSelector<S> dateSelector;
    public View dayFrame;
    public RecyclerView recyclerView;
    public int themeResId;
    public View yearFrame;
    public RecyclerView yearSelector;

    public enum CalendarSelector {
        DAY,
        YEAR
    }

    public interface OnDayClickListener {
    }

    public static int getDayHeight(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    public LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = this.mArguments;
        }
        this.themeResId = bundle.getInt("THEME_RES_ID_KEY");
        this.dateSelector = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.current = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final int i;
        int i2;
        LinearSnapHelper linearSnapHelper;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.calendarConstraints.start;
        if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i2 = R$layout.mtrl_calendar_vertical;
            i = 1;
        } else {
            i2 = R$layout.mtrl_calendar_horizontal;
            i = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new AccessibilityDelegateCompat(this) {
            /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass1 */

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                accessibilityNodeInfoCompat.setCollectionInfo(null);
            }
        });
        gridView.setAdapter((ListAdapter) new DaysOfWeekAdapter());
        gridView.setNumColumns(month.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new SmoothCalendarLayoutManager(getContext(), false, i) {
            /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass2 */

            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
                if (i == 0) {
                    iArr[0] = MaterialCalendar.this.recyclerView.getWidth();
                    iArr[1] = MaterialCalendar.this.recyclerView.getWidth();
                    return;
                }
                iArr[0] = MaterialCalendar.this.recyclerView.getHeight();
                iArr[1] = MaterialCalendar.this.recyclerView.getHeight();
            }
        });
        this.recyclerView.setTag("MONTHS_VIEW_GROUP_TAG");
        final MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new OnDayClickListener() {
            /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass3 */
        });
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView4 = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView4;
        if (recyclerView4 != null) {
            recyclerView4.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(new RecyclerView.ItemDecoration() {
                /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass4 */
                public final Calendar endItem = ReactYogaConfigProvider.getUtcCalendar();
                public final Calendar startItem = ReactYogaConfigProvider.getUtcCalendar();

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
                    int i;
                    if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                        YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                        for (Pair<Long, Long> pair : MaterialCalendar.this.dateSelector.getSelectedRanges()) {
                            F f = pair.first;
                            if (!(f == null || pair.second == null)) {
                                this.startItem.setTimeInMillis(f.longValue());
                                this.endItem.setTimeInMillis(pair.second.longValue());
                                int positionForYear = yearGridAdapter.getPositionForYear(this.startItem.get(1));
                                int positionForYear2 = yearGridAdapter.getPositionForYear(this.endItem.get(1));
                                View findViewByPosition = gridLayoutManager.findViewByPosition(positionForYear);
                                View findViewByPosition2 = gridLayoutManager.findViewByPosition(positionForYear2);
                                int i2 = gridLayoutManager.mSpanCount;
                                int i3 = positionForYear / i2;
                                int i4 = positionForYear2 / i2;
                                for (int i5 = i3; i5 <= i4; i5++) {
                                    View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.mSpanCount * i5);
                                    if (findViewByPosition3 != null) {
                                        int top = findViewByPosition3.getTop() + MaterialCalendar.this.calendarStyle.year.insets.top;
                                        int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.calendarStyle.year.insets.bottom;
                                        int width = i5 == i3 ? (findViewByPosition.getWidth() / 2) + findViewByPosition.getLeft() : 0;
                                        if (i5 == i4) {
                                            i = (findViewByPosition2.getWidth() / 2) + findViewByPosition2.getLeft();
                                        } else {
                                            i = recyclerView.getWidth();
                                        }
                                        canvas.drawRect((float) width, (float) top, (float) i, (float) bottom, MaterialCalendar.this.calendarStyle.rangeFill);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            final MaterialButton materialButton = (MaterialButton) inflate.findViewById(R$id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() {
                /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass5 */

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    String str;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    if (MaterialCalendar.this.dayFrame.getVisibility() == 0) {
                        str = MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection);
                    } else {
                        str = MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection);
                    }
                    accessibilityNodeInfoCompat.setHintText(str);
                }
            });
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.yearFrame = inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
            this.dayFrame = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            setSelector(CalendarSelector.DAY);
            materialButton.setText(this.current.longName);
            this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass6 */

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    if (i == 0) {
                        recyclerView.announceForAccessibility(materialButton.getText());
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    int i3;
                    if (i < 0) {
                        i3 = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition();
                    } else {
                        i3 = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
                    }
                    MaterialCalendar.this.current = monthsPagerAdapter.getPageMonth(i3);
                    materialButton.setText(monthsPagerAdapter.calendarConstraints.start.monthsLater(i3).longName);
                }
            });
            materialButton.setOnClickListener(new View.OnClickListener() {
                /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass7 */

                public void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    CalendarSelector calendarSelector = CalendarSelector.DAY;
                    CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
                    CalendarSelector calendarSelector3 = materialCalendar.calendarSelector;
                    if (calendarSelector3 == calendarSelector2) {
                        materialCalendar.setSelector(calendarSelector);
                    } else if (calendarSelector3 == calendarSelector) {
                        materialCalendar.setSelector(calendarSelector2);
                    }
                }
            });
            materialButton3.setOnClickListener(new View.OnClickListener() {
                /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass8 */

                public void onClick(View view) {
                    int findFirstVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
                    if (findFirstVisibleItemPosition < MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
                        MaterialCalendar.this.setCurrentMonth(monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition));
                    }
                }
            });
            materialButton2.setOnClickListener(new View.OnClickListener() {
                /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass9 */

                public void onClick(View view) {
                    int findLastVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
                    if (findLastVisibleItemPosition >= 0) {
                        MaterialCalendar.this.setCurrentMonth(monthsPagerAdapter.getPageMonth(findLastVisibleItemPosition));
                    }
                }
            });
        }
        if (!MaterialDatePicker.isFullscreen(contextThemeWrapper) && (recyclerView3 = (linearSnapHelper = new LinearSnapHelper()).mRecyclerView) != (recyclerView2 = this.recyclerView)) {
            if (recyclerView3 != null) {
                recyclerView3.removeOnScrollListener(linearSnapHelper.mScrollListener);
                linearSnapHelper.mRecyclerView.setOnFlingListener(null);
            }
            linearSnapHelper.mRecyclerView = recyclerView2;
            if (recyclerView2 != null) {
                if (recyclerView2.getOnFlingListener() == null) {
                    linearSnapHelper.mRecyclerView.addOnScrollListener(linearSnapHelper.mScrollListener);
                    linearSnapHelper.mRecyclerView.setOnFlingListener(linearSnapHelper);
                    linearSnapHelper.mGravityScroller = new Scroller(linearSnapHelper.mRecyclerView.getContext(), new DecelerateInterpolator());
                    linearSnapHelper.snapToTargetExistingView();
                } else {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
            }
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.getPosition(this.current));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.themeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.current);
    }

    public final void postSmoothRecyclerViewScroll(final int i) {
        this.recyclerView.post(new Runnable() {
            /* class com.google.android.material.datepicker.MaterialCalendar.AnonymousClass10 */

            public void run() {
                MaterialCalendar.this.recyclerView.smoothScrollToPosition(i);
            }
        });
    }

    public void setCurrentMonth(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int monthsUntil = monthsPagerAdapter.calendarConstraints.start.monthsUntil(month);
        int position = monthsUntil - monthsPagerAdapter.getPosition(this.current);
        boolean z = true;
        boolean z2 = Math.abs(position) > 3;
        if (position <= 0) {
            z = false;
        }
        this.current = month;
        if (z2 && z) {
            this.recyclerView.scrollToPosition(monthsUntil - 3);
            postSmoothRecyclerViewScroll(monthsUntil);
        } else if (z2) {
            this.recyclerView.scrollToPosition(monthsUntil + 3);
            postSmoothRecyclerViewScroll(monthsUntil);
        } else {
            postSmoothRecyclerViewScroll(monthsUntil);
        }
    }

    public void setSelector(CalendarSelector calendarSelector2) {
        this.calendarSelector = calendarSelector2;
        if (calendarSelector2 == CalendarSelector.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
        } else if (calendarSelector2 == CalendarSelector.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }
}
