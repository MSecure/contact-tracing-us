package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.internal.zzk;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class IBeaconId {
    public static final int LENGTH = 20;
    private final zzk zza;

    private IBeaconId(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 20, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        this.zza = new zzk(bArr);
    }

    public IBeaconId(UUID uuid, short s, short s2) {
        this.zza = new zzk(uuid, Short.valueOf(s), Short.valueOf(s2));
    }

    public static IBeaconId from(Message message) {
        boolean zza2 = message.zza(Message.MESSAGE_TYPE_I_BEACON_ID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 55);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_I_BEACON_ID");
        Preconditions.checkArgument(zza2, sb.toString());
        return new IBeaconId(message.getContent());
    }

    public UUID getProximityUuid() {
        return this.zza.zzc();
    }

    public short getMajor() {
        return this.zza.zzd().shortValue();
    }

    public short getMinor() {
        return this.zza.zze().shortValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IBeaconId)) {
            return false;
        }
        return Objects.equal(this.zza, ((IBeaconId) obj).zza);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        short major = getMajor();
        short minor = getMinor();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
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
