package c.b.a.b.x;

import android.os.Parcel;
import android.os.Parcelable;
import c.b.a.b.x.a;
import java.util.Arrays;

public class e implements a.c {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final long f3242b;

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
        this.f3242b = j;
    }

    public e(long j, a aVar) {
        this.f3242b = j;
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
        return this.f3242b == ((e) obj).f3242b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f3242b)});
    }

    @Override // c.b.a.b.x.a.c
    public boolean i(long j) {
        return j >= this.f3242b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f3242b);
    }
}
