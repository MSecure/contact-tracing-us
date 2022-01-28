package com.google.android.gms.nearby.connection;

import b.b.k.i;
import c.b.a.a.c.k.a;
import java.util.Arrays;

public class ConnectionsOptions implements a.d {
    public final String zza;

    public static class Builder {
        public ConnectionsOptions build() {
            return new ConnectionsOptions(this);
        }
    }

    public ConnectionsOptions(Builder builder) {
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
        return i.j.X(null, null);
    }

    public String getZeroPartyIdentifier() {
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{null});
    }
}
