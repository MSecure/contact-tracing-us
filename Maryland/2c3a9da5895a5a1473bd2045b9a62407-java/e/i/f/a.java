package e.i.f;

import android.util.Base64;
import java.util.List;
import java.util.Objects;

public final class a {
    public final String a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f1455d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1456e;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        Objects.requireNonNull(list);
        this.f1455d = list;
        this.f1456e = str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder h2 = f.a.a.a.a.h("FontRequest {mProviderAuthority: ");
        h2.append(this.a);
        h2.append(", mProviderPackage: ");
        h2.append(this.b);
        h2.append(", mQuery: ");
        h2.append(this.c);
        h2.append(", mCertificates:");
        sb.append(h2.toString());
        for (int i2 = 0; i2 < this.f1455d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f1455d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        return f.a.a.a.a.e(sb, "}", "mCertificatesArray: 0");
    }
}
