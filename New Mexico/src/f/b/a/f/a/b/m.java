package f.b.a.f.a.b;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class m extends k<ParcelFileDescriptor> {
    public m(s sVar, n<ParcelFileDescriptor> nVar) {
        super(sVar, nVar);
    }

    @Override // f.b.a.f.a.b.k, f.b.a.f.a.e.h0
    public final void h(Bundle bundle, Bundle bundle2) {
        this.b.f3289d.c(this.a);
        s.f3287g.d("onGetChunkFileDescriptor", new Object[0]);
        this.a.b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
