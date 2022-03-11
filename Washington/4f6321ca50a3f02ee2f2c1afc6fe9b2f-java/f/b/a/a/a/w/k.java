package f.b.a.a.a.w;

import android.net.Uri;
import f.a.a.a.a;
import java.util.Objects;

public final class k extends f0 {
    public final Uri a;
    public final Uri b;

    public k(Uri uri, Uri uri2) {
        Objects.requireNonNull(uri, "Null indexUri");
        this.a = uri;
        Objects.requireNonNull(uri2, "Null mostRecentSuccessfulDownload");
        this.b = uri2;
    }

    @Override // f.b.a.a.a.w.f0
    public Uri a() {
        return this.a;
    }

    @Override // f.b.a.a.a.w.f0
    public Uri b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.a.equals(f0Var.a()) && this.b.equals(f0Var.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder h2 = a.h("DownloadServerEntity{indexUri=");
        h2.append(this.a);
        h2.append(", mostRecentSuccessfulDownload=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
