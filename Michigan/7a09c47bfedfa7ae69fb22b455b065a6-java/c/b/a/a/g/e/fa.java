package c.b.a.a.g.e;

import android.util.Log;
import c.b.a.a.d.k.o.e;
import c.b.a.a.d.k.o.k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.internal.zzp;

public final class fa extends zzp {

    /* renamed from: a  reason: collision with root package name */
    public final k<e<Status>> f3568a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3569b = false;

    public fa(k<e<Status>> kVar) {
        this.f3568a = kVar;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzq
    public final synchronized void zza(Status status) {
        if (!this.f3569b) {
            this.f3568a.a(new ea(status));
            this.f3569b = true;
            return;
        }
        String valueOf = String.valueOf(status);
        StringBuilder sb = new StringBuilder(valueOf.length() + 28);
        sb.append("Received multiple statuses: ");
        sb.append(valueOf);
        Log.wtf("NearbyMessagesCallbackWrapper", sb.toString(), new Exception());
    }
}
