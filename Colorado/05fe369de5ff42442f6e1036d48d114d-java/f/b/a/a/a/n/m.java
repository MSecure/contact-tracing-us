package f.b.a.a.a.n;

import android.net.Uri;
import f.a.a.a.a;
import java.io.File;
import java.util.Objects;

public final class m extends q {
    public final Uri a;
    public final Uri b;
    public final File c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2255d;

    public m(Uri uri, Uri uri2, File file, boolean z) {
        Objects.requireNonNull(uri, "Null index");
        this.a = uri;
        Objects.requireNonNull(uri2, "Null uri");
        this.b = uri2;
        this.c = file;
        this.f2255d = z;
    }

    @Override // f.b.a.a.a.n.q
    public File a() {
        return this.c;
    }

    @Override // f.b.a.a.a.n.q
    public Uri b() {
        return this.a;
    }

    @Override // f.b.a.a.a.n.q
    public boolean c() {
        return this.f2255d;
    }

    @Override // f.b.a.a.a.n.q
    public Uri d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        File file;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a.equals(qVar.b()) && this.b.equals(qVar.d()) && ((file = this.c) != null ? file.equals(qVar.a()) : qVar.a() == null) && this.f2255d == qVar.c();
    }

    public int hashCode() {
        int hashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        File file = this.c;
        return ((hashCode ^ (file == null ? 0 : file.hashCode())) * 1000003) ^ (this.f2255d ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder i2 = a.i("KeyFile{index=");
        i2.append(this.a);
        i2.append(", uri=");
        i2.append(this.b);
        i2.append(", file=");
        i2.append(this.c);
        i2.append(", isMostRecent=");
        i2.append(this.f2255d);
        i2.append("}");
        return i2.toString();
    }
}
