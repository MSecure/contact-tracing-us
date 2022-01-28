package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class ConnectionsOptions implements Api.ApiOptions.Optional {
    private final String zza;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Builder {
        public ConnectionsOptions build() {
            return new ConnectionsOptions(this);
        }
    }

    public String getZeroPartyIdentifier() {
        return null;
    }

    private ConnectionsOptions(Builder builder) {
        this.zza = null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionsOptions)) {
            return false;
        }
        ConnectionsOptions connectionsOptions = (ConnectionsOptions) obj;
        return Objects.equal(null, null);
    }

    public int hashCode() {
        return Objects.hashCode(null);
    }
}
