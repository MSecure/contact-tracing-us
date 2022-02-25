package f.b.a.a.a.k;

import android.net.Uri;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.o.h;
import java.util.Objects;

public final /* synthetic */ class a implements d {
    public final /* synthetic */ n a;
    public final /* synthetic */ Uri b;

    public /* synthetic */ a(n nVar, Uri uri) {
        this.a = nVar;
        this.b = uri;
    }

    @Override // e.f.a.d
    public final Object a(b bVar) {
        n nVar = this.a;
        Uri uri = this.b;
        Objects.requireNonNull(nVar);
        String str = "Downloading keyfile file from " + uri;
        h hVar = new h(uri, new e(uri, bVar), new d(uri, bVar), nVar.f2089k);
        nVar.f2084f.a(hVar);
        return hVar;
    }
}
