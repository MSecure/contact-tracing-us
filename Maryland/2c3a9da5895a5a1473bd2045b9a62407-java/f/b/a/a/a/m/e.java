package f.b.a.a.a.m;

import android.net.Uri;
import e.f.a.b;
import f.a.b.p;

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
        byte[] bArr = (byte[]) obj;
        String str = "Keyfile " + uri + " successfully downloaded " + bArr.length + " bytes.";
        this.b.a(bArr);
    }
}
