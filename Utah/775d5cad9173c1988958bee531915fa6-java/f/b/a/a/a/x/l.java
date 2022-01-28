package f.b.a.a.a.x;

import android.net.Uri;
import f.a.a.a.a;
import java.util.Objects;

public final class l extends o {
    public final Uri a;
    public final Uri b;

    public l(Uri uri, Uri uri2) {
        Objects.requireNonNull(uri, "Null indexUri");
        this.a = uri;
        Objects.requireNonNull(uri2, "Null fileBaseUri");
        this.b = uri2;
    }

    @Override // f.b.a.a.a.x.o
    public Uri a() {
        return this.b;
    }

    @Override // f.b.a.a.a.x.o
    public Uri b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a.equals(oVar.b()) && this.b.equals(oVar.a());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder h2 = a.h("DownloadUriPair{indexUri=");
        h2.append(this.a);
        h2.append(", fileBaseUri=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
