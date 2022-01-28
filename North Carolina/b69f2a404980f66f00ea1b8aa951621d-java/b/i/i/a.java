package b.i.i;

import android.util.Base64;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f1068a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1069b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1070c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f1071d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1072e;
    public final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1068a = str;
        this.f1069b = str2;
        this.f1070c = str3;
        if (list != null) {
            this.f1071d = list;
            this.f1072e = 0;
            this.f = str + "-" + this.f1069b + "-" + this.f1070c;
            return;
        }
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder g = c.a.a.a.a.g("FontRequest {mProviderAuthority: ");
        g.append(this.f1068a);
        g.append(", mProviderPackage: ");
        g.append(this.f1069b);
        g.append(", mQuery: ");
        g.append(this.f1070c);
        g.append(", mCertificates:");
        sb.append(g.toString());
        for (int i = 0; i < this.f1071d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1071d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1072e);
        return sb.toString();
    }
}
