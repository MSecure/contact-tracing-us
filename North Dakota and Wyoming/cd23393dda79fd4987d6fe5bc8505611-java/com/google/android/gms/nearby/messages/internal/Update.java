package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzkn;
import com.google.android.gms.internal.nearby.zzko;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new zzci();
    public final Message zza;
    public final zzf zzb;
    public final zza zzc;
    public final zzkn zzd;
    private final int zze;
    private final int zzf;
    private final byte[] zzg;

    Update(int i, int i2, Message message, zzf zzf2, zza zza2, zzkn zzkn, byte[] bArr) {
        this.zze = i;
        if (zza(i2, 2)) {
            i2 = 2;
            zzf2 = null;
            zza2 = null;
            zzkn = null;
            bArr = null;
        }
        this.zzf = i2;
        this.zza = message;
        this.zzb = zzf2;
        this.zzc = zza2;
        this.zzd = zzkn;
        this.zzg = bArr;
    }

    private static boolean zza(int i, int i2) {
        return (i & i2) != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zze);
        SafeParcelWriter.writeInt(parcel, 2, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzd, i, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza(int i) {
        return zza(this.zzf, i);
    }

    public String toString() {
        ArraySet arraySet = new ArraySet();
        if (zza(1)) {
            arraySet.add("FOUND");
        }
        if (zza(2)) {
            arraySet.add("LOST");
        }
        if (zza(4)) {
            arraySet.add("DISTANCE");
        }
        if (zza(8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (zza(16)) {
            arraySet.add("DEVICE");
        }
        if (zza(32)) {
            arraySet.add("BLE_RECORD");
        }
        String valueOf = String.valueOf(arraySet);
        String valueOf2 = String.valueOf(this.zza);
        String valueOf3 = String.valueOf(this.zzb);
        String valueOf4 = String.valueOf(this.zzc);
        String valueOf5 = String.valueOf(this.zzd);
        String valueOf6 = String.valueOf(zzko.zza(this.zzg));
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 68 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length());
        sb.append("Update{types=");
        sb.append(valueOf);
        sb.append(", message=");
        sb.append(valueOf2);
        sb.append(", distance=");
        sb.append(valueOf3);
        sb.append(", bleSignal=");
        sb.append(valueOf4);
        sb.append(", device=");
        sb.append(valueOf5);
        sb.append(", bleRecord=");
        sb.append(valueOf6);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.zzf == update.zzf && Objects.equal(this.zza, update.zza) && Objects.equal(this.zzb, update.zzb) && Objects.equal(this.zzc, update.zzc) && Objects.equal(this.zzd, update.zzd) && Arrays.equals(this.zzg, update.zzg);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzf), this.zza, this.zzb, this.zzc, this.zzd, this.zzg);
    }
}
