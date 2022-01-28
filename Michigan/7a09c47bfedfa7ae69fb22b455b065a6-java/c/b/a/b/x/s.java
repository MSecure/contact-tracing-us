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
    public final Calendar f4610b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4611c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4612d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4613e = this.f4610b.get(1);

    /* renamed from: f  reason: collision with root package name */
    public final int f4614f = this.f4610b.getMaximum(7);

    /* renamed from: g  reason: collision with root package name */
    public final int f4615g = this.f4610b.getActualMaximum(5);
    public final long h;

    public static class a implements Parcelable.Creator<s> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public s createFromParcel(Parcel parcel) {
            return s.t(parcel.readInt(), parcel.readInt());
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
        this.f4610b = c2;
        this.f4612d = c2.get(2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLLL, yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(a0.e());
        this.f4611c = simpleDateFormat.format(this.f4610b.getTime());
        this.h = this.f4610b.getTimeInMillis();
    }

    public static s t(int i, int i2) {
        Calendar g2 = a0.g();
        g2.set(1, i);
        g2.set(2, i2);
        return new s(g2);
    }

    public static s x(long j) {
        Calendar g2 = a0.g();
        g2.setTimeInMillis(j);
        return new s(g2);
    }

    public static s y() {
        return new s(a0.f());
    }

    public int A() {
        int firstDayOfWeek = this.f4610b.get(7) - this.f4610b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f4614f : firstDayOfWeek;
    }

    public s B(int i) {
        Calendar c2 = a0.c(this.f4610b);
        c2.add(2, i);
        return new s(c2);
    }

    public int D(s sVar) {
        if (this.f4610b instanceof GregorianCalendar) {
            return (sVar.f4612d - this.f4612d) + ((sVar.f4613e - this.f4613e) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
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
        return this.f4612d == sVar.f4612d && this.f4613e == sVar.f4613e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4612d), Integer.valueOf(this.f4613e)});
    }

    /* renamed from: p */
    public int compareTo(s sVar) {
        return this.f4610b.compareTo(sVar.f4610b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4613e);
        parcel.writeInt(this.f4612d);
    }
}
