package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import c.b.a.a.e.c.y9;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public class Message extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    public static final y9[] zza = {y9.f2814e};
    public final int zzb;
    public final byte[] zzc;
    public final String zzd;
    public final String zze;
    @Deprecated
    public final y9[] zzf;
    public final long zzg;

    public Message(int i, byte[] bArr, String str, String str2, y9[] y9VarArr, long j) {
        this.zzb = i;
        i.j.s(str2);
        this.zzd = str2;
        this.zze = str == null ? "" : str;
        this.zzg = j;
        i.j.s(bArr);
        i.j.j(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf((int) MAX_CONTENT_SIZE_BYTES));
        this.zzc = bArr;
        this.zzf = (y9VarArr == null || y9VarArr.length == 0) ? zza : y9VarArr;
        i.j.j(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
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

    public Message(byte[] bArr, String str, String str2, y9[] y9VarArr) {
        this(bArr, str, str2, y9VarArr, 0);
    }

    public Message(byte[] bArr, String str, String str2, y9[] y9VarArr, long j) {
        this(2, bArr, str, str2, y9VarArr, 0);
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

    public byte[] getContent() {
        return this.zzc;
    }

    public String getNamespace() {
        return this.zze;
    }

    public String getType() {
        return this.zzd;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zze, this.zzd, Integer.valueOf(Arrays.hashCode(this.zzc)), Long.valueOf(this.zzg)});
    }

    public String toString() {
        String str = this.zze;
        String str2 = this.zzd;
        byte[] bArr = this.zzc;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 59);
        sb.append("Message{namespace='");
        sb.append(str);
        sb.append("', type='");
        sb.append(str2);
        sb.append("', content=[");
        sb.append(length);
        sb.append(" bytes]}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.q1(parcel, 1, getContent(), false);
        i.j.z1(parcel, 2, getType(), false);
        i.j.z1(parcel, 3, getNamespace(), false);
        i.j.A1(parcel, 4, this.zzf, i, false);
        i.j.x1(parcel, 5, this.zzg);
        i.j.u1(parcel, 1000, this.zzb);
        i.j.F1(parcel, e2);
    }

    public final boolean zza(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }
}
