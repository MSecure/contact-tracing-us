package f.b.a.a.a.n;

import android.net.Uri;
import e.f.a.b;
import f.a.b.p;
import f.b.a.a.a.i.e0.a;

public final /* synthetic */ class e implements p.b {
    public final /* synthetic */ Uri a;
    public final /* synthetic */ b b;

    public /* synthetic */ e(Uri uri, b bVar) {
        this.a = uri;
        this.b = bVar;
    }

    @Override // f.a.b.p.b
    public final void a(Object obj) {
        Uri uri = this.a;
        b bVar = this.b;
        byte[] bArr = (byte[]) obj;
        a aVar = n.m;
        aVar.a("Keyfile " + uri + " successfully downloaded " + bArr.length + " bytes.");
        bVar.a(bArr);
    }
}
