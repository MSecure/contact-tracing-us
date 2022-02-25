package f.b.a.c.e.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.i.i;
import java.io.IOException;
import java.util.List;

public final class s extends f.a {
    public final /* synthetic */ List a;
    public final /* synthetic */ i b;

    public s(List list, i iVar) {
        this.a = list;
        this.b = iVar;
    }

    @Override // f.b.a.c.b.l.l.f
    public final void f(Status status) {
        for (ParcelFileDescriptor parcelFileDescriptor : this.a) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e2) {
                Log.w("ExposureNotification", "Failed to close file", e2);
            }
        }
        m.h.r1(status, null, this.b);
    }
}
