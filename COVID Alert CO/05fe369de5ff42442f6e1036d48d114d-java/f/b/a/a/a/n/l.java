package f.b.a.a.a.n;

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

    @Override // f.b.a.a.a.n.o
    public Uri a() {
        return this.b;
    }

    @Override // f.b.a.a.a.n.o
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
        StringBuilder i2 = a.i("DownloadUriPair{indexUri=");
        i2.append(this.a);
        i2.append(", fileBaseUri=");
        i2.append(this.b);
        i2.append("}");
        return i2.toString();
    }
}
