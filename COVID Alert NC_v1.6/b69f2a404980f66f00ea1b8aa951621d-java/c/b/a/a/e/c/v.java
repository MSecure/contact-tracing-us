package c.b.a.a.e.c;

import android.os.ParcelFileDescriptor;
import b.b.k.i;
import c.b.a.a.c.k.o.h;
import c.b.a.a.g.i;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.List;

public final class v extends h.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f2765a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f2766b;

    public v(List list, i iVar) {
        this.f2765a = list;
        this.f2766b = iVar;
    }

    @Override // c.b.a.a.c.k.o.h
    public final void l(Status status) {
        for (ParcelFileDescriptor parcelFileDescriptor : this.f2765a) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
        i.j.a1(status, null, this.f2766b);
    }
}
