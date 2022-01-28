package c.b.a.a.g.e;

import android.os.ParcelFileDescriptor;
import b.x.t;
import c.b.a.a.d.k.o.h;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.List;

public final class v extends h.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f3767a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f3768b;

    public v(List list, j jVar) {
        this.f3767a = list;
        this.f3768b = jVar;
    }

    @Override // c.b.a.a.d.k.o.h
    public final void i(Status status) {
        for (ParcelFileDescriptor parcelFileDescriptor : this.f3767a) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
        t.L2(status, null, this.f3768b);
    }
}
