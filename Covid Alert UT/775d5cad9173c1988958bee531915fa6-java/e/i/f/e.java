package e.i.f;

import android.util.Base64;
import f.a.a.a.a;
import java.util.List;
import java.util.Objects;

public final class e {
    public final String a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f1506d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1507e;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        Objects.requireNonNull(str);
        this.a = str;
        Objects.requireNonNull(str2);
        this.b = str2;
        this.c = str3;
        Objects.requireNonNull(list);
        this.f1506d = list;
        this.f1507e = str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder h2 = a.h("FontRequest {mProviderAuthority: ");
        h2.append(this.a);
        h2.append(", mProviderPackage: ");
        h2.append(this.b);
        h2.append(", mQuery: ");
        h2.append(this.c);
        h2.append(", mCertificates:");
        sb.append(h2.toString());
        for (int i2 = 0; i2 < this.f1506d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f1506d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        return a.e(sb, "}", "mCertificatesArray: 0");
    }
}
