package f.b.a.c.b.l;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

public class b extends Exception {
    @RecentlyNonNull
    @Deprecated
    public final Status b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(@RecentlyNonNull Status status) {
        super(r3.toString());
        int i2 = status.c;
        String str = status.f412d;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i2);
        sb.append(": ");
        sb.append(str);
        this.b = status;
    }
}
