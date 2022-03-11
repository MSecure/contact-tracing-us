package f.b.c;

import android.os.Parcel;
import android.os.Parcelable;
import f.b.a.c.b.o.b;
import java.util.Date;
/* loaded from: classes.dex */
public final class d implements Comparable<d>, Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();
    public final long b;
    public final int c;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<d> {
        @Override // android.os.Parcelable.Creator
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public d[] newArray(int i2) {
            return new d[i2];
        }
    }

    public d(long j2, int i2) {
        o(j2, i2);
        this.b = j2;
        this.c = i2;
    }

    public d(Parcel parcel) {
        this.b = parcel.readLong();
        this.c = parcel.readInt();
    }

    public d(Date date) {
        long time = date.getTime();
        long j2 = time / 1000;
        int i2 = ((int) (time % 1000)) * 1000000;
        if (i2 < 0) {
            j2--;
            i2 += 1000000000;
        }
        o(j2, i2);
        this.b = j2;
        this.c = i2;
    }

    public static void o(long j2, int i2) {
        b.v(i2 >= 0, "Timestamp nanoseconds out of range: %s", Integer.valueOf(i2));
        b.v(((double) i2) < 1.0E9d, "Timestamp nanoseconds out of range: %s", Integer.valueOf(i2));
        b.v(j2 >= -62135596800L, "Timestamp seconds out of range: %s", Long.valueOf(j2));
        b.v(j2 < 253402300800L, "Timestamp seconds out of range: %s", Long.valueOf(j2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof d) && compareTo((d) obj) == 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j2 = this.b;
        return (((((int) j2) * 37 * 37) + ((int) (j2 >> 32))) * 37) + this.c;
    }

    /* renamed from: n */
    public int compareTo(d dVar) {
        long j2 = this.b;
        long j3 = dVar.b;
        return j2 == j3 ? Integer.signum(this.c - dVar.c) : Long.signum(j2 - j3);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Timestamp(seconds=");
        h2.append(this.b);
        h2.append(", nanoseconds=");
        h2.append(this.c);
        h2.append(")");
        return h2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.b);
        parcel.writeInt(this.c);
    }
}
