package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        /* class com.google.android.material.datepicker.CalendarConstraints.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    };
    public final Month end;
    public final int monthSpan;
    public final Month openAt;
    public final Month start;
    public final DateValidator validator;
    public final int yearSpan;

    public static final class Builder {
        public static final long DEFAULT_END = ReactYogaConfigProvider.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        public static final long DEFAULT_START = ReactYogaConfigProvider.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        public long end = DEFAULT_END;
        public Long openAt;
        public long start = DEFAULT_START;
        public DateValidator validator = new DateValidatorPointForward(Long.MIN_VALUE);

        public Builder(CalendarConstraints calendarConstraints) {
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    public CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator, AnonymousClass1 r5) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month.firstOfMonth.compareTo(month3.firstOfMonth) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3.firstOfMonth.compareTo(month2.firstOfMonth) <= 0) {
            this.monthSpan = month.monthsUntil(month2) + 1;
            this.yearSpan = (month2.year - month.year) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && this.openAt.equals(calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }
}
