package c.b.a.a.d.m.o;

import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;

public class b extends RuntimeException {
    /* JADX WARNING: Illegal instructions before constructor call */
    public b(@RecentlyNonNull String str, @RecentlyNonNull Parcel parcel) {
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
