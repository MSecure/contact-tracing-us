package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzkn;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    private static final zzkn[] zza = {zzkn.zza};
    private final int zzb;
    private final byte[] zzc;
    private final String zzd;
    private final String zze;
    @Deprecated
    private final zzkn[] zzf;
    private final long zzg;

    Message(int i, byte[] bArr, String str, String str2, zzkn[] zzknArr, long j) {
        this.zzb = i;
        this.zzd = (String) Preconditions.checkNotNull(str2);
        this.zze = str == null ? "" : str;
        this.zzg = j;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf((int) MAX_CONTENT_SIZE_BYTES));
        this.zzc = bArr;
        this.zzf = (zzknArr == null || zzknArr.length == 0) ? zza : zzknArr;
        Preconditions.checkArgument(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public final boolean zza(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }

    public Message(byte[] bArr) {
        this(bArr, "", "");
    }

    public Message(byte[] bArr, String str) {
        this(bArr, "", str);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, zza);
    }

    private Message(byte[] bArr, String str, String str2, zzkn[] zzknArr) {
        this(bArr, str, str2, zzknArr, 0);
    }

    private Message(byte[] bArr, String str, String str2, zzkn[] zzknArr, long j) {
        this(2, bArr, str, str2, zzknArr, 0);
    }

    public String getType() {
        return this.zzd;
    }

    public String getNamespace() {
        return this.zze;
    }

    public byte[] getContent() {
        return this.zzc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getContent(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeString(parcel, 3, getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzf, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzg);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public int hashCode() {
        return Objects.hashCode(this.zze, this.zzd, Integer.valueOf(Arrays.hashCode(this.zzc)), Long.valueOf(this.zzg));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.zze, message.zze) && TextUtils.equals(this.zzd, message.zzd) && Arrays.equals(this.zzc, message.zzc) && this.zzg == message.zzg;
    }

    public String toString() {
        String str = this.zze;
        String str2 = this.zzd;
        byte[] bArr = this.zzc;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59 + String.valueOf(str2).length());
        sb.append("Message{namespace='");
        sb.append(str);
        sb.append("', type='");
        sb.append(str2);
        sb.append("', content=[");
        sb.append(length);
        sb.append(" bytes]}");
        return sb.toString();
    }
}
