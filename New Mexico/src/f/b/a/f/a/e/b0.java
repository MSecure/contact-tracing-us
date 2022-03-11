package f.b.a.f.a.e;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import f.b.a.f.a.a.n;
import f.b.a.f.a.a.o;
import f.b.a.f.a.a.q;
import f.b.a.f.a.d.a;
import java.io.File;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class b0 extends w implements c0 {
    public b0() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // f.b.a.f.a.e.w
    public final boolean p(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 2) {
            Bundle bundle = (Bundle) x.a(parcel, Bundle.CREATOR);
            n nVar = (n) this;
            nVar.c.a.c(nVar.b);
            nVar.a.d("onRequestInfo", new Object[0]);
            if (bundle.getInt("error.code", -2) != 0) {
                nVar.b.a(new a(bundle.getInt("error.code", -2)));
                return true;
            }
            f.b.a.f.a.h.n<T> nVar2 = nVar.b;
            o oVar = nVar.f3171e;
            String str = nVar.f3170d;
            int i4 = bundle.getInt("version.code", -1);
            int i5 = bundle.getInt("update.availability");
            int i6 = bundle.getInt("install.status", 0);
            Integer valueOf = bundle.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle.getInt("client.version.staleness"));
            int i7 = bundle.getInt("in.app.update.priority", 0);
            long j2 = bundle.getLong("bytes.downloaded");
            long j3 = bundle.getLong("total.bytes.to.download");
            long j4 = bundle.getLong("additional.size.required");
            q qVar = oVar.f3174d;
            Objects.requireNonNull(qVar);
            nVar2.b(new f.b.a.f.a.a.a(str, i4, i5, i6, valueOf, i7, j2, j3, j4, q.a(new File(qVar.a.getFilesDir(), "assetpacks")), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"), (PendingIntent) bundle.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent")));
            return true;
        } else if (i2 != 3) {
            return false;
        } else {
            Bundle bundle2 = (Bundle) x.a(parcel, Bundle.CREATOR);
            n nVar3 = (n) this;
            nVar3.c.a.c(nVar3.b);
            nVar3.a.d("onCompleteUpdate", new Object[0]);
            return true;
        }
    }
}
