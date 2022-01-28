package c.b.a.a.c.k;

import com.google.android.gms.common.api.Status;

public class b extends Exception {
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public final Status f2304b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(Status status) {
        super(r3.toString());
        int i = status.f4432c;
        String str = status.f4433d;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        this.f2304b = status;
    }
}
