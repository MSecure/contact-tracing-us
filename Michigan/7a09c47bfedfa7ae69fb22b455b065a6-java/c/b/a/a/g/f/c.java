package c.b.a.a.g.f;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.b.a.a.d.k.e;
import c.b.a.a.d.m.f;

public final class c extends f<a> {
    public c(Context context, Looper looper, c.b.a.a.d.m.c cVar, e.a aVar, e.b bVar) {
        super(context, looper, 51, cVar, aVar, bVar);
    }

    @Override // c.b.a.a.d.m.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.phenotype.internal.IPhenotypeService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new b(iBinder);
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final int getMinApkVersion() {
        return 11925000;
    }

    @Override // c.b.a.a.d.m.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.phenotype.internal.IPhenotypeService";
    }

    @Override // c.b.a.a.d.m.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.phenotype.service.START";
    }
}
