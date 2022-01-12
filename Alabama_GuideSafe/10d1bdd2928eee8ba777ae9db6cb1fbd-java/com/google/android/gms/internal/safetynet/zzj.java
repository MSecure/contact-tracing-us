package com.google.android.gms.internal.safetynet;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzj implements zzi, IInterface {
    public final IBinder zza;
    public final String zzb = "com.google.android.gms.safetynet.internal.ISafetyNetService";

    public zzj(IBinder iBinder) {
        this.zza = iBinder;
    }

    public IBinder asBinder() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.safetynet.zzi
    public final void zza(zzg zzg, byte[] bArr, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        zzc.zza(obtain, zzg);
        obtain.writeByteArray(bArr);
        obtain.writeString(str);
        Parcel obtain2 = Parcel.obtain();
        try {
            this.zza.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
