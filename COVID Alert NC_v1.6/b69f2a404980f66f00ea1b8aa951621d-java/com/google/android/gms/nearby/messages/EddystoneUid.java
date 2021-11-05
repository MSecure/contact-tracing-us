package com.google.android.gms.nearby.messages;

import b.b.k.i;
import com.google.android.gms.nearby.messages.internal.zzc;
import com.google.android.gms.nearby.messages.internal.zzf;
import java.util.Arrays;

public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;
    public final zzf zza;

    public EddystoneUid(String str) {
        this(zzc.zza(str));
    }

    public EddystoneUid(String str, String str2) {
        this.zza = new zzf(str, str2);
    }

    public EddystoneUid(byte[] bArr) {
        i.j.k(bArr.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        this.zza = new zzf(bArr);
    }

    public static EddystoneUid from(Message message) {
        boolean zza2 = message.zza(Message.MESSAGE_TYPE_EDDYSTONE_UID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 58);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.");
        i.j.k(zza2, sb.toString());
        return new EddystoneUid(message.getContent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EddystoneUid)) {
            return false;
        }
        return i.j.X(this.zza, ((EddystoneUid) obj).zza);
    }

    public String getHex() {
        return this.zza.zzb();
    }

    public String getInstance() {
        byte[] zza2 = this.zza.zza();
        if (zza2.length < 16) {
            return null;
        }
        return zzc.zza(Arrays.copyOfRange(zza2, 10, 16));
    }

    public String getNamespace() {
        return zzc.zza(Arrays.copyOfRange(this.zza.zza(), 0, 10));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public String toString() {
        String hex = getHex();
        StringBuilder sb = new StringBuilder(String.valueOf(hex).length() + 17);
        sb.append("EddystoneUid{id=");
        sb.append(hex);
        sb.append('}');
        return sb.toString();
    }
}
