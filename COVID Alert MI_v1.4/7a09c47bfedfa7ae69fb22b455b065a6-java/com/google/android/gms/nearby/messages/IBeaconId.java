package com.google.android.gms.nearby.messages;

import b.x.t;
import com.google.android.gms.nearby.messages.internal.zzm;
import java.util.Arrays;
import java.util.UUID;

public class IBeaconId {
    public static final int LENGTH = 20;
    public final zzm zza;

    public IBeaconId(UUID uuid, short s, short s2) {
        this.zza = new zzm(uuid, Short.valueOf(s), Short.valueOf(s2));
    }

    public IBeaconId(byte[] bArr) {
        t.r(bArr.length == 20, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        this.zza = new zzm(bArr);
    }

    public static IBeaconId from(Message message) {
        boolean zza2 = message.zza(Message.MESSAGE_TYPE_I_BEACON_ID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 55);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_I_BEACON_ID");
        t.r(zza2, sb.toString());
        return new IBeaconId(message.getContent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IBeaconId)) {
            return false;
        }
        return t.j1(this.zza, ((IBeaconId) obj).zza);
    }

    public short getMajor() {
        return this.zza.zzd().shortValue();
    }

    public short getMinor() {
        return this.zza.zze().shortValue();
    }

    public UUID getProximityUuid() {
        return this.zza.zzc();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        short major = getMajor();
        short minor = getMinor();
        StringBuilder sb = new StringBuilder(valueOf.length() + 53);
        sb.append("IBeaconId{proximityUuid=");
        sb.append(valueOf);
        sb.append(", major=");
        sb.append((int) major);
        sb.append(", minor=");
        sb.append((int) minor);
        sb.append('}');
        return sb.toString();
    }
}
