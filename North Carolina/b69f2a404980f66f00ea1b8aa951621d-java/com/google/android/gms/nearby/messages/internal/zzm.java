package com.google.android.gms.nearby.messages.internal;

import b.b.k.i;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class zzm extends zzc {
    /* JADX WARNING: Illegal instructions before constructor call */
    public zzm(UUID uuid, Short sh, Short sh2) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzm(byte[] bArr) {
        super(bArr);
        i.j.k(bArr.length == 16 || bArr.length == 18 || bArr.length == 20, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String valueOf = String.valueOf(zzc());
        String valueOf2 = String.valueOf(zzd());
        String valueOf3 = String.valueOf(zze());
        StringBuilder sb = new StringBuilder(valueOf3.length() + valueOf2.length() + valueOf.length() + 47);
        sb.append("IBeaconIdPrefix{proximityUuid=");
        sb.append(valueOf);
        sb.append(", major=");
        sb.append(valueOf2);
        sb.append(", minor=");
        sb.append(valueOf3);
        sb.append('}');
        return sb.toString();
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
}
