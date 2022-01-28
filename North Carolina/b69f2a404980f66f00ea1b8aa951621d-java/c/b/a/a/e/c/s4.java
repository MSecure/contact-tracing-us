package c.b.a.a.e.c;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

public final class s4 implements Connections.StartAdvertisingResult {

    /* renamed from: b  reason: collision with root package name */
    public final Status f2713b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2714c;

    public s4(Status status, String str) {
        this.f2713b = status;
        this.f2714c = str;
    }

    @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    public final String getLocalEndpointName() {
        return this.f2714c;
    }

    @Override // c.b.a.a.c.k.i, com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    public final Status getStatus() {
        return this.f2713b;
    }
}
