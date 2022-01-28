package b.i.i;

import android.util.Base64;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f1771a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1772b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1773c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f1774d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1775e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1776f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1771a = str;
        this.f1772b = str2;
        this.f1773c = str3;
        if (list != null) {
            this.f1774d = list;
            this.f1775e = 0;
            this.f1776f = str + "-" + this.f1772b + "-" + this.f1773c;
            return;
        }
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder h = c.a.a.a.a.h("FontRequest {mProviderAuthority: ");
        h.append(this.f1771a);
        h.append(", mProviderPackage: ");
        h.append(this.f1772b);
        h.append(", mQuery: ");
        h.append(this.f1773c);
        h.append(", mCertificates:");
        sb.append(h.toString());
        for (int i = 0; i < this.f1774d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1774d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1775e);
        return sb.toString();
    }
}
