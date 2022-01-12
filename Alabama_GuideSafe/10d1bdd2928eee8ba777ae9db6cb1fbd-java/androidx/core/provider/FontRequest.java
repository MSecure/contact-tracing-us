package androidx.core.provider;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public final class FontRequest {
    public final List<List<byte[]>> mCertificates;
    public final int mCertificatesArray;
    public final String mIdentifier;
    public final String mProviderAuthority;
    public final String mProviderPackage;
    public final String mQuery;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.mProviderAuthority = str;
        this.mProviderPackage = str2;
        this.mQuery = str3;
        if (list != null) {
            this.mCertificates = list;
            this.mCertificatesArray = 0;
            this.mIdentifier = str + "-" + this.mProviderPackage + "-" + this.mQuery;
            return;
        }
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("FontRequest {mProviderAuthority: ");
        outline17.append(this.mProviderAuthority);
        outline17.append(", mProviderPackage: ");
        outline17.append(this.mProviderPackage);
        outline17.append(", mQuery: ");
        outline17.append(this.mQuery);
        outline17.append(", mCertificates:");
        sb.append(outline17.toString());
        for (int i = 0; i < this.mCertificates.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.mCertificates.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.mCertificatesArray);
        return sb.toString();
    }
}
