package c.b.a.a.g.e;

import com.google.android.gms.nearby.messages.StatusCallback;

public final class ja extends ha<StatusCallback> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3618a;

    public ja(boolean z) {
        this.f3618a = z;
    }

    @Override // c.b.a.a.d.k.o.k.b
    public final /* synthetic */ void notifyListener(Object obj) {
        ((StatusCallback) obj).onPermissionChanged(this.f3618a);
    }
}
