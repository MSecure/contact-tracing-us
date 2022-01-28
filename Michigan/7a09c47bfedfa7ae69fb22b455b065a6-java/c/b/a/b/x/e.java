package c.b.a.b.x;

import android.os.Parcel;
import android.os.Parcelable;
import c.b.a.b.x.a;
import java.util.Arrays;

public class e implements a.c {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final long f4569b;

    public static class a implements Parcelable.Creator<e> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel.readLong(), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e(long j) {
        this.f4569b = j;
    }

    public e(long j, a aVar) {
        this.f4569b = j;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f4569b == ((e) obj).f4569b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4569b)});
    }

    @Override // c.b.a.b.x.a.c
    public boolean k(long j) {
        return j >= this.f4569b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4569b);
    }
}
