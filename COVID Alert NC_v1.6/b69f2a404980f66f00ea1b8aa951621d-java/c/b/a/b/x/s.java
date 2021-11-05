package c.b.a.b.x;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class s implements Comparable<s>, Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f3279b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3280c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3281d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3282e = this.f3279b.get(1);
    public final int f = this.f3279b.getMaximum(7);
    public final int g = this.f3279b.getActualMaximum(5);
    public final long h;

    public static class a implements Parcelable.Creator<s> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public s createFromParcel(Parcel parcel) {
            return s.q(parcel.readInt(), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public s[] newArray(int i) {
            return new s[i];
        }
    }

    public s(Calendar calendar) {
        calendar.set(5, 1);
        Calendar c2 = a0.c(calendar);
        this.f3279b = c2;
        this.f3281d = c2.get(2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLLL, yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(a0.e());
        this.f3280c = simpleDateFormat.format(this.f3279b.getTime());
        this.h = this.f3279b.getTimeInMillis();
    }

    public static s q(int i, int i2) {
        Calendar g2 = a0.g();
        g2.set(1, i);
        g2.set(2, i2);
        return new s(g2);
    }

    public static s s(long j) {
        Calendar g2 = a0.g();
        g2.setTimeInMillis(j);
        return new s(g2);
    }

    public static s t() {
        return new s(a0.f());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f3281d == sVar.f3281d && this.f3282e == sVar.f3282e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3281d), Integer.valueOf(this.f3282e)});
    }

    /* renamed from: p */
    public int compareTo(s sVar) {
        return this.f3279b.compareTo(sVar.f3279b);
    }

    public int u() {
        int firstDayOfWeek = this.f3279b.get(7) - this.f3279b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f : firstDayOfWeek;
    }

    public s v(int i) {
        Calendar c2 = a0.c(this.f3279b);
        c2.add(2, i);
        return new s(c2);
    }

    public int w(s sVar) {
        if (this.f3279b instanceof GregorianCalendar) {
            return (sVar.f3281d - this.f3281d) + ((sVar.f3282e - this.f3282e) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3282e);
        parcel.writeInt(this.f3281d);
    }
}
