package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzk extends zzb {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzk(byte[] bArr) {
        super(bArr);
        Preconditions.checkArgument(bArr.length == 16 || bArr.length == 18 || bArr.length == 20, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public zzk(UUID uuid, Short sh, Short sh2) {
        this(r0.array());
        ByteBuffer allocate = ByteBuffer.allocate((sh == null ? 0 : 2) + 16 + (sh2 != null ? 2 : 0));
        allocate.putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits());
        if (sh != null) {
            allocate.putShort(sh.shortValue());
        }
        if (sh2 != null) {
            allocate.putShort(sh2.shortValue());
        }
    }

    public final UUID zzc() {
        ByteBuffer wrap = ByteBuffer.wrap(zza());
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public final Short zzd() {
        byte[] zza = zza();
        if (zza.length >= 18) {
            return Short.valueOf(ByteBuffer.wrap(zza).getShort(16));
        }
        return null;
    }

    public final Short zze() {
        byte[] zza = zza();
        if (zza.length == 20) {
            return Short.valueOf(ByteBuffer.wrap(zza).getShort(18));
        }
        return null;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzb
    public final String toString() {
        String valueOf = String.valueOf(zzc());
        String valueOf2 = String.valueOf(zzd());
        String valueOf3 = String.valueOf(zze());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("IBeaconIdPrefix{proximityUuid=");
        sb.append(valueOf);
        sb.append(", major=");
        sb.append(valueOf2);
        sb.append(", minor=");
        sb.append(valueOf3);
        sb.append('}');
        return sb.toString();
    }
}
