package f.b.a.e.k;

import android.os.Parcel;
import android.os.Parcelable;
import f.b.a.e.k.a;
import java.util.Arrays;

public class g implements a.c {
    public static final Parcelable.Creator<g> CREATOR = new a();
    public final long b;

    public static class a implements Parcelable.Creator<g> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public g[] newArray(int i2) {
            return new g[i2];
        }
    }

    public g(long j2) {
        this.b = j2;
    }

    public g(long j2, a aVar) {
        this.b = j2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.b == ((g) obj).b;
    }

    @Override // f.b.a.e.k.a.c
    public boolean f(long j2) {
        return j2 >= this.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.b)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.b);
    }
}
