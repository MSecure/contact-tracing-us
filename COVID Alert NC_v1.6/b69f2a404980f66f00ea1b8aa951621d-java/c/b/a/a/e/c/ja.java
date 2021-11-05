package c.b.a.a.e.c;

import com.google.android.gms.nearby.messages.StatusCallback;

public final class ja extends ha<StatusCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2630a;

    public ja(boolean z) {
        this.f2630a = z;
    }

    @Override // c.b.a.a.c.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((StatusCallback) obj).onPermissionChanged(this.f2630a);
    }
}
