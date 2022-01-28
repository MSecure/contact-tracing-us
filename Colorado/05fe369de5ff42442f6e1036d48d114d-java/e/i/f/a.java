package e.i.f;

import android.util.Base64;
import java.util.List;
import java.util.Objects;

public final class a {
    public final String a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f1266d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1267e;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        Objects.requireNonNull(list);
        this.f1266d = list;
        this.f1267e = str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder i2 = f.a.a.a.a.i("FontRequest {mProviderAuthority: ");
        i2.append(this.a);
        i2.append(", mProviderPackage: ");
        i2.append(this.b);
        i2.append(", mQuery: ");
        i2.append(this.c);
        i2.append(", mCertificates:");
        sb.append(i2.toString());
        for (int i3 = 0; i3 < this.f1266d.size(); i3++) {
            sb.append(" [");
            List<byte[]> list = this.f1266d.get(i3);
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i4), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        return f.a.a.a.a.f(sb, "}", "mCertificatesArray: 0");
    }
}
