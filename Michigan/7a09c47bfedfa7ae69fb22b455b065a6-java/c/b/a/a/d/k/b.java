package c.b.a.a.d.k;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

public class b extends Exception {
    @RecentlyNonNull
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public final Status f2941b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(@RecentlyNonNull Status status) {
        super(r3.toString());
        int i = status.f5981c;
        String str = status.f5982d;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        this.f2941b = status;
    }
}
