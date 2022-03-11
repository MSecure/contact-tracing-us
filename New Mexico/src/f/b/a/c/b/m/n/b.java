package f.b.a.c.b.m.n;

import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
/* loaded from: classes.dex */
public class b extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
