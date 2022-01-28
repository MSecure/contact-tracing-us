package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.e.c;
import b.x.t;
import c.b.a.a.d.m.o.a;
import c.b.a.a.g.e.v9;
import c.b.a.a.g.e.y9;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

public class Update extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new zzci();
    public final Message zza;
    public final zzd zzb;
    public final zzb zzc;
    public final y9 zzd;
    public final int zze;
    public final int zzf;
    public final byte[] zzg;

    public Update(int i, int i2, Message message, zzd zzd2, zzb zzb2, y9 y9Var, byte[] bArr) {
        this.zze = i;
        if (zza(i2, 2)) {
            i2 = 2;
            zzd2 = null;
            zzb2 = null;
            y9Var = null;
            bArr = null;
        }
        this.zzf = i2;
        this.zza = message;
        this.zzb = zzd2;
        this.zzc = zzb2;
        this.zzd = y9Var;
        this.zzg = bArr;
    }

    public static boolean zza(int i, int i2) {
        return (i & i2) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.zzf == update.zzf && t.j1(this.zza, update.zza) && t.j1(this.zzb, update.zzb) && t.j1(this.zzc, update.zzc) && t.j1(this.zzd, update.zzd) && Arrays.equals(this.zzg, update.zzg);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzf), this.zza, this.zzb, this.zzc, this.zzd, this.zzg});
    }

    public String toString() {
        c cVar = new c();
        if (zza(1)) {
            cVar.add("FOUND");
        }
        if (zza(2)) {
            cVar.add("LOST");
        }
        if (zza(4)) {
            cVar.add("DISTANCE");
        }
        if (zza(8)) {
            cVar.add("BLE_SIGNAL");
        }
        if (zza(16)) {
            cVar.add("DEVICE");
        }
        if (zza(32)) {
            cVar.add("BLE_RECORD");
        }
        String valueOf = String.valueOf(cVar);
        String valueOf2 = String.valueOf(this.zza);
        String valueOf3 = String.valueOf(this.zzb);
        String valueOf4 = String.valueOf(this.zzc);
        String valueOf5 = String.valueOf(this.zzd);
        String valueOf6 = String.valueOf(v9.b(this.zzg));
        StringBuilder sb = new StringBuilder(valueOf6.length() + valueOf5.length() + valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 68);
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

    public void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.zze);
        t.q3(parcel, 2, this.zzf);
        t.v3(parcel, 3, this.zza, i, false);
        t.v3(parcel, 4, this.zzb, i, false);
        t.v3(parcel, 5, this.zzc, i, false);
        t.v3(parcel, 6, this.zzd, i, false);
        t.l3(parcel, 7, this.zzg, false);
        t.w4(parcel, m);
    }

    public final boolean zza(int i) {
        return zza(this.zzf, i);
    }
}
