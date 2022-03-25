package f.b.a.d.l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class u implements Comparable<u>, Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new a();
    public final Calendar b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2743d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2744e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2745f;

    /* renamed from: g  reason: collision with root package name */
    public final long f2746g;

    /* renamed from: h  reason: collision with root package name */
    public String f2747h;

    public static class a implements Parcelable.Creator<u> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public u createFromParcel(Parcel parcel) {
            return u.o(parcel.readInt(), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public u[] newArray(int i2) {
            return new u[i2];
        }
    }

    public u(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d2 = d0.d(calendar);
        this.b = d2;
        this.c = d2.get(2);
        this.f2743d = d2.get(1);
        this.f2744e = d2.getMaximum(7);
        this.f2745f = d2.getActualMaximum(5);
        this.f2746g = d2.getTimeInMillis();
    }

    public static u o(int i2, int i3) {
        Calendar g2 = d0.g();
        g2.set(1, i2);
        g2.set(2, i3);
        return new u(g2);
    }

    public static u q(long j2) {
        Calendar g2 = d0.g();
        g2.setTimeInMillis(j2);
        return new u(g2);
    }

    public static u r() {
        return new u(d0.f());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.c == uVar.c && this.f2743d == uVar.f2743d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.f2743d)});
    }

    /* renamed from: n */
    public int compareTo(u uVar) {
        return this.b.compareTo(uVar.b);
    }

    public int s() {
        int firstDayOfWeek = this.b.get(7) - this.b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f2744e : firstDayOfWeek;
    }

    public long t(int i2) {
        Calendar d2 = d0.d(this.b);
        d2.set(5, i2);
        return d2.getTimeInMillis();
    }

    public String u(Context context) {
        if (this.f2747h == null) {
            long timeInMillis = this.b.getTimeInMillis();
            this.f2747h = DateUtils.formatDateTime(context, timeInMillis - ((long) TimeZone.getDefault().getOffset(timeInMillis)), 36);
        }
        return this.f2747h;
    }

    public u v(int i2) {
        Calendar d2 = d0.d(this.b);
        d2.add(2, i2);
        return new u(d2);
    }

    public int w(u uVar) {
        if (this.b instanceof GregorianCalendar) {
            return (uVar.c - this.c) + ((uVar.f2743d - this.f2743d) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2743d);
        parcel.writeInt(this.c);
    }
}
