package c.b.a.a.c.l.s;

import android.os.Parcel;

public class b extends RuntimeException {
    /* JADX WARNING: Illegal instructions before constructor call */
    public b(String str, Parcel parcel) {
        super(r2.toString());
        int dataPosition = parcel.dataPosition();
        int dataSize = parcel.dataSize();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
        sb.append(str);
        sb.append(" Parcel: pos=");
        sb.append(dataPosition);
        sb.append(" size=");
        sb.append(dataSize);
    }
}
