package com.google.android.gms.common;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zza;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public abstract class zzd extends zza implements zzm {
    public int zza;

    public zzd(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        ReactYogaConfigProvider.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    public boolean equals(Object obj) {
        IObjectWrapper zzb;
        if (obj != null && (obj instanceof zzm)) {
            try {
                zzm zzm = (zzm) obj;
                if (zzm.zzc() == this.zza && (zzb = zzm.zzb()) != null) {
                    return Arrays.equals(zza(), (byte[]) ObjectWrapper.unwrap(zzb));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.common.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            IObjectWrapper zzb = zzb();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzd.zza(parcel2, zzb);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(zzc);
            return true;
        }
    }

    public abstract byte[] zza();

    @Override // com.google.android.gms.common.internal.zzm
    public final IObjectWrapper zzb() {
        return new ObjectWrapper(zza());
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final int zzc() {
        return this.zza;
    }

    public static byte[] zza(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
