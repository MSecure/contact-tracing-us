package f.b.a.c.b.l;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public class b extends Exception {
    @RecentlyNonNull
    @Deprecated
    public final Status b;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public b(@RecentlyNonNull Status status) {
        super(r3.toString());
        int i2 = status.c;
        String str = status.f461d;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i2);
        sb.append(": ");
        sb.append(str);
        this.b = status;
    }
}
