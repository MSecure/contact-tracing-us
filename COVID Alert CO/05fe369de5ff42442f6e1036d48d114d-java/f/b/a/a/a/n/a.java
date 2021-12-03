package f.b.a.a.a.n;

import android.net.Uri;
import e.f.a.b;
import e.f.a.d;
import f.b.a.a.a.r.h;
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
        e eVar = new e(uri, bVar);
        d dVar = new d(uri, bVar);
        f.b.a.a.a.i.e0.a aVar = n.m;
        aVar.a("Downloading keyfile file from " + uri);
        h hVar = new h(uri, eVar, dVar, nVar.f2263k);
        nVar.f2258f.a(hVar);
        return hVar;
    }
}
