package f.b.a.a.a.m;

import android.net.Uri;
import android.util.Log;
import e.f.a.b;
import f.a.b.p;
import f.a.b.u;

public final /* synthetic */ class d implements p.a {
    public final /* synthetic */ Uri a;
    public final /* synthetic */ b b;

    public /* synthetic */ d(Uri uri, b bVar) {
        this.a = uri;
        this.b = bVar;
    }

    @Override // f.a.b.p.a
    public final void a(u uVar) {
        Uri uri = this.a;
        b bVar = this.b;
        Log.e("KeyDownloader", "Error getting keyfile " + uri);
        bVar.c(uVar);
    }
}
