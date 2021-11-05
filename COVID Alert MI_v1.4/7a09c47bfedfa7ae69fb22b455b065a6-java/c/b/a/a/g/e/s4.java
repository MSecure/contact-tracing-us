package c.b.a.a.g.e;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

public final class s4 implements Connections.StartAdvertisingResult {

    /* renamed from: b  reason: collision with root package name */
    public final Status f3707b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3708c;

    public s4(Status status, String str) {
        this.f3707b = status;
        this.f3708c = str;
    }

    @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    public final String getLocalEndpointName() {
        return this.f3708c;
    }

    @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult, c.b.a.a.d.k.i
    public final Status getStatus() {
        return this.f3707b;
    }
}
