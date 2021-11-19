package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.internal.zzb;
import com.google.android.gms.nearby.messages.internal.zzh;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;
    private final zzh zza;

    private EddystoneUid(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        this.zza = new zzh(bArr);
    }

    public EddystoneUid(String str) {
        this(zzb.zza(str));
    }

    public EddystoneUid(String str, String str2) {
        this.zza = new zzh(str, str2);
    }

    public static EddystoneUid from(Message message) {
        boolean zza2 = message.zza(Message.MESSAGE_TYPE_EDDYSTONE_UID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 58);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.");
        Preconditions.checkArgument(zza2, sb.toString());
        return new EddystoneUid(message.getContent());
    }

    public String getNamespace() {
        return zzb.zza(Arrays.copyOfRange(this.zza.zza(), 0, 10));
    }

    public String getInstance() {
        byte[] zza2 = this.zza.zza();
        if (zza2.length < 16) {
            return null;
        }
        return zzb.zza(Arrays.copyOfRange(zza2, 10, 16));
    }

    public String getHex() {
        return this.zza.zzb();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EddystoneUid)) {
            return false;
        }
        return Objects.equal(this.zza, ((EddystoneUid) obj).zza);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
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
