package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.common.zzd;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public interface IGmsCallbacks extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public static abstract class zza extends com.google.android.gms.internal.common.zza implements IGmsCallbacks {
        public zza() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.google.android.gms.internal.common.zza
        public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                ((BaseGmsClient.zze) this).onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                parcel.readInt();
                Bundle bundle = (Bundle) zzd.zza(parcel, Bundle.CREATOR);
                Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            } else if (i != 3) {
                return false;
            } else {
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                zzc zzc = (zzc) zzd.zza(parcel, zzc.CREATOR);
                BaseGmsClient.zze zze = (BaseGmsClient.zze) this;
                BaseGmsClient baseGmsClient = zze.zza;
                ReactYogaConfigProvider.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
                ReactYogaConfigProvider.checkNotNull(zzc);
                baseGmsClient.zzac = zzc;
                zze.onPostInitComplete(readInt, readStrongBinder, zzc.zza);
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
