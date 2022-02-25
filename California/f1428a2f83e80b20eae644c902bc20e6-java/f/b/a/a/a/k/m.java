package f.b.a.a.a.k;

import android.net.Uri;
import f.a.a.a.a;
import java.io.File;
import java.util.Objects;

public final class m extends q {
    public final Uri a;
    public final Uri b;
    public final File c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2081d;

    public m(Uri uri, Uri uri2, File file, boolean z) {
        Objects.requireNonNull(uri, "Null index");
        this.a = uri;
        Objects.requireNonNull(uri2, "Null uri");
        this.b = uri2;
        this.c = file;
        this.f2081d = z;
    }

    @Override // f.b.a.a.a.k.q
    public File a() {
        return this.c;
    }

    @Override // f.b.a.a.a.k.q
    public Uri b() {
        return this.a;
    }

    @Override // f.b.a.a.a.k.q
    public boolean c() {
        return this.f2081d;
    }

    @Override // f.b.a.a.a.k.q
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
        return this.a.equals(qVar.b()) && this.b.equals(qVar.d()) && ((file = this.c) != null ? file.equals(qVar.a()) : qVar.a() == null) && this.f2081d == qVar.c();
    }

    public int hashCode() {
        int hashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        File file = this.c;
        return ((hashCode ^ (file == null ? 0 : file.hashCode())) * 1000003) ^ (this.f2081d ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder h2 = a.h("KeyFile{index=");
        h2.append(this.a);
        h2.append(", uri=");
        h2.append(this.b);
        h2.append(", file=");
        h2.append(this.c);
        h2.append(", isMostRecent=");
        h2.append(this.f2081d);
        h2.append("}");
        return h2.toString();
    }
}
