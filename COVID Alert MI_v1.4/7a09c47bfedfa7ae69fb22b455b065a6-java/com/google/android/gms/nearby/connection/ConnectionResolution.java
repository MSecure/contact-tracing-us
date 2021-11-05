package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Status;

public final class ConnectionResolution {
    public final Status zza;

    @Deprecated
    public ConnectionResolution(Status status) {
        this.zza = status;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
